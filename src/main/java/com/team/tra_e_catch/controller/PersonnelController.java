package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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

import com.team.tra_e_catch.personnel.PersonnelLogic;

@Controller
@RequestMapping(value = "/per")
public class PersonnelController {
	@Autowired
	private PersonnelLogic personnelLogic = null;
	/*
	 * @Autowired를 사용하면 setter메소드에 사용될 이름은 반드시 클래스 이름과 일치시킬것. 만일 setter객체 주입법을 사용하는
	 * 경우라면 개발자가 그 이름을 xml문서에 등록할 수 있지만
	 * 
	 * @Autowired를 사용할 땐 xml문서에 추가 등록자체가 필요없기 때문임.
	 */
	private static final Logger logger = Logger.getLogger(PersonnelController.class);
	private final ApplicationContext context = new ClassPathXmlApplicationContext("submenu/personnel-submenu.xml");

////////////////////////////////김훈태 작성///////////////////////////////////////
	// 급여관리
	@RequestMapping(value = "/salary/{counts}", method = RequestMethod.GET)
	public String viewSalary(@RequestParam Map<String, Object> pMap, Model mod, @PathVariable int counts) {
		logger.info("salary호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "급여관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);
		return "per/salary/salary";
	}

	// 출퇴근관리
	@RequestMapping(value = "/attd/{counts}", method = RequestMethod.GET)
	public String viewAttd(@RequestParam Map<String, Object> pMap, Model mod, @PathVariable int counts) {
		logger.info("viewAttd호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-attsub");// 근태 관련 서브메뉴
																											// 호출
		mod.addAttribute("curSubMenu", "출퇴근관리");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/attd/attd_attenList";

	}

