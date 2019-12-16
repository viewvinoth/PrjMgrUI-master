package com.springboot.rest.restservice.service;

import java.util.List;

import com.springboot.rest.restservice.dto.ProjectDTO;

public interface IProjectService {

	List<ProjectDTO> retrieveAllProjects();
	
	ProjectDTO retrieveProjectById(int id);
	
	ProjectDTO createProject(ProjectDTO project);
	
	ProjectDTO editProject(ProjectDTO project);
	
	void deleteProject(int id);
}
