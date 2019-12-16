package com.springboot.rest.restservice.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import com.springboot.rest.restservice.entity.User;
import com.springboot.rest.restservice.repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class UserServiceTest {

	@Autowired
	IUserService userService;
	
	@MockBean
	UserRepository userRepository;
	
	User user;
List<User> userList;
Iterable<User> userIterable;
Optional<User> optUser;
	@Before
	public void setUp() throws Exception {
		user= new User();
		optUser = Optional.of(user);
		userList = new ArrayList<User>();
		userList.add(user);
		userIterable = new Iterable<User>() {
			
			@Override
			public Iterator<User> iterator() {
				// TODO Auto-generated method stub
				return userList.iterator();
			}
		};
	}

	@Test
	public void testRetrieveAllUsers() {
		/* fail("Not yet implemented"); */
		Mockito.when(userRepository.findAll()).thenReturn(userIterable);
		Iterable<User> iterable = userService.retrieveAllUsers();
		assertNotNull(iterable);
	}

	@Test
	public void testRetrieveUserById() {
		/*fail("Not yet implemented");*/
		Mockito.when(userRepository.findById(1)).thenReturn(optUser);
		Optional<User> actualUser = userService.retrieveUserById(1);
		assertNotNull(actualUser);
	}

}
