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
		
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "�۾� ���ü�");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/prodCRUD/prodCRUD";
	}
	
	@RequestMapping(value="/prod/view/prodInven")
	public String viewProdInven(Model mod, @RequestParam Map<String,Object> pMap) {
		logger.info("viewProdInven()");
		
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubxMenu", "��� ����");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/prodinven/prodInven";
	}
	
	@RequestMapping(value="/prod/view/prodStat")
	public String viewProdstat(Model mod, @RequestParam Map<String,Object> pMap) {
		logger.info("viewProdstat()");
		
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ǰ ���");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/prodstat/prodStat";
	}	
	
	@RequestMapping(value="/prod/view/prodStat_moon/{counts}", method = RequestMethod.GET)
	public String viewProdstat_moon(Model mod,@PathVariable int counts) {
		logger.info("viewProdstat()"+counts);
		
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		List<Map<String,Object>> moon_List = productLogic.moon_List_Logic();
		mod.addAttribute("curSubMenu", "��ǰ ���");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("moon_List", moon_List);
		mod.addAttribute("counts", counts);	
		return "prod/prodstat/prodStat_moon";
	}	
	
	@RequestMapping(value="/prod/view/prodStat_ct/{counts}/{day}/{yn}", method = RequestMethod.GET)
	public String viewProdstat_ct(Model mod,@PathVariable int counts,@PathVariable int day,@PathVariable int yn) {
		logger.info("viewProdstat()"+counts+day);
		
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		List<Map<String,Object>> moon_List = productLogic.moon_List_Logic();
		List<Map<String,Object>> ct_List = productLogic.ct_List_Logic();
		mod.addAttribute("curSubMenu", "��ǰ ���");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("ct_List", ct_List);
		logger.info(ct_List);
		mod.addAttribute("moon_List", moon_List);
		mod.addAttribute("counts", counts);	
		mod.addAttribute("day", day);	
		mod.addAttribute("yn", yn);	
		return "prod/prodstat/prodStat_ct";
	}	
	
	@RequestMapping(value="/prod/view/prodTran")
	public String viewProdTran(Model mod, @RequestParam Map<String,Object> pMap) {
		logger.info("viewProdTran()");
		
		//��Ʈ�ѷ��� ���� �Ѱܹ޴� �Ӽ�
		//subMenuList : List<Map<String, Object>>
		//				[{key : value}] = [{"sm_name" : "����޴��̸�"}, {"sm_url" : "��ũ���"}]
		//curSubMenu : String
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "�ŷ� ������");
		mod.addAttribute("subMenuList", subMenuList);
		
		return "prod/prodtran/prodTran";
	}
	
	
	
	
	

}
