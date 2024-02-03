package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class StafEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(max = 12, min = 3)
	private String name;
	
	@NotBlank
	private String loc;
	
	@Email
	private String email;
	
	private Integer age;
	
	
}

