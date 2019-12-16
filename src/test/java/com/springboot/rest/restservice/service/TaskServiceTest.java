package com.springboot.rest.restservice.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.rest.restservice.TestConfiguration;
import com.springboot.rest.restservice.dto.TaskDTO;
import com.springboot.rest.restservice.entity.ParentTask;
import com.springboot.rest.restservice.entity.Task;
import com.springboot.rest.restservice.mapper.TaskDTOMapper;
import com.springboot.rest.restservice.repository.TaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class TaskServiceTest {
	
	@Autowired
	ITaskService taskService;
	
	@MockBean
	TaskRepository taskRepository;
	
	@MockBean
	IParentTaskService parentTaskService;
	
	@MockBean
	TaskDTOMapper mapper;
	
	ParentTask parentTask;
	Optional<ParentTask> parentTaskOpt;
	Task task;
	List<Task> taskList;
	Iterable<Task> taskIterable;

	@Before
	public void setUp() throws Exception {
		parentTask = new ParentTask(1, "parentTask");
		parentTaskOpt = Optional.of(parentTask);
		task = new Task(1, 1, 1, "task", "01/01/2019", "12/31/2019", 1, "open", 1);
		taskList = new ArrayList<Task>();
		taskList.add(task);
		taskIterable = new Iterable<Task>() {
			
			@Override
			public Iterator<Task> iterator() {
				// TODO Auto-generated method stub
				return taskList.iterator();
			}
		};
	}

	@Test
	public void testRetrieveAllTasks() {
		/*fail("Not yet implemented");*/
		Mockito.when(taskRepository.findAll()).thenReturn(taskIterable);
		Mockito.when(parentTaskService.getParentTaskById(1)).thenReturn(parentTaskOpt);
		//Mockito.when(mapper.getTaskDTO(anyString(), parenttask))
		List<TaskDTO> list = taskService.retrieveAllTasks(1);
		assertEquals(1, list.size());
	}

	@Test
	public void testRetrieveTaskById() {
		/*fail("Not yet implemented");*/
	}

	@Test
	public void testCreateTask() {
		/*fail("Not yet implemented");*/
	}

	@Test
	public void testEditTask() {
		/*fail("Not yet implemented");*/
	}

	@Test
	public void testDeleteTask() {
		/*fail("Not yet implemented");*/
		taskService.deleteTask(1);
	}

}
