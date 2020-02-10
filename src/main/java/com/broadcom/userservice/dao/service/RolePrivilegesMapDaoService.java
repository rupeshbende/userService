package com.broadcom.userservice.dao.service;

import static com.broadcom.userservice.constants.CommonConstants.DB_TRY_MAX_ATTEMPTS;
import static com.broadcom.userservice.constants.CommonConstants.DEFAULT_RETRY_PAUSE;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.broadcom.userservice.beans.Group;
import com.broadcom.userservice.dao.RolePrivilegesMapDao;

@Service
@EnableRetry
@DependsOn(value = "sqlSessionFactory")
public class RolePrivilegesMapDaoService {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public List<Integer> getRoleOfPrivilege(int privilegesId) {
		return sqlSession.getMapper(RolePrivilegesMapDao.class).getRoleOfPrivilege(privilegesId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public List<Integer> getRolePrivileges(int roleId) {
		return sqlSession.getMapper(RolePrivilegesMapDao.class).getRolePrivileges(roleId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void addPrivilegeToRole(int privilegeId, int roleId) {
		sqlSession.getMapper(RolePrivilegesMapDao.class).addPrivilegeToRole(roleId, privilegeId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void deletePrivilegeRoleMappingByPrivilegeId(int privilegeId) {
		sqlSession.getMapper(RolePrivilegesMapDao.class).deletePrivilegeRoleMappingByPrivilegeId(privilegeId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void deletePrivilegeRoleMappingByRoleId(int roleId) {
		sqlSession.getMapper(RolePrivilegesMapDao.class).deletePrivilegeRoleMappingByRoleId(roleId);
	}
}
