<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	/* List<Map<String,Object>> EpayWaitList = (List<Map<String,Object>>)request.getParameter("EpayWaitList"); */
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재 대기 문서</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>
<%@ include file="/WEB-INF/views/_common/header.jsp"%>
<div class="container">
<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
<div class="col-md-10">
 <form class="form-horizontal">
				<div class="page-header">
					<h1>결재 대기 문서</h1>
				</div>
           <table class="table table-condensed">
					<thead>
						<tr>
							<th width="10%">사원번호</th>
							<th width="10%">서류분류</th>
							<th width="30%">제목</th>
							<th width="10%">서류번호</th>
							<th width="10%">등록일자</th>
							<th width="10%">승인여부</th>
						</tr>
					</thead>
					<tbody>
					<%-- <%for(List<Map<String,Object>> wait : EpayWaitList){ %>
						<tr>
							<td><%=wait.get("emp_no")%></td>
							<td><%=wait.get("dtype_no")%></td>
							<td><%=wait.get("title")%></td>
							<td><%=wait.get("doc_no")%></td>
							<td><%=wait.get("path")%></td>
							<td><%=wait.get("sign_yn")%></td>
						</tr>
						<%}%> --%>
					</tbody>
				</table>
                <nav>
<div class="text-center">
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</div>
</nav>
</form>
                </div>
                </div>
<jsp:include page="/WEB-INF/views/_common/footer.jsp" />                
</body>
</html>