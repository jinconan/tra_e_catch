package com.team.tra_e_catch.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.tra_e_catch.plan.PlanLogic;

@Controller
public class PlanController {
	
	private static final	Logger				logger	= Logger.getLogger(PlanController.class);
	private final 			ApplicationContext	context = new ClassPathXmlApplicationContext("submenu/plan-submenu.xml");
	@Autowired
	private PlanLogic planLogic;
	///////////////////////////////////////////////��ȹ��////////////////////////////////////////

	/**
	 * ��ȹ�� ����Ʈ ������ ��û
	 * @param mod
	 * @param pageNo ������ ��ȣ
	 * @return plan/prop/propList
	 */
	@RequestMapping(value="/plan/view/propList", method=RequestMethod.GET)
	public String viewPropList(Model mod
			, @RequestParam(name="pageNo", defaultValue="1") int pageNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "plan/prop/propList";
	}
	
	/**
	 * ��ȹ�� �߰� ������ ��û
	 * @param mod
	 * @return plan/prop/propInsert
	 */
	@RequestMapping(value="/plan/view/propInsert")
	public String viewInsertProp(Model mod) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� �ۼ�");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/prop/propInsert";
	}
	
	/**
	 * ��ȹ�� ���� ������ ��û
	 * @param mod
	 * @param propNo
	 * @return plan/prop/propUpdate
	 */
	@RequestMapping(value="/plan/view/propUpdate")
	public String viewUpdateProp(Model mod
			, @RequestParam(name="propNo", required=true) int propNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("propNo", propNo);
		return "plan/prop/propUpdate";
	}
	
	
	/**
	 * ��ȹ�� �������� ��û
	 * @param mod
	 * @param propNo
	 * @return plan/prop/propDetail
	 */
	@RequestMapping(value="/plan/view/propDetail")
	public String viewProp(Model mod
			, @RequestParam("propNo") int propNo) {
		logger.info("viewProp()");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("propNo", propNo);
		return "plan/prop/propDetail";
	}
	
	
	
	///////////////////////////////////////////////������Ʈ////////////////////////////////////////
	
	/**
	 * ������Ʈ �߰� ������ ��û
	 * @param mod
	 * @return plan/proj/projInsert
	 */
	@RequestMapping("/plan/view/projInsert")
	public String viewProjInsert(Model mod) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "������Ʈ ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projInsert";
	}
	
	/**
	 * ������Ʈ ���� ������ ��û
	 * @param mod
	 * @return plan/proj/projUpdate
	 */
	@RequestMapping("/plan/view/projUpdate")
	public String viewProjUpdate(Model mod
			, @RequestParam(name="projNo", required=true) int projNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "������Ʈ ����");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		return "plan/proj/projUpdate";
	}
	
	/**
	 * ������Ʈ ��ü ����Ʈ ������ ��û (all, ing,end,stop)
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/plan/view/projList/{pstatus_name}")
	public String viewProjList(Model mod
			, @PathVariable(name="pstatus_name",required=true) String pstatus_name
			, @RequestParam(name="pageNo", defaultValue="1") int pageNo
			, @RequestParam(name="searchColumn", required=false) String searchColumn
			, @RequestParam(name="searchValue", required=false) String searchValue) {

		logger.info("viewProjList()");
		logger.info("pstatus_name : " + pstatus_name +", pageNo : " + pageNo);
		logger.info("searchColumn : " + searchColumn + ", searchValue : " + searchValue); 
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "������Ʈ ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("pstatus_name",pstatus_name);
		mod.addAttribute("pageNo",pageNo);
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("pageNo", pageNo);
		pMap.put("pstatus_name", pstatus_name);
		
		if(searchColumn != null) {
			pMap.put("searchColumn",  searchColumn);
			pMap.put("searchValue", searchValue);
		}
		Map<String, Object> logicResult = planLogic.getProjList(pMap);
		
		mod.addAttribute("projList", logicResult.get("projList"));
		mod.addAttribute("numOfProjPage",logicResult.get("numOfProjPage"));
		return "plan/proj/projList";
	}
	
	
	/**
	 * ������Ʈ �� ������ ��û
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/projDetail")
	public String viewProjDetail(Model mod
			, @RequestParam(value="projNo", required=true) int projNo) {
		logger.info("viewProjDetail()");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "������Ʈ ����");
		mod.addAttribute("subMenuList", subMenuList);
		
		Map<String, Object> projDetail = planLogic.getProjDetail(projNo);
		mod.addAttribute("projDetail", projDetail);
		
		return "plan/proj/projDetail";
	}
	
	/**
	 * ������Ʈ ��� ����Ʈ ������ ��û
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/projMemberList")
	public String viewProjMemList(Model mod
			, @RequestParam("projNo") int projNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "������ ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		return "plan/proj/projMemberList";
	}
	
	/**
	 * ������Ʈ Ÿ�Ӷ��� ������ ��û
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/projTimeline")
	public String viewProjTimeline(Model mod
			, @RequestParam("projNo") int projNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "Ÿ�Ӷ���");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		return "plan/proj/projTimeline";
	}
	
	/**
	 * ������Ʈ DIY�Խ��� ���� ������ ��û
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/projBoardConfig")
	public String viewBoardConfig(Model mod
			, @RequestParam("projNo") int projNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "�Խ��� ����");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		return "plan/proj/projBoardConfig";
	}
	
	
	@RequestMapping("/plan/projInsert")
	public String projInsert(@RequestParam("projName") String projName
			, @RequestParam("startDate") String startDate
			, @RequestParam("endSchedDate") String endSchedDate) {
		logger.info("projInsert("+projName+", "+startDate+", "+endSchedDate+")");
		
		int result = planLogic.insertProj(projName,startDate,endSchedDate);
		
		return "redirect:/plan/view/projList/all";
	}
	
	@RequestMapping("/plan/projDelete")
	public String projDelete(@RequestParam(value="projNo", required=true) int projNo) {
		logger.info("projDelete("+projNo+")");
		int result = planLogic.deleteProj(projNo);
		return "redirect:/plan/view/projList/all";
	}
	//////////////////////////////////////DIY�Խ��� ////////////////////////////////////////////
	/**
	 * DIY�Խ��� ����Ʈ ������ ��û
	 * @param mod
	 * @param projNo
	 * @param boardNo
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/diyBoardList")
	public String viewBoardList(Model mod
			, @RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo
			, @RequestParam("pageNo") int pageNo
			) {
		return "plan/proj/diy/diyBoardList";
	}
	
	/**
	 * DIY�Խ��� �Խñ� �� ������ ��û
	 * @param mod
	 * @param projNo
	 * @param boardNo
	 * @param articleNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/diyBoardDetail")
	public String viewBoardDetail(Model mod
			, @RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo
			, @RequestParam("articleNo") int articleNo) {
		
		return "plan/proj/diy/diyBoardDetail";
	}
	
	/**
	 * DIY�Խ��� �Խñ� �߰� ������ ��û
	 * @param mod
	 * @param projNo
	 * @param boardNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/diyBoardInsert")
	public String viewBoardUpdate(Model mod
			, @RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo) {
		
		return "plan/proj/diy/diyBoardInsert";
	}
	
	/**
	 * DIY�Խ��� �Խñ� ���� ������ ��û
	 * @param mod
	 * @param projNo
	 * @param boardNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/diyBoardUpdate")
	public String viewBoardUpdate(Model mod
			, @RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo
			, @RequestParam("articleNo") int articleNo) {
		
		return "plan/proj/diy/diyBoardUpdate";
	}
	
}
