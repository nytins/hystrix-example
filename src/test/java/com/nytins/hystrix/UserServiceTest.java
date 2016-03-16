package com.nytins.hystrix;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserServiceTest {
	
	@Autowired
	private UserService service;

	@Test
	public void getUserWithNullUserId() {
		assertEquals(null, service.getUser(null));
	}
	
	@Test
	public void getUserWithGoodUserId() {
		User expected = new User("nytins", "nytins@email.com");
		User actual = service.getUser("nytins");
		assertThat(actual.getEmail(), is(expected.getEmail()));
	}
}
