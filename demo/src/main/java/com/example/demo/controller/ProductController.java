package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Product;
import com.example.demo.model.ProductFile;
import com.example.demo.service.ProductService;
import com.example.demo.service.fileUploadService;

@ResponseStatus(value = HttpStatus.OK)
@RequestMapping("/product")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@Autowired
	private fileUploadService fileuploadservice;
	
	private String path="images\\";
	//upload file
	@PostMapping("/fileUpload")
	public String fileUpload(@RequestParam("image") MultipartFile image) throws IOException {
		fileuploadservice.uploadFile(path, image);
		return "file uploaded..!";
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) throws IOException {
		return fileuploadservice.downloadFile(fileName);
		
	}
	
	//post single product
	@PostMapping("/addOne")
	public String addOne(@RequestBody Product data) {
		productservice.addOne(data);
		return "product added..!";
	}
	
	//get all the data in collection
	@GetMapping("/getAll")
	public List<Product> getAll(){
		return productservice.getAll();
	}
	
	//get data of single user reference= id
	@GetMapping("/getById/{id}")
	public Product getById(@PathVariable String id) {
		return productservice.getById(id);
	}
	
	
	//get by category
	@GetMapping("/getByCategory/{category}")
	public List<Product> getByCategory(@PathVariable String category){
		return productservice.getByCategory(category);
	}
	
	//delete single product reference = id
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable String id) {
		productservice.deletById(id);
		return "product deleted..!";
	}
	
	@PostMapping("/addOneForm")
	public Boolean addOneForm(@RequestParam("name") String name,
			@RequestParam("discription") String discription,
			@RequestParam("unitPrice") float unitPrice,
			@RequestParam("discount") float discount,
			@RequestParam("rating") float rating,
			@RequestParam("unitsInStock") int unitsInStock,
			@RequestParam("category") String category,
			@RequestParam("image") MultipartFile image,
			@RequestParam("provider") String provider) 
					throws IOException{
		
		String path = "images/";
		String imageId=fileuploadservice.uploadFile(path, image);
		ProductFile imageObj = new ProductFile(imageId);
		
		Product product=new Product(name, discription,
				unitPrice, discount, 
				rating, unitsInStock,
				category, null, imageObj,
				null, provider);
		
		
		
		productservice.addOne(product);
		return true;
	}
	

	
}
