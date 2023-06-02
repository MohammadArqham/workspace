package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Cart")
public class Cart {
	@Id
	private String id;
	@DBRef
	private Product product;
	@DBRef
	private User user;
	private int quantity;
	
	
	public Cart(String id) {
		super();
		this.id = id;
	}
	
	
	public Cart(Product product, User user, int quantity) {
		super();
		this.product = product;
		this.user = user;
		this.quantity = quantity;
	}


	public Cart(String id, Product product, User user, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
	}


	public Cart() {
		super();
	
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", product=" + product + ", user=" + user + ", quantity=" + quantity + "]";
	}
	
}
