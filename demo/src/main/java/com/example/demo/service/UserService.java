package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;

	//save single user data
	public void addOne(User data) {
		userRepo.save(data);
	}

	//get all user data
	public List<User> getAll() {
		
		return userRepo.findAll();
	}

	//delete user by id
	public void deleteUser(String id) {
		userRepo.deleteById(id);
	}
	
	//get user by id
	public Optional<User> getOne(String id) {
		
		return userRepo.findById(id);
	}
	
	//get user by name
	public User getByUserName(String username) {
		return userRepo.findByUsername(username);
	}

	//get user by email
	public User getByEmail(String email) {
		
		return userRepo.findByEmail(email);
	}

	//get user by phone number
	public User getByPhoneNo(Long phoneNo) {
		
		return userRepo.findByPhoneNo(phoneNo);
	}
	
}
