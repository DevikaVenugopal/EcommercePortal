package com.niit.babyCare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.babyCare.dao.UserDao;
import com.niit.babyCare.model.user;

@Controller
public class UserController 
{
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/user")
	public String regi(@RequestParam("mail")String mail,@RequestParam("name")String name,@RequestParam("phone")String phone,@RequestParam("pwd")String pwd,@RequestParam("add")String add,@RequestParam("con")String con)
	{
		user u=new user();
		u.setEmail(mail);
		u.setCountry(con);
		u.setName(name);
		u.setPassword(pwd);
		u.setAddress(add);
		u.setPhone(phone);
		u.setRole("USER");
		u.setEnabled(true);
		userDao.insertUser(u);
		
		return "Login";
	}
	
	
	

}
