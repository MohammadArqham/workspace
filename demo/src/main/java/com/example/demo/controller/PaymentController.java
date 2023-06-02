package com.example.demo.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;

@RequestMapping("/payment")
@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	

	@PostMapping("/addOne")
	public Boolean addOne(@RequestBody Payment data) {
		paymentService.addOne(data);
		return true;
	}
	
	@PostMapping("/addOneForm")
	public String addOneForm(@RequestParam("paymentType") String paymentType,@RequestParam("paymentStatus") String paymentStatus,@RequestParam("provider") String provider,@RequestParam("amount") float amount) {
		
		Payment payment = new Payment(paymentType,LocalDate.now(),paymentStatus,provider,amount);
		paymentService.addOne(payment);
		return payment.toString();
	}
	
	@GetMapping("/getAll")
	public List<Payment> getAll() {
		return paymentService.getAll();
	}
	@GetMapping("getById/{id}")
	public Payment getById(@PathVariable String id) {
		return paymentService.getById(id);
	}
	@DeleteMapping("/deleteById/{id}")
	public Boolean deleteById(@PathVariable String id) {
		paymentService.deleteById(id);
		return true;
	}
}
