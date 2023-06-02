package com.example.apmcProject.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apmcProject.dto.userResponce;
import com.example.apmcProject.model.user;
import com.example.apmcProject.repository.userRepository;

@Service
public class userService {

	@Autowired
	userRepository userRepo;
	
	public userResponce getOne(String id) {
		
		user data = userRepo.findById(id).get();
		userResponce responce = new userResponce(data.getUsername(), 
				data.getFullname(), 
				data.getLocation(), 
				data.getEmail(),
				data.getPhoneNo() , 
				data.getRegistrationDate(), 
				data.getAbout());
		
		return responce;
	}

	public String addOneUser(user d) {
		
		d.setRegistrationDate(LocalDate.now());
		userRepo.save(d);
		
		return "item added..!";
	}

	public List<userResponce> getAll() {
		
		List<user> userList = userRepo.findAll();
		
		List<userResponce> Responce = userList.stream().map(
		item-> {
			
			userResponce responce = new userResponce(
					item.getUsername(), 
					item.getFullname(), 
					item.getLocation(), 
					item.getEmail(),
					item.getPhoneNo() , 
					item.getRegistrationDate(), 
					item.getAbout());
			
			return responce;
		
		}).collect(Collectors.toList());
		
		return Responce;
		
	}
	
	
	
}
