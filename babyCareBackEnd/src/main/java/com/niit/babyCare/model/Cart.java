package com.niit.babyCare.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="cart")
public class Cart implements Serializable
{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;

	@ManyToOne
	@JoinColumn(name="USERNAME")
	private user cartUserDetails;
	
	private int cartQnty;

	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public user getCartUserDetails() {
		return cartUserDetails;
	}

	public void setCartUserDetails(user cartUserDetails) {
		this.cartUserDetails = cartUserDetails;
	}

	public int getCartQnty() {
		return cartQnty;
	}

	public void setCartQnty(int cartQnty) {
		this.cartQnty = cartQnty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
