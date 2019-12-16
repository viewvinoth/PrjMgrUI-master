package com.springboot.rest.restservice.service;

import static org.junit.Assert.*;

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
import com.springboot.rest.restservice.controller.ParentTaskController;
import com.springboot.rest.restservice.entity.ParentTask;
import com.springboot.rest.restservice.repository.ParentTaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class ParentTaskServiceTest {

	@Autowired
	IParentTaskService service;
	
	@MockBean
	ParentTaskRepository parentTaskRepository;
	
	ParentTask task;
	Optional<ParentTask> taskOpt;

	@Before
	public void setUp() throws Exception {
		task = new ParentTask(1, "parentTask");
		taskOpt = Optional.of(task);
	}

	@Test
	public void testCreateParentTask() {
		Mockito.when(parentTaskRepository.save(task)).thenReturn(task);
		ParentTask actualTask = service.createParentTask(task);
		assertEquals(1, actualTask.getParent_id());
	}

	@Test
	public void testRetrieveParentTasks() {
		/* fail("Not yet implemented"); */
	}

	@Test
	public void testUpdateParentTask() {
		Mockito.when(parentTaskRepository.save(task)).thenReturn(task);
		ParentTask actualTask = service.createParentTask(task);
		assertEquals(1, actualTask.getParent_id());
	}
	
	@Test
	public void testGetParentTaskById() {
		Mockito.when(parentTaskRepository.findById(1)).thenReturn(taskOpt);
		Optional<ParentTask> actualOptTask = service.getParentTaskById(1);
		assertEquals(1, actualOptTask.get().getParent_id());
	}

}
