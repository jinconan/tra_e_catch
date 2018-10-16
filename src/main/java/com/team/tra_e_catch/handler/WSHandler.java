package com.team.tra_e_catch.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionException;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * �� ������ ���� �������� ���� ��û�� ó���ϴ� �ڵ鷯
 */
public class WSHandler extends TextWebSocketHandler{
	private Logger logger = Logger.getLogger(WSHandler.class);
	 
	//������ ����� ��� map ��ü
	private Map<String,WebSocketSession> onlineEmp; 
	public void setOnlineEmp(Map<String,WebSocketSession> onlineEmp) {
		this.onlineEmp=onlineEmp;
	}
	
	//DB �۾��� �����ϱ� ���� SqlSession
	private SqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	/**
	 * ������ ����Ǿ����� ȣ��Ǵ� �޼ҵ�
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sendOpenMsg(session);
		sendDlogMsg(session);
	}
	
	/**
	 * ���Ͽ��� ������ �޽����� ó���ϴ� �޼ҵ�
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//���Ͽ��� ���� json �����͸� Map���� ��ȯ
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> jsonMap = mapper.readValue(message.getPayload(),new TypeReference<Map<String,Object>>() {});
		logger.info(jsonMap);
		
		String mtype = (String)jsonMap.get("mtype"); //������ ���� �޽��� ó���� ���� �޽���Ÿ���� get.
		
		//���Ͽ� ���� ����޽��� �ʱ�ȭ.
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String jsonResult = null;
		
		///////�޽��� Ÿ�Կ� ���� ���� ó��///////
		
		//ä�ó��� ��û (���������׸� ����)
		if("clog".equals(mtype)) {
			sendClogMsg(session, jsonMap);
		}
		
		//ä�� ����(�������, �޴»��)
		else if("chat".equals(mtype)) {
			sendChatMsg(session, jsonMap);
		}
		
		else if("dlog".equals(mtype)) {
			sendDlogMsg(session);
		}
		
		//�߸��� �޽���Ÿ��(���������)
		else {
			resultMap.put("mtype", "error");
			resultMap.put("errmsg", "�������� �޽����� ó���ϴµ� �����߽��ϴ�.");
			jsonResult = mapper.writeValueAsString(resultMap);
			session.sendMessage(new TextMessage(jsonResult));
		}
	}
	
	/**
	 * ���Ͽ��� ������ �����Ҷ� ȣ��Ǵ� �޼ҵ�.
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sendCloseMsg(session);
	}
	
	/**
	 * ���Ӹ޽����� �����Ѵ�.
	 * @param session
	 * @throws Exception
	 */
	private void sendOpenMsg(WebSocketSession session) throws Exception {
		Map<String,Object> sessionAttr = session.getAttributes(); //���ǿ� ����ִ� ��Ʈ����Ʈ
		Map<String,Object> resultMap = new HashMap<String,Object>(); //�������� ���� Map��ü
		
		//DB��ȸ�ؼ� �������� ��ȣ, �̸�, ��å, �μ� ������.
		resultMap.put("mtype", "open_other"); //�޽��� Ÿ��.
		resultMap.put("emp_no", sessionAttr.get("emp_no"));
		resultMap.put("emp_name", sessionAttr.get("emp_name"));
		resultMap.put("emp_level", sessionAttr.get("emp_level"));
		resultMap.put("emp_dept", sessionAttr.get("emp_dept"));
		
		//resultMap�� json ���ڿ��� ��ȯ.
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(resultMap);
		
		//�̹� ����� ���ϵ鿡�� ���� ������ ����� ���� ����.
		Iterator<String> iter = onlineEmp.keySet().iterator();
		while(iter.hasNext()) {
			WebSocketSession empSession = onlineEmp.get(iter.next());
			empSession.sendMessage(new TextMessage(jsonResult));
		}
		
		//�������� ����� ���� �� db���� �� ����鿡 ���� ������ ����Ʈ�� ��� json���ڿ��� �����Ѵ�.
		resultMap.put("mtype", "open_self");
		if(onlineEmp.size()!=0) {
			List<Map<String,Object>> onlineList = sqlSessionTemplate.selectList("getOnlineList",onlineEmp);
			resultMap.put("onlineList", onlineList);
		}
		jsonResult = mapper.writeValueAsString(resultMap);
		
		//���� ������ ������� �޽����� �����Ѵ�.
		session.sendMessage(new TextMessage(jsonResult));
		
		//�޽��� ���� �� �����ڸ���Ʈ�� �����ڸ� �߰��Ѵ�.
		String emp_no = sessionAttr.get("emp_no").toString();
		onlineEmp.put(emp_no, session);
		logger.info("������ ����Ʈ : " + onlineEmp);
	}
	
	
	/**
	 * ä�ó����� �����Ѵ�
	 * @param session
	 * @param jsonMap
	 * @throws Exception
	 */
	private void sendClogMsg(WebSocketSession session, Map<String ,Object> jsonMap) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		logger.info(jsonMap);
		
		String mtype = (String)jsonMap.get("mtype"); //������ ���� �޽��� ó���� ���� �޽���Ÿ���� get.
		
		//���Ͽ� ���� ����޽��� �ʱ�ȭ.
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String jsonResult = null;
		
