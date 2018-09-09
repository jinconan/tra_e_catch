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

	///////////////////////////////////////////////��ȹ��////////////////////////////////////////

	/**
	 * ��ȹ�� ����Ʈ ������ ��û
	 * @param mod
	 * @param pageNumber
	 * @return plan/prop/propList
	 */
	@RequestMapping(value="/plan/prop/view/list/{pageNumber}")
	public String viewPropList(Model mod, @PathVariable int  pageNumber) {
		logger.info("viewPropList(pageNumber="+pageNumber+")");
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "plan/prop/propList";
	}
	
	/**
	 * ��ȹ�� �߰� ������ ��û
	 * @param mod
	 * @return plan/prop/insertProp
	 */
	@RequestMapping(value="/plan/prop/view/insert")
	public String viewInsertProp(Model mod) {
		logger.info("viewInsertProp()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� �ۼ�");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/prop/insertProp";
	}
	
	/**
	 * ��ȹ�� ���� ������ ��û
	 * @param mod
	 * @param propNo
	 * @return plan/prop/updateProp
	 */
	@RequestMapping(value="/plan/prop/view/update/{propNo}")
	public String viewUpdateProp(Model mod, @PathVariable int propNo) {
		logger.info("viewUpdateProp()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("propNo", propNo);
		return "plan/prop/updateProp";
	}
	
	
	/**
	 * ��ȹ�� �������� ��û
	 * @param mod
	 * @param propNo
	 * @return plan/prop/propDetail
	 */
	@RequestMapping(value="/plan/prop/view/detail/{propNo}")
	public String viewProp(Model mod, @PathVariable int propNo) {
		logger.info("viewProp()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("propNo", propNo);
		return "plan/prop/propDetail";
	}
	
	
	
	///////////////////////////////////////////////������Ʈ////////////////////////////////////////
	/**
	 * ������Ʈ ��ü ����Ʈ ������ ��û
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/plan/proj/view/list/{pageNumber}")
	public String viewProjList(Model mod) {
		logger.info("viewProjList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "��ü ������Ʈ ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projList";
	}
	
	/**
	 * ������Ʈ ������ ����Ʈ ������ ��û
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/plan/proj/view/list/ing/{pageNumber}")
	public String viewProjIngList(Model mod) {
		logger.info("viewProjIngList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "������");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projList";
	}
	
	/**
	 * ������Ʈ ���� ����Ʈ ������ ��û
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/plan/proj/view/list/end/{pageNumber}")
	public String viewProjEndList(Model mod) {
		logger.info("viewProjEndList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "����");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projList";
	}
	
	/**
	 * ������Ʈ �ߴ� ����Ʈ ������ ��û
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/plan/proj/view/list/stop/{pageNumber}")
	public String viewProjStopList(Model mod) {
		logger.info("viewProjStopList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "�ߴ�");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projList";
	}
	
	/**
	 * ������Ʈ �� ������ ��û
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/proj/view/detail/{projNo}")
	public String viewProjDetail(Model mod, @PathVariable int projNo) {
		logger.info("viewProjDetail()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "������Ʈ ����");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		return "plan/proj/projDetail";
	}
	
	/**
	 * ������Ʈ ��� ����Ʈ ������ ��û
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/proj/view/memList/{projNo}")
	public String viewProjMemList(Model mod, @PathVariable int projNo) {
		logger.info("viewProjMemList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
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
	@RequestMapping(value="/plan/proj/view/timeline/{projNo}")
	public String viewProjTimeline(Model mod, @PathVariable int projNo) {
		logger.info("viewProjTimeline()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
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
	@RequestMapping(value="/plan/proj/view/boardConfig/{projNo}")
	public String viewBoardConfig(Model mod, @PathVariable int projNo) {
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "�Խ��� ����");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		return "plan/proj/projBoardConfig";
	}
	
	//////////////////////////////////////DIY�Խ��� ////////////////////////////////////////////
	/**
	 * DIY�Խ��� ����Ʈ ������ ��û
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
	 * DIY�Խ��� �Խñ� �� ������ ��û
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
	 * DIY�Խ��� �Խñ� ���� ������ ��û
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
	 * DIY�Խ��� �Խñ� �߰� ������ ��û
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
