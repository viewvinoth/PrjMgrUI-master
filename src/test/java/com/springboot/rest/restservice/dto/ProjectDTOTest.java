package com.springboot.rest.restservice.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProjectDTOTest {

	ProjectDTO project;

	@Before
	public void setUp() throws Exception {
		project = new ProjectDTO(0, null, null, null, 0, 0, 0, 0);
	}

	@Test
	public void testGetProject_id() {
		project.setProject_id(12);
		assertEquals(12, project.getProject_id());
	}

	@Test
	public void testGetProject() {
		project.setProject("project");
		assertEquals("project", project.getProject());
	}

	@Test
	public void testGetStartDate() {
		project.setStartDate("01/01/2019");
		assertEquals("01/01/2019", project.getStartDate());
	}

	@Test
	public void testGetEndDate() {
		project.setEndDate("12/31/2019");
		assertEquals("12/31/2019", project.getEndDate());
	}

	@Test
	public void testGetPriority() {
		project.setPriority(1);
		assertEquals(1, project.getPriority());
	}

	@Test
	public void testGetUser_id() {
		project.setUser_id(1);
		assertEquals(1, project.getUser_id());
	}
	
	

}
