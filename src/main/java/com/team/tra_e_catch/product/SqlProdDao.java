package com.team.tra_e_catch.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;


public class SqlProdDao {
	Logger logger = Logger.getLogger(SqlProdDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<Map<String, Object>> tranR_Dao() {
		logger.info("tran_Dao¡¯¿‘");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = sqlSessionTemplate.selectList("orTranlist");
		return list;
	}
	
	public List<Map<String, Object>> chartsR_Dao() {
		logger.info("charts_Dao");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("counst", 0);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		sqlSessionTemplate.selectList("Pro_Stat_Chart",map);
		list = (List<Map<String, Object>>) map.get("cos_type1");
		return list;
	}
}
