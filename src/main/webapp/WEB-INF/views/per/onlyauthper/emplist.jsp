<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>������</title>
<%@ include file="/WEB-INF/views/_common/commonUI.jsp"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn_emp").click(function(){
			$.ajax({
				url:"/tra_e_catch/emptable.ens"
				,method:"GET"
				,success:function(data){
					alert("���۽� ����");
					$("#emptable").html(data);
				}
			 ,error:function(Object){
		    	 alert("error : "+Object.responseText);
		     }
			});
			return false;
		});
	});
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/_common/header.jsp"%>
	<%-- <jsp:include page="/WEB-INF/views/_common/header.jsp" /> --%>
	<div class="col-md-12">
		<form class="form-horizontal">
		  <div class="page-header">
          <h1>������ <small>basic form</small></h1>
         </div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">�̸�</label>
				<div class="col-sm-6">
					<input class="form-control" id="inputEmail" type="email"
						placeholder="�̸�">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputPassword">�����ڵ�</label>
				<div class="col-sm-6">
					<input class="form-control" id="inputPassword" type="password"
						placeholder="�����ڵ�">
					
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputPasswordCheck">�μ��ڵ�</label>
				<div class="col-sm-6">
					<input class="form-control" id="inputPasswordCheck" type="password"
						placeholder="�μ��ڵ�">
					
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputName">�����ڵ�</label>
				<div class="col-sm-6">
					<input class="form-control" id="inputName" type="text"
						placeholder="�����ڵ�">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputNumber">�Ի�����</label>
				<div class="col-sm-6">
					<div class="input-group">
						<input type="tel" class="form-control" id="inputNumber"
							placeholder="�Ի�����" />
							
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputNumberCheck">����</label>
				<div class="col-sm-6">
					<div class="input-group">
						<input class="form-control" id="inputNumberCheck" type="text"
							placeholder="����">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">��翩��</label>
				<div class="col-sm-6">
					<input class="form-control" id="inputEmail" type="email"
						placeholder="��翩��">
				</div>
			</div>		
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">�������ٹ���</label>
				<div class="col-sm-6">
					<input class="form-control" id="inputEmail" type="email"
						placeholder="�������ٹ���">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">���̵�</label>
				<div class="col-sm-6">
					<input class="form-control" id="inputEmail" type="email"
						placeholder="���̵�">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">password</label>
				<div class="col-sm-6">
					<input class="form-control" id="inputEmail" type="email"
						placeholder="password">
				</div>
			</div>				
			</div>
			<div class="form-group">
				<div class="col-sm-12 text-center">
					<button id="btn_emp"class="btn btn-primary">
						�˻�<i class="fa fa-check spaceLeft"></i>
					</button>
					
				</div>
			</div>
			<div class="form-group" id="emptable">
				
			</div>  
		</form>
		<hr>
	</div>
</body>
</html>