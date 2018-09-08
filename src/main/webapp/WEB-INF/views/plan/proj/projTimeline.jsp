<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 타임라인</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script src="<%=request.getContextPath()%>/js/google_chart_loader.js"></script>
<script>
	google.charts.load('current', {
		'packages' : [ 'timeline' ],
		'language' : 'ko'
	});
	google.charts.setOnLoadCallback(drawChart);

	//타임라인 차트 그리기 함수
	function drawChart() {
		var container = document.getElementById('timeline');
		var chart = new google.visualization.Timeline(container);
		var dataTable = new google.visualization.DataTable();

		dataTable.addColumn({
			type : 'string',
			id : 'plan'
		});
		dataTable.addColumn({
			type : 'date',
			id : 'Start'
		});
		dataTable.addColumn({
			type : 'date',
			id : 'End'
		});
		dataTable.addRows([
			[ '전체 기간', new Date(2018, 8, 29), new Date(2018, 10, 12) ]
			, [ '화면작업', new Date(2018, 9, 3), new Date(2018, 9, 14) ]
			, [ '화면작업', new Date(2018, 9, 3), new Date(2018, 9, 14) ]
			, [ '화면작업', new Date(2018, 9, 3), new Date(2018, 9, 14) ]
		]);

		chart.draw(dataTable);
	}

	$(window).resize(function(Event) {
		drawChart();
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
			<div class="well profile">

				<div class="row">
					<h2>
						<strong>프로젝트 타임라인</strong>
						<div class="pull-right">
							<button type="button" class="btn btn-primary">추가</button>
							<button type="button" class="btn btn-primary">변경</button>
							<button type="button" class="btn btn-danger">삭제</button>
						</div>
					</h2>

				</div>

				<div class="row">
					<div id="timeline" style="height: 300px;"></div>
				</div>
			</div>

		</div>
	</div>

	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>