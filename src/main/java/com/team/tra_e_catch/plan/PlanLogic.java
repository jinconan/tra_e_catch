package com.team.tra_e_catch.plan;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	public Map<String, Object> getPropList(Map<String, Object> pMap) {
		logger.info("getPropList");
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> propList = sqlPlanDao.getPropList(pMap);
		int numOfPropPage = sqlPlanDao.getNumOfPropPage(pMap);
		
		result.put("propList", propList);
		result.put("numOfPropPage", numOfPropPage);
		
		return result;
	}

	public int insertProp(Map<String, Object> pMap) {
		logger.info("insertProp");
		int result = sqlPlanDao.insertProp(pMap);
		return result;
	}
	/**
	 * 프로젝트 리스트 페이지에서 나타나는 프로젝트들을 구하는 메소드
	 * @param pMap
	 * @return Map<String, Object> : ("projList", List<Map<String,Object>>), ("numOfProjPage",int)
	 */
	public Map<String, Object> getProjList(Map<String, Object> pMap) {
		logger.info("getProjList() 호출");
		Map<String, Object> result = new HashMap<String, Object>();
		
		if("ing".equals((String)pMap.get("pstatus_name"))) {
			pMap.put("pstatus_name", "진행중");
		} else if("end".equals((String)pMap.get("pstatus_name"))) {
			pMap.put("pstatus_name", "종료");
		} else if("stop".equals((String)pMap.get("pstatus_name"))) {
			pMap.put("pstatus_name", "중단");
		} 
		
		List<Map<String,Object>> projList = sqlPlanDao.getProjList(pMap);
		int numOfProjPage = sqlPlanDao.getNumOfProjPage(pMap);
		result.put("projList", projList);
		result.put("numOfProjPage", numOfProjPage);
		
		return result;
	}
	
	public boolean getProjLeader(int empNo, int projNo) {
		logger.info("getProjLeader() 호출");
		return sqlPlanDao.getProjLeader(empNo,projNo);
	}

	public boolean isMember(int projNo, int empNo) {
		logger.info("isLeader() 호출");
		return sqlPlanDao.isMember(projNo,empNo);
	}
	
	/**
	 * 프로젝트 상세 페이지에서 나타나는 프로젝트 상세정보를 구하는 메소드
	 * @param projNo
	 * @return
	 */
	public Map<String, Object> getProjDetail(int projNo) {
		logger.info("getProjDetail() 호출");
		return sqlPlanDao.getProjDetail(projNo);
	}
	
	/**
	 * 프로젝트의 일정 리스트를 구하는 메소드
	 * @param projNo
	 * @param isToday
	 * @return
	 */
	public Map<String,Object> getJsonProjTimeline(int projNo, boolean isToday) {
		logger.info("getJsonProjTimeline()");
		Map<String,Object> result = new HashMap<String, Object>();
		
		Map<String,Object> pMap = new HashMap<String, Object>();
		pMap.put("proj_no",projNo);
		pMap.put("isToday", isToday);
		List<Map<String, Object>> timelineList = sqlPlanDao.getJsonProjTimeline(pMap);
		
		List<Map<String,Object>> cols = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		Map<String,Object> colMap = new HashMap<String,Object>();
		
		//컬럼 세팅
		colMap.put("id", "sched_name");
		colMap.put("type", "string");
		cols.add(colMap);

		colMap = new HashMap<String,Object>();
		colMap.put("id", "start_date");
		colMap.put("type", "date");
		cols.add(colMap);

		colMap = new HashMap<String,Object>();
		colMap.put("id", "end_date");
		colMap.put("type", "date");
		cols.add(colMap);
		
		result.put("cols", cols);
		
		//로우 세팅
		for(Map<String,Object> tlMap : timelineList) {
			List<Map<String,Object>> schedRow = new ArrayList<Map<String,Object>>();
			Map<String,Object> vMap = new HashMap<String,Object>();
			
			vMap.put("v",tlMap.get("sched_name"));
			schedRow.add(vMap);
			
			vMap = new HashMap<String,Object>();
			vMap.put("v",tlMap.get("start_date"));
			schedRow.add(vMap);
			
			vMap = new HashMap<String,Object>();
			vMap.put("v",tlMap.get("end_date"));
			schedRow.add(vMap);

			Map<String,Object> rowMap = new HashMap<String,Object>();
			rowMap.put("c",schedRow);
			rowMap.put("schedNo", tlMap.get("sched_no"));
			rows.add(rowMap);
		}
		
		result.put("rows", rows);
		
		return result;
	}

	/**
	 * 프로젝트 테이블에 프로젝트 추가. 멤버는 여기서 추가X
	 * @param empNo 
	 * @param projName
	 * @param startDate
	 * @param endSchedDate
	 * @return
	 */
	public int insertProj(int empNo, String projName, String startDate, String endSchedDate) {
		logger.info("insertProj");
		Map<String, Object> pMap = new HashMap<String, Object>();
		
		pMap.put("emp_no", empNo);
		pMap.put("proj_name", projName);
		pMap.put("start_date", startDate);
		pMap.put("end_sched_date", endSchedDate);
		
		int result = sqlPlanDao.insertProj(pMap);
		if(result != 0) {
			pMap.put("rtype_no", 101);
			result = sqlPlanDao.insertMember(pMap);
		}
		return result;
	}

	public int deleteProj(int projNo) {
		logger.info("deleteProj");
		int result = sqlPlanDao.deleteProj(projNo);
		return result;
	}

	public int updateProj(Map<String, Object> pMap) {
		logger.info("updateProj");
		
		if(pMap.containsKey("projNo"))
			pMap.put("proj_no", pMap.get("projNo"));
		if(pMap.containsKey("projName"))
			pMap.put("proj_name", pMap.get("projName"));
		if(pMap.containsKey("startDate"))
			pMap.put("start_date", pMap.get("startDate"));
		if(pMap.containsKey("endSchedDate"))
			pMap.put("end_sched_date", pMap.get("endSchedDate"));
		if(pMap.containsKey("endDate"))
			pMap.put("end_date", pMap.get("endDate"));
		if(pMap.containsKey("pstatusNo"))
			pMap.put("pstatus_no", pMap.get("pstatusNo"));
		if(pMap.containsKey("prodNo"))
			pMap.put("prod_no", pMap.get("prodNo"));
		if(pMap.containsKey("firstPay"))
			pMap.put("first_pay", pMap.get("firstPay"));
		
		int result = sqlPlanDao.updateProj(pMap);
		return result;
	}
	
	public int insertTimeline(Map<String,Object> pMap) {
		logger.info("insertTimeline");
		
		if(pMap.containsKey("projNo"))
			pMap.put("proj_no", pMap.get("projNo"));
		if(pMap.containsKey("schedName"))
			pMap.put("sched_name", pMap.get("schedName"));
		if(pMap.containsKey("startDate"))
			pMap.put("start_date", pMap.get("startDate"));
		if(pMap.containsKey("endDate"))
			pMap.put("end_date", pMap.get("endDate"));
		return sqlPlanDao.insertTimeline(pMap);
	}
	
	public int updateTimeline(Map<String,Object> pMap) {
		logger.info("updateTimeline");
		
		if(pMap.containsKey("projNo"))
			pMap.put("proj_no", pMap.get("projNo"));
		if(pMap.containsKey("schedNo"))
			pMap.put("sched_no", pMap.get("schedNo"));
		if(pMap.containsKey("schedName"))
			pMap.put("sched_name", pMap.get("schedName"));
		if(pMap.containsKey("startDate"))
			pMap.put("start_date", pMap.get("startDate"));
		if(pMap.containsKey("endDate"))
			pMap.put("end_date", pMap.get("endDate"));
		return sqlPlanDao.updateTimeline(pMap);
	}
	public int deleteTimeline(Map<String,Object> pMap) {
		logger.info("deleteTimeline");
		
		if(pMap.containsKey("projNo"))
			pMap.put("proj_no", pMap.get("projNo"));
		if(pMap.containsKey("schedNo"))
			pMap.put("sched_no", pMap.get("schedNo"));
		return sqlPlanDao.deleteTimeline(pMap);
	}

	public List<Map<String, Object>> getJsonProjMemberList(int projNo) {
		logger.info("getJsonProjMemberList");
		return sqlPlanDao.getJsonProjMemberList(projNo);
	}

	public int insertMember(Map<String, Object> pMap) {
		logger.info("insertMember");
		if(pMap.containsKey("projNo"))
			pMap.put("proj_no", pMap.get("projNo"));
		if(pMap.containsKey("empNo"))
			pMap.put("emp_no", pMap.get("empNo"));
		
		return sqlPlanDao.insertMember(pMap);
	}

	public int deleteMember(Map<String, Object> pMap) {
		logger.info("deleteMember");
		if(pMap.containsKey("projNo"))
			pMap.put("proj_no", pMap.get("projNo"));
		if(pMap.containsKey("empNo"))
			pMap.put("emp_no", pMap.get("empNo"));
		return sqlPlanDao.deleteMember(pMap);
	}

	public int updateMember(Map<String, Object> pMap) {
		logger.info("updateMember");
		if(pMap.containsKey("projNo"))
			pMap.put("proj_no", pMap.get("projNo"));
		if(pMap.containsKey("empNo"))
			pMap.put("emp_no", pMap.get("empNo"));
		if(pMap.containsKey("roleName")) {
			if("팀장".equals(pMap.get("roleName")))
				pMap.put("rtype_no",101);
			else
				pMap.put("rtype_no", 102);
		}
		return sqlPlanDao.updateMember(pMap);
	}

	public List<Map<String, Object>> getJsonNotProjMemberList(int projNo) {
		logger.info("getJsonNotProjMemberList");
		return sqlPlanDao.getJsonNotProjMemberList(projNo);
	}

	public List<Map<String, Object>> getProjBoardList(int projNo) {
		logger.info("getProjBoardList : projNo=" +projNo);
		return sqlPlanDao.getProjBoardList(projNo);
	}

	public int insertProjBoard(Map<String, Object> pMap) {
		logger.info("insertProjBoard : " +pMap);
		return sqlPlanDao.insertProjBoard(pMap);
	}

	public int deleteProjBoard(Map<String, Object> pMap) {
		logger.info("deleteProjBoard : " +pMap);
		return sqlPlanDao.deleteProjBoard(pMap);
	}

	public int updateProjBoard(Map<String, Object> pMap) {
		logger.info("updateProjBoard : " +pMap);
		return sqlPlanDao.updateProjBoard(pMap);
	}

	public Map<String, Object> getArticleList(Map<String, Object> pMap) {
		logger.info("getArticleList");
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Map<String, Object>> articleList = sqlPlanDao.getArticleList(pMap);
		int numOfArticlePage = sqlPlanDao.getNumOfArticlePage(pMap);
		List<Map<String,Object>> projBoardList = sqlPlanDao.getProjBoardList((Integer)pMap.get("proj_no"));
		result.put("articleList", articleList);
		result.put("numOfArticlePage", numOfArticlePage);
		result.put("projBoardList", projBoardList);
		return result;
	}

	public int insertArticle(Map<String, Object> pMap) {
		logger.info("insertArticle");
		int result = sqlPlanDao.insertArticle(pMap);
		return result;
	}

	public Map<String, Object> getArticleDetail(int articleNo) {
		logger.info("getArticleDetail");
		int hit = sqlPlanDao.hitArticle(articleNo);
		Map<String,Object> result = sqlPlanDao.getArticleDetail(articleNo);
		
		return result;
	}

	public int deleteArticle(int articleNo) {
		logger.info("deleteArticle");
		int result = sqlPlanDao.deleteArticle(articleNo);
		return result;
	}

	public int updateArticle(Map<String, Object> pMap) {
		logger.info("updateArticle");
		int result = sqlPlanDao.updateArticle(pMap);
		return result;
	}

	

	
	

	
}
