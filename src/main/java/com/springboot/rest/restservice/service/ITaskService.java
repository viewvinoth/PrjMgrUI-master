package com.springboot.rest.restservice.service;

import java.util.List;

import com.springboot.rest.restservice.dto.TaskDTO;
import com.springboot.rest.restservice.entity.Task;

public interface ITaskService {
	List<TaskDTO> retrieveAllTasks(int projectId);

	TaskDTO retrieveTaskById(int id);

	TaskDTO createTask(TaskDTO task);

	TaskDTO editTask(TaskDTO task);

	void deleteTask(int id);
}
