package com.nytins.hystrix;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {

	private static Map<String, User> users = new HashMap<>();
	
	static {
		users.put("nytins", new User("nytins", "nytins@email.com"));
		users.put("john", new User("john", "john@email.com"));
	}
	
	public static User getUser(String userId) {
		return users.get(userId);
	}

}
