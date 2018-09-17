package com.team.tra_e_catch.product;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.team.tra_e_catch.accounting.SqlAccDao;

public class SqlProdDao {
	Logger logger = Logger.getLogger(SqlProdDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
