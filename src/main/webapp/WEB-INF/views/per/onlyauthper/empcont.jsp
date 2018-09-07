<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn_empcontsearch").click(function(){
			$.ajax({
				url:"/tra_e_catch/per/empconttable"
				,method:"GET"
				,success:function(data){
					alert("아작스 성공");
					$("#empconttable").html(data);
				}
			 ,error:function(Object){
		    	 alert("error : "+Object.responseText);
		     }
			});
			return false;
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
		<form class="form-horizontal">
		  <div class="page-header">
          <h1>고용계약서 </h1>
         </div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">사원코드</label>
				<div class="col-sm-3">
					<input class="form-control" id="inputEmail" type="email"
						placeholder="사원코드">
              
				</div>
				<div class="col-sm-1 text-center" style="padding-left: 1px;">
					<button id="btn_empcontsearch"class="btn btn-primary" style="margin-left:10px;">
						조회<i class="fa fa-check spaceLeft"></i>
					</button>
				</div>
				
					
				</div>
			</div>
			
			
			
			<div class="form-group" id="empconttable"></div>  
		  </form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>