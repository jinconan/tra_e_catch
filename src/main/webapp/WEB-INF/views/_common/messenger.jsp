<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="d_messenger" class="panel panel-info"" style="position: fixed; width: 300px; height: 100%; top: 0px; right: 0px;">
	<div class="panel-heading"><h6>${sessionScope.emp_name}</h6></div>
	<div style="height:100%;overflow:auto;">
		<ul id="online_list" class="list-group">
			<li class="list-group-item" onclick="selectEmp($(this))">
				<span class="emp_no" style="display:none;">1</span>
				<span class="emp_level">인턴</span>
				<span class="emp_name">홍길동</span>
				<span class="emp_id">(test)</span>
			</li>
		</ul>
	</div>
</div>
<div id="d_chat" class="panel panel-info" style="position: fixed; width: 300px; height: 50%; bottom: 0px; right: 300px;">
	<input type="hidden" class="emp_no"    />
	<input type="hidden" class="emp_level" /> 
	<input type="hidden" class="emp_name"  /> 
	<input type="hidden" class="emp_id"    /> 
	
	<div class="panel-heading"></div>
	<div class="panel-body">
		<div style="overflow:auto; height: 250px; top: 0px; right: 0px;">
			<ul class="list-grouplist-group">
				<li class="list-group-item">
					<span>홍길동</span>&gt;<span>hi</span><span>2018-10-04 11:11:11</span> 
				</li>
			</ul>
		</div>
		
		<!-- /input-group -->
	</div>
	<div class="input-group">
		<label for="chat_content" class="sr-only control-label">입력창</label>
		<input type="text" id="chat_content" class="form-control"> 
		<span class="input-group-btn">
			 <button id="btn_sendchat" class="btn btn-default" type="button">전송</button>
		</span>
	</div>
</div>
<a href="javascript:$('#d_messenger').toggle()" class="btn btn-primary" style="position:fixed; bottom:55px;">메신저창</a>
<script src=" <%=request.getContextPath()%>/resources/js/sockjs.min.js"></script>
<script>

	var wsocket = new SockJS("/tra_e_catch/echo-ws");
	wsocket.onopen = function() {
        console.log("연결되었습니다.");
    }
	wsocket.onmessage = function (evt) {
        var data = JSON.parse(evt.data);
        console.log(data);
        
        switch(data.mtype) {
        case "open":
        	$("#online_list").append("<li class='list-group-item'>"
    				+"<span class='emp_no' style='display:none;'>"+data.emp_no+"</span>"
    				+"<span class='emp_level'>"+data.emp_level+"</span>"
    				+"<span class='emp_name'>"+data.emp_name+"</span>"
    				+"<span class='emp_id'>("+data.emp_id+")</span></li>");
        	break;
        case "close":
        	//$("#online_list").
        	break;
        case "clog":
        	$("#d_chat .list-grouplist-group").text("");
        	break;
        case "chat":
        	//현재 열린 창에서의 대화인 경우 출력. 아닌경우 출력X.
        	var another = $("#d_chat").find(".emp_no").val();
        	if(another == data.from || another == data.to) {
        		var c = "<li class='list-group-item' onclick='selectEmp($(this))'><span>"+$("#d_chat").find(".emp_name").val()+"</span>&gt;<span>"+data.content+"</span>&nbsp;<span>"+data.timestamp+"</span></li>"
        		$("#d_chat .list-grouplist-group").append(c);
        	}
        	break;
        }
        
    }
	wsocket.onclose = function () {
        console.log("연결끊김");
    }
	
	//채팅 전송
	$("#btn_sendchat").click(function() {
		var content = $("#chat_content").val();
		var msg = {
			mtype:"chat" 
			,from: ${sessionScope.emp_no}
			,to:Number($("#d_chat").find(".emp_no").val())
			,content:content
		}
		wsocket.send(JSON.stringify(msg));
	})
	
	//사람 선택
	function selectEmp($obj) {
		$("#d_chat").show();
		$("#d_chat").find(".emp_no").val($obj.find(".emp_no").text());
		$("#d_chat").find(".emp_level").val($obj.find(".emp_level").text());
		$("#d_chat").find(".emp_name").val($obj.find(".emp_name").text());
		$("#d_chat").find(".emp_id").val($obj.find(".emp_id").text());
		
		$("#d_chat .panel-heading").html($("#d_chat").find(".emp_name").val()+$("#d_chat").find(".emp_id").val());
		var msg= { 
			mtype:"clog"
			,from: ${sessionScope.emp_no}
			,to : Number($("#d_chat").find(".emp_no").val())
		}
		console.log(msg);
		wsocket.send(JSON.stringify(msg));
	}
</script>