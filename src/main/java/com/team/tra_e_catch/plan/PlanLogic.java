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

	/**
	 * ������Ʈ ����Ʈ ���������� ��Ÿ���� ������Ʈ���� ���ϴ� �޼ҵ�
	 * @param pMap
	 * @return Map<String, Object> : ("projList", List<Map<String,Object>>), ("numOfProjPage",int)
	 */
	public Map<String, Object> getProjList(Map<String, Object> pMap) {
		logger.info("getProjList() ȣ��");
		Map<String, Object> result = new HashMap<String, Object>();
		
		if("ing".equals((String)pMap.get("pstatus_name"))) {
			pMap.put("pstatus_name", "������");
		} else if("end".equals((String)pMap.get("pstatus_name"))) {
			pMap.put("pstatus_name", "����");
		} else if("stop".equals((String)pMap.get("pstatus_name"))) {
			pMap.put("pstatus_name", "�ߴ�");
		} 
		
		List<Map<String,Object>> projList = sqlPlanDao.getProjList(pMap);
		int numOfProjPage = sqlPlanDao.getNumOfProjPage(pMap);

		result.put("projList", projList);
		result.put("numOfProjPage", numOfProjPage);
		
		return result;
	}
	
	/**
	 * ������Ʈ �� ���������� ��Ÿ���� ������Ʈ �������� ���ϴ� �޼ҵ�
	 * @param projNo
	 * @return
	 */
	public Map<String, Object> getProjDetail(int projNo) {
		logger.info("getProjDetail() ȣ��");
		Map<String,Object> result = sqlPlanDao.getProjDetail(projNo);
		return result;
	}
	
	/**
	 * ������Ʈ�� ���� ����Ʈ�� ���ϴ� �޼ҵ�
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
		
		//�÷� ����
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
		
		//�ο� ����
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
			rows.add(rowMap);
		}
		
		result.put("rows", rows);
		
		return result;
	}

	/**
	 * ������Ʈ ���̺� ������Ʈ �߰�. ����� ���⼭ �߰�X
	 * @param projName
	 * @param startDate
	 * @param endSchedDate
	 * @return
	 */
	public int insertProj(String projName, String startDate, String endSchedDate) {
		logger.info("insertProj");
		Map<String, Object> pMap = new HashMap<String, Object>();
		
		pMap.put("proj_name", projName);
		pMap.put("start_date", startDate);
		pMap.put("end_sched_date", endSchedDate);
		
		int result = sqlPlanDao.insertProj(pMap);
		return result;
	}

	public int deleteProj(int projNo) {
		logger.info("deleteProj");
		int result = sqlPlanDao.deleteProj(projNo);
		return result;
	}
	
	
}
