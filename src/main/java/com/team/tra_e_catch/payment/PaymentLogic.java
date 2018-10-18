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
	 * ��� ���
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
			                <th>����</th><th>������</th><th>������</th>
			            </tr>
			        </thead>
			        <tbody>
			            <tr>
			                <td>����</td><td>2018-10-24</td><td>2018-10-31</td>
			            </tr>
			        </tbody>
			    </table>
		 * 
		 * 
		 * 
		 */
		if("�ް�".equals(pMap.get("dtname"))) {
			StringBuilder annuString = new StringBuilder();
			annuString.append("<table class='table' border='1'>");
			annuString.append("<thead>");
			annuString.append("<tr>");
            annuString.append("<th>����</th><th>������</th><th>������</th>");
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
	 * ���� ��� ��� 
	 * @param pMap
	 * @return
	 */
	public Map<String, Object> getEpayWaitList(Map<String, Object> pMap) {
		logger.info("getEpayWaitList ȣ�⼺��");
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		List<Map<String,Object>> epaywaitList = null; 
		epaywaitList = sqlPayDao.getEpayWaitList(pMap);
		int total = sqlPayDao.getTotalEpayWaitList(pMap);
		rMap.put("total", total);
		rMap.put("rows", epaywaitList);
		return rMap;
	}
	/**
	 * ��ȿ� ���� ���� �Ǵ� �ź�
	 * @param pMap
	 * @return
	 */
	public int updateEpay(Map<String, Object> pMap) {
		logger.info("getEpayupdate ȣ�⼺��");
		int signDno = Integer.parseInt((String)pMap.get("signDno"));
		int signVal = Integer.parseInt((String)pMap.get("signVal"));
		int result = 0;
		result = sqlPayDao.updateEpay(pMap); //���� ó��
		
		//���� �ް��� ���� ����ó���� ���
		pMap = new HashMap<String, Object>();
		pMap.put("annuDno", signDno);
		List<Map<String, Object>> annuDoc = sqlPayDao.getPaymentList(pMap);
		if(signVal == 2 && annuDoc != null && annuDoc.size() == 1) {
			if("�ް�".equals(annuDoc.get(0).get("DNAME"))) {
				String content = (String)annuDoc.get(0).get("CONTENT");
				BigDecimal eno = (BigDecimal)annuDoc.get(0).get("ENO");
				pMap.put("eno", eno.intValue());
				Pattern p = Pattern.compile("<td>([��-��]{2,4}|[0-9]{4}-[0-9]{2}-[0-9]{2})</td>");
				Pattern p2 = Pattern.compile("([��-��]{2,4}|[0-9]{4}-[0-9]{2}-[0-9]{2})");
	
				Matcher m = p.matcher(content);
				m.find();
				Matcher m2 = p2.matcher(m.group());
				m2.find();
				pMap.put("aname", m2.group());
				
				m.find();
				m2 = p2.matcher(m.group());
				m2.find();
				pMap.put("fdate", m2.group());
				
				
				
				if("����".equals(pMap.get("aname"))) {
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
	 * ���� �Ϸ� ����Ʈ
	 * @param pMap
	 * @return
	 */
	public Map<String, Object> getEpayEnd(Map<String, Object> pMap) {
        logger.info("getEpayEnd ȣ�⼺��");
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		List<Map<String,Object>> epayend = null; 
		epayend = sqlPayDao.getEpayEnd(pMap);
		int total = sqlPayDao.getTotalEpayEndList(pMap);
		rMap.put("total", total);
		rMap.put("rows", epayend);
		return rMap;
	}

	/**
	 * ��� ��� ����Ʈ
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
	 * ���� �� ������ �����ȣ�� eno�� ������� �� ���� ������� ����Ʈ
	 * @param eno
	 * @return
	 */
	public List<Map<String, Object>> getUpperTeamMemberList(int eno) {
		logger.info("getUpperTeamMemberList " + eno);
		List<Map<String, Object>> upperTeamMemberList = sqlPayDao.getUpperTeamMemberList(eno);
		return upperTeamMemberList;
	}

	/**
	 * ����� �˶� ��¥�� �����Ѵ�.
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
	 * ��ȸ�� ��Ʈ ������
	 * @param eno
	 * @return
	 */
	public List<Map<String, Object>> getDraftChart(int eno) {
		logger.info("getDraftChart : " + eno);
		return sqlPayDao.getDraftChart(eno);
	}

}
