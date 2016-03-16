package com.nytins.hystrix;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserDatabaseTest {
	
	@Autowired
	private UserDatabase database;

	@Test
	public void getUser() {
		database.forceException(false);
		assertThat(database.getUser("nytins").getEmail(), is("nytins@email.com"));
	}
	
	@Test
	public void totalUsersAvailable() {
		database.forceException(false);
		assertThat(database.getAllUsers().size(), is(2));
	}
	
	@Test(expected = RuntimeException.class)
	public void throwException() {
		database.forceException(true);
		database.getAllUsers();
	}

}
