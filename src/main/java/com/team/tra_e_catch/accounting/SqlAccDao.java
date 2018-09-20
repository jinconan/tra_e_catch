package com.team.tra_e_catch.accounting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

/*
 * 클래스명 : AccountingController
 * 작성자 : 신철우
 * 날짜 : 2018-08-31
 */
public class SqlAccDao {
	Logger logger = Logger.getLogger(SqlAccDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<Map<String, Object>> Team_Dao(int counts) {
		logger.info("Team_Dao진입");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("counst", counts);
		logger.info(map);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		sqlSessionTemplate.selectList("timecell",map);
		list = (ArrayList)map.get("cos_type1");
		return list;
	}
	
}
