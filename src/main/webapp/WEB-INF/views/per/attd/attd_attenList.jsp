<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트라E캐치 홈화면</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<%-- <jsp:include page="/WEB-INF/views/_common/header.jsp" /> --%>
</head>
<body style="margin-top: 30px">
	<script type="text/javascript">
		var $table = $('#p_table');
		var mydata = [
			{	"EMP_NO" : "1",
				"a_date" : "2018-08-08",
				"a_time" : "08:59",
				"l_time" : "23:50",
				"a_cla" : "정상출근",
				"a_etc" : "야근"
			},
			{
				"a_date" : "2018-08-09",
				"a_cla" : "출근",
				"a_swork" : "10:59",
				"a_ework" : "19:50",
				"a_etc" : "지각"
			},
			{
				"a_date" : "2018-08-10",
				"a_cla" : "출근",
				"a_swork" : "09:31",
				"a_ework" : "19:00",
				"a_etc" : "지각"
			},
			{
				"a_date" : "2018-08-08",
				"a_cla" : "출근",
				"a_swork" : "10:12",
				"a_ework" : "18:59",
				"a_etc" : "지각, 조기퇴근"
			}
		];
	
		$(function() {
			$('#p_table').bootstrapTable({
				data : mydata
			});
		});
	</script>
	<jsp:include page="/WEB-INF/views/_common/header.jsp" />

	<div class="container">
		<jsp:include page="/WEB-INF/views/_common/submenu.jsp" />
		<h3>
			<b>출 결 관 리</b>
		</h3>
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
						<i class="glyphicon glyphicon-user"></i> 18-111111 <br> <i class="glyphicon glyphicon-lock"></i> 인사팀<br> <i class="glyphicon glyphicon-edit"></i> 부장 <br> <i class="glyphicon glyphicon-calendar"></i> 2018-09-04<br> <i class="glyphicon glyphicon-time"></i> 0년차
					</p>
				</div>
			</div>


			<!-- 무죄 -->
			<div class="table-responsive col-xs-9">
				<table id="p_table" class="table table-striped table-hover">
					<thead>
						<tr>
							<!-- data-field에는 json포멧으로 데이터를 담을예정  -->
							<th width="5%" data-field="EMP_NO">사원번호</th>
							<th width="5%" data-field="a_date">일자</th>
							<th width="30%" data-field="a_time">출근시간</th>
							<th width="30%" data-field="l_time">퇴근시간</th>
							<th width="20%" data-field="time_chk">출근상태</th>
							<th width="15%" data-field="time_etc">퇴근상태</th>

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