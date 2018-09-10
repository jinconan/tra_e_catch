<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

$('.c_form').click(function(){
	alert("되니?");	
	console.log( "ready!" );
	$('.c_form').printThis(); <!-- print 할 부분에 설정 -->
});

</script>
</head>
<body>
	<table class="c_form" border="1" width="80%" height="800px">
		<tr>
			<td colspan="4"><h3 align="center">시 말 서</h3></td>
		</tr>

		<tr>
			<td align="center" width="16%">성 명</td>
			<td align="center">김위백</td>
			<td align="center" width="14%">생년월일</td>
			<td align="center">1992년01월07일</td>
		<tr>
			<td align="center">부 서</td>
			<td align="center">인사팀</td>
			<td align="center">직급</td>
			<td align="center">찌끄래기</td>
		</tr>

		<tr>
			<td align="center">현주소</td>
			<td colspan="3" align="center">경기도 과천시 과천동 513-13호</td>
		</tr>

		<tr>
			<td align="center">담당업무</td>
			<td colspan="3" align="center">화장실청소</td>
		</tr>

		<tr>
			<td align="center" width="16%">재직기간</td>
			<td colspan="3" align="center">2018-04-07 ~ 현재&nbsp;(x년xx개월)</td>
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
				  <tr><td align="center">20&nbsp;&nbsp;&nbsp;년  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;월 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일</td></tr>
				  <tr><td align="center"></td></tr>
				  <tr><td align="right">제&nbsp;&nbsp;출&nbsp;&nbsp;인&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(인)&nbsp;&nbsp;</td></tr>
				  </table>
				
				 </td>

		</tr>
	</table>
</body>
</html>