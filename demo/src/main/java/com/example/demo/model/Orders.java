package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Orders")
public class Orders {
	
	@Id
	private String id;
	@DBRef
	private User user;
	@DBRef
	private Product product;
	private int quantity;
	private String status;
	private float shippingCharge;
	@DBRef
	private Payment payment;
	
	public Orders(String id) {
		super();
		this.id = id;
	}
	public Orders(User user, Product product, int quantity, String status, float shippingCharge, Payment payment) {
		super();
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.status = status;
		this.shippingCharge = shippingCharge;
		this.payment = payment;
	}
	public Orders(String id, User user, Product product, int quantity, String status, float shippingCharge,
			Payment payment) {
		super();
		this.id = id;
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.status = status;
		this.shippingCharge = shippingCharge;
		this.payment = payment;
	}
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getShippingCharge() {
		return shippingCharge;
	}
	public void setShippingCharge(float shippingCharge) {
		this.shippingCharge = shippingCharge;
	}
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", user=" + user + ", product=" + product + ", quantity=" + quantity + ", status="
				+ status + ", shippingCharge=" + shippingCharge + ", payment=" + payment + "]";
	}
		
	
	
}
