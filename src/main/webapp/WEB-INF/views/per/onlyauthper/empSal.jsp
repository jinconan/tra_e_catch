<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>트라E캐치 - 인사권자 전용 - 사원 급여관리</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script type="text/javascript">
function tableParam(param,) {
	param.pageNo=1;
	return param;
}
$(function() {
	$('#f_gsmodal').on('load-success.bs.table', function (e,data) {
	    $('#f_gsmodal').bootstrapTable('resetView', 100);
	});
})
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">
			<div class="page-header">
				<h1>사원 급여관리</h1>
			</div>
			<div class="row">
				<!-- 테이블 툴바 -->
				<div id="table-toolbar">
					<a data-toggle="modal" data-target="#giveSalModal" class="btn btn-primary">급여지급</a>
					<a data-toggle="modal" data-target="#modifySalModal" class="btn btn-success">월급수정</a>
				</div>
				<!-- 급여 지급내역 테이블 -->
				<table data-toggle="table"
					data-url="<%=request.getContextPath() %>/perR/salhistory"
					data-query-params="tableParam"
					data-toolbar="#table-toolbar"
					data-show-columns="true"
					data-pagination="true"
					data-page-list="[10]"
					data-side-pagination="server"
					>
					<thead>
						<tr>
							<th data-field="GDATE">지급날짜</th>
							<th data-field="ENAME">사원명</th>
							<th data-field="LNAME">직급</th>
							<th data-field="DNAME">부서</th>
							<th data-field="TNAME">팀</th>
							<th data-field="SSAL">지급액</th>
							<th data-field="SNAME">급여종류</th>
							<th data-field="SNOTE">비고</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
		<!-- 급여지급 모달 -->
		<div id="giveSalModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header bg-primary">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">급여지급</h4>
					</div>
					<form action="<%=request.getContextPath()%>/per/salaryInsert" method="post">
						<div class="modal-body">
							<div>
								<label for="eno" class="control-label">사원번호</label> <input type="number" class="form-control" name="eno" id="eno" required="required" />
							</div>
							<div>
								<label for="stype" class="control-label">급여종류</label> <select id="stype" name="stype" class="form-control">
									<option value="1" selected="selected">월급</option>
									<option value="2">상여금</option>
									<option value="3">연차수당</option>
									<option value="4">퇴직금</option>
								</select>
							</div>
							<div>
								<label for="svalue" class="control-label">급여액</label> <input type="number" id="svalue" name="svalue" class="form-control" required="required">
							</div>
							<div>
								<label for="snote" class="control-label">급여설명</label> <input type="text" id="snote" name="snote" class="form-control">
							</div>
						</div>
						<div class="modal-footer">
							<button class="btn btn-primary">지급</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<!-- 월급 수정 모달 -->
		<div id="modifySalModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header bg-success">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">월급수정</h4>
					</div>
					<form action="<%=request.getContextPath() %>/per/empSalUpdate" method="post">
						<div class="modal-body">
							<div>
								<label for="mseno" class="control-label">사원번호</label> <input type="number" class="form-control" name="mseno" id="mseno" required="required" />
							</div>
							<div>
								<label for="msvalue" class="control-label">급여액</label> <input type="number" id="msvalue" name="msvalue" class="form-control" required="required">
							</div>
						</div>
						<div class="modal-footer">
							<button class="btn btn-success">수정</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
	</div>
</body>
</html>