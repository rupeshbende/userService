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
import com.broadcom.userservice.dao.UserGroupMapDao;

@Service
@EnableRetry
@DependsOn(value = "sqlSessionFactory")
public class UserGroupMapDaoService {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public List<Integer> getUserGroups(long userId) {
		return sqlSession.getMapper(UserGroupMapDao.class).getUserGroups(userId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public List<Long> getUsersOfGroup(int groupId) {
		return sqlSession.getMapper(UserGroupMapDao.class).getUsersOfGroup(groupId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void addUserToGroup(long userId, int groupId) {
		sqlSession.getMapper(UserGroupMapDao.class).addUserToGroup(userId, groupId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void deleteUserGroupMappingByGroupId(int groupId) {
		sqlSession.getMapper(UserGroupMapDao.class).deleteUserGroupMappingByGroupId(groupId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void deleteUserGroupMappingByUserId(long userId) {
		sqlSession.getMapper(UserGroupMapDao.class).deleteUserGroupMappingByUserId(userId);
	}
}
