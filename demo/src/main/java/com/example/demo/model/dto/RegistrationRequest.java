package com.example.demo.model.dto;

import com.example.demo.model.UserAddress;

public class RegistrationRequest {
		private String name;
		private String username;
		private String email;
		private String password;
		private Long phoneNo;
		private UserAddress adress;
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Long getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(Long phoneNo) {
			this.phoneNo = phoneNo;
		}
		public UserAddress getAdress() {
			return adress;
		}
		public void setAdress(UserAddress adress) {
			this.adress = adress;
		}
		public RegistrationRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
		public RegistrationRequest(String name, String username, String email, String password, Long phoneNo,
				UserAddress adress) {
			super();
			this.name = name;
			this.username = username;
			this.email = email;
			this.password = password;
			this.phoneNo = phoneNo;
			this.adress = adress;
		}
		
		
}
