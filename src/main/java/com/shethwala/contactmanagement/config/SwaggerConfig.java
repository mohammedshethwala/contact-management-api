package com.shethwala.contactmanagement.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());                                           
    }
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Contact Management API", 
	      "This REST API serves as an interface to add, update, delete and view all the contacts in the system. "
	      + "This application has an in-memory H2 database which will be initialized with 2 contacts on the database. "
	      + "The data.sql file is loaded during the startup and as soon as the application is up, the table and databsse will be "
	      + "ready with the initial data. You can hit the GET /contacts endpoint to get the list of available contacts "
	      + "in the database at any give point of time. You can use other POST, PUT, DELETE endpoints to add, update, "
	      + "or delete contacts from the database.", 
	      "V1", 
	      "No Terms of Service", 
	      new Contact("Mohammed Shethwala", "https://github.com/mohammedshethwala", "shethwala.mohammed@gmail.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}

}
