package com.broadcom.userservice.beans;

import java.util.ArrayList;
import java.util.List;

public class Role {
	List<Privilege> privileges;

	public Role(Privilege privilege) {
		privileges = new ArrayList<>();
		privileges.add(privilege);
	}
	
}
