package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Orders;
import com.example.demo.model.User;
import com.example.demo.repository.OrdersRepository;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository orderRepo;

	public void addOne(Orders data) {
		orderRepo.save(data);
	}

	public List<Orders> getAll() {
		
		return orderRepo.findAll();
	}

	public Orders getById(String id) {
		
		return orderRepo.findOrderById(id);
	}

	public List<Orders> getByUser(String userId) {
		User user = new User(userId);
		
		return orderRepo.findByUser(user);
	}

	public void changeStatusById(String id, String status) {
		try {
			Orders order1=new Orders();
			order1=orderRepo.findOrderById(id);
		order1.setStatus(status);
		orderRepo.save(order1);
		}
		catch(Exception e) {
			System.out.println("+++++++++++++++=>"+e);
		}
		

	}

	public void deleteById(String id) {
		orderRepo.deleteById(id);
		
	}
	
	
}
