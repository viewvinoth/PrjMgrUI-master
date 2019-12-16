package com.springboot.rest.restservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.rest.restservice.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
