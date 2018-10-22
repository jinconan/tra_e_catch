<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <style>
    /* USER PROFILE PAGE */
 .card {
    margin-top: 20px;
    padding: 30px;
    background-color: rgba(214, 224, 226, 0.2);
    -webkit-border-top-left-radius:5px;
    -moz-border-top-left-radius:5px;
    border-top-left-radius:5px;
    -webkit-border-top-right-radius:5px;
    -moz-border-top-right-radius:5px;
    border-top-right-radius:5px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.card.hovercard {
    position: relative;
    padding-top: 0;
    overflow: hidden;
    text-align: center;
    background-color: #fff;
    background-color: rgba(255, 255, 255, 1);
}
.card.hovercard .card-background {
    height: 160px;
}
.card-background img {
    -webkit-filter: blur(25px);
    -moz-filter: blur(25px);
    -o-filter: blur(25px);
    -ms-filter: blur(25px);
    filter: blur(25px);
    margin-left: -100px;
    margin-top: -200px;
    min-width: 130%;
}
.card.hovercard .useravatar {
    position: absolute;
    top: 15px;
    left: 0;
    right: 0;
}
.card.hovercard .useravatar img {
    width: 125px;
    height: 125px;
    max-width: 125px;
    max-height: 125px;
    -webkit-border-radius: 50%;
    -moz-border-radius: 50%;
    border-radius: 50%;
    border: 5px solid rgba(255, 255, 255, 0.5);
}
.card.hovercard .card-info {
    position: absolute;
    bottom: 14px;
    left: 0;
    right: 0;
}
.card.hovercard .card-info .card-title {
    padding:0 5px;
    font-size: 20px;
    line-height: 1;
    color: #262626;
    background-color: rgba(255, 255, 255, 0.1);
    -webkit-border-radius: 4px;
    -moz-border-radius: 4px;
    border-radius: 4px;
}
.card.hovercard .card-info {
    overflow: hidden;
    font-size: 12px;
    line-height: 20px;
    color: #737373;
    text-overflow: ellipsis;
}
.card.hovercard .bottom {
    padding: 0 20px;
    margin-bottom: 17px;
}
.btn-pref .btn {
    -webkit-border-radius:0 !important;
}

    
    </style>
<script type="text/javascript">

$(function() {
	var sessemp_no = <%=session.getAttribute("emp_no")%> //사원번호 저장.
	
		$(".btn-pref .btn").click(function () {
		    $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
		    // $(".tab").addClass("active"); // instead of this do the below 
		    $(this).removeClass("btn-default").addClass("btn-primary");   
		});
	$.ajax({
		url:'<%=request.getContextPath()%>/perR/indivemp',
		type: "json",
		success: function(data){
			$("#empno").append(" "+data[0].EMP_NO);//사원번호
			$("#ename").append(data[0].ENAME);//사원이름
			$("#bday").append(" "+data[0].BDAY);//사원생년월일
			$("#tname").append(" "+data[0].TNAME);//팀이름
			$("#clev").append(" "+data[0].CLEV);//직급
			$("#hday").append(" "+data[0].HDAY);//입사일자
			$("#sdate").append(" "+data[0].SDATE);//현재일자
		}
	});
	
});

		
function attdok(){
	alert("정상 출근 되었습니다.");
	
	/* <input type="hidden" id="attSelect" name="attSelect"/> */
	$("#attSelect").val($("#attok").val())
	$("#f_attdchk").attr("action","../attdinsert");
	$("#f_attdchk").submit(); 
}
function attdexit(){
	alert("정상 퇴근 처리되었습니다.");
	$("#attSelect").val($("#attexit").val())
	$("#f_attdchk").attr("action","../attdinsert");
	$("#f_attdchk").submit(); 
	
}
	

</script>

<div class="row">
	<div class="card hovercard" style="background: linear-gradient( to bottom, #f0ad4e, #ffffff)">
		<div class="card-background"></div>
		<div class="useravatar">
			<img alt="" src="<%=request.getContextPath()%>/imgs/profile/<%=((BigDecimal)session.getAttribute("emp_no")).intValue()%8+1 %>.png">
		</div>
		<div class="card-info">
			<span class="card-title" id="ename"></span>

		</div>
	</div>
	<div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="...">
		<div class="btn-group" role="group">
			<button type="button" id="stars" class="btn btn-primary" href="#tab1" data-toggle="tab">
				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
				<div class="hidden-xs">사원정보</div>
			</button>
		</div>
		<div class="btn-group" role="group">
			<button type="button" id="following" class="btn btn-default" href="#tab3" data-toggle="tab">
				<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
				<div class="hidden-xs">출결버튼</div>
			</button>
		</div>
	</div>

	<div class="well">
		<div class="tab-content">
			<div class="tab-pane fade in active" id="tab1">
				<i class="glyphicon glyphicon-user" id="empno"></i> <br> 
				<i class="glyphicon glyphicon-lock" id="tname"></i> <br> 
				<i class="glyphicon glyphicon-edit" id="clev"></i> <br> 
				<i class="glyphicon glyphicon-calendar" id="hday"></i>
			</div>

			<div class="tab-pane fade in" id="tab2">
				<h3>This is tab 2</h3>
			</div>
			<div class="tab-pane fade in" id="tab3">


				<form id="f_attdchk" method="post">
					<input type="hidden" id="attSelect" name="attSelect" />
					<button type="button" class="btn btn-danger" id="attok" value="출근" onclick="attdok()">
						<i class="glyphicon glyphicon-ok" aria-hidden="true"></i>출근
					</button>
					<button type="button" class="btn btn-primary" id="attexit" value="퇴근" onclick="attdexit()">
						<i class="glyphicon glyphicon-remove" aria-hidden="true"></i>퇴근
					</button>
				</form>


			</div>
		</div>
	</div>

</div>


