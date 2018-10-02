<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script type="text/javascript">
function accept(){
	var emp_no = $("#f_emp_no").serialize();
	
	$.ajax({
		url:"/tra_e_catch/per/empconttable"
		,method:"POST"
		,data:emp_no,
		success:function(log){
		$("#empconttable").html(log);
		}
	 ,error:function(Object){
    	 alert("error : "+Object.responseText);
     }
	});
}
function sourcinginsert(){
	 $("#f_emp_no").attr("action","./sourcing/insert");
	$("#f_emp_no").submit(); 
	alert("등록되었습니다.");
	
}
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	<%-- <jsp:include page="/WEB-INF/views/_common/header.jsp" /> --%>
<div class="container">
	<%@ include file="/WEB-INF/views/_common/submenu.jsp" %>
	<div class="col-md-10">
		
		  <div class="page-header">
          <h1>고용계약서 </h1>
         </div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">사원코드</label>
				<div class="col-sm-3">
				<form id="f_emp_no" method="post">
					<input class="form-control" id="emp_no" name="emp_no"
						placeholder="사원코드">
              	</form>
				</div>
				<div class="col-sm-1 text-center" style="padding-left: 1px;">
					<button id="btn_empcontsearch"class="btn btn-primary" style="margin-left:10px;"
					 onclick="javascript:accept()">
						조회<i class="fa fa-check spaceLeft"></i>
					</button>
				</div>
				<div class="col-sm-1 text-center" style="padding-left: 1px;">
					<button id="btn_labinsert"class="btn btn-primary" style="margin-right:10px;" 
					 onclick="javascript:sourcinginsert()">
						등록<i class="fa fa-check spaceLeft"></i>
					</button>
					</div>
					
				</div>
			</div>
			
			
			
			<div class="form-group" id="empconttable"></div>  
		  
		</div>
	
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>