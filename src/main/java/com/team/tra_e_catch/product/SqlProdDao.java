package com.team.tra_e_catch.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;


public class SqlProdDao {
	Logger logger = Logger.getLogger(SqlProdDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<Map<String, Object>> tranR_Dao() {
		logger.info("tran_Dao진입");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = sqlSessionTemplate.selectList("orTranlist");
		return list;
	}
	
	public List<Map<String, Object>> chartsR_Dao() {
		logger.info("charts_Dao진입");
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("counst", 0);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		sqlSessionTemplate.selectList("Pro_Stat_Chart",map);
		list = (ArrayList)map.get("chart_Plan1");
		return list;
	}

	public List<Map<String, Object>> chartsR_moon_Dao(int counts) {
		// TODO Auto-generated method stub
		logger.info("charts_moon_Dao진입"+counts);
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("counst", counts);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		sqlSessionTemplate.selectList("Pro_moon_Chart",map);
		list = (ArrayList)map.get("chart_Plan1");
		return list;
	}

}
