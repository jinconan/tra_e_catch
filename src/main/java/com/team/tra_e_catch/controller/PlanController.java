package com.team.tra_e_catch.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.team.tra_e_catch.plan.PlanLogic;

@Controller
public class PlanController {
	
	private static final	Logger				logger	= Logger.getLogger(PlanController.class);
	private final 			ApplicationContext	context = new ClassPathXmlApplicationContext("submenu/plan-submenu.xml");
	
	private final String FILE_REPO = "E:\\files\\";
	
	@Autowired
	private PlanLogic planLogic;
	
	///////////////////////////////////////////////��ȹ��////////////////////////////////////////
	/**
	 * ��ȹ�� ����Ʈ ������ ��û
	 * @param mod : �𵨰�ü
	 * @param pageNo : ��ȹ�� �Խ��� ��������ȣ.(����Ʈ 1)
	 * @param searchColumn : �˻��� �˻�����.
	 * @param searchValue : �˻��� �Է��� ��.
	 * @return plan/prop/propList
	 */
	@RequestMapping(value="/plan/view/propList", method=RequestMethod.GET)
	public String viewPropList(Model mod
			, @RequestParam(name="pageNo", defaultValue="1") int pageNo
			, @RequestParam(name="searchColumn", required=false) String searchColumn
			, @RequestParam(name="searchValue", required=false) String searchValue) {
		logger.info("viewPropList");
		logger.info("pageNo = " + pageNo + ", searchColumn = " + searchColumn +", searchValue = " + searchValue);
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("pageNo", pageNo);
		mod.addAttribute("pageNo", pageNo);
		if(searchColumn!=null) {
			pMap.put("searchColumn", searchColumn);
			pMap.put("searchValue", searchValue);
			mod.addAttribute("searchColumn", searchColumn);
			mod.addAttribute("searchValue", searchValue);
		}
		Map<String, Object> logicResult = planLogic.getPropList(pMap);
		
		mod.addAttribute("propList", logicResult.get("propList"));
		mod.addAttribute("numOfPropPage",logicResult.get("numOfPropPage"));
		
		return "plan/prop/propList";
	}
	
	/**
	 * ��ȹ�� �߰� ������ ��û
	 * @param mod : �𵨰�ü
	 * @return plan/prop/propInsert
	 */
	@RequestMapping(value="/plan/view/propInsert")
	public String viewPropInsert(Model mod) {
		logger.info("viewPropInsert");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� �ۼ�");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/prop/propInsert";
	}
	
