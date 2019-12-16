package com.springboot.rest.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.springboot.rest.restservice.mapper.ProjectDTOMapper;
import com.springboot.rest.restservice.mapper.TaskDTOMapper;

@SpringBootApplication
public class RestServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

	@Bean
	public ProjectDTOMapper projectDTOMapper() {
		return new ProjectDTOMapper();
	}
	
	@Bean
	public TaskDTOMapper taskDTOMapper() {
		return new TaskDTOMapper();
	}
}
