<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
 	List<Map<String,Object>> getScvList =(List<Map<String,Object>>)request.getAttribute("getScvList");
 	String name = (String)getScvList.get(0).get("NAME");   
	String email = (String)getScvList.get(0).get("EMAIL");
	String id    = (String)getScvList.get(0).get("ID");
	String birthday    = (String)getScvList.get(0).get("BIRTHDAY");
	int gender = ((BigDecimal)getScvList.get(0).get("GENDER")).intValue();
	
	if(email == null) {
		email = "";
	}
	
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치-내 정보 수정</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
function isok(){
	//정보를 변경하고 싶으면 현재비번은 무조건 입력하는 것으로...
	var $emp_cur_pw = $("#emp_cur_pw").val();
	if($emp_cur_pw != "") {
		$.ajax({
			url:"<%=request.getContextPath()%>/scv/checkCurPw"
			,data:"emp_cur_pw="+$("#emp_cur_pw").val()
			,method:"post"
			,success:function(data) {
				if(data.result == 1) {
					//현재 비밀번호 일치
					var $newPw = $("#emp_new_pw").val();
					var $newPwCheck = $("#emp_new_pw_check").val();
					
					if($newPw != $newPwCheck) {
						alert("새 비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
						return false;
					}
					else {
						var params = null;
						if($newPw == "") {
							params = "emp_email="+$("#emp_email").val();
						} else {
							params = "emp_email="+$("#emp_email").val()+"&emp_new_pw="+$newPw;
						}
						
						$.ajax({
							url:"<%=request.getContextPath()%>/scv/modify"
							,data:params
							,method:"post"
							,success:function(data) {
								if(data.result == 1) {
									alert("수정되었습니다.");
								} else {
									alert("수정에 실패하였습니다");
								}
								location.reload();
							}
						})
					}					
					
				}
				else {
					alert("현재 비밀번호가 올바르지 않습니다.");
					return false;
				}
			}
		})
		return false;
		
	} else {
		alert("현재 비밀번호를 입력해 주세요");
		return false;
	}
	
	//새 비밀번호와 새 비밀번호 확인 칸에 값이 들어있으면 비밀번호를 변경하길 원하는 것으로 판단.
}
	
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
							<input type="password" class="form-control" id="emp_cur_pw" name="emp_cur_pw"  />
						</div>
					</div>
					<div class="form-group">
						<label for="emp_cur_pw" class="col-sm-3 control-label">새 비밀번호</label>
						<div class="col-sm-3">
							<input type="password" class="form-control" id="emp_new_pw" name="emp_new_pw"/>
						</div>
					</div>
					<div class="form-group">
						<label for="emp_cur_pw" class="col-sm-3 control-label">새 비밀번호 확인</label>
						<div class="col-sm-3">
							<input type="password" class="form-control" id="emp_new_pw_check" name="emp_new_pw_check" />
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
					<!-- <div class="form-group">
						<label for="d_gender" class="col-sm-3 control-label" >성별</label>
						<div id="d_gender" class="col-sm-3">
							<label class="radio-inline control-label"> 
							  <input type="radio" id="emp_male" name="emp_gender" value="1">남
							</label> 
							<label class="radio-inline control-label"> 
							<input type="radio" id="emp_female" name="emp_gender" value="0">여
							</label>
						</div>
					</div> -->
				<!-- 	<div class="form-group">
						<label for="cb_recv_email" class="col-sm-3 control-label">전자결재 이메일 수신</label>
						<div class="col-sm-3">
							<div class="checkbox">
								<input type="checkbox" id="cb_recv_email" name="cb_recv_email" value="1" style="margin-left: 0px;">
							</div>
						</div>
					</div> -->
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-3">
							<button type="button" class="btn btn-primary" onclick="isok()">수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>
