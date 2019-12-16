package com.springboot.rest.restservice.service;

import java.util.Optional;

import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.restservice.entity.ParentTask;
import com.springboot.rest.restservice.repository.ParentTaskRepository;

@Service
public class ParentTaskService implements IParentTaskService{
	
	@Autowired
	ParentTaskRepository parentTaskRepository;
	
	public ParentTask createParentTask(ParentTask parentTask) {
		return parentTaskRepository.save(parentTask);
	}
	
	public Iterable<ParentTask> retrieveParentTasks() {
		return parentTaskRepository.findAll();
	}
	
	public ParentTask updateParentTask(ParentTask parentTask) {
		return parentTaskRepository.save(parentTask);
	}
	
	public Optional<ParentTask> getParentTaskById(int id) {
		return parentTaskRepository.findById(id);
	}

}
