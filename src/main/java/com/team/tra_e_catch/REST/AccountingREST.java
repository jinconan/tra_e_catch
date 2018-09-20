package com.team.tra_e_catch.REST;

import java.util.*;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.team.tra_e_catch.accounting.AccountingLogic;


/*
 * Ŭ������ : AccountingREST
 * �ۼ��� : ��ö��
 * ��¥ : 2018-09-18
 */


//������ �̵� ���� �������̽�
@RestController
@RequestMapping("/accR")
public class AccountingREST{
	Logger logger = Logger.getLogger(AccountingREST.class);
	@Autowired
	private AccountingLogic accountingLogic;
	
	// ����
	/*
	 * init�޼��� : slip/slip_main.jsp
	 * out������ : ��ǥ ���� 
	 * �뵵 : ��ǥ���� ��¿�
	 * ��� : x
	 */
	@RequestMapping("slip/{counts}")
	private List<Map<String, Object>> team(@PathVariable int counts,Model mod) {
		logger.info(counts+"�� slieR����");
		List<Map<String, Object>> as = accountingLogic.teamR_Logic(counts);	
		logger.info(as.size());
		mod.addAttribute("se_sile_list",as.size());
		return as;
	}
	
	
	
	@RequestMapping("slip/test")
	private Map<String,Object> team_test() {
		logger.info("test_slieR����");
		Map<String,Object> list = new HashMap<String,Object>();	
		Map<String,Object> data = new HashMap<String,Object>();
		Map<String,Object> map1 = null;
		Map<String,Object> map = null;
		List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		Random rd = new Random();
		
		map1 = new HashMap<String,Object>();
		map1.put("caption","������ �� �Ǹűݾ�");                  
		map1.put("subcaption","2018~2018");                  
		map1.put("xaxisname,","�⵵");                              
		map1.put("yaxisname","�ݾ�");                       
		map1.put("showBorder","0");                                         
		map1.put("numberSuffix","��");                                     
		map1.put("theme","fusion");
		list.put("chart", map1);
		
		for(int i = 0; i<10; i++) {
			map = new HashMap<String, Object>();
			map.put("label", 2008+i);
			list2.add(map);
		}	
		map = new HashMap<String, Object>();
		map.put("category", list2);
		list2 = new ArrayList<Map<String,Object>>(); 
		list2.add(map);
		list.put("categories", list2);
		
		
		list2 = new ArrayList<Map<String,Object>>();
		for(int i = 0; i<10; i++) {
			map = new HashMap<String, Object>();
			map.put("value", rd.nextInt(100)*100);
			list2.add(map);
		}
		map = new HashMap<String, Object>();
		map.put("seriesname", "�׽�Ʈ1");
		map.put("data", list2);
		list1.add(map);
		
		list2 = new ArrayList<Map<String,Object>>();
		for(int i = 0; i<10; i++) {
			map = new HashMap<String, Object>();
			map.put("value", rd.nextInt(100)*100);
			list2.add(map);
		}
		map = new HashMap<String, Object>();
		map.put("seriesname", "�׽�Ʈ2");
		map.put("data", list2);
		list1.add(map);
		
		list2 = new ArrayList<Map<String,Object>>();
		for(int i = 0; i<10; i++) {
			map = new HashMap<String, Object>();
			map.put("value", rd.nextInt(100)*100);
			list2.add(map);
		}
		map = new HashMap<String, Object>();
		map.put("seriesname", "�׽�Ʈ3");
		map.put("data", list2);
		list1.add(map);
		
		list.put("dataset", list1);

		return list;
	}
	
	
}
