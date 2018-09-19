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
	/**
	 * 
	 * @param pMap
	 * @return
	 */
	//출퇴근 내역 데이터 요청 DB
	public List<Map<String, Object>> getAttdList(Map<String, Object> pMap) {
		List<Map<String,Object>> attdList = null;
		attdList = sqlSessionTemplate.selectList("getAttdList",pMap);
		return attdList;
	}
	//급여내역 데이터 요청 DB
	public List<Map<String, Object>> getSalList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> salList = null;
		salList = sqlSessionTemplate.selectList("getSalList",pMap);
		return salList;
	}
	//사원명부 데이터 요청 DB
	public List<Map<String, Object>> getEmpList(Map<String, Object> pMap) {
		logger.info("들어왔어");
		List<Map<String, Object>> getEmpList = null;
		getEmpList = sqlSessionTemplate.selectList("getEmpList",pMap );
		return getEmpList;
		
	}
	
}
