package com.niit.babyCare.daoImpl;

import java.util.List;
import java.util.Locale.Category;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.babyCare.dao.categoryDao;
import com.niit.babyCare.model.category;

@Repository("categoryDAO")
@EnableTransactionManagement
public class CategoryDaoImpl implements categoryDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	public CategoryDaoImpl(SessionFactory sessionFactory) 
	{
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean addCategory(category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		    return false;
		}
	}

	@Transactional
	public List<category> retrieveCategory() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from category");
		List<category> listCategory=query.list();
		session.close();
		return listCategory;
	}

	
	public category getCategory(int catId) 
	{
		Session session=sessionFactory.openSession();
		category category=(category)session.get(category.class, catId);
		session.close();
		return category;
	}

	@Transactional
	public boolean deleteCategory(category category)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		    return false;
		}
	}

	@Transactional
	public boolean updateCategory(category category)
	{
		try
		{
		sessionFactory.getCurrentSession().update(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		return false;
		}
	}

}
