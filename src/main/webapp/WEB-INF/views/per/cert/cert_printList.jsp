<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<div class="table-responsive col-xs-10">
				<table id="p_table" class="table table-striped table-hover">
					<thead>
						<tr>
							<!-- data-field에는 json포멧으로 데이터를 담을예정  -->
							<th width="5%" data-field="C_DATE">일자</th>
							<th width="20%" data-field="C_NAME">구분</th>
							<th width="30%" data-field="C_TYPE">제출용도</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				</div>
				
				
				
<script type="text/javascript">





$('#p_table').bootstrapTable({
	url:'<%=request.getContextPath()%>/perR/certlist'
});

</script>