package com.nytins.hystrix;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class UserServiceTest {
	
	private UserService service = new UserService();

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
