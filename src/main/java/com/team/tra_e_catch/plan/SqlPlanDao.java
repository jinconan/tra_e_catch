package com.team.tra_e_catch.plan;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.team.tra_e_catch.accounting.SqlAccDao;

public class SqlPlanDao {
	Logger logger = Logger.getLogger(SqlPlanDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
