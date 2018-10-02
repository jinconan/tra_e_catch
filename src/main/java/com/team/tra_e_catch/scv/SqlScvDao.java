package com.team.tra_e_catch.scv;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class SqlScvDao {
	Logger logger = Logger.getLogger(SqlScvDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public Map<String, Object> login(Map<String, Object> pMap) {
		Map<String,Object> result = null;
		
		try {
			result = sqlSessionTemplate.selectOne("com.mybatis.mapper.scvMapper.login",pMap);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
	
	public int modify(Map<String, Object> pMap) {
		int result = 0;
		
		try {
			result = sqlSessionTemplate.update("com.mybatis.mapper.scvMapper.modify", pMap);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
	
}
