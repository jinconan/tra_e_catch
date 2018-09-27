<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function() {
	
	$.ajax({
		url:'<%=request.getContextPath()%>/perR/indivemp',
		type: "json",
		success: function(data){
			$("#empno").append(" "+data[0].EMP_NO);//사원이름
			$("#ename").append(data[0].ENAME);//사원이름
			$("#bday").append(" "+data[0].BDAY);//사원생년월일
			$("#tname").append(" "+data[0].TNAME);//팀이름
			$("#clev").append(" "+data[0].CLEV);//직급
			$("#hday").append(" "+data[0].HDAY);//입사일자
			$("#sdate").append(" "+data[0].SDATE);//현재일자
		}
	})
	
});

</script>

<div>
				<div class="row">
					<img src="http://thetransformedmale.files.wordpress.com/2011/06/bruce-wayne-armani.jpg" alt="" class="img-rounded img-responsive">
				</div>
				<div class="row">
					<blockquote>
						<p id="ename"></p>
						<small><cite>Seoul, Korea <i class="glyphicon glyphicon-map-marker"></i></cite></small>
					</blockquote>
				</div>
				<div class="row">
				<form id="f_empinfo" method="post"> <!-- 사원정보 받아오는 폼 -->
					<p>
					<!-- 
					$("#ename").text(data[0].ENAME);//사원이름
					$("#bday").append(data[0].BDAY);//사원생년월일
					$("#tname").append(data[0].TNAME);//팀이름
					$("#clev").append(data[0].CLEV);//직급
					$("#hday").append(data[0].HDAY);//입사일자
					$("#sdate").append(data[0].SDATE);//현재일자
					 -->
						<i class="glyphicon glyphicon-user" id="empno"></i>
						<br>
						<i class="glyphicon glyphicon-lock" id="tname"></i>
						<br>
						<i class="glyphicon glyphicon-edit" id="clev"></i>
						 <br> <i class="glyphicon glyphicon-calendar" id="hday"></i>
						 </p>
						 </form>
				</div>
			</div>
