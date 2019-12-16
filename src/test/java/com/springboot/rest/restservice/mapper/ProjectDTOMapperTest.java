package com.springboot.rest.restservice.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.rest.restservice.TestConfiguration;
import com.springboot.rest.restservice.dto.ProjectDTO;
import com.springboot.rest.restservice.entity.Project;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class ProjectDTOMapperTest {

	@Autowired
	ProjectDTOMapper mapper;
	ProjectDTO projectDto;
	Project project;
	
	@Before
	public void setUp() throws Exception {
		project = new Project(1, "testproject", "01/01/2019", "12/31/2019", 1, 1);
		projectDto = new ProjectDTO(1, "testproject", "01/01/2019", "12/31/2019", 1, 1, 1, 1);
	}

	@Test
	public void testGetProjectDto() {
		ProjectDTO actualDto = mapper.getProjectDto(project);
		assertEquals("01/01/2019", actualDto.getStartDate());
		assertEquals("12/31/2019", actualDto.getEndDate());
	}

	@Test
	public void testGetProject() {
		Project actual = mapper.getProject(projectDto);
		assertEquals("01/01/2019", actual.getStartDate());
		assertEquals("12/31/2019", actual.getEndDate());
	}

}
