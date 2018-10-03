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
	<div class="row">
		<div class="col-sm-4">
    	    <div class="hero-widget well well-sm">
                <div class="icon">
                     <i class="glyphicon glyphicon-user"></i>
                </div>
                <div class="text">
                    <var>3</var>
                    <label class="text-muted">invited guests</label>
                </div>
                <div class="options">
                    <a href="javascript:;" class="btn btn-primary btn-lg"><i class="glyphicon glyphicon-plus"></i> Add a guest</a>
                </div>
            </div>
		</div>
        <div class="col-sm-4">
            <div class="hero-widget well well-sm">
                <div class="icon">
                     <i class="glyphicon glyphicon-star"></i>
                </div>
                <div class="text">
                    <var>614</var>
                    <label class="text-muted">page likes</label>
                </div>
                <div class="options">
                    <a href="javascript:;" class="btn btn-default btn-lg"><i class="glyphicon glyphicon-search"></i> View traffic</a>
                </div>
            </div>
		</div>
        <div class="col-sm-4">
            <div class="hero-widget well well-sm">
                <div class="icon">
                     <i class="glyphicon glyphicon-tags"></i>
                </div>
                <div class="text">
                    <var>73</var>
                    <label class="text-muted">total orders</label>
                </div>
                <div class="options">
                    <a href="javascript:;" class="btn btn-default btn-lg"><i class="glyphicon glyphicon-search"></i> View orders</a>
                </div>
            </div>
    	</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/_common/footer.jsp"/>
<%-- <jsp:include page="/WEB-INF/views/_common/messenger.jsp"/> --%>
</body>
</html>