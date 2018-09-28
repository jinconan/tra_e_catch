package com.team.tra_e_catch.accounting;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/*
 * Ŭ������ : AccountingController
 * �ۼ��� : ��ö��
 * ��¥ : 2018-08-31
 * init�޼��� : AccountingController
 */
@Service
public class AccountingLogic {
	Logger logger = Logger.getLogger(AccountingLogic.class);
	@Autowired
	private SqlAccDao sqlAccDao = null;
	
	public String team_Logic() {
		String s = null;
		return null;
	}
	
	/*
	 * init������ : ��ǥ ����Ʈ ��ȣ 
	 * out������ : ��ǥ ����Ʈ
	 * �뵵 : ��ǥ����Ʈ �� ����ϱ� ���� ����
	 * ��� : x
	 */
	
	public List<Map<String, Object>> teamR_Logic(int counst) {
		logger.info("TeamR_Logic����");
		List<Map<String, Object>> s = null;
		s = sqlAccDao.Team_Dao(counst);
		return s;
	}
	
	public List<Map<String, Object>> t_teamR_Logic(int counst,HttpServletRequest res) {
		logger.info("t_TeamR_Logic����");
		List<Map<String, Object>> s = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("counst", counst);
		Arrrtd arr = new Arrrtd();
		arr.initDate(res,map);
		s = sqlAccDao.t_Team_Dao(map);
		gbrun(s);
		return s;
	}
	
	public List<Map<String, Object>> b_teamR_Logic(int counst,HttpServletRequest res) {
		logger.info("b_TeamR_Logic����");
		List<Map<String, Object>> s = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("counst", counst);
		Arrrtd arr = new Arrrtd();
		arr.initDate(res,map);
		s = sqlAccDao.b_Team_Dao(map);
		gbrun(s);
		return s;
	}
	
	private void gbrun(List<Map<String, Object>> s) {
		for(Map<String, Object> map: s) {
			if(map.get("����").equals("�����ڻ�")) {
				map.put("�����ڻ�",map.get("�ݾ�"));
				map.put("���",0);
				map.put("����",0);
			}else if(map.get("����").equals("����")) {
				map.put("���",map.get("�ݾ�"));
				map.put("�����ڻ�",0);
				map.put("����",0);
			}else {
				map.put("���",0);
				map.put("�����ڻ�",0);
				map.put("����",map.get("�ݾ�"));
			}
		}
	}

}
