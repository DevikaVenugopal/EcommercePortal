package com.niit.babyCare.dao;

import java.util.List;

import com.niit.babyCare.model.Cart;

public interface cartDao 
{
	public boolean addCart(Cart cart);
    public boolean updateCart(Cart cart);
    public boolean deleteCart(Cart cart);
    public Cart getCartItem(int cartitemId); 
    public List<Cart> getCartItems(String username);
    public Cart getCartById(int pid,String username);
}
