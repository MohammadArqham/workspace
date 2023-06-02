package com.example.apmcProject.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.apmcProject.model.user;

@Repository
public interface userRepository extends MongoRepository<user, String> {
	  Optional<user> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
}
