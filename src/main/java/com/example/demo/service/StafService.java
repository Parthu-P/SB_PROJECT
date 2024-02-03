package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StafEntity;
import com.example.demo.repo.StafRepo;

@Service
public class StafService {

	@Autowired
	private StafRepo repo;
	
	public String create(StafEntity entity) {
		repo.save(entity);
		return "success";
	}
	
	public List<StafEntity> fetch() {
		List<StafEntity> findAll = repo.findAll();
		return findAll;
	}
}
