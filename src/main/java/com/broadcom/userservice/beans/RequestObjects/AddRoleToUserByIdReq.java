package com.broadcom.userservice.beans.RequestObjects;

public class AddRoleToUserByIdReq {
	int roleId;
	long userId;
	public AddRoleToUserByIdReq(int roleId, long userId) {
		super();
		this.roleId = roleId;
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public long getUserId() {
		return userId;
	}
	@Override
	public String toString() {
		return "AddRoleToUserByIdReq [roleId=" + roleId + ", userId=" + userId + "]";
	}
}
