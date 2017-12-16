package com.niit.babyCare.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.babyCare.dao.categoryDao;
import com.niit.babyCare.model.category;

@Controller
public class CategoryController 
{
	@Autowired
	categoryDao categoryDao;
	
	@RequestMapping(value="/admin/AddCategory",method=RequestMethod.POST)
    public String addCategory(@RequestParam("catName") String catName,@RequestParam("catDesc") String catDesc,Model m)
    {
        category category=new category();
        
        category.setCatName(catName);
        category.setCatDesc(catDesc);
         
        categoryDao.addCategory(category);
         
        List<category> listCategory=categoryDao.retrieveCategory();
        m.addAttribute("categoryList",listCategory);
        m.addAttribute("status","Category Added Successfully....");
         
        return "Category";
    }
	
	@RequestMapping(value="/admin/category",method=RequestMethod.GET)
    public String showCategory(@RequestParam("status")String status,Model m)
    {
        category category=new category();
        m.addAttribute(category);
        m.addAttribute("status",status);
         
        List<category> listCategory=categoryDao.retrieveCategory();
        m.addAttribute("categoryList",listCategory);
        return "Category";
    }
	

     
	 
	@RequestMapping(value="/admin/deleteCategory/{catId}",method=RequestMethod.GET)
    public String deleteCategory(@PathVariable("catId")int catId,Model m)
    {
        category category=categoryDao.getCategory(catId);
        try
        {
        categoryDao.deleteCategory(category);
        m.addAttribute("status","Category Deleted Successfully....");
        }
        catch (Exception e) 
        {
        	m.addAttribute("status","Category Already in Product ...You cant delete it..");
		}
       
        return "redirect:/admin/category";
    }
     
	 @RequestMapping(value="/admin/updateC",method=RequestMethod.GET)
     public String updateCategory(@RequestParam("catId") int catId,Model m)
     {
         category category=categoryDao.getCategory(catId);
         m.addAttribute("cat",category);
          
         List<category> listCategory=categoryDao.retrieveCategory();
         m.addAttribute("categoryList",listCategory);
         return "updateCategory";
     }
	 
	 @RequestMapping(value="/admin/UpdateCategory",method=RequestMethod.POST)
	 public String updateCategory(@RequestParam("catId") int catId,@RequestParam("catName") String catName,@RequestParam("catDesc") String catDesc,Model m)
	 {
		category category=categoryDao.getCategory(catId);
		category.setCatName(catName);
		category.setCatDesc(catDesc);
		
		categoryDao.updateCategory(category);
		List<category> listCategory=categoryDao.retrieveCategory();
        m.addAttribute("categoryList",listCategory);
        m.addAttribute("status","Category Updated Successfully....");
        return "redirect:/admin/category";
	 }
      
      
}
