package com.team.tra_e_catch.plan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.LoggerFactory;

public class SqlPlanDao {
//	Logger logger = Logger.getLogger(SqlPlanDao.class);
	org.slf4j.Logger logger = LoggerFactory.getLogger(SqlPlanDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	/**
	 * 프로젝트 리스트 얻는 메소드
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getProjList(Map<String, Object> pMap) {
		logger.info("getProjList() 호출");
		List<Map<String, Object>> projList = null;
		
		try {
			projList = sqlSessionTemplate.selectList(
					"mybatis-mapper.planMapper.getProjList", pMap);
			logger.info("리스트 수 : " + projList.size());
		} catch(Exception e) {
			logger.error(e.toString());
			projList = new ArrayList<Map<String,Object>>();
		}
		return projList;
	}

	/**
	 * 프로젝트 리스트안의 프로젝트 수를 리턴하는 메소드
	 * @param pMap
	 * @return
	 */
	public int getNumOfProjPage(Map<String, Object> pMap) {
		logger.info("getNumberOfProj() 호출");
		int result = 0;
		try {
			result = sqlSessionTemplate.selectOne("mybatis-mapper.planMapper.getNumOfProjPage",pMap);
			logger.info("페이지 수 : " + result);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	/**
	 * 특정 프로젝트의 상세 정보를 리턴
	 * @param pMap
	 * @return
	 */
	public Map<String, Object> getProjDetail(int projNo) {
		logger.info("getProjDetail()");
		Map<String, Object> result = null;
		try {
			result = sqlSessionTemplate.selectOne("mybatis-mapper.planMapper.getProjDetail", projNo);
			logger.info("result : " + result);
		} catch(Exception e) {
			logger.error(e.toString());
			result = new HashMap<String,Object>();
		}
		return result;
	}

	/**
	 * 프로젝트의 일정 리스트를 리턴
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getProjTimeline(Map<String,Object> pMap) {
		logger.info("getProjTimeline()");
		List<Map<String,Object>> result = null;
		try {
			result = sqlSessionTemplate.selectList("mybatis-mapper.planMapper.getProjTimeline", pMap);
			logger.info("result.size(): "+result.size());
		} catch(Exception e) {
			logger.error(e.toString());
			result = new ArrayList<Map<String, Object>> ();
		}
		return result;
	}
	
	public List<Map<String, Object>> getJsonProjTimeline(Map<String,Object> pMap) {
		logger.info("getJsonProjTimeline()");
		List<Map<String,Object>> result = null;
		try {
			result = sqlSessionTemplate.selectList("mybatis-mapper.planMapper.getJsonProjTimeline", pMap);
			logger.info("result.size(): "+result.size());
		} catch(Exception e) {
			logger.error(e.toString());
			result = new ArrayList<Map<String, Object>> ();
		}
		return result;
	}

	public int insertProj(Map<String, Object> pMap) {
		logger.info("insertProj()");
		int result = 0;
		
		try {
			result = sqlSessionTemplate.insert("mybatis-mapper.planMapper.insertProj", pMap);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
	
	public int deleteProj(int projNo) {
		logger.info("deleteProj()");
		int result =0;
		try {
			result = sqlSessionTemplate.delete("mybatis-mapper.planMapper.deleteProj", projNo);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
}
