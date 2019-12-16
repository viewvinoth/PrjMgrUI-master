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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springboot.rest.restservice.TestConfiguration;
import com.springboot.rest.restservice.dto.ProjectDTO;
import com.springboot.rest.restservice.service.IProjectService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfiguration.class)
@AutoConfigureMockMvc
public class ProjectControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	IProjectService projectService;
	
	List<ProjectDTO>  list;
	ProjectDTO project1;
	ProjectDTO project2;
	
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<ProjectDTO>();
		project1 = new ProjectDTO(1, "project", "2019-01-01", "2019-12-31", 1, 287445, 1, 1);
		project2 = new ProjectDTO(2, "project2", "2019-01-01", "2019-12-31", 12, 287445, 11, 10);
		list.add(project1);
		list.add(project2);
	}

	@Test
	public void testRetrieveAllProjects() throws Exception {
		Mockito.when(projectService.retrieveAllProjects()).thenReturn(list);
		RequestBuilder builder =  MockMvcRequestBuilders.get("/projects").accept(MediaType.APPLICATION_JSON);		
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		JSONAssert.assertEquals("[{\"project_id\":1,\"project\":\"project\",\"startDate\":\"2019-01-01\",\"endDate\":\"2019-12-31\",\"priority\":1,\"user_id\":287445,\"noOfTasks\":1,\"noOfCompletedTasks\":1},{\"project_id\":2,\"project\":\"project2\",\"startDate\":\"2019-01-01\",\"endDate\":\"2019-12-31\",\"priority\":12,\"user_id\":287445,\"noOfTasks\":11,\"noOfCompletedTasks\":10}]", mvcResult.getResponse().getContentAsString(), false);	
	}

	@Test
	public void testRetrievePorjectById() throws Exception {
		Mockito.when(projectService.retrieveProjectById(1)).thenReturn(project1);
		RequestBuilder builder =  MockMvcRequestBuilders.get("/projects/1").accept(MediaType.APPLICATION_JSON);		
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		JSONAssert.assertEquals("{\"project_id\":1,\"project\":\"project\",\"startDate\":\"2019-01-01\",\"endDate\":\"2019-12-31\",\"priority\":1,\"user_id\":287445,\"noOfTasks\":1,\"noOfCompletedTasks\":1}", mvcResult.getResponse().getContentAsString(), false);	
	}

	@Test
	public void testCreateProject() throws Exception {
		/*
		 * Mockito.when(projectService.createProject(project1)).thenReturn(project1);
		 * RequestBuilder builder =
		 * MockMvcRequestBuilders.post("/projects").accept(MediaType.APPLICATION_JSON).
		 * content(
		 * "{\"project_id\":1,\"project\":\"project\",\"startDate\":\"2019-01-01\",\"endDate\":\"2019-12-31\",\"priority\":1,\"user_id\":287445,\"noOfTasks\":1,\"noOfCompletedTasks\":1}"
		 * ).contentType(MediaType.APPLICATION_JSON); MvcResult mvcResult =
		 * mockMvc.perform(builder).andReturn(); MockHttpServletResponse httpResponse =
		 * mvcResult.getResponse(); assertEquals(HttpStatus.OK.value(),
		 * httpResponse.getStatus());
		 */
	}

	@Test
	public void testUpdateProject() throws Exception {
		Mockito.when(projectService.editProject(project1)).thenReturn(project1);
		RequestBuilder builder =  MockMvcRequestBuilders.put("/projects/1").accept(MediaType.APPLICATION_JSON).content("{\"project_id\":1,\"project\":\"project\",\"startDate\":\"2019-01-01\",\"endDate\":\"2019-12-31\",\"priority\":1,\"user_id\":287445,\"noOfTasks\":1,\"noOfCompletedTasks\":1}").contentType(MediaType.APPLICATION_JSON);		
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse httpResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.CREATED.value(), httpResponse.getStatus());
	}	

}
