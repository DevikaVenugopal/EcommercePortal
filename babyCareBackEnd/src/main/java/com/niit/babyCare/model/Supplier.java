package com.niit.babyCare.model;

import java.util.Set;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Supplier 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int supplierId;
	String supplierName,supplierAddress;
	
	@OneToMany(targetEntity=Product.class,fetch=FetchType.EAGER,mappedBy="supplier")
	private Set<Product> products;
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	
	

}
