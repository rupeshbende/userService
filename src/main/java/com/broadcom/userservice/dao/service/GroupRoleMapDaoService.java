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

import com.broadcom.userservice.dao.GroupRoleMapDao;

@Service
@EnableRetry
@DependsOn(value = "sqlSessionFactory")
public class GroupRoleMapDaoService {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public List<Integer> getGroupRoles(int groupId) {
		return sqlSession.getMapper(GroupRoleMapDao.class).getGroupRoles(groupId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public List<Integer> getGroupsOfRole(int roleId) {
		return sqlSession.getMapper(GroupRoleMapDao.class).getGroupsOfRole(roleId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void addRoleToGroup(int roleId, int groupId) {
		sqlSession.getMapper(GroupRoleMapDao.class).addRoleToGroup(roleId, groupId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void deleteRoleGroupMappingByRoleId(int roleId) {
		sqlSession.getMapper(GroupRoleMapDao.class).deleteRoleGroupMappingByRoleId(roleId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void deleteRoleGroupMappingByGroupId(int groupId) {
		sqlSession.getMapper(GroupRoleMapDao.class).deleteRoleGroupMappingByGroupId(groupId);
	}
}
