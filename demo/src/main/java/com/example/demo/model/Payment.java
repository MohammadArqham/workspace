package com.example.demo.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class Payment {
	@Id
	private String id;
	private String paymentType;
	private LocalDate paymentDate;
	private String paymentStatus;
	private String provider;
	private float amount;
	public Payment(String id, String paymentType, LocalDate paymentDate, String paymentStatus, String provider,
			float amount) {
		super();
		this.id = id;
		this.paymentType = paymentType;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
		this.provider = provider;
		this.amount = amount;
	}
	public Payment(String id) {
		super();
		this.id = id;
	}
	public Payment(String paymentType, LocalDate paymentDate, String paymentStatus, String provider, float amount) {
		super();
		this.paymentType = paymentType;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
		this.provider = provider;
		this.amount = amount;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", paymentType=" + paymentType + ", paymentDate=" + paymentDate
				+ ", paymentStatus=" + paymentStatus + ", provider=" + provider + ", amount=" + amount + "]";
	}
	
	
	
}
