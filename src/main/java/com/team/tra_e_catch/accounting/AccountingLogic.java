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
 * 클래스명 : AccountingController
 * 작성자 : 신철우
 * 날짜 : 2018-08-31
 * init메서드 : AccountingController
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
	 * init데이터 : 전표 리스트 번호 
	 * out데이터 : 전표 리스트
	 * 용도 : 전표리스트 를 출력하기 위한 로직
	 * 비고 : x
	 */
	
	public List<Map<String, Object>> teamR_Logic(int counts) {
		logger.info("TeamR_Logic진입");
		List<Map<String, Object>> s = null;
		s = sqlAccDao.Team_Dao(counts);
		return s;
	}
>>>>>>> refs/heads/cw_09181
}
