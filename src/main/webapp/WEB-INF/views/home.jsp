<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 홈화면</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<style>
.hero-widget { text-align: center; padding-top: 20px; padding-bottom: 20px; }
.hero-widget .icon { display: block; font-size: 96px; line-height: 96px; margin-bottom: 10px; text-align: center; }
.hero-widget var { display: block; height: 64px; font-size: 64px; line-height: 64px; font-style: normal; }
.hero-widget label { font-size: 17px; }
.hero-widget .options { margin-top: 10px; }
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />
	<div class="container">
		<div class="col-sm-4">
			<div class="hero-widget well well-sm">
				<div class="icon">
					<i class="glyphicon glyphicon-user"></i>
				</div>
				<div class="text">
					<var>인사</var>
					<label class="text-muted">Personnel</label>
				</div>
				<div class="options">
					<a href="<%=request.getContextPath() %>/per/attd/1" class="btn btn-default btn-lg"><i class="glyphicon glyphicon-search"></i> 출결내역</a>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="hero-widget well well-sm">
				<div class="icon">
					<i class="glyphicon glyphicon-shopping-cart"></i>
				</div>
				<div class="text">
					<var>상품</var>
					<label class="text-muted">Product</label>
				</div>
				<div class="options">
					<a href="<%=request.getContextPath() %>/prod/view/prodStat" class="btn btn-default btn-lg"><i class="glyphicon glyphicon-search"></i> 상품 통계</a>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="hero-widget well well-sm">
				<div class="icon">
					<i class="glyphicon glyphicon-briefcase"></i>
				</div>
				<div class="text">
					<var>상품기획</var>
					<label class="text-muted">Product Planning</label>
				</div>
				<div class="options">
					<a href="<%=request.getContextPath() %>/plan/view/propList" class="btn btn-default btn-lg"><i class="glyphicon glyphicon-search"></i> 기획서</a>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="hero-widget well well-sm">
				<div class="icon">
					<i class="glyphicon glyphicon-credit-card"></i>
				</div>
				<div class="text">
					<var>전자결재</var>
					<label class="text-muted">Draft</label>
				</div>
				<div class="options">
					<a href="<%=request.getContextPath() %>/pay/draft" class="btn btn-default btn-lg"><i class="glyphicon glyphicon-search"></i>기안서 작성</a>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="hero-widget well well-sm">
				<div class="icon">
					<i class="glyphicon glyphicon-piggy-bank"></i>
				</div>
				<div class="text">
					<var>회계</var>
					<label class="text-muted">Accounting</label>
				</div>
				<div class="options">
					<a href="<%=request.getContextPath() %>/acc/slip/in" class="btn btn-default btn-lg"><i class="glyphicon glyphicon-search"></i> 전표작성</a>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="hero-widget well well-sm">
				<div class="icon">
					<i class="glyphicon glyphicon-cog"></i>
				</div>
				<div class="text">
					<var>My</var>
					<label class="text-muted">My page</label>
				</div>
				<div class="options">
					<a href="<%=request.getContextPath() %>/scv/logout" class="btn btn-default btn-lg"><i class="glyphicon glyphicon-search"></i> 로그아웃</a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</body>
</html>