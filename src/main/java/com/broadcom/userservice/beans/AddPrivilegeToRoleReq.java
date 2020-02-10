package com.broadcom.userservice.beans;

public class AddPrivilegeToRoleReq {
	String privilege;
	String Role;
	public AddPrivilegeToRoleReq(String privilege, String role) {
		super();
		this.privilege = privilege;
		Role = role;
	}
	public String getPrivilege() {
		return privilege;
	}
	public String getRole() {
		return Role;
	}
	@Override
	public String toString() {
		return "AddPrivilegeToRoleReq [privilege=" + privilege + ", Role=" + Role + "]";
	}
	
}
