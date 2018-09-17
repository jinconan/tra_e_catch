package com.team.tra_e_catch.scv;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.team.tra_e_catch.accounting.SqlAccDao;

public class SqlScvDao {
	Logger logger = Logger.getLogger(SqlScvDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
