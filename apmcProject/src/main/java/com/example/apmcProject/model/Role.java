package com.example.apmcProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="roles")
public class Role {
	  
	  @Id
	  private String id;

	  private ERole name;

	public Role() {
		super();
	}

	public Role(String id) {
		super();
		this.id = id;
	}

	public Role(String id, ERole name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
	  
	  
}
