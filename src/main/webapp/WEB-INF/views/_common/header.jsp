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

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						인사<span class="glyphicon glyphicon-user"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
							<li><a href="<%=contextPath%>/per/attd/attlist">근태</a></li>
						<li><a href="<%=contextPath%>/per/cert/cert">증명서 발급</a></li>
						<li><a href="<%=contextPath%>/per/salary/salaryList">급여관리</a></li>
						<li><a href="<%=contextPath%>/per/rating/perrating">인사고과</a></li>
						<li class="divider"></li>
						<li><a href="<%=contextPath%>/per/empList">인사권자 전용</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						상품<span class="glyphicon glyphicon-shopping-cart"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">작업지시서</a></li>
						<li><a href="#">재고관리</a></li>
						<li><a href="#">상품통계</a></li>
						<li><a href="#">상품관리</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						상품기획<span class="glyphicon glyphicon-briefcase"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath%>/plan/prop/view/list/1">기획서 관리</a></li>
						<li class="divider"></li>
						<li><a href="<%=contextPath%>/plan/proj/view/list/1 ">프로젝트 관리</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						전자결재<span class="glyphicon glyphicon-credit-card"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath %>/pay/epay">전자결재관리</a></li>
						<li class="divider"></li>
						<li><a href="#">결재권자 설정</a></li>
						<li><a href="<%=contextPath %>/pay/orgchart">조직도</a>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						회계<span class="glyphicon glyphicon-piggy-bank"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath %>/acc/tempexp">팀운영비</a></li>
						<li><a href="<%=contextPath %>/acc/slip">전표</a></li>
						<li><a href="<%=contextPath %>/acc/wel">복지지원비</a></li>
						<li><a href="<%=contextPath %>/acc/tax">세금관리</a></li>
					</ul></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						My<span class="glyphicon glyphicon-cog"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=contextPath%>/scv/view/login">로그인</a></li>
						<li><a href="<%=contextPath%>/scv/view/join">직원등록</a></li>
						<li><a href="<%=contextPath%>/scv/view/modify">정보수정</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</header>
