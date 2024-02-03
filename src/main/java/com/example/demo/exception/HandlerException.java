package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

	@ExceptionHandler(DataNotFoundExceptio.class)
	public ResponseEntity<DataNotFoundExceptio> handleException(DataNotFoundExceptio ex) {
		DataNotFoundExceptio errorResponse = new DataNotFoundExceptio(ex.getMessage());
		return new ResponseEntity<>(errorResponse, ex.getStatus());

	}

}
