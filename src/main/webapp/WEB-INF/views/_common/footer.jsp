<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>


<%if(session != null && session.getAttribute("emp_no") != null) {%>
	<jsp:include page="/WEB-INF/views/_common/messenger.jsp"/>	
<%}%>

<footer>
	<div class="container-fluid">
		<p class="navbar-text pull-left">© 2018 - Site Built By No.2 Team Tra E Catch</p>
		<span class="pull-right"> 
				<a href="https://github.com/jinconan/tra_e_catch" class="navbar-btn btn-success btn">
				<span class="glyphicon glyphicon-star"></span>  github
			</a> 
			<!-- 메신저창 온오프 버튼 --> 
			<%if(session != null && session.getAttribute("emp_no") != null) {%>
			<a href="javascript:toggleMessenger()" class="navbar-btn btn btn-primary pull-right">메신저창</a>
			<%}%>
		</span>
	</div>
</footer>
