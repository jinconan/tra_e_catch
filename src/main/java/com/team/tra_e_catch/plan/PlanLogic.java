package com.team.tra_e_catch.plan;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanLogic {
	private final Logger logger = Logger.getLogger(PlanLogic.class);

	@Autowired
	private SqlPlanDao sqlPlanDao;

	/**
	 * 프로젝트 리스트 페이지에서 나타나는 프로젝트들을 구하는 메소드
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getProjList(Map<String, Object> pMap) {
		logger.info("getProjList() 호출");
		
		if("ing".equals((String)pMap.get("pstatus_name"))) {
			pMap.put("pstatus_name", "진행중");
		} else if("end".equals((String)pMap.get("pstatus_name"))) {
			pMap.put("pstatus_name", "종료");
		} else if("stop".equals((String)pMap.get("pstatus_name"))) {
			pMap.put("pstatus_name", "중단");
		} 
			
		
		List<Map<String,Object>> projList = sqlPlanDao.getProjList(pMap);
		return projList;
	}
}