	/**
	 * ��ȹ�� ���� ������ ��û
	 * @param mod : �𵨰�ü
	 * @param propNo : ��ȹ�� ��ȣ
	 * @return plan/prop/propUpdate
	 */
	@RequestMapping(value="/plan/view/propUpdate")
	public String viewPropUpdate(Model mod, @RequestParam("propNo") int propNo) {
		logger.info("viewPropUpdate");
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("prod-submenu");
		mod.addAttribute("curSubMenu", "��ȹ�� ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("propNo", propNo);
		return "plan/prop/propUpdate";
	}
	
	/**
	 * ��ȹ�� �Է� ó�� �޼ҵ�
	 * @param req - ��û��ü
	 * @param propTitle - ��ȹ�� ����
	 * @param propFile - ��ȹ�� ÷������.(����)
	 * @return redirect:/plan/view/propList
	 */
	@RequestMapping(value="/plan/propInsert", method=RequestMethod.POST,headers = ("content-type=multipart/*"))
	public String propInsert(HttpServletRequest req
			,@RequestParam("propTitle") String propTitle
			,@RequestParam(value="propFile", required=false) MultipartFile propFile) {
		logger.info("propInsert");
		logger.info("propTitle : " + propTitle + ", propFile : " + propFile);
		
		String doc_repo = FILE_REPO+"doc\\";
		
		HttpSession session = req.getSession();
		Object emp_no = session.getAttribute("emp_no");
		
		Map<String, Object> pMap = new HashMap<String,Object>();
		pMap.put("emp_no",emp_no);
		pMap.put("propTitle", propTitle);
		pMap.put("propFile", propFile.getOriginalFilename());

		int result = planLogic.insertProp(pMap);
		int doc_no = (Integer)pMap.get("doc_no");
		
		if(propFile.isEmpty() == false) {
			logger.debug("���� ���ε� ����");
			String filename = propFile.getOriginalFilename();
			File directory = new File(doc_repo+doc_no);
			File file = new File(directory+"\\"+filename);
			directory.mkdirs();
			
			try {
				propFile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return "redirect:/plan/view/propList";
	}
	
	/**
	 * ��ȹ�� �ٿ�ε� ��û
	 * @param res - ��û��ü
	 * @param propNo - ��ȹ����ȣ
	 * @param propFile - ��ȹ�����ϸ�
	 * @return ResponseEntity<byte[]>
	 */
	@ResponseBody
	@RequestMapping(value="/plan/propDownload")
	public ResponseEntity<byte[]> propDownload(HttpServletResponse res
			, @RequestParam("propNo") int propNo
			, @RequestParam("propFile") String propFile) {
		logger.info("propDownload()");
		logger.info("propNo : "+ propNo + ", propFile : " + propFile);
		ResponseEntity<byte[]> entity = null;
		
		String docRepo = FILE_REPO+"doc\\";
		String docNo = null;
		
		//���ȼ� ��ȣ�κ��� ���� ���̺����� ���� ��ȣ����.
		Map<String,Object> pMap = new HashMap<String, Object>();
		pMap.put("propNo", propNo);
		Map<String,Object> rMap = planLogic.getPropList(pMap);
		List<Map<String,Object>> propList = (List<Map<String,Object>>)rMap.get("propList");
		
		if(propList.size() != 0) 
			docNo = ((BigDecimal)propList.get(0).get("doc_no")).toString();

		try(InputStream in = new FileInputStream(docRepo+docNo+"\\"+propFile);) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", 
					"attatchment; filename=\"" + new String(propFile.getBytes("UTF-8"), "ISO-8859-1") +"\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		
        return entity;
	}
	
	///////////////////////////////////////////////������Ʈ////////////////////////////////////////
	
	/**
	 * ������Ʈ �߰� ������ ��û
	 * @param mod - �𵨰�ü
	 * @return plan/proj/projInsert
	 */
	@RequestMapping("/plan/view/projInsert")
	public String viewProjInsert(Model mod) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "������Ʈ ���");
		mod.addAttribute("subMenuList", subMenuList);
		return "plan/proj/projInsert";
	}
	
	/**
	 * ������Ʈ ���� ������ ��û
	 * @param mod - �𵨰�ü
	 * @param projNo - ������Ʈ ��ȣ
	 * @return plan/proj/projUpdate
	 */
	@RequestMapping("/plan/view/projUpdate")
	public String viewProjUpdate(Model mod
			, @RequestParam("projNo") int projNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "������Ʈ ����");
		mod.addAttribute("subMenuList", subMenuList);
		
		Map<String, Object> projDetail = planLogic.getProjDetail(projNo);
		mod.addAttribute("projDetail", projDetail);
		
		return "plan/proj/projUpdate";
	}
	
