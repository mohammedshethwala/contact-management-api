package com.shethwala.contactmanagement.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class ContactValidationException extends RuntimeException {
	
	private final BindingResult errors;

	public ContactValidationException(BindingResult errors) {
       this.errors = errors;
	}

	public List<String> getMessages() {
       return getValidationMessage(this.errors);
	}

	@Override
	public String getMessage() {
       return this.getMessages().toString();
	}

	private static List<String> getValidationMessage(BindingResult bindingResult) {
       return bindingResult.getAllErrors()
               .stream()
               .map(ContactValidationException::getValidationMessage)
               .collect(Collectors.toList());
	}

	private static String getValidationMessage(ObjectError error) {
       if (error instanceof FieldError) {
           FieldError fieldError = (FieldError) error;
           String property = fieldError.getField();
           Object invalidValue = fieldError.getRejectedValue();
           String message = fieldError.getDefaultMessage();
           return String.format("%s : %s, but it was %s", property, message, invalidValue);
       }
       return String.format("%s: %s", error.getObjectName(), error.getDefaultMessage());
	}

}
