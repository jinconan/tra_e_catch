package com.team.tra_e_catch.personnel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonnelLogic {
	Logger logger = Logger.getLogger(PersonnelLogic.class);
	
	@Autowired
	private SqlPerDao sqlPerDao = null;
	
	//����� ���� JSON������ ��û
	public List<Map<String, Object>> getAttdList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("getAttdList ȣ�� ����");
		
		List<Map<String,Object>> attdList = null;
		
		attdList = sqlPerDao.getAttdList(pMap);
		return attdList;
	}
	
	
	//�޿����� JSON���� ������ ��û
	public List<Map<String, Object>> getSalList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("getSalList ȣ�� ����");
		
		List<Map<String,Object>> salList = null;
		
		salList = sqlPerDao.getSalList(pMap);
		return salList;
	}
	


	public List<Map<String, Object>> getTeamList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("getTeamList ȣ�� ����");
		List<Map<String,Object>> teamList = null;
		teamList = sqlPerDao.getTeamList(pMap);
		return teamList;
	}



	public List<Map<String, Object>> setServrating(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> serList = null;
		serList = sqlPerDao.setSerList(pMap);
		return serList;
	}


	public List<Map<String, Object>> getindivList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> serList = null;
		serList = sqlPerDao.getIndivList(pMap);
		return serList;
	}


	public List<Map<String, Object>> getCertlist(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> certList = null;
		certList = sqlPerDao.getCertList(pMap);
		return certList;
	}


	public List<Map<String, Object>> setAttdInsert(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> attdInsert = null;
		attdInsert = sqlPerDao.setAttdInsert(pMap);
		return null;
	}


	public List<Map<String, Object>> getlevlist(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> levList = null;
		levList = sqlPerDao.viewLevList(pMap);
		return levList;
	}


	public List<Map<String, Object>> getLocList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> locList = null;
		locList = sqlPerDao.viewLocList(pMap);
		return locList;
	}


	public List<Map<String, Object>> getDeptList(Map<String, Object> pMap) {
		List<Map<String, Object>> deptList = null;
		deptList = sqlPerDao.viewDeptList(pMap);
		return deptList;
	}


	public List<Map<String, Object>> EmpInsert(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> empInsert = null;
		empInsert = sqlPerDao.EmpInsert(pMap);
		return null;
	}


	public List<Map<String, Object>> certInsert(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> certInsert = null;
		certInsert = sqlPerDao.CertInsert(pMap);
		return null;
	}


	public List<Map<String, Object>> getWorkList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> workList = null;
		workList = sqlPerDao.viewWorkList(pMap);
		return workList;
	}


	public List<Map<String, Object>> labInsert(Map<String, Object> pMap) {
		List<Map<String, Object>> labInsert = null;
		labInsert = sqlPerDao.LabInsert(pMap);
		return labInsert;
	}

	//����༭ ��ȸ
		public List<Map<String, Object>> getSourcingList(Map<String, Object> pMap) {
			logger.info("perLogic sourcingList  ȣ��");
			List<Map<String,Object>> sourcingList = null;
			sourcingList = sqlPerDao.viewSourcingList(pMap);
			return sourcingList;
		}

	//����༭ ���
		public List<Map<String, Object>> empsourcingInsert(Map<String, Object> pMap) {
			logger.info("perLogic empsourcingInsert  ȣ��");
			List<Map<String,Object>> sourcinginsert = null;
			sourcinginsert = sqlPerDao.SourcingInsert(pMap);
			return sourcinginsert;
		}

	//������
		public List<Map<String, Object>> getEmpList(Map<String, Object> pMap) {
			logger.info("perLogic  getEmpList ȣ��");
			List<Map<String,Object>> empList = null;
			 empList = sqlPerDao.getEmpList(pMap);
			return empList;
		}

		//���޸���Ʈ
		public List<Map<String, Object>> getlevList(Map<String, Object> pMap) {
			// TODO Auto-generated method stub
			List<Map<String,Object>> levList = null;
			levList = sqlPerDao.getLevList(pMap);
			return levList;
		}

		//�ٹ��� ����Ʈ
		public List<Map<String, Object>> getlocList(Map<String, Object> pMap) {
			// TODO Auto-generated method stub
			List<Map<String,Object>> locList = null;
			locList = sqlPerDao.getLocList(pMap);
			return locList;
		}

		//�μ� ����Ʈ
		public List<Map<String, Object>> getdeptList(Map<String, Object> pMap) {
			// TODO Auto-generated method stub
			List<Map<String,Object>> deptList = null;
			deptList = sqlPerDao.getDeptList(pMap);
			return deptList;
		}

		//�λ�߷� ����
		public List<Map<String, Object>> updateEmployee(Map<String, Object> pMap) {
			// TODO Auto-generated method stub
			List<Map<String,Object>> empupdatelist = null;
			empupdatelist = sqlPerDao.updateEmployee(pMap);
			return empupdatelist;
		}

		//��ü�� ����Ʈ
		public List<Map<String, Object>> getTeamListView(Map<String, Object> pMap) {
			// TODO Auto-generated method stub
			List<Map<String,Object>> teamList = null;
			teamList = sqlPerDao.getTeamListView(pMap);
			return teamList;

		}

		//�μ��߰�
		public List<Map<String, Object>> deptInsert(Map<String, Object> pMap) {
			// TODO Auto-generated method stub
			List<Map<String,Object>> deptinsert = null;
			deptinsert = sqlPerDao.deptInsert(pMap);
			return null;
		}

		//�μ� ����
		public List<Map<String, Object>> deptUpdate(Map<String, Object> pMap) {
			// TODO Auto-generated method stub
			List<Map<String,Object>> deptupdate = null;
			deptupdate = sqlPerDao.deptUpdate(pMap);
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

		//���߰� ����
		public List<Map<String, Object>> teamInsert(Map<String, Object> pMap) {
			// TODO Auto-generated method stub
			List<Map<String,Object>> teaminsert = null;
			teaminsert = sqlPerDao.teamInsert(pMap);
			return null;
		}

		//�������� Ȯ�� �б� ����Ʈ
		public List<Map<String, Object>> getQuarList(Map<String, Object> pMap) {
			List<Map<String,Object>> quarlist = null;
			quarlist = sqlPerDao.getQuarList(pMap);
			return quarlist;
		}

		//�λ�����ǰ�
		public List<Map<String, Object>> getleaderView(Map<String, Object> pMap) {
			// TODO Auto-generated method stub
			List<Map<String,Object>> leaderview = null;
			leaderview = sqlPerDao.getLeaderView(pMap);
			return leaderview;
		}

}
