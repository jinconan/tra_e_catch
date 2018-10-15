package com.team.tra_e_catch.REST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.tra_e_catch.plan.PlanLogic;

@RestController
@RequestMapping(value="/planR")
public class PlanREST {
	Logger logger = Logger.getLogger(PlanREST.class);
	@Autowired
	private PlanLogic planLogic;

	@RequestMapping("/json/projTimeline")
	public Map<String,Object> getTimeLineJson(@RequestParam("projNo") int projNo
			,@RequestParam(value="isToday", defaultValue="true") String isToday) {
		return planLogic.getJsonProjTimeline(projNo, Boolean.parseBoolean(isToday));
	}
	
	@RequestMapping("/json/projMemberList")
	public List<Map<String,Object>> getMemberListJson(@RequestParam("projNo") int projNo) {
		return planLogic.getJsonProjMemberList(projNo);
	}
	
	@RequestMapping("/json/projMemberCharts")
	public Map<String ,Object> getProjMemberChartsJson(@RequestParam("projNo") int projNo) {
		return planLogic.getJsonProjMemberCharts(projNo);
	}
	
	
	@RequestMapping("/json/notProjMemberList")
	public List<Map<String,Object>> getNotMemberListJson(@RequestParam("projNo") int projNo) {
		return planLogic.getJsonNotProjMemberList(projNo);
	}
	
	@RequestMapping("/json/projBoardList")
	public List<Map<String,Object>> getProjBoardListJson(@RequestParam("projNo") int projNo) {
		return planLogic.getProjBoardList(projNo);
	}
	
	@RequestMapping("/json/propList")
	public Map<String, Object> getPropList(
			@RequestParam(name="pageNo", defaultValue="1") int pageNo
			, @RequestParam(name="searchColumn", required=false) String searchColumn
			, @RequestParam(name="searchValue", required=false) String searchValue) {
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("pageNo", pageNo);
		if(searchColumn != null) {
			pMap.put("searchColumn", searchColumn);
			pMap.put("searchValue", searchValue);
		}
		Map<String, Object> logicResult = planLogic.getPropList(pMap);
		
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("rows",logicResult.get("propList"));
		rMap.put("total", logicResult.get("numOfPropPage"));
		return rMap;
	}
}
