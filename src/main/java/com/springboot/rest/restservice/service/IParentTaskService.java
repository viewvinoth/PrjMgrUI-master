package com.springboot.rest.restservice.service;


import java.util.Optional;

import com.springboot.rest.restservice.entity.ParentTask;

public interface IParentTaskService {
	ParentTask createParentTask(ParentTask parentTask);

	Iterable<ParentTask> retrieveParentTasks();
	
	ParentTask updateParentTask(ParentTask parentTask);
	
	Optional<ParentTask> getParentTaskById(int id);
}
