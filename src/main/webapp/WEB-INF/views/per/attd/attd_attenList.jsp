<%@page import="org.springframework.web.bind.annotation.SessionAttribute"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 홈화면</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<%-- <jsp:include page="/WEB-INF/views/_common/header.jsp" /> --%>
</head>
<%
	int counts = (Integer)request.getAttribute("counts");
	int list = (((counts-1)/10)*10)+1;
	int num = (counts%10);
%>
<body>
	<script type="text/javascript">
	 $(function() {

		$('#p_table').bootstrapTable({
			url:'<%=request.getContextPath()%>/perR/attd/<%=counts%>'
		});
		var base = $('#liid'+<%=num%>);
		base.addClass('active');
	
	}); 
		 
	</script>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<div class="container">
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
		<div class="col-sm-10">
			<div class="page-header">
				<h2>
					<strong>출 결 내 역</strong>
				</h2>
			</div>
			<div class="col-sm-3">
				<jsp:include page="/WEB-INF/views/per/empinfo.jsp" />
				
			</div>
				<div class="table-responsive col-xs-9">
				<table id="p_table" class="table table-striped table-hover">
					<thead>
						<tr>
							<!-- data-field에는 json포멧으로 데이터를 담을예정  -->
							<!-- <th width="15%" data-field="EMP_NO">사원번호</th> -->
							<th width="10%" data-field="A_DATE">일자</th>
							<th width="20%" data-field="A_TIME">출근시간</th>
							<th width="20%" data-field="L_TIME">퇴근시간</th>
							<th width="20%" data-field="TIME_CHK">출근상태</th>
							<th width="15%" data-field="TIME_ETC">퇴근상태</th>

						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
				<nav>
					<ul class="pagination">
								<li><a href="<%=request.getContextPath()%>/per/attd/1" aria-label="Previous"><span
										aria-hidden="true"> << </span></a></li>
								<li><a href="<%=request.getContextPath()%>/per/attd/<%=list-1%>" aria-label="Previous"><span aria-hidden="true"> < </span></a></li>
								<li id="liid1"><a href="<%=request.getContextPath()%>/per/attd/<%=list%>"><%=list%><span class="sr-only">(current)</span></a></li>
								<li id="liid2"><a href="<%=request.getContextPath()%>/per/attd/<%=list+1%>"><%=list+1%><span class="sr-only">(current)</span></a></li>
								<li id="liid3"><a href="<%=request.getContextPath()%>/per/attd/<%=list+2%>"><%=list+2%><span class="sr-only">(current)</span></a></li>
								<li id="liid4"><a href="<%=request.getContextPath()%>/per/attd/<%=list+3%>"><%=list+3%><span class="sr-only">(current)</span></a></li>
								<li id="liid5"><a href="<%=request.getContextPath()%>/per/attd/<%=list+4%>"><%=list+4%><span class="sr-only">(current)</span></a></li>
								<li id="liid6"><a href="<%=request.getContextPath()%>/per/attd/<%=list+5%>"><%=list+5%><span class="sr-only">(current)</span></a></li>
								<li id="liid7"><a href="<%=request.getContextPath()%>/per/attd/<%=list+6%>"><%=list+6%><span class="sr-only">(current)</span></a></li>
								<li id="liid8"><a href="<%=request.getContextPath()%>/per/attd/<%=list+7%>"><%=list+7%><span class="sr-only">(current)</span></a></li>
								<li id="liid9"><a href="<%=request.getContextPath()%>/per/attd/<%=list+8%>"><%=list+8%><span class="sr-only">(current)</span></a></li>
								<li id="liid0"><a href="<%=request.getContextPath()%>/per/attd/<%=list+9%>"><%=list+9%> <span class="sr-only">(current)</span></a></li>
								<li><a href="<%=request.getContextPath()%>/per/attd/<%=list+10%>" aria-label="Previous"><span aria-hidden="true"> > </span></a></li>
								<li><a href="<%=request.getContextPath()%>/per/attd/<%=list+100%>" aria-label="Previous"><span aria-hidden="true"> >> </span></a></li>
							</ul>
				</nav>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
	</div>


</body>
</html>