package com.example.demo.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository {

	UserDetails findByUsername(String username);

}
