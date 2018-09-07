<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>
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

$(function () {
$('#p_table').bootstrapTable({
    data: mydata
});
});
</script>

<div class="table-responsive col-xs-8">
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
</body>
</html>