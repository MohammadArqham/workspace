package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired
	private CartService cartservice;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private ProductService productservice;
	
	//add single cart item to the collection
	@PostMapping("/addOne")
	public String addOne(@RequestBody Cart data) {
		cartservice.addOne(data);
		return "cart item added..!";
	}
	
	//Retrieve all the data from the collection
	@GetMapping("/getAll")
	public List<Cart> getAll(){
		return cartservice.getAll();
	}
	
	//Get all the cart items related to specific user id
	@GetMapping("/getItemsByUserId/{id}")
	public List<Cart> getItemsByUserId(@PathVariable String id){
		return cartservice.getAllItems(id);
	}
	
	//Get all the cart items related to specific user name
	@GetMapping("/getItemsByUserName/{name}")
	public List<Cart> getItemsByUserName(@PathVariable String name){
		return cartservice.getItemsByUserName(name);
	}
	
	//delete single item based on cart item id
	@DeleteMapping("/deleteItemById/{id}")
	public Boolean deleteItemById(@PathVariable String id) {
		cartservice.deleteItemById(id);
		return true;
	}
	
	
	@RequestMapping("/addToCart/{userId}/{productId}")
	public String AddToCart(@PathVariable("userId") String userId,@PathVariable("productId") String productId) {
		
		User user = new User(userId);
		Product product=new Product(productId);
		
		Cart cartItem = new Cart(product,user,0);
		
		cartservice.addOne(cartItem);
		
		return "item added.!";
	}
	
	@RequestMapping("/incrementCart/{id}")
	public void incrementCartItemQuantity(@PathVariable String id) {
		Cart item = cartservice.getById(id);
		item.setQuantity(item.getQuantity()+1);
		cartservice.addOne(item);
	}
	
	@RequestMapping("/dicrementCart/{id}")
	public void decrementCartItemQuantity(@PathVariable String id) {
		Cart item = cartservice.getById(id);
		item.setQuantity(item.getQuantity()-1);
		cartservice.addOne(item);
	}
	
}
