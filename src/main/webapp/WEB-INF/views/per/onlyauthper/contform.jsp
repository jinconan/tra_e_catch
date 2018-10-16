<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String emp_no = String.valueOf(request.getAttribute("emp_no"));
%>
<script type="text/javascript">
$(function() {
	
	var empdata = $("#f_emp_no").serialize();
	$.ajax({
		
		url:'<%=request.getContextPath()%>/perR/auth/contlist',
		method:"POST",
		type: "json",
		data:empdata,
		success: function(log){
			$("#ename").append(log[0].ENAME);//사원이름
			$("#bday").append(log[0].BDAY);//사원생년월일
			$("#tname").append(log[0].TNAME);//팀이름
			$("#clev").append(log[0].CLEV);//직급
			$("#hday").append(log[0].HDAY);//입사일자
			$("#sdate").append(log[0].SDATE);//현재일자
			$("#email").append(log[0].EMAIL);//이메일
			$("#dname").append(log[0].DNAME);//근무부서
			$("#conename").text(log[0].ENAME);
					}
	})
	 
});

</script>
<form id="f_emp_no" method="post">
<input type="hidden" id="emp_no" name="in_emp_no" value="<%=emp_no %>">
</form>
	<table border="1" style="width: 600px;" align="center" id="printtable1">
		<tr>
			<td colspan="5"><h3 align="center">고용계약서</h3></td>
		</tr>
		<tr>
			<td colspan="2" align="center">성명</td>
			<td align="center"><div id="ename"></div></td>
			<td align="center">이메일 주소</td>
			<td align="center"><div id="email"></div></td>
		</tr>
		<tr>
			<td colspan="2" align="center">근무지 주소</td>
			<td colspan="3" align="center">서울 특별시 어디구 어디어디 오디 554-56</td>
		</tr>

		<tr>
			<td colspan="2" align="center">소속부서</td>
			<td colspan="3" align="center"><div id="dname"></div></td>
		</tr>
		<tr>
			<td colspan="2" align="center">고용기간</td>
			<td colspan="3" align="center"><div id="hday"></div></td>
		</tr>
		<tr>
			<td colspan="2" align="center">근무시간</td>
			<td colspan="3" align="center">오전 9시 30분 부터 오후 7시 30분 까지</td>
		</tr>
		<tr>
			<td colspan="2" align="center">휴계시간</td>
			<td colspan="3" align="center">오후 12시 30분 부터 1시 30분 까지</td>
		</tr>
		<tr style="height: 600px;">
			<td colspan="5" style="vertical-align: top;"> 
			<br>&nbsp;&nbsp;&nbsp;
				<br> 
				<br>
				상기와 같이 고용계약을 체결하고 근로자는 아래 사항을 준수할 것을 약정합니다.<br>
				<br>
				<br>
				<br>
				-- 일반사항 --<br>
1. 근로자는 회사의 업무를 성실히 수행하며 회사의 이익을 위하여<br>
 &nbsp;&nbsp;&nbsp;자신의 능력을 최대한 발휘하고 회사의 규정을 준수한다.<br>
 <br>
2. 근로자는 재직 중 또는 퇴직 후에라도 회사의 기밀이나, 직무상의 중요사항을<br>
 &nbsp;&nbsp;&nbsp;무단히 타에 누설하여서는 아니된다.<br>
 <br>
3. 회사의 제한 규정을 준수하지 못하거나, 담당업무를 태만히 하였을<br>
 &nbsp;&nbsp;&nbsp;경우에는 회사는 언제든지 고용계약을 해지할 수 있다.<br>
 <br>
4. 경영상의 불가항력적 사유를 포함한 합리적 사유로<br>
 &nbsp;&nbsp;&nbsp;고용이 불가능할 때에는 고용계약기간에 불구하고 계약을 해지한다.<br>
			</td>
		</tr> 
		<tr>
			<td colspan="5"><table border="1">
			<tr>
			<td style="width: 450px;">회사명 : xxxx<br>
			주소 : 서울특별시 구로구 어디어디 어디어디<br>
			대표이사 : 강 희 복
			</td>
			<td style="width: 350px;">
			근로자 확인<br>
			성명 : <div id="conename"></div><br>
			작성일자 : 2018-10-04
			
			
			</td>
			</tr>
			</table></td>
		</tr>

	</table>
</body>
</html>