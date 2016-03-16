package com.nytins.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {
	
	@Autowired
	private UserDatabase database;
	
	@HystrixCommand(fallbackMethod="getUserFallback")
	public User getUser(String userId) {
		return database.getUser(userId);
	}

	public User getUserFallback(String userId) {
		return null;
	}

}
