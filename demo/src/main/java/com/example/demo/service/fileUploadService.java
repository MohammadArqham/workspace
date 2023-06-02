package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.ProductFile;
import com.example.demo.repository.ProductFileRepository;

@Service
public class fileUploadService {

	@Autowired
	private ProductFileRepository fileRepo;
	

	
	public String uploadFile(String PATH,MultipartFile file) throws IOException {
		
		ProductFile PFile=new ProductFile();
		PFile.setName(file.getOriginalFilename());
		PFile.setType(file.getContentType());
		PFile.setImagePath(null);
		fileRepo.save(PFile);
		String fullPath=PATH+PFile.getId()+PFile.getName().substring(PFile.getName().lastIndexOf("."));
		PFile.setImagePath(fullPath);
		fileRepo.save(PFile);
		Files.copy(file.getInputStream(), Paths.get(fullPath),StandardCopyOption.REPLACE_EXISTING);
		System.out.println("-----------\n "+PFile.getId());
		return PFile.getId();
	}
	
	
	public ResponseEntity<byte[]> downloadFile(String fileName) throws IOException {
		Optional<ProductFile> p = fileRepo.findById(fileName);
		byte[] fileData =  Files.readAllBytes(new File(p.get().getImagePath()).toPath());
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(p.get().getType())).body(fileData);
	}
}
