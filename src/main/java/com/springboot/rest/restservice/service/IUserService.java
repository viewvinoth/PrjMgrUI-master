package com.springboot.rest.restservice.service;

import java.util.List;
import java.util.Optional;

import com.springboot.rest.restservice.entity.User;

public interface IUserService {
	
	Iterable<User> retrieveAllUsers();
	
	Optional<User> retrieveUserById(int id);
	
	User createUser(User user);
	
	User editUser(User user);
	
	void deleteUser(int id);
	
}