	/**
	 * ������Ʈ ��ü ����Ʈ ������ ��û (all, ing,end,stop)
	 * @param mod - �𵨰�ü
	 * @param pstatus_name - ������Ʈ ��Ȳ(all, ing, end, stop)
	 * @param pageNo - ������Ʈ ����Ʈ ������ ��ȣ(����Ʈ 1)
	 * @param searchColumn - ����Ʈ �˻� ����
	 * @param searchValue - ����Ʈ �˻� ��
	 * @return plan/proj/projList
	 */
	@RequestMapping(value="/plan/view/projList/{pstatus_name}")
	public String viewProjList(Model mod
			, @PathVariable("pstatus_name") String pstatus_name
			, @RequestParam(name="pageNo", defaultValue="1") int pageNo
			, @RequestParam(name="searchColumn", required=false) String searchColumn
			, @RequestParam(name="searchValue", required=false) String searchValue) {

		logger.info("viewProjList()");
		logger.info("pstatus_name : " + pstatus_name +", pageNo : " + pageNo);
		logger.info("searchColumn : " + searchColumn + ", searchValue : " + searchValue); 
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-list-submenu");
		mod.addAttribute("curSubMenu", "������Ʈ ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("pstatus_name",pstatus_name);
		mod.addAttribute("pageNo",pageNo);
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("pageNo", pageNo);
		pMap.put("pstatus_name", pstatus_name);
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
	 * ������Ʈ �� ������ ��û
	 * @param mod
	 * @param projNo
	 * @param empNo :���ǿ��� ���� ȸ����ȣ
	 * @return
	 */
	@RequestMapping(value="/plan/view/projDetail")
	public String viewProjDetail(Model mod
			, @RequestParam("projNo") int projNo
			, @SessionAttribute("emp_no") int empNo) {
		logger.info("viewProjDetail");
		logger.info("projNo : " + projNo + ", emp_no : "+empNo);
		
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "������Ʈ ����");
		mod.addAttribute("subMenuList", subMenuList);
		
		Map<String, Object> projDetail = planLogic.getProjDetail(projNo);
		List<Map<String,Object>> projBoardList = planLogic.getProjBoardList(projNo);
		boolean isLeader = planLogic.getProjLeader(empNo,projNo);
		mod.addAttribute("projDetail", projDetail);
		mod.addAttribute("projBoardList", projBoardList);
		mod.addAttribute("isLeader", isLeader);
		return "plan/proj/projDetail";
	}
	
	/**
	 * ������Ʈ ��� ����Ʈ ������ ��û
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/projMemberList")
	public String viewProjMemList(Model mod
			, @RequestParam("projNo") int projNo
			, @SessionAttribute("emp_no") int empNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "������ ����Ʈ");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		boolean isLeader = planLogic.getProjLeader(empNo,projNo);
		mod.addAttribute("isLeader", isLeader);
		return "plan/proj/projMemberList";
	}
	
	/**
	 * ������Ʈ Ÿ�Ӷ��� ������ ��û
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/projTimeline")
	public String viewProjTimeline(Model mod
			, @RequestParam("projNo") int projNo
			, @SessionAttribute("emp_no") int empNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "Ÿ�Ӷ���");
		mod.addAttribute("subMenuList", subMenuList);
		mod.addAttribute("projNo", projNo);
		boolean isLeader = planLogic.getProjLeader(empNo,projNo);
		mod.addAttribute("isLeader", isLeader);
		return "plan/proj/projTimeline";
	}
	
	/**
	 * ������Ʈ DIY�Խ��� ���� ������ ��û
	 * @param mod
	 * @param projNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/projBoardConfig")
	public String viewBoardConfig(Model mod
			, @RequestParam("projNo") int projNo
			, @SessionAttribute("emp_no") int empNo) {
		List<Map<String,Object>> subMenuList = (List<Map<String,Object>>)context.getBean("proj-submenu");
		mod.addAttribute("curSubMenu", "�Խ��� ����");
		mod.addAttribute("subMenuList", subMenuList);
		
		boolean isLeader = planLogic.getProjLeader(empNo,projNo);
		if(isLeader == false) {
			return "redirect:/plan/view/projDetail?projNo="+projNo;
		}
		mod.addAttribute("projNo", projNo);
		List<Map<String,Object>> projBoardList = planLogic.getProjBoardList(projNo);
		mod.addAttribute("projBoardList", projBoardList);
		
		return "plan/proj/projBoardConfig";
	}
	
	
	@RequestMapping(value="/plan/projInsert", method=RequestMethod.POST)
	public String projInsert(@SessionAttribute("emp_no") int empNo
			, @RequestParam("projName") String projName
			, @RequestParam("startDate") String startDate
			, @RequestParam("endSchedDate") String endSchedDate) {
		logger.info("projInsert("+projName+", "+startDate+", "+endSchedDate+")");
		
		int result = planLogic.insertProj(empNo, projName,startDate,endSchedDate);
		
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
	
	@RequestMapping(value="/plan/projBoardInsert", method=RequestMethod.POST)
	public String projBoardInsert(Model mod
			,@RequestParam Map<String,Object> pMap) {
		logger.info("projBoardInsert : " + pMap);
		int result = planLogic.insertProjBoard(pMap);
		return "redirect:/planR/json/projBoardList?projNo="+pMap.get("proj_no");
	}
	
	@RequestMapping(value="/plan/projBoardDelete", method=RequestMethod.POST)
	public String projBoardDelete(Model mod
			,@RequestParam Map<String,Object> pMap) {
		logger.info("projBoardDelete : " + pMap);
		int result = planLogic.deleteProjBoard(pMap);
		return "redirect:/planR/json/projBoardList?projNo="+pMap.get("proj_no");
	}
	
	@RequestMapping(value="/plan/projBoardUpdate", method=RequestMethod.POST)
	public String projBoardUpdate(Model mod
			,@RequestParam Map<String,Object> pMap) {
		logger.info("projBoardUpdate : " + pMap);
		int result = planLogic.updateProjBoard(pMap);
		return "redirect:/planR/json/projBoardList?projNo="+pMap.get("proj_no");
	}
	
	
	//////////////////////////////////////������Ʈ ���� �Խ��� ////////////////////////////////////////////
	/**
	 * DIY�Խ��� ����Ʈ ������ ��û
	 * @param mod
	 * @param projNo
	 * @param boardNo
	 * @param pageNo
	 * @param searchColumn
	 * @param searchValue
	 * @return
	 */
	@RequestMapping(value="/plan/view/diyBoardList")
	public String viewArticleList(Model mod
			, @RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo
			, @RequestParam(name="pageNo", defaultValue="1") int pageNo
			, @RequestParam(name="searchColumn", required=false) String searchColumn
			, @RequestParam(name="searchValue", required=false) String searchValue
			) {
		
		logger.info("viewArticleList()");
		logger.info("[projNo:"+projNo+", boardNo:"+boardNo+",pageNo:"+pageNo+",searchColumn:"+searchColumn+",searchValue:"+searchValue+"]");
		
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("pageNo", pageNo);
		pMap.put("board_no", boardNo);
		pMap.put("proj_no", projNo);
		mod.addAttribute("pageNo", pageNo);
		mod.addAttribute("boardNo",boardNo);
		mod.addAttribute("projNo",projNo);
		
		if(searchColumn!=null) {
			pMap.put("searchColumn", searchColumn);
			pMap.put("searchValue", searchValue);
		}
		
		Map<String, Object> logicResult = planLogic.getArticleList(pMap);
		
		mod.addAttribute("articleList", logicResult.get("articleList"));
		mod.addAttribute("numOfArticlePage",logicResult.get("numOfArticlePage"));
		mod.addAttribute("projBoardList", logicResult.get("projBoardList"));
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
	@RequestMapping(value="/plan/view/diyBoardDetail")
	public String viewArticleDetail(Model mod
			, @RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo
			, @RequestParam("articleNo") int articleNo
			) {
		logger.info("viewArticleDetail : " + articleNo);
		mod.addAttribute("projNo",projNo);
		mod.addAttribute("boardNo",boardNo);
		mod.addAttribute("articleNo",articleNo);
		
		Map<String,Object> articleDetail = planLogic.getArticleDetail(articleNo);
		mod.addAttribute("articleDetail",articleDetail);
		
		return "plan/proj/diy/diyBoardDetail";
	}
	
	/**
	 * DIY�Խ��� �Խñ� �߰� ������ ��û
	 * @param mod
	 * @param projNo
	 * @param boardNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/diyBoardInsert")
	public String viewArticleInsert(Model mod
			, @RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo) {
		logger.info("viewBoardInsert : projNo="+projNo+", boardNo="+boardNo);
		
		mod.addAttribute("projNo",projNo);
		mod.addAttribute("boardNo",boardNo);
		return "plan/proj/diy/diyBoardInsert";
	}
	
	/**
	 * DIY�Խ��� �Խñ� ���� ������ ��û
	 * @param mod
	 * @param projNo
	 * @param boardNo
	 * @return
	 */
	@RequestMapping(value="/plan/view/diyBoardUpdate")
	public String viewArticleUpdate(Model mod
			, @RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo
			, @RequestParam("articleNo") int articleNo) {
		logger.info("viewArticleUpdate");
		
		Map<String,Object> articleDetail = planLogic.getArticleDetail(articleNo);
		
		mod.addAttribute("projNo", projNo);
		mod.addAttribute("boardNo", boardNo);
		mod.addAttribute("articleNo", articleNo);
		mod.addAttribute("articleDetail", articleDetail);
		
		return "plan/proj/diy/diyBoardUpdate";
	}
	
	/**
	 * 
	 * @param pMap
	 * @return
	 */
	@RequestMapping(value="/plan/articleInsert", method=RequestMethod.POST)
	public String articleInsert(HttpServletRequest req
			, @RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo
			, @RequestParam("articleTitle") String articleTitle
			, @RequestParam("articleContent") String articleContent
			, @RequestParam(value="articleFile", required=false) MultipartFile articleFile
	) {
		logger.info("articleInsert");
		////////////////////
		String fileRepo = "D:\\files\\article\\";
		HttpSession session = req.getSession();
		Object article_writer = session.getAttribute("emp_name");
		// ���� ���� ���� �������� �׽�Ʈ������ ����
		if (article_writer == null)
			article_writer = "����";

		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("article_writer", article_writer);
		pMap.put("article_title", articleTitle);
		pMap.put("article_content", articleContent);
		pMap.put("article_path", articleFile.getOriginalFilename());
		pMap.put("proj_no", projNo);
		pMap.put("board_no", boardNo);

		int result = planLogic.insertArticle(pMap);
		int article_no = (Integer) pMap.get("article_no");
		if (articleFile.isEmpty() == false) {
			String filename = articleFile.getOriginalFilename();
			File directory = new File(fileRepo + article_no);
			File file = new File(fileRepo + article_no + "\\" + filename);
			directory.mkdirs();

			try {
				articleFile.transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		////////////////////
		return "redirect:/plan/view/diyBoardList?projNo="+projNo+"&boardNo="+boardNo;
	}
	
	/**
	 * 
	 * @param res
	 * @param articleNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/plan/articleDownload")
	public ResponseEntity<byte[]> articleDownload(HttpServletResponse res
			,@RequestParam("articleNo") int articleNo
	) {
		ResponseEntity<byte[]> entity = null;
		String articleRepo = FILE_REPO+"article\\";
		
		//���ȼ� ��ȣ�κ��� ���� ���̺����� ���� ��ȣ����.
		Map<String,Object> pMap = new HashMap<String, Object>();
		Map<String,Object> rMap = planLogic.getArticleDetail(articleNo);
		
		if(rMap.containsKey("ARTICLE_NO")) { 
			String articlePath = (String)rMap.get("ARTICLE_PATH");
			
			try(InputStream in = new FileInputStream(articleRepo+articleNo+"\\"+articlePath);) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attatchment; filename=\"" + 
	                    new String(articlePath.getBytes("UTF-8"), "ISO-8859-1") + 
	                    "\"");
				entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			} catch(Exception e) {
				logger.error(e.toString());
			}
		}
		
        return entity;
	}
	
	@RequestMapping(value="/plan/articleDelete", method=RequestMethod.POST)
	public String articleDelete(
			@RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo
			, @RequestParam("articleNo") int articleNo) {
		logger.info("articleDelete");
		int result = planLogic.deleteArticle(articleNo);
		return "redirect:/plan/view/diyBoardList?projNo="+projNo+"&boardNo="+boardNo;
	}
	
	@RequestMapping(value="/plan/articleUpdate", method=RequestMethod.POST)
	public String articleUpdate(
			@RequestParam("projNo") int projNo
			, @RequestParam("boardNo") int boardNo
			, @RequestParam("articleNo") int articleNo
			, @RequestParam("articleTitle") String articleTitle
			, @RequestParam("articleContent") String articleContent
			) {
		logger.info("articleUpdate");
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("article_title", articleTitle);
		pMap.put("article_content", articleContent);
		//pMap.put("article_path", articleFile.getOriginalFilename());
		pMap.put("proj_no", projNo);
		pMap.put("board_no", boardNo);
		pMap.put("article_no", articleNo);
		int result = planLogic.updateArticle(pMap);
		return "redirect:/plan/view/diyBoardDetail?projNo="+projNo+"&boardNo="+boardNo+"&articleNo="+articleNo;
	}
}

