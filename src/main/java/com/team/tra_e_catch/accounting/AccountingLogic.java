package com.team.tra_e_catch.accounting;

<<<<<<< HEAD
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountingLogic {
	Logger logger = Logger.getLogger(AccountingLogic.class);
	@Autowired
	private SqlAccDao sqlAccDao = null;
	
	
=======
import java.util.List;
import java.util.Map;

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
	
	public List<Map<String, Object>> teamR_Logic(int counts) {
		logger.info("TeamR_Logic����");
		List<Map<String, Object>> s = null;
		s = sqlAccDao.Team_Dao(counts);
		return s;
	}
>>>>>>> refs/heads/cw_09181
}
