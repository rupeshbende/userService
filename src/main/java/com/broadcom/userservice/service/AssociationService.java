package com.broadcom.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadcom.userservice.beans.RequestObjects.AddPrivilegeToRoleByIdReq;
import com.broadcom.userservice.beans.RequestObjects.AddPrivilegeToRoleReq;
import com.broadcom.userservice.beans.RequestObjects.AddRoleToGroupByIdReq;
import com.broadcom.userservice.beans.RequestObjects.AddRoleToGroupReq;
import com.broadcom.userservice.beans.RequestObjects.AddRoleToUserByIdReq;
import com.broadcom.userservice.beans.RequestObjects.AddRoleToUserReq;
import com.broadcom.userservice.beans.RequestObjects.AddUserToGroupByIdReq;
import com.broadcom.userservice.beans.RequestObjects.AddUserToGroupReq;
import com.broadcom.userservice.beans.RequestObjects.Group;
import com.broadcom.userservice.beans.RequestObjects.Privilege;
import com.broadcom.userservice.beans.RequestObjects.Role;
import com.broadcom.userservice.beans.RequestObjects.User;
import com.broadcom.userservice.dao.GroupDao;
import com.broadcom.userservice.dao.GroupRoleMapDao;
import com.broadcom.userservice.dao.PrivilegeDao;
import com.broadcom.userservice.dao.RoleDao;
import com.broadcom.userservice.dao.RolePrivilegesMapDao;
import com.broadcom.userservice.dao.UserDao;
import com.broadcom.userservice.dao.UserGroupMapDao;
import com.broadcom.userservice.dao.UserRoleMapDao;

@Service
public class AssociationService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	GroupDao groupDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	PrivilegeDao privilegeDao;
	
	@Autowired
	GroupRoleMapDao groupRoleMapDao;
	
	@Autowired
	RolePrivilegesMapDao rolePrivilegesMapDao;
	
	@Autowired
	UserGroupMapDao userGroupMapDao;
	
	@Autowired
	UserRoleMapDao userRoleMapDao;
	
	public void addUserToGroup(AddUserToGroupByIdReq addUserToGroupByIdReq) {
		userGroupMapDao.addUserToGroup(addUserToGroupByIdReq.getUserId(), addUserToGroupByIdReq.getGroupId());
	}
	
	public void addRoleToGroup(AddRoleToGroupByIdReq addRoleToGroupByIdReq) {
		
		groupRoleMapDao.addRoleToGroup(addRoleToGroupByIdReq.getRoleId(), addRoleToGroupByIdReq.getGroupId());
	}
	
	public void addRoleToUser(AddRoleToUserByIdReq addRoleToUserByIdReq) {
		userRoleMapDao.addRoleToUser(addRoleToUserByIdReq.getUserId(), addRoleToUserByIdReq.getRoleId());
	}
	
	public void addPrivilegeToRole(AddPrivilegeToRoleByIdReq addPrivilegeToRoleByIdReq) {
		rolePrivilegesMapDao.addPrivilegeToRole(addPrivilegeToRoleByIdReq.getRoleId(), addPrivilegeToRoleByIdReq.getPrivilegeId());
	}
	
	public void addUserToGroup(AddUserToGroupReq addUserToGroupReq) {
		User user = userDao.getUser(addUserToGroupReq.getEmail());
		Group group = groupDao.getGroup(addUserToGroupReq.getGroup());
		userGroupMapDao.addUserToGroup(user.getId(), group.getId());
	}
	
	public void addRoleToGroup(AddRoleToGroupReq addRoleToGroupReq) {
		Role role = roleDao.getRole(addRoleToGroupReq.getRole());
		Group group = groupDao.getGroup(addRoleToGroupReq.getGroup());
		groupRoleMapDao.addRoleToGroup(role.getId(), group.getId());
	}
	
	public void addRoleToUser(AddRoleToUserReq addRoleToUserByIdReq) {
		User user = userDao.getUser(addRoleToUserByIdReq.getEmail());
		Role role = roleDao.getRole(addRoleToUserByIdReq.getRole());
		userRoleMapDao.addRoleToUser(user.getId(), role.getId());
	}
	
	public void addPrivilegeToRole(AddPrivilegeToRoleReq addPrivilegeToRoleReq) {
		Role role = roleDao.getRole(addPrivilegeToRoleReq.getRole());
		Privilege privilege = privilegeDao.getPrivilege(addPrivilegeToRoleReq.getPrivilege());
		rolePrivilegesMapDao.addPrivilegeToRole(role.getId(), privilege.getId());
	}
}
