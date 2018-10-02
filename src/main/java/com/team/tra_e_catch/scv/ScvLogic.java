package com.team.tra_e_catch.scv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScvLogic {
	private final Logger logger = Logger.getLogger(ScvLogic.class);

	@Autowired
	private SqlScvDao sqlScvDao;

	public int login(String emp_id, String emp_pw) {
		logger.info("login");
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("emp_id",  emp_id);
		pMap.put("emp_pw",  emp_pw);
		
		return sqlScvDao.login(pMap);
	}
	public int  modify(Map<String,Object> pMap)
	{
		logger.info("modify");
		logger.info("pw:"+pMap.get("emp_cur_pw"));
		int result = 0;//0:수정실패, 1:수정성공
		result = sqlScvDao.modify(pMap);//세션아이디
		return result;
		
	}
	public List<Map<String, Object>> getScvList(int emp_no) {
		logger.info("getScvList 호출 성공");
		List<Map<String,Object>> scvList = null;
		//왜 Dao에는 메소드를 분리하지 않는거지? - 같은 sql문을 사용하니깐
		scvList = sqlScvDao.getScvList(emp_no);
		
		return scvList;
	}
	
}
