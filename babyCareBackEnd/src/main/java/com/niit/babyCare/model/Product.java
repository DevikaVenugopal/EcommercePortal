package com.niit.babyCare.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Product
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int productId;
	String productName,productDesc;
	int stock,price;
	
	@ManyToOne
	@JoinColumn(name="catId")
	private category category;
	
	@ManyToOne
	@JoinColumn(name="supplierId")
	private Supplier supplier;
	
	
	@Transient
	MultipartFile pimage;
	
	@OneToMany(targetEntity=Cart.class,fetch=FetchType.EAGER,mappedBy="product")
	private Set<Cart> cart;


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductDesc() {
		return productDesc;
	}


	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public category getCategory() {
		return category;
	}


	public void setCategory(category category) {
		this.category = category;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public MultipartFile getPimage() {
		return pimage;
	}


	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}


	
	
	
}
