<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//프로젝트 번호
	int projNo = (Integer) request.getAttribute("projNo");
	//게시판 리스트 받아오기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 정보</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
	//한 프로젝트에 대한 서브메뉴의 경우에는 PK를 뒤에 붙여주어야함.
	$(document).ready(function() {
		var $a = $("#submenu>li>a");
		
		$a.each(function(i,data) {
			var href= $(this).attr("href");
			console.log("before : " + href);
			$(this).attr("href", href+"/${projNo}" );
			var href= $(this).attr("href");
			console.log("after : " + href);
		});
	})
</script>
<script type="text/javascript">
	google.charts.load('current', {
		'packages' : [ 'timeline' ]
		,'language': 'ko'
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
			<!--  
		멤버 리스트, 	기간(진행중인 경우 : 시작~종료 예정, 그외 : 시작 ~종료), 소스 URL, 사용플랫폼, 게시판 리스트
		게시판 생성은 팀장만 가능, 테스트 리스트 게시판(테스트 종류, 기간, 인원,첨부자료 유무), 각 테스트마다  n개의 첨부자료.
		테스트 일정을 달력으로 출력해도 좋을듯. 
		-->
			<div class="well profile">

				<div class="row">
					<h2>
						<strong>엽문</strong>
					</h2>
					<p>
						<strong>상태: </strong> 진행중(2018.04.17 ~ 2018.10.26)
					</p>
					<p>
						<strong>플랫폼: </strong> <span class="tags">PS4</span> <span class="tags">PC</span>
					</p>
				</div>

				<div class="row">
					<p>
						<strong>오늘의 일정</strong>
					</p>
					<div id="timeline" style="height: 180px;"></div>
				</div>

				<div class="row">
					<p>
						<strong>게시판</strong>
					</p>
					<div class="col-sm-3">
						<div class="thumbnail">
							<div class="well">
								<h4>게시판1</h4>
								<button type="button" class="btn btn-primary btn-xs btn-update btn-add-card">들어가기</button>
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="thumbnail">
							<div class="well">
								<h4>게시판2</h4>
								<button type="button" class="btn btn-primary btn-xs btn-update btn-add-card">들어가기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>