package com.springboot.rest.restservice.mapper;

import com.springboot.rest.restservice.dto.ProjectDTO;
import com.springboot.rest.restservice.entity.Project;


public class ProjectDTOMapper {
	
	public ProjectDTO getProjectDto(Project project) {
		return (new ProjectDTO(project.getProject_id(), project.getProject(), project.getStartDate(),
				project.getEndDate(), project.getPriority(), project.getUser_id(), 0, 0));
	}
	
	public Project getProject(ProjectDTO project) {
		return (new Project(project.getProject_id(), project.getProject(), project.getStartDate(),
				project.getEndDate(), project.getPriority(), project.getUser_id()));
	}

}
