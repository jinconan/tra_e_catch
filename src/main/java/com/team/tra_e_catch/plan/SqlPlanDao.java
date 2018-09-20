package com.team.tra_e_catch.plan;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.LoggerFactory;

public class SqlPlanDao {
//	Logger logger = Logger.getLogger(SqlPlanDao.class);
	org.slf4j.Logger logger = LoggerFactory.getLogger(SqlPlanDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public List<Map<String, Object>> getProjList(Map<String, Object> pMap) {
		logger.info("getProjList() »£√‚");
		List<Map<String, Object>> projList = sqlSessionTemplate.selectList(
				"mybatis-mapper.planMapper.getProjList", pMap);
		
		logger.info("projList.size() : " + projList.size());
		return projList;
	}
}
