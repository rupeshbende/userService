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

import com.broadcom.userservice.beans.Privilege;
import com.broadcom.userservice.dao.PrivilegeDao;

@Service
@EnableRetry
@DependsOn(value = "sqlSessionFactory")
public class PrivilegeDaoService {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public Privilege getPrivilege(int privilegeId) {
		return sqlSession.getMapper(PrivilegeDao.class).getPrivilege(privilegeId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public Privilege getPrivilege(String privilegeName) {
		return sqlSession.getMapper(PrivilegeDao.class).getPrivilege(privilegeName);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void addPrivilege(Privilege privilege) {
		sqlSession.getMapper(PrivilegeDao.class).addPrivilege(privilege);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void deletePrivilege(int privilegeId) {
		sqlSession.getMapper(PrivilegeDao.class).deletePrivilege(privilegeId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void setName(int privilegeId, String name) {
		sqlSession.getMapper(PrivilegeDao.class).setName(privilegeId, name);
	}
}
