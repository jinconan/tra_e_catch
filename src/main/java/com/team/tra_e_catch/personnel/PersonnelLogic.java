package com.team.tra_e_catch.personnel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class PersonnelLogic {
	Logger logger = Logger.getLogger(PersonnelLogic.class);
	
	@Autowired
	private SqlPerDao sqlPerDao = null;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	/**
	 * 출퇴근 관리 JSON데이터 요청
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getAttdList(Map<String, Object> pMap) {
		logger.info("getAttdList :"+pMap);
		return sqlPerDao.getAttdList(pMap);
	}
	
	/**
	 * 증명서 내역 json데이터 요청
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getCertlist(Map<String, Object> pMap) {
		logger.info("getCertlist :" + pMap);
		return sqlPerDao.getCertList(pMap);
	}
	
	/**
	 * 증명서 내역 추가
	 * @param pMap
	 * @return
	 */
	public int insertCert(Map<String, Object> pMap) {
		return sqlPerDao.insertCert(pMap);
	}
	
	/**
	 * 개인 신상 내역 데이터 요청
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getindivList(Map<String, Object> pMap) {
		logger.info("getindivList :" + pMap);
		List<Map<String, Object>> serList = null;
		serList = sqlPerDao.getIndivList(pMap); 
		return serList;
	}
	//고용계약서 개인신상 데이터
	public List<Map<String, Object>> getindivlist(Map<String, Object> pMap) {
		logger.info("getindivlist :" + pMap);
		List<Map<String, Object>> serList = null;
		serList = sqlPerDao.getIndivlist(pMap); 
		return serList;
	}
	
	/**
	 * 급여내역 JSON포멧 데이터 요청 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getSalList(Map<String, Object> pMap) {
		logger.info("getSalList 호출 성공 :" + pMap);
		List<Map<String,Object>> salList = sqlPerDao.getSalList(pMap);
		return salList;
	}
	
	/**
	 * 팀원 리스트 데이터 요청
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getTeamList(Map<String, Object> pMap) {
		logger.info("getTeamList 호출 성공");
		List<Map<String,Object>> teamList = sqlPerDao.getTeamList(pMap);
		return teamList;
	}

	/**
	 * 개인평정 확인 분기 리스트 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getQuarList(Map<String, Object> pMap) {
		List<Map<String,Object>> quarlist = null;
		quarlist = sqlPerDao.getQuarList(pMap);
		return quarlist;
	}
	
	/**
	 * 인사권자의견 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getleaderView(Map<String, Object> pMap) {
		List<Map<String,Object>> leaderview = null;
		leaderview = sqlPerDao.getLeaderView(pMap);
		return leaderview;
	}

	
	/**
	 * 평정 추가
	 * @param pMap
	 * @return
	 */
	public int insertServrating(Map<String, Object> pMap) {
		logger.info("insertServrating : " + pMap);
		int result = sqlPerDao.insertSerList(pMap);
		return result;
	}

	/**
	 * 사원명부
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getEmpList(Map<String, Object> pMap) {
		logger.info("getEmpList 호출 :" + pMap);
		List<Map<String, Object>> empList = sqlPerDao.getEmpList(pMap);
		return empList;
	}

	/**
	 * 직급 리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getlevlist(Map<String, Object> pMap) {
		List<Map<String, Object>> levList = null;
		levList = sqlPerDao.viewLevList(pMap);
		return levList;
	}

	/**
	 * 지역 리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getLocList(Map<String, Object> pMap) {
		List<Map<String, Object>> locList = null;
		locList = sqlPerDao.viewLocList(pMap);
		return locList;
	}

	/**
	 * 부서 리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getDeptList(Map<String, Object> pMap) {
		List<Map<String, Object>> deptList = null;
		deptList = sqlPerDao.viewDeptList(pMap);
		return deptList;
	}

	/**
	 * 사원 등록 수행
	 * @param pMap
	 * @return
	 */
	public int insertEmp(Map<String, Object> pMap) {
		String default_emp_pw = bCryptPasswordEncoder.encode("0000");
		pMap.put("emp_pw", default_emp_pw);
		logger.info("insertEmp :" + pMap);
		int result = sqlPerDao.insertEmp(pMap);
		return result;
	}
	
	/**
	 *  
	 * @param pMap
	 * @return
	 */
	public int insertLab(Map<String, Object> pMap) {
		logger.info("insertLab  호출");
		int result  = sqlPerDao.insertLab(pMap);
		return result;
	}
	
	/**
	 * 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getWorkList(Map<String, Object> pMap) {
		List<Map<String, Object>> workList = null;
		workList = sqlPerDao.viewWorkList(pMap);
		return workList;
	}

	/**
	 * 고용계약서 조회
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getSourcingList(Map<String, Object> pMap) {
		logger.info("perLogic sourcingList  호출");
		List<Map<String,Object>> sourcingList = null;
		sourcingList = sqlPerDao.viewSourcingList(pMap);
		return sourcingList;
	}
	
	/**
	 * 고용계약서 등록
	 * @param pMap
	 * @return
	 */
	public int insertEmpSourcing(Map<String, Object> pMap) {
		logger.info("perLogic empsourcingInsert  호출");
		return sqlPerDao.insertSourcing(pMap);
	}
	
	/**
	 * 부서추가
	 * @param pMap
	 * @return
	 */
	public int insertDept(Map<String, Object> pMap) {
		logger.info("insertDept : "+pMap);
		return sqlPerDao.insertDept(pMap);
	}
	
	/**
	 * 부서 수정
	 * @param pMap
	 * @return
	 */
	public int updateDept(Map<String, Object> pMap) {
		return  sqlPerDao.updateDept(pMap);
	}
	
	/**
	 * 부서 리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getdeptList(Map<String, Object> pMap) {
		List<Map<String, Object>> deptList = null;
		deptList = sqlPerDao.getDeptList(pMap);
		return deptList;
	}
	
	/**
	 * 인사발령 수정
	 * @param pMap
	 * @return
	 */
	public int updateEmployee(Map<String, Object> pMap) {
		return sqlPerDao.updateEmployee(pMap);
	}

	/**
	 * 직급리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getlevList(Map<String, Object> pMap) {
		List<Map<String,Object>> levList = null;
		levList = sqlPerDao.getLevList(pMap);
		return levList;
	}

	/**
	 * 근무지 리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getlocList(Map<String, Object> pMap) {
		List<Map<String,Object>> locList = null;
		locList = sqlPerDao.getLocList(pMap);
		return locList;
	}

	/**
	 * 전체팀 리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getTeamListView(Map<String, Object> pMap) {
		List<Map<String,Object>> teamList = null;
		teamList = sqlPerDao.getTeamListView(pMap);
		return teamList;

	}

	/**
	 * 팀추가 로직
	 * @param pMap
	 * @return
	 */
	public int insertTeam(Map<String, Object> pMap) {
		return sqlPerDao.insertTeam(pMap);
	}
	
	
	
	public List<Map<String, Object>> setAttdInsert(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> attdInsert = null;
		attdInsert = sqlPerDao.setAttdInsert(pMap);
		return null;
	}


	//급여 지급 페이지에서 나타나는 지급내역
	public Map<String, Object> getSalHistory(Map<String, Object> pMap) {
		Map<String, Object> rMap = new HashMap<String, Object>();
		int total = sqlPerDao.getTotalSalHistory(pMap);
		List<Map<String, Object>> rows = sqlPerDao.getSalHistory(pMap);
		rMap.put("total",total);
		rMap.put("rows", rows);
		return rMap;
	}

	public int insertSalary(Map<String, Object> pMap) {
		return sqlPerDao.insertSalary(pMap);
	}


	public int updateSalary(Map<String, Object> pMap) {
		return sqlPerDao.updateSalary(pMap);
		
	}

	/**
	 * 인사권한 체크
	 * @param pMap
	 * @return
	 */
	public boolean isPerAuth(Map<String, Object> pMap) {
		int result = sqlPerDao.isPerAuth(pMap);
		return result == 1 ? true : false;
	}

}
