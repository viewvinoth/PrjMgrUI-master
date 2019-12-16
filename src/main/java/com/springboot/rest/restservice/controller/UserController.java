package com.springboot.rest.restservice.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.rest.restservice.entity.User;
import com.springboot.rest.restservice.service.IUserService;

@CrossOrigin(maxAge = 3600)
@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/users")
	public Iterable<User> retrieveAllUsers() {
		return userService.retrieveAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUserById(@PathVariable int id) {
		return userService.retrieveUserById(id).get();
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = userService.createUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getUserId()).toUri();

		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User savedUser = userService.createUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getUserId()).toUri();

		return ResponseEntity.created(location).build();		
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
}
