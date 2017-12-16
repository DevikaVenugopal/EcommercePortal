package com.niit.babyCare.daoImpl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.babyCare.dao.*;
import com.niit.babyCare.model.*;

@Repository("UserDAO")
public class UserDaoImpl implements UserDao
{
	@Autowired
	SessionFactory sessionFac;
	
	@Transactional
	public boolean insertUser(user user) 
	{
		try
		{
			Session session=sessionFac.openSession();
			session.beginTransaction();
			session.persist(user);
			session.getTransaction().commit();
			return true;    
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		    return false;
		}
	}
	
	
	@Transactional
	public List<user> retrieveUser()
	{
		Session session=sessionFac.openSession();
		Query query=session.createQuery("from user");
		List<user> listUser=query.list();
		session.close();
		return listUser;
	}


	public user getUser(String user) 
	{
		Session session=sessionFac.openSession();
		user u=(user)session.get(user.class, user);
		session.close();
		return u;
	}

}
