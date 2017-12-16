package com.niit.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.babyCare.dao.UserDao;
import com.niit.babyCare.model.user;

public class userTest 
{
	static UserDao userDao;
	
	//@Ignore
		@BeforeClass
		public static void INITIALIZE()
		{
			AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
			configApplnContext.scan("com.niit");
			configApplnContext.refresh();
			//SessionFactory sessioFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
			userDao=(UserDao)configApplnContext.getBean("UserDAO");

		}


	@Ignore	
	@Test
	public void insertUserTest() 
	{
		user user=new user();
		user.setEmail("devikavenugopal95@gmail");
		user.setName("Devika Venugopal");
		user.setPhone("9497487595");
		user.setAddress("xyz");
		user.setPassword("uvw");
		user.setCountry("India");
		user.setRole("");
		user.setEnabled(true);
		assertTrue(userDao.insertUser(user));
	}
	
	//@Ignore
	@Test
	public void retrieveUserTest()
	{
		List<user> listUser=userDao.retrieveUser();
		assertNotNull("Problem in Retrieving ",listUser);
		this.show(listUser);
	}
		
	public void show(List<user> listUser)
	{
		for(user user:listUser)
		{
			System.out.println("User Email::"+user.getEmail());
			System.out.println("User Name :"+user.getName());
			System.out.println("User Phone no:"+user.getPhone());
			System.out.println("User Address:"+user.getAddress());
			System.out.println("User Password:"+user.getPassword());
			System.out.println("User Role:"+user.getRole());
			System.out.println("User Country:"+user.getCountry());
			
		}
	}
}


