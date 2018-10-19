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
	 * init데이터 : 등록코드,거래처코드,결제방식,결제시작일 + 결제종료일,거래량
	 * out데이터 : List<Map<String, Object>> 출력테이블
	 * 용도 : 거래내역 전표 출력용 REST 
	 * 비고 : x
	 */
	public List<Map<String, Object>> teamR_Logic(int counts,HttpServletRequest res) {
		logger.info("TeamR_Logic진입");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("counts", counts);
		Prod_VO arr = new Prod_VO();
		arr.initDate(res, map);
		List<Map<String, Object>> s = sqlProdDao.tranR_Dao(map);
		return s;
	}
	
	public Map<String, Object> chartsR_Logic() {
		logger.info("chartsR_Logic진입");
		Chart_Make cm = new Chart_Make();
		cm.C_Make(sqlProdDao.chartsR_Dao());
		return cm.map;
	}

	public Map<String, Object> chartsR_moon_Logic(int counts) {
		logger.info("chartsR_moon_Logic진입");
		Chart_Make cm = new Chart_Make();
		cm.C_Make(sqlProdDao.chartsR_moon_Dao(counts));
		return cm.map;
	}

	public List<Map<String, Object>> moon_List_Logic() {
		logger.info("chartsR_moon_Logic진입");
		List<Map<String, Object>> s = sqlProdDao.moon_List_Deo();
		return s;
	}
	
	public List<Map<String, Object>> ct_List_Logic() {
		logger.info("chartsR_ct_Logic진입");
		List<Map<String, Object>> s = sqlProdDao.ct_List_Deo();
		return s;
	}
	
	public Map<String, Object> chartsR_ct_Logic(int counts,int day,int yn) {
		logger.info("chartsR_ct_Logic진입");
		Chart_Make cm = new Chart_Make();
		cm.C_Make(sqlProdDao.chartsR_ct_Dao(counts,day,yn));
		return cm.map;
	}

	public List<Map<String, Object>> teancli_Logic() {
		List<Map<String, Object>> s = sqlProdDao.trancli_Dao();
		String name = (String)s.get(0).get("회사명");
		List<Map<String, Object>> list= new ArrayList<Map<String, Object>>();
		Map<String, Object> inmap = new HashMap<String,Object>();
		Map<String, Object> map = new HashMap<String,Object>();
		for(Map<String,Object>san: s) {
			inmap = new HashMap<String,Object>();
			if(!name.equals(san.get("회사명"))) {
				map.put(name, list);
				list= new ArrayList<Map<String, Object>>();
				name = san.get("회사명").toString();
			}
			inmap.put("번호", san.get("번호"));
			inmap.put("상품이름", san.get("상품이름"));
			list.add(inmap);
		}
		map.put(name, list);
		s = new ArrayList<Map<String, Object>>();
		s.add(map);
		logger.info(s);
		return s;
	}

	public void Tran_init_Logic(Map<String, String> map) {
		logger.info("Tran_init_Logic진입");
		sqlProdDao.Tran_init_Dao(map);
	}

	public List<Map<String, Object>> TRANprint_logic(Map<String, Object> pMap) {
		logger.info("TRANprint_logic진입");
		// TODO Auto-generated method stub
		return sqlProdDao.getTRANList_Dao(pMap);
	}

	public List<Map<String, Object>> TRANupdate_logic(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		sqlProdDao.getTRANupdate_Dao(pMap);
		return null;
	}

	public List<Map<String, Object>> InvenR_Logic(int counts, HttpServletRequest res) {
		logger.info("TeamR_Logic진입");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("counts", counts);
		List<Map<String, Object>> s = sqlProdDao.InvenR_Dao(map);
		return s;
	}

	public void Inven_init_Logic(Map<String, String> map) {
		logger.info("Inven_init_Logic진입");
		sqlProdDao.Inven_init_Dao(map);
	}
	public void Inven_update_Logic(Map<String, String> map) {
		logger.info("Inven_update_Logic진입");
		sqlProdDao.Inven_update_Dao(map);
	}

	public int emp_test(String emp_no) {
		// TODO Auto-generated method stub
		return sqlProdDao.emp_Dao(emp_no);
	}

	public List<Map<String, Object>> clientR_Logic(int counts, HttpServletRequest req) {
		logger.info("clientR_Logic진입");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("counts", counts);
		List<Map<String, Object>> s = sqlProdDao.clientR_Dao(map);
		return s;
	}

	public void client_init_Logic(Map<String, Object> map) {
		logger.info("client_init_Logic진입");
		sqlProdDao.client_init_Dao(map);
	}

	public void client_update_Logic(Map<String, Object> map) {
		logger.info("client_update_Logic진입");
		sqlProdDao.client_update_Dao(map);
	}

	public List<Map<String, Object>> tran_goods_Logic(int counts) {
		logger.info("tran_goods_Logic진입");
		return sqlProdDao.tran_goods_Dao(counts);
	}

	public void client_goodsin_Logic(Map<String, Object> map) {
		logger.info("client_goodsin_Logic진입");
		sqlProdDao.client_goodsin_Dao(map);		
	}
}
