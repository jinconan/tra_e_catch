package com.team.tra_e_catch.payment;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.team.tra_e_catch.accounting.Acc_VO;

@Service
public class PaymentLogic {
	private final Logger logger = Logger.getLogger(PaymentLogic.class);
	
	@Autowired
	private SqlPayDao sqlPayDao = null;
	
	/**
	 * 기안 등록
	 * @param pMap
	 * @return
	 */
	public int insertEpay(Map<String, Object> pMap) {
		logger.info("insertEpay() " + pMap);
		int result = 0;
		
		/*
		 *     <table border="1">
			        <thead>
			            <tr>
			                <th>종류</th><th>시작일</th><th>종료일</th>
			            </tr>
			        </thead>
			        <tbody>
			            <tr>
			                <td>연차</td><td>2018-10-24</td><td>2018-10-31</td>
			            </tr>
			        </tbody>
			    </table>
		 * 
		 * 
		 * 
		 */
		if("휴가".equals(pMap.get("dtname"))) {
			StringBuilder annuString = new StringBuilder();
			annuString.append("<table class='table' border='1'>");
			annuString.append("<thead>");
			annuString.append("<tr>");
            annuString.append("<th>종류</th><th>시작일</th><th>종료일</th>");
            annuString.append("</tr>");
            annuString.append("<tbody>");
            annuString.append("<tr>");
            annuString.append("<td>"+pMap.get("annuType")+"</td><td>"+pMap.get("fdate")+"</td><td>"+pMap.get("tdate")+"</td>");
            annuString.append("</tr>");
            annuString.append("</tbody>");
			annuString.append("</table>");
			StringBuilder newContent = new StringBuilder(annuString+(String)pMap.get("content"));
			pMap.put("content", newContent.toString());
		}
		
		int resultOfEpay = sqlPayDao.insertEpay(pMap);
		if(resultOfEpay == 0)
			throw new RuntimeException();
		else {
			result = sqlPayDao.insertSign(pMap);
			if(result == 0)
				throw new RuntimeException();
		}
		return result;
	}
	/**
	 * 결재 대기 목록 
	 * @param pMap
	 * @return
	 */
	public Map<String, Object> getEpayWaitList(Map<String, Object> pMap) {
		logger.info("getEpayWaitList 호출성공");
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		List<Map<String,Object>> epaywaitList = null; 
		epaywaitList = sqlPayDao.getEpayWaitList(pMap);
		int total = sqlPayDao.getTotalEpayWaitList(pMap);
		rMap.put("total", total);
		rMap.put("rows", epaywaitList);
		return rMap;
	}
	/**
	 * 기안에 대한 승인 또는 거부
	 * @param pMap
	 * @return
	 */
	public int updateEpay(Map<String, Object> pMap) {
		logger.info("getEpayupdate 호출성공");
		int signDno = Integer.parseInt((String)pMap.get("signDno"));
		int signVal = Integer.parseInt((String)pMap.get("signVal"));
		int result = 0;
		result = sqlPayDao.updateEpay(pMap); //결재 처리
		
		//만약 휴가에 대한 결재처리인 경우
		pMap = new HashMap<String, Object>();
		pMap.put("annuDno", signDno);
		List<Map<String, Object>> annuDoc = sqlPayDao.getPaymentList(pMap);
		if(signVal == 2 && annuDoc != null && annuDoc.size() == 1) {
			if("휴가".equals(annuDoc.get(0).get("DNAME"))) {
				String content = (String)annuDoc.get(0).get("CONTENT");
				BigDecimal eno = (BigDecimal)annuDoc.get(0).get("ENO");
				pMap.put("eno", eno.intValue());
				Pattern p = Pattern.compile("<td>([가-휴]{2,4}|[0-9]{4}-[0-9]{2}-[0-9]{2})</td>");
				Pattern p2 = Pattern.compile("([가-휴]{2,4}|[0-9]{4}-[0-9]{2}-[0-9]{2})");
	
				Matcher m = p.matcher(content);
				m.find();
				Matcher m2 = p2.matcher(m.group());
				m2.find();
				pMap.put("aname", m2.group());
				
				m.find();
				m2 = p2.matcher(m.group());
				m2.find();
				pMap.put("fdate", m2.group());
				
				
				
				if("연차".equals(pMap.get("aname"))) {
					m.find();
					m2 = p2.matcher(m.group());
					m2.find();
					pMap.put("tdate", m2.group());
				} else {
					pMap.put("tdate", "1900-01-01");
				}
				
				result = sqlPayDao.insertAnnu(pMap);
			}
		}
		
		
		return result;
	}
	/**
	 * 결재 완료 리스트
	 * @param pMap
	 * @return
	 */
	public Map<String, Object> getEpayEnd(Map<String, Object> pMap) {
        logger.info("getEpayEnd 호출성공");
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		List<Map<String,Object>> epayend = null; 
		epayend = sqlPayDao.getEpayEnd(pMap);
		int total = sqlPayDao.getTotalEpayEndList(pMap);
		rMap.put("total", total);
		rMap.put("rows", epayend);
		return rMap;
	}

	/**
	 * 기안 목록 리스트
	 * @param pMap
	 * @return
	 */
	public Map<String, Object> getPaymentList(Map<String, Object> pMap) {
		logger.info("getPaymentList " + pMap);
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> rows = sqlPayDao.getPaymentList(pMap);
		int total = sqlPayDao.getTotalPayment(pMap);
		
		rMap.put("total",  total);
		rMap.put("rows", rows);
		return rMap;
	}

	/**
	 * 같은 팀 내에서 사원번호가 eno인 사원보다 윗 선인 사원들의 리스트
	 * @param eno
	 * @return
	 */
	public List<Map<String, Object>> getUpperTeamMemberList(int eno) {
		logger.info("getUpperTeamMemberList " + eno);
		List<Map<String, Object>> upperTeamMemberList = sqlPayDao.getUpperTeamMemberList(eno);
		return upperTeamMemberList;
	}

	/**
	 * 사원의 알람 날짜를 갱신한다.
	 * @param eno
	 * @return
	 */
	public int updateAlarmDate(int eno) {
		logger.info("updateAlarmDate " + eno);
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("eno",  eno);
		int result = sqlPayDao.updateAlarmDate(pMap);
		return result;
	}
	
	/**
	 * 기안목록 차트 데이터
	 * @param eno
	 * @return
	 */
	public List<Map<String, Object>> getDraftChart(int eno) {
		logger.info("getDraftChart : " + eno);
		return sqlPayDao.getDraftChart(eno);
	}

}
