package com.niit.babyCare.dao;

import java.util.List;

import com.niit.babyCare.model.Product;

public interface productDao 
{
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public List<Product> retrieveProduct();
	public List<Product> retrieveProductByCat(int catId);
	public boolean updateProduct(Product product);
	public Product getProduct(int productId);

}
