package com.shethwala.contactmanagement.exceptionhandlers;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shethwala.contactmanagement.exceptions.ContactValidationException;
import com.shethwala.contactmanagement.models.Error;

@ControllerAdvice
public class ContactExceptionHandler {
	
	@ExceptionHandler(ContactValidationException.class)
	public ResponseEntity<Error> handle(ContactValidationException ex) {
		return ResponseEntity
				.badRequest()
				.body(new Error(ex.getMessages()));
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Error> handle(ValidationException ex) {		
		return new ResponseEntity<Error>(new Error(ex.getMessage()), 
				HttpStatus.NOT_FOUND);
	}

}
