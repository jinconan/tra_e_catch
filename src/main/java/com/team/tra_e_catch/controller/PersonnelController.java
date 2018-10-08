package com.team.tra_e_catch.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public String viewSalary(@RequestParam Map<String, Object> pMap, Model mod, @PathVariable int counts, HttpServletRequest req) {
		logger.info("salary호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "급여관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("counts", counts);
		HttpSession session= req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		return "per/salary/salary";
	}

	// 출퇴근관리
	@RequestMapping(value = "/attd/{counts}")
	public String viewAttd(@RequestParam Map<String, Object> pMap, Model mod, @PathVariable int counts) {
		logger.info("viewAttd호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-attsub");// 근태 관련 서브메뉴

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
	//인사발령 메인
	@RequestMapping(value = "/onlyauthper/empupdate")
	public String empUpdate(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		logger.info("empUpdate호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "인사정보 수정");
		mod.addAttribute("subMenuList", subMenuList);
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		
		return "per/onlyauthper/empupdate";
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
		logger.info("certList호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-certsub");// 증명서 관리
																											// 서브메뉴
		mod.addAttribute("curSubMenu", "증명서발급");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/cert/cert_mainList";

	}
	@RequestMapping(value = "/cert/certprint", method = RequestMethod.POST)
	public String certPrint(@RequestParam Map<String, Object> pMap, Model mod) {
		logger.info("certList호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-certsub");// 증명서 관리
		mod.addAttribute("curSubMenu", "증명서발급");
		mod.addAttribute("subMenuList", subMenuList);
		return "per/cert/cert_printList";

	}


	// 재직증명서 양식 페이지
	@RequestMapping(value = "/cert/certform", method = RequestMethod.POST)
	public String serform(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		logger.info("serform호출");
		List<Map<String, Object>> certinsert = null;
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("emp_no", emp_no);
		System.out.println(pMap);
		certinsert = personnelLogic.certInsert(pMap);
		
		return "per/cert/certform";
	}

	// 경력증명서 양식 페이지
	@RequestMapping(value = "/cert/careercert", method = RequestMethod.POST)
	public String careercert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		logger.info("certPrintList호출");
		List<Map<String, Object>> certinsert = null;
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("emp_no", emp_no);
		System.out.println(pMap);
		certinsert = personnelLogic.certInsert(pMap);
		return "per/cert/careercert";
	}

	// 사직서 양식 페이지
	@RequestMapping(value = "/cert/retireform", method = RequestMethod.POST)
	public String retirecert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		// 컨트롤러로 부터 넘겨받는 속성
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		// curSubMenu : String
		List<Map<String, Object>> certinsert = null;
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("emp_no", emp_no);
		System.out.println(pMap);
		certinsert = personnelLogic.certInsert(pMap);
		logger.info("certPrintList호출");
		return "per/cert/retireform";
	}

	// 시말서 양식 페이지
	@RequestMapping(value = "/cert/reasonform", method = RequestMethod.POST)
	public String reasoncert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		// 컨트롤러로 부터 넘겨받는 속성
		// subMenuList : List<Map<String, Object>>
		// [{key : value}] = [{"sm_name" : "서브메뉴이름"}, {"sm_url" : "링크경로"}]
		// curSubMenu : String
		List<Map<String, Object>> certinsert = null;
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("emp_no", emp_no);
		System.out.println(pMap);
		certinsert = personnelLogic.certInsert(pMap);
		logger.info("certPrintList호출");
		return "per/cert/reasonform";
	}

	// 평정 데이터 입력
	@RequestMapping(value = "/rating/servrating")
	public String sendRating(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {

		logger.info("sendRating호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("per-submenu");
		mod.addAttribute("curSubMenu", "인사고과");
		mod.addAttribute("subMenuList", subMenuList);
		List<Map<String, Object>> servList = null;
		HttpSession session = req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("emp_no", emp_no);
		servList = personnelLogic.setServrating(pMap);
		
		return "per/rating/perrating";
	}
	
	// 인사발령정보 수정
		@RequestMapping(value = "/onlyauthper/empupdateaccept")
		public String empupdateaccept(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
			logger.info("sendRating호출");
			List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
			mod.addAttribute("curSubMenu", "인사정보 수정");
			mod.addAttribute("subMenuList", subMenuList);
			List<Map<String, Object>> empupdateList = null;
			System.out.println("인사발령 수정정보 : "+pMap);
			empupdateList = personnelLogic.updateEmployee(pMap);
			
			
			
			return "per/onlyauthper/empupdate";
		}
		
		// 부서정보 수정
				@RequestMapping(value = "/onlyauthper/deptupdatelist/{counts}")
				public String deptupdatelist(@RequestParam Map<String, Object> pMap,@PathVariable int counts, Model mod, HttpServletRequest req) {
					logger.info("deptupdatelist호출");
					List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
					HttpSession session = req.getSession();
					String semp_no = String.valueOf(session.getAttribute("emp_no"));
					int emp_no = Integer.parseInt(semp_no);			
					mod.addAttribute("counts", counts);
					mod.addAttribute("curSubMenu", "부서관리");
					mod.addAttribute("subMenuList", subMenuList);
				
					return "per/onlyauthper/deptinsert";
				}
				
				// 부서정보 수정실행
				@RequestMapping(value = "/onlyauthper/deptupdate")
				public String deptUpdate(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
					logger.info("deptUpdate호출");
					List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
					mod.addAttribute("curSubMenu", "부서관리");
					mod.addAttribute("subMenuList", subMenuList);
					List<Map<String, Object>> deptupdateinfo = null;
					deptupdateinfo = personnelLogic.deptUpdate(pMap);
					return "per/onlyauthper/deptinsert";
				}
				
				
				// 부서정보 인서트
				@RequestMapping(value = "/onlyauthper/deptinsert")
				public String deptinsert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
					logger.info("deptinsert호출");
					List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
					mod.addAttribute("curSubMenu", "부서관리");
					mod.addAttribute("subMenuList", subMenuList);
					List<Map<String, Object>> deptinsertinfo = null;
					deptinsertinfo = personnelLogic.deptInsert(pMap);
					return "per/onlyauthper/deptinsert";
				}
				// 팀정보 인서트
				@RequestMapping(value = "/onlyauthper/teaminsert")
				public String teamInsert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
					logger.info("deptinsert호출");
					List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
					mod.addAttribute("curSubMenu", "부서관리");
					mod.addAttribute("subMenuList", subMenuList);
					List<Map<String, Object>> teaminsertinfo = null;
					teaminsertinfo = personnelLogic.teamInsert(pMap);
					return "per/onlyauthper/deptinsert";
				}
	
	@RequestMapping(value = "/attdinsert")
	public String attdInsert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		logger.info("attdInsert호출");
		List<Map<String, Object>> attdinfo = null;
		HttpSession session= req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		pMap.put("emp_no", emp_no);
		attdinfo = personnelLogic.setAttdInsert(pMap);
		
		return "home";
	}

