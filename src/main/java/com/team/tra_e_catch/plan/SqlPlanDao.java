package com.team.tra_e_catch.plan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class SqlPlanDao {
	Logger logger = Logger.getLogger(SqlPlanDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public List<Map<String, Object>> getProjList(Map<String, Object> pMap) {
		logger.info("getProjList() »£√‚");
		
//		return sqlSessionTemplate.selectList(
//				"com.mybatis.mapper.planMapper.getProjList", pMap);
		return new ArrayList<Map<String,Object>>();
	}
}
