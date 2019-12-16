package com.springboot.rest.restservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.rest.restservice.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{

}
