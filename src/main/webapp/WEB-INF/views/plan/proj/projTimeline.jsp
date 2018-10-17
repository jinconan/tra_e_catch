<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	boolean isLeader = (Boolean) request.getAttribute("isLeader");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 프로젝트 일정</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script src="<%=request.getContextPath()%>/js/google_chart_loader.js"></script>
<script type="text/javascript">
	var container = null;
	var chart = null;
	var dataTable = null;
	var jsonProjTimeline = null;
	
	$.ajax({
		url:"<%=request.getContextPath()%>/planR/json/projTimeline"
		,async:false
		,data:"projNo=${requestScope.projNo}&isToday=false"
		,dataType:"json"
		,success:function(data) {
			//string으로 받아온 날짜를 자바스크립트의 Date타입으로 변환.
			console.log(data);
			for(var i=0;i<data.rows.length;i++) {
				data.rows[i].c[1].v = new Date(data.rows[i].c[1].v);
				data.rows[i].c[2].v = new Date(data.rows[i].c[2].v);
			}
			console.log(data);
			jsonProjTimeline = data;
		}
		,error:function(xhr) {
			console.log("error");
		}
	})
	
	//구글차트 로딩
	google.charts.load('current', {
		'packages' : [ 'timeline' ]
		,'language': 'ko'
	});
	google.charts.setOnLoadCallback(drawChart);
	
	//타임라인 차트 그리기 함수
	function drawChart() {
		container = document.getElementById('timeline');
		chart = new google.visualization.Timeline(container);
		if(jsonProjTimeline.rows.length != 0) {
			dataTable = new google.visualization.DataTable(jsonProjTimeline);
			chart.draw(dataTable);
		}
		else {
			container.innerHTML="";
		}
	}
	
	//브라우저 크기 변경시 차트 다시 그리기
	$(window).resize(function(Event) {
		chart.clearChart();	
		drawChart();
	})
