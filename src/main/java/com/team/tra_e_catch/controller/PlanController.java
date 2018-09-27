package com.team.tra_e_catch.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team.tra_e_catch.plan.PlanLogic;

@Controller
public class PlanController {
	
	private static final	Logger				logger	= Logger.getLogger(PlanController.class);
	private final 			ApplicationContext	context = new ClassPathXmlApplicationContext("submenu/plan-submenu.xml");
	@Autowired
	private PlanLogic planLogic;
	///////////////////////////////////////////////기획서////////////////////////////////////////

	/**
	 * 기획서 리스트 페이지 요청
	 * @param mod
	 * @param pageNo 페이지 번호
	 * @return plan/prop/propList
	 */
	@RequestMapping(value="/plan/view/propList", method=RequestMethod.GET)
	public String viewPropList(Model mod
			, @RequestParam(name="pageNo", defaultValue="1") int pageNo
			, @RequestParam(name="searchColumn", required=false) String searchColumn
			, @RequestParam(name="searchValue", required=false) String searchValue) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("pageNo", pageNo);
		mod.addAttribute("pageNo", pageNo);
		if(searchColumn!=null) {
			pMap.put("searchColumn", searchColumn);
			pMap.put("searchValue", searchValue);
		}
		Map<String, Object> logicResult = planLogic.getPropList(pMap);
		
		mod.addAttribute("propList", logicResult.get("propList"));
		mod.addAttribute("numOfPropPage",logicResult.get("numOfPropPage"));
		
		return "plan/prop/propList";
	}
	
	/**
	 * 기획서 추가 페이지 요청
	 * @param mod
	 * @return plan/prop/propInsert
	 */
	@RequestMapping(value="/plan/view/propInsert")
	public String viewPropInsert(Model mod) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 작성");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/prop/propInsert";
	}
	
	/**
	 * 기획서 수정 페이지 요청
	 * @param mod
	 * @param propNo
	 * @return plan/prop/propUpdate
	 */
	@RequestMapping(value="/plan/view/propUpdate")
	public String viewPropUpdate(Model mod
			, @RequestParam(name="propNo", required=true) int propNo) {
		logger.info("viewPropUpdate");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "기획서 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("propNo", propNo);
		return "plan/prop/propUpdate";
	}
	
	@RequestMapping(value="/plan/propInsert", method=RequestMethod.POST,headers = ("content-type=multipart/*"))
	public String propInsert(HttpServletRequest req
			 ,@RequestParam("propTitle") String propTitle
			,@RequestParam(value="propFile", required=false) MultipartFile propFile) {
		
		String fileRepo = "E:\\files\\";
		logger.info("propInsert");
		HttpSession session = req.getSession();
		Object emp_no = session.getAttribute("emp_no");
		//아직 세션 구현 안했으니 테스트용으로 강희복
		if(emp_no == null)
			emp_no = 1;
		
		Map<String, Object> pMap = new HashMap<String,Object>();
		pMap.put("emp_no",emp_no);
		pMap.put("propTitle", propTitle);
		pMap.put("propFile", propFile.getOriginalFilename());

		//result : 인서트된 문서의 PK값
		int result = planLogic.insertProp(pMap);
		
		if(propFile.isEmpty() == false) {
			String filename = propFile.getOriginalFilename();
			File directory = new File(fileRepo+result);
			File file = new File(fileRepo+result+"\\"+filename);
			directory.mkdir();
			
			try {
				propFile.transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return "redirect:/plan/view/propList";
	}
	
	/**
	 * 기획서 다운로드 요청
	 * @param res
	 * @param propNo
	 * @param propFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/plan/propDownload")
	public ResponseEntity<byte[]> propDownload(HttpServletResponse res
			, @RequestParam("propNo") int propNo
			, @RequestParam("propFile") String propFile) {
		logger.info("propDownload");
		ResponseEntity<byte[]> entity = null;
		
		String fileRepo = "E:\\files\\";
		String docNo = null;
		
		//제안서 번호로부터 문서 테이블에서의 문서 번호리턴.
		Map<String,Object> pMap = new HashMap<String, Object>();
		pMap.put("propNo", propNo);
		Map<String,Object> rMap = planLogic.getPropList(pMap);
		List<Map<String,Object>> propList = (List<Map<String,Object>>)rMap.get("propList");
		
		if(propList.size() != 0) 
			docNo = (String)propList.get(0).get("doc_no");

		try(InputStream in = new FileInputStream(fileRepo+docNo+"\\"+propFile);) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attatchment; filename=\"" + 
                    new String(propFile.getBytes("UTF-8"), "ISO-8859-1") + 
                    "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
        return entity;
	}
	
	///////////////////////////////////////////////프로젝트////////////////////////////////////////
	
	/**
	 * 프로젝트 추가 페이지 요청
	 * @param mod
	 * @return plan/proj/projInsert
	 */
	@RequestMapping("/plan/view/projInsert")
	public String viewProjInsert(Model mod) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "프로젝트 등록");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projInsert";
	}
	
	/**
	 * 프로젝트 수정 페이지 요청
	 * @param mod
	 * @return plan/proj/projUpdate
	 */
	@RequestMapping("/plan/view/projUpdate")
	public String viewProjUpdate(Model mod
			, @RequestParam(name="projNo", required=true) int projNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "프로젝트 정보");
		mod.addAttribute("subMenuList", subMenuList);
		
		Map<String, Object> projDetail = planLogic.getProjDetail(projNo);
		mod.addAttribute("projDetail", projDetail);
		
		return "plan/proj/projUpdate";
	}
	
	/**
	 * 프로젝트 전체 리스트 페이지 요청 (all, ing,end,stop)
	 * @param mod
	 * @return
	 */
	@RequestMapping(value="/plan/view/projList/{pstatus_name}")
	public String viewProjList(Model mod
			, @PathVariable(name="pstatus_name",required=true) String pstatus_name
			, @RequestParam(name="pageNo", defaultValue="1") int pageNo
			, @RequestParam(name="searchColumn", required=false) String searchColumn
			, @RequestParam(name="searchValue", required=false) String searchValue) {

		logger.info("viewProjList()");
		logger.info("pstatus_name : " + pstatus_name +", pageNo : " + pageNo);
		logger.info("searchColumn : " + searchColumn + ", searchValue : " + searchValue); 
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "프로젝트 리스트");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("pstatus_name",pstatus_name);
		mod.addAttribute("pageNo",pageNo);
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("pageNo", pageNo);
		pMap.put("pstatus_name", pstatus_name);
