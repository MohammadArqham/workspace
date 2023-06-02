package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Orders;
import com.example.demo.model.User;

public interface OrdersRepository extends MongoRepository<Orders,String> {

	List<Orders> findByUser(User user);
	
	@Query("{id:?0}")
	Orders findOrderById(String id);
}
