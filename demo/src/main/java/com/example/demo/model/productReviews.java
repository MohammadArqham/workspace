package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class productReviews {
	
	@DBRef
	private User user;
	private String review;
	
	
	public productReviews(User user, String review) {
		super();
		this.user = user;
		this.review = review;
	}
	public productReviews() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	
}
