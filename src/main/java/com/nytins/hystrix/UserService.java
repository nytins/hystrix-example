package com.nytins.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDatabase database;
	
	public User getUser(String userId) {
		return database.getUser(userId);
	}

}
