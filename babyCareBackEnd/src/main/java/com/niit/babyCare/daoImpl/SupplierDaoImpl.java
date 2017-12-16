package com.niit.babyCare.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.babyCare.dao.supplierDao;
import com.niit.babyCare.model.Supplier;


@Repository("supplierDAO")
@EnableTransactionManagement
public class SupplierDaoImpl implements supplierDao
{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean addSupplier(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		    return false;
		}
	}

	@Transactional
	public List<Supplier> retrieveSupplier()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> listSupplier=query.list();
		session.close();
		return listSupplier;
	}

	@Transactional
	public boolean deleteSupplier(Supplier supplier)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		    return false;
		}
	}

	@Transactional
	public Supplier getSupplier(int SupplierId) 
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class, SupplierId);
		session.close();
		return supplier;
	}

	@Transactional
	public boolean updateSupplier(Supplier supplier)
	{
		try
		{
		sessionFactory.getCurrentSession().update(supplier);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		return false;
		}
	}
	
	

}
