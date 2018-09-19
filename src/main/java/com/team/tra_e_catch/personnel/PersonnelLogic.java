package com.team.tra_e_catch.personnel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonnelLogic {
	Logger logger = Logger.getLogger(PersonnelLogic.class);
	
	@Autowired
	private SqlPerDao sqlPerDao = null;
	
	//����� ���� JSON������ ��û
	public List<Map<String, Object>> getAttdList(Map<String, Object> pMap, HttpServletResponse res) {
		// TODO Auto-generated method stub
		logger.info("getAttdList ȣ�� ����");
		
		List<Map<String,Object>> attdList = null;
		
		attdList = sqlPerDao.getAttdList(pMap);
		return attdList;
	}
	//�޿����� JSON���� ������ ��û
	public List<Map<String, Object>> getSalList(Map<String, Object> pMap, HttpServletResponse res) {
		// TODO Auto-generated method stub
		logger.info("getSalList ȣ�� ����");
		
		List<Map<String,Object>> salList = null;
		
		salList = sqlPerDao.getSalList(pMap);
		return salList;
	}
	//������ ������ ��û
	public List<Map<String, Object>> getEmpList(Map<String, Object> pMap, HttpServletResponse res) {
		logger.info("getEmpList ȣ�� ����");
		List<Map<String, Object>> getEmpList = null;
		getEmpList = sqlPerDao.getEmpList(pMap);
		return getEmpList;
	}

}
