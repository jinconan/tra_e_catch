<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        
        var jsonData = $.ajax({
        	url:"<%=request.getContextPath()%>/proR/slip/test",
        	dateType:"json",
        	async:false
        }).responseText;
        
    var data = new google.visualization.DataTable(jsonData);
    var options = {
      title : '연도별 총 판매량 및 판매금액',	//제목
      vAxis: {title: '금액(천원),거래량(개)'},							//로우
      hAxis: {title: '연도'},							//컬럼
      seriesType: 'bars',								
      series: {5: {type: 'line'}}
    };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
    chart.draw(data, options);
  }
    </script>

	

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
<div id="chart_div" style="width: 900px; height: 500px;"></div>
<!--------------------------- 페이지 네이션 처리 --------------------------------->
</div>

<!-------------------- 하단 메뉴 ------------------->
 <jsp:include page="/WEB-INF/views/_common/footer.jsp"/>
</body>
</html>