package com.nytins.hystrix;

public class UserService {
	
	public User getUser(String userId) {
		return UserDatabase.getUser(userId);
	}

}
