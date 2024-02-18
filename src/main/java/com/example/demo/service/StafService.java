package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StafEntity;
import com.example.demo.repo.StafRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StafService {

	private Logger logger = LoggerFactory.getLogger(StafService.class);

	@Autowired
	private StafRepo repo;

	public StafEntity create(StafEntity entity) {
		Optional<StafEntity> findById = repo.findById(entity.getStafId());
		if(findById.isEmpty()) {
			return repo.save(entity);
		}else {
			throw new EntityNotFoundException("this id is already exsits");
		}
	}

	public List<StafEntity> fetch() {
		List<StafEntity> list = repo.findAll();
		if(list.isEmpty()) {
			throw new EntityNotFoundException("data is not found");
		}else {
			return list;
		}
	}

	public StafEntity getById(Integer id) {
		return repo.findById(id).orElseThrow(() -> {
			logger.info("");
			throw new EntityNotFoundException("Id is not found ");
		});
	}

	public String deleteById(Integer id) {
		repo.findById(id).orElseThrow(() -> {
			logger.info("");
			throw new EntityNotFoundException("nnnnnnnnnnnnnnnnn");
		});
		repo.deleteById(id);
		return "Deleted";
	}

	public StafEntity updateId(Integer id, StafEntity entity) {
		repo.findById(id).orElseThrow(() -> {
			throw new EntityNotFoundException("nnnnnnnnnnnnn");
		});
		return repo.save(entity);

	}
}
