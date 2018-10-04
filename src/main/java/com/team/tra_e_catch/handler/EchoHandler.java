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
		logger.info(session.getRemoteAddress()+" 접속");
		
		Map<String,Object> sessionAttr = session.getAttributes();
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//DB조회해서 접속자의 번호, 이름, 직책, 부서 가져옴.
		resultMap.put("mtype", "open_other");
		resultMap.put("emp_no", sessionAttr.get("emp_no"));
		resultMap.put("emp_name", sessionAttr.get("emp_name"));
		resultMap.put("emp_level", sessionAttr.get("emp_level"));
		resultMap.put("emp_dept", sessionAttr.get("emp_dept"));
		
		//resultMap을 json 문자열로 변환.
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(resultMap);
		
		//이미 연결된 소켓들에게 새로 접속한 사람에 대해 전송.
		Iterator<String> iter = onlineEmp.keySet().iterator();
		while(iter.hasNext()) {
			WebSocketSession empSession = onlineEmp.get(iter.next());
			empSession.sendMessage(new TextMessage(jsonResult));
		}
		
		//접속중인 사람이 있을 때 db에서 그 사람들에 대한 정보를 리스트로 얻고 json문자열을 갱신한다.
		resultMap.put("mtype", "open_self");
		if(onlineEmp.size()!=0) {
			List<Map<String,Object>> onlineList = sqlSessionTemplate.selectList("getOnlineList",onlineEmp);
			resultMap.put("onlineList", onlineList);
			
		}
		jsonResult = mapper.writeValueAsString(resultMap);
		//현재 접속한 사람에게 메시지를 전달한다.
		session.sendMessage(new TextMessage(jsonResult));
		
		//메시지 전달 후 접속자리스트에 접속자를 추가한다.
		String emp_no = sessionAttr.get("emp_no").toString();
		onlineEmp.put(emp_no, session);
		logger.info("접속자 리스트 : " + onlineEmp);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//소켓에서 받은 json 데이터를 Map으로 변환
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> jsonMap = mapper.readValue(message.getPayload(),new TypeReference<Map<String,Object>>() {});
		System.out.println(jsonMap);
		
		String mtype = (String)jsonMap.get("mtype"); //메시지 타입
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String jsonResult = null;
		//메시지 타입에 따른 로직 처리
		
		//채팅내역 요청 (보낸놈한테만 답장)
		if("clog".equals(mtype)) {
			int from =  (Integer)jsonMap.get("from");
			int to =  (Integer)jsonMap.get("to");
			//DB에서 List타입으로 얻음
			List<Map<String,Object>> logs = new ArrayList<Map<String,Object>>();
			//TextMessage인스턴스화
			resultMap.put("mtype", mtype);
			resultMap.put("from", from);
			resultMap.put("to", to);
			resultMap.put("logs", logs);
			jsonResult = mapper.writeValueAsString(resultMap);
			session.sendMessage(new TextMessage(jsonResult));
		} 
		//채팅 전송(보낸사람, 받는사람)
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
		
		//잘못된 메시지타입(보낸사람만)
		else {
			resultMap.put("mtype", "error");
			jsonResult = mapper.writeValueAsString(resultMap);
			session.sendMessage(new TextMessage(jsonResult));
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//접속 종료시 접속자 리스트에서 제거한다.
		Map<String,Object> sessionAttr = session.getAttributes();
		String emp_no = sessionAttr.get("emp_no").toString();
		onlineEmp.remove(emp_no);
		
		//메시지 만들기
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("mtype", "close");
		resultMap.put("emp_no", sessionAttr.get("emp_no"));
		String jsonResult = new ObjectMapper().writeValueAsString(resultMap);
		//메시지 전송
		Iterator<String> iter = onlineEmp.keySet().iterator();
		while(iter.hasNext()) {
			WebSocketSession empSession = onlineEmp.get(iter.next());
			empSession.sendMessage(new TextMessage(jsonResult));
		}
		logger.info(session.getRemoteAddress() + "접속 종료");
	}
}
