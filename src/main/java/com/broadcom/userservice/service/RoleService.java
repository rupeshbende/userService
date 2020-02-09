package com.broadcom.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadcom.userservice.beans.RequestObjects.Role;
import com.broadcom.userservice.dao.RoleDao;
import com.broadcom.userservice.dao.RolePrivilegesMapDao;
import com.broadcom.userservice.dao.UserRoleMapDao;

@Service
public class RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Autowired
	RolePrivilegesMapDao rolePrivilegesMapDao;
	
	@Autowired
	UserRoleMapDao userRoleMapDao;
	
	public int createRole(Role role) {
		roleDao.addRole(role);
		return role.getId();
	}
	
    public void deleteRole(int roleId) {
    	rolePrivilegesMapDao.deletePrivilegeRoleMappingByRoleId(roleId);
    	userRoleMapDao.deleteUserRoleMappingByRoleId(roleId);
    	roleDao.deleteRole(roleId);
    }
    
    public void updateRole(Role role) {
    	roleDao.setName(role.getId(), role.getName());
    }
    
    public Role getRole(int roleId) {
		return roleDao.getRole(roleId);
	}
}
