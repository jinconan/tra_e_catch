<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 타임라인</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script src="<%=request.getContextPath()%>/js/google_chart_loader.js"></script>
<script>
	var container = null; //타임라인이 그려질 div영역
	var chart = null; //container에 그려진 차트
	var dataTable = null; //chart가 사용할 데이터 테이블
	var dataTableRows = [
		[ '전체 기간', new Date(2018, 8, 29), new Date(2018, 10, 12) ]
		, [ '계획수립', new Date(2018, 8, 29), new Date(2018, 8, 31) ]
		, [ '화면작업', new Date(2018, 9, 3), new Date(2018, 9, 14) ]
		, [ '테스트', new Date(2018, 9, 29), new Date(2018, 10, 5) ]
	]; //dataTable에 들어갈 row들
	
	google.charts.load('current', {
		'packages' : [ 'timeline' ],
		'language' : 'ko'
	});
	google.charts.setOnLoadCallback(drawChart);

	//타임라인 차트 그리기 함수
	function drawChart() {
		container = document.getElementById('timeline');
		chart = new google.visualization.Timeline(container);
		dataTable = new google.visualization.DataTable({
			cols : [
				 {type : 'string', id : 'plan'}
				,{type : 'date', id : 'start'}
				,{type : 'date', id : 'end'}
			]
		});
		dataTable.addRows(dataTableRows);
		chart.draw(dataTable);
	}

	$(window).resize(function(Event) {
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
		$(this).attr("href", href+"${projNo}" );
	});
	
	$("#btn_add_timeline").click(function() {
		//data-toggle="modal" data-target="#modalTimeline"
		$(this).attr("data-toggle", "modal");
		$(this).attr("data-target", "#modalTimeline");
		$("#modalTimelineLabel").html("<strong>타임라인 추가</strong>");
	 	$("#time_name").val("");
		$("#time_start").val("");
		$("#time_end").val("");
		$("#btn_modalTimeline").attr("class", "btn btn-primary");
		$("#btn_modalTimeline").text("추가");
		
	})
	$("#btn_mod_timeline").click(function() {
		var row = chart.getSelection()[0].row;
		if(row ==null) {
			alert("변경할 일정을 선택하세요");
		}
		else {
			$(this).attr("data-toggle", "modal");
			$(this).attr("data-target", "#modalTimeline");
			$("#modalTimelineLabel").html("<strong>타임라인 변경</strong>");
			//선택한 일정 데이터 파싱작업 진행
			var time_name = dataTable.getFormattedValue(row,0);
			var time_start = dataTable.getFormattedValue(row,1);
			var time_end = dataTable.getFormattedValue(row,2);
			$("#time_name").val(time_name);
			$("#time_start").val(time_start);
			$("#time_end").val(time_end);
			$("#btn_modalTimeline").attr("class", "btn btn-warning");
			$("#btn_modalTimeline").text("변경");
		}
	})
	$("#btn_del_timeline").click(function() {
		var row = chart.getSelection()[0].row;
		if(row == null) {
			alert("삭제할 일정을 선택하세요");
		} else {
			var select = confirm("정말 삭제하시겠습니까?");
			if(select==true) {
				//삭제 처리 진행
			}
		}
	})
	
	$(".form_datetime").datetimepicker({
		format : 'yyyy. mm. dd'
		, minView : 2
	});
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
			<div class="well">

				<div class="row">
					<h2>
						<strong>프로젝트 타임라인</strong>
						<div class="btn-group">
							<button type="button" id="btn_add_timeline" class="btn btn-primary">추가</button>
							<button type="button" id="btn_mod_timeline" class="btn btn-warning">변경</button>
							<button type="button" id="btn_del_timeline" class="btn btn-danger">삭제</button>
						</div>
					</h2>

				</div>

				<div class="row">
					<div id="timeline" style="height: 300px;"></div>
				</div>
			</div>
		</div>
	</div>

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
						<label for="time_name" class="control-label">일정명</label>
						<input type="text" class="form-control" id="time_name" name="time_name" placeholder="일정명" required/>
						<label for="time_date" class="control-label">기간</label>
						<div class="input-group">
							<input type="text" class="form-control form_datetime" id="time_start" name="time_start" placeholder="시작일" readonly required/>
							<div class="input-group-addon">~</div>						
							<input type="text" class="form-control form_datetime" id="time_end" name="time_end" placeholder="종료일" readonly required/>
						</div>
						<button id="btn_modalTimeline" class="btn btn-primary">추가</button>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>


	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>