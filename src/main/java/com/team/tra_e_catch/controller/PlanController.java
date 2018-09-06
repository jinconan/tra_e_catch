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
	
	@RequestMapping(value="/plan/prop/view/insert")
	public String viewInsertProp(Model mod) {
		logger.info("viewInsertProp()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� �ۼ�");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/prop/insertProp";
	}
	
	@RequestMapping(value="/plan/proj/view/list/{pageNumber}")
	public String viewProjList(Model mod) {
		logger.info("viewProjList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "��ü ������Ʈ ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projList";
	}
	
	@RequestMapping(value="/plan/proj/view/list/ing/{pageNumber}")
	public String viewProjIngList(Model mod) {
		logger.info("viewProjIngList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "������");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projList";
	}
	
	@RequestMapping(value="/plan/proj/view/list/end/{pageNumber}")
	public String viewProjEndList(Model mod) {
		logger.info("viewProjEndList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "����");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projList";
	}
	
	@RequestMapping(value="/plan/proj/view/list/stop/{pageNumber}")
	public String viewProjStopList(Model mod) {
		logger.info("viewProjStopList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "�ߴ�");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projList";
	}
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
	
	@RequestMapping(value="/plan/proj/view/memList/{projNo}")
	public String viewProjMemList(Model mod, @PathVariable int projNo) {
		logger.info("viewProjMemList()");
		ApplicationContext context = new ClassPathXmlApplicationContext("plan-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "���� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		return "plan/proj/projMemList";
	}
}
