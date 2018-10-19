package com.team.tra_e_catch.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SqlProdDao {
	Logger logger = Logger.getLogger(SqlProdDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;

	public List<Map<String, Object>> tranR_Dao(Map<String, Object> map) {
		logger.info("tran_Dao진입");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = sqlSessionTemplate.selectList("orTranlist",map);
		return list;
	}
	
	public List<Map<String, Object>> chartsR_Dao() {
		logger.info("charts_Dao진입");
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("counst", 0);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		sqlSessionTemplate.selectList("Pro_Stat_Chart",map);
		list = (ArrayList)map.get("chart_Plan1");
		return list;
	}

	public List<Map<String, Object>> chartsR_moon_Dao(int counts) {
		// TODO Auto-generated method stub
		logger.info("charts_moon_Dao진입"+counts);
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("counst", counts);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		sqlSessionTemplate.selectList("Pro_moon_Chart",map);
		list = (ArrayList)map.get("chart_Plan1");
		return list;
	}

	public List<Map<String, Object>> moon_List_Deo() {
		logger.info("moon_Deo진입");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = sqlSessionTemplate.selectList("moon_lists");
		return list;
	}

	public List<Map<String, Object>> ct_List_Deo() {
		logger.info("ct_Deo진입");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = sqlSessionTemplate.selectList("ct_list");
		return list;
	}

	public List<Map<String, Object>> chartsR_ct_Dao(int counts, int day, int yn) {
		// TODO Auto-generated method stub
		logger.info("charts_ct_Dao진입"+counts+day);
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("counst", counts);
		map.put("day", day);
		map.put("yn", yn);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		sqlSessionTemplate.selectList("Pro_ct_Chart",map);
		list = (ArrayList)map.get("chart_Plan1");
		logger.info(list);
		return list;
	}

	public List<Map<String, Object>> trancli_Dao() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = sqlSessionTemplate.selectList("client_goods");
		return list;
	}

	public void Tran_init_Dao(Map<String, String> map) {
		logger.info("Tran_init_Dao 도착"+map);
		sqlSessionTemplate.insert("Tran_init",map);
	}

	public List<Map<String, Object>> getTRANList_Dao(Map<String, Object> pMap) {
		logger.info("getTRANList_Dao진입");
		return 	sqlSessionTemplate.selectList("getTRANcell",pMap);
	}

	public void getTRANupdate_Dao(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("getTRANupdate_Dao진입");
		sqlSessionTemplate.selectList("tran_update",pMap);
	}

	public List<Map<String, Object>> InvenR_Dao(Map<String, Object> map) {
		logger.info("InvenR_Dao진입" + map);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = sqlSessionTemplate.selectList("orInvenRlist",map);
		return list;
	}

	public void Inven_init_Dao(Map<String, String> map) {
		logger.info("Tran_init_Dao 도착"+map);
		sqlSessionTemplate.selectOne("Inven_init",map);
	}
	public void Inven_update_Dao(Map<String, String> map) {
		logger.info("Tran_init_Dao 도착"+map);
		sqlSessionTemplate.update("Inven_update",map);
	}

	public int emp_Dao(String emp_no) {
		// TODO Auto-generated method stub
		logger.info("emp_Dao진입");
		return sqlSessionTemplate.selectOne("emp_list",emp_no);
	}

	public List<Map<String, Object>> clientR_Dao(Map<String, Object> map) {
		logger.info("clientR_Dao진입" + map);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = sqlSessionTemplate.selectList("client_list",map);
		return list;
	}

	public void client_init_Dao(Map<String, Object> map) {
		logger.info("client_init_Dao 도착"+map);
		sqlSessionTemplate.insert("CLIENT_init",map);
	}

	public void client_update_Dao(Map<String, Object> map) {
		logger.info("client_update_Dao 도착"+map);
		sqlSessionTemplate.update("CLIENT_update",map);
	}

	public List<Map<String, Object>> tran_goods_Dao(int counts) {
		logger.info("tran_goods_Dao진입" + counts);
		return sqlSessionTemplate.selectList("tran_goods",counts);
	}

	public void client_goodsin_Dao(Map<String, Object> map) {
		logger.info("client_goodsin_Dao 도착"+map);
		sqlSessionTemplate.insert("client_goodsin",map);			
	}
}
