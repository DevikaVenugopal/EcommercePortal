package com.niit.babyCare.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.babyCare.dao.categoryDao;
import com.niit.babyCare.dao.productDao;
import com.niit.babyCare.dao.supplierDao;
import com.niit.babyCare.model.Product;
import com.niit.babyCare.model.category;

@Controller
public class ProductController
{
	@Autowired
	productDao productDao;
	
	@Autowired
	categoryDao categoryDao;
	
	@Autowired
	supplierDao supplierDao;
	
	@RequestMapping(value="/admin/product",method=RequestMethod.GET)
	public String showProduct(@RequestParam("status")String status,Model m)
	{
		m.addAttribute("categoryList",categoryDao.retrieveCategory());
		m.addAttribute("status",status);
		m.addAttribute("supplierList",supplierDao.retrieveSupplier());
		List<Product> listProducts=productDao.retrieveProduct();
		m.addAttribute("productList",listProducts);
		return "Product";
	}
	
	@RequestMapping(value="/admin/InsertProduct", method=RequestMethod.POST)
	public String insertProduct(@RequestParam("productName")String productName,@RequestParam("productDesc")String productDesc,@RequestParam("productStock")int stock,@RequestParam("productPrice")int price,@RequestParam("pCat")int catId,@RequestParam("pSupplier")int supplierId,@RequestParam("file")MultipartFile fileDetail,Model m)
	{
		Product p=new Product();
		p.setProductName(productName);
		p.setProductDesc(productDesc);
		p.setPrice(price);
		p.setStock(stock);
		p.setCategory(categoryDao.getCategory(catId));
		p.setSupplier(supplierDao.getSupplier(supplierId));
		p.setPimage(fileDetail);
		
		productDao.addProduct(p);
		String path="C:\\devika\\babyCare\\src\\main\\webapp\\resources\\images\\";
		String totalFileWithPath=path+String.valueOf(p.getProductId())+".jpg";
		File productImage=new File(totalFileWithPath);
		if(!fileDetail.isEmpty())
		{
			try
			{
				byte fileBuffer[]=fileDetail.getBytes();
				FileOutputStream fos=new FileOutputStream(productImage);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("error",e.getMessage());
			}
		}
		else
		{
			m.addAttribute("error","Problem in file uploading");
		}
		Product product1=new Product();
		m.addAttribute(product1);
		 m.addAttribute("status","Product Added Successfully....");
		return "redirect:/admin/adding";
	}
	
	@RequestMapping(value="admin/productDesc/{productId}")
	public String showProductDesc(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDao.getProduct(productId);
		m.addAttribute("product",product);
		return "admin/productDesc";
	}
	
	@RequestMapping(value="admin/deleteProduct/{productId}",method=RequestMethod.GET)
    public String deleteProduct(@PathVariable("productId")int productId,Model m)
    {
        Product product=productDao.getProduct(productId);
        try
        {
        productDao.deleteProduct(product);
        m.addAttribute("status","Product Deleted Successfully....");
        }
        catch(Exception e)
        {
        	 m.addAttribute("status","Product Already in Cart ...You cant delete it..");
        }
        
        List<Product> listProduct=productDao.retrieveProduct();
        m.addAttribute("productList",listProduct);
         
        Product product1= new Product();
        m.addAttribute(product1);
         
        return "redirect:/admin/product";
    }
    
    @RequestMapping(value="/admin/updateP",method=RequestMethod.GET)
    public String updateCategory(@RequestParam("productId") int productId,Model m)
    {
    	Product product=productDao.getProduct(productId);
    	m.addAttribute("prod",product);
    	m.addAttribute("categoryList",categoryDao.retrieveCategory());
	    m.addAttribute("supplierList",supplierDao.retrieveSupplier());
    	
    	List<Product> listProduct=productDao.retrieveProduct();
	    m.addAttribute("productList",listProduct);
	    
	    return "UpdateProduct";
    }
    
    @RequestMapping(value="admin/updateProduct",method=RequestMethod.POST)
    public String newUpdateProd(@RequestParam("productId") int productId,@RequestParam("productName") String productName,@RequestParam("productDesc") String productDesc,@RequestParam("productStock") int stock,@RequestParam("pSupplier") int pSupplier,@RequestParam("pCat") int pCat,@RequestParam("productPrice") int price,@RequestParam("pimage")MultipartFile fileDetail,Model m)
    {
    	Product p=productDao.getProduct(productId);
    	p.setProductId(productId);
        p.setProductName(productName);
        p.setPrice(price);
        p.setProductDesc(productDesc);
        p.setStock(stock);
        p.setCategory(categoryDao.getCategory(pCat));
        p.setSupplier(supplierDao.getSupplier(pSupplier));
        p.setPimage(fileDetail);
        
        productDao.updateProduct(p);
        
   	    	
   	    	
   	    	
        String path="C:\\devika\\babyCare\\src\\main\\webapp\\resources\\images\\";
         
        String totalFileWithPath=path+String.valueOf(p.getProductId())+".jpg";
         
        File productImage=new File(totalFileWithPath);
         
        if(!fileDetail.isEmpty())
        {
            try
            {
                byte fileBuffer[]=fileDetail.getBytes();
                FileOutputStream fos=new FileOutputStream(productImage);
                BufferedOutputStream bs=new BufferedOutputStream(fos);
                bs.write(fileBuffer);
                bs.close();
            }
            catch(Exception e)
            {
                m.addAttribute("error",e.getMessage());
            }
        }
        else
        {
            m.addAttribute("error","Problem in File Uploading");
        }
         
        Product product1=new Product();
        m.addAttribute(product1);
        m.addAttribute("status","Product Updated Successfully....");
         
        return "redirect:/admin/product";
    }
    
    @RequestMapping(value="/productList",method=RequestMethod.GET)
    public String productListByCatId(@RequestParam("catId") int catId,Model m)
    {
    	m.addAttribute("categoryList",categoryDao.retrieveCategory());
    	
    	List<Product> listProduct=productDao.retrieveProductByCat(catId);
	    m.addAttribute("productList",listProduct);
	    
	    return "ProductList";
    }
    
    @RequestMapping(value="/productView",method=RequestMethod.GET)
    public String productView(@RequestParam("pid") int pid,@RequestParam("error") String error,Model m)
    {
    	m.addAttribute("categoryList",categoryDao.retrieveCategory());
    	
    	Product p=productDao.getProduct(pid);
	    m.addAttribute("product",p);
	    m.addAttribute("error", error);
	    
	    return "ProductView";
    }

}
