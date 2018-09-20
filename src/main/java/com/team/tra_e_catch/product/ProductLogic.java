package com.team.tra_e_catch.product;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	public List<Map<String, Object>> chartsR_Logic() {
		logger.info("chartsR_Logic����");
		List<Map<String, Object>> s = sqlProdDao.chartsR_Dao();
		
		Map<String,Object> map = null;
		Map<String,Object> list = new HashMap<String,Object>();	
		List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		map = new HashMap<String,Object>();
		map.put("caption","������ �� �Ǹűݾ�");                  
		map.put("subcaption","2018~2018");                  
		map.put("xaxisname,","�⵵");                              
		map.put("yaxisname","�ݾ�");                       
		map.put("showBorder","0");                                         
		map.put("numberSuffix","��");                                     
		map.put("theme","fusion");
		list.put("chart", map);
		
		
		for(Map<String,Object> maplist : s) {
			map = new HashMap<String, Object>();
			map.put("label", maplist.get("��������"));
			list2.add(map);
		}
		map = new HashMap<String, Object>();
		map.put("category", list2);
		list2 = new ArrayList<Map<String,Object>>(); 
		list2.add(map);
		list.put("categories", list2);
		
		for(Map<String,Object> maplist : s) {
			map = new HashMap<String, Object>();
			map.put("value", maplist.get("�ݾ�"));
			list2.add(map);
		}
		map = new HashMap<String, Object>();
		map.put("seriesname", "������ �ݾ�");
		map.put("allowDrag", "0");
		map.put("data", list2);
		list1.add(map);
		
		return s;
	}
	
}
