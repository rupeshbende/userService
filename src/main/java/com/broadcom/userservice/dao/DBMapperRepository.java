package com.broadcom.userservice.dao;

import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBMapperRepository {

	@Autowired
	@Qualifier("sqlSessionFactory")
	protected SqlSessionFactoryBean sqlSessionFactory;

	private static final Logger logger = LoggerFactory.getLogger(DBMapperRepository.class);

	@PostConstruct
	public void init() {
		try {
			sqlSessionFactory.getObject().getConfiguration().addMapper(UserDao.class);
			sqlSessionFactory.getObject().getConfiguration().addMapper(GroupDao.class);
			sqlSessionFactory.getObject().getConfiguration().addMapper(RoleDao.class);
			sqlSessionFactory.getObject().getConfiguration().addMapper(PrivilegeDao.class);
			sqlSessionFactory.getObject().getConfiguration().addMapper(GroupRoleMapDao.class);
			sqlSessionFactory.getObject().getConfiguration().addMapper(RolePrivilegesMapDao.class);
			sqlSessionFactory.getObject().getConfiguration().addMapper(UserGroupMapDao.class);
			sqlSessionFactory.getObject().getConfiguration().addMapper(UserRoleMapDao.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	//TODO data source configuration
}
