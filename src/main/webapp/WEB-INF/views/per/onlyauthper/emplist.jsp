<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>트라E캐치-사원명부</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<%

int addemp_no = Integer.parseInt(String.valueOf(session.getAttribute("emp_no"))); //사원정보 받는 곳

%>
<script type="text/javascript">
function tableParams(params) {
	params.name=$("#name").val();
	params.dept_no=$("#dept_no").val();
	params.lev_no=$("#lev_no").val();
	return params;
}

function accept(){
	 $('#p_table').bootstrapTable('refresh', null); 
}

$(function() {
var emp_nochk = <%=addemp_no%>;

if(emp_nochk>3){
	alert("인사권자 전용 페이지 입니다.");
	location.href='<%=request.getContextPath()%>/';
}
<%-- var adminno= <%=adminemp_no%>;
	/* alert(adminno);//emp_no정상적으로 가져옴 */
	$("#adminacc").click(function() {
		if(adminno>3){
			alert("인사권자 전용페이지 입니다.");
			$("#adminacc").attr("href", "<%=contextPath%>/")
			<li><a href="<%=contextPath%>/per/empList" id="adminacc">인사권자 전용</a></li>
		}
	}) --%>
});



</script>
	
</head>
<body>
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">
			<div class="row">
				<div class="page-header">
						<h1>사원명부</h1>
					</div>
					<div class="form-group" id="emptable"></div>
				</div>	
				
				<!-- -------------- -->
				<div class="row">
					<div id="table-toolbar" class="form-inline">
						<div class="form-group">
							<label for="name" class="control-label sr-only">이름</label>
							<input class="form-control " name="name" id="name" type="text" placeholder="이름">
						</div>
						<div class="form-group">
							<label class="control-label sr-only" for="lev_no">직급</label>
							<input class="form-control " name="lev_no" id="lev_no" type="text" placeholder="직급코드">
						</div>
						<div class="form-group">
							<label class="control-label sr-only" for="dept_no">부서</label>
							<input class="form-control " name="dept_no" id="dept_no" type="text" placeholder="부서코드">
						</div>
						<div class="form-group">
							<button id="btn_emp" class="btn btn-primary" onclick="javascript:accept()">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				
					<table class="table table-striped" id="p_table"
						data-toggle="table"
						data-url="<%=request.getContextPath() %>/perR/auth/emplist"
						data-toolbar="#table-toolbar"
						data-pagination="true"
						data-page-list="[10]"
						data-query-params="tableParams">
						<thead>
							<tr>
							    <th width="10%" data-field="NAME">이름</th>
								<th width="11%" data-field="HIRE_DATE">입사일자</th>
								<th width="11%" data-field="LEV_NO">직급코드</th>
								<th width="11%" data-field="DEPT_NO">부서코드</th>
								<th width="11%" data-field="LOC_NO">지역코드</th>
								<th width="11%" data-field="BIRTHDAY">생일</th>
								<th width="11%" data-field="EMAIL">이메일</th>
								<th width="11%" data-field="TEAM_NO">팀코드</th>
							</tr>
						</thead>
					</table>
				</div>
				<!-- ----------------- -->
		</div>
		<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
	</div>
</body>
</html>