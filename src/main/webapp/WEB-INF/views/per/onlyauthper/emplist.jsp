<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>사원명부</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script type="text/javascript">
function accept(){
var lev_no = $("#f_info").serialize();
	$.ajax({
		url:"/tra_e_catch/per/emptable"
		,method:"GET"
		,data:lev_no,
		success:function(log){
			$("#emptable").html(log);
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
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-9">
				<div class="page-header">
					<h1>
						사원명부 <small>basic form</small>
					</h1>
				</div>
				<form id="f_info" method="post" class="form-horizontal col-xs-11">
					<div class="form-group"></div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="per-name">이름</label>
						<div class="col-sm-3">
							<input class="form-control" name="name" id="per-name"
								type="per-name" placeholder="이름">
						</div>

					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="lev-no">직급코드</label>
						<div class="col-sm-4">
							<input class="form-control" name="lev_no" id="lev-no"
								type="lev-code" placeholder="직접코드">

						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="dept-no">부서코드</label>
						<div class="col-sm-4">
							<input class="form-control" name="dept_no" id="dept-no"
								type="dept-code" placeholder="부서코드">

						</div>
					</div>
				</form>
		</div>
		<div class="form-group">
			<div class="col-sm-12 text-center">
				<button id="btn_emp" class="btn btn-primary" onclick="javascript:accept()">
					검색<i class="fa fa-check spaceLeft"></i>
				</button>

			</div>
		</div>
		<div class="form-group" id="emptable">
				
			</div>
		<!-- <div class="table-responsive col-xs-9 col-xs-offset-2">
			<table id="p_table" class="table table-striped table-hover">
				<thead>
					<tr>

						data-field에는 json포멧으로 데이터를 담을예정 
						<th width="15%" data-field="EMP_NO">사원번호</th>
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

			<hr>
		</div> -->
		<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
	</div>
</body>
</html>