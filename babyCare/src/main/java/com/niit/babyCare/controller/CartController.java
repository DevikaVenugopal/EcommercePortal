package com.niit.babyCare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.babyCare.model.Cart;
import com.niit.babyCare.model.Orders;
import com.niit.babyCare.model.Product;
import com.niit.babyCare.model.category;
import com.niit.babyCare.model.user;
import com.niit.babyCare.dao.*;

@Controller
public class CartController 
{
	
	@Autowired
	cartDao cartDao;
	
	@Autowired
	categoryDao categoryDao;
	
	@Autowired
	productDao productDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	orderDao ordersDao;
	
	@RequestMapping("/addCart")
  	public ModelAndView goToaddCart(@RequestParam("pid")int pid, @RequestParam("qty")int qty)
  	{
  		
		ModelAndView mv=new ModelAndView();
  		Product p=productDao.getProduct(pid);
  		if(p.getStock()>=qty)
  		{
  		
  		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
  		String username = authentication.getName();
  		System.out.println("User Name : ---------------"+username);
  		
  		
  		
  		Cart c=cartDao.getCartById(pid,username);
  		
  		if(c==null)
  		{
  		c=new Cart();
  		c.setCartQnty(qty);
  		c.setProduct(p);
  		c.setCartUserDetails(userDao.getUser(username));
  		cartDao.addCart(c);
  		}
  		else
  		{
  			c.setCartQnty(c.getCartQnty()+qty);
  			cartDao.updateCart(c);
  		}
  		
  		
  		p.setStock(p.getStock()-qty);
  		productDao.updateProduct(p);
  	     mv.setViewName("redirect:/Cart?status=");
  		
  		}
  		else
  		{
  			mv.setViewName("redirect:/productView");
  			mv.addObject("pid",pid);
  			mv.addObject("error", "Reqired no of products not available....");
  		}
  		
		return mv;
  	}
	

	@RequestMapping("/Cart")
  	public ModelAndView goToaCart(@RequestParam("status")String status)
  	{
  		ModelAndView mv=new ModelAndView("Cart");
  		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
  		String username = authentication.getName();
  		
  		List<category> cs=categoryDao.retrieveCategory();
  		mv.addObject("categoryList", cs);
  		
  		
  		System.out.println(cs);
  	    List<Cart> cartList=cartDao.getCartItems(username);
	    mv.addObject("cartInfo", cartList);
	    mv.addObject("status", status);
	    
		
		return mv;
  	}
	
	
	@RequestMapping(value="deleteCart/{cartId}",method=RequestMethod.GET)
    public String deletemyCart(@PathVariable("cartId")int cartId,Model m)
    {
        Cart cart=cartDao.getCartItem(cartId);
        
        Product p=cart.getProduct();
        p.setStock(p.getStock()+cart.getCartQnty());
        productDao.updateProduct(p);
        cartDao.deleteCart(cart);
        Cart cartList=cartDao.getCartItem(cartId);
        m.addAttribute("cartList",cartList);
         
        Cart cart1=new Cart();
        m.addAttribute(cart1);
        m.addAttribute("status","Cart Item deleted Successfully"); 
        return "redirect:/Cart";
    }
	
	@RequestMapping(value="updateCart",method=RequestMethod.POST)
    public String updateCart(@RequestParam("cid") int cartId,@RequestParam("qty") int qty,Model m)
    {
		Cart c=cartDao.getCartItem(cartId);
		if(c.getProduct().getStock()>=qty)
		{
		c.setCartQnty(qty);
		cartDao.updateCart(c);
		m.addAttribute("status", "");
		}
		else
		{
			m.addAttribute("status", "Required no of products not available...");
		}
		
		return "redirect:/Cart";
    }
	
	@RequestMapping("/Checkout")
  	public ModelAndView checkout()
  	{
  		ModelAndView mv=new ModelAndView("Checkout");
  		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		user u=userDao.getUser(username);
		mv.addObject("user", u);
  		List<category> cs=categoryDao.retrieveCategory();
  		mv.addObject("categoryList", cs);
  		System.out.println(cs);
  	    List<Cart> cartList=cartDao.getCartItems(username);
	    mv.addObject("Cart", cartList);
	    
		
		return mv;
  	}
	
	 @RequestMapping("/Invoice")
     public ModelAndView receiptGe(@RequestParam("got")Double gtot)
     {
         ModelAndView mv=new ModelAndView("Invoice");
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String username = authentication.getName();
       
       user u=userDao.getUser(username);
       mv.addObject("User", u);
       
       Orders o=new Orders();
       o.setTotal(gtot);
       o.setUser(u);
       o.setPayment("Card Payment");
       ordersDao.addOrder(o);
   /*
       List<Cart> clist=cartDao.getCartItems(username);
       
       for(Cart c: clist)
       {
       cartDao.deleteCart(c);
       }*/
       
       
         List<category> cs=categoryDao.retrieveCategory();
         mv.addObject("categoryList", cs);
         System.out.println(cs);
         List<Cart> cartList=cartDao.getCartItems(username);
       mv.addObject("Cart", cartList);
       mv.addObject("Order",o);
       
       
       return mv;
     }
	
	 @RequestMapping("/ackOrder")
	 public ModelAndView ackOrder()
	 {

         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String username = authentication.getName();
		 
	       List<Cart> clist=cartDao.getCartItems(username);
	       
	       for(Cart c: clist)
	       {
	       cartDao.deleteCart(c);
	       }
		 return new ModelAndView("ackOrder");
	 }



}
