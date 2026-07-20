package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<GenericExceptionResponse>handleException(Exception e){
		GenericExceptionResponse r = new GenericExceptionResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value() , e.getMessage()); 
		
		return new ResponseEntity<>(r, HttpStatus.INTERNAL_SERVER_ERROR); 
	}
}
