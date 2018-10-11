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
	<%-- 	<%@ include file="/WEB-INF/views/_common/submenu.jsp"%> --%>
		<div class="col-md-10">
			<table class="table table-striped" id="p_table">
				
				<thead>
					<tr>
						<!-- 김훈태 작업중  -->
						    <th width="10%" data-field="NAME">이름</th>
							<th width="11%" data-field="HIRE_DATE">입사일자</th>
							<th width="11%" data-field="LEV_NO">직급코드</th>
							<th width="11%" data-field="DEPT_NO">부서코드</th>
							<th width="11%" data-field="LOC_NO">지역코드</th>
							<th width="11%" data-field="BIRTHDAY">생일</th>
							<th width="11%" data-field="EMAIL">이메일</th>
							<th width="11%" data-field="TEAM_NO">팀코드</th>
							
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
