package com.example.demo.model;

public class UserAddress {
	
	private String area="sample1";
	private String city="sample1";
	private String state="sample1";
	private int pincode=123;
	
	public UserAddress(String area, String city, String state, int pincode) {
		super();
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "UserAddress [area=" + area + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	
	
}
