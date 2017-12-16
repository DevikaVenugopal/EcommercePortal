package com.niit.babyCare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.babyCare.dao.categoryDao;

@Controller
public class homeController 
{

	@Autowired
	categoryDao categoryDao;
	
	@RequestMapping("/")
	public String index(Model m)
	{
		m.addAttribute("categoryList",categoryDao.retrieveCategory());
		return "Index";
	}
	@RequestMapping("/admin")
	public String indexA(Model m)
	{
		m.addAttribute("categoryList",categoryDao.retrieveCategory());
		return "Index";
	}
	@RequestMapping("/error")
	public String error(Model m)
	{
		m.addAttribute("categoryList",categoryDao.retrieveCategory());
		return "errorIn";
	}
	
	@RequestMapping("/Login")
	public String login(Model m)
	{
		m.addAttribute("categoryList",categoryDao.retrieveCategory());
		return "Login";
	}
	
	@RequestMapping("/Register")
	public String register(Model m)
	{
		m.addAttribute("categoryList",categoryDao.retrieveCategory());
		return "Register";
	}
	
	
	
}	



