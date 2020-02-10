package com.broadcom.userservice.service;

import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

public class UserServiceTest {

	@Mock
	UserDaoService userDao;

	@Mock
	GroupDaoService groupDao;

	@Mock
	RoleDaoService roleDao;

	@Mock
	PrivilegeDaoService privilegeDao;

	@Mock
	UserRoleMapDaoService userRoleMapDao;

	@Mock
	UserGroupMapDaoService userGroupMapDao;

	@Mock
	AssociationService associationService;

	@InjectMocks
	UserService service;

	@BeforeTest
	public void beforeTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createUserTest_validUser_assertUserId() {
		Mockito.doNothing().when(userDao).addUser(Mockito.any());
		User user = new User();
		user.setEmail("bac@zxc.com");
		user.setId(1);
		assertEquals(service.createUser(user), 1);
	}

	@Test
	public void deleteUserTest_validUser_asserNoException() {
		Mockito.doNothing().when(userDao).deleteUser(Mockito.anyLong());
		Mockito.doNothing().when(userRoleMapDao).deleteUserRoleMappingByUserId(Mockito.anyLong());
		Mockito.doNothing().when(userGroupMapDao).deleteUserGroupMappingByUserId(Mockito.anyLong());
		Mockito.doNothing().when(groupDao).deleteGroup(Mockito.anyInt());
		List<Integer> groupIds = new ArrayList<>();
		groupIds.add(1);
		groupIds.add(2);
		groupIds.add(3);
		Mockito.when(userGroupMapDao.getUserGroups(Mockito.anyLong())).thenReturn(groupIds);
		List<Long> userIds = new ArrayList<Long>();
		Mockito.when(userGroupMapDao.getUsersOfGroup(1)).thenReturn(userIds);
		Mockito.when(userGroupMapDao.getUsersOfGroup(2)).thenReturn(new ArrayList<Long>());
		Mockito.when(userGroupMapDao.getUsersOfGroup(3)).thenReturn(null);
		service.deleteUser(123);
	}
	
	@Test
	public void updateUserTest_validFirstNameNullLastName_assertNoException() {
		Mockito.doNothing().when(userDao).setFirstName(Mockito.anyLong(), Mockito.anyString());
		User user = new User();
		user.setEmail("bac@zxc.com");
		user.setId(1);
		user.setFirstName("abc");
		service.updateUser(user);
	}
	
	@Test
	public void updateUserTest_nullFirstNameValidLastName_assertNoException() {
		Mockito.doNothing().when(userDao).setLastName(Mockito.anyLong(), Mockito.anyString());
		User user = new User();
		user.setEmail("bac@zxc.com");
		user.setId(1);
		user.setLastName("abc");
		service.updateUser(user);
	}
	
	@Test
	public void getUser_validCall_assertUserId() {
		User user = new User();
		user.setId(123);
		user.setEmail("bac@zxc.com");
		Mockito.when(userDao.getUser(Mockito.anyLong())).thenReturn(user);
		assertEquals(service.getUser(123).getEmail(), "bac@zxc.com");
	}
	
	@Test
	public void getUser_userNotPresent_assertNull() {
		Mockito.when(userDao.getUser(Mockito.anyLong())).thenReturn(null);
		assertNull(service.getUser(123));
	}
	
	@Test
	public void getUserGroupsTest_validCall_assertGroupSize() {
		List<Integer> groupIds = new ArrayList<Integer>();
		groupIds.add(1);
		Mockito.when(associationService.getUserGroups(Mockito.anyLong())).thenReturn(groupIds);
		Group group = new Group();
		group.setId(1);
		group.setName("admin");
		Mockito.when(groupDao.getGroup(Mockito.anyInt())).thenReturn(group);
		assertEquals(service.getUserGroups(123).size(), 1);
	}
	
	@Test
	public void getUserGroupsTest_noUserGroup_assertGroupSize() {
		List<Integer> groupIds = new ArrayList<Integer>();
		Mockito.when(associationService.getUserGroups(Mockito.anyLong())).thenReturn(groupIds);
		assertEquals(service.getUserGroups(123).size(), 0);
	}
	
	@Test
	public void getUserRoleTest_validCall_assertRoleSize() {
		List<Integer> roleIds = new ArrayList<Integer>();
		roleIds.add(1);
		Mockito.when(associationService.getAllRoleIdsOfUser(Mockito.anyLong())).thenReturn(roleIds);
		Role role = new Role();
		role.setId(1);
		role.setName("admin");
		Mockito.when(roleDao.getRole(Mockito.anyInt())).thenReturn(role);
		assertEquals(service.getUserRoles(123).size(), 1);
	}

	@Test
	public void getUserRolesTest_noUserRole_assertRoleSize() {
		Mockito.when(associationService.getAllRoleIdsOfUser(Mockito.anyLong())).thenReturn(new ArrayList<Integer>());
		assertEquals(service.getUserRoles(123).size(), 0);
	}
	
	@Test
	public void getUserRolesByEmailTest_userNotPresent_assertRoleSize() {
		Mockito.when(userDao.getUser(Mockito.anyString())).thenReturn(null);
		assertEquals(service.getUserRolesByEmail("any@email.com").size(), 0);
	}

	@Test
	public void getUserRolesByEmailTest_validCall_assertRoleSize() {
		User user = new User();
		user.setId(123);
		user.setEmail("any@email.com");
		Mockito.when(userDao.getUser(Mockito.anyString())).thenReturn(user);
		Mockito.when(associationService.getAllRoleIdsOfUser(Mockito.anyLong())).thenReturn(new ArrayList<Integer>());
		assertEquals(service.getUserRolesByEmail("any@email.com").size(), 0);
	}

	@Test
	public void getUserPrivilegeTest_validCall_assertPrivilegeSize() {
		List<Integer> privilegeIds = new ArrayList<Integer>();
		privilegeIds.add(1);
		Mockito.when(associationService.getUserPrivileges(Mockito.anyLong())).thenReturn(privilegeIds);
		Privilege privilege = new Privilege();
		privilege.setId(1);
		privilege.setName("admin");
		Mockito.when(privilegeDao.getPrivilege(Mockito.anyInt())).thenReturn(privilege);
		assertEquals(service.getUserPrivileges(123).size(), 1);
	}

	@Test
	public void getUserPrivilegesTest_noUserPrivilege_assertPrivilegeSize() {
		Mockito.when(associationService.getUserPrivileges(Mockito.anyLong())).thenReturn(new ArrayList<Integer>());
		assertEquals(service.getUserPrivileges(123).size(), 0);
	}
	
	@Test
	public void getUserPrivilegesByEmailTest_userNotPresent_assertPrivilegeSize() {
		Mockito.when(userDao.getUser(Mockito.anyString())).thenReturn(null);
		assertEquals(service.getUserPrivilegesByEmail("any@email.com").size(), 0);
	}

	@Test
	public void getUserPrivilegeByEmailTest_validCall_assertPrivilegeSize() {
		User user = new User();
		user.setId(123);
		user.setEmail("any@email.com");
		Mockito.when(userDao.getUser(Mockito.anyString())).thenReturn(user);
		Mockito.when(associationService.getUserPrivileges(Mockito.anyLong())).thenReturn(new ArrayList<Integer>());
		assertEquals(service.getUserPrivilegesByEmail("any@email.com").size(), 0);
	}

}
