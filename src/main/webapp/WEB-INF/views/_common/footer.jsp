<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>


<jsp:include page="/WEB-INF/views/_common/messenger.jsp"/>
<footer class="navbar navbar-default navbar-fixed-bottom">
	<div class="container-fluid">
		<p class="navbar-text pull-left">© 2018 - Site Built By No.2 Team Tra E Catch</p>
		<span class="pull-right"> 
				<a href="https://github.com/jinconan/tra_e_catch" class="navbar-btn btn-success btn">
				<span class="glyphicon glyphicon-star"></span>  github
			</a> 
			<!-- 메신저창 온오프 버튼 --> 
			<a href="javascript:$('#d_messenger').toggle()" class="navbar-btn btn btn-primary pull-right">메신저창</a>
		</span>
	</div>
</footer>