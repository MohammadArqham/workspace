package com.example.apmcProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.apmcProject.model.fileData;

@Repository
public interface fileRepository extends MongoRepository<fileData, String> {

}
