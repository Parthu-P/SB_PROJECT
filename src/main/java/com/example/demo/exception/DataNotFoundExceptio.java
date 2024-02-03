package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class DataNotFoundExceptio extends RuntimeException {

	private HttpStatus status;

	public DataNotFoundExceptio(String message) {
		super(message);
	}
	
	
}
