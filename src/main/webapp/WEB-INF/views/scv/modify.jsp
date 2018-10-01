<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


 <%
	String emp_id = null;
 	String emp_pw = null;
 	String emp_new_pw =null;
 	String emp_new_pw_check =null;
 	String emp_email =null;
	try {
		emp_id = (String)request.getAttribute("emp_id");
	}catch(Exception e) {
		emp_id = "";
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
	새 비밀번호		: emp_new_pw
	새 비밀번호 확인	: emp_new_pw_check
	이메일			: emp_email
	생일				: emp_birthday
	성별				: emp_gender(남 : emp_male, 여 : emp_female)
	이메일수신		: cb_recv_email
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
	$(document).ready(function() {
		$(".form_datetime").datetimepicker({
			format : 'yyyy-mm-dd',
			minView : 2
		});
		$("#f_modify").click(function(){
			$("#f_modify1")
			
		});
	})
	function isok(){
/* 	alert("저장되었습니다."); */
	
	//alert($("#e_list option:selected").val());
	
	$("#f_modify").attr("action","<%= request.getContextPath() %>/scv/modify");
	$("#f_modify").submit(); 
}
	
 /* $(function() {
	$emp_pw = $("#emp_pw");
	$emp_cur_pw = $("#emp_cur_pw");
	$emp_new_pw = $("#emp_new_pw");
	$emp_new_pw_check = $("#emp_new_pw_check");
	
	if($emp_pw.val() != "") {
		$emp_pw.attr("checked","checked");
	}
})	  */
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
			
				<form class="form-horizontal" method="post" >
					<div class="form-group">
						<label for="emp_name" class="col-sm-3 control-label">이름</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="emp_name" name="emp_name" readonly required />
						</div>
					</div>
					<div class="form-group">
						<label for="emp_id" class="col-sm-3 control-label">아이디</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="emp_id" name="emp_id" readonly required />
						</div>
					</div>
					<div class="form-group">
						<label for="emp_cur_pw" class="col-sm-3 control-label">현재 비밀번호</label>
						<div class="col-sm-3">
							<input type="password" class="form-control" id="emp_cur_pw" name="emp_cur_pw" value="<%=emp_pw%>" required />
						</div>
					</div>
					<div class="form-group">
						<label for="emp_cur_pw" class="col-sm-3 control-label">새 비밀번호</label>
						<div class="col-sm-3">
							<input type="password" class="form-control" id="emp_new_pw" name="emp_new_pw" value="<%=emp_new_pw%>" required />
						</div>
					</div>
					<div class="form-group">
						<label for="emp_cur_pw" class="col-sm-3 control-label">새 비밀번호 확인</label>
						<div class="col-sm-3">
							<input type="password" class="form-control" id="emp_new_pw_check" name="emp_new_pw_check" value="<%=emp_new_pw_check%>" required />
						</div>
					</div>
	
					<div class="form-group">
						<label for="emp_email" class="col-sm-3 control-label">이메일</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="emp_email" name="emp_email" placeholder="xxxx@xxxXX.xxx" value="<%=emp_email%>" required />
						</div>
					</div>
					<div class="form-group">
						<label for="emp_birthday" class="control-label col-sm-3">생일</label>
						<div class="col-sm-3">
							<input type="text" class="form-control form_datetime" id="emp_birthday" name="emp_birthday" readonly>
						</div>
					</div>
					<div class="form-group">
						<label for="d_gender" class="col-sm-3 control-label">성별</label>
						<div id="d_gender" class="col-sm-3">
							<label class="radio-inline control-label"> <input type="radio" id="emp_male" name="emp_gender" value="남" checked>남
							</label> <label class="radio-inline control-label"> <input type="radio" id="emp_female" name="emp_gender" value="여">여
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
						<div class="col-sm-offset-3 col-sm-3" onclick=javascript:isok()>
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
