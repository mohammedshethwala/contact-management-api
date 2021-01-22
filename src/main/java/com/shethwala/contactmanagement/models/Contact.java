package com.shethwala.contactmanagement.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class Contact {
	
	/*
	 * id is the primary key for this entity and an auto-generated value has been defined for this field
	 * using the @GenericGenerator annotation. The initial value is defined as 3 because this application
	 * will be started with an in-memory database with 2 contacts already existing in the database at start up
	 */
	@Id
	@GeneratedValue(generator = "contact-sequence-generator")
	@GenericGenerator(
      name = "contact-sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "contact_sequence"),
        @Parameter(name = "initial_value", value = "3"),
        @Parameter(name = "increment_size", value = "1")
      }
	)
	@JsonProperty("contactId")
	private Long id;
	
	@NotEmpty
	@Size(max=25, message="First Name must be at most 25 characters long")
	private String firstName;
	
	@NotEmpty
	@Size(max=25, message="Last Name must be at most 25 characters long")
	private String lastName;
	
	@NotEmpty
	@Email(message="Email should be valid")
	private String email;

}
