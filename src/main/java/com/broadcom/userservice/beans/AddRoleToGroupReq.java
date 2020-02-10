package com.broadcom.userservice.beans;

public class AddRoleToGroupReq {

	String role;
	String group;
	public AddRoleToGroupReq(String role, String group) {
		super();
		this.role = role;
		this.group = group;
	}
	public String getRole() {
		return role;
	}
	public String getGroup() {
		return group;
	}
	@Override
	public String toString() {
		return "AddRoleToGroupReq [role=" + role + ", group=" + group + "]";
	}

}
