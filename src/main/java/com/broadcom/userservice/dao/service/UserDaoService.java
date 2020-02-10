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
import com.broadcom.userservice.beans.User;
import com.broadcom.userservice.dao.UserDao;

@Service
@EnableRetry
@DependsOn(value = "sqlSessionFactory")
public class UserDaoService {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public User getUser(long userId) {
		return sqlSession.getMapper(UserDao.class).getUser(userId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public User getUser(String email) {
		return sqlSession.getMapper(UserDao.class).getUser(email);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void addUser(User user) {
		sqlSession.getMapper(UserDao.class).addUser(user);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void deleteUser(long userId) {
		sqlSession.getMapper(UserDao.class).deleteUser(userId);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void setFirstName(long userId, String firstName) {
		sqlSession.getMapper(UserDao.class).setFirstName(userId, firstName);
	}

	@Retryable(include = { RecoverableDataAccessException.class,
			TransientDataAccessException.class }, maxAttempts = DB_TRY_MAX_ATTEMPTS, backoff = @Backoff(delay = DEFAULT_RETRY_PAUSE))
	public void setLastName(long userId, String lastName) {
		sqlSession.getMapper(UserDao.class).setFirstName(userId, lastName);
	}
}
