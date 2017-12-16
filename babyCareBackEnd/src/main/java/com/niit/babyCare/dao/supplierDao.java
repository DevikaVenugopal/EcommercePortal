package com.niit.babyCare.dao;

import java.util.List;

import com.niit.babyCare.model.Supplier;
import com.niit.babyCare.model.category;

public interface supplierDao 
{
	public boolean addSupplier(Supplier supplier);
	public List<Supplier> retrieveSupplier();
	public boolean deleteSupplier(Supplier supplier);
	public Supplier getSupplier(int SupplierId);
	public boolean updateSupplier(Supplier supplier);
}
