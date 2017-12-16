package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.babyCare.dao.supplierDao;
import com.niit.babyCare.model.Supplier;


public class supplierTest
{
	static supplierDao supplierDao;
	
	//@Ignore
	@BeforeClass
	public static void INITIALIZE()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();
		//SessionFactory sessioFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		supplierDao=(supplierDao)configApplnContext.getBean("supplierDAO");

	}

	//@Ignore
	@Test
	public void addSupplierTest() 
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(100);
		supplier.setSupplierName("Xiomi");
		supplier.setSupplierAddress("Smart Phone");
		assertTrue(supplierDao.addSupplier(supplier));

	}
	
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(102);
		supplier.setSupplierName("Samsung");
		supplier.setSupplierAddress("xyz");
		
		assertTrue(supplierDao.updateSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(101);
		assertTrue(supplierDao.deleteSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void retrieveSupplierTest()
	{
		List<Supplier> listSupplier=supplierDao.retrieveSupplier();
		assertNotNull("Problem in Retriving ",listSupplier);
		this.show(listSupplier);
	}
	
	public void show(List<Supplier> listSupplier)
	{
		for(Supplier supplier:listSupplier)
		{
			System.out.println("Supplier ID:"+supplier.getSupplierId());
			System.out.println("Supplier Name:"+supplier.getSupplierName());
		}
	}
	
	@Ignore
	@Test
	public void getSupplierTest()
	{
		Supplier supplier=supplierDao.getSupplier(102);
		assertNotNull("Problem in Getting:",supplier);
		System.out.println("Category ID:"+supplier.getSupplierId());
		System.out.println("Category Name:"+supplier.getSupplierName());
	}
}
