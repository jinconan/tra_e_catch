package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlanController {
	
	private static final Logger logger = Logger.getLogger(PlanController.class);

	///////////////////////////////////////////////기획서////////////////////////////////////////

	/**
	 * 기획서 리스트 페이지 요청
	 * @param mod
	 * @param pageNumber
	 * @return plan/prop/propList
	 */
	@RequestMapping(value="/plan/prop/view/list/{pageNumber}")
	public String viewPropList(Model mod, @PathVariable int  pageNumber) {
		logger.info("viewPropList(pageNumber="+pageNumber+")");
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "plan/prop/propList";
	}
	
	/**
	 * 기획서 추가 페이지 요청
	 * @param mod
	 * @return plan/prop/insertProp
	 */
	@RequestMapping(value="/plan/prop/view/insert")
	public String viewInsertProp(Model mod) {
		logger.info("viewInsertProp()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 작성");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/prop/insertProp";
	}
	
	/**
	 * 기획서 수정 페이지 요청
	 * @param mod
	 * @param propNo
	 * @return plan/prop/updateProp
	 */
	@RequestMapping(value="/plan/prop/view/update/{propNo}")
	public String viewUpdateProp(Model mod, @PathVariable int propNo) {
		logger.info("viewUpdateProp()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("propNo", propNo);
		return "plan/prop/updateProp";
	}
	
	
	/**
	 * 기획서 상세페이지 요청
	 * @param mod
	 * @param propNo
	 * @return plan/prop/propDetail
	 */
	@RequestMapping(value="/plan/prop/view/detail/{propNo}")
	public String viewProp(Model mod, @PathVariable int propNo) {
		logger.info("viewProp()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("propNo", propNo);
		return "plan/prop/propDetail";
	}
	
	
	
	///////////////////////////////////////////////프로젝트////////////////////////////////////////
	/**
	 * 프로젝트 전체 리스트 페이지 요청
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/plan/proj/view/list/{pageNumber}")
	public String viewProjList(Model mod) {
		logger.info("viewProjList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "전체 프로젝트 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projList";
	}
	
	/**
	 * 프로젝트 진행중 리스트 페이지 요청
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/plan/proj/view/list/ing/{pageNumber}")
	public String viewProjIngList(Model mod) {
		logger.info("viewProjIngList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "진행중");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projList";
	}
	
	/**
	 * 프로젝트 종료 리스트 페이지 요청
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/plan/proj/view/list/end/{pageNumber}")
	public String viewProjEndList(Model mod) {
		logger.info("viewProjEndList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "종료");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projList";
	}
	
	/**
	 * 프로젝트 중단 리스트 페이지 요청
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/plan/proj/view/list/stop/{pageNumber}")
	public String viewProjStopList(Model mod) {
		logger.info("viewProjStopList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "중단");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projList";
	}
	
	/**
	 * 프로젝트 상세 페이지 요청
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/proj/view/detail/{projNo}")
	public String viewProjDetail(Model mod, @PathVariable int projNo) {
		logger.info("viewProjDetail()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
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
	@RequestMapping(value="/plan/proj/view/memList/{projNo}")
	public String viewProjMemList(Model mod, @PathVariable int projNo) {
		logger.info("viewProjMemList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
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
	@RequestMapping(value="/plan/proj/view/timeline/{projNo}")
	public String viewProjTimeline(Model mod, @PathVariable int projNo) {
		logger.info("viewProjTimeline()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
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
	@RequestMapping(value="/plan/proj/view/boardConfig/{projNo}")
	public String viewBoardConfig(Model mod, @PathVariable int projNo) {
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
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
	 * @return
	 */
	@RequestMapping(value="/plan/proj/board/view/{projNo}/{boardNo}")
	public String viewBoardList(Model mod, @PathVariable int projNo, @PathVariable int boardNo) {
		
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
	@RequestMapping(value="/plan/proj/board/view/detail/{projNo}/{boardNo}/{articleNo}")
	public String viewBoardDetail(Model mod, 
			@PathVariable int projNo, @PathVariable int boardNo, @PathVariable int articleNo) {
		
		return "plan/proj/diy/diyBoardDetail";
	}
	
	/**
	 * DIY게시판 게시글 수정 페이지 요청
	 * @param mod
	 * @param projNo
	 * @param boardNo
	 * @return
	 */
	@RequestMapping(value="/plan/proj/board/view/update/{projNo}/{boardNo}/{articleNo}")
	public String viewBoardUpdate(Model mod, 
			@PathVariable int projNo, @PathVariable int boardNo, @PathVariable int articleNo) {
		
		return "plan/proj/diy/diyBoardUpdate";
	}
	/**
	 * DIY게시판 게시글 추가 페이지 요청
	 * @param mod
	 * @param projNo
	 * @param boardNo
	 * @return
	 */
	@RequestMapping(value="/plan/proj/board/view/insert/{projNo}/{boardNo}")
	public String viewBoardUpdate(Model mod, @PathVariable int projNo, @PathVariable int boardNo) {
		
		return "plan/proj/diy/diyBoardInsert";
	}
}