	// 인사고과 메인
	@RequestMapping(value = "/rating/perrating", method = RequestMethod.GET)
	public String viewRating(@RequestParam Map<String, Object> pMap, Model mod) {
		// 컨트롤러로 부터 넘겨받는 속성
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		// curSubMenu : String
		logger.info("viewRating호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "인사고과");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/rating/perrating";
	}

	// 기안서폼 임시저장
	@RequestMapping(value = "/rating/testform", method = RequestMethod.GET)
	public String formTest(@RequestParam Map<String, Object> pMap, Model mod) {
		// 컨트롤러로 부터 넘겨받는 속성
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		// curSubMenu : String
		logger.info("viewRating호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "인사메뉴");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/salary/testform";

	}

	// 연차관리
	@RequestMapping(value = "/attd/leave", method = RequestMethod.GET)
	public String attLeave(@RequestParam Map<String, Object> pMap, Model mod) {
		// 컨트롤러로 부터 넘겨받는 속성
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		// curSubMenu : String
		logger.info("attLeave호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-attsub");// 근태 관련 서브메뉴
																											// 호출
		mod.addAttribute("curSubMenu", "연차관리");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/attd/attd_leaveList";

	}

	// 증명서관리
	@RequestMapping(value = "/cert/cert", method = RequestMethod.GET)
	public String certList(@RequestParam Map<String, Object> pMap, Model mod) {
		// 컨트롤러로 부터 넘겨받는 속성
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		// curSubMenu : String
		logger.info("certList호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-certsub");// 증명서 관리
																											// 서브메뉴
		mod.addAttribute("curSubMenu", "증명서발급");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/cert/cert_mainList";

	}

	// 증명서 출력기록 페이지
	@RequestMapping(value = "/cert/certprint", method = RequestMethod.POST)
	public String certPrintList(@RequestParam Map<String, Object> pMap, Model mod) {
		// 컨트롤러로 부터 넘겨받는 속성
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		// curSubMenu : String
		logger.info("certPrintList호출");
		return "per/cert/cert_printList";
	}

	// 재직증명서 양식 페이지
	@RequestMapping(value = "/cert/certform", method = RequestMethod.POST)
	public String serform(@RequestParam Map<String, Object> pMap, Model mod) {
		// 컨트롤러로 부터 넘겨받는 속성
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		// curSubMenu : String
		logger.info("certPrintList호출");
		return "per/cert/certform";
	}

	// 경력증명서 양식 페이지
	@RequestMapping(value = "/cert/careercert", method = RequestMethod.POST)
	public String careercert(@RequestParam Map<String, Object> pMap, Model mod) {
		// 컨트롤러로 부터 넘겨받는 속성
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		// curSubMenu : String
		logger.info("certPrintList호출");
		return "per/cert/careercert";
	}

	// 사직서 양식 페이지
	@RequestMapping(value = "/cert/retireform", method = RequestMethod.POST)
	public String retirecert(@RequestParam Map<String, Object> pMap, Model mod) {
		// 컨트롤러로 부터 넘겨받는 속성
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		// curSubMenu : String
		logger.info("certPrintList호출");
		return "per/cert/retireform";
	}

	// 시말서 양식 페이지
	@RequestMapping(value = "/cert/reasonform", method = RequestMethod.POST)
	public String reasoncert(@RequestParam Map<String, Object> pMap, Model mod) {
		// 컨트롤러로 부터 넘겨받는 속성
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		// curSubMenu : String
		logger.info("certPrintList호출");
		return "per/cert/reasonform";
	}

	// 평정 데이터 입력
	@RequestMapping(value = "/rating/servrating")
	public String sendRating(@RequestParam Map<String, Object> pMap, Model mod) {

		logger.info("sendRating호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "인사고과");
		mod.addAttribute("subMenuList", subMenuList);
		System.out.print(pMap.get("w_content"));
		System.out.print(pMap.get("e_content"));
		System.out.print(pMap.get("pm_content"));
		System.out.print("넌 뭐니 : "+pMap.get("e_list"));//셀렉된 사람의 이름이 나오네..?
		System.out.print("사이즈 : " + pMap.size());
		List<Map<String, Object>> servList = null;
		servList = personnelLogic.setServrating(pMap);
		
		return "per/rating/perrating";
	}

////////////////////////////////김훈태 작성 끝 ///////////////////////////////////////		

	// 사원명부
	@RequestMapping(value = "/empList")
	public String per(@RequestParam Map<String, Object> pMap, Model mod, HttpServletResponse res) {
		logger.info("Welcome home! The client locale is1");

		logger.info(pMap);
		logger.info(pMap.get("name") + "\t" + pMap.get("lev-no") + "\t" + pMap.get("dept-no"));
		String a = (String) pMap.get("lev-no");
		System.out.println(a);
		try {
			List<Map<String, Object>> getEmpList = null;
			getEmpList = personnelLogic.getEmpList(pMap, res);
			mod.addAttribute("getEmpList", getEmpList);
			List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
			mod.addAttribute("curSubMenu", "기획서 리스트");
			mod.addAttribute("subMenuList", subMenuList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "per/onlyauthper/emplist";
	}

	// 사원명부 검색 테이블
	@RequestMapping(value = "/emptable", method = RequestMethod.GET)
	public String pertable(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is");
		return "per/onlyauthper/emptable";
	}

	@RequestMapping(value = "/empRegist", method = RequestMethod.GET)
	public String perRegist(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "사원 등록");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empRegist";
	}

	// 근로계약서 관리
	@RequestMapping(value = "/labcont", method = RequestMethod.GET)
	public String labcont(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/labcont";
	}

	// 근로계약서 검색 테이블
	@RequestMapping(value = "/labtable", method = RequestMethod.GET)
	public String labtable(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is");
		return "per/onlyauthper/lablist";
	}

	// 고용계약서 조회
	@RequestMapping(value = "/empcont", method = RequestMethod.GET)
	public String empcont(Locale locale, Model mod) {
		logger.info("Welcome home! The client locale is");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/onlyauthper/empcont";
	}

	// 근로계약서 조회 테이블
	@RequestMapping(value = "/empconttable", method = RequestMethod.GET)
	public String empconttable(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is");
		return "per/onlyauthper/empconttable";
	}

}
