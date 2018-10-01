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
	int emp_no = (int)session.getAttribute("emp_no"); //사원정보 받는 곳
%>
<body>
<script type="text/javascript">
$(function() {
	$('#p_table').bootstrapTable({
		url:'<%=request.getContextPath()%>/perR/salary/<%=counts%>'
		
	});
	var base = $('#liid'+<%=num%>);
	base.addClass('active');
	
});

</script>
<jsp:include page="/WEB-INF/views/_common/header.jsp" /> <!-- 드롭다운이 안나옴... -->

<div class="container">
	<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
		<h3><b>급 여 지 급 내 역</b></h3>
	<div class="col-sm-10">
		<div class="col-sm-3">
			<jsp:include page="/WEB-INF/views/per/empinfo.jsp" /><!-- 인사 프로필 공통코드 작성해서 적용했는데 위에있는 헤더 JSP안읽히는데 충돌인건가요?
			
			 -->
		</div>


		<!-- 무죄 -->
		<div class="table-responsive col-xs-9">
				<table id="p_table" class="table table-striped table-hover">
				<thead>
					<tr>
					<!-- data-field에는 json포멧으로 데이터를 담을예정  -->
						<th width="5%" data-field="GIVE_DATE">급여지급일자</th>
						<th width="40%" data-field="NOTE">급여구분</th>
						<th width="30%" data-field="SAL">금액</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<nav>
				<ul class="pagination">
								<li><a href="<%=request.getContextPath()%>/per/salary/1" aria-label="Previous"><span
										aria-hidden="true"> << </span></a></li>
								<li><a href="<%=request.getContextPath()%>/per/salary/<%=list-1%>" aria-label="Previous"><span aria-hidden="true"> < </span></a></li>
								<li id="liid1"><a href="<%=request.getContextPath()%>/per/salary/<%=list%>"><%=list%><span class="sr-only">(current)</span></a></li>
								<li id="liid2"><a href="<%=request.getContextPath()%>/per/salary/<%=list+1%>"><%=list+1%><span class="sr-only">(current)</span></a></li>
								<li id="liid3"><a href="<%=request.getContextPath()%>/per/salary/<%=list+2%>"><%=list+2%><span class="sr-only">(current)</span></a></li>
								<li id="liid4"><a href="<%=request.getContextPath()%>/per/salary/<%=list+3%>"><%=list+3%><span class="sr-only">(current)</span></a></li>
								<li id="liid5"><a href="<%=request.getContextPath()%>/per/salary/<%=list+4%>"><%=list+4%><span class="sr-only">(current)</span></a></li>
								<li id="liid6"><a href="<%=request.getContextPath()%>/per/salary/<%=list+5%>"><%=list+5%><span class="sr-only">(current)</span></a></li>
								<li id="liid7"><a href="<%=request.getContextPath()%>/per/salary/<%=list+6%>"><%=list+6%><span class="sr-only">(current)</span></a></li>
								<li id="liid8"><a href="<%=request.getContextPath()%>/per/salary/<%=list+7%>"><%=list+7%><span class="sr-only">(current)</span></a></li>
								<li id="liid9"><a href="<%=request.getContextPath()%>/per/salary/<%=list+8%>"><%=list+8%><span class="sr-only">(current)</span></a></li>
								<li id="liid0"><a href="<%=request.getContextPath()%>/per/salary/<%=list+9%>"><%=list+9%> <span class="sr-only">(current)</span></a></li>
								<li><a href="<%=request.getContextPath()%>/per/salary/<%=list+10%>" aria-label="Previous"><span aria-hidden="true"> > </span></a></li>
								<li><a href="<%=request.getContextPath()%>/per/salary/<%=list+100%>" aria-label="Previous"><span aria-hidden="true"> >> </span></a></li>
							</ul>
			</nav>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</div>

<body>

</body>
</html>