package com.team.tra_e_catch.scv;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SqlScvDao {
	Logger logger = Logger.getLogger(SqlScvDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;

	public Map<String, Object> login(Map<String, Object> pMap) {
		Map<String,Object> result = null;
		logger.info("login : " + pMap);
		try {
			result = sqlSessionTemplate.selectOne("com.mybatis.mapper.scvMapper.login",pMap);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
	
	public int updateEmpPrivate(Map<String, Object> pMap) {
		int result = 0;
		
		try {
			result = sqlSessionTemplate.update("com.mybatis.mapper.scvMapper.updateEmpPrivateAll", pMap);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	public List<Map<String, Object>> getScvList(int emp_no) {
		logger.info("getScvList 호출 성공");
		List<Map<String, Object>> getScvList = null;
		getScvList = sqlSessionTemplate.selectList("com.mybatis.mapper.scvMapper.getScvList", emp_no);
		return getScvList;//NullPointerException
	}

	public String getPw(int eno) {
		logger.info("getPw 호출 성공");
		String result = null;
		result = sqlSessionTemplate.selectOne("com.mybatis.mapper.scvMapper.getPw", eno);
		return result;//NullPointerException
	}
}
