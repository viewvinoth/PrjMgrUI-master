package com.springboot.rest.restservice.controller;

import java.net.URI;
import java.util.List;

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

import com.springboot.rest.restservice.dto.ProjectDTO;
import com.springboot.rest.restservice.service.IProjectService;

@CrossOrigin(maxAge = 3600)
@RestController
public class ProjectController {

	@Autowired
	IProjectService projectService;
	
	@GetMapping("/projects")
	public List<ProjectDTO> retrieveAllProjects(){
		return projectService.retrieveAllProjects();
	}
	
	@GetMapping("/projects/{id}")
	public ProjectDTO retrievePorjectById(@PathVariable int id) {
		return projectService.retrieveProjectById(id);
	}
	
	@PostMapping("/projects")
	public  ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO project) {
		ProjectDTO savedProject = projectService.createProject(project);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProject.getProject_id()).toUri();

		return ResponseEntity.created(location).build();
	}	
	
	@PutMapping("/projects")
	public  ResponseEntity<ProjectDTO> updateProject(@RequestBody ProjectDTO project) {
		ProjectDTO savedProject = projectService.createProject(project);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProject.getProject_id()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/projects/{id}")
	public void deleteProject(@PathVariable int id) {
		projectService.deleteProject(id);
	}
}
