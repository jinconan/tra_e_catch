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
	<form id="f_update" method="post" action="<%=request.getContextPath()%>/TRAN/update">
	<input type="hidden" name = "결제코드" value="<%=getList.get("등록번호") %>">
	<table border="1" style="width: 600px;" align="center" id="printtable">
		<tr>
			<td colspan="5"><h3 align="center">거래내역 전표</h3></td>
		</tr>
		<tr>
			<td colspan="2" align="center">등록번호</td>
			<td align="center"><%=getList.get("등록번호") %></td>
			<td align="center">상품명</td>
			<td align="center"><%=getList.get("상품명") %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">회사</td>
			<td align="center"><%=getList.get("회사") %></td>
			<td align="center">담당자 전화번호</td>
			<td align="center"><%=getList.get("담당자전화번호") %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">등록일</td>
			<td colspan="3" align="center"><%=getList.get("등록일") %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">가격</td>
			<td align="center"><%=getList.get("가격") %></td>
			<td align="center">개수</td>
			<td align="center"><input type="text" name = "거래량" value="<%=getList.get("개수") %>"></td>
			
		</tr>
	</table>
	</form>
</body>
</html>