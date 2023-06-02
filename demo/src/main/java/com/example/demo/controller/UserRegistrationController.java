package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.RegistrationRequest;
import com.example.demo.service.AppUserService;


@RestController
@RequestMapping("userRegistration")
public class UserRegistrationController {
	
	@Autowired
	private AppUserService userService;
	
	public String registre(@RequestBody RegistrationRequest request) {
		return userService.register(request);
	}
}
