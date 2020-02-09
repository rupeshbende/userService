package com.broadcom.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadcom.userservice.beans.RequestObjects.User;
import com.broadcom.userservice.dao.GroupDao;
import com.broadcom.userservice.dao.UserDao;
import com.broadcom.userservice.dao.UserGroupMapDao;
import com.broadcom.userservice.dao.UserRoleMapDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	GroupDao groupDao;
	
	@Autowired
	UserRoleMapDao userRoleMapDao;
	
	@Autowired
	UserGroupMapDao userGroupMapDao;
	
	public int createUser(User user) {
		userDao.addUser(user);
		return user.getId();
	}
	
    public void deleteUser(int userId) {
    	userRoleMapDao.deleteUserRoleMappingByUserId(userId);
    	userGroupMapDao.deleteUserGroupMappingByUserId(userId);
    	List<Integer> groups = userGroupMapDao.getUserGroups(userId);
    	groups.forEach(groupId -> {
    		List<Long> usersOfGroup = userGroupMapDao.getUsersOfGroup(groupId);
    		if(usersOfGroup==null || usersOfGroup.size()==0) {
    			groupDao.deleteGroup(groupId);
    		}
    	});
    	userDao.deleteUser(userId);
    }
    
    public void updateUser(User user) {
    	if(user.getFirstName()!=null)
    		userDao.setFirstName(user.getId(), user.getFirstName());
    	if(user.getLastName()!=null)
    		userDao.setLastName(user.getId(), user.getLastName());
    }
    
    public User getUser(long userId) {
		return userDao.getUser(userId);
	}
}
