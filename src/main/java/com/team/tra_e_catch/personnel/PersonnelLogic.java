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
	 * ����� ���� JSON������ ��û
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getAttdList(Map<String, Object> pMap) {
		logger.info("getAttdList :"+pMap);
		return sqlPerDao.getAttdList(pMap);
	}
	
	/**
	 * ���� ���� json������ ��û
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getCertlist(Map<String, Object> pMap) {
		logger.info("getCertlist :" + pMap);
		return sqlPerDao.getCertList(pMap);
	}
	
	/**
	 * ���� ���� �߰�
	 * @param pMap
	 * @return
	 */
	public int insertCert(Map<String, Object> pMap) {
		return sqlPerDao.insertCert(pMap);
	}
	
	/**
	 * ���� �Ż� ���� ������ ��û
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getindivList(Map<String, Object> pMap) {
		logger.info("getindivList :" + pMap);
		List<Map<String, Object>> serList = null;
		serList = sqlPerDao.getIndivList(pMap); 
		return serList;
	}
	//����༭ ���νŻ� ������
	public List<Map<String, Object>> getindivlist(Map<String, Object> pMap) {
		logger.info("getindivlist :" + pMap);
		List<Map<String, Object>> serList = null;
		serList = sqlPerDao.getIndivlist(pMap); 
		return serList;
	}
	
	/**
	 * �޿����� JSON���� ������ ��û 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getSalList(Map<String, Object> pMap) {
		logger.info("getSalList ȣ�� ���� :" + pMap);
		List<Map<String,Object>> salList = sqlPerDao.getSalList(pMap);
		return salList;
	}
	
	/**
	 * ���� ����Ʈ ������ ��û
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getTeamList(Map<String, Object> pMap) {
		logger.info("getTeamList ȣ�� ����");
		List<Map<String,Object>> teamList = sqlPerDao.getTeamList(pMap);
		return teamList;
	}

	/**
	 * �������� Ȯ�� �б� ����Ʈ 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getQuarList(Map<String, Object> pMap) {
		List<Map<String,Object>> quarlist = null;
		quarlist = sqlPerDao.getQuarList(pMap);
		return quarlist;
	}
	
	/**
	 * �λ�����ǰ� 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getleaderView(Map<String, Object> pMap) {
		List<Map<String,Object>> leaderview = null;
		leaderview = sqlPerDao.getLeaderView(pMap);
		return leaderview;
	}

	
	/**
	 * ���� �߰�
	 * @param pMap
	 * @return
	 */
	public int insertServrating(Map<String, Object> pMap) {
		logger.info("insertServrating : " + pMap);
		int result = sqlPerDao.insertSerList(pMap);
		return result;
	}

	/**
	 * ������
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getEmpList(Map<String, Object> pMap) {
		logger.info("getEmpList ȣ�� :" + pMap);
		List<Map<String, Object>> empList = sqlPerDao.getEmpList(pMap);
		return empList;
	}

	/**
	 * ���� ����Ʈ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getlevlist(Map<String, Object> pMap) {
		List<Map<String, Object>> levList = null;
		levList = sqlPerDao.viewLevList(pMap);
		return levList;
	}

	/**
	 * ���� ����Ʈ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getLocList(Map<String, Object> pMap) {
		List<Map<String, Object>> locList = null;
		locList = sqlPerDao.viewLocList(pMap);
		return locList;
	}

	/**
	 * �μ� ����Ʈ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getDeptList(Map<String, Object> pMap) {
		List<Map<String, Object>> deptList = null;
		deptList = sqlPerDao.viewDeptList(pMap);
		return deptList;
	}

	/**
	 * ��� ��� ����
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
		logger.info("insertLab  ȣ��");
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
	 * ����༭ ��ȸ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getSourcingList(Map<String, Object> pMap) {
		logger.info("perLogic sourcingList  ȣ��");
		List<Map<String,Object>> sourcingList = null;
		sourcingList = sqlPerDao.viewSourcingList(pMap);
		return sourcingList;
	}
	
	/**
	 * ����༭ ���
	 * @param pMap
	 * @return
	 */
	public int insertEmpSourcing(Map<String, Object> pMap) {
		logger.info("perLogic empsourcingInsert  ȣ��");
		return sqlPerDao.insertSourcing(pMap);
	}
	
	/**
	 * �μ��߰�
	 * @param pMap
	 * @return
	 */
	public int insertDept(Map<String, Object> pMap) {
		logger.info("insertDept : "+pMap);
		return sqlPerDao.insertDept(pMap);
	}
	
	/**
	 * �μ� ����
	 * @param pMap
	 * @return
	 */
	public int updateDept(Map<String, Object> pMap) {
		return  sqlPerDao.updateDept(pMap);
	}
	
	/**
	 * �μ� ����Ʈ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getdeptList(Map<String, Object> pMap) {
		List<Map<String, Object>> deptList = null;
		deptList = sqlPerDao.getDeptList(pMap);
		return deptList;
	}
	
	/**
	 * �λ�߷� ����
	 * @param pMap
	 * @return
	 */
	public int updateEmployee(Map<String, Object> pMap) {
		return sqlPerDao.updateEmployee(pMap);
	}

	/**
	 * ���޸���Ʈ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getlevList(Map<String, Object> pMap) {
		List<Map<String,Object>> levList = null;
		levList = sqlPerDao.getLevList(pMap);
		return levList;
	}

	/**
	 * �ٹ��� ����Ʈ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getlocList(Map<String, Object> pMap) {
		List<Map<String,Object>> locList = null;
		locList = sqlPerDao.getLocList(pMap);
		return locList;
	}

	/**
	 * ��ü�� ����Ʈ
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getTeamListView(Map<String, Object> pMap) {
		List<Map<String,Object>> teamList = null;
		teamList = sqlPerDao.getTeamListView(pMap);
		return teamList;

	}

	/**
	 * ���߰� ����
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


	//�޿� ���� ���������� ��Ÿ���� ���޳���
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
	 * �λ���� üũ
	 * @param pMap
	 * @return
	 */
	public boolean isPerAuth(Map<String, Object> pMap) {
		int result = sqlPerDao.isPerAuth(pMap);
		return result == 1 ? true : false;
	}

}
