package com.springboot.rest.restservice.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	User user;

	@Before
	public void setUp() throws Exception {
		user = new User();
	}

	@Test
	public void testGetUserId() {
		user.setUserId(1);
		assertEquals(1, user.getUserId());
	}

	@Test
	public void testGetFirstName() {
		user.setFirstName("Bala");
		assertEquals("Bala", user.getFirstName());
	}

	@Test
	public void testGetLastName() {
		user.setLastName("Jeeva");
		assertEquals("Jeeva", user.getLastName());
	}

	@Test
	public void testGetEmployeeId() {
		user.setEmployeeId("287445");
		assertEquals("287445", user.getEmployeeId());
	}

}
