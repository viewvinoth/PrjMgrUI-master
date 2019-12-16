package com.springboot.rest.restservice.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaskTest {

Task task;
	@Before
	public void setUp() throws Exception {
		task = new Task();
	}

	@Test
	public void testGetTask_id() {
		task.setTask_id(1234);
		assertEquals(1234, task.getTask_id());
	}

	@Test
	public void testGetParent_id() {
		task.setParent_id(1234);
		assertEquals(1234, task.getParent_id());
	}

	@Test
	public void testGetProject_id() {
		task.setProject_id(1234);
		assertEquals(1234, task.getProject_id());
	}

	@Test
	public void testGetTask() {
		task.setTask("Task");
		assertEquals("Task", task.getTask());
	}

	@Test
	public void testGetStart_date() {
		task.setStart_date("01/01/2019");
		assertEquals("01/01/2019", task.getStart_date());
	}

	@Test
	public void testGetEnd_date() {
		task.setEnd_date("12/31/2019");
		assertEquals("12/31/2019", task.getEnd_date());
	}

	@Test
	public void testGetPriority() {
		task.setPriority(12);
		assertEquals(12, task.getPriority());
	}

	@Test
	public void testGetStatus() {
		task.setStatus("open");
		assertEquals("open", task.getStatus());
		}

	@Test
	public void testGetUserId() {
		task.setUserId(1);
		assertEquals(1, task.getUserId());
	}

}
