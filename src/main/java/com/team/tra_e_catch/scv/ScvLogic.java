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
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public Map<String,Object> login(String emp_id, String emp_pw) {
		logger.info("login");
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("emp_id",  emp_id);
		Map<String, Object> rMap = sqlScvDao.login(pMap);
		if(rMap != null) {
			//���̵�� ��ġ�ϴ� ��� �Է��� ���� ��ȣȭ�� ��й�ȣ�� ���Ѵ�.
			String enc_pw = (String)rMap.get("PW");
			if(bcryptPasswordEncoder.matches(emp_pw, enc_pw))
				return rMap;
			else
				return null;
		} else
			return null;
	}
	public Map<String, Object> updateEmpPrivate(Map<String,Object> pMap)
	{
		logger.info("modify " + pMap);
		if(pMap.containsKey("emp_new_pw")) {
			pMap.put("emp_new_pw", bcryptPasswordEncoder.encode((String)pMap.get("emp_new_pw")));
		}
		
		int result = 0;//0:��������, 1:��������
		result = sqlScvDao.updateEmpPrivate(pMap);//���Ǿ��̵�
		Map<String, Object> rMap = new HashMap<String, Object>();
		rMap.put("result", result);
		return rMap;
		
	}
	public List<Map<String, Object>> getScvList(int emp_no) {
		logger.info("getScvList ȣ�� ����");
		List<Map<String,Object>> scvList = null;
		scvList = sqlScvDao.getScvList(emp_no);
		
		return scvList;
	}
	
	public Map<String, Object> checkCurPw(int eno, String rawPw) {
		logger.info("checkCurPw ȣ�� ����");
		String encPw = sqlScvDao.getPw(eno);
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		
		System.out.println(rawPw+", " + encPw);
		if(bcryptPasswordEncoder.matches(rawPw, encPw)) {
			rMap.put("result", 1);
		} else {
			rMap.put("result", 0);
		}
		return rMap;
	}
	
}
