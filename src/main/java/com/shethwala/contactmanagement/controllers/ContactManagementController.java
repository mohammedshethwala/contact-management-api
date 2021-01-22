package com.shethwala.contactmanagement.controllers;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shethwala.contactmanagement.exceptions.ContactValidationException;
import com.shethwala.contactmanagement.models.Contact;
import com.shethwala.contactmanagement.repositories.ContactRepository;

@RestController
@RequestMapping(path="/v1", produces="application/json")
public class ContactManagementController {
	
	public static final String NOT_FOUND_MESSAGE = "Contact with contactId: %s not found";
	
	@Autowired
	private ContactRepository contactRepository;
	
	/*
	 * This resource gets all the available contacts from the database
	 */
	@GetMapping(path="/contacts")
	public Iterable<Contact> getAllContacts() {
		return contactRepository.findAll();
	}
	
	/*
	 * This resource gets information about a particular contact based on the contactId passed in the path parameter
	 * If the contactId is not available in database, then it will return an error object in response
	 */
	@GetMapping(path="/contacts/{contactId}")
	public Contact getContact(
			@PathVariable("contactId") Long contactId) {
		Optional<Contact> currentContact = contactRepository.findById(contactId);
	    if (currentContact.isPresent()) {
			return currentContact.get();
	    } else {
	    	throw new ValidationException(String.format(NOT_FOUND_MESSAGE, contactId));
	    }
	}
	
	/*
	 * This resource adds a new contact to the database. There are some input validations and if those are not met,
	 * then this resource will return an error response with the description of the input validation error message.
	 * If validation is successful, it will add the new contact to the database by auto generating the id primary key
	 */
	@PostMapping(path="/contacts")
	public Contact addContact(
			@Validated @Valid @RequestBody Contact contact,
			BindingResult errors) {
			
		if (errors != null && errors.hasErrors()) {
           throw new ContactValidationException(errors);
		}
		
		return contactRepository.save(contact);
	}
	
	/*
	 * This resource updates an existing contact information like first name, last name and email.
	 * The contact needs to be already available in the database in order for the update to work successfully.
	 * If the contact is not found, then this resource will send an error response with a user friendly message
	 */
	@PutMapping(path="/contacts/{contactId}")
	public Contact updateContact(
			@PathVariable("contactId") Long contactId,
			@Validated @Valid @RequestBody Contact contact,
			BindingResult errors) {	
		
		if (errors != null && errors.hasErrors()) {
           throw new ContactValidationException(errors);
		}
		
		Optional<Contact> currentContact = contactRepository.findById(contactId);
	    if (currentContact.isPresent()) {
	    	contact.setId(contactId);
			return contactRepository.save(contact);
	    } else {
	    	throw new ValidationException(String.format(NOT_FOUND_MESSAGE, contactId));
	    }
	}
	
	/*
	 * This resource deletes an already existing contact from the database
	 */
	@DeleteMapping(path="/contacts/{contactId}")
	public void deleteContact(
			@PathVariable("contactId") Long contactId) {
		Optional<Contact> currentContact = contactRepository.findById(contactId);
	    if (currentContact.isPresent()) {
	    	contactRepository.deleteById(contactId);
	    } else {
	    	throw new ValidationException(String.format(NOT_FOUND_MESSAGE, contactId));
	    }
	}

}
