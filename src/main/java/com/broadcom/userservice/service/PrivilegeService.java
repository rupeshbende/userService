package com.broadcom.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadcom.userservice.beans.Privilege;
import com.broadcom.userservice.dao.service.PrivilegeDaoService;
import com.broadcom.userservice.dao.service.RolePrivilegesMapDaoService;

@Service
public class PrivilegeService {

	@Autowired
	PrivilegeDaoService privilegeDao;
	
	@Autowired
	RolePrivilegesMapDaoService rolePrivilegesMapDao;
	
	public int createPrivilege(Privilege privilege) {
		privilegeDao.addPrivilege(privilege);
		return privilege.getId();
	}
	
    public void deletePrivilege(int privilegeId) {
    	rolePrivilegesMapDao.deletePrivilegeRoleMappingByPrivilegeId(privilegeId);
    	privilegeDao.deletePrivilege(privilegeId);
    }
    
    public void updatePrivilege(Privilege privilege) {
    	privilegeDao.setName(privilege.getId(), privilege.getName());
    }
    
    public Privilege getPrivilege(int privilegeId) {
		return privilegeDao.getPrivilege(privilegeId);
	}
}
