package com.niit.babyCare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.niit.babyCare.dao.supplierDao;
import com.niit.babyCare.dao.categoryDao;
import com.niit.babyCare.model.Supplier;

import com.niit.babyCare.model.category;

@Controller
public class AdminController 
{
	@Autowired 
	categoryDao categoryDao;
	
	@Autowired 
	supplierDao supplierDao;
	
	@RequestMapping("/admin/adding")
	public ModelAndView adding()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Adding");
		mv.addObject("categoryList",categoryDao.retrieveCategory());
		mv.addObject("supplierList",supplierDao.retrieveSupplier());
		return mv;
		
	}
	@RequestMapping("/adding")
	public ModelAndView addingA()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/admin/adding");
		return mv;
		
	}
	
	

	
}
