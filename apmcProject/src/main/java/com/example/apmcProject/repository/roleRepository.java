package com.example.apmcProject.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.apmcProject.model.ERole;
import com.example.apmcProject.model.Role;

public interface roleRepository extends MongoRepository<Role, String>{
	Optional<Role> findByName(ERole name);
}
