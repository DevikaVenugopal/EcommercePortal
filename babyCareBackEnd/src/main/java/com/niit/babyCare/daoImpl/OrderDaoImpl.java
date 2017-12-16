package com.niit.babyCare.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.babyCare.dao.orderDao;
import com.niit.babyCare.model.*;

@Repository
public class OrderDaoImpl implements orderDao
{
	@Autowired
	SessionFactory sessionFac;

	public OrderDaoImpl(SessionFactory sessionFac) 
	{
		super();
		this.sessionFac = sessionFac;
	}
	
	@Transactional
	public boolean addOrder(Orders order)
	{
		try
		{
		Session session = sessionFac.openSession();
		session.beginTransaction();
		session.persist(order);
		session.getTransaction().commit();
		return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		    return false;
		}
	}
	

}
