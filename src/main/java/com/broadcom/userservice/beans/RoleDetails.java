package com.broadcom.userservice.beans;

import java.util.ArrayList;
import java.util.List;

public class RoleDetails {
	int id;
	String name;
	List<PrivilegeDetails> privileges;

	public RoleDetails(String name, PrivilegeDetails privilege) {
		instantiatePrivileges();
		privileges.add(privilege);
	}

	private void instantiatePrivileges() {
		privileges = new ArrayList<>();
	}
	
}
