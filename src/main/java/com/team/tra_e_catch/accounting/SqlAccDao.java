package com.team.tra_e_catch.accounting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

/*
 * Ŭ������ : AccountingController
 * �ۼ��� : ��ö��
 * ��¥ : 2018-08-31
 */
public class SqlAccDao {
	Logger logger = Logger.getLogger(SqlAccDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<Map<String, Object>> Team_Dao(int counst,String emp_no) {
		logger.info("Team_Dao����");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("counst", counst);
		map.put("emp_no", emp_no);
		logger.info(map);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		sqlSessionTemplate.selectList("timecell",map);
		list = (ArrayList)map.get("cos_type1");
		return list;
	}
	
	public int Team_size() {
		logger.info("Team_size����");
		return sqlSessionTemplate.selectOne("stertcell");
	}
	
	
	public List<Map<String, Object>> b_Team_Dao(Map<String, Object> map) {
		logger.info("t_Team_Dao����");
		logger.info(map);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = sqlSessionTemplate.selectList("b_timecell",map);
		return list;
	}
	
	
	public List<Map<String, Object>> t_Team_Dao(Map<String, Object> map) {
		logger.info("t_Team_Dao����");
		logger.info(map);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = sqlSessionTemplate.selectList("t_timecell",map);
		return list;
	}

	public void flieupdate_Dao(Map<String, Object> slipTitle) {
		logger.info("fukeupdate_DaoDao����");
		logger.info(slipTitle);
		sqlSessionTemplate.update("flieupdate_Dao",slipTitle);
	}
	
}
