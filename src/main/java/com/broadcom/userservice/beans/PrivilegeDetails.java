package com.broadcom.userservice.beans;

public class PrivilegeDetails {
	int id;
	String name;
	
	public PrivilegeDetails(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Privilege [id=" + id + ", name=" + name + "]";
	}
	
}
