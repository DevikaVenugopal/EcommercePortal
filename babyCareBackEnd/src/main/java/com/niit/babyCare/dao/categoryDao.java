package com.niit.babyCare.dao;

import java.util.List;
import java.util.Locale.Category;

import com.niit.babyCare.model.category;

public interface categoryDao
{
	public boolean addCategory(category category);
	public List<category> retrieveCategory();
	public boolean deleteCategory(category category);
	public category getCategory(int catId);
	public boolean updateCategory(category category);

}
