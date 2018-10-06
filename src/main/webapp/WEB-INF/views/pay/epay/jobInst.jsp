<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>

<script type="text/javascript">
	$(function() {
		$('#datetimepicker1').datetimepicker({
			format: 'yyyy-mm-dd'
		   ,minView:2
		});
		$('#datetimepicker2').datetimepicker({
			format: 'yyyy-mm-dd'
		   ,minView:2
		});
	});
	
	
	function accept(){
		var emp_no = $("#f_emp_no").serialize();
		$.ajax({
			url:"/tra_e_catch/pay/epay/jobInst"
			,method:"POST"
			,data:emp_no,
			success:function(log){
			$("#jobtable").html(log);
			}
		 ,error:function(Object){
	    	 alert("error : "+Object.responseText);
	     }
		});
	}
	function jobInst() {
			
			$("#f_emp_no").attr("action","./jobInst/insert");
			$("#f_emp_no").submit(); 
			alert("등록되었습니다."); 
		
	}
	
	
	
	
</script>

</head>
<body>


<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	<div class="container">
	<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">
			
			<form class="form-horizontal" id="f_jobInst">
				<center>
				<div class="page-header">
					<h1>작업지시서</h1>
				</div>
				</center>
					<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">거래처</label>
					<div class="col-sm-3">
						<input class="form-control" id="inputDeal" type="email"
							placeholder="거래처">
					</div>
					</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">제목</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputPassword" type="password"
							placeholder="제목">

					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputNumber">등록일자</label>
					<div class="col-sm-2" style="padding-right: 0px;">

						<div class='input-group date' id='datetimepicker1'>
							<input type='text' class="form-control" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>



					<label class="col-sm-2 control-label" for="inputNumber">납기일자</label>
					<div class="col-sm-2" style="padding-left: 0px;">

						<div class='input-group date' id='datetimepicker2'>
							<input type='text' class="form-control" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
				</div>

					<label class="col-sm-3 control-label" for="inputEmail">사원코드</label>
						<div class="col-sm-3">
					<form id="f_emp_no" method="post">
				<input class="form-control" id="emp_no" name="emp_no" placeholder="사원코드">
					</form>
						</div>
				

				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">내용</label>
					<div class="col-sm-6">
						<textarea class="form-control" rows="10"></textarea>
					</div>
				</div>

		</div>
		<div class="form-group">
			<div class="col-sm-12 text-center">
				<button id="btn_pay" class="btn btn-primary">
					전송<i class="fa fa-check spaceLeft" onclick="javascript:jobInst()"></i>
				</button>
				<button id="btn_pay" class="btn btn-primary">
					취소<i class="fa fa-check spaceLeft"></i>
				</button>

			</div>
		</div>
		<div class="form-group" id="jobtable"></div>
		</form>
		<hr>
	</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>

