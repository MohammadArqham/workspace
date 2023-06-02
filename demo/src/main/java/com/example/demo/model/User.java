package com.example.demo.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="User")
public class User {
	
	@Id
	private String id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNo;
	private boolean isAdmin=false;
	private UserAddress adress;
	
	
	public User(String id) {
		super();
		this.id = id;
	}
	public User(String username, String password, String firstName, String lastName, String email, Long phoneNo,
			boolean isAdmin, UserAddress adress) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.isAdmin = isAdmin;
		this.adress = adress;
	}
	public User() {
		super();
	}
	
	
	
	public User(String id, String username, String password, String firstName, String lastName, String email,
			Long phoneNo, boolean isAdmin, UserAddress adress) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.isAdmin = isAdmin;
		this.adress = adress;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public UserAddress getAdress() {
		return adress;
	}
	public void setAdress(UserAddress adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phoneNo=" + phoneNo + ", isAdmin=" + isAdmin
				+ ", adress=" + adress + "]";
	}
	
	
	
	
	
	
}
