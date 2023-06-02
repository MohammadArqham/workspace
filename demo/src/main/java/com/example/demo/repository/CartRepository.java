package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.User;

public interface CartRepository extends MongoRepository<Cart,String>{
	List<Cart> findByUser(User currentUser);

	Product findByProduct(Product product);

	@Query("{'product[id]':?0}")
	List<Cart> checkExisting(String product, User user);
	//@Query("{ 'product':?0 , 'user':?1}")

	@Query("{id:?0}")
	Cart findByItemId(String id);
	



	
}
