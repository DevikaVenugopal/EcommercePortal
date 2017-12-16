package com.niit.babyCare.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.babyCare.dao.cartDao;
import com.niit.babyCare.model.Cart;
import com.niit.babyCare.model.Product;

@Repository
public class CartDaoImpl implements cartDao
{
	@Autowired
	SessionFactory sessionFac;
	
	
	public CartDaoImpl(SessionFactory sessionFac) {
		super();
		this.sessionFac = sessionFac;
	}

	public CartDaoImpl() {
		super();
	}

	public Cart getCartById(int pid,String userEmail)
    {
        Session session=sessionFac.openSession();
        Cart cr=null;
        try
        {
        	System.out.println("----------------------Product Existence----------------"+cr);
            session.beginTransaction();
            cr=(Cart)session.createQuery("From Cart where USERNAME=:email and PRODUCT_ID=:id")
                            .setString("email",userEmail)
                            .setInteger("id", pid)
                            .uniqueResult();
            session.getTransaction().commit();
            System.out.println(" Cart : "+cr);
            return cr;
        }
        catch(HibernateException e)
        {
        	System.out.println("ERROR=================================="+e.getMessage());
            session.getTransaction().rollback();
        }
        return cr;
    }    
    

    public boolean addCart(Cart cart) {
        Session session=sessionFac.openSession();
        session.beginTransaction();
        session.persist(cart);
        session.getTransaction().commit();
        return true;
    }

    public boolean updateCart(Cart cart) {
        Session session=sessionFac.openSession();
        session.beginTransaction();
        session.update(cart);
        session.getTransaction().commit();
        return true;
    }

    public boolean deleteCart(Cart cart) {
        Session session=sessionFac.openSession();
        session.beginTransaction();
        session.delete(cart);
        session.getTransaction().commit();
        return true;
    }

   
    @SuppressWarnings("unchecked")
	public List<Cart> getCartItems(String username) {
        Session session=sessionFac.openSession();
        List<Cart> cr=null;
        try
        {
            session.beginTransaction();
            cr=(List<Cart>)session.createQuery("From Cart where USERNAME='"+username+"'").list();
            session.getTransaction().commit();
        }
        catch(HibernateException e)
        {
            session.getTransaction().rollback();
        }
        return cr;
    }

	public Cart getCartItem(int cartitemId)
	{
		Session session=sessionFac.openSession();
		Cart cart=(Cart)session.get(Cart.class, cartitemId);
		session.close();
		return cart;

	}
    }
