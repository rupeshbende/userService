package com.broadcom.userservice.beans.RequestObjects;

public class AddRoleToUserReq {
	String role;
	long user;
	
	public AddRoleToUserReq(String role, long user) {
		super();
		this.role = role;
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public long getUser() {
		return user;
	}
	@Override
	public String toString() {
		return "AddRoleToUserReq [role=" + role + ", user=" + user + "]";
	}
	
}
