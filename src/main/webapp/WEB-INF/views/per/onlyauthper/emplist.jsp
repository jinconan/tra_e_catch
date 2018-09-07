<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>사원명부</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn_emp").click(function(){
			$.ajax({
				url:"/tra_e_catch/per/emptable"
				,method:"GET"
				,success:function(data){
					alert("아작스 성공");
					$("#emptable").html(data);
				}
			 ,error:function(Object){
		    	 alert("error : "+Object.responseText);
		     }
			});
			return false;
		});
	});
</script>
	<script type="text/javascript">
	$(function() {
		$('#datetimepicker1').datetimepicker();
		$('#datetimepicker2').datetimepicker();
		$('#datetimepicker3').datetimepicker();
	});
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	<%-- <jsp:include page="/WEB-INF/views/_common/header.jsp" /> --%>
<div class="container">
	<%@ include file="/WEB-INF/views/_common/submenu.jsp" %>
	<div class="col-md-10">
		<form class="form-horizontal">
		  <div class="page-header">
          <h1>사원명부 <small>basic form</small></h1>
         </div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">이름</label>
				<div class="col-sm-3">
					<input class="form-control" id="inputEmail" type="email"
						placeholder="이름">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputPassword">직급코드</label>
				<div class="col-sm-4">
					<input class="form-control" id="inputPassword" type="password"
						placeholder="직접코드">
					
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputPasswordCheck">부서코드</label>
				<div class="col-sm-4">
					<input class="form-control" id="inputPasswordCheck" type="password"
						placeholder="부서코드">
					
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputName">지역코드</label>
				<div class="col-sm-4">
					<input class="form-control" id="inputName" type="text"
						placeholder="지역코드">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputNumber">입사일자</label>
				<div class="col-sm-3">
					<div class='input-group date' id='datetimepicker1'>
							<input type='text' class="form-control" placeholder="입사일자"/> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar" ></span>
							</span>
						</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputNumberCheck">생일</label>
				<div class="col-sm-3">
					<div class='input-group date' id='datetimepicker2'>
							<input type='text' class="form-control" placeholder="생일"/> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar" ></span>
							</span>
						</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">퇴사여부</label>
				<div class="col-sm-5">
					<input class="form-control" id="inputEmail" type="email"
						placeholder="퇴사여부">
				</div>
			</div>		
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">마지막근무일</label>
				<div class="col-sm-3">
					<div class='input-group date' id='datetimepicker3'>
							<input type='text' class="form-control" placeholder="마지막근무일"/> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar" ></span>
							</span>
						</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">아이디</label>
				<div class="col-sm-3">
					<input class="form-control" id="inputEmail" type="email"
						placeholder="아이디">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">password</label>
				<div class="col-sm-3">
					<input class="form-control" id="inputEmail" type="email"
						placeholder="password">
				</div>
			</div>				
			</div>
			<div class="form-group">
				<div class="col-sm-12 text-center">
					<button id="btn_emp"class="btn btn-primary">
						검색<i class="fa fa-check spaceLeft"></i>
					</button>
					
				</div>
			</div>
			<div class="form-group" id="emptable">
				
			</div>  
		</form>
		<hr>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>