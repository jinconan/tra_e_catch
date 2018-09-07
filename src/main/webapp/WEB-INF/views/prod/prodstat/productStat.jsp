<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/css/sticky-footer.css">
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css">
<script src="/dev_jsp201809020/bootstrap/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script src="/dev_jsp201809020/bootstrap/js/google_chart_loader.js"></script>
<script src="/dev_jsp201809020/bootstrap/js/jquery-2.2.4.min.js"></script>
<script src="/dev_jsp201809020/bootstrap/js/bootstrap.min.js"></script>
<script src="/dev_jsp201809020/bootstrap/js/moment.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Insert title here</title>

 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Sales', 'Expenses', 'Profit'],
          ['2014', 1000, 400, 200],
          ['2015', 1170, 460, 250],
          ['2016', 660, 1120, 300],
          ['2017', 1030, 540, 350]
        ]);

        var options = {
          chart: {
            title: 'Company Performance',
            subtitle: 'Sales, Expenses, and Profit: 2014-2017',
          }
        };

        var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      }
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/views/_common/header.jsp"/>

	<div class="container">
	
	 <jsp:include page="/WEB-INF/views/_common/header.jsp"/>
	 
   <div id="columnchart_material" style="width: 800px; height: 500px;"></div>
	</div>
	
	<jsp:include page="/WEB-INF/views/_common/header.jsp"/>
</body>
</html>