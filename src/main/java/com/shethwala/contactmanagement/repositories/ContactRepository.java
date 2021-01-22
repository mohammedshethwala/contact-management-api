package com.shethwala.contactmanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shethwala.contactmanagement.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	Iterable<Contact> findAll();
}
