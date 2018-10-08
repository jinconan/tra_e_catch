<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<%
int addemp_no = Integer.parseInt(String.valueOf(session.getAttribute("emp_no"))); //사원정보 받는 곳
%>
<script type="text/javascript">
function accept(){
	$("#in_emp_no").val($("#i_emp_no").val());
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

$(function() {
var emp_nochk = <%=addemp_no%>;

if(emp_nochk>3){
	alert("인사권자 전용 페이지 입니다.");
	location.href='<%=request.getContextPath()%>/';
}
$("#i_emp_no").keypress(function(e) {
	
	if(e.which==13 ||event.keyCode == 13) {
		$("#in_emp_no").val($("#i_emp_no").val());
		accept();
		}
	});

});
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
					<input class="form-control" id="i_emp_no" placeholder="사원코드">
              	<form id="f_emp_no" method="post">
              	<input type="hidden" id="in_emp_no" name="in_emp_no">
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