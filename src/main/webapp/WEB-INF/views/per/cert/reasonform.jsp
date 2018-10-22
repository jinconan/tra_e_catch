<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

$('.c_form').click(function(){
	$('.c_form').printThis(); <!-- print 할 부분에 설정 -->
});

$(function() {
	$.ajax({
		url:'<%=request.getContextPath()%>/perR/indivemp',
		type: "json",
		success: function(data){
			$("#ename").text(data[0].ENAME);//사원이름
			$("#bday").append(data[0].BDAY);//사원생년월일
			$("#tname").append(data[0].TNAME);//팀이름
			$("#clev").append(data[0].CLEV);//직급
			$("#hday").append(data[0].HDAY);//입사일자
			$("#sdate").append(data[0].SDATE);//현재일자
			$("#lname").append(data[0].LNAME);//근무지
			
		}
	})
	 
});
</script>
</head>
<body>
	<table class="c_form" border="1" width="100%" height="1000px">
		<tr>
			<td colspan="4"><h3 align="center">시 말 서</h3></td>
		</tr>

		<tr>
			<td align="center" width="16%">성 명</td>
			<td align="center"><div id="ename"></div></td>
			<td align="center" width="14%">생년월일</td>
			<td align="center"><div id="bday"></div></td>
		<tr>
			<td align="center">부 서</td>
			<td align="center"><div id="tname"></div></td>
			<td align="center">직급</td>
			<td align="center"><div id="clev"></div></td>
		</tr>

		<tr>
			<td align="center">근무지</td>
			<td colspan="3" align="center"><div id="lname"></div></td>
		</tr>

		<tr>
			<td align="center">담당업무</td>
			<td colspan="3" align="center"><div id="d_userwork"></div></td>
		</tr>

		<tr>
			<td align="center" width="16%">재직기간</td>
			<td colspan="3" align="center"><div id="hday"></div>~ 현재&nbsp;</td>
		</tr>
		<tr>
			<td colspan="4" rowspan="40" align="center">
			  <br>
			   <br>
							  <br> <br> <br>
							  <br> <br> <br>
							  <br> <br> <br>
							  <br> <br> <br>
				  <table align="center">
				  <tr><td align="center">20&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;년  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;월 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일</td></tr>
				  <tr><td align="center"></td></tr>
				  <tr><td align="right">제&nbsp;&nbsp;출&nbsp;&nbsp;인&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(인)&nbsp;&nbsp;</td></tr>
				  </table>
				
				 </td>

		</tr>
	</table>
</body>
</html>