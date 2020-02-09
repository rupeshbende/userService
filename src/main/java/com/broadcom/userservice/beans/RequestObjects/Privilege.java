package com.broadcom.userservice.beans.RequestObjects;

public class Privilege {
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
		return "Privilege [id=" + id + ", name=" + name + "]";
	}
	
}
