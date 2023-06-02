package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Orders;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.OrdersService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

@RequestMapping("/orders")
@RestController
public class OrdersController {

	@Autowired
	private OrdersService orderservice;
	
	@Autowired
	private ProductService productservice;
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/addOne")
	public String addOne(@RequestBody Orders data) {
		orderservice.addOne(data);
		return "order added..!";
	}
	
	@GetMapping("/getAll")
	public List<Orders> getAll() {
		return orderservice.getAll();
	}
	
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestParam("userId") String userId,@RequestParam("productId") String productId,@RequestParam("quantity") int qunatity) {
		User user = userservice.getOne(userId).get();
		Product product = productservice.getById(productId);
		if(product.getUnitsInStock()<=0)
			return "product out of stock..!";
		
		product.setUnitsInStock(product.getUnitsInStock()-1);
		productservice.addOne(product);
		
		Orders order = new Orders(user,product,qunatity,"order placed",60.00F,null);
		orderservice.addOne(order);
		
		return "order placed..!";
	}
	
	@GetMapping("/getById/{id}")
	public Orders getById(@PathVariable String id) {
		
		return orderservice.getById(id);
	}
	
	@GetMapping("/getByUser/{userId}")
	public List<Orders> getByUser(@PathVariable String userId){
		return orderservice.getByUser(userId);
	}
	
	@RequestMapping("/changeStatus/{id}/{status}")
	public String changeStatusById(@PathVariable("id") String id,@PathVariable("status") String status) {
		try{
			orderservice.changeStatusById(id,status);
		}catch(Exception e) {
			System.out.println("______=>"+e);
		}
		
	return "Status Changed to "+status+" ..!";
	}
	public String deleteById(@PathVariable String id) {
		orderservice.deleteById(id);
		return "order with id "+id+" is deleted..!";
	}
}
