package com.team.tra_e_catch.scv;

import java.util.HashMap;
import java.util.Map;

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
	public int modify(String emp_pw, String emp_new_pw, String emp_new_pw_check,String emp_email)
	{
		logger.info("modify");
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("emp_pw", emp_pw);
		pMap.put("emp_new_pw", emp_new_pw);
		pMap.put("emp_new_pw_check", emp_new_pw_check);
		pMap.put("emp_email", emp_email);
		
		return sqlScvDao.modify(pMap);
		
	}
	
}
