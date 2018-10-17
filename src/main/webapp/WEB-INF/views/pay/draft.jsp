 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 - 기안 목록</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script src="<%=request.getContextPath() %>/js/google_chart_loader.js"></script>
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
////////차트 처리
var jsonData = null;
var dataTable = null;
var chart = null;
function getChartDatas() {
	$.ajax({
		url:"<%=request.getContextPath()%>/payR/draftChart"
		,async:false
		,success:function(data) {
			jsonData = data;
		}
		,error:function(xhr) {
			console.log(xhr);
		}
	})
}
getChartDatas();
google.charts.load('current', {'packages':['corechart'],'language': 'ko' });
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    var chartArray = [['분류', '수']];
    
    for(var i=0;i<jsonData.length;i++) {
    	chartArray[1+i] = [jsonData[i].DNAME, jsonData[i].CNT];
    }
    
    console.log(chartArray);
    dataTable = google.visualization.arrayToDataTable(chartArray);
    chart = new google.visualization.PieChart(document.getElementById('chart'));
    chart.draw(dataTable, {title:"기안서 분류"});
  }	

function redrawChart() {
	chart.clearChart();	
	drawChart();
}

//브라우저 크기 변경시 차트 다시 그리기
$(window).resize(function(Event) {
	redrawChart();
})
/////////차트 처리 끝
</script>
<script>
$(document).ready(function() {
	$("#p_table").on("click-row.bs.table", function(e, row, $element, field) {
		console.log(row);
		$("#draftModal").modal('show');
		$("#dno").text(row.DNO);
		$("#udate").text(row.UDATE);
		$("#name").text("${sessionScope.emp_name}");
		$("#title").text(row.TITLE);
		$("#content").html(row.CONTENT);
		
		if(row.SIGN_YN == 1) {
			$("#cname").html(row.CENAME + "<span class='glyphicon glyphicon-thumbs-up' aria-hidden='true'></span>");
			$("#cdate").text(row.CDATE);
		} else if(row.SIGN_YN == 2) {
			$("#cdate").text(row.CDATE);
			$("#adate").text(row.ADATE);
			$("#cname").html(row.CENAME + "<span class='glyphicon glyphicon-thumbs-up' aria-hidden='true'></span>");
			$("#aname").html(row.AENAME + "<span class='glyphicon glyphicon-thumbs-up' aria-hidden='true'></span>");
		} else if(row.SIGN_YN == -1) {
			$("#cname").html(row.CENAME + "<span class='glyphicon glyphicon-thumbs-down' aria-hidden='true'></span>");
			$("#cdate").text(row.CDATE);
		} else if(row.SIGN_YN == -2) {
			$("#cname").html(row.CENAME + "<span class='glyphicon glyphicon-thumbs-up' aria-hidden='true'></span>");
			$("#aname").html(row.AENAME + "<span class='glyphicon glyphicon-thumbs-down' aria-hidden='true'></span>");
			$("#cdate").text(row.CDATE);
			$("#adate").text(row.ADATE);
		}
	})
	
	$('#printinp').click(function() {
		$('#print_table').printThis();
	});
})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>

	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">
			<div class="page-header">
				<h2>기안 문서 목록</h2>
			</div>
			
			<div class="row">
				<div id="chart" style="height:270px;"></div>
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
					data-url="<%=request.getContextPath() %>/payR/draft"
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
			
			<div class="modal fade" id="draftModal" tabindex="-1" role="dialog" aria-labelledby="draftModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="draftModalLabel">기안서</h4>
						</div>
						<div class="modal-body">
							<div id="d_viewwork">
								<table border="1" id="print_table" class="center-block" style="width: 532px; text-align:center;">
									<tr>
										<td colspan="5">
											<h3>기 안 서</h3>
										</td>
									</tr>
									<tr>
										<td width="15%">문서번호</td>
										<td width="45%" id="dno"></td>
										<td rowspan="2" width="10%">결재</td>
										<td width="15%">승인</td>
										<td width="15%">결재</td>
									</tr>
									<tr>
										<td>기안일자</td>
										<td id="udate"></td>
										<td id="cname"></td>
										<td id="aname"></td>
									</tr>
									<tr>
										<td>승인일자</td>
										<td id="cdate"></td>
										<td colspan="3">기안자</td>
									</tr>
									<tr>
										<td>결재일자</td>
										<td id="adate"></td>
										<td colspan="3" id="name"></td>
									</tr>
									<tr>
										<td>제목</td>
										<td colspan="4" id="title"></td>
									</tr>
									<tr>
										<td colspan="5">내용</td>
									</tr>
									<tr>
										<td id="content" colspan="5" rowspan="10" width="532" height="420"></td>
									</tr>
								</table>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="printinp">Print</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>