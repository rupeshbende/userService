package com.broadcom.userservice.beans;

import java.util.ArrayList;
import java.util.List;

public class Role {
	int id;
	String name;
	List<Privilege> privileges;

	public Role(String name, Privilege privilege) {
		instantiatePrivileges();
		privileges.add(privilege);
	}

	private void instantiatePrivileges() {
		privileges = new ArrayList<>();
	}
	
}
