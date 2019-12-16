package com.springboot.rest.restservice.mapper;

import com.springboot.rest.restservice.dto.TaskDTO;
import com.springboot.rest.restservice.entity.Task;

public class TaskDTOMapper {

	public TaskDTO getTaskDTO(Task task, String parenttask) {
		return new TaskDTO(task.getTask_id(), task.getParent_id(), task.getProject_id(), task.getTask(),
				task.getStart_date(), task.getEnd_date(), task.getPriority(), task.getStatus(),
				task.getUserId(), parenttask);		
	}
	
	public Task getTask(TaskDTO task) {
		return new Task(task.getTask_id(), task.getParent_id(), task.getProject_id(), task.getTask(),
				task.getStart_date(), task.getEnd_date(), task.getPriority(), task.getStatus(),
				task.getUserId());
	}
}
