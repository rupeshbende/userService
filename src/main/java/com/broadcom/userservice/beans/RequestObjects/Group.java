package com.broadcom.userservice.beans.RequestObjects;

public class Group {
	int id;
	String name;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
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
		return "Group [id=" + id + ", name=" + name + "]";
	}
	
}
