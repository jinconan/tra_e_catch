<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	double remainLeave = (request.getAttribute("remainLeave") != null) ?
				(Double)request.getAttribute("remainLeave") : 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치-연차내역</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script>
	function btnLeaveMouseOut() {
		$('#btn_leave').html("남은 연차 일 수 <span class='badge'><%=remainLeave %> 일 </span>");
	}
</script>
</head>
<body>
<jsp:include page="/WEB-INF/views/_common/header.jsp" />

<div class="container">
	<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
		
	<div class="col-sm-10">
		<div class="page-header">
			<h2><strong>연 차 내  역</strong></h2>
		</div>
		<div class="col-sm-3">
			<jsp:include page="/WEB-INF/views/per/empinfo.jsp"/>
		</div>
		<div id="table-toolbar">
			 <% if(remainLeave > 0) {%>
			 <a id="btn_leave" href="<%=request.getContextPath() %>/pay/draft" class="btn btn-primary btn-lg" 
			 onmouseover="$('#btn_leave').text(' 휴&nbsp;&nbsp;가&nbsp;&nbsp;신&nbsp;&nbsp;청&nbsp;&nbsp;하&nbsp;&nbsp;기')" onmouseout="btnLeaveMouseOut()">
			 <% } else { %>
			 <a id="btn_leave" href="#" class="btn btn-danger"
			 onmouseover="$('#btn_leave').text(' 휴&nbsp;&nbsp;가&nbsp;&nbsp;신&nbsp;&nbsp;청&nbsp;&nbsp;불&nbsp;&nbsp;가')" onmouseout="btnLeaveMouseOut()">
			 <% } %>	
			 남은 연차 일 수 <span class="badge"><%=remainLeave %> 일 </span>
			</a>
		</div>
		<div class="table-responsive col-xs-9">
			<table id="p_table" class="table table-striped table-hover"
				data-toggle="table"
				data-toolbar="#table-toolbar"
				data-url="<%=request.getContextPath() %>/perR/leave"
				data-pagination="true"
				data-side-pagination="server">
				<thead>
					<tr>
					<!-- data-field에는 json포멧으로 데이터를 담을예정  -->
						<th width="20%" data-field="ANAME">휴가종류</th>
						<th width="40%" data-field="FDATE">시작일자</th>
						<th width="40%" data-field="TDATE">종료일자</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</div>

</body>
</html>