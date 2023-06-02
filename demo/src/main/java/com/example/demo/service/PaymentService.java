package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepo;

	public void addOne(Payment data) {
		paymentRepo.save(data);
	}

	public List<Payment> getAll() {
		return paymentRepo.findAll();
	}

	public void deleteById(String id) {
		paymentRepo.deleteById(id);
	}

	public Payment getById(String id) {
		
		return paymentRepo.getById(id);
	}
	

	
}
