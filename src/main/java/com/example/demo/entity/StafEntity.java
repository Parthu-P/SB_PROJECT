package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name="Staf", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}),@UniqueConstraint(columnNames = {"name"})})
public class StafEntity {

	@Id
	private Integer stafId;
	
	@Size(max = 12, min = 3)
	private String name;
	
	@NotBlank
	private String loc;
	
	@Email
	private String email;
	
	private Integer age;
	
	@JoinColumn(name="id")
	@ManyToOne
	private AdminEntity admin; 
	
	
}

