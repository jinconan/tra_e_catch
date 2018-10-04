<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String lev_no = request.getParameter("lev_no").toString();
String name = request.getParameter("name").toString();
String dept_no = request.getParameter("dept_no").toString();
%>

	<script type="text/javascript">
$(function() {

	$('#p_table').bootstrapTable({
		
		url:'<%=request.getContextPath()%>/perR/only/emplist',
		queryParams: function(p){
            return{
            	lev_no : '<%=lev_no%>',
            	name : '<%=name%>',
            	dept_no : '<%=dept_no%>'
            
            };
		}

	});
});

</script>
	<div class="container">
		<%@ include file="/WEB-INF/views/_common/submenu.jsp"%>
		<div class="col-md-10">
			<table class="table table-striped" id="p_table">
				<thead>
					<tr>
							<th width="10%">사원번호</th>
							<th width="10%">서류분류</th>
							<th width="30%">내용</th>
							<th width="10%">서류번호</th>
							<th width="10%">등록일자</th>
							<th width="10%">승인여부</th>
				     </tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<nav>
				<div class="text-center">
	
				</div>
			</nav>
		</div>
	</div>
