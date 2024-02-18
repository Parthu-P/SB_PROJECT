package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name="Staf", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}),@UniqueConstraint(columnNames = {"name"})})
public class StafEntity {

	@Id
	private Integer stafId;
	
	@NotNull
	@Size(max = 12, min = 3)
	private String name;
	
	@NotBlank
	private String loc;
	
	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Email is not valid")
	private String email;
	
	private Integer age;
	
	@JoinColumn(name="id")
	@ManyToOne
	private AdminEntity admin; 
	
	
}

