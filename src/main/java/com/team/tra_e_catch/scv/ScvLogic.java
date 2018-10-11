package com.team.tra_e_catch.scv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ScvLogic {
	private final Logger logger = Logger.getLogger(ScvLogic.class);

	@Autowired
	private SqlScvDao sqlScvDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Map<String,Object> login(String emp_id, String emp_pw) {
		logger.info("login");
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("emp_id",  emp_id);
		pMap.put("emp_pw",  emp_pw);
//		pMap.put("emp_pw",  bCryptPasswordEncoder.encode(emp_pw));
		
		return sqlScvDao.login(pMap);
	}
	public Map<String, Object> updateEmpPrivate(Map<String,Object> pMap)
	{
		logger.info("modify " + pMap);
		if(pMap.containsKey("emp_new_pw")) {
		//	pMap.put("emp_new_pw", bCryptPasswordEncoder.encode((String)pMap.get("emp_new_pw")));
		}
		
		int result = 0;//0:수정실패, 1:수정성공
		result = sqlScvDao.updateEmpPrivate(pMap);//세션아이디
		Map<String, Object> rMap = new HashMap<String, Object>();
		rMap.put("result", result);
		return rMap;
		
	}
	public List<Map<String, Object>> getScvList(int emp_no) {
		logger.info("getScvList 호출 성공");
		List<Map<String,Object>> scvList = null;
		//왜 Dao에는 메소드를 분리하지 않는거지? - 같은 sql문을 사용하니깐
		scvList = sqlScvDao.getScvList(emp_no);
		
		return scvList;
	}
	
	public Map<String, Object> checkCurPw(int eno, String rawPw) {
		logger.info("checkCurPw 호출 성공");
		String encPw = sqlScvDao.getPw(eno);
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		
		System.out.println(rawPw+", " + encPw);
		//if(bCryptPasswordEncoder.matches(rawPw, encPw)) {
		if(rawPw.equals(encPw)) {
			rMap.put("result", 1);
		} else {
			rMap.put("result", 0);
		}
		return rMap;
	}
	
}
