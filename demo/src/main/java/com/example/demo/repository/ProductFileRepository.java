package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.ProductFile;

public interface ProductFileRepository extends MongoRepository<ProductFile,String> {

	ProductFile findByName(String fileName);

}
