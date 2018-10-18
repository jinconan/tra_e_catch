package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	List<Map<String,Object>> subMenuList = null;
	@Autowired
	private ProductLogic productLogic;
	
	public void manubar(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String emp_no = String.valueOf(session.getAttribute("emp_no"));
		int num = productLogic.emp_test(emp_no);
		if(num<5) {		
			subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu_M");
		}else {
			subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		}
	}
	
	@RequestMapping(value="/prod/view/prodCRUD")
	public String viewProdCRUD(Model mod, @RequestParam Map<String,Object> pMap,HttpServletRequest req) {
		logger.info("viewProdCRUD()");

		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		
		manubar(req);
		mod.addAttribute("curSubMenu", "작업 지시서");
		mod.addAttribute("subMenuList", subMenuList);	
		return "prod/prodCRUD/prodCRUD";
	}
	
	@RequestMapping(value="/prod/view/prodInven/{counts}")
	public String viewProdInven(Model mod,@PathVariable int counts,HttpServletRequest req) {
		logger.info("viewProdInven()"+counts);
		mod.addAttribute("counts", counts);	
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		
		manubar(req);
		mod.addAttribute("curSubMenu", "상품 관리");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/prodinven/prodInven";
	}
	@RequestMapping(value="/prod/view/client/{counts}")
	public String viewprodclient(Model mod,@PathVariable int counts,HttpServletRequest req) {
		logger.info("viewprodclient()"+counts);
		mod.addAttribute("counts", counts);	
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		
		manubar(req);
		mod.addAttribute("curSubMenu", "거래 처 정보");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/client/prodclient";
	}
	
	@RequestMapping(value="/prod/view/prodStat")
	public String viewProdstat(Model mod, @RequestParam Map<String,Object> pMap,HttpServletRequest req) {
		logger.info("viewProdstat()");
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		
		manubar(req);
		mod.addAttribute("curSubMenu", "상품 통계");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/prodstat/prodStat";
	}	
	
	@RequestMapping(value="/prod/view/prodStat_moon/{counts}", method = RequestMethod.GET)
	public String viewProdstat_moon(Model mod,@PathVariable int counts,HttpServletRequest req) {
		logger.info("viewProdstat()"+counts);
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		
		manubar(req);
		List<Map<String,Object>> moon_List = productLogic.moon_List_Logic();
		mod.addAttribute("curSubMenu", "상품 통계");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("moon_List", moon_List);
		mod.addAttribute("counts", counts);	
		return "prod/prodstat/prodStat_moon";
	}	
	
	@RequestMapping(value="/prod/view/prodStat_ct/{counts}/{day}/{yn}", method = RequestMethod.GET)
	public String viewProdstat_ct(Model mod,@PathVariable int counts,@PathVariable int day,@PathVariable int yn,HttpServletRequest req) {
		logger.info("viewProdstat()"+counts+day);
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		
		manubar(req);
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
	public String viewProdTran(Model mod, @RequestParam Map<String,Object> pMap,@PathVariable int counts,HttpServletRequest req) {
		logger.info("viewProdTran()");
		
		//컨트롤러로 부터 넘겨받는 속성
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		//curSubMenu : String
		
		manubar(req);
		mod.addAttribute("curSubMenu", "거래 내역서");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);	
		return "prod/prodtran/prodTran";
	}
	
	@RequestMapping(value ="/Tran_list/{counts}", method = RequestMethod.POST)
	public String wel_list(Model mod,@RequestParam Map<String,String> map,HttpServletRequest req) {
		logger.info("Tran_list진입");
		manubar(req);
		logger.info(map);
		String s = "?y=0";
		if (map.get("std").length()>4) {
			s += "&std="+map.get("std");
		}
		if (map.get("dtd").length()>4) {
			s += "&dtd="+ map.get("dtd");	
		}	
		if (map.get("incode").length()>0) {
			s += "&incode="+ map.get("incode");
		}
		if (map.get("opt").length()==2) {
			s += "&opt="+ map.get("opt");
		} 
		if (map.get("sums").length()>0) {
			s += "&sums="+ map.get("sums");
		}		
		if (map.get("cata").length()>0) {
			s += "&cata="+ map.get("cata");
		}		
		s = s.replaceAll(" ", "");
		mod.addAttribute("curSubMenu", "거래 내역서");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts",1);
		mod.addAttribute("datas",s);
		return "prod/prodtran/prodTran";
	}
	@RequestMapping(value ="/Tran_init", method = RequestMethod.POST)
	public String wel_init(Model mod,@RequestParam Map<String,String> map,HttpServletRequest req) {
		logger.info("Tran_init진입");
		productLogic.Tran_init_Logic(map);
		manubar(req);
		mod.addAttribute("curSubMenu", "거래 내역서");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts",1);
		return "prod/prodtran/prodTran";
	}
	
	@RequestMapping(value ="/Inven_init", method = RequestMethod.POST)
	public String Inven_init(Model mod,@RequestParam Map<String,String> map,HttpServletRequest req) {
		logger.info("Inven_init진입");
		productLogic.Inven_init_Logic(map);
		manubar(req);
		mod.addAttribute("curSubMenu", "상품 관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts",1);
		return "prod/prodinven/prodInven";
	}
	
	@RequestMapping(value ="/client_init", method = RequestMethod.POST)
	public String client_init(Model mod,@RequestParam Map<String,Object> map,HttpServletRequest req) {
		logger.info("client_init진입");
		productLogic.client_init_Logic(map);
		manubar(req);
		mod.addAttribute("curSubMenu", "상품 관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts",1);
		return "prod/client/prodclient";
	}
	
	@RequestMapping(value ="/client_goodsin", method = RequestMethod.POST)
	public String client_goodsin(Model mod,@RequestParam Map<String,Object> map,HttpServletRequest req) {
		logger.info("client_goodsin진입");
		HttpSession session = req.getSession();
		String emp_no = String.valueOf(session.getAttribute("emp_no"));
		map.put("map", emp_no);
		productLogic.client_goodsin_Logic(map);
		mod.addAttribute("curSubMenu", "상품 관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts",1);
		return "prod/client/prodclient";
	}
	
	@RequestMapping(value ="/client_update", method = RequestMethod.POST)
	public String client_update(Model mod,@RequestParam Map<String,Object> map,HttpServletRequest req) {
		logger.info("client_update진입");
		productLogic.client_update_Logic(map);
		manubar(req);
		mod.addAttribute("curSubMenu", "상품 관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts",1);
		return "prod/client/prodclient";
	}
	@RequestMapping(value ="/Inven_update", method = RequestMethod.POST)
	public String Inven_update(Model mod,@RequestParam Map<String,String> map,HttpServletRequest req) {
		logger.info("Inven_update진입");
		productLogic.Inven_update_Logic(map);
		manubar(req);
		mod.addAttribute("curSubMenu", "상품 관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts",1);
		return "prod/prodinven/prodInven";
	}
	
	//사내전산 전표뷰
	@RequestMapping(value = "/TRAN/wordprint")
	public String TRANprint(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
		logger.info("TRANprint호출"+pMap);
		List<Map<String, Object>> getList = null;
		getList = productLogic.TRANprint_logic(pMap);
		req.setAttribute("getList", getList.get(0));
		return "prod/prodtran/printform";
	}
	
	@RequestMapping(value = "/TRAN/update")
	public String TRANupdate(Model mod,@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
		logger.info("TRANupdate호출"+pMap);
		List<Map<String, Object>> getList = null;
		manubar(req);
		getList = productLogic.TRANupdate_logic(pMap);
		mod.addAttribute("curSubMenu", "거래 내역서");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts",1);
		return "prod/prodtran/prodTran";
	}
	

}
