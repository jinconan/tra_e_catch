<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<title>Insert title here</title>
<script src="/resources/js/google_chart_loader.js"></script>
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Sales', 'Expenses', 'Profit'],
          ['2012', 1000, 400, 200],
          ['2013', 1170, 460, 250],
          ['2014', 660, 1120, 300],
          ['2015', 660, 1120, 300],
          ['2016', 660, 1120, 300],
          ['2017', 660, 1120, 300],
          ['2018', 1030, 540, 350]
        ]);

        var options = {
          chart: {
            
          }
        };

        var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      }
    </script>
</head>
<body>

<!----------------------- 헤더 ----------------------->
<jsp:include page="/WEB-INF/views/_common/header.jsp"/>


<!--------------------- 서브 메뉴 ---------------------->	
	
	<div class="container">
	 	<jsp:include page="/WEB-INF/views/_common/submenu.jsp"/> 
   	<div class="col-sm-10">
 <!---------------------- 제목 --------------------------> 	
  	 	<div class="page-header">
					<h1>상품 통계</h1>
			</div>
  
 <!--------------- 버튼 드롭다운 : 연도별  판매량 연도별  판매 금액 --------------->
	<div class="btn-group">
  	<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
    	년도 <span class="caret"></span>
  	</button>
  <ul class="dropdown-menu" role="menu">
    <li><a href="#">연도 전체판매량</a></li>
    <li><a href="#">연도 전체판매금액</a></li>
    <li><a href="#">연도별 최대판매량</a></li>
    <li><a href="#">연도별 최대판매금액</a></li>
    <li><a href="#">연도별 최소판매량</a></li>
    <li><a href="#">연도별 최소판매금액</a></li>
    <li class="divider"></li>
    <li><a href="#">Separated link</a></li>
  </ul>
</div>

<!--------------- 버튼 드롭다운 : 월별  판매량 월별  판매 금액 --------------->
<div class="btn-group">
  	<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
    	월별 <span class="caret"></span>
  	</button>
  <ul class="dropdown-menu" role="menu">
    <li><a href="#">월 전체판매량</a></li>
    <li><a href="#">월 전체판매금액</a></li>
    <li><a href="#">월별 최대판매상품</a></li>
    <li><a href="#">월별 최대판매상품금액</a></li>
    <li><a href="#">월별 최소판매상품</a></li>
    <li><a href="#">월별 최소판매상품금액</a></li>
    <li class="divider"></li>
    <li><a href="#">Separated link</a></li>
  </ul>
</div>

<!--------------- 버튼 드롭다운 : 상품별 최대,최소 판매량 상품별 최대,최소 판매 금액 --------------->
<div class="btn-group">
  	<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
    	상품별 <span class="caret"></span>
  	</button>
  <ul class="dropdown-menu" role="menu">
    <li><a href="#">상품별 개별 판매량 </a></li>
    <li><a href="#">상품별 개별 금액량 </a></li>
    <li><a href="#">상품별 최대 판매량 일자</a></li>
    <li><a href="#">상품별 최대 판매량 금액</a></li>
    <li><a href="#">상품별 최소 판매량 일자</a></li>
    <li><a href="#">상품별 최소 판매량 금액</a></li>
    <li class="divider"></li>
    <li><a href="#">Separated link</a></li>
  </ul>
</div>

<!----------------------------- 그래프 차트 ------------------------------------>
   <div id="columnchart_material" style="width: 800px; height: 500px;"></div>
	 
	</div>

<!--------------------------- 페이지 네이션 처리 --------------------------------->
<center>
<nav>
		<ul class="pagination">
			<li class="abled"><a href="#" aria-label="Previous"><span aria-hidden="true"> << </span></a></li>
			<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
			<li><a href="#">2 <span class="sr-only">(current)</span></a></li>
			<li><a href="#">3 <span class="sr-only">(current)</span></a></li>
			<li><a href="#">4 <span class="sr-only">(current)</span></a></li>
			<li class="abled"><a href="#" aria-label="Next"><span aria-hidden="true"> >> </span></a></li>
		</ul>
	</nav>
</div>
</center>

<!-------------------- 하단 메뉴 ------------------->
<jsp:include page="/WEB-INF/views/_common/footer.jsp"/>
</body>
</html>