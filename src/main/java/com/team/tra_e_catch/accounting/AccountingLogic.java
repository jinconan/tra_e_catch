package com.team.tra_e_catch.accounting;


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
	
	public List<Map<String, Object>> t_teamR_Logic() {
		logger.info("t_TeamR_Logic진입");
		List<Map<String, Object>> s = null;
		s = sqlAccDao.t_Team_Dao();
		gbrun(s);
		return s;
	}
	
	public List<Map<String, Object>> b_teamR_Logic() {
		logger.info("b_TeamR_Logic진입");
		List<Map<String, Object>> s = null;
		s = sqlAccDao.b_Team_Dao();
		gbrun(s);
		return s;
	}
	
	private void gbrun(List<Map<String, Object>> s) {
		for(Map<String, Object> map: s) {
			if(map.get("구분").equals("고정자산")) {
				map.put("고정자산",map.get("금액"));
				map.put("비용",0);
				map.put("수입",0);
			}else if(map.get("구분").equals("지출")) {
				map.put("비용",map.get("금액"));
				map.put("고정자산",0);
				map.put("수입",0);
			}else {
				map.put("비용",0);
				map.put("고정자산",0);
				map.put("수입",map.get("금액"));
			}
		}
	}

}
