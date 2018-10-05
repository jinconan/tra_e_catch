<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>사원명부</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<%
	List<Map<String,Object>> getEmpList = (List<Map<String,Object>>)request.getAttribute("getEmpList");
%>
<script type="text/javascript">
function accept(){
	$('#p_table').bootstrapTable({
		method: "post",
		contentType: 'application/x-www-form-urlencoded',
		queryParams: function(p){
            return{
            	lev_no : $("#lev-no").val(),
            	name : $("#per-name").val(),
            	dept_no : $("#dept-no").val(),
            };
		}
		,url:'<%=request.getContextPath()%>/perR/empList'
	});
}

</script>

</head>
<body>
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	<%-- <jsp:include page="/WEB-INF/views/_common/header.jsp" /> --%>
<div class="container">
	<%@ include file="/WEB-INF/views/_common/submenu.jsp" %>
	<div class="col-md-9">
		<form class="form-horizontal col-xs-11">
		  <div class="page-header">
          <h1>사원명부 <small>basic form</small></h1>
         </div>
         <form id="f_info">
			<div class="form-group">
	
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="per-name">이름</label>
				<div class="col-sm-3">
					<input class="form-control" name="name" id="per-name" type="per-name"
						placeholder="이름">
				</div>
				
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="lev-no">직급코드</label>
				<div class="col-sm-4">
					<input class="form-control" name="lev-no" id="lev-no" type="lev-code"
						placeholder="직접코드">
					
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="dept-no">부서코드</label>
				<div class="col-sm-4">
					<input class="form-control" name="dept-no" id="dept-no" type="dept-code"
						placeholder="부서코드">
					
				</div>
			</div>
			</form>
			
			</div>
			<div class="form-group">
				<div class="col-sm-12 text-center">
					<button id="btn_emp"class="btn btn-primary" onclick="javascript:accept()">
						검색<i class="fa fa-check spaceLeft"></i>
					</button>
					
				</div>
			</div>
			<!-- <div class="form-group" id="emptable">
				
			</div>   -->
			<div class="table-responsive col-xs-9 col-xs-offset-2">
				<table id="p_table" class="table table-striped table-hover">
					<thead>
						<tr>
						
							<!-- data-field에는 json포멧으로 데이터를 담을예정  -->
							<!-- <th width="15%" data-field="EMP_NO">사원번호</th> -->
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
					<tbody>
					
					</tbody>
				</table>
		</form>
		<hr>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>