package com.team.tra_e_catch.personnel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class PersonnelLogic {
	Logger logger = Logger.getLogger(PersonnelLogic.class);
	private SqlMapAttdDao sqlMapAttdDao = null;
	public List<Map<String, Object>> getAttdList(Map<String, Object> pMap, HttpServletResponse res) {
		// TODO Auto-generated method stub
		logger.info("getAttdList 호출 성공");
		List<Map<String,Object>> attdList = null;
		attdList = sqlMapAttdDao.getAttdList(pMap);
		return attdList;
	}

}
