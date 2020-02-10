package com.broadcom.userservice.beans;

public class AddUserToGroupByIdReq {
	long userId;
	int groupId;
	public AddUserToGroupByIdReq(long userId, int groupId) {
		super();
		this.userId = userId;
		this.groupId = groupId;
	}
	public long getUserId() {
		return userId;
	}
	public int getGroupId() {
		return groupId;
	}
	@Override
	public String toString() {
		return "AddUserToGroupByIdReq [userId=" + userId + ", groupId=" + groupId + "]";
	}
}
