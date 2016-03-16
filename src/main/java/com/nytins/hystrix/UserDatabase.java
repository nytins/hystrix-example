package com.nytins.hystrix;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class UserDatabase {

	private Map<String, User> users = new HashMap<>();
	private boolean forceException = false;
	
	@PostConstruct
	private void init() {
		users.put("nytins", new User("nytins", "nytins@email.com"));
		users.put("john", new User("john", "john@email.com"));
	}
	
	public User getUser(String userId) {
		if (forceException) throw new RuntimeException("forced exception");
		return users.get(userId);
	}

	public Collection<User> getAllUsers() {
		if (forceException) throw new RuntimeException("forced exception");
		return users.values();
	}

	public void forceException(boolean forceException) {
		this.forceException = forceException;
	}

}
