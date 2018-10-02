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
		int result = 0;//0:��������, 1:��������
		result = sqlScvDao.modify(pMap);//���Ǿ��̵�
		return result;
		
	}
	public List<Map<String, Object>> getScvList(int emp_no) {
		logger.info("getScvList ȣ�� ����");
		List<Map<String,Object>> scvList = null;
		//�� Dao���� �޼ҵ带 �и����� �ʴ°���? - ���� sql���� ����ϴϱ�
		scvList = sqlScvDao.getScvList(emp_no);
		
		return scvList;
	}
	
}
