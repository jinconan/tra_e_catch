<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<%
	int counts = (Integer)request.getAttribute("counts");
%>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        
        var jsonData = $.ajax({
        	url:"<%=request.getContextPath()%>/proR/prodStat_moon/<%=counts%>",
        	dateType:"json",
        	async:false
        }).responseText;
        
    var data = new google.visualization.DataTable(jsonData);
    var options = {
      title : '전체 총 판매량 및 판매금액',	//제목
      vAxis: {title: '금액(만원),거래량(개)'},							//로우
      hAxis: {title: '연도'},							//컬럼
      seriesType: 'bars',								
      series: {0: {type: 'line'}}
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
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat">연도별 전체 판매량</a></li>
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat_moon/2008">월별 전체 판매량</a></li>
    <li class="divider"></li>
    <li><a href="#">제조사별 전체 판매량</a></li>
    <li><a href="#">상품별 전체 판매량</a></li>
  </ul>
</div>

<!--------------- 버튼 드롭다운 : 월별  판매량 월별  판매 금액 --------------->
<div class="btn-group">
  	<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
    	월별 <span class="caret"></span>
  	</button>
  <ul class="dropdown-menu" role="menu">
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat_moon/2008">2008년 전체판매량</a></li>
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat_moon/2009">2009년 전체판매량</a></li>
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat_moon/2010">2010년 전체판매량</a></li>
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat_moon/2011">2011년 전체판매량</a></li>
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat_moon/2012">2012년 전체판매량</a></li>
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat_moon/2013">2013년 전체판매량</a></li>
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat_moon/2014">2014년 전체판매량</a></li>
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat_moon/2015">2015년 전체판매량</a></li>
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat_moon/2016">2016년 전체판매량</a></li>
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat_moon/2017">2017년 전체판매량</a></li>
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat_moon/2018">2018년 전체판매량</a></li>
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