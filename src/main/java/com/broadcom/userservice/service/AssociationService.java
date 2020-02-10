package com.broadcom.userservice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadcom.userservice.beans.AddPrivilegeToRoleByIdReq;
import com.broadcom.userservice.beans.AddPrivilegeToRoleReq;
import com.broadcom.userservice.beans.AddRoleToGroupByIdReq;
import com.broadcom.userservice.beans.AddRoleToGroupReq;
import com.broadcom.userservice.beans.AddRoleToUserByIdReq;
import com.broadcom.userservice.beans.AddRoleToUserReq;
import com.broadcom.userservice.beans.AddUserToGroupByIdReq;
import com.broadcom.userservice.beans.AddUserToGroupReq;
import com.broadcom.userservice.beans.Group;
import com.broadcom.userservice.beans.Privilege;
import com.broadcom.userservice.beans.Role;
import com.broadcom.userservice.beans.User;
import com.broadcom.userservice.dao.service.GroupDaoService;
import com.broadcom.userservice.dao.service.GroupRoleMapDaoService;
import com.broadcom.userservice.dao.service.PrivilegeDaoService;
import com.broadcom.userservice.dao.service.RoleDaoService;
import com.broadcom.userservice.dao.service.RolePrivilegesMapDaoService;
import com.broadcom.userservice.dao.service.UserDaoService;
import com.broadcom.userservice.dao.service.UserGroupMapDaoService;
import com.broadcom.userservice.dao.service.UserRoleMapDaoService;

@Service
public class AssociationService {

	@Autowired
	UserDaoService userDao;
	
	@Autowired
	GroupDaoService groupDao;
	
	@Autowired
	RoleDaoService roleDao;
	
	@Autowired
	PrivilegeDaoService privilegeDao;
	
	@Autowired
	GroupRoleMapDaoService groupRoleMapDao;
	
	@Autowired
	RolePrivilegesMapDaoService rolePrivilegesMapDao;
	
	@Autowired
	UserGroupMapDaoService userGroupMapDao;
	
	@Autowired
	UserRoleMapDaoService userRoleMapDao;
	
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
		Group group = groupDao.getGroupByName(addUserToGroupReq.getGroup());
		userGroupMapDao.addUserToGroup(user.getId(), group.getId());
	}
	
	public void addRoleToGroup(AddRoleToGroupReq addRoleToGroupReq) {
		Role role = roleDao.getRole(addRoleToGroupReq.getRole());
		Group group = groupDao.getGroupByName(addRoleToGroupReq.getGroup());
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
	
	public List<Integer> getUserGroups(long userId) {
		return userGroupMapDao.getUserGroups(userId);
	}
	
	public List<Integer> getGroupPrivileges(int groupId) {
		Set<Integer> privilegeIds = new HashSet<>();
		groupRoleMapDao.getGroupRoles(groupId).forEach(roleId->privilegeIds.addAll(rolePrivilegesMapDao.getRolePrivileges(roleId)));
		return new ArrayList<Integer>(privilegeIds);
	}
	
	public List<Integer> getAllRoleIdsOfUser(long userId) {
		Set<Integer> roleIdsSet = new HashSet<>();
		roleIdsSet.addAll(userRoleMapDao.getUserRoles(userId));
		userGroupMapDao.getUserGroups(userId).forEach(groupId -> {
			roleIdsSet.addAll(groupRoleMapDao.getGroupRoles(groupId));
		});
		return new ArrayList<Integer>(roleIdsSet);
	}
	
	public List<Integer> getUserPrivileges(long userId){
		Set<Integer> privilegeIds = new HashSet<>();
		getAllRoleIdsOfUser(userId)
				.forEach(roleId -> privilegeIds.addAll(rolePrivilegesMapDao.getRolePrivileges(roleId)));
		return new ArrayList<>(privilegeIds);
	}

}
