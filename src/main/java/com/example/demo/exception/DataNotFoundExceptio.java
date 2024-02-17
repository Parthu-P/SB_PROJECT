package com.example.demo.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class DataNotFoundExceptio extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus status;

	public DataNotFoundExceptio(String msg,LocalDate date) {
		super();
	}
	
	
}
