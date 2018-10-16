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
 * 웹 소켓을 통해 브라우저가 보낸 요청을 처리하는 핸들러
 */
public class WSHandler extends TextWebSocketHandler{
	private Logger logger = Logger.getLogger(WSHandler.class);
	 
	//접속한 사원을 담는 map 객체
	private Map<String,WebSocketSession> onlineEmp; 
	public void setOnlineEmp(Map<String,WebSocketSession> onlineEmp) {
		this.onlineEmp=onlineEmp;
	}
	
	//DB 작업을 수행하기 위한 SqlSession
	private SqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	/**
	 * 소켓이 연결되었을때 호출되는 메소드
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sendOpenMsg(session);
		sendDlogMsg(session);
	}
	
	/**
	 * 소켓에서 전송한 메시지를 처리하는 메소드
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//소켓에서 받은 json 데이터를 Map으로 변환
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> jsonMap = mapper.readValue(message.getPayload(),new TypeReference<Map<String,Object>>() {});
		logger.info(jsonMap);
		
		String mtype = (String)jsonMap.get("mtype"); //종류에 따른 메시지 처리를 위해 메시지타입을 get.
		
		//소켓에 보낼 응답메시지 초기화.
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String jsonResult = null;
		
		///////메시지 타입에 따른 로직 처리///////
		
		//채팅내역 요청 (보낸놈한테만 답장)
		if("clog".equals(mtype)) {
			sendClogMsg(session, jsonMap);
		}
		
		//채팅 전송(보낸사람, 받는사람)
		else if("chat".equals(mtype)) {
			sendChatMsg(session, jsonMap);
		}
		
		else if("dlog".equals(mtype)) {
			sendDlogMsg(session);
		}
		
		//잘못된 메시지타입(보낸사람만)
		else {
			resultMap.put("mtype", "error");
			resultMap.put("errmsg", "서버에서 메시지를 처리하는데 실패했습니다.");
			jsonResult = mapper.writeValueAsString(resultMap);
			session.sendMessage(new TextMessage(jsonResult));
		}
	}
	
	/**
	 * 소켓에서 연결을 해제할때 호출되는 메소드.
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sendCloseMsg(session);
	}
	
	/**
	 * 접속메시지를 전달한다.
	 * @param session
	 * @throws Exception
	 */
	private void sendOpenMsg(WebSocketSession session) throws Exception {
		Map<String,Object> sessionAttr = session.getAttributes(); //세션에 담겨있는 어트리뷰트
		Map<String,Object> resultMap = new HashMap<String,Object>(); //브라우저로 보낼 Map객체
		
		//DB조회해서 접속자의 번호, 이름, 직책, 부서 가져옴.
		resultMap.put("mtype", "open_other"); //메시지 타입.
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
	
	
	/**
	 * 채팅내역을 전달한다
	 * @param session
	 * @param jsonMap
	 * @throws Exception
	 */
	private void sendClogMsg(WebSocketSession session, Map<String ,Object> jsonMap) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		logger.info(jsonMap);
		
		String mtype = (String)jsonMap.get("mtype"); //종류에 따른 메시지 처리를 위해 메시지타입을 get.
		
		//소켓에 보낼 응답메시지 초기화.
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String jsonResult = null;
		
		int from =  (Integer)jsonMap.get("from"); //송신자의 번호
		int to =  (Integer)jsonMap.get("to"); //수신자의 번호
		
		//DB에서 List타입으로 채팅 내역을 얻음
		List<Map<String,Object>> logs = sqlSessionTemplate.selectList("getChatlog", jsonMap);
		
		//TextMessage인스턴스화
		resultMap.put("mtype", mtype);
		resultMap.put("from", from);
		resultMap.put("to", to);
		resultMap.put("logs", logs);
		jsonResult = mapper.writeValueAsString(resultMap);
		session.sendMessage(new TextMessage(jsonResult));
	}
	
	
	/**
	 * 채팅메시지를 전달한다.
	 * @param session
	 * @param jsonMap
	 * @throws Exception
	 */
	private void sendChatMsg(WebSocketSession session, Map<String ,Object> jsonMap) throws Exception {
		//소켓에서 받은 json 데이터를 Map으로 변환
		ObjectMapper mapper = new ObjectMapper();
		logger.info(jsonMap);
		
		String mtype = (String)jsonMap.get("mtype"); //종류에 따른 메시지 처리를 위해 메시지타입을 get.
		
		//소켓에 보낼 응답메시지 초기화.
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String jsonResult = null;
		
		String curTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		int from =  (Integer)jsonMap.get("from"); //송신자 번호
		int to =  (Integer)jsonMap.get("to"); //수신자 번호
		
		//DB에 채팅을 저장.
		int result = sqlSessionTemplate.insert("insertChatlog", jsonMap);
		
		//insert실패시 송신자에게 에러 메시지 전송
		if(result == 0) {
			resultMap.put("mtype", "error");
			resultMap.put("errmsg", "서버에서 메시지를 처리하는데 실패했습니다.");
			jsonResult = mapper.writeValueAsString(resultMap);
			session.sendMessage(new TextMessage(jsonResult));
		}
		//성공시 양측에게 메시지 전달.
		else {
			resultMap.put("mtype", mtype);
			resultMap.put("from", from);
			resultMap.put("to", to);
			resultMap.put("content", jsonMap.get("content"));
			resultMap.put("timestamp", curTime);
			jsonResult = mapper.writeValueAsString(resultMap);
			
			//송신자의 소켓을 접속자 중에서 찾아냄.
			WebSocketSession recvSocket = onlineEmp.get(Integer.toString(from));
			if(recvSocket != null)
				recvSocket.sendMessage(new TextMessage(jsonResult));
			
			//수신자의 소켓을 접속자 중에서 찾아냄.
			recvSocket = onlineEmp.get(Integer.toString(to));
			if(recvSocket != null)
				recvSocket.sendMessage(new TextMessage(jsonResult));
		}
	}
	
	/**
	 * 기안서 갯수를 전달한다.
	 * @param session
	 * @throws Exception
	 */
	private void sendDlogMsg(WebSocketSession session) throws Exception  {
		Map<String,Object> sessionAttr = session.getAttributes();
		//기안 갯수 가져오기
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
	 * 접속 종료를 다른 사원들에게 전달한다.
	 * @param session
	 * @throws Exception
	 */
	private void sendCloseMsg(WebSocketSession session) throws Exception{
		//접속 종료시 접속자 리스트에서 제거한다.
		Map<String,Object> sessionAttr = session.getAttributes();
		String emp_no = sessionAttr.get("emp_no").toString();
		onlineEmp.remove(emp_no);
		
		//메시지 만들기
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("mtype", "close");
		resultMap.put("emp_no", sessionAttr.get("emp_no"));
		String jsonResult = new ObjectMapper().writeValueAsString(resultMap);
		
		//현재 접속 중인 사원들에게 해당 사원이 나갔음을 알리는 메시지를 전송한다.
		Iterator<String> iter = onlineEmp.keySet().iterator();
		while(iter.hasNext()) {
			WebSocketSession empSession = onlineEmp.get(iter.next());
			empSession.sendMessage(new TextMessage(jsonResult));
		}
		logger.info(session.getRemoteAddress() + "접속 종료");
	}
}
