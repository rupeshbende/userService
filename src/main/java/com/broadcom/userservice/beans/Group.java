package com.broadcom.userservice.beans;

import java.util.ArrayList;
import java.util.List;

public class Group {
	User admin;
	List<User> users;
	List<Role> roles;
	
	public Group(User admin) {
		this.admin = admin;
		users = new ArrayList<>();
		roles = new ArrayList<>();
	}
}
