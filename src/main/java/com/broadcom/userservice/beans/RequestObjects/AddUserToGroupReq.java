package com.broadcom.userservice.beans.RequestObjects;

public class AddUserToGroupReq {
	long userId;
	int groupId;
	
	public AddUserToGroupReq(long userId, int groupId) {
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
		return "AddUserToGroupReq [userId=" + userId + ", groupId=" + groupId + "]";
	}	
}
