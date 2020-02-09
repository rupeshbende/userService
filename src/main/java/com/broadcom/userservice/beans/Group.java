package com.broadcom.userservice.beans;

import java.util.ArrayList;
import java.util.List;

public class Group {
	int id;
	String name;
	User admin;
	List<User> users;
	List<Role> roles;
	
	public Group(String name, User admin) {
		this.admin = admin;
		instancetiateUserAndRoles();
	}

	private void instancetiateUserAndRoles() {
		users = new ArrayList<>();
		roles = new ArrayList<>();
	}
}
