package com.broadcom.userservice.beans.RequestObjects;

public class AddRoleToGroupByIdReq {

	int roleId;
	int groupId;
	public AddRoleToGroupByIdReq(int roleId, int groupId) {
		super();
		this.roleId = roleId;
		this.groupId = groupId;
	}
	public int getRoleId() {
		return roleId;
	}
	public int getGroupId() {
		return groupId;
	}
	@Override
	public String toString() {
		return "AddRoleToGroupByIdReq [roleId=" + roleId + ", groupId=" + groupId + "]";
	}
}
