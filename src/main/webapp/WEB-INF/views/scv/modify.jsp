<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
 	List<Map<String,Object>> getScvList =(List<Map<String,Object>>)request.getAttribute("getScvList");
 	String name = (String)getScvList.get(0).get("NAME");   
	String email = (String)getScvList.get(0).get("EMAIL");
	String id    = (String)getScvList.get(0).get("ID");
	String pw    = (String)getScvList.get(0).get("PW");
	String birthday  = (String)getScvList.get(0).get("BIRTHDAY");
	int gender = ((BigDecimal)getScvList.get(0).get("GENDER")).intValue();
	int email_yn = ((BigDecimal)getScvList.get(0).get("EMAIL_YN")).intValue();
	
	if(email == null) {
		email = "";
	}
	
	
%> 

<%-- 
	form정보
	action : 미정
	method : post
	-------------
	[필드명, 이름, 아이디(이름과 아이디가 다를 경우에 명시)]
	이름				: emp_name
	아이디			: emp_id
	현재 비밀번호		: emp_cur_pw
	새 비밀번호			: emp_new_pw
	새 비밀번호 확인		: emp_new_pw_check
	이메일			: emp_email
	생일				: emp_birthday
	성별				: emp_gender(남 : emp_male, 여 : emp_female)
	이메일수신			: cb_recv_email
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
	$(document).ready(function() {
		
		/* $("#f_modify").click(function(){
			$("#f_modify1")
		}); */
		
		var gender = <%=gender%>;
		var email_yn = <%=email_yn%>;
		
		if(gender == 1) 
			$("#emp_male").attr("checked","checked");
		else 
			$("#emp_female").attr("checked","checked");
		
		if(email_yn == 1)
			$("#cb_recv_email").attr("checked","checked");
		
	})
	
	function isok(){
		
		if(emp_new_pw==emp_new_pw_check)
			alert("저장되었습니다.");
		if(emp_new_pw!=emp_new_pw_check)
			alert("비번이 일치하지 않습니다.")
		if(emp_cur_pw==emp_new_pw)
			alert("현재 비번과 일치합니다.")
		if(emp_new_pw==null)
			alert("비번을 입력하지 않았습니다.")
	
	$("#f_modify").attr("action","<%= request.getContextPath() %>/scv/modify");
	$("#f_modify").submit();
	
}
	
	
	
	
	
 	
$(function() {
	$emp_id = $("#emp_id");
	$remember_id = $("#remember_id");
	
	if($emp_id.val() != "") {
		$remember_id.attr("checked","checked");
	}
})
	
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<div class="container">
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
		<!-- 본문 -->
		<div class="col-sm-10">
			<div class="well">
				<h2><strong>내 정보 수정</strong></h2>
			
				<form class="form-horizontal" method="post" id="f_modify">
					<div class="form-group">
						<label for="emp_name" class="col-sm-3 control-label">이름</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="emp_name" name="emp_name" value="<%=name %>" readonly />
						</div>
					</div>
					<div class="form-group">
						<label for="emp_id" class="col-sm-3 control-label">아이디</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="emp_id" name="emp_id" value="<%=id %>" readonly  />
						</div>
					</div>
					<div class="form-group">
						<label for="emp_cur_pw" class="col-sm-3 control-label">현재 비밀번호</label>
						<div class="col-sm-3">
							<input type="password" class="form-control" id="emp_cur_pw" name="emp_cur_pw" value="<%=pw %>"  readonly />
						</div>
					</div>
					<div class="form-group">
						<label for="emp_cur_pw" class="col-sm-3 control-label">새 비밀번호</label>
						<div class="col-sm-3">
							<input type="password" class="form-control" id="emp_new_pw" name="emp_new_pw"  required />
						</div>
					</div>
					<div class="form-group">
						<label for="emp_cur_pw" class="col-sm-3 control-label">새 비밀번호 확인</label>
						<div class="col-sm-3">
							<input type="password" class="form-control" id="emp_new_pw_check" name="emp_new_pw_check"  required />
						</div>
					</div>
	
					<div class="form-group">
						<label for="emp_email" class="col-sm-3 control-label">이메일</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="emp_email" name="emp_email" placeholder="xxxx@xxxxx.xxx" value="<%=email %>" required />
						</div>
					</div>
					<div class="form-group">
						<label for="emp_birthday" class="control-label col-sm-3">생일</label>
						<div class="col-sm-3">
							<input type="text" class="form-control form_datetime" id="emp_birthday" name="emp_birthday" value="<%=birthday %>" readonly>
						</div>
					</div>
					<div class="form-group">
						<label for="d_gender" class="col-sm-3 control-label" >성별</label>
						<div id="d_gender" class="col-sm-3">
							<label class="radio-inline control-label"> 
							  <input type="radio" id="emp_male" name="emp_gender" value="1">남
							</label> 
							<label class="radio-inline control-label"> 
							<input type="radio" id="emp_female" name="emp_gender" value="0">여
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="cb_recv_email" class="col-sm-3 control-label">전자결재 이메일 수신</label>
						<div class="col-sm-3">
							<div class="checkbox">
								<input type="checkbox" id="cb_recv_email" name="cb_recv_email" value="1" style="margin-left: 0px;">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-3" onclick="javascript:isok()">
							<button class="btn btn-primary">수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>
