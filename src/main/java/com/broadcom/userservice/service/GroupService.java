package com.broadcom.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadcom.userservice.beans.RequestObjects.Group;
import com.broadcom.userservice.dao.GroupDao;
import com.broadcom.userservice.dao.GroupRoleMapDao;
import com.broadcom.userservice.dao.UserGroupMapDao;

@Service
public class GroupService {

    @Autowired
    GroupDao groupDao;

    @Autowired
    GroupRoleMapDao groupRoleMapDao;

    @Autowired
    UserGroupMapDao userGroupMapDao;

    public int createGroup(Group group){
    	groupDao.addGroup(group);
    	return group.getId();
    }
    
    public void deleteGroup(int groupId) {
    	groupRoleMapDao.deleteRoleGroupMappingByGroupId(groupId);
    	userGroupMapDao.deleteUserGroupMappingByGroupId(groupId);
    	groupDao.deleteGroup(groupId);
    }
    
    public void updateGroup(Group group) {
    	groupDao.setName(group.getId(), group.getName());
    }
    
    public Group getGroup(int groupId) {
		return groupDao.getGroup(groupId);
	}
}
