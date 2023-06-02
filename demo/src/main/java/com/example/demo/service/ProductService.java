package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;

	public void addOne(Product data) {
		productRepo.save(data);
	}

	public List<Product> getAll() {
		
		return productRepo.findAll();
	}

	public Product getById(String id) {
		Product product=productRepo.findById(id).get();
		float intaialvalue = product.getUnitPrice();
		float discount = product.getDiscount();
		
		float newValue = intaialvalue - (intaialvalue*(discount/100));
		
		product.setUnitPrice(newValue);
		
		return product;
	}

	public List<Product> getByCategory(String category) {
		
		return productRepo.findByCategory(category);
	}

	public void deletById(String id) {
		
		productRepo.deleteById(id);
	}
	

	
}
