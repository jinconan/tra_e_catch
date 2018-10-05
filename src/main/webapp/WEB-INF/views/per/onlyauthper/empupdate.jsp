<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>사원명부</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>

<script type="text/javascript">
function acceptlist(){
	var emp_no = $("#f_emp_no").serialize();
	$.ajax({
		url:"/tra_e_catch/per/empupdatetable"
		,method:"POST"
		,data:emp_no,
		success:function(log){
		$("#empupdatetable").html(log);
		}
	 ,error:function(Object){
    	 alert("error : "+Object.responseText);
     }
	});
	

}

</script>

</head>
<body>
<%@ include file="/WEB-INF/views/_common/header.jsp"%>
<div class="container">
	<%@ include file="/WEB-INF/views/_common/submenu.jsp" %>
	<div class="col-md-10">
	  <div class="page-header">
          <h1>인사정보 수정</h1>
         </div>
			<div class="form-group">
			
				<label class="col-sm-3 control-label" for="inputEmail">사원번호</label>
				<div class="col-sm-3">
				<form id="f_emp_no" method="post">
				<input class="form-control" id="emp_no" name="emp_no" placeholder="사원번호">
				</form>		</div>
				
				<div class="col-sm-1 text-center" style="padding-left: 1px;">
					<button id="btn_labsearch"class="btn btn-primary" style="margin-left:10px;" onclick="javascript:acceptlist()">
						조회<i class="fa fa-check spaceLeft"></i>
					</button>
				</div>
								
				</div>
				<div id="empupdatetable"></div>
			</div>
			
			
			
			<div class="form-group" id="labtable"></div>  
		</div>

	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>