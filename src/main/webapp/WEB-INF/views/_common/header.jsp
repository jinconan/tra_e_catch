<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
				<span class="sr-only">네비게이션 끄기/켜기</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a href="<%=request.getContextPath()%>/" class="navbar-brand">트라E캐치</a>
		</div>
		<nav class="collapse navbar-collapse bs-navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="#">인사</a></li>
				<li><a href="#">상품</a></li>
				<li><a href="#">상품기획</a></li>
				<li><a href="#">전자결재</a></li>
				<li><a href="#">회계</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">설정</a></li>
			</ul>
		</nav>
	</div>

</header>