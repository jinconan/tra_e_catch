package com.team.tra_e_catch.personnel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Repository;

@Repository
public class SqlPerDao {
	Logger logger = Logger.getLogger(SqlPerDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	/**
	 * 출퇴근 내역 데이터 요청 DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getAttdList(Map<String, Object> pMap) {
		List<Map<String,Object>> attdList = null;
		attdList = sqlSessionTemplate.selectList("getAttdList",pMap);
		return attdList;
	}
	
	/**
	 * 증명서 내역 데이터 요청 DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getCertList(Map<String, Object> pMap) {
		List<Map<String, Object>> certList = null;
		certList = sqlSessionTemplate.selectList("getCertList",pMap);
		return certList;
	}
	
	/**
	 * 증명서 내역 추가
	 * @param pMap
	 * @return
	 */
	public int insertCert(Map<String, Object> pMap) {
		logger.info("최종적으로 들어가는 것들 : "+pMap);
		return sqlSessionTemplate.insert("certinsert", pMap);
	}
	
	/**
	 * 개인 프로필 정보 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getIndivList(Map<String, Object> pMap) {
		List<Map<String, Object>> indivList = null;
		indivList = sqlSessionTemplate.selectList("getIndivList", pMap);
		return indivList;
	}
	//고용계약서 개인 ㅣ프로필 정보
	public List<Map<String, Object>> getIndivlist(Map<String, Object> pMap) {
		List<Map<String, Object>> indivList = null;
		indivList = sqlSessionTemplate.selectList("getIndivlist", pMap);
		return indivList;
	}
	
	/**
	 * 급여내역 데이터 요청 DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getSalList(Map<String, Object> pMap) {
		List<Map<String,Object>> salList = null;//널포인터 의심
		salList = sqlSessionTemplate.selectList("getSalList",pMap);
		return salList;
	}
	/**
	 * 팀원 리스트 데이터 요청 DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getTeamList(Map<String, Object> pMap) {
		logger.info("getTeamList");
		List<Map<String,Object>> teamList = sqlSessionTemplate.selectList("getTeamList",pMap);
		return teamList;
	}
	
	/**
	 * 개인 근무평정 기간분류
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getQuarList(Map<String, Object> pMap) {
		List<Map<String, Object>> quarlist = null;
		quarlist = sqlSessionTemplate.selectList("getQuarList", pMap);
		return quarlist;
	}
	
	/**
	 * 인사권자의견 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getLeaderView(Map<String, Object> pMap) {
		logger.info("getLeaderView : " + pMap);
		List<Map<String, Object>> leaderview = null;
		leaderview = sqlSessionTemplate.selectList("getLeaderView",pMap);
		logger.info("받는 값 : " + leaderview.get(0));
		return leaderview;
	}
	
	/**
	 * 근무평정 데이터 insert 
	 * @param pMap
	 * @return
	 */
	public int insertSerList(Map<String, Object> pMap) {
		logger.info("insertSerList : " + pMap);
		int result = sqlSessionTemplate.insert("insertSerList", pMap);
		return result;
	}
	
	/**
	 * 사원명부 데이터 요청 DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getEmpList(Map<String, Object> pMap) {
		logger.info("getEmpList :" + pMap);
		List<Map<String, Object>> getEmpList = sqlSessionTemplate.selectList("getEmpList",pMap );
		return getEmpList;
	}
	
	/**
	 * 직급리스트 요청 DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> viewLevList(Map<String, Object> pMap) {
		List<Map<String, Object>> levList = null;
		levList = sqlSessionTemplate.selectList("viewLevList",pMap);
		return levList;
	}
	
	/**
	 * 근무지 리스트 요청 DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> viewLocList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> locList = null;
		locList = sqlSessionTemplate.selectList("viewLocList",pMap);
		return locList;

	}
	/**
	 * 부서 리스트 요청 DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> viewDeptList(Map<String, Object> pMap) {
		logger.info(pMap);
		List<Map<String, Object>> deptList = null;
		deptList = sqlSessionTemplate.selectList("viewDeptList",pMap);
		return deptList;

	}
	
	/**
	 * 사원 등록 insert
	 * @param pMap
	 * @return
	 */
	public int insertEmp(Map<String, Object> pMap) {
		logger.info("insertEmp : " + pMap);
		int result = sqlSessionTemplate.insert("insertEmp",pMap);
		return result;
	}
	
	/**
	 * 근로계약서 등록 
	 * @param pMap
	 * @return
	 */
	public int insertLab(Map<String, Object> pMap) {
		logger.info("최종적으로 들어가는 것들 : " + pMap);
		int result=sqlSessionTemplate.insert("insertLab", pMap);
		return result;
	}
	
	/**
	 * 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> viewWorkList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> workList = null;
		workList = sqlSessionTemplate.selectList("viewWorkList",pMap);
		return workList;
	}
	
	/**
	 * 고용계약서 조회
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> viewSourcingList(Map<String, Object> pMap) {
		List<Map<String, Object>> sourcingList = null;
		System.out.println("최종적으로 들어가는 것들 :" + pMap);
		sourcingList = sqlSessionTemplate.selectList("viewSourcingList", pMap);
		return sourcingList;
	}
	
	/**
	 * 고용계약서 등록
	 * @param pMap
	 * @return
	 */
	public int insertSourcing(Map<String, Object> pMap) {
		logger.info("최종적으로 들어가는 것들 :" +pMap);
		return sqlSessionTemplate.insert("insertSourcing", pMap);
	}
	
	/**
	 * 부서추가
	 * @param pMap
	 * @return
	 */
	public int insertDept(Map<String, Object> pMap) {
		logger.info(pMap);
		return sqlSessionTemplate.insert("insertDept",pMap);
	}
	
	/**
	 * 부서 수정
	 * @param pMap
	 * @return
	 */
	public int updateDept(Map<String, Object> pMap) {
		logger.info(pMap);
		return sqlSessionTemplate.update("updateDept",pMap);
	}
	
	/**
	 * 부서리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getDeptList(Map<String, Object> pMap) {
		List<Map<String, Object>> deptList = null;
		deptList = sqlSessionTemplate.selectList("getDeptList", pMap);
		return deptList;
	}
	
	/**
	 * 
	 * @param pMap
	 * @return
	 */
	public int updateEmployee(Map<String, Object> pMap) {
		int result = sqlSessionTemplate.update("updateEmployee",pMap);
		return result;
	}

	/**
	 * 직급리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getLevList(Map<String, Object> pMap) {
		List<Map<String, Object>> levList = null;
		levList = sqlSessionTemplate.selectList("getLevList",pMap);
		return levList;
	}

	/**
	 * 근무지 리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getLocList(Map<String, Object> pMap) {
		List<Map<String, Object>> locList = null;
		locList = sqlSessionTemplate.selectList("getLocList",pMap);
		return locList;
	}
	
	/**
	 * 팀 리스트
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getTeamListView(Map<String, Object> pMap) {
		List<Map<String, Object>> teamList = null;
		teamList = sqlSessionTemplate.selectList("getTeamListView",pMap);
		return teamList;
	}
	
	/**
	 * 팀정보 인서트
	 * @param pMap
	 * @return
	 */
	public int insertTeam(Map<String, Object> pMap) {
		return sqlSessionTemplate.insert("insertTeam", pMap);
	}
	
	
	public List<Map<String, Object>> setAttdInsert(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> attdInsert = null;
		attdInsert = sqlSessionTemplate.selectOne("setAttdInsert",pMap);
		return null;
	}
	

	
	
	


		
	// 조건하에 검색된 급여내역의 건 수.
	public int getTotalSalHistory(Map<String, Object> pMap) {
		logger.info("getTotalSalHistory");
		int result = 0;
		try {
			result = sqlSessionTemplate.selectOne("getTotalSalHistory", pMap);
		} catch (Exception e) {
			logger.error(e.toString());
		}

		return result;
	}

	// 조건하에 검색된 급여내역의 리스트 조회
	public List<Map<String, Object>> getSalHistory(Map<String, Object> pMap) {
		logger.info("getTotalSalHistory");
		List<Map<String, Object>> result = null;
		try {
			result = sqlSessionTemplate.selectList("getSalHistory", pMap);
		} catch (Exception e) {
			logger.error(e.toString());
			result = new ArrayList<Map<String, Object>>();
		}

		return result;
	}

	public List<Map<String, Object>> getEmpListForSalary() {
		logger.info("getEmpListForSalary");
		List<Map<String, Object>> result = null;
		try {
			result = sqlSessionTemplate.selectList("getEmpListForSalary");
		} catch (Exception e) {
			logger.error(e.toString());
			result = new ArrayList<Map<String, Object>>();
		}
		return result;
	}

	public int insertSalary(Map<String, Object> pMap) {
		logger.info("insertSalary");
		int result = 0;
		try {
			result = sqlSessionTemplate.selectOne("insertSalary", pMap);
		} catch (Exception e) {
			logger.error(e.toString());
		}

		return result;
	}

	public int updateSalary(Map<String, Object> pMap) {
		logger.info("updateSalary");
		int result = 0;
		try {
			result = sqlSessionTemplate.selectOne("updateSalary", pMap);
		} catch (Exception e) {
			logger.error(e.toString());
		}

		return result;
	}
		
	/**
	 * 인사권차 체크
	 * @param pMap
	 * @return
	 */
	public int isPerAuth(Map<String, Object> pMap) {
		logger.info("isPerAuth");
		return sqlSessionTemplate.selectOne("isPerAuth", pMap);
	}

	
	/**
	 * 연차 내역 총 갯수
	 * @param pMap
	 * @return
	 */
	public int getTotalLeave(Map<String, Object> pMap) {
		logger.info("getTotalLeave");
		return sqlSessionTemplate.selectOne("getTotalLeave", pMap);
	}

	/**
	 * 연차 내역
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getLeavList(Map<String, Object> pMap) {
		logger.info("getLeaveList");
		return sqlSessionTemplate.selectList("getLeaveList",pMap);
	}
	
	/**
	 * 올해 남은 연차 일 수
	 * @param pMap
	 * @return
	 */
	public double getRemainLeave(Map<String, Object> pMap) {
		logger.info("getRemainLeave");
		return sqlSessionTemplate.selectOne("getRemainLeave", pMap);
	}

	public void startrating(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
			logger.info("startrating 호출 - DAO");
		System.out.println("다오에서 최종 처리 맵 : "+pMap);
		try {
			sqlSessionTemplate.selectOne("startrating", pMap);
			logger.info("startrating-DAO 정상 처리 완료");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		
	}
}
