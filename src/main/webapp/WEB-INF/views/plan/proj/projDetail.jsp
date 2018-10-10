<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> projBoardList = 
	(List<Map<String,Object>>) request.getAttribute("projBoardList");

	boolean 			isLeader 		= (Boolean)request.getAttribute("isLeader");
	boolean 			isMember		= (Boolean)request.getAttribute("isMember");
	Map<String,Object>	projDetail		= (Map<String,Object>) request.getAttribute("projDetail");
	int					projNo			= ((BigDecimal)projDetail.get("proj_no")).intValue();
	String				proj_name		= (String)projDetail.get("proj_name");
	String 				pstatus_name	= (String)projDetail.get("pstatus_name");
	String 				start_date 		= (String)projDetail.get("start_date");
	String 				end_sched_date	= (String)projDetail.get("end_sched_date");
	String 				end_date 		= projDetail.containsKey("end_date") ?(String)projDetail.get("end_date") : null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 프로젝트-<%= proj_name%> </title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script src="<%=request.getContextPath()%>/js/google_chart_loader.js"></script>
<script>
	//한 프로젝트에 대한 서브메뉴의 경우에는 PK를 뒤에 붙여주어야함.
	$(document).ready(function() {
		var $a = $("#submenu>li>a");
		$a.each(function(i,data) {
			var href= $(this).attr("href");
			if($(this).text().trim() == "전체 프로젝트 리스트") {
				return;
			}
			$(this).attr("href", href+"<%=projNo%>" );
		});
		
		
		//삭제버튼 클릭 이벤트
		$("#btn_del_project").click(function() {
			var result = confirm("정말 이 프로젝트를 삭제하시겠습니까?");
			if(result == true) {
				document.forms[0].action="<%=request.getContextPath()%>/plan/projDelete?projNo=<%=projNo%>&";
				document.forms[0].method="post";
				document.forms[0].submit();
			}
		})
		
		//중단 버튼 클릭 이벤트
		$("#btn_stop").click(function() {
			document.forms[0].action="<%=request.getContextPath()%>/plan/projUpdate?projNo=<%=projNo%>&pstatusNo=3";
			document.forms[0].method="post";
			document.forms[0].submit();
		})
		
		//재개 버튼 클릭 이벤트
		$("#btn_restart").click(function() {
			document.forms[0].action="<%=request.getContextPath()%>/plan/projUpdate?projNo=<%=projNo%>&pstatusNo=1";
			document.forms[0].method="post";
			document.forms[0].submit();
		})
		
		//종료 버튼 클릭 이벤트
		$("#btn_end").click(function() {
			document.forms[0].action="<%=request.getContextPath()%>/plan/projUpdate?projNo=<%=projNo%>&pstatusNo=2&endDate="+dateToString(new Date());
			document.forms[0].method="post";
			document.forms[0].submit();
		})
		
	})
</script>
<script type="text/javascript">

	var jsonProjTimeline = null;
	$.ajax({
		url:"<%=request.getContextPath()%>/planR/json/projTimeline"
		,async:false
		,data:"projNo=<%=projNo%>&isToday=true"
		,dataType:"json"
		,success:function(data) {
			//string으로 받아온 날짜를 자바스크립트의 Date타입으로 변환.
			for(var i=0;i<data.rows.length;i++) {
				data.rows[i].c[1].v = new Date(data.rows[i].c[1].v);
				data.rows[i].c[2].v = new Date(data.rows[i].c[2].v);
			}
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
		var container = document.getElementById('timeline');
		var chart = new google.visualization.Timeline(container);

		if(jsonProjTimeline.rows.length != 0) {
			var dataTable = new google.visualization.DataTable(jsonProjTimeline);
			chart.draw(dataTable);
		}
		else {
			container.innerHTML="<p class='bg-danger'>없음</p>";
		}
	}
	
	//브라우저 크기 변경시 차트 다시 그리기
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

			<div class="well">

				<div class="row">
					<form>
						<input type="hidden" name="projNo" id="projNo" value="<%=projNo%>">
					</form>
					<h2>
						<strong><%=proj_name %></strong>
						<%if(isLeader == true) {%>
						<span class="btn-group">
							<a class="btn btn-warning" id="btn_mod_project" href="<%=request.getContextPath() %>/plan/view/projUpdate?projNo=<%=projNo %>">
									변경
							</a>
							<button type="button" id="btn_del_project" class="btn btn-danger">삭제</button>
						</span>
						<%} %>
					</h2>
					<p>
						<strong>상태: </strong>
						<%if("종료".equals(pstatus_name)) {%>
						<%=pstatus_name %>(<%=start_date %> ~ <%=end_date %>)
						<%} else {%>
						<%=pstatus_name %>(<%=start_date %> ~ <%=end_sched_date %>)
						
						<%if(isLeader == true) {%>
						<span class="btn-group">
							<%if("진행중".equals(pstatus_name)) {%>
							<a id="btn_stop" class="btn btn-info">중단</a>
							<%} else {%>
							<a id="btn_restart" class="btn btn-info">재개</a>
							<%}%>
							<a id="btn_end" class="btn btn-danger">종료</a>
						</span>
						<% 	} %>
						<%}%>
					</p>
				</div> 

				<div class="row">
					<p>
						<strong>오늘의 일정</strong>
					</p>
					<div id="timeline" style="height: 180px;"></div>
				</div>

				<%if(isMember == true) {%>
				<div class="row">
					<p>
						<strong>게시판 목록</strong>
					</p>
					<%
					if(projBoardList != null) {
						for(int i=0; i<projBoardList.size();i++) {
							String board_name = (String)projBoardList.get(i).get("board_name");
							BigDecimal board_no = (BigDecimal)projBoardList.get(i).get("board_no");
					%>
					<div class="col-sm-4">
						<div class="well">
							<h4><%=board_name %></h4>
							<a class="btn btn-xs btn-update btn-add-card btn-success" role="button"
								href="<%=request.getContextPath() %>/plan/view/diyBoardList?projNo=<%= projNo%>&boardNo=<%=board_no%>&pageNo=1">들어가기</a>
						</div>
					</div>	
					<%
						}
					}
					%>
				</div>
				<%} %>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>