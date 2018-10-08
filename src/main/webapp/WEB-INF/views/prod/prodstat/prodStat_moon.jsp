<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<%@ include file="/WEB-INF/views/_common/loading.jsp"%>
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<%
	int counts = (Integer)request.getAttribute("counts");
	List<Map<String,Object>> list = (List<Map<String,Object>>)request.getAttribute("moon_List");
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
      title : '연도별 총 판매량 및 판매금액',	//제목
      vAxis: {title: '금액(만원),거래량(개)'},							//로우
      hAxis: {title: '월별'},							//컬럼
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
    <li><a href="<%=request.getContextPath()%>/prod/view/prodStat_ct/110/2008/0">제조사별 전체 판매량</a></li>
  </ul>
</div>

<!--------------- 버튼 드롭다운 : 월별  판매량 월별  판매 금액 --------------->
<div class="btn-group">
  	<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
    	월별 <span class="caret"></span>
  	</button>
  <ul class="dropdown-menu" role="menu">
  <%
  	if(list!=null){
  		for(Map map : list){
  			String dr = (String)map.get("DAY");
  			%>
  			<li><a href="<%=request.getContextPath()%>/prod/view/prodStat_moon/<%=dr%>"><%=dr%>년 전체판매량</a></li>
  			<%
  		}
  	}
  %>
  </ul>
</div>
<!----------------------------- 그래프 차트 ------------------------------------>
<div id="chart_div" style="width: 900px; height: 500px;">

<style>
#loading {
	width: 100%;
	height: 100%;
	top: 0px;
	left: 0px;
	position: fixed;
	display: block;
	opacity: 0.7;
	background-color: #fff;
	z-index: 99;
	text-align: center;
}

#loading-image {
	position: absolute;
	top: 50%;
	left: 50%;
	z-index: 100;
}
</style>

<script type="text/javascript">
$(window).load(function() {    
     $('#loading').hide();  
    });
</script>

	<div id="loading"><img id="loading-image" src="<%=request.getContextPath() %>/resources/imgs/ajax-loader.gif" alt="Loading..." /></div>

</div>
<!--------------------------- 페이지 네이션 처리 --------------------------------->
</div>

<!-------------------- 하단 메뉴 ------------------->
 <jsp:include page="/WEB-INF/views/_common/footer.jsp"/>
</body>
</html>