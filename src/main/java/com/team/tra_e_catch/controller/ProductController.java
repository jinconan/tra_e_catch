package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.multipart.support.RequestPartServletServerHttpRequest;

import com.team.tra_e_catch.product.ProductLogic;

@Controller
public class ProductController {
	
	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	@RequestMapping(value="/prod/prodCRUD/prodCRUD")
	public String viewProdCRUD(Model mod, @RequestParam Map<String,Object> pMap) {
		logger.info("viewProdCRUD()");
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		ApplicationContext context = new ClassPathXmlApplicationContext("product-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/prodCRUD/prodCRUD";
	}
	@RequestMapping(value="/prod/prodinven/prodInven")
	public String viewProdInven(Model mod, @RequestParam Map<String,Object> pMap) {
		logger.info("viewProdInven()");
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		ApplicationContext context = new ClassPathXmlApplicationContext("product-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubxMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/prodinven/prodInven";
	}
	@RequestMapping(value="/prod/prodstat/prodStat")
	public String viewProdstat(Model mod, @RequestParam Map<String,Object> pMap) {
		logger.info("viewProdstat()");
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		ApplicationContext context = new ClassPathXmlApplicationContext("product-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/prodstat/prodStat";
	}
	@RequestMapping(value="/prod/prodtran/prodTran")
	public String viewProdTran(Model mod, @RequestParam Map<String,Object> pMap) {
		logger.info("viewProdTran()");
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		ApplicationContext context = new ClassPathXmlApplicationContext("product-submenu.xml");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/prodtran/prodTran";
	}
	
	
	
	
	

}
