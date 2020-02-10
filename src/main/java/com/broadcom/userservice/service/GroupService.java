package com.broadcom.userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadcom.userservice.beans.Group;
import com.broadcom.userservice.beans.Privilege;
import com.broadcom.userservice.beans.User;
import com.broadcom.userservice.dao.service.GroupDaoService;
import com.broadcom.userservice.dao.service.GroupRoleMapDaoService;
import com.broadcom.userservice.dao.service.PrivilegeDaoService;
import com.broadcom.userservice.dao.service.UserDaoService;
import com.broadcom.userservice.dao.service.UserGroupMapDaoService;

@Service
public class GroupService {

	@Autowired
	GroupDaoService groupDao;

	@Autowired
	UserDaoService userDao;

	@Autowired
	PrivilegeDaoService privilegeDao;

	@Autowired
	GroupRoleMapDaoService groupRoleMapDao;

	@Autowired
	UserGroupMapDaoService userGroupMapDao;

	@Autowired
	AssociationService associationService;

	public int createGroup(Group group) {
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

	public List<Privilege> getGroupPrivileges(int groupId) {
		List<Privilege> privileges = new ArrayList<>();
		associationService.getGroupPrivileges(groupId)
				.forEach(privilegeId -> privileges.add(privilegeDao.getPrivilege(privilegeId)));
		return privileges;
	}

	public List<User> getGroupUsers(int groupId) {
		List<User> users = new ArrayList<>();
		userGroupMapDao.getUsersOfGroup(groupId).forEach(userId -> users.add(userDao.getUser(userId)));
		return users;
	}
}
