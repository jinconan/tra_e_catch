<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 - 기안 목록</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
var dtype = null;
var sign_status = null;
	
function tableParams(param) {
	if(sign_status != null) {
		param.sign_yn = sign_status;
		if(sign_status == "전체") {
			delete param.sign_yn;
		}
	}
	if(dtype != null) {
		param.dname = dtype;
		if(dtype == "전체") {
			delete param.dname;
		}
	}
	return param;
}

function setDtype(data) {
	dtype = data;
	$("#p_table").bootstrapTable('refresh',null);
	if(data != "전체")
		$("#dtype button.dropdown-text").text(data);
	else
		$("#dtype button.dropdown-text").text("문서 종류");
}

function setSignStatus(data) {
	if(data != "전체") {
		if(data == "읽지않음") 
			sign_status = 0;
		else if(data == "승인완료")
			sign_status = 1;
		else if(data == "결재완료")
			sign_status = 2;
		else if(data == "승인실패")
			sign_status = -1;
		else if(data == "결재실패")
			sign_status = -2;
		$("#sign_status button.dropdown-text").text(data);
	}
	else {
		$("#sign_status button.dropdown-text").text("기안 현황");
		sign_status = "전체";
	}
	$("#p_table").bootstrapTable('refresh',null);
}
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>

	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">
			<div class="page-header">
				<h1>기안 문서 목록</h1>
			</div>
			<!-- 테이블 툴바 -->
			<div id="table-toolbar">
				<div class="btn-group" id="dtype">
					<button type="button" class="btn btn-primary dropdown-text">문서 종류</button>
					<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
						<span class="caret"></span> <span class="sr-only">Toggle Dropdown</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="javascript:setDtype('전체')">전체</a></li>
						<li><a href="javascript:setDtype('휴가')">휴가</a></li>
						<li><a href="javascript:setDtype('외근')">외근</a></li>
						<li><a href="javascript:setDtype('프로젝트보고서')">프로젝트보고서</a></li>
						<li><a href="javascript:setDtype('협찬보고서')">협찬보고서</a></li>
						<li><a href="javascript:setDtype('협업승인서')">협업승인서</a></li>
						<li><a href="javascript:setDtype('작업지시서')">작업지시서</a></li>
						<li><a href="javascript:setDtype('공간대여')">공간대여</a></li>
						<li><a href="javascript:setDtype('공용장비대여')">공용장비대여</a></li>
						<li><a href="javascript:setDtype('주말근무보고서')">주말근무보고서</a></li>
						<li><a href="javascript:setDtype('회식보고서')">회식보고서</a></li>
						<li><a href="javascript:setDtype('계약서')">계약서</a></li>
						<li><a href="javascript:setDtype('근로계약서')">근로계약서</a></li>
						<li><a href="javascript:setDtype('고용계약서')">고용계약서</a></li>
						<li><a href="javascript:setDtype('사직서')">사직서</a></li>
					</ul>
				</div>
				<div class="btn-group" id="sign_status">
					<button type="button" class="btn btn-info dropdown-text">기안 현황</button>
					<button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
						<span class="caret"></span> <span class="sr-only">Toggle Dropdown</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="javascript:setSignStatus('전체')">전체</a></li>
						<li><a href="javascript:setSignStatus('읽지않음')">읽지않음</a></li>
						<li><a href="javascript:setSignStatus('승인완료')">승인완료</a></li>
						<li><a href="javascript:setSignStatus('결재완료')">결재완료</a></li>
						<li><a href="javascript:setSignStatus('승인실패')">승인실패</a></li>
						<li><a href="javascript:setSignStatus('결재실패')">결재실패</a></li>
					</ul>
				</div>
			</div>
			
			<div class="row">
				<table class="table table-striped" id="p_table"
					data-toggle="table"
					data-url="<%=request.getContextPath() %>/payR/epay/draft"
					data-show-columns="true"
					data-toolbar="#table-toolbar"
					data-pagination="true"
					data-page-list="[10]"
					data-query-params="tableParams"
					data-side-pagination="server">
					<%-- RNO, DNAME, TITLE, CONTENT, UDATE, CENAME, AENAME, SIGN_YN, SRESULT --%> 
					<thead>
						<tr>
							<th data-field="RNO">#</th>
							<th data-field="DNAME">종류</th>
							<th data-field="TITLE">제목</th>
							<th data-field="UDATE">기안날짜</th>
							<th data-field="CENAME">승인자</th>
							<th data-field="AENAME">결재자</th>
							<th data-field="SRESULT">현황</th>
						</tr>
					</thead>
				</table>
			</div>

		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>