package com.springboot.rest.restservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.restservice.dto.ProjectDTO;
import com.springboot.rest.restservice.dto.TaskDTO;
import com.springboot.rest.restservice.entity.Project;
import com.springboot.rest.restservice.entity.Task;
import com.springboot.rest.restservice.mapper.ProjectDTOMapper;
import com.springboot.rest.restservice.repository.ProjectRepository;

@Service
public class ProjectService implements IProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	ITaskService taskService;
	
	@Autowired
	ProjectDTOMapper mapper;

	@Override
	public List<ProjectDTO> retrieveAllProjects() {
		Iterable<Project> repoTaskList = projectRepository.findAll();
		List<ProjectDTO> returnList = new ArrayList<ProjectDTO>();
		for (Project project : repoTaskList) {
			List<TaskDTO> taskList = taskService.retrieveAllTasks(project.getProject_id());
			List<TaskDTO> completedTaskList = new ArrayList<TaskDTO>();
			for (TaskDTO task : taskList) {
				if (task.getStatus().equalsIgnoreCase("completed")) {
					completedTaskList.add(task);
				}
			}
			ProjectDTO cProject = mapper.getProjectDto(project);
			cProject.setNoOfCompletedTasks(completedTaskList.size());
			cProject.setNoOfTasks(taskList.size());
			returnList.add(cProject);
		}
		
		return returnList;
	}

	@Override
	public ProjectDTO retrieveProjectById(int id) {
		Project project = projectRepository.findById(id).get(); 
		return mapper.getProjectDto(project);
	}

	@Override
	public ProjectDTO createProject(ProjectDTO project) {
		return mapper.getProjectDto(projectRepository.save(mapper.getProject(project)));
	}

	@Override
	public ProjectDTO editProject(ProjectDTO project) {
		return mapper.getProjectDto(projectRepository.save(mapper.getProject(project)));
	}

	@Override
	public void deleteProject(int id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);		
	}

}
