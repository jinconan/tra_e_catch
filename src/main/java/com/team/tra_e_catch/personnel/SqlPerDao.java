package com.team.tra_e_catch.personnel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.EnableLoadTimeWeaving;


public class SqlPerDao {
	Logger logger = Logger.getLogger(SqlPerDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	/**
	 * 
	 * @param pMap
	 * @return
	 */
	//����� ���� ������ ��û DB
	public List<Map<String, Object>> getAttdList(Map<String, Object> pMap) {
		List<Map<String,Object>> attdList = null;
		attdList = sqlSessionTemplate.selectList("getAttdList",pMap);
		return attdList;
	}
	//�޿����� ������ ��û DB
	public List<Map<String, Object>> getSalList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> salList = null;//�������� �ǽ�
		salList = sqlSessionTemplate.selectList("getSalList",pMap);
		return salList;
	}
	public List<Map<String, Object>> getTeamList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("sqlTeamȮ��");
		List<Map<String,Object>> teamList = null;
		teamList = sqlSessionTemplate.selectList("getTeamList",pMap);
		return teamList;
	}
		//������ ������ ��û DB
	public List<Map<String, Object>> getEmpList(Map<String, Object> pMap) {
		logger.info("���Ծ�");
		List<Map<String, Object>> getEmpList = null;
		getEmpList = sqlSessionTemplate.selectList("getEmpList",pMap );
		
		return getEmpList;
		
	}
	//�ٹ����� ������ insert
	
	public List<Map<String, Object>> setSerList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> serList = null;
		serList = sqlSessionTemplate.selectOne("setSerList",pMap);
		
		
		return serList;
	}
	//���� ������ ����
	public List<Map<String, Object>> getIndivList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> indivList = null;
		indivList = sqlSessionTemplate.selectList("getIndivList",pMap);
		return indivList;
	}
	public List<Map<String, Object>> getCertList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> certList = null;
		certList = sqlSessionTemplate.selectList("getCertList",pMap);
		return certList;
	}
	public List<Map<String, Object>> setAttdInsert(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> attdInsert = null;
		attdInsert = sqlSessionTemplate.selectOne("setAttdInsert",pMap);
		return null;
	}
	public List<Map<String, Object>> viewLevList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> levList = null;
		levList = sqlSessionTemplate.selectList("viewLevList",pMap);
		return levList;
	}
	public List<Map<String, Object>> viewLocList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> locList = null;
		locList = sqlSessionTemplate.selectList("viewLocList",pMap);
		return locList;

	}
	public List<Map<String, Object>> viewDeptList(Map<String, Object> pMap) {
		List<Map<String, Object>> deptList = null;
		deptList = sqlSessionTemplate.selectList("viewDeptList",pMap);
		return deptList;

	}
	public List<Map<String, Object>> EmpInsert(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> attdInsert = null;
		attdInsert = sqlSessionTemplate.selectOne("EmpInsert",pMap);
		return null;
	}
	public List<Map<String, Object>> CertInsert(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		System.out.println("���������� ���� �͵� : "+pMap);
		sqlSessionTemplate.insert("certinsert", pMap);
		return null;
	}
	public List<Map<String, Object>> viewWorkList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> workList = null;
		workList = sqlSessionTemplate.selectList("viewWorkList",pMap);
		return workList;
	}
	
	public List<Map<String, Object>> LabInsert(Map<String, Object> pMap) {
		System.out.println("���������� ���� �͵� : "+pMap);
		sqlSessionTemplate.insert("labInsert", pMap);
		return null;
	}
	//����༭ ��ȸ
		public List<Map<String, Object>> viewSourcingList(Map<String, Object> pMap) {
			List<Map<String,Object>> sourcingList = null;
			System.out.println("���������� ���� �͵� :" +pMap);
			sourcingList = sqlSessionTemplate.selectList("viewSourcingList", pMap);
			return sourcingList;
		}
		//����༭ ���
		public List<Map<String, Object>> SourcingInsert(Map<String, Object> pMap) {
			System.out.println("���������� ���� �͵� :" +pMap);
			sqlSessionTemplate.insert("sourcingInsert", pMap);
			return null;
		}
		//���޸���Ʈ 
		public List<Map<String, Object>> getLevList(Map<String, Object> pMap) {
			// TODO Auto-generated method stub
			List<Map<String, Object>> levList = null;
			levList = sqlSessionTemplate.selectList("getLevList",pMap);
			return levList;
		}
		//�ٹ��� ����Ʈ
		public List<Map<String, Object>> getLocList(Map<String, Object> pMap) {
			// TODO Auto-generated method stub
			List<Map<String, Object>> locList = null;
			locList = sqlSessionTemplate.selectList("getLocList",pMap);
			return locList;
		}
		//�μ�����Ʈ
		public List<Map<String, Object>> getDeptList(Map<String, Object> pMap) {
			// TODO Auto-generated method stub
			List<Map<String, Object>> deptList = null;
			deptList = sqlSessionTemplate.selectList("getDeptList",pMap);
			return deptList;
		}
		public List<Map<String, Object>> updateEmployee(Map<String, Object> pMap) {
			// TODO Auto-generated method stub
			List<Map<String, Object>> updateList = null;
			updateList = sqlSessionTemplate.selectOne("updateEmployee",pMap);
			return updateList;
		}
		public List<Map<String, Object>> getTeamListView(Map<String, Object> pMap) {
			List<Map<String, Object>> teamList = null;
			teamList = sqlSessionTemplate.selectList("getTeamListView",pMap);
			return teamList;
		}

	
}