</script>
<script>
$(document).ready(function() {
	//한 프로젝트에 대한 서브메뉴의 경우에는 PK를 뒤에 붙여주어야함.
	var $a = $("#submenu>li>a");
	
	$a.each(function(i,data) {
		var href= $(this).attr("href");
		if($(this).text().trim() == "전체 프로젝트 리스트") {
			return;
		}
		$(this).attr("href", href+"${requestScope.projNo}" );
	});
	
	$("#btn_add_timeline").click(function() {
		//data-toggle="modal" data-target="#modalTimeline"
		$(this).attr("data-toggle", "modal");
		$(this).attr("data-target", "#modalTimeline");
		$("#modalTimelineLabel").html("<strong>타임라인 추가</strong>");
	 	$("#schedName").val("");
		$("#startDate").val("");
		$("#endDate").val("");
		$("#btn_modalTimeline").attr("class", "btn btn-primary ");
		$("#btn_modalTimeline").text("추가");
		
	})
	$("#btn_mod_timeline").click(function() {
		var row = chart.getSelection()[0].row;
		if(row ==null) {
			alert("변경할 일정을 선택하세요");
			return false;
		}
		else {
			$(this).attr("data-toggle", "modal");
			$(this).attr("data-target", "#modalTimeline");
			$("#modalTimelineLabel").html("<strong>타임라인 변경</strong>");
			//선택한 일정 데이터 파싱작업 진행
			var schedName = dataTable.getFormattedValue(row,0);
			var startDate = dateToString(new Date(dataTable.getFormattedValue(row,1)));
			var endDate = dateToString(new Date(dataTable.getFormattedValue(row,2)));
			
			$("#schedName").val(schedName);
			$("#startDate").val(startDate);
			$("#endDate").val(endDate);
			$("#btn_modalTimeline").attr("class", "btn btn-warning");
			$("#btn_modalTimeline").text("변경");
		}
	})
	$("#btn_del_timeline").click(function() {
		var row = chart.getSelection()[0].row;
		if(row == null) {
			alert("삭제할 일정을 선택하세요");
			return false;
		} else {
			var select = confirm("정말 삭제하시겠습니까?");
			if(select==true) {
				var schedNo = jsonProjTimeline.rows[row].schedNo;
				$.ajax({
					url:"${pageContext.request.contextPath}/plan/timelineDelete"
					,data:"projNo=${requestScope.projNo}&schedNo="+schedNo
					,dataType:"json"
					,method:"post"
					,success:function(data) {
						alert("삭제되었습니다.");
						for(var i=0;i<data.rows.length;i++) {
							data.rows[i].c[1].v = new Date(data.rows[i].c[1].v);
							data.rows[i].c[2].v = new Date(data.rows[i].c[2].v);
						}
						jsonProjTimeline = data;
						chart.clearChart();
						drawChart();
						console.log(data);
					}
					,error:function(xhr) {
						console.log("error");
					}
				})
			}
		}
	})
	
	$("#btn_modalTimeline").click(function() {
		var $btnText = $("#btn_modalTimeline").text();
		var schedName = $("#schedName").val();
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		var data = "projNo=${requestScope.projNo}&schedName="
			+ schedName + "&startDate=" + startDate + "&endDate=" + endDate;
		var url = null;
		if($btnText == "추가"){
			url = "${pageContext.request.contextPath}/plan/timelineInsert"
		} else {
			url = "${pageContext.request.contextPath}/plan/timelineUpdate"
			var row = chart.getSelection()[0].row;
			var schedNo = jsonProjTimeline.rows[row].schedNo;
			data += "&schedNo="+schedNo;
		}
		
		$.ajax({
			url:url
			,data:data
			,method:"post"
			,dataType:"json"
			,success:function(data) {
				for(var i=0;i<data.rows.length;i++) {
					data.rows[i].c[1].v = new Date(data.rows[i].c[1].v);
					data.rows[i].c[2].v = new Date(data.rows[i].c[2].v);
				}
				jsonProjTimeline = data;
				chart.clearChart();
				drawChart();
				$("#modalTimeline").removeClass("in");
			}
			,error:function(xhr) {
				console.log("error");
			}
		})
	})
	
	$(".form_datetime").datetimepicker({
		format : 'yyyy-mm-dd'
		, minView : 2
	});
	
	//시작일 선택하면 종료예정일은 시작일부터 활성화.
	$("#startDate").datetimepicker().on("changeDate",function(ev) {
		$("#endDate").datetimepicker("setStartDate",$("#startDate").val())
	})
	
	//종료예정일 선택하면 시작일은 최대 종료예정일까지 활성화
	$("#endDate").datetimepicker().on("changeDate",function(ev) {
		$("#startDate").datetimepicker("setEndDate",$("#endDate").val())
	})
})
</script>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<!-- 본문 -->
	<div class="container">
		<!-- 좌측 사이드 메뉴 -->
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>

		<!-- 작성할 부분 -->
		<div class="col-sm-10">

			<div class="row">
				<div class="page-header">
					<h2>
						<strong>프로젝트 일정</strong>
						<%if(isLeader == true) {%>
						<div class="btn-group">
							<button type="button" id="btn_add_timeline" class="btn btn-primary">추가</button>
							<button type="button" id="btn_mod_timeline" class="btn btn-warning">변경</button>
							<button type="button" id="btn_del_timeline" class="btn btn-danger">삭제</button>
						</div>
						<%} %>
					</h2>
				</div>

			</div>

			<div class="row">
				<div id="timeline" style="height: 300px;"></div>
			</div>
		</div>
	</div>
	<% if(isLeader == true) { %>
	<div id="modalTimeline" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalTimelineLabel" aria-hidden="true" style="display: none;">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<div class="modal-header bg-primary">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="modalTimelineLabel">
						<strong>타임라인 추가</strong>
					</h4>
				</div>
				<div class="modal-body">
					<div class="form-inline">
						<label for="schedName" class="control-label">일정명</label>
						<input type="text" class="form-control" id="schedName" name="schedName" placeholder="일정명" required/>
						<label for="time_date" class="control-label">기간</label>
						<div class="input-group">
							<input type="text" class="form-control form_datetime" id="startDate" name="startDate" placeholder="시작일" readonly required/>
							<div class="input-group-addon">~</div>						
							<input type="text" class="form-control form_datetime" id="endDate" name="endDate" placeholder="종료일" readonly required/>
						</div>
						<button id="btn_modalTimeline" class="btn btn-primary">추가</button>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<% } %>

	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>