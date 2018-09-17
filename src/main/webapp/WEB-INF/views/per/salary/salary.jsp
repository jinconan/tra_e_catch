<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 홈화면</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<%-- <jsp:include page="/WEB-INF/views/_common/header.jsp" /> --%>
</head>
<body>
<script type="text/javascript">
var $table = $('#p_table');

var mydata = 
 [
	{
	    "p_date": "2018-09-04",
	    "p_cla": "월급여",
	    "p_pay": "$9977"
	},{
	    "p_date": "2018-08-04",
	    "p_cla": "월급여",
	    "p_pay": "$9977"
	},{
	    "p_date": "2018-07-04",
	    "p_cla": "월급여",
	    "p_pay": "$9977"
	},{
	    "p_date": "2018-06-04",
	    "p_cla": "월급여",
	    "p_pay": "$9977"
	},{
	    "p_date": "2018-05-04",
	    "p_cla": "월급여",
	    "p_pay": "$9977"
	},{
	    "p_date": "2018-04-04",
	    "p_cla": "월급여",
	    "p_pay": "$9977"
	},{
	    "p_date": "2018-03-04",
	    "p_cla": "월급여",
	    "p_pay": "$9977"
	},{
	    "p_date": "2018-02-04",
	    "p_cla": "월급여",
	    "p_pay": "$9977"
	}
]; 

$(function () {
$('#p_table').bootstrapTable({
    data: mydata
    /* url:'/per/salary/salaryjson' */ //json포멧으로 받는 url은 해당 컨트롤러에서 담당.
});
});

</script>
<jsp:include page="/WEB-INF/views/_common/header.jsp" />

<div class="container">
	<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
		<h3><b>급 여 관 리</b></h3>
	<div class="col-sm-10">
		<div class="col-sm-3">
			<div class="row">
				<img src="http://thetransformedmale.files.wordpress.com/2011/06/bruce-wayne-armani.jpg" alt="" class="img-rounded img-responsive">
			</div>
			<div class="row">
				<blockquote>
					<p>WeBack Kim</p>
					<small><cite>Seoul, Korea <i class="glyphicon glyphicon-map-marker"></i></cite></small>
				</blockquote>
			</div>
			<div class="row">
				<p>
					<i class="glyphicon glyphicon-user"></i> 18-111111 <br>
					 <i class="glyphicon glyphicon-lock"></i> 인사팀<br>
					 <i class="glyphicon glyphicon-edit"></i> 부장 <br>
					 <i class="glyphicon glyphicon-calendar"></i> 2018-09-04<br>
					  <i class="glyphicon glyphicon-time"></i> 0년차
				</p>
			</div>
		</div>


		<!-- 무죄 -->
		<div class="table-responsive col-xs-9">
			<table id="p_table" class="table table-striped table-hover">
				<thead>
					<tr>
					<!-- data-field에는 json포멧으로 데이터를 담을예정  -->
						<th width="5%" data-field="p_date">급여지급일자</th>
						<th width="40%" data-field="p_cla">급여구분</th>
						<th width="30%" data-field="p_pay">금액</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<nav>
				<ul class="pagination">
					<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true"> << </span></a></li>
					<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
					<li><a href="#">2 <span class="sr-only">(current)</span></a></li>
					<li><a href="#">3 <span class="sr-only">(current)</span></a></li>
					<li><a href="#">4 <span class="sr-only">(current)</span></a></li>
				</ul>
			</nav>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/_common/footer.jsp" />
</div>

<body>

</body>
</html>