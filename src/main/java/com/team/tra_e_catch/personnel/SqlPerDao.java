package com.team.tra_e_catch.personnel;

import java.util.ArrayList;
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
	/**
	 * 
	 * @param pMap
	 * @return
	 */
	//출퇴근 내역 데이터 요청 DB
	public List<Map<String, Object>> getAttdList(int counts) {
		List<Map<String,Object>> attdList = null;
		attdList = sqlSessionTemplate.selectList("getAttdList",counts);
		return attdList;
	}
	//급여내역 데이터 요청 DB
	public List<Map<String, Object>> getSalList(int counts) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> salList = new ArrayList<Map<String,Object>>();
		salList = sqlSessionTemplate.selectList("getSalList",counts);
		return salList;
	}
	
}
