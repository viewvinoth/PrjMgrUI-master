package com.springboot.rest.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.restservice.entity.ParentTask;
import com.springboot.rest.restservice.service.IParentTaskService;

@CrossOrigin(maxAge = 3600)
@RestController
public class ParentTaskController {

	@Autowired
	IParentTaskService parentTaskService;
	
	@PostMapping("/parenttasks")
	public ParentTask addParentTask(@RequestBody ParentTask parentTask) {
		return parentTaskService.createParentTask(parentTask);
	}
	
	@GetMapping("/parenttasks")
	public Iterable<ParentTask> retrieveAllParentTasks(){
		return parentTaskService.retrieveParentTasks();
	}
}
