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
	private final ApplicationContext context = new ClassPathXmlApplicationContext("submenu/product-submenu.xml");
	
	@Autowired
	private ProductLogic productLogic;
	
	@RequestMapping(value="/prod/view/prodCRUD")
	public String viewProdCRUD(Model mod, @RequestParam Map<String,Object> pMap) {
		logger.info("viewProdCRUD()");
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "작업 지시서");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/prodCRUD/prodCRUD";
	}
	
	@RequestMapping(value="/prod/view/prodInven")
	public String viewProdInven(Model mod, @RequestParam Map<String,Object> pMap) {
		logger.info("viewProdInven()");
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubxMenu", "재고 관리");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/prodinven/prodInven";
	}
	
	@RequestMapping(value="/prod/view/prodStat")
	public String viewProdstat(Model mod, @RequestParam Map<String,Object> pMap) {
		logger.info("viewProdstat()");
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "상품 통계");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/prodstat/prodStat";
	}	
	
	@RequestMapping(value="/prod/view/prodStat_moon/{counts}", method = RequestMethod.GET)
	public String viewProdstat_moon(Model mod,@PathVariable int counts) {
		logger.info("viewProdstat()"+counts);
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		List<Map<String,Object>> moon_List = productLogic.moon_List_Logic();
		mod.addAttribute("curSubMenu", "상품 통계");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("moon_List", moon_List);
		mod.addAttribute("counts", counts);	
		return "prod/prodstat/prodStat_moon";
	}	
	
	@RequestMapping(value="/prod/view/prodStat_ct/{counts}/{day}/{yn}", method = RequestMethod.GET)
	public String viewProdstat_ct(Model mod,@PathVariable int counts,@PathVariable int day,@PathVariable int yn) {
		logger.info("viewProdstat()"+counts+day);
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		List<Map<String,Object>> moon_List = productLogic.moon_List_Logic();
		List<Map<String,Object>> ct_List = productLogic.ct_List_Logic();
		mod.addAttribute("curSubMenu", "상품 통계");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("ct_List", ct_List);
		logger.info(ct_List);
		mod.addAttribute("moon_List", moon_List);
		mod.addAttribute("counts", counts);	
		mod.addAttribute("day", day);	
		mod.addAttribute("yn", yn);	
		return "prod/prodstat/prodStat_ct";
	}	
	
	@RequestMapping(value="/prod/view/prodTran/{counts}")
	public String viewProdTran(Model mod, @RequestParam Map<String,Object> pMap,@PathVariable int counts) {
		logger.info("viewProdTran()");
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "거래 내역서");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);	
		return "prod/prodtran/prodTran";
	}
	
	@RequestMapping(value = "/Tran_list", method = RequestMethod.POST)
	public String wel_list(Model mod,@RequestParam Map<String, Object> pMap,@RequestParam Map<String,String> map) {
		logger.info("Tran_list진입");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		logger.info(map);
		String s = "?y=0";
		if (map.get("std").length()>1) {
			s += "&std="+map.get("std").substring(0, 11);
		}
		if (map.get("dtd").length()>1) {
			s += "&dtd=" + map.get("dtd").substring(0, 11);	
		}	
		if (map.get("spay").length()>1) {
			s += "&spay=" + map.get("spay");
		}
		if (map.get("dpay").length()>1) {
			s += "&dpay=" + map.get("dpay");
		} 
		if (map.get("opt").length()==2) {
			s += "&opt=" + map.get("opt");
		} 
		if (map.get("intxt").length()>1) {
			s += "&intxt=" + map.get("intxt");
		}		
		s = s.replaceAll(" ", "");
		mod.addAttribute("curSubMenu", "거래 내역서");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts",1);
		mod.addAttribute("datas",s);
		System.out.println(s);
		return "acc/welfare/wel_main";
	}
	
	
	

}
