package com.broadcom.userservice.dao.service;

import static com.broadcom.userservice.constants.CommonConstants.DB_TRY_MAX_ATTEMPTS;
import static com.broadcom.userservice.constants.CommonConstants.DEFAULT_RETRY_PAUSE;

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
import com.broadcom.userservice.dao.GroupDao;

@Service
@EnableRetry
@DependsOn(value = "sqlSessionFactory")
public class GroupDaoService {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public Group getGroup(int groupId) {
		return sqlSession.getMapper(GroupDao.class).getGroup(groupId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public Group getGroupByName(String groupName) {
		return sqlSession.getMapper(GroupDao.class).getGroupByName(groupName);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void addGroup(Group group) {
		sqlSession.getMapper(GroupDao.class).addGroup(group);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void deleteGroup(int groupId) {
		sqlSession.getMapper(GroupDao.class).deleteGroup(groupId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void setName(int groupId, String name) {
		sqlSession.getMapper(GroupDao.class).setName(groupId, name);
	}
}
