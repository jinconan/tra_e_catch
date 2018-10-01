<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script type="text/javascript">

	function accept(){
		var empno = $("#f_emp_no").serialize();
		$.ajax({
			url:"/tra_e_catch/per/labtable"
			,method:"POST"
			,data:empno,
			success:function(log){
			$("#labtable").html(log);
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
	<%-- <jsp:include page="/WEB-INF/views/_common/header.jsp" /> --%>
<div class="container">
	<%@ include file="/WEB-INF/views/_common/submenu.jsp" %>
	<div class="col-md-10">
	  <div class="page-header">
          <h1>근로계약서 관리</h1>
         </div>
			<div class="form-group">
			
				<label class="col-sm-3 control-label" for="inputEmail">사원코드</label>
				<div class="col-sm-3">
				<form id="f_emp_no" method="post">
					<input class="form-control" id="emp_no" name="emp_no" placeholder="사원코드">
				</form>
				</div>
				
				<div class="col-sm-1 text-center" style="padding-left: 1px;">
					<button id="btn_labsearch"class="btn btn-primary" style="margin-left:10px;" onclick="javascript:accept()">
						조회<i class="fa fa-check spaceLeft"></i>
					</button>
				</div>
				<div class="col-sm-1 text-center" style="padding-left: 1px;">
					<button id="btn_labinsert"class="btn btn-primary" style="margin-right:10px;">
						등록<i class="fa fa-check spaceLeft"></i>
					</button>
					</div>
					
				</div>
			</div>
			
			
			
			<div class="form-group" id="labtable"></div>  
		</div>

	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>