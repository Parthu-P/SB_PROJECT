package com.example.demo.exception;

import java.time.LocalDate;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class HandlerException {

	@ExceptionHandler(DataNotFoundExceptio.class)
	public ResponseEntity<DataNotFoundExceptio> handleException(DataNotFoundExceptio ex) {
		DataNotFoundExceptio errorResponse = new DataNotFoundExceptio(ex.getMessage(),LocalDate.now());
		return new ResponseEntity<>(errorResponse,ex.getStatus());
	}
	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
	
	@ExceptionHandler(DataAccessException .class)
    public ResponseEntity<String> handleDataAccessException (DataAccessException  ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
