package com.team.tra_e_catch.scv;

import java.util.List;
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
	
	public int modify(Map<String, Object> pMap) {
		int result = 0;
		
		try {
			result = sqlSessionTemplate.update("com.mybatis.mapper.scvMapper.modify", pMap);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	public List<Map<String, Object>> getScvList(int emp_no) {
		logger.info("getScvList 호출 성공");
		List<Map<String, Object>> getScvList = null;
		getScvList = sqlSessionTemplate.selectList("getScvList", emp_no);
		return getScvList;//NullPointerException
	}
}
