package com.nytins.hystrix;

public class User {

	private String userId;
	private String email;

	public User(String userId, String email) {
		this.userId = userId;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}
	
	@Override
	public int hashCode() {
		return userId.length();
	}
	
	@Override
	public boolean equals(Object other) {
		return userId.equals(other);
	}

	public String getEmail() {
		return email;
	}
}
