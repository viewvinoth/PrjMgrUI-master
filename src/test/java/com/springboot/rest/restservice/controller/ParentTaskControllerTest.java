package com.springboot.rest.restservice.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.remoting.support.RemoteInvocationResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springboot.rest.restservice.TestConfiguration;
import com.springboot.rest.restservice.entity.ParentTask;
import com.springboot.rest.restservice.service.IParentTaskService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfiguration.class)
@AutoConfigureMockMvc
public class ParentTaskControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	IParentTaskService parentTaskService;
	
	List<ParentTask> list;
	ParentTask parentTask1;
	ParentTask parentTask2;
	Iterable<ParentTask> iterable;
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<ParentTask>();
		parentTask1 = new ParentTask(1, "parentTask1");
		parentTask2 = new ParentTask(2, "task2");
		list.add(parentTask1);
		list.add(parentTask2);
		iterable = new Iterable<ParentTask>() {			
			@Override
			public Iterator<ParentTask> iterator() {
				// TODO Auto-generated method stub
				return list.iterator();
			}
		};
	}

	@Test
	public void testAddParentTask() throws Exception{
		Mockito.when(parentTaskService.createParentTask(parentTask1)).thenReturn(parentTask1);
		RequestBuilder builder =  MockMvcRequestBuilders.post("/parenttasks").accept(MediaType.APPLICATION_JSON).content("{\"parent_id\":1,\"parent_task\":\"parentTask1\"}").contentType(MediaType.APPLICATION_JSON);		
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse httpResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), httpResponse.getStatus());
	}

	@Test
	public void testRetrieveAllParentTasks() throws Exception {
		Mockito.when(parentTaskService.retrieveParentTasks()).thenReturn(iterable);
		RequestBuilder builder =  MockMvcRequestBuilders.get("/parenttasks").accept(MediaType.APPLICATION_JSON);		
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		JSONAssert.assertEquals("[{\"parent_id\":1,\"parent_task\":\"parentTask1\"},{\"parent_id\":2,\"parent_task\":\"task2\"}]", mvcResult.getResponse().getContentAsString(), false);
	}

}
