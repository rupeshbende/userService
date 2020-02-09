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

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", roles=" + roles + "]";
	}
	
	
}
