package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/plan")
public class PlanController {
	
	private static final Logger logger = Logger.getLogger(PlanController.class);

	@RequestMapping(value="/prop/view/propList/{pageNumber}")
	public String viewPropList(Model mod, @PathVariable int  pageNumber) {
		logger.info("viewPropList(pageNumber="+pageNumber+")");
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		ApplicationContext context = new ClassPathXmlApplicationContext("auto-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		
		
		return "plan/prop/propList";
	}
	
	@RequestMapping(value="/prop/view/insertProp")
	public String viewInsertProp(Model mod, @RequestParam Map<String,Object> pMap) {
		logger.info("viewInsertProp()");
		logger.info("parameter : " + pMap);
		ApplicationContext context = new ClassPathXmlApplicationContext("auto-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� �ۼ�");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/prop/insertProp";
	}
}
