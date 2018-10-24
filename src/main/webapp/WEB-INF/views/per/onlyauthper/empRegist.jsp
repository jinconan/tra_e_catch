<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
int addemp_no = Integer.parseInt(String.valueOf(session.getAttribute("emp_no"))); //사원정보 받는 곳
/* int result = (Integer)request.getAttribute("result"); */
%>
<title>트라E캐치-사원등록</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
	$(document).ready(function() {
		
		
		var emp_nochk = <%=addemp_no%>;

		if(emp_nochk>3){
			alert("인사권자 전용 페이지 입니다.");
			location.href='<%=request.getContextPath()%>/';
		}
		$(".form_datetime").datetimepicker({
			format : 'yyyy-mm-dd'
			, minView : 2
			, 
		});
		
		$.ajax({
			url:'<%=request.getContextPath()%>/perR/lev/list',
			type: "json",
			success: function(data){
				for(i in data){
					$("#lev_list").append("<option val="+data[i].LEV_NO+">"+data[i].NAME+"</option>");
					
				}
			}
		})
		$.ajax({
			url:'<%=request.getContextPath()%>/perR/loc/list',
			type: "json",
			success: function(data){
				for(i in data){
					$("#loc_list").append("<option val="+data[i].LOC_NO+">"+data[i].NAME+"</option>");
					
				}
			}
		})
		$.ajax({
			url:'<%=request.getContextPath()%>/perR/dept/list',
			type: "json",
			success: function(data){
				for(i in data){
					$("#dept_list").append("<option val="+data[i].DEPT_NO+">"+data[i].NAME+"</option>");
					
				}
			}
		})
	})
	function accept(){
		 $("#f_empinsert").attr("action","<%=request.getContextPath()%>/per/auth/empInsert");
			$("#f_empinsert").submit(); 
			/* 필요 정보
			
			디폴트값 : 
				 - sal = null
				 - pw = a12345
				 - sal = 0
				 - 팀번호 = null
				 - 이메일수신여부 = N
		
			*/
			alert("정상적으로 처리되었습니다.");
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
				<h2><strong>직원 등록</strong></h2>
				<form class="form-horizontal" method="post" id="f_empinsert">
					<div class="form-group">
						<label for="emp_name" class="col-sm-3 control-label">이름</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="emp_name" name="emp_name" required/>
						</div>
					</div>
					<div class="form-group">
						<label for="emp_id" class="col-sm-3 control-label">아이디</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="emp_id" name="emp_id" required/>
						</div>
					</div>
					<div class="form-group">
						<label for="emp_lev" class="col-sm-3 control-label">직급</label>
						<div class="col-sm-3">
					<select class="form-control" id="lev_list" name="lev_list">

						</select>
						</div>
					</div>
				<div class="form-group">
						<label for="emp_loc" class="col-sm-3 control-label">근무지역</label>
						<div class="col-sm-3">
					<select class="form-control" id="loc_list" name="loc_list">

						</select>
						</div>
					</div>
						<div class="form-group">
						<label for="dept_list" class="col-sm-3 control-label">근무부서</label>
						<div class="col-sm-3">
					<select class="form-control" id="dept_list" name="dept_list">

						</select>
						</div>
					</div>
					<div class="form-group">
						<label for="emp_email" class="col-sm-3 control-label">이메일</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="emp_email" name="emp_email" placeholder="xxxx@xxxXX.xxx" required/>
						</div>
					</div>
					<div class="form-group">
						<label for="emp_birthday" class="control-label col-sm-3">생일</label>
						<div class="col-sm-3">
							<input type="text" class="form-control form_datetime" id="emp_birthday" name="emp_bdate" readonly>
						</div>
					</div>
					<div class="form-group">
						<label for="d_gender" class="col-sm-3 control-label">성별</label>
						<div id="d_gender" class="col-sm-3">
							<label class="radio-inline control-label">
								<input type="radio" id="emp_male" name="emp_gender" value="남" checked>남
							</label>
							<label class="radio-inline control-label">
								<input type="radio" id="emp_female" name="emp_gender" value="여">여
							</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-3">
							<button class="btn btn-primary btn-block" onclick="javascript:accept()">등록</button>
						</div>
					</div>
				</form>
			</div>			
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>
