package com.broadcom.userservice.beans;

public class AddPrivilegeToRoleByIdReq {
	int privilegeId;
	int roleId;
	public AddPrivilegeToRoleByIdReq(int privilegeId, int roleId) {
		super();
		this.privilegeId = privilegeId;
		this.roleId = roleId;
	}
	public int getPrivilegeId() {
		return privilegeId;
	}
	public int getRoleId() {
		return roleId;
	}
	@Override
	public String toString() {
		return "AddPrivilegeToRoleByIdReq [privilegeId=" + privilegeId + ", roleId=" + roleId + "]";
	}
}
