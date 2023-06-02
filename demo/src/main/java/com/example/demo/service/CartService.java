package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private UserService userservice;
	
	public void addOne(Cart data) {
		cartRepo.save(data);
		
	}
	
	public Cart getById(String id) {
		return cartRepo.findById(id).get();
	}

	public List<Cart> getAll() {
			return cartRepo.findAll();
	}

	public List<Cart> getAllItems(String user) {
		User currentUser = new User(user);
		
		return cartRepo.findByUser(currentUser);
	}

	public List<Cart> getItemsByUserName(String name) {
		User user = userservice.getByUserName(name);
		return cartRepo.findByUser(user);
	}

	public void deleteItemById(String id) {
		cartRepo.deleteById(id);
		
	}

	public Product getByProductId(String id) {
		Product product = new Product(id);
		return cartRepo.findByProduct(product);
	}

	
	
	
}
