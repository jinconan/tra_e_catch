<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<div class="table-responsive col-xs-10">
				<table id="p_table" class="table table-striped table-hover">
					<thead>
						<tr>
							<!-- data-field에는 json포멧으로 데이터를 담을예정  -->
							<th width="5%" data-field="a_date">일자</th>
							<th width="20%" data-field="a_cla">구분</th>
							<th width="30%" data-field="a_use">제출용도</th>
							<th width="30%" data-field="a_conf">승인여부</th>
							<th width="15%" data-field="a_print">출력</th>

						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				</div>
				
				
				
<script type="text/javascript">
var $table = $('#p_table');
var mydata = 
[
	{
	
	    		"a_date"   :"2018-09-07",
	    		"a_cla"    :"재직증명서",
	    		"a_use"    :"은행제출용",
	    		"a_conf"   :"Y",
	    		"a_print"  :"Y"
	}
];


$('#p_table').bootstrapTable({
    data: mydata
});

</script>