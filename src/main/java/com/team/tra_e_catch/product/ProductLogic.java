package com.team.tra_e_catch.product;


import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductLogic {
	private final Logger logger = Logger.getLogger(ProductLogic.class);

	@Autowired
	private SqlProdDao sqlProdDao;
	
	
	/*
	 * init������ : ����ڵ�,�ŷ�ó�ڵ�,�������,���������� + ����������,�ŷ���
	 * out������ : List<Map<String, Object>> ������̺�
	 * �뵵 : �ŷ����� ��ǥ ��¿� REST 
	 * ��� : x
	 */
	public List<Map<String, Object>> teamR_Logic() {
		logger.info("TeamR_Logic����");
		List<Map<String, Object>> s = sqlProdDao.tranR_Dao();
		return s;
	}
	
	public Map<String, Object> chartsR_Logic() {
		logger.info("chartsR_Logic����");
		Chart_Make cm = new Chart_Make();
		cm.C_Make(sqlProdDao.chartsR_Dao());

		return cm.map;
	}

	public Map<String, Object> chartsR_moon_Logic(int counts) {
		logger.info("chartsR_moon_Logic����");
		Chart_Make cm = new Chart_Make();
		cm.C_Make(sqlProdDao.chartsR_moon_Dao(counts));
		return cm.map;
	}

	public List<Map<String, Object>> moon_List_Logic() {
		logger.info("chartsR_moon_Logic����");
		List<Map<String, Object>> s = sqlProdDao.moon_List_Deo();
		return s;
	}
	
	public List<Map<String, Object>> ct_List_Logic() {
		logger.info("chartsR_ct_Logic����");
		List<Map<String, Object>> s = sqlProdDao.ct_List_Deo();
		return s;
	}
	
	public Map<String, Object> chartsR_ct_Logic(int counts,int day,int yn) {
		logger.info("chartsR_ct_Logic����");
		Chart_Make cm = new Chart_Make();
		cm.C_Make(sqlProdDao.chartsR_ct_Dao(counts,day,yn));
		return cm.map;
	}
}
