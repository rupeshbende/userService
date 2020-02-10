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
import com.broadcom.userservice.dao.UserRoleMapDao;

@Service
@EnableRetry
@DependsOn(value = "sqlSessionFactory")
public class UserRoleMapDaoService {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public List<Integer> getUserRoles(long userId) {
		return sqlSession.getMapper(UserRoleMapDao.class).getUserRoles(userId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public List<Long> getUsersofRole(int roleId) {
		return sqlSession.getMapper(UserRoleMapDao.class).getUsersofRole(roleId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void addRoleToUser(long userId, int roleId) {
		sqlSession.getMapper(UserRoleMapDao.class).addRoleToUser(userId, roleId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void deleteUserRoleMappingByRoleId(int roleId) {
		sqlSession.getMapper(UserRoleMapDao.class).deleteUserRoleMappingByRoleId(roleId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void deleteUserRoleMappingByUserId(long userId) {
		sqlSession.getMapper(UserRoleMapDao.class).deleteUserRoleMappingByUserId(userId);
	}
}
