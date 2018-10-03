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
		//접속한 사원번호에 대해서 이미 접속중인 사원들에게 알림
		//그 다음에 맵 객체에 새로 접속한 사원을 put
		Map<String,Object> sessionAttr = session.getAttributes();
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String jsonResult = null;
		if(onlineEmp.size()!=0) {
			List<Map<String,Object>> onlineList = sqlSessionTemplate.selectList("getOnlineList",onlineEmp);
			resultMap.put("onlineList", onlineList);
		}
		//DB조회해서 접속자의 번호, 이름, 아이디, 직책 가져옴.
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
		
		//다른 사람들에겐 현재 접속한 사람에 대해 알리고, 접속한 사람에게는 접속중인 사람들의 리스트를 전달한다.
		onlineEmp.put(emp_no, session);
		System.out.println(session.getId()+" 연결됨");
		System.out.println("현재 온라인 : " + onlineEmp);
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
		// TODO Auto-generated method stub
		Map<String,Object> sessionAttr = session.getAttributes();
		String emp_no = sessionAttr.get("emp_no").toString();
		onlineEmp.remove(emp_no);
		
		Iterator<String> iter = onlineEmp.keySet().iterator();
		while(iter.hasNext()) {
			WebSocketSession empSession = onlineEmp.get(iter.next());
			empSession.sendMessage(new TextMessage(emp_no+"가 퇴장했습니다"));
		}
		
		System.out.println(session.getId()+" 연결끊김");
	}
}
