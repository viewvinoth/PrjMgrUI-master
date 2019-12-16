package com.springboot.rest.restservice.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.rest.restservice.TestConfiguration;
import com.springboot.rest.restservice.dto.TaskDTO;
import com.springboot.rest.restservice.entity.Task;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class TaskDTOMapperTest {
	
	@Autowired
	TaskDTOMapper mapper;
	TaskDTO taskDto;
	Task task;

	@Before
	public void setUp() throws Exception {
		taskDto = new TaskDTO(1, 1, 1, "task", "01/01/2019", "12/31/2019", 1, "open", 1, "taskparent");
		task = new Task(1, 1, 1, "task", "01/01/2019", "12/31/2019", 1, "open", 1);
	}

	@Test
	public void testGetTaskDTO() {
		TaskDTO actualDto = mapper.getTaskDTO(task, "taskdad");
		assertEquals("taskdad", actualDto.getParenttask());
	}

	@Test
	public void testGetTask() {
		Task actual = mapper.getTask(taskDto);
		assertEquals("task", actual.getTask());
	}

}