//		pMap.put("emp_no", 1);
		if(searchColumn != null) {
			pMap.put("searchColumn",  searchColumn);
			pMap.put("searchValue", searchValue);
			mod.addAttribute("searchColumn",searchColumn);
			mod.addAttribute("searchValue", searchValue);
		}
		Map<String, Object> logicResult = planLogic.getProjList(pMap);
		
		mod.addAttribute("projList", logicResult.get("projList"));
		mod.addAttribute("numOfProjPage",logicResult.get("numOfProjPage"));
		return "plan/proj/projList";
	}
	
	
	/**
	 * 프로젝트 상세 페이지 요청
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/projDetail")
	public String viewProjDetail(Model mod
			, @RequestParam(value="projNo", required=true) int projNo) {
		logger.info("viewProjDetail()");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "프로젝트 정보");
		mod.addAttribute("subMenuList", subMenuList);
		
		Map<String, Object> projDetail = planLogic.getProjDetail(projNo);
		mod.addAttribute("projDetail", projDetail);
		
		return "plan/proj/projDetail";
	}
	
	/**
	 * 프로젝트 멤버 리스트 페이지 요청
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/projMemberList")
	public String viewProjMemList(Model mod
			, @RequestParam("projNo") int projNo) {
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
	@RequestMapping(value="/plan/view/projTimeline")
	public String viewProjTimeline(Model mod
			, @RequestParam("projNo") int projNo) {
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
	@RequestMapping(value="/plan/view/projBoardConfig")
	public String viewBoardConfig(Model mod
			, @RequestParam("projNo") int projNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "게시판 관리");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		return "plan/proj/projBoardConfig";
	}
	
	
	@RequestMapping(value="/plan/projInsert", method=RequestMethod.POST)
	public String projInsert(@RequestParam("projName") String projName
			, @RequestParam("startDate") String startDate
			, @RequestParam("endSchedDate") String endSchedDate) {
		logger.info("projInsert("+projName+", "+startDate+", "+endSchedDate+")");
		
		int result = planLogic.insertProj(projName,startDate,endSchedDate);
		
		return "redirect:/plan/view/projList/all";
	}
	
	@RequestMapping(value="/plan/projDelete", method=RequestMethod.POST)
	public String projDelete(@RequestParam(value="projNo", required=true) int projNo) {
		logger.info("projDelete("+projNo+")");
		int result = planLogic.deleteProj(projNo);
		return "redirect:/plan/view/projList/all";
	}
	
	@RequestMapping(value="/plan/projUpdate", method=RequestMethod.POST)
	public String projUpdate(@RequestParam Map<String,Object> pMap) {
		logger.info("projUpdate()");
		int result = planLogic.updateProj(pMap);
		return "redirect:/plan/view/projDetail?projNo="+pMap.get("proj_no");
	}
	
	@RequestMapping(value="/plan/timelineInsert", method=RequestMethod.POST)
	public String timelineInsert(@RequestParam Map<String,Object> pMap) {
		logger.info("timelineInsert()");
		int result = planLogic.insertTimeline(pMap);
		return "redirect:/planR/json/projTimeline?isToday=false&projNo="+pMap.get("proj_no");
	}
	@RequestMapping(value="/plan/timelineUpdate", method=RequestMethod.POST)
	public String timelineUpdate(@RequestParam Map<String,Object> pMap) {
		logger.info("timelineUpdate()");
		int result = planLogic.updateTimeline(pMap);
		return "redirect:/planR/json/projTimeline?isToday=false&projNo="+pMap.get("proj_no");
	}
	@RequestMapping(value="/plan/timelineDelete", method=RequestMethod.POST)
	public String timelineDelete(@RequestParam Map<String,Object> pMap) {
		logger.info("timelineDelete()");
		int result = planLogic.deleteTimeline(pMap);
		return "redirect:/planR/json/projTimeline?isToday=false&projNo="+pMap.get("proj_no");
	}
	
	@RequestMapping(value="/plan/memberInsert", method=RequestMethod.POST)
	public String memberInsert(@RequestParam Map<String, Object> pMap) {
		logger.info("memberInsert");
		logger.info(pMap.toString());
		int result = planLogic.insertMember(pMap);
		return "redirect:/planR/json/projMemberList?projNo="+pMap.get("projNo");
	}
	
	@RequestMapping(value="/plan/memberDelete", method=RequestMethod.POST)
	public String memberDelete(@RequestParam Map<String, Object> pMap) {
		logger.info("memberDelete");
		int result = planLogic.deleteMember(pMap);
		return "redirect:/planR/json/projMemberList?projNo="+pMap.get("proj_no");
	}
	
	@RequestMapping(value="/plan/memberUpdate", method=RequestMethod.POST)
	public String memberUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("memberUpdate");
		int result = planLogic.updateMember(pMap);
		return "redirect:/planR/json/projMemberList?projNo="+pMap.get("proj_no");
	}
	//////////////////////////////////////DIY게시판 ////////////////////////////////////////////
	/**
	 * DIY게시판 리스트 페이지 요청
	 * @param mod
	 * @param projNo
	 * @param boardNo
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/diyBoardList")
	public String viewBoardList(Model mod
			, @RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo
			, @RequestParam("pageNo") int pageNo
			) {
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
	@RequestMapping(value="/plan/view/diyBoardDetail")
	public String viewBoardDetail(Model mod
			, @RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo
			, @RequestParam("articleNo") int articleNo) {
		
		return "plan/proj/diy/diyBoardDetail";
	}
	
	/**
	 * DIY게시판 게시글 추가 페이지 요청
	 * @param mod
	 * @param projNo
	 * @param boardNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/diyBoardInsert")
	public String viewBoardUpdate(Model mod
			, @RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo) {
		
		return "plan/proj/diy/diyBoardInsert";
	}
	
	/**
	 * DIY게시판 게시글 수정 페이지 요청
	 * @param mod
	 * @param projNo
	 * @param boardNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/diyBoardUpdate")
	public String viewBoardUpdate(Model mod
			, @RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo
			, @RequestParam("articleNo") int articleNo) {
		
		return "plan/proj/diy/diyBoardUpdate";
	}
	
}
