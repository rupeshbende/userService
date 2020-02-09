package com.broadcom.userservice.beans;

public class User {
	long id;
	String firstName;
	String lastName;
	String email;
	
	public User(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public User(String email) {
		this.email = email;
	}
}
