package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Admin")
public class AdminEntity {

	@Id
	private Integer id;
	
	private String name;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private List<StafEntity> staf;
}
