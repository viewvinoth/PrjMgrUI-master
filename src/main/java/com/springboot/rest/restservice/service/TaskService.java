package com.springboot.rest.restservice.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.restservice.dto.TaskDTO;
import com.springboot.rest.restservice.entity.ParentTask;
import com.springboot.rest.restservice.entity.Task;
import com.springboot.rest.restservice.mapper.TaskDTOMapper;
import com.springboot.rest.restservice.repository.TaskRepository;

@Service
public class TaskService implements ITaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private IParentTaskService parentTaskService;

	@Autowired
	private TaskDTOMapper mapper;

	@Override
	public List<TaskDTO> retrieveAllTasks(int projectId) {
		List<TaskDTO> list = new ArrayList<TaskDTO>();
		Optional<ParentTask> parentTask;
		Iterable<Task> iterable = taskRepository.findAll();
		for (Task task : iterable) {
			if (task.getProject_id() == projectId) {
				parentTask = parentTaskService.getParentTaskById(task.getParent_id());
				if (parentTask.isPresent()) {
					list.add(mapper.getTaskDTO(task, parentTask.get().getParent_task()));
				} else {
					list.add(mapper.getTaskDTO(task, ""));
				}
			}
		}
		return list;
	}

	@Override
	public TaskDTO retrieveTaskById(int id) {
		Task task = taskRepository.findById(id).get();
		Optional<ParentTask> parenttask = parentTaskService.getParentTaskById(task.getParent_id());
		if (parenttask.isPresent()) {
			return mapper.getTaskDTO(task, parenttask.get().getParent_task());
		} else {
			return mapper.getTaskDTO(task, "");
		}
	}

	@Override
	public TaskDTO createTask(TaskDTO taskDto) {
		Task task = mapper.getTask(taskDto);
		taskRepository.save(task);
		return taskDto;
	}

	@Override
	public TaskDTO editTask(TaskDTO taskDto) {
		Task task = mapper.getTask(taskDto);
		taskRepository.save(task);
		return taskDto;
	}

	@Override
	public void deleteTask(int id) {
		taskRepository.deleteById(id);
	}

}
