<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String contextPath = request.getContextPath();
%>
<!-- 맨 위 메뉴 -->
<header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
	<div class="container">
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
						<li><a href="<%=contextPath%>/per/cert/cert">증명서 발급</a></li>
						<li><a href="<%=contextPath%>/per/salary/1">급여관리</a></li>
						<li><a href="<%=contextPath%>/per/rating/perrating">인사고과</a></li>
						<li class="divider"></li>
						<li><a href="<%=contextPath%>/per/empList">인사권자 전용</a></li>
					</ul>
				</li>
				<!-- 상품 업무 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						상품<span class="glyphicon glyphicon-shopping-cart"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath%>/prod/view/prodInven">재고관리</a></li>
						<li><a href="<%=contextPath%>/prod/view/prodStat">상품통계</a></li>
						<li><a href="<%=contextPath%>/prod/view/prodTran">상품관리</a></li>
					</ul>
				</li>
				<!-- 기획 업무 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						상품기획<span class="glyphicon glyphicon-briefcase"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath%>/plan/view/propList?pageNo=1">기획서 관리</a></li>
						<li><a href="<%=contextPath%>/plan/view/projList/all?pageNo=1 ">프로젝트 관리</a></li>
					</ul>
				</li>
				<!-- 전자결재 업무 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						전자결재<span class="glyphicon glyphicon-credit-card"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath %>/pay/epay">기안문서</a></li>
						<li><a href="<%=contextPath %>/pay/epay/epaywait">결재목록</a></li>
					</ul>
				</li>
				<!-- 회계 업무 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						회계<span class="glyphicon glyphicon-piggy-bank"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath%>/acc/slip/1">전표처리 관리</a></li>
						<li><a href="<%=contextPath%>/acc/team">팀운영비 관리</a></li>
						<li><a href="<%=contextPath%>/acc/wel">복지지원비 조회</a></li>
					</ul>
				</li>
			</ul>
			<!-- 우측에 정렬된 메뉴 -->
			<ul class="nav navbar-nav navbar-right">
				<!-- 개인 정보 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						My<span class="glyphicon glyphicon-cog"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath%>/scv/view/modify">정보수정</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- 상단 바 업무별 메뉴 끝 -->
	</div>
</header>
