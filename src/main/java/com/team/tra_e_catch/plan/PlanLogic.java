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
	 * ������Ʈ ����Ʈ ���������� ��Ÿ���� ������Ʈ���� ���ϴ� �޼ҵ�
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getProjList(Map<String, Object> pMap) {
		logger.info("getProjList() ȣ��");
		
		if("ing".equals((String)pMap.get("pstatus_name"))) {
			pMap.put("pstatus_name", "������");
		} else if("end".equals((String)pMap.get("pstatus_name"))) {
			pMap.put("pstatus_name", "����");
		} else if("stop".equals((String)pMap.get("pstatus_name"))) {
			pMap.put("pstatus_name", "�ߴ�");
		} 
			
		
		List<Map<String,Object>> projList = sqlPlanDao.getProjList(pMap);
		return projList;
	}
}
