<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<%
String emp_no = request.getParameter("emp_no").toString();
System.out.println("뾰롱"+emp_no);
%>
<body>
	<script type="text/javascript">
$(function() {
	$('#p_table').bootstrapTable({
		url:'<%=request.getContextPath()%>/perR/indivemplist',
		queryParams: function(p){
            return{
            	emp_no : '<%=emp_no%>'
            }
		
		}
	});
	

});

</script>
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">
			<table class="table table-striped" id="p_table">
				<thead>
					<tr>
						<!-- 김훈태 작업중  -->
						<th width="10%" data-field="EMP_NO">사원번호</th>
						<th width="15%" data-field="ENAME">사원이름</th>
						<th width="15%" data-field="TNAME">팀명</th>
						<th width="15%" data-field="CLEV">직급</th>
						<th width="15%" data-field="HDAY">입사일자</th>
						<th width="15%" id="insaupdate">수정</th>
			
			
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<nav>
				<div class="text-center">
	
				</div>
			</nav>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>