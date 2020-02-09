package com.broadcom.userservice.beans;

import java.util.ArrayList;
import java.util.List;

public class GroupDetails {
	int id;
	String name;
	UserDetails admin;
	List<UserDetails> users;
	List<RoleDetails> roles;
	
	public GroupDetails(String name, UserDetails admin) {
		this.admin = admin;
		instancetiateUserAndRoles();
	}

	private void instancetiateUserAndRoles() {
		users = new ArrayList<>();
		roles = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserDetails getAdmin() {
		return admin;
	}

	public void setAdmin(UserDetails admin) {
		this.admin = admin;
	}

	public List<UserDetails> getUsers() {
		return users;
	}

	public void setUsers(List<UserDetails> users) {
		this.users = users;
	}

	public List<RoleDetails> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDetails> roles) {
		this.roles = roles;
	}
}
