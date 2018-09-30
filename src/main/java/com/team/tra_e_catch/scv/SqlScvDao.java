package com.team.tra_e_catch.scv;

import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.team.tra_e_catch.accounting.SqlAccDao;

public class SqlScvDao {
	Logger logger = Logger.getLogger(SqlScvDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public int login(Map<String, Object> pMap) {
		int result = 0;
		
		try {
			result = sqlSessionTemplate.selectOne("com.mybatis.mapper.scvMapper.login",pMap);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
}
