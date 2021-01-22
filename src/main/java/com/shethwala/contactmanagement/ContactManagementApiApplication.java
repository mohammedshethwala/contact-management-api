package com.shethwala.contactmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ContactManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactManagementApiApplication.class, args);
	}

}
