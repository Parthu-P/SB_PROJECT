package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StafEntity;
import com.example.demo.repo.StafRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StafService {

	private Logger logger=LoggerFactory.getLogger(StafService.class);
	
	@Autowired
	private StafRepo repo;

	public StafEntity create(StafEntity entity, Integer id) {
	     repo.findById(id)
	            .map(existingEntity -> {
	                throw new EntityNotFoundException("Entity with ID " + id + " already exists");
	            })
	            .orElseGet(() -> repo.save(entity));
	     return entity;
	}
	

	public List<StafEntity> fetch() {
		List<StafEntity> findAll = repo.findAll();
		return findAll;
	}

	public StafEntity getById(Integer id) {
		return repo.findById(id).orElseThrow(() -> {
			logger.info("");
			return new EntityNotFoundException("Id is not found ");
		});
	}
	
	public String deleteById(Integer id) {
		repo.findById(id).orElseThrow(()->{
			logger.info("");
			return new EntityNotFoundException("   ");
		});
		repo.deleteById(id);
		return "Deleted";
	}
	
	public StafEntity updateId(Integer id, StafEntity entity) {
		repo.findById(id).orElseThrow(()->{
			return new EntityNotFoundException("");
		});
		return repo.save(entity);
		
	}
}
