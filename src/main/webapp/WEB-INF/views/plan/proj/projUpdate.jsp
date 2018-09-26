<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int projNo = -1;
	String projName = "";
	String startDate = "";
	String endSchedDate = "";
	
	Map<String,Object> projDetail = (request.getAttribute("projDetail") != null) ? 
			(Map<String,Object>) request.getAttribute("projDetail") : null;
	
	if(projDetail != null) {
		projNo = (projDetail.containsKey("proj_no"))? ((BigDecimal)projDetail.get("proj_no")).intValue() : -1;
		projName = (projDetail.containsKey("proj_name")) ? (String)projDetail.get("proj_name") : "";
		startDate = (projDetail.containsKey("start_date")) ? (String)projDetail.get("start_date") : "";
		endSchedDate = (projDetail.containsKey("end_sched_date")) ? (String)projDetail.get("end_sched_date") : "";
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 프로젝트 변경</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
	$(function() {
		var $a = $("#submenu>li>a");
		$a.each(function(i,data) {
			var href= $(this).attr("href");
			if($(this).text().trim() == "전체 프로젝트 리스트") {
				return;
			}
			$(this).attr("href", href+"<%=projNo%>" );
		});
		
		$(".form_datetime").datetimepicker({
			format : 'yyyy-mm-dd',
			minView : 2
		});
		
		//시작일 선택하면 종료예정일은 시작일부터 활성화.
		$("#startDate").datetimepicker().on("changeDate",function(ev) {
			$("#endSchedDate").datetimepicker("setStartDate",$("#startDate").val())
		})
		
		//종료예정일 선택하면 시작일은 최대 종료예정일까지 활성화
		$("#endSchedDate").datetimepicker().on("changeDate",function(ev) {
			$("#startDate").datetimepicker("setEndDate",$("#endSchedDate").val())
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
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />

		<!-- 프로젝트 추가 폼 -->
		<div class="col-sm-10">
			<div class="well">
				<div class="row">
					<h2>
						<strong> 프로젝트 변경 </strong>
					</h2>
				</div>
				<form action="<%=request.getContextPath() %>/plan/projUpdate" method="post" class="form-horizontal">
					<input type="hidden" name="projNo" id="projNo" value="<%=projNo%>">
					<div class="form-group">
						<label for="projName" class="col-sm-2 control-label">프로젝트명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="projName" id="projName" placeholder="프로젝트명" value="<%=projName %>" required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="projPeriod" class="col-sm-2 control-label">기간</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input type="text" class="form-control form_datetime" id="startDate" name="startDate" placeholder="시작일" value="<%=startDate %>" readonly required />
								<div class="input-group-addon">~</div>
								<input type="text" class="form-control form_datetime" id="endSchedDate" name="endSchedDate" placeholder="종료예정일" value="<%=endSchedDate %>" readonly required />
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-2">
							<button class="btn btn-warning btn-block">변경</button>
						</div>
					</div>
				</form>
			</div>

		</div>


	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />

</body>
</html>