<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/css/sticky-footer.css">
<link rel="stylesheet" href="/dev_jsp201809020/bootstrap/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css">
<script src="/dev_jsp201809020/bootstrap/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script src="/dev_jsp201809020/bootstrap/js/google_chart_loader.js"></script>
<script src="/dev_jsp201809020/bootstrap/js/jquery-2.2.4.min.js"></script>
<script src="/dev_jsp201809020/bootstrap/js/bootstrap.min.js"></script>
<script src="/dev_jsp201809020/bootstrap/js/moment.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
	



</script>

</head>
<body style="background-color: #f8f9fa;">
	
	<jsp:include page="/WEB-INF/views/_common/header.jsp"/>
<hr>
  <div class="container">
  
  	<jsp:include page="/WEB-INF/views/_common/header.jsp"/>
	<div class="row">
	  <div class="col-sm-10">
		<div class="panel panel-primary">
		  <div class="panel-heading">
		    <h3 class="panel-title">
		      <span class="glyphicon glyphicon-tags"></span>
				  &nbsp;&nbsp;�ŷ� ���� 
			</h3>
		   </div>
			  
				  <table class="table table-bordered responsive-table bordered">
				  	<thead>
				  		<tr>
				  			<th>��������</th>
				  			<th>��ǰ�ڵ�</th>
				  			<th>�ŷ�ó�ڵ�</th>
				  			<th>�������</th><!-- () -->
				  			<th>�����ڵ�</th><!-- (����,����...) -->
				  			<th>�ŷ���</th>
				  		</tr>
				  	</thead>
				  	<tbody>
				  		<tr>
				  			<td>2018-09-03</td>
				  			<td>102394</td>
				  			<td>steam</td>
				  			<td>����</td>
				  			<td>2367</td>
				  			<td>1</td>
				  		</tr>	
				  		<tr>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  			<td><input type="text" class="form-control " placeholder="Text input"></td>
				  		</tr>	
				  	</tbody>		
				  </table>
				  <button class="btn btn-default btn-xs" type="submit">��ȸ</button>
				  <button class="btn btn-default btn-xs" type="submit">�߰�</button>
				  <button class="btn btn-default btn-xs" type="submit">��ü ��ȸ</button>
				  <button class="btn btn-default btn-xs" type="submit">����</button>
				  <button class="btn btn-default btn-xs" type="submit">����</button>
			</div>	  
		</div>
	</div>
</div>	
	
	<jsp:include page="/WEB-INF/views/_common/header.jsp"/>
	


</body>
</html>