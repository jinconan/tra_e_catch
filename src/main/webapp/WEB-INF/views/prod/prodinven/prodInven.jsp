<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
</head>
<body>


<!------------- ��� ------------>
<jsp:include page="/WEB-INF/views/_common/header.jsp">
	
<!------------- ���� ------------>	
	<hr>
  <div class="container">
<!------------ ���̵� �޴� ------------>  
		<nav class="col-sm-2 nav nav-pills nav-stacked nav-pills-stacked-example">
			<li role="presentation"><a href="<%=request.getContextPath()%>/prod/inven/view/prodInven/1">��ȹ�� ����Ʈ</a></li>
			<li role="presentation" class="active"><a href="<%=request.getContextPath()%>/plan/prop/view/insertProp">��ȹ�� �ۼ�</a></li>
		</nav>
  <jsp:include page="/WEB-INF/views/_common/submenu.jsp">
	
<!------------ �߾� �Խ��� ------------>	
	<div class="row">
	  <div class="col-sm-10">
		<div class="panel panel-primary">
		  <div class="panel-heading">
		    <h3 class="panel-title">
		      <span class="glyphicon glyphicon-tags"></span>
				  &nbsp;&nbsp;��� ���� ����
			</h3>
		   </div>
			��ȸ : <input id="myInput" type="text" placeholder="Search.."><button class="btn btn-default btn-xs" type="submit">��ȸ</button>
			
			 
			 <table class="table">
				  <thead>
				  	    <tr>
				  	    	<th>��ǰ�ڵ�</th>
				  			<th>��ǰ�����ڵ�</th>
				  			<th>�������</th>
				  			<th>�Ǹſ���</th>
				  			<th>����</th>
				  			<th>����</th>
				 			<th>�ֱ� �ŷ�����</th>
				  		</tr>
				  	</thead>
				  	<tbody>
				  		<tr>
				  			<td>CRD-12</td>
				  			<td>rp-12</td>
				  			<td>2018-09-04</td>
				  			<td>�Ǹ���</td>
				  			<td>3</td>
				  			<td>19,000��</td>
				  			<td>2018-09-03</td>
				  			
				  		</tr>	
				  	</tbody>		
				  </table>
				  <button class="btn btn-default btn-xs" type="submit">�߰�</button>
				  <button class="btn btn-default btn-xs" type="submit">��ü ��ȸ</button>
				  <button class="btn btn-default btn-xs" type="submit">����</button>
				  <button class="btn btn-default btn-xs" type="submit">����</button>
			</div>	  
		</div>
	</div>
</div>	
<jsp:include page="/WEB-INF/views/_common/footer.jsp">
	
			   
</body>
</html>