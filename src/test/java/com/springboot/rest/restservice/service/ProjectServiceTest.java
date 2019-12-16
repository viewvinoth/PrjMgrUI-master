package com.springboot.rest.restservice.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.rest.restservice.TestConfiguration;
import com.springboot.rest.restservice.dto.ProjectDTO;
import com.springboot.rest.restservice.dto.TaskDTO;
import com.springboot.rest.restservice.entity.Project;
import com.springboot.rest.restservice.mapper.ProjectDTOMapper;
import com.springboot.rest.restservice.repository.ProjectRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class ProjectServiceTest {

	@Autowired
	IProjectService projectService;

	@MockBean
	ProjectRepository projectRepository;

	@MockBean
	ITaskService taskService;

	@MockBean
	ProjectDTOMapper mapper;

	ProjectDTO projectDto;
	List<ProjectDTO> prjList;
	Project project;
	Optional<Project> projectOpt;
	Iterable<Project> prjIterable;
	List<Project> projectList;
	TaskDTO taskDto;
	List<TaskDTO> taskList;

	@Before
	public void setUp() throws Exception {
		projectDto = new ProjectDTO(1, "project", "01/01/2019", "12/31/2019", 1, 1, 1, 1);
		taskDto = new TaskDTO(1, 1, 1, "task", "01/01/2019", "12/31/2019", 1, "completed", 1, "parentTask");
		taskList = new ArrayList<TaskDTO>();
		taskList.add(taskDto);
		prjList = new ArrayList<ProjectDTO>();
		prjList.add(projectDto);
		project = new Project(1, "project", "01/01/2019", "12/31/2019", 1, 1);
		projectList = new ArrayList<Project>();
		projectList.add(project);
		projectOpt = Optional.of(project);
		prjIterable = new Iterable<Project>() {

			@Override
			public Iterator<Project> iterator() {
				// TODO Auto-generated method stub
				return projectList.iterator();
			}
		};
	}

	@Test
	public void testRetrieveAllProjects() {
		Mockito.when(projectRepository.findAll()).thenReturn(prjIterable);
		Mockito.when(taskService.retrieveAllTasks(1)).thenReturn(taskList);
		Mockito.when(mapper.getProjectDto(project)).thenReturn(projectDto);
		List<ProjectDTO> actualList = projectService.retrieveAllProjects();
		assertEquals(1, actualList.size());

	}

	@Test
	@Ignore
	public void testRetrieveProjectById() {
		Mockito.when(projectRepository.findById(1)).thenReturn(projectOpt);
		ProjectDTO actualDto = projectService.retrieveProjectById(1);
		assertEquals("01/01/2019", actualDto.getStartDate());
		assertEquals("12/31/2019", actualDto.getEndDate());
	}

	@Test
	@Ignore
	public void testCreateProject() {
		Mockito.when(projectRepository.save(project)).thenReturn(project);
		Mockito.when(mapper.getProject(projectDto)).thenReturn(project);
		ProjectDTO actualDto = projectService.createProject(projectDto);
		
		assertEquals("01/01/2019", actualDto.getStartDate());
		assertEquals("12/31/2019", actualDto.getEndDate());
	}

	@Test
	@Ignore
	public void testEditProject() {
		Mockito.when(projectRepository.save(project)).thenReturn(project);
		ProjectDTO actualDto = projectService.editProject(projectDto);
		assertEquals("01/01/2019", actualDto.getStartDate());
		assertEquals("12/31/2019", actualDto.getEndDate());
	}

	@Test
	public void testDeleteProject() {
		/* fail("Not yet implemented"); */
		projectService.deleteProject(1);
	}

}
