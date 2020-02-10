package com.broadcom.userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadcom.userservice.beans.Group;
import com.broadcom.userservice.beans.Privilege;
import com.broadcom.userservice.beans.Role;
import com.broadcom.userservice.beans.User;
import com.broadcom.userservice.dao.service.GroupDaoService;
import com.broadcom.userservice.dao.service.PrivilegeDaoService;
import com.broadcom.userservice.dao.service.RoleDaoService;
import com.broadcom.userservice.dao.service.UserDaoService;
import com.broadcom.userservice.dao.service.UserGroupMapDaoService;
import com.broadcom.userservice.dao.service.UserRoleMapDaoService;

@Service
public class UserService {

	@Autowired
	UserDaoService userDao;

	@Autowired
	GroupDaoService groupDao;

	@Autowired
	RoleDaoService roleDao;

	@Autowired
	PrivilegeDaoService privilegeDao;

	@Autowired
	UserRoleMapDaoService userRoleMapDao;

	@Autowired
	UserGroupMapDaoService userGroupMapDao;

	@Autowired
	AssociationService associationService;

	public int createUser(User user) {
		userDao.addUser(user);
		return user.getId();
	}

	public void deleteUser(long userId) {
		deleteUserRoleMapping(userId);
		deleteUserGroupMapping(userId);
		deleteEmptyGroup(userId);
		userDao.deleteUser(userId);
	}

	private void deleteEmptyGroup(long userId) {
		List<Integer> groups = userGroupMapDao.getUserGroups(userId);
		groups.forEach(groupId -> {
			List<Long> usersOfGroup = userGroupMapDao.getUsersOfGroup(groupId);
			if (usersOfGroup == null || usersOfGroup.size() == 0) {
				groupDao.deleteGroup(groupId);
			}
		});
	}

	private void deleteUserGroupMapping(long userId) {
		userGroupMapDao.deleteUserGroupMappingByUserId(userId);
	}

	private void deleteUserRoleMapping(long userId) {
		userRoleMapDao.deleteUserRoleMappingByUserId(userId);
	}

	public void updateUser(User user) {
		if (user.getFirstName() != null)
			userDao.setFirstName(user.getId(), user.getFirstName());
		if (user.getLastName() != null)
			userDao.setLastName(user.getId(), user.getLastName());
	}

	public User getUser(long userId) {
		return userDao.getUser(userId);
	}

	public List<Group> getUserGroups(long userId) {
		List<Group> groups = new ArrayList<>();
		associationService.getUserGroups(userId).forEach(groupId -> groups.add(groupDao.getGroup(groupId)));
		return groups;
	}

	public List<Role> getUserRoles(long userId) {
		List<Role> roles = new ArrayList<>();
		List<Integer> roleIds = associationService.getAllRoleIdsOfUser(userId);
		roleIds.forEach(roleId -> {
			roles.add(roleDao.getRole(roleId));
		});
		return roles;
	}

	public List<Role> getUserRolesByEmail(String email) {
		User user = userDao.getUser(email);
		if (user != null) {
			return getUserRoles(user.getId());
		}
		return new ArrayList<Role>();
	}

	public List<Privilege> getUserPrivileges(long userId) {
		List<Privilege> privileges = new ArrayList<>();
		associationService.getUserPrivileges(userId)
				.forEach(privilegeId -> privileges.add(privilegeDao.getPrivilege(privilegeId)));
		return privileges;
	}

	public List<Privilege> getUserPrivilegesByEmail(String email) {
		User user = userDao.getUser(email);
		if (user != null) {
			return getUserPrivileges(user.getId());
		}
		return new ArrayList<Privilege>();
	}

}
