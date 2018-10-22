<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	StringBuilder path = new StringBuilder(request.getContextPath());
	path.append("/resources");
%>
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
			
		}
	})
	 
});
</script>
</head>
<body>
	<table class="c_form" border="1" width="100%" height="1000px">
		<tr>
			<td colspan="4"><h3 align="center">사 직 서</h3></td>
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
			<td align="center">담당업무</td>
			<td colspan="3" align="center"><div id="d_userwork"></div></td>
		</tr>

		<tr>
			<td align="center" width="16%">재직기간</td>
			<td colspan="3" align="center"><div id="hday"></div> ~ 현재&nbsp;(x년xx개월)</td>
		</tr>
		<tr><td align="center" colspan="4">퇴직 사유</td>
		</tr>
		<tr>
			<td colspan="4" rowspan="40" align="center">
			   
			  <br>
			   <br>
			   <br>
				 <br> <br> 
				 <br> <br> <br>
				  <br>
				   <br>
				   
				  <br> 상기 본인은 위와 같은 사유로 인하여 사직서를 제출하오니 허락하여 주시기 바랍니다. <br> <br>
				  <br>
				  <br>
				  <br>
				  <table align="center">
				  <tr><td align="center">20&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;년  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;월 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일</td></tr>
				  <tr><td align="center"></td></tr>
				  <tr><td align="right">제&nbsp;&nbsp;출&nbsp;&nbsp;인&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(인)&nbsp;&nbsp;</td></tr>
				  </table>
				  <br>
				  <br>
				  <table align="right">
				 <tr><td align="right">서울특별시 강남구 논현로 54&nbsp;&nbsp;&nbsp;</td></tr>
				 <tr><td align="right">주식회사 트라이캐치&nbsp;&nbsp;&nbsp;</td></tr>
				 <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
				 <tr><td>대표이사 강희복 <span style="position: relative;">(인) <span style="position: absolute; left:-15px; top: -20px;"><img src="<%=path.toString()%>/imgs/intest.png" style="width: 75px; height: 75px;"></span></span>&nbsp;&nbsp;&nbsp;</td>
				 
				 </tr>
				 
				 </table>
				 <br>   
				 <br>   
				 <br>   
				 </td>

		</tr>
	</table>
</body>
</html>