		int from =  (Integer)jsonMap.get("from"); //�۽����� ��ȣ
		int to =  (Integer)jsonMap.get("to"); //�������� ��ȣ
		
		//DB���� ListŸ������ ä�� ������ ����
		List<Map<String,Object>> logs = sqlSessionTemplate.selectList("getChatlog", jsonMap);
		
		//TextMessage�ν��Ͻ�ȭ
		resultMap.put("mtype", mtype);
		resultMap.put("from", from);
		resultMap.put("to", to);
		resultMap.put("logs", logs);
		jsonResult = mapper.writeValueAsString(resultMap);
		session.sendMessage(new TextMessage(jsonResult));
	}
	
	
	/**
	 * ä�ø޽����� �����Ѵ�.
	 * @param session
	 * @param jsonMap
	 * @throws Exception
	 */
	private void sendChatMsg(WebSocketSession session, Map<String ,Object> jsonMap) throws Exception {
		//���Ͽ��� ���� json �����͸� Map���� ��ȯ
		ObjectMapper mapper = new ObjectMapper();
		logger.info(jsonMap);
		
		String mtype = (String)jsonMap.get("mtype"); //������ ���� �޽��� ó���� ���� �޽���Ÿ���� get.
		
		//���Ͽ� ���� ����޽��� �ʱ�ȭ.
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String jsonResult = null;
		
		String curTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		int from =  (Integer)jsonMap.get("from"); //�۽��� ��ȣ
		int to =  (Integer)jsonMap.get("to"); //������ ��ȣ
		
		//DB�� ä���� ����.
		int result = sqlSessionTemplate.insert("insertChatlog", jsonMap);
		
		//insert���н� �۽��ڿ��� ���� �޽��� ����
		if(result == 0) {
			resultMap.put("mtype", "error");
			resultMap.put("errmsg", "�������� �޽����� ó���ϴµ� �����߽��ϴ�.");
			jsonResult = mapper.writeValueAsString(resultMap);
			session.sendMessage(new TextMessage(jsonResult));
		}
		//������ �������� �޽��� ����.
		else {
			resultMap.put("mtype", mtype);
			resultMap.put("from", from);
			resultMap.put("to", to);
			resultMap.put("content", jsonMap.get("content"));
			resultMap.put("timestamp", curTime);
			jsonResult = mapper.writeValueAsString(resultMap);
			
			//�۽����� ������ ������ �߿��� ã�Ƴ�.
			WebSocketSession recvSocket = onlineEmp.get(Integer.toString(from));
			if(recvSocket != null)
				recvSocket.sendMessage(new TextMessage(jsonResult));
			
			//�������� ������ ������ �߿��� ã�Ƴ�.
			recvSocket = onlineEmp.get(Integer.toString(to));
			if(recvSocket != null)
				recvSocket.sendMessage(new TextMessage(jsonResult));
		}
	}
	
	/**
	 * ��ȼ� ������ �����Ѵ�.
	 * @param session
	 * @throws Exception
	 */
	private void sendDlogMsg(WebSocketSession session) throws Exception  {
		Map<String,Object> sessionAttr = session.getAttributes();
		//��� ���� ��������
		int todayChecked = 0;
		int notCheck = 0;
		int totalAlarm = 0;
		Map<String ,Object> pMap = new HashMap<String, Object>();
		pMap.put("eno", sessionAttr.get("emp_no"));
		try {
			todayChecked = sqlSessionTemplate.selectOne("getTotalTodayCheckedDraft", pMap);
		} catch(SqlSessionException e) {
			logger.error(e.toString());
		}
		
		try {
			notCheck = sqlSessionTemplate.selectOne("getTotalEpayWaitList", pMap);
		} catch(SqlSessionException e) {
			logger.error(e.toString());
		}
		try {
			totalAlarm = sqlSessionTemplate.selectOne("getTotalAlarmCount", pMap);
		} catch(SqlSessionException e) {
			logger.error(e.toString());
		}
		Map<String ,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("mtype", "dlog");
		resultMap.put("todayChecked", todayChecked);
		resultMap.put("notCheck", notCheck);
		resultMap.put("totalAlarm", totalAlarm);
		logger.info(resultMap);
		session.sendMessage(new TextMessage( new ObjectMapper().writeValueAsString(resultMap)));
	}
	
	
	/**
	 * ���� ���Ḧ �ٸ� ����鿡�� �����Ѵ�.
	 * @param session
	 * @throws Exception
	 */
	private void sendCloseMsg(WebSocketSession session) throws Exception{
		//���� ����� ������ ����Ʈ���� �����Ѵ�.
		Map<String,Object> sessionAttr = session.getAttributes();
		String emp_no = sessionAttr.get("emp_no").toString();
		onlineEmp.remove(emp_no);
		
		//�޽��� �����
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("mtype", "close");
		resultMap.put("emp_no", sessionAttr.get("emp_no"));
		String jsonResult = new ObjectMapper().writeValueAsString(resultMap);
		
		//���� ���� ���� ����鿡�� �ش� ����� �������� �˸��� �޽����� �����Ѵ�.
		Iterator<String> iter = onlineEmp.keySet().iterator();
		while(iter.hasNext()) {
			WebSocketSession empSession = onlineEmp.get(iter.next());
			empSession.sendMessage(new TextMessage(jsonResult));
		}
		logger.info(session.getRemoteAddress() + "���� ����");
	}
}
