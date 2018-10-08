<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function() {
	
	 var empdata = $("#f_emp_no").serialize(); 
	$.ajax({
		
		url:'<%=request.getContextPath()%>/payR/epay/epayform',
		method:"GET",
		type: "json",
		data:empdata,
		success: function(log){
			console.log("테이블~~")
			console.log(log);
			$("#name").append(log[0].ENAME);//사원이름
			$("#dno").append(log[0].DNO);//서류번호
			$("#udate").append(log[0].UDATE);//서류번호
			$("#adate").append(log[0].ADATE);//서류번호
			$("#cdate").append(log[0].CDATE);//서류번호
			$("#title").append(log[0].TITLE);//서류번호
			$("#sign_no").append(log[0].SIGN_NO);//서류번호
			
			/* $("#bday").append(log[0].BDAY);//사원생년월일
			$("#tname").append(log[0].TNAME);//팀이름
			$("#clev").append(log[0].CLEV);//직급
			$("#hday").append(log[0].HDAY);//입사일자
			$("#sdate").append(log[0].SDATE);//현재일자
			$("#email").append(log[0].EMAIL);//이메일
			$("#dname").append(log[0].DNAME);//근무부서
			$("#conename").text(log[0].ENAME); */
			
		}
	}) 
	 
});


</script>
</head>
<body>
<%-- <%
String ename = String.valueOf(request.getAttribute("ename"));
String dno = String.valueOf(request.getAttribute("dtype_no"));
String udate = String.valueOf(request.getAttribute("udate"));
String adate = String.valueOf(request.getAttribute("adate"));
String cdate = String.valueOf(request.getAttribute("cdate"));
String title = String.valueOf(request.getAttribute("title"));
String sign_yn = String.valueOf(request.getAttribute("sign_yn"));
%> --%>
<form id="f_emp_no" method="post">
<%-- <input type="hidden" id="ename" value="<%=ename %>"> --%>

<table border="1"style="text-align: center; width: 600px">
		<tr>
			<td colspan="7"><div>
					<h3>기 안 서</h3>
				</div></td>
		</tr>
		<tr>
			<td width="10%">문서번호</td>
			<td width="25%"><div id="dno"></div></td>
			<td rowspan="2" width="10%">결재</td>
			<td>승인</td>
			<td>결재</td>
		</tr>
		<tr>
			<td>기안일자</td>
			<td><div id="udate"></div></td>
			<td>div</td>
			<td>div</td>
			
		</tr>
		<tr>
			<td>시행일자</td>
			<td><div id="cdate"></div></td>
			<td>기안자</td>
			<td colspan="4"><div id="name"><%-- <input id="ename" value="<%=ename%>"> --%></div></td>
		</tr>
		<tr>
			<td>결제일자</td>
			<td><div id="adate"></div></td>
			<td>참조</td>
			<td colspan="4">div</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="6"><div id="title"></div></td>
		</tr>
		<tr>
			<td colspan="8">내용</td>
		</tr>
		<tr><td colspan="8" rowspan="10" width="532" height="420"><div id="content"></div><br>
		div<br>
		div<br>
		div<br>
		div<br>
		div<br>
		div<br>
		div<br>
		div<br>
		div<br>
		div<br>
		div<br>
		div<br>
		div<br>
		div<br>
		div<br>
		
		
		</td></tr>
			</table>
			</form>
</body>
</html>