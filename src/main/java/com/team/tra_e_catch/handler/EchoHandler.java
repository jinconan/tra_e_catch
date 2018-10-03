package com.team.tra_e_catch.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EchoHandler extends TextWebSocketHandler{
	private Logger logger = Logger.getLogger(EchoHandler.class);
	private Map<String,WebSocketSession> onlineEmp;
	public void setOnlineEmp(Map<String,WebSocketSession> onlineEmp) {
		this.onlineEmp=onlineEmp;
	}
	
	private SqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//������ �����ȣ�� ���ؼ� �̹� �������� ����鿡�� �˸�
		//�� ������ �� ��ü�� ���� ������ ����� put
		Map<String,Object> sessionAttr = session.getAttributes();
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String jsonResult = null;
		if(onlineEmp.size()!=0) {
			List<Map<String,Object>> onlineList = sqlSessionTemplate.selectList("getOnlineList",onlineEmp);
			resultMap.put("onlineList", onlineList);
		}
		//DB��ȸ�ؼ� �������� ��ȣ, �̸�, ���̵�, ��å ������.
		resultMap.put("mtype", "open");
		resultMap.put("emp_id", sessionAttr.get("emp_id"));
		resultMap.put("emp_name", sessionAttr.get("emp_name"));
		
		
		ObjectMapper mapper = new ObjectMapper();
		jsonResult = mapper.writeValueAsString(resultMap);
		
		String emp_no = sessionAttr.get("emp_no").toString();
		Iterator<String> iter = onlineEmp.keySet().iterator();
		while(iter.hasNext()) {
			WebSocketSession empSession = onlineEmp.get(iter.next());
			empSession.sendMessage(new TextMessage(jsonResult));
		}
		
		//�ٸ� ����鿡�� ���� ������ ����� ���� �˸���, ������ ������Դ� �������� ������� ����Ʈ�� �����Ѵ�.
		onlineEmp.put(emp_no, session);
		System.out.println(session.getId()+" �����");
		System.out.println("���� �¶��� : " + onlineEmp);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//���Ͽ��� ���� json �����͸� Map���� ��ȯ
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> jsonMap = mapper.readValue(message.getPayload(),new TypeReference<Map<String,Object>>() {});
		System.out.println(jsonMap);
		
		String mtype = (String)jsonMap.get("mtype"); //�޽��� Ÿ��
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String jsonResult = null;
		//�޽��� Ÿ�Կ� ���� ���� ó��
		
		//ä�ó��� ��û (���������׸� ����)
		if("clog".equals(mtype)) {
			int from =  (Integer)jsonMap.get("from");
			int to =  (Integer)jsonMap.get("to");
			//DB���� ListŸ������ ����
			List<Map<String,Object>> logs = new ArrayList<Map<String,Object>>();
			//TextMessage�ν��Ͻ�ȭ
			resultMap.put("mtype", mtype);
			resultMap.put("from", from);
			resultMap.put("to", to);
			resultMap.put("logs", logs);
			jsonResult = mapper.writeValueAsString(resultMap);
			session.sendMessage(new TextMessage(jsonResult));
		} 
		//ä�� ����(�������, �޴»��)
		else if("chat".equals(mtype)) {
			String curTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			int from =  (Integer)jsonMap.get("from");
			int to =  (Integer)jsonMap.get("to");
			
			resultMap.put("mtype", mtype);
			resultMap.put("from", from);
			resultMap.put("to", to);
			resultMap.put("content", jsonMap.get("content"));
			resultMap.put("timestamp", curTime);
			
			jsonResult = mapper.writeValueAsString(resultMap);
			
			WebSocketSession recvSocket = onlineEmp.get(Integer.toString(from));
			if(recvSocket != null)
				recvSocket.sendMessage(new TextMessage(jsonResult));
			
			recvSocket = onlineEmp.get(Integer.toString(to));
			if(recvSocket != null)
				recvSocket.sendMessage(new TextMessage(jsonResult));
		}
		
		//�߸��� �޽���Ÿ��(���������)
		else {
			resultMap.put("mtype", "error");
			jsonResult = mapper.writeValueAsString(resultMap);
			session.sendMessage(new TextMessage(jsonResult));
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> sessionAttr = session.getAttributes();
		String emp_no = sessionAttr.get("emp_no").toString();
		onlineEmp.remove(emp_no);
		
		Iterator<String> iter = onlineEmp.keySet().iterator();
		while(iter.hasNext()) {
			WebSocketSession empSession = onlineEmp.get(iter.next());
			empSession.sendMessage(new TextMessage(emp_no+"�� �����߽��ϴ�"));
		}
		
		System.out.println(session.getId()+" �������");
	}
}
