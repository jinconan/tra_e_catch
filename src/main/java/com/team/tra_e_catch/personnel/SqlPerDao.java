package com.team.tra_e_catch.personnel;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;


public class SqlPerDao {
	Logger logger = Logger.getLogger(SqlPerDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public List<Map<String, Object>> getAttdList(Map<String, Object> pMap) {
		List<Map<String,Object>> attdList = null;
		attdList = sqlSessionTemplate.selectList("getAttdList",pMap);
		return attdList;
	}
	
}
