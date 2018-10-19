package com.team.tra_e_catch.product;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public List<Map<String, Object>> teamR_Logic(int counts,HttpServletRequest res) {
		logger.info("TeamR_Logic����");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("counts", counts);
		Prod_VO arr = new Prod_VO();
		arr.initDate(res, map);
		List<Map<String, Object>> s = sqlProdDao.tranR_Dao(map);
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

	public List<Map<String, Object>> teancli_Logic() {
		List<Map<String, Object>> s = sqlProdDao.trancli_Dao();
		String name = (String)s.get(0).get("ȸ���");
		List<Map<String, Object>> list= new ArrayList<Map<String, Object>>();
		Map<String, Object> inmap = new HashMap<String,Object>();
		Map<String, Object> map = new HashMap<String,Object>();
		for(Map<String,Object>san: s) {
			inmap = new HashMap<String,Object>();
			if(!name.equals(san.get("ȸ���"))) {
				map.put(name, list);
				list= new ArrayList<Map<String, Object>>();
				name = san.get("ȸ���").toString();
			}
			inmap.put("��ȣ", san.get("��ȣ"));
			inmap.put("��ǰ�̸�", san.get("��ǰ�̸�"));
			list.add(inmap);
		}
		map.put(name, list);
		s = new ArrayList<Map<String, Object>>();
		s.add(map);
		logger.info(s);
		return s;
	}

	public void Tran_init_Logic(Map<String, String> map) {
		logger.info("Tran_init_Logic����");
		sqlProdDao.Tran_init_Dao(map);
	}

	public List<Map<String, Object>> TRANprint_logic(Map<String, Object> pMap) {
		logger.info("TRANprint_logic����");
		// TODO Auto-generated method stub
		return sqlProdDao.getTRANList_Dao(pMap);
	}

	public List<Map<String, Object>> TRANupdate_logic(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		sqlProdDao.getTRANupdate_Dao(pMap);
		return null;
	}

	public List<Map<String, Object>> InvenR_Logic(int counts, HttpServletRequest res) {
		logger.info("TeamR_Logic����");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("counts", counts);
		List<Map<String, Object>> s = sqlProdDao.InvenR_Dao(map);
		return s;
	}

	public void Inven_init_Logic(Map<String, String> map) {
		logger.info("Inven_init_Logic����");
		sqlProdDao.Inven_init_Dao(map);
	}
	public void Inven_update_Logic(Map<String, String> map) {
		logger.info("Inven_update_Logic����");
		sqlProdDao.Inven_update_Dao(map);
	}

	public int emp_test(String emp_no) {
		// TODO Auto-generated method stub
		return sqlProdDao.emp_Dao(emp_no);
	}

	public List<Map<String, Object>> clientR_Logic(int counts, HttpServletRequest req) {
		logger.info("clientR_Logic����");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("counts", counts);
		List<Map<String, Object>> s = sqlProdDao.clientR_Dao(map);
		return s;
	}

	public void client_init_Logic(Map<String, Object> map) {
		logger.info("client_init_Logic����");
		sqlProdDao.client_init_Dao(map);
	}

	public void client_update_Logic(Map<String, Object> map) {
		logger.info("client_update_Logic����");
		sqlProdDao.client_update_Dao(map);
	}

	public List<Map<String, Object>> tran_goods_Logic(int counts) {
		logger.info("tran_goods_Logic����");
		return sqlProdDao.tran_goods_Dao(counts);
	}

	public void client_goodsin_Logic(Map<String, Object> map) {
		logger.info("client_goodsin_Logic����");
		sqlProdDao.client_goodsin_Dao(map);		
	}
}
