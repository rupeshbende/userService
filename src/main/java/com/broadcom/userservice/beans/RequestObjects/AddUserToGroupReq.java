package com.broadcom.userservice.beans.RequestObjects;

public class AddUserToGroupReq {
	String email;
	String group;
	public AddUserToGroupReq(String email, String group) {
		super();
		this.email = email;
		this.group = group;
	}
	public String getEmail() {
		return email;
	}
	public String getGroup() {
		return group;
	}
	@Override
	public String toString() {
		return "AddUserToGroupReq [email=" + email + ", group=" + group + "]";
	}
}
