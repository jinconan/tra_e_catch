package com.team.tra_e_catch.REST;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.tra_e_catch.plan.PlanLogic;

/*
 * Ŭ������ : PlanREST 
 * �ۼ��� : Lee Jin
 * ��¥ : 2018-09-23
 */

@RestController
@RequestMapping(value="/planR")
public class PlanREST {
	Logger logger = Logger.getLogger(PlanREST.class);
	@Autowired
	private PlanLogic planLogic;
	
	/**
	 * ���� json ���� ��û
	 * @param projNo
	 * @param isToday
	 * @return
	 */
	@RequestMapping("/json/projTimeline")
	public Map<String,Object> getTimeLineJson(@RequestParam("projNo") int projNo
			,@RequestParam(value="isToday", defaultValue="true") String isToday) {
		
		return planLogic.getJsonProjTimeline(projNo, Boolean.parseBoolean(isToday));
	}
	
	@RequestMapping("/json/projMemberList")
	public List<Map<String,Object>> getMemberListJson(@RequestParam("projNo") int projNo) {
		return planLogic.getJsonProjMemberList(projNo);
	}
	
	@RequestMapping("/json/notProjMemberList")
	public List<Map<String,Object>> getNotMemberListJson(@RequestParam("projNo") int projNo) {
		return planLogic.getJsonNotProjMemberList(projNo);
	}
}
