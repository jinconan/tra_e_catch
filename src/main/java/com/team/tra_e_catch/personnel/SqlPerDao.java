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
	//����� ���� ������ ��û DB
	public List<Map<String, Object>> getAttdList(int counts) {
		List<Map<String,Object>> attdList = null;
		attdList = sqlSessionTemplate.selectList("getAttdList",counts);
		return attdList;
	}
	//�޿����� ������ ��û DB
	public List<Map<String, Object>> getSalList(int counts) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> salList = null;//�������� �ǽ�
		salList = sqlSessionTemplate.selectList("getSalList",counts);
		return salList;
	}
	public List<Map<String, Object>> getTeamList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("sqlTeamȮ��");
		List<Map<String,Object>> teamList = null;
		teamList = sqlSessionTemplate.selectList("getTeamList",pMap);
		System.out.println(teamList.size());
		return teamList;
	}
		//������ ������ ��û DB
	public List<Map<String, Object>> getEmpList(Map<String, Object> pMap) {
		logger.info("���Ծ�");
		List<Map<String, Object>> getEmpList = null;
		getEmpList = sqlSessionTemplate.selectList("getEmpList",pMap );
		return getEmpList;
		
	}
	public List<Map<String, Object>> setSerList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> serList = null;
		serList = sqlSessionTemplate.selectList("setSerList",pMap );
		return serList;
	}
	
}
