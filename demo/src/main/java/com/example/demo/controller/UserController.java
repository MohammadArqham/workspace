package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@CrossOrigin(origins="*")
@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	public UserService userservice;
	
	//test method
	@PostMapping("/test")
	public String test(@RequestParam("name") String name,@RequestParam("age") int age) {
		System.out.println("-----------------------------------\n"+name+"  "+age);
		return "data recived";
	}
	
	//add one user user collection
	@PostMapping("/addOne")
	public String addOne(@RequestBody User data){
		String errorMassage="";
		//check email address if already exists in collection 
		if(userservice.getByEmail(data.getEmail())!= null) {
			errorMassage = "email";
		}
		//check phone number if already exists in collection
		if(userservice.getByPhoneNo(data.getPhoneNo())!= null) {
			errorMassage = errorMassage + " phone number";
		}
		
		if(errorMassage!="")
			return errorMassage+" is taken";
		
		userservice.addOne(data);
		return "user data added..!";
	}
	
	//Different data value is added to collection with existing id then existing data gets updated,,following method is for updating single user
	@PostMapping("/update")
	public String update(@RequestBody User data){
		userservice.addOne(data);
		return "user data updated..!";
	}
	
	//Retrieve data of single user,referencing id
	@GetMapping("/getById/{id}")
	public Optional<User> getOne(@PathVariable String id) {
		return userservice.getOne(id);
	}
	
	//get all the data from user collection
	@GetMapping("/getAll")
	public List<User> getAll(){
		return userservice.getAll();
	}
	
	//delete single user from user collection reference:- id
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable String id) {
		userservice.deleteUser(id);
		return "user deleted";
	}
	
	//delete single user from user collection reference:- user name
	@GetMapping("/getByUsername/{username}")
	public User getByUsername(@PathVariable String username) {
		return userservice.getByUserName(username);
	}
	
	//delete single user from user collection reference:- email
	@GetMapping("/getByEmail/{email}")
	public User getByEmail(@PathVariable String email) {
		return userservice.getByEmail(email);
	}
	
	//delete single user from user collection reference:- phone number
	@GetMapping("/getByPhoneNo/{phoneNo}")
	public User getByPhoneNo(@PathVariable Long phoneNo) {
		return userservice.getByPhoneNo(phoneNo);
	}
	
	
	
}
