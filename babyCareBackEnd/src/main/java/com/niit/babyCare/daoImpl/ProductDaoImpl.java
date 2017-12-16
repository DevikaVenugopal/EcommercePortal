package com.niit.babyCare.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.babyCare.dao.productDao;
import com.niit.babyCare.model.Product;
import com.niit.babyCare.model.category;

@Repository("productDAO")
@EnableTransactionManagement
public class ProductDaoImpl implements productDao
{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean addProduct(Product product)
	{
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
		    return false;
		}
	}

	@Transactional
	public boolean deleteProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
		    return false;
		}
	}

	@Transactional
	public List<Product> retrieveProduct()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listProduct=query.list();
		session.close();
		return listProduct;
	}

	@Transactional
	public boolean updateProduct(Product product) 
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		return false;
		}
	}

	@Transactional
	public Product getProduct(int productId) 
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class, productId);
		session.close();
		return product;
	}

	public List<Product> retrieveProductByCat(int catId)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where catId="+catId);
		List<Product> listProduct=query.list();
		session.close();
		return listProduct;
	}

}
