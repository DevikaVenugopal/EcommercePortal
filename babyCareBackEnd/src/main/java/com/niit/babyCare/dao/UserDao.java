package com.niit.babyCare.dao;

import java.util.List;

import com.niit.babyCare.model.category;
import com.niit.babyCare.model.user;

public interface UserDao
{
	public boolean insertUser(user user); 
	public List<user> retrieveUser();
	public user getUser(String username);
	 

}
