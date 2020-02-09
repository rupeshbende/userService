package com.broadcom.userservice.beans.RequestObjects;

public class AddRoleToUserReq {
	String role;
	String email;
	public AddRoleToUserReq(String role, String email) {
		super();
		this.role = role;
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "AddRoleToUserReq [role=" + role + ", email=" + email + "]";
	}
}
