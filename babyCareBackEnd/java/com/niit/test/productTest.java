package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.babyCare.model.Product;
import com.niit.babyCare.dao.productDao;


public class productTest
{
	static productDao productDao;
	
	    //@Ignore
		@BeforeClass
		public static void INITIALIZE()
		{
			AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
			configApplnContext.scan("com.niit");
			configApplnContext.refresh();
			//SessionFactory sessioFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
			productDao=(productDao)configApplnContext.getBean("productDAO");

		}
		@Ignore
		@Test
		public void addProductTest() 
		{
			Product product=new Product();
			product.setProductId(4);
			product.setProductName("Mobile");
			product.setProductDesc("Smart Phone with NFC, 4G");
			product.setStock(10);
			product.setPrice(800);
			product.setCatId(1001);
			product.setSupplierId(1001);
			assertTrue("Problem in insertion",productDao.addProduct(product));

		}
		
		
		@Ignore
		@Test
		public void updateProductTest()
		{
			Product product=new Product();
			product.setProductId(3);
			product.setProductName("JMShirt");
			product.setProductDesc("John Miller Shirt with Best Price");
			product.setStock(10);
			product.setPrice(800);
			product.setCatId(1001);
			product.setSupplierId(1001);
			
			assertTrue(productDao.updateProduct(product));
		}
		
		
		@Ignore
		@Test
		public void deleteProductTest()
		{
			Product product=new Product();
			product.setProductId(3);
			assertTrue(productDao.deleteProduct(product));
		}
		
		@Ignore
		@Test
		public void retrieveProductTest()
		{
			List<Product> listProduct=productDao.retrieveProduct();
			assertNotNull("Problem in Retrieving ",listProduct);
			this.show(listProduct);
		}
		
		public void show(List<Product> listProduct)
		{
			for(Product product:listProduct)
			{
				System.out.println("Product ID:"+product.getProductId());
				System.out.println("Product Name:"+product.getProductName());
				System.out.println("Product Description:"+product.getProductDesc());
			}
		}
		
		@Ignore
		@Test
		public void getCategoryTest()
		{
			Product product=productDao.getProduct(4);
			assertNotNull("Problem in Getting:",product);
			System.out.println("Category ID:"+product.getProductId());
			System.out.println("Category Name:"+product.getProductName());
		}


}
