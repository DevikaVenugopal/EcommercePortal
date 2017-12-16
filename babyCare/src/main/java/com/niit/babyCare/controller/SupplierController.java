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

import com.niit.babyCare.dao.supplierDao;
import com.niit.babyCare.model.Supplier;
import com.niit.babyCare.model.category;

@Controller
public class SupplierController 
{
	@Autowired
	supplierDao supplierDao;
	
	@RequestMapping(value="/admin/AddSupplier",method=RequestMethod.POST)
    public String addSupplier(@RequestParam("supplierName") String supplierName,@RequestParam("supplierAddress") String supplierAddress,Model m)
    {
        Supplier supplier=new Supplier();
        
        supplier.setSupplierName(supplierName);
        supplier.setSupplierAddress(supplierAddress);
         
        supplierDao.addSupplier(supplier);
         
        List<Supplier> listSupplier=supplierDao.retrieveSupplier();
        m.addAttribute("supplierList",listSupplier);
        m.addAttribute("status","Supplier Added Successfully....");
        return "redirect:/admin/supplier";
    }

	@RequestMapping(value="/admin/supplier",method=RequestMethod.GET)
    public String showSupplier(@RequestParam("status")String status,Model m)
    {
		m.addAttribute("status",status);
        List<Supplier> listSupplier=supplierDao.retrieveSupplier();
        m.addAttribute("supplierList",listSupplier);
        return "Supplier";
    }
     
	 @RequestMapping(value="/admin/deleteSupplier/{supplierId}",method=RequestMethod.GET)
     public String deleteSupplier(@PathVariable("supplierId")int supplierId,Model m)
     {
         Supplier supplier=supplierDao.getSupplier(supplierId);
         try
         {
         supplierDao.deleteSupplier(supplier);
         m.addAttribute("status","Supplier Deleted Successfully....");
         }
         catch(Exception e)
         {
        	 m.addAttribute("status","Supplier Already in Product....You cant delete it..");
         }
         List<Supplier> listSupplier=supplierDao.retrieveSupplier();
         m.addAttribute("supplierList",listSupplier);
         
         Supplier supplier1=new Supplier();
         m.addAttribute(supplier1);
         return "redirect:/admin/supplier";
     }
	 
	 @RequestMapping(value="/admin/updateS",method=RequestMethod.GET)
     public String updateSupplier(@RequestParam("supplierId") int supplierId,Model m)
     {
         Supplier supplier=supplierDao.getSupplier(supplierId);
         m.addAttribute("sup",supplier);
          
         List<Supplier> listSupplier=supplierDao.retrieveSupplier();
         m.addAttribute("supplierList",listSupplier);
         return "updateSupplier";
     }
      
	 @RequestMapping(value="/admin/UpdateSupplier",method=RequestMethod.POST)
	 public String updateSupplier(@RequestParam("supplierId") int supplierId,@RequestParam("supplierName") String supplierName,@RequestParam("supplierAddress") String supplierAddress,Model m)
	 {
	    Supplier supplier=supplierDao.getSupplier(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddress(supplierAddress);
		
		supplierDao.updateSupplier(supplier);
		List<Supplier> listSupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		 m.addAttribute("status","Supplier Updated Successfully....");
		return "redirect:/admin/supplier";
	 }
}
