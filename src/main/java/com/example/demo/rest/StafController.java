package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StafEntity;
import com.example.demo.exception.DataNotFoundExceptio;
import com.example.demo.repo.StafRepo;
import com.example.demo.service.StafService;

import jakarta.validation.Valid;

@RestController
public class StafController {

	@Autowired
	private StafService service;

	private StafRepo repo;

	@PostMapping("/create")
	public StafEntity create(@Valid @RequestBody StafEntity staf) {
		try {
		service.create(staf);
		return staf;
		}catch(DataNotFoundExceptio ex) {
			throw new DataNotFoundExceptio("Invalid Data");
		}
	}

	@GetMapping("/fetch")
	public List<StafEntity> getAll() {
		List<StafEntity> fetch = service.fetch();
		if (fetch.isEmpty()) {
			throw new DataNotFoundExceptio("Data Not found");
		}
		else {
			return fetch;
		}
	}
}
