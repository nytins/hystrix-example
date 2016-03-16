package com.nytins.hystrix;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class UserDatabase {

	private Map<String, User> users = new HashMap<>();
	
	@PostConstruct
	private void init() {
		users.put("nytins", new User("nytins", "nytins@email.com"));
		users.put("john", new User("john", "john@email.com"));
	}
	
	public User getUser(String userId) {
		return users.get(userId);
	}

}
