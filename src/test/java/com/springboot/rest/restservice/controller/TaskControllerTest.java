package com.springboot.rest.restservice.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springboot.rest.restservice.TestConfiguration;
import com.springboot.rest.restservice.dto.TaskDTO;
import com.springboot.rest.restservice.entity.Task;
import com.springboot.rest.restservice.service.ITaskService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfiguration.class)
@AutoConfigureMockMvc
public class TaskControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ITaskService taskService;
	
	List<TaskDTO> list;
	TaskDTO task1;
	TaskDTO task2;
	

	@Before
	public void setUp() throws Exception {
		task1 = new TaskDTO(1, 1, 1, "task", "2019-01-01", "2019-12-31", 1, "open", 2, "parent Task1");
		task2 = new TaskDTO(2, 2, 2, "task2", "2019-01-01", "2019-12-31", 1, "open", 3, "parent Task2");
		list = new ArrayList<TaskDTO>();
		list.add(task1);
		list.add(task2);
	}

	@Test
	public void testRetrieveAllTasks() throws Exception{
		Mockito.when(taskService.retrieveAllTasks(1)).thenReturn(list);
		RequestBuilder builder = MockMvcRequestBuilders.get("/tasks/byproject/1").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		JSONAssert.assertEquals("[{\"task_id\":1,\"parent_id\":1,\"project_id\":1,\"task\":\"task\",\"start_date\":\"2019-01-01\",\"end_date\":\"2019-12-31\",\"priority\":1,\"status\":\"open\"},{\"task_id\":2,\"parent_id\":2,\"project_id\":2,\"task\":\"task2\",\"start_date\":\"2019-01-01\",\"end_date\":\"2019-12-31\",\"priority\":1,\"status\":\"open\"}]", mvcResult.getResponse().getContentAsString(), false);
	}

	@Test
	public void testRetrieveTaskById() throws Exception {
		Mockito.when(taskService.retrieveTaskById(1)).thenReturn(task1);
		RequestBuilder builder = MockMvcRequestBuilders.get("/tasks/1").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		JSONAssert.assertEquals("{\"task_id\":1,\"parent_id\":1,\"project_id\":1,\"task\":\"task\",\"start_date\":\"2019-01-01\",\"end_date\":\"2019-12-31\",\"priority\":1,\"status\":\"open\"}", mvcResult.getResponse().getContentAsString(), false);
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
	}

}
