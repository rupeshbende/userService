package com.broadcom.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadcom.userservice.beans.RequestObjects.Group;
import com.broadcom.userservice.beans.RequestObjects.Privilege;
import com.broadcom.userservice.dao.PrivilegeDao;
import com.broadcom.userservice.dao.RolePrivilegesMapDao;

@Service
public class PrivilegeService {

	@Autowired
	PrivilegeDao privilegeDao;
	
	@Autowired
	RolePrivilegesMapDao rolePrivilegesMapDao;
	
	public int createPrivilege(Privilege privilege) {
		privilegeDao.addPrivilege(privilege);
		return privilege.getId();
	}
	
    public void deletePrivilege(int privilegeId) {
    	rolePrivilegesMapDao.deletePrivilegeRoleMappingByPrivilegeId(privilegeId);
    	privilegeDao.deletePrivilege(privilegeId);
    }
    
    public void updateGroup(Group group) {
    	privilegeDao.setName(group.getId(), group.getName());
    }
    
    public Privilege getGroup(int privilegeId) {
		return privilegeDao.getPrivilege(privilegeId);
	}
}
