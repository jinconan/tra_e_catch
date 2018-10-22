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
	 * ����� ���� ������ ��û DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getAttdList(Map<String, Object> pMap) {
		List<Map<String,Object>> attdList = null;
		attdList = sqlSessionTemplate.selectList("getAttdList",pMap);
		return attdList;
	}
	
	/**
	 * ���� ���� ������ ��û DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getCertList(Map<String, Object> pMap) {
		List<Map<String, Object>> certList = null;
		certList = sqlSessionTemplate.selectList("getCertList",pMap);
		return certList;
	}
	
	/**
	 * ���� ���� �߰�
	 * @param pMap
	 * @return
	 */
	public int insertCert(Map<String, Object> pMap) {
		logger.info("���������� ���� �͵� : "+pMap);
		return sqlSessionTemplate.insert("certinsert", pMap);
	}
	
	/**
	 * ���� ������ ���� 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getIndivList(Map<String, Object> pMap) {
		List<Map<String, Object>> indivList = null;
		indivList = sqlSessionTemplate.selectList("getIndivList", pMap);
		return indivList;
	}
	//����༭ ���� �������� ����
	public List<Map<String, Object>> getIndivlist(Map<String, Object> pMap) {
		List<Map<String, Object>> indivList = null;
		indivList = sqlSessionTemplate.selectList("getIndivlist", pMap);
		return indivList;
	}
	
	/**
	 * �޿����� ������ ��û DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getSalList(Map<String, Object> pMap) {
		List<Map<String,Object>> salList = null;//�������� �ǽ�
		salList = sqlSessionTemplate.selectList("getSalList",pMap);
		return salList;
	}
	/**
	 * ���� ����Ʈ ������ ��û DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getTeamList(Map<String, Object> pMap) {
		logger.info("getTeamList");
		List<Map<String,Object>> teamList = sqlSessionTemplate.selectList("getTeamList",pMap);
		return teamList;
	}
	
	/**
	 * ���� �ٹ����� �Ⱓ�з�
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getQuarList(Map<String, Object> pMap) {
		List<Map<String, Object>> quarlist = null;
		quarlist = sqlSessionTemplate.selectList("getQuarList", pMap);
		return quarlist;
	}
	
	/**
	 * �λ�����ǰ� 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getLeaderView(Map<String, Object> pMap) {
		logger.info("getLeaderView : " + pMap);
		List<Map<String, Object>> leaderview = null;
		leaderview = sqlSessionTemplate.selectList("getLeaderView",pMap);
		logger.info("�޴� �� : " + leaderview.get(0));
		return leaderview;
	}
	
	/**
	 * �ٹ����� ������ insert 
	 * @param pMap
	 * @return
	 */
	public int insertSerList(Map<String, Object> pMap) {
		logger.info("insertSerList : " + pMap);
		int result = sqlSessionTemplate.insert("insertSerList", pMap);
		return result;
	}
	
	/**
	 * ������ ������ ��û DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getEmpList(Map<String, Object> pMap) {
		logger.info("getEmpList :" + pMap);
		List<Map<String, Object>> getEmpList = sqlSessionTemplate.selectList("getEmpList",pMap );
		return getEmpList;
	}
	
	/**
	 * ���޸���Ʈ ��û DB
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> viewLevList(Map<String, Object> pMap) {
		List<Map<String, Object>> levList = null;
		levList = sqlSessionTemplate.selectList("viewLevList",pMap);
		return levList;
	}
	
	/**
	 * �ٹ��� ����Ʈ ��û DB
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
	 * �μ� ����Ʈ ��û DB
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
	 * ��� ��� insert
	 * @param pMap
	 * @return
	 */
	public int insertEmp(Map<String, Object> pMap) {
		logger.info("insertEmp : " + pMap);
		int result = sqlSessionTemplate.insert("insertEmp",pMap);
		return result;
	}
	
	/**
	 * �ٷΰ�༭ ��� 
	 * @param pMap
	 * @return
	 */
	public int insertLab(Map<String, Object> pMap) {
		logger.info("���������� ���� �͵� : " + pMap);
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
	 * ����༭ ��ȸ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> viewSourcingList(Map<String, Object> pMap) {
		List<Map<String, Object>> sourcingList = null;
		System.out.println("���������� ���� �͵� :" + pMap);
		sourcingList = sqlSessionTemplate.selectList("viewSourcingList", pMap);
		return sourcingList;
	}
	
	/**
	 * ����༭ ���
	 * @param pMap
	 * @return
	 */
	public int insertSourcing(Map<String, Object> pMap) {
		logger.info("���������� ���� �͵� :" +pMap);
		return sqlSessionTemplate.insert("insertSourcing", pMap);
	}
	
	/**
	 * �μ��߰�
	 * @param pMap
	 * @return
	 */
	public int insertDept(Map<String, Object> pMap) {
		logger.info(pMap);
		return sqlSessionTemplate.insert("insertDept",pMap);
	}
	
	/**
	 * �μ� ����
	 * @param pMap
	 * @return
	 */
	public int updateDept(Map<String, Object> pMap) {
		logger.info(pMap);
		return sqlSessionTemplate.update("updateDept",pMap);
	}
	
	/**
	 * �μ�����Ʈ
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
	 * ���޸���Ʈ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getLevList(Map<String, Object> pMap) {
		List<Map<String, Object>> levList = null;
		levList = sqlSessionTemplate.selectList("getLevList",pMap);
		return levList;
	}

	/**
	 * �ٹ��� ����Ʈ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getLocList(Map<String, Object> pMap) {
		List<Map<String, Object>> locList = null;
		locList = sqlSessionTemplate.selectList("getLocList",pMap);
		return locList;
	}
	
	/**
	 * �� ����Ʈ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getTeamListView(Map<String, Object> pMap) {
		List<Map<String, Object>> teamList = null;
		teamList = sqlSessionTemplate.selectList("getTeamListView",pMap);
		return teamList;
	}
	
	/**
	 * ������ �μ�Ʈ
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
	

	
	
	


		
	// �����Ͽ� �˻��� �޿������� �� ��.
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

	// �����Ͽ� �˻��� �޿������� ����Ʈ ��ȸ
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
	 * �λ���� üũ
	 * @param pMap
	 * @return
	 */
	public int isPerAuth(Map<String, Object> pMap) {
		logger.info("isPerAuth");
		return sqlSessionTemplate.selectOne("isPerAuth", pMap);
	}

	
	/**
	 * ���� ���� �� ����
	 * @param pMap
	 * @return
	 */
	public int getTotalLeave(Map<String, Object> pMap) {
		logger.info("getTotalLeave");
		return sqlSessionTemplate.selectOne("getTotalLeave", pMap);
	}

	/**
	 * ���� ����
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getLeavList(Map<String, Object> pMap) {
		logger.info("getLeaveList");
		return sqlSessionTemplate.selectList("getLeaveList",pMap);
	}
	
	/**
	 * ���� ���� ���� �� ��
	 * @param pMap
	 * @return
	 */
	public double getRemainLeave(Map<String, Object> pMap) {
		logger.info("getRemainLeave");
		return sqlSessionTemplate.selectOne("getRemainLeave", pMap);
	}

	public void startrating(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
			logger.info("startrating ȣ�� - DAO");
		System.out.println("�ٿ����� ���� ó�� �� : "+pMap);
		try {
			sqlSessionTemplate.selectOne("startrating", pMap);
			logger.info("startrating-DAO ���� ó�� �Ϸ�");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		
	}
}
