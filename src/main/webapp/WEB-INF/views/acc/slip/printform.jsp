<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Map<String, Object> getList = (Map<String, Object>)request.getAttribute("getList");
%>
	<table border="1" style="width: 600px;" align="center" id="printtable">
		<tr>
			<td colspan="5"><h3 align="center">사내결제 전표</h3></td>
		</tr>
		<tr>
			<td colspan="2" align="center">번호</td>
			<td align="center"><%=getList.get("번호") %></td>
			<td align="center">작성자</td>
			<td align="center"><%=getList.get("작성자") %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">분류</td>
			<td align="center"><%=getList.get("분류") %></td>
			<td align="center">구분</td>
			<td align="center"><%=getList.get("구분") %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">적요</td>
			<td colspan="3" align="center"><%=getList.get("적요") %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">금액</td>
			<td align="center"><%=getList.get("금액") %></td>
			<td align="center">결제방식</td>
			<td align="center"><%=getList.get("증빙") %></td>
		</tr>
	</table>
</body>
</html>