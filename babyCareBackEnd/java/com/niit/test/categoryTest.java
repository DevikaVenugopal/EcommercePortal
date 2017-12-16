package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.babyCare.dao.categoryDao;
import com.niit.babyCare.model.category;

public class categoryTest 
{
	static categoryDao categoryDao;
	
	//@Ignore
	@BeforeClass
	public static void INITIALIZE()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();
		//SessionFactory sessioFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		categoryDao=(categoryDao)configApplnContext.getBean("categoryDAO");

	}
	@Ignore
	@Test
	public void addCategoryTest() 
	{
		category category=new category();
		category.setCatId(3);
		category.setCatName("Mobile");
		category.setCatDesc("Smart Phone with NFC, 4G");
		assertTrue(categoryDao.addCategory(category));

	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		category category=new category();
		category.setCatId(3);
		category.setCatName("JMShirt");
		category.setCatDesc("John Miller Shirt with Best Price");
		
		assertTrue(categoryDao.updateCategory(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		category category=new category();
		category.setCatId(2);
		assertTrue(categoryDao.deleteCategory(category));
	}
	
	//@Ignore
	@Test
	public void retrieveCategoryTest()
	{
		List<category> listCategory=categoryDao.retrieveCategory();
		assertNotNull("Problem in Retrieving ",listCategory);
		this.show(listCategory);
	}
	
	public void show(List<category> listCategory)
	{
		for(category category:listCategory)
		{
			System.out.println("Category ID:"+category.getCatId());
			System.out.println("Category Name:"+category.getCatName());
			System.out.println("Category Description:"+category.getCatDesc());
		}
	}
	
	@Ignore
	@Test
	public void getCategoryTest()
	{
		category category=categoryDao.getCategory(1);
		assertNotNull("Problem in Getting:",category);
		System.out.println("Category ID:"+category.getCatId());
		System.out.println("Category Name:"+category.getCatName());
	}

}




