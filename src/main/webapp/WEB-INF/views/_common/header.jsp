<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String contextPath = request.getContextPath();
	Object emp_no = session.getAttribute("emp_no");
	
%>
<!-- 맨 위 메뉴 -->
<header class="navbar" id="top" role="banner">

	<div class="container-fluid">
		<!-- 트라2캐치 홈 화면 링크 -->
		<div class="navbar-header">
			<a class="navbar-brand" href="<%=contextPath%>/">
				트라E캐치<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
			</a>
		</div>

		<!-- 상단 바 업무별 메뉴 시작 -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<!-- 인사 업무 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						인사<span class="glyphicon glyphicon-user"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath%>/per/attd/1">근태</a></li>
						<li><a href="<%=contextPath%>/per/cert">증명서 발급</a></li>
						<li><a href="<%=contextPath%>/per/salary/1">급여내역</a></li>
						<li><a href="<%=contextPath%>/per/rating/perrating">인사고과</a></li>
						<li class="divider"></li> 
						<li><a href="<%=contextPath%>/per/auth/empList" id="adminacc">인사권자 전용</a></li>
					</ul>
				</li>
				<!-- 상품 업무 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						상품<span class="glyphicon glyphicon-shopping-cart"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath%>/prod/view/prodInven/1">상품관리</a></li>
						<li><a href="<%=contextPath%>/prod/view/prodStat">상품통계</a></li>
						<li><a href="<%=contextPath%>/prod/view/prodTran/1">거래내역서</a></li>
					</ul>
				</li>
				<!-- 기획 업무 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						상품기획<span class="glyphicon glyphicon-briefcase"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath%>/plan/view/projList/all?pageNo=1 ">프로젝트 관리</a></li>
						<li><a href="<%=contextPath%>/plan/view/propList?pageNo=1">기획서 관리</a></li>
					</ul>
				</li>
				<!-- 전자결재 업무 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						전자결재<span class="glyphicon glyphicon-credit-card"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath %>/pay/draft">기안문서</a></li>
						<li><a href="<%=contextPath %>/pay/epaywait">결재목록</a></li>
					</ul>
				</li>
				<!-- 회계 업무 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						회계<span class="glyphicon glyphicon-piggy-bank"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath%>/acc/slip/1">전표처리 관리</a></li>
						<li><a href="<%=contextPath%>/acc/team/1">팀운영비 관리</a></li>
						<li><a href="<%=contextPath%>/acc/wel/1">복지지원비 조회</a></li>
					</ul>
				</li>
			</ul>
			
			<%if(emp_no != null) {%>
			<!-- 우측에 정렬된 메뉴 -->
			<ul class="nav navbar-nav navbar-right">
				<!-- 알림창 -->
				<li class="dropdown"  style="font-size: 25px">
					<a id="a_alarm" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						<span class="glyphicon glyphicon-info-sign" style="color: red;"></span>
						<span id="totalAlarm" style="color:red;"></span>
					</a>
					
					<ul class="dropdown-menu" role="menu">
					    <li><a href="<%=contextPath %>/pay/draftList">오늘 처리된 기안<span class="badge" id="b_todayChecked"></span></a></li> 
						<li><a href="<%=contextPath %>/pay/epaywait">처리 안한 기안<span class="badge" id="b_notCheck"></span></a></li>
					</ul>
				</li>
				<script>
					$("#a_alarm").click(function() {
						$.ajax({
							url:"<%=request.getContextPath()%>/payR/resetAlarm"
							,method:"post"
							,success:function(data) {
								if(data == 0) {
									alert("error");
								} else {
									$("#totalAlarm").text(0);
								}
							}
							,error:function(xhr) {
								alert("ajax error")
							}
						})
					})
				</script>
				<!-- 개인 정보 메뉴 -->
				<li class="dropdown" style="font-size: 25px">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						<span class="glyphicon glyphicon-cog"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
					    <li><a href="<%=contextPath%>/scv/view/modify">정보수정</a></li> 
						<li><a href="<%=contextPath%>/scv/logout">로그아웃</a></li>
					</ul>
				</li>
			</ul>
			<%}%>
			<form id = "Test">
			<input id = "emp_no" type = "hidden" value = '<%=emp_no%>'>
			</form>
		</div>
		<!-- 상단 바 업무별 메뉴 끝 -->
	</div>
</header>

<style>
#loading {
	width: 100%;
	height: 100%;
	top: 0px;
	left: 0px;
	position: fixed;
	display: block;
	opacity: 0.7;
	background-color: #fff;
	z-index: 99;
	text-align: center;
}

#loading-image {
	position: absolute;
	top: 50%;
	left: 50%;
	z-index: 100;
}
</style>
