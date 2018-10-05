<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    	  List<Map<String,Object>> epaywaitList = (List<Map<String,Object>>)request.getAttribute("epaywaitList"); 
         
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재 대기 문서</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>
<%
 int emp_no = Integer.parseInt(String.valueOf(session.getAttribute("emp_no")));
 out.print("emp_no : "+emp_no);
%>
<script type="text/javascript">
$(function(){
<%-- 	$("table").bootstrapTable({
		url:'<%=request.getContextPath()%>/perR/epay/epaywait',
		queryParams: function(p){
			//데이터 요청시 넘길 파라미터를 객체 형식으로 요청
            return{
            	emp_no : '<%=emp_no%>'
            };
            <td><%=wait.get("RNO")%></td>
			<td><%=wait.get("EMP_NO")%></td>
			<td><%=wait.get("ENAME")%></td>
			<td><%=wait.get("DTYPE")%></td>
			<td><%=wait.get("TITLE")%></td>
			<td><%=wait.get("UP_DATE")%></td>
			<td><%=wait.get("SIGN_YN")%></td>
		},
		onClickRow : function(row,$element, field) {
			console.log(row.UP_DATE);
			//로우 선택시 로우에 대한 서류를 모달로 출력하는 부분.
			$("#exampleModal").modal();
		}
	}) --%>
	$("tbody tr").click(function() {
		alert($(this).find("td").eq(3).text());
		
	})
});
</script>   
<jsp:include page="/WEB-INF/views/_common/header.jsp" />
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
							<th width="5%">#</th>
							<th width="10%">사원번호</th>
							<th width="10%">사원이름</th>
							<th width="10%">서류이름</th>
							<th width="20%">제목</th>
							<th width="10%">등록일자</th>
							<th width="10%">승인여부</th>
							<th width="10%">승인여부</th>
							<th width="10%">승인여부</th>
							<th width="10%">승인여부</th>
							<th width="10%">승인여부</th>
							<th width="10%">승인여부</th>
						</tr>
					</thead>
 					<tbody>
					<%for(Map<String,Object> wait : epaywaitList){ %>
						<tr>
							<td><%=wait.get("RNO")%></td>
							<td><%=wait.get("CONFIRM_EMP_NO")%></td>
							<td><%=wait.get("ACCEPT_EMP_NO")%></td>
							<td><%=wait.get("ENAME")%></td>
							<td><%=wait.get("EMP_NO")%></td>
							<td><%=wait.get("DTNAME")%></td>
							<td><%=wait.get("TITLE")%></td>
							<td><%=wait.get("CONFIRM_DATE")%></td>
							<td><%=wait.get("ACCEPT_DATE")%></td>
							<td><%=wait.get("SIGN_YN")%></td>
							<td><%=wait.get("CONTENT")%></td>
							<td><%=wait.get("UP_DATE")%></td>
						</tr>
						<%}%>
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
                <!-- 상세내역 모달 페이지 -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document" style="width: 635px">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">고용계약서 상세페이지</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      	<div id="d_viewwork"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="printinp">Print</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
		<!-- 상세내역 모달 끝 -->
                </div>
<jsp:include page="/WEB-INF/views/_common/footer.jsp" />                
</body>
</html>