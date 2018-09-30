package com.team.tra_e_catch.plan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class SqlPlanDao {
	Logger logger = Logger.getLogger(SqlPlanDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public List<Map<String, Object>> getPropList(Map<String, Object> pMap) {
		logger.info("getPropList() ȣ��");
		List<Map<String, Object>> propList = null;	
		
		try {
			propList = sqlSessionTemplate.selectList(
					"mybatis-mapper.planMapper.getPropList", pMap);
			logger.info("����Ʈ �� : " + propList.size());
		} catch(Exception e) {
			logger.error(e.toString());
			propList = new ArrayList<Map<String,Object>>();
		}
		return propList;
	}
	
	
	public int getNumOfPropPage(Map<String, Object> pMap) {
		logger.info("getNumOfPropPage() ȣ��");
		int result = 0;
		try {
			result = sqlSessionTemplate.selectOne("mybatis-mapper.planMapper.getNumOfPropPage",pMap);
			logger.info("������ �� : " + result);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
	
	public int insertProp(Map<String, Object> pMap) {
		logger.info("insertProp()");
		int result = 0;
		try {
			result = sqlSessionTemplate.insert("mybatis-mapper.planMapper.insertProp", pMap);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
	
	/**
	 * ������Ʈ ����Ʈ ��� �޼ҵ�
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> getProjList(Map<String, Object> pMap) {
		logger.info("getProjList() ȣ��");
		List<Map<String, Object>> projList = null;
		
		try {
			projList = sqlSessionTemplate.selectList(
					"mybatis-mapper.planMapper.getProjList", pMap);
			logger.info("����Ʈ �� : " + projList.size());
		} catch(Exception e) {
			logger.error(e.toString());
			projList = new ArrayList<Map<String,Object>>();
		}
		return projList;
	}

	/**
	 * ������Ʈ ����Ʈ���� ������Ʈ ���� �����ϴ� �޼ҵ�
	 * @param pMap
	 * @return
	 */
	public int getNumOfProjPage(Map<String, Object> pMap) {
		logger.info("getNumberOfProj() ȣ��");
		int result = 0;
		try {
			result = sqlSessionTemplate.selectOne("mybatis-mapper.planMapper.getNumOfProjPage",pMap);
			logger.info("������ �� : " + result);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	/**
	 * Ư�� ������Ʈ�� �� ������ ����
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
	
	public int updateProj(Map<String,Object> pMap) {
		logger.info("updateProj()");
		int result =0;
		try {
			result = sqlSessionTemplate.update("mybatis-mapper.planMapper.updateProj", pMap);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	public int insertTimeline(Map<String,Object> pMap) {
		logger.info("insertTimeline()");
		int result = 0;
		try {
			result = sqlSessionTemplate.insert("mybatis-mapper.planMapper.insertTimeline",pMap);
			logger.info("insertTimeline() = " + result);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
	public int updateTimeline(Map<String,Object> pMap) {
		logger.info("updateTimeline()");
		int result = 0;
		try {
			result = sqlSessionTemplate.update("mybatis-mapper.planMapper.updateTimeline",pMap);
			logger.info("updateTimeline() = " + result);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
	public int deleteTimeline(Map<String,Object> pMap) {
		logger.info("deleteTimeline()");
		int result = 0;
		try {
			result = sqlSessionTemplate.delete("mybatis-mapper.planMapper.deleteTimeline",pMap);
			logger.info("deleteTimeline() = " + result);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
	
	public int insertMember(Map<String, Object> pMap) {
		logger.info("insertMember()");
		int result = 0;
		try {
			result = sqlSessionTemplate.insert("mybatis-mapper.planMapper.insertMember",pMap);
			logger.info("insertMember() = " + result);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
	public int deleteMember(Map<String, Object> pMap) {
		logger.info("deleteMember()");
		int result = 0;
		try {
			result = sqlSessionTemplate.delete("mybatis-mapper.planMapper.deleteMember",pMap);
			logger.info("deleteMember() = " + result);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
	public int updateMember(Map<String, Object> pMap) {
		logger.info("updateMember()");
		int result = 0;
		try {
			result = sqlSessionTemplate.update("mybatis-mapper.planMapper.updateMember",pMap);
			logger.info("updateMember() = " + result);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
	
	public List<Map<String, Object>> getProjBoardList(int projNo) {
		logger.info("getJsonNotProjMemberList(): projNo = " + projNo);
		List<Map<String, Object>> result = null;
		try {
			result = sqlSessionTemplate.selectList("mybatis-mapper.planMapper.getProjBoardList",projNo);
			logger.info("size() = " + result.size());
		} catch(Exception e) {
			logger.error(e.toString());
			result = new ArrayList<Map<String,Object>>();
		}
		return result;
	}
	
	
	/////////////////RESTController���� ����ϴ� DAO �޼ҵ�� //////////////////////////////
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
	
	public List<Map<String, Object>> getJsonProjMemberList(int projNo) {
		logger.info("getJsonProjMemberList()");
		List<Map<String, Object>> result = null;
		try {
			result = sqlSessionTemplate.selectList("mybatis-mapper.planMapper.getJsonProjMemberList",projNo);
			logger.info("size() = " + result.size());
		} catch(Exception e) {
			logger.error(e.toString());
			result = new ArrayList<Map<String,Object>>();
		}
		return result;
	}
	
	public List<Map<String, Object>> getJsonNotProjMemberList(int projNo) {
		logger.info("getJsonNotProjMemberList()");
		List<Map<String, Object>> result = null;
		try {
			result = sqlSessionTemplate.selectList("mybatis-mapper.planMapper.getJsonNotProjMemberList",projNo);
			logger.info("size() = " + result.size());
		} catch(Exception e) {
			logger.error(e.toString());
			result = new ArrayList<Map<String,Object>>();
		}
		return result;
	}

	public int insertProjBoard(Map<String, Object> pMap) {
		logger.info("insertProjBoard() : " + pMap);
		int result = 0;
		try {
			result = sqlSessionTemplate.update("mybatis-mapper.planMapper.insertProjBoard",pMap);
			logger.info("insertProjBoard() result = " + result);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	public int deleteProjBoard(Map<String, Object> pMap) {
		logger.info("deleteProjBoard() : " + pMap);
		int result = 0;
		try {
			result = sqlSessionTemplate.update("mybatis-mapper.planMapper.deleteProjBoard",pMap);
			logger.info("deleteProjBoard() result = " + result);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	public int updateProjBoard(Map<String, Object> pMap) {
		logger.info("updateProjBoard() : " + pMap);
		int result = 0;
		try {
			result = sqlSessionTemplate.update("mybatis-mapper.planMapper.updateProjBoard",pMap);
			logger.info("updateProjBoard() result = " + result);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	public List<Map<String, Object>> getArticleList(Map<String, Object> pMap) {
		logger.info("getArticleList() ȣ��");
		List<Map<String, Object>> articleList = null;	
		
		try {
			articleList = sqlSessionTemplate.selectList(
					"mybatis-mapper.planMapper.getArticleList", pMap);
			logger.info("����Ʈ �� : " + articleList.size());
		} catch(Exception e) {
			logger.error(e.toString());
			articleList = new ArrayList<Map<String,Object>>();
		}
		return articleList;
	}

	public int getNumOfArticlePage(Map<String, Object> pMap) {
		logger.info("getNumOfArticlePage() ȣ��");
		int result = 0;
		try {
			result = sqlSessionTemplate.selectOne("mybatis-mapper.planMapper.getNumOfArticlePage",pMap);
			logger.info("������ �� : " + result);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	public String getBoardName(Map<String, Object> pMap) {
		logger.info("getBoardName() ȣ��");
		String result = "";
		try {
			result = sqlSessionTemplate.selectOne("mybatis-mapper.planMapper.getBoardName",pMap);
			logger.info("�Խ��� �� : " + result);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	public int insertArticle(Map<String, Object> pMap) {
		logger.info("insertArticle()");
		int result = 0;
		try {
			result = sqlSessionTemplate.insert("mybatis-mapper.planMapper.insertArticle", pMap);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	public int hitArticle(int articleNo) {
		logger.info("hitArticle()");
		int result = 0;
		try {
			result = sqlSessionTemplate.update("mybatis-mapper.planMapper.hitArticle", articleNo);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	public Map<String, Object> getArticleDetail(int articleNo) {
		logger.info("getArticleDetail() ȣ��");
		Map<String, Object> result = null;
		try {
			result = sqlSessionTemplate.selectOne("mybatis-mapper.planMapper.getArticleDetail",articleNo);
		} catch (Exception e) {
			logger.error(e.toString());
			result = new HashMap<String,Object>();
		}
		return result;
	}

	public int deleteArticle(int articleNo) {
		logger.info("deleteArticle");
		int result = 0;
		try {
			result = sqlSessionTemplate.delete("mybatis-mapper.planMapper.deleteArticle", articleNo);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	public int updateArticle(Map<String, Object> pMap) {
		logger.info("updateArticle()");
		int result = 0;
		try {
			result = sqlSessionTemplate.update("mybatis-mapper.planMapper.updateArticle", pMap);
		} catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}
}
