package com.broadcom.userservice.beans;

import java.util.ArrayList;
import java.util.List;

public class User {
	long id;
	String firstName;
	String lastName;
	String email;
	List<Role> roles;
	
	public User(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		instantiateRoles();
	}
	
	public User(String email) {
		this.email = email;
		instantiateRoles();
	}
	
	private void instantiateRoles(){
		roles = new ArrayList<>();
	}
}