////////////////////////////////김훈태 작성 끝 ///////////////////////////////////////		
	
	
	@RequestMapping(value = "/empinsert")
		public String empInsert(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
		logger.info("empInsert호출");
		List<Map<String, Object>> empinsert = null;
		System.out.println("사원정보 : "+pMap);
		/*attdinfo = personnelLogic.setAttdInsert(pMap);*/
		HttpSession session= req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);
		empinsert = personnelLogic.EmpInsert(pMap);
		return "per/onlyauthper/empRegist";
	}
	// 사원명부
		@RequestMapping(value = "/empList")
		public String perEmpList(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) {
			logger.info("emplist호출");
			List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
			mod.addAttribute("curSubMenu", "사원 명부");
			mod.addAttribute("subMenuList", subMenuList);
			HttpSession session= req.getSession();
			String semp_no = String.valueOf(session.getAttribute("emp_no"));
			int emp_no = Integer.parseInt(semp_no);
			return "per/onlyauthper/emplist";
		}

		// 사원명부 검색 테이블
		@RequestMapping(value = "/emptable", method = RequestMethod.GET)
		public String pertable(@RequestParam Map<String, Object> pMap, Model mod) {
			logger.info("사원명부 검색 테이블");
			System.out.println(pMap);
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
	@RequestMapping(value = "/labcont")
	public String labcont(Locale locale, Model mod, HttpServletRequest req) {
		logger.info("labcont호출");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "근로계약서 관리");
		mod.addAttribute("subMenuList", subMenuList);
		HttpSession session= req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);		
		return "per/onlyauthper/labcont";
	}
	//고용계약서 뷰
	@RequestMapping(value = "/onlyauthper/wordprint")
	public String wordprint(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
		logger.info("wordprint호출");
		System.out.print("고용계약 뷰"+pMap);
		List<Map<String, Object>> getEmpList = null;
		getEmpList = personnelLogic.getindivList(pMap);
		System.out.println("고용계약서 인포 : "+getEmpList);
		req.setAttribute("emp_no", getEmpList.get(0).get("EMP_NO"));
		return "per/onlyauthper/printform";
	}
	//근로계약서
	@RequestMapping(value = "/labtable")
	public String labtable(@RequestParam Map<String, Object> pMap) {
		logger.info("labtable호출");
		System.out.println(pMap);//정상적으로 emp_no가 들어있음.
		return "per/onlyauthper/lablist";
	}
	//근로계약서 등록
	@RequestMapping(value = "/labcont/insert")
	public String labcontinsert(@RequestParam Map<String, Object> pMap) {
		logger.info("labcontinsert호출");
		System.out.println(pMap);//정상적으로 emp_no가 들어있음.
		List<Map<String, Object>> labinsert = null;
		System.out.println(pMap);
		labinsert = personnelLogic.labInsert(pMap);
		return "per/onlyauthper/labcont";
	}

	//고용계약서 등록
		@RequestMapping(value = "/sourcing/insert")
		public String empsourcinginsert(@RequestParam Map<String, Object> pMap,Model mod, HttpServletRequest req) {
			logger.info("empsourcinginsert호출");
			System.out.println(pMap);//정상적으로 emp_no가 들어있음.
			List<Map<String, Object>> sourcinginsert = null;
			System.out.println(pMap);
			sourcinginsert = personnelLogic.empsourcingInsert(pMap);
			List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
			
			HttpSession session= req.getSession();
			String semp_no = String.valueOf(session.getAttribute("emp_no"));
			int emp_no = Integer.parseInt(semp_no);		
			mod.addAttribute("curSubMenu", "기획서 리스트");
			mod.addAttribute("subMenuList", subMenuList);
			return "per/onlyauthper/empcont";
		}

		// 고용계약서 관리화면
		@RequestMapping(value = "/empcont")
		public String empcont(@RequestParam Map<String, Object> pMap, Model mod) {
			logger.info("고용계약서 조회");
			List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
			mod.addAttribute("curSubMenu", "고용계약서");
			mod.addAttribute("subMenuList", subMenuList);
			return "per/onlyauthper/empcont";
		}
		
	// 근로계약서 조회 테이블
	@RequestMapping(value = "/empconttable")
	public String empconttable(Locale locale, Model model) {
		return "per/onlyauthper/empconttable";
	}
	
	// 인사정보수정테이블
	@RequestMapping(value = "/empupdatetable")
	public String empupdatetable(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
		req.setAttribute("emp_no", pMap.get("emp_no"));
		System.out.println(pMap.get("emp_no"));
		return "per/onlyauthper/updatetable";
	}
		
	////////////// 급여 지급////////////////
	/**
	 * 급여지급 페이지 요청
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/onlyauthper/empSal")
	public String viewEmpSal(Model mod, HttpServletRequest req) {
		logger.info("viewEmpSal ");
		List<Map<String, Object>> subMenuList = (List<Map<String, Object>>) context.getBean("perauth-submenu");
		mod.addAttribute("curSubMenu", "사원 급여관리");
		mod.addAttribute("subMenuList", subMenuList);
		HttpSession session= req.getSession();
		String semp_no = String.valueOf(session.getAttribute("emp_no"));
		int emp_no = Integer.parseInt(semp_no);

		return "per/onlyauthper/empSal";

	}	
		
	/**
	 * 급여 지급 요청
	 * @param pMap
	 * @return
	 */
	@RequestMapping(value="/salaryInsert", method=RequestMethod.POST)
	public String salaryInsert(@RequestParam Map<String, Object> pMap) {
		logger.info("salaryInsert "+pMap);
		personnelLogic.insertSalary(pMap);
		return "redirect:/per/onlyauthper/empSal";
	}
	
	@RequestMapping(value="/empSalUpdate", method=RequestMethod.POST)
	public String empSalaryUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("empSalaryUpdate "+pMap);
		personnelLogic.updateSalary(pMap);
		return "redirect:/per/onlyauthper/empSal";
	}
}
