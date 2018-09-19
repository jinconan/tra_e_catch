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
	///////////////////////////////////////////////기획서////////////////////////////////////////

	/**
	 * 기획서 리스트 페이지 요청
	 * @param mod
	 * @param pageNo 페이지 번호
	 * @return plan/prop/propList
	 */
	@RequestMapping(value="/plan/view/propList", method=RequestMethod.GET)
	public String viewPropList(Model mod
			, @RequestParam(name="pageNo", defaultValue="1") int pageNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "plan/prop/propList";
	}
	
	/**
	 * 기획서 추가 페이지 요청
	 * @param mod
	 * @return plan/prop/propInsert
	 */
	@RequestMapping(value="/plan/view/propInsert")
	public String viewInsertProp(Model mod) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 작성");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/prop/propInsert";
	}
	
	/**
	 * 기획서 수정 페이지 요청
	 * @param mod
	 * @param propNo
	 * @return plan/prop/propUpdate
	 */
	@RequestMapping(value="/plan/view/propUpdate")
	public String viewUpdateProp(Model mod
			, @RequestParam(name="propNo", required=true) int propNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("propNo", propNo);
		return "plan/prop/propUpdate";
	}
	
	
	/**
	 * 기획서 상세페이지 요청
	 * @param mod
	 * @param propNo
	 * @return plan/prop/propDetail
	 */
	@RequestMapping(value="/plan/view/propDetail")
	public String viewProp(Model mod
			, @RequestParam("propNo") int propNo) {
		logger.info("viewProp()");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("propNo", propNo);
		return "plan/prop/propDetail";
	}
	
	
	
	///////////////////////////////////////////////프로젝트////////////////////////////////////////
	
	/**
	 * 프로젝트 추가 페이지 요청
	 * @param mod
	 * @return plan/proj/projInsert
	 */
	@RequestMapping("/plan/view/projInsert")
	public String viewProjInsert(Model mod) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "프로젝트 등록");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projInsert";
	}
	
	/**
	 * 프로젝트 수정 페이지 요청
	 * @param mod
	 * @return plan/proj/projUpdate
	 */
	@RequestMapping("/plan/view/projUpdate")
	public String viewProjUpdate(Model mod
			, @RequestParam(name="projNo", required=true) int projNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "프로젝트 정보");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projUpdate";
	}
	
	/**
	 * 프로젝트 전체 리스트 페이지 요청 (all, ing,end,stop)
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/plan/view/projList/{pstatus_name}")
	public String viewProjList(Model mod
			, @PathVariable(name="pstatus_name",required=true) String pstatus_name
			, @RequestParam(name="pageNo", defaultValue="1") int pageNo
			, @RequestParam(name="searchColumn", required=false) String searchColumn
			, @RequestParam(name="searchValue", required=false) String searchValue) {
		logger.info("viewProjList() 호출");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "프로젝트 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("pstatus_name",pstatus_name);
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("pageNo", pageNo);
		pMap.put("pstatus_name", pstatus_name);
		
		if(searchColumn != null) {
			pMap.put("serchColumn",  searchColumn);
			pMap.put("searchValue", searchValue);
		}
		List<Map<String,Object>> projList = planLogic.getProjList(pMap);
		mod.addAttribute("projList", projList);
		return "plan/proj/projList";
	}
	
	
	/**
	 * 프로젝트 상세 페이지 요청
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/projDetail")
	public String viewProjDetail(Model mod
			, @RequestParam("projNo") int projNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "프로젝트 정보");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		return "plan/proj/projDetail";
	}
	
	/**
	 * 프로젝트 멤버 리스트 페이지 요청
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/projMemberList")
	public String viewProjMemList(Model mod
			, @RequestParam("projNo") int projNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "참여자 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		return "plan/proj/projMemberList";
	}
	
	/**
	 * 프로젝트 타임라인 페이지 요청
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/projTimeline")
	public String viewProjTimeline(Model mod
			, @RequestParam("projNo") int projNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "타임라인");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		return "plan/proj/projTimeline";
	}
	
	/**
	 * 프로젝트 DIY게시판 관리 페이지 요청
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/projBoardConfig")
	public String viewBoardConfig(Model mod
			, @RequestParam("projNo") int projNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "게시판 관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		return "plan/proj/projBoardConfig";
	}
	
	//////////////////////////////////////DIY게시판 ////////////////////////////////////////////
	/**
	 * DIY게시판 리스트 페이지 요청
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
	 * DIY게시판 게시글 상세 페이지 요청
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
	 * DIY게시판 게시글 추가 페이지 요청
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
	 * DIY게시판 게시글 수정 페이지 요청
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
