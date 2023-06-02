package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment,String>{

	@Query("{id:?0}")
	Payment getById(String id);

}
