package com.capgemini.productmanagementapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.productmanagementapp.exception.ProductException;

@RestControllerAdvice
public class ProductAdvice extends Exception {
	@ExceptionHandler(value = { ProductException.class })
	public ResponseEntity<String> handleException1(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
