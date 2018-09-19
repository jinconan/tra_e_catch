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
	//����� ���� ������ ��û DB
	public List<Map<String, Object>> getAttdList(Map<String, Object> pMap) {
		List<Map<String,Object>> attdList = null;
		attdList = sqlSessionTemplate.selectList("getAttdList",pMap);
		return attdList;
	}
	//�޿����� ������ ��û DB
	public List<Map<String, Object>> getSalList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> salList = null;
		salList = sqlSessionTemplate.selectList("getSalList",pMap);
		return salList;
	}
	//������ ������ ��û DB
	public List<Map<String, Object>> getEmpList(Map<String, Object> pMap) {
		logger.info("���Ծ�");
		List<Map<String, Object>> getEmpList = null;
		getEmpList = sqlSessionTemplate.selectList("getEmpList",pMap );
		return getEmpList;
		
	}
	
}
