<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ss.mango.user.space.model.vo.SubSpace" %>
<%@ page import="ss.mango.user.space.model.vo.SpaceRegistration" %>
<%@ page import="ss.mango.user.member.model.vo.Member" %>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공간 선택 페이지</title>
	<style>
		* {
            box-sizing: border-box;
            margin: 0px;
            padding: 0px;
    	}
    	.reservation_table_box {
   		    overflow-x: auto;
    		overflow-y: hidden;
    	}
    	.reservation_table {
   		    position: relative;
		    margin-top: 16px;
		    width: 1800px;
    	}
    	.reservation_table td {
    		padding: 0px 6px;
    		height: 18px;
    		font-size: 14px;
    	}
    	.reservation_table th {
    		padding: 0px 12px;
    	}
    	.table_left {
    		width: 320px;
    		padding-left: 21px;
    		padding-right: 21px;
    	}
    	.insertPlaceTitleStyle {
			padding: 0;
			width: 100%;
			border-left: 5px solid gray;
			margin-bottom: 30px;
		}
		.insertPlaceTitleStyle>span {
			width: 100%;
			padding: 0 10px;
			margin: 50px 0;
			font-weight: bold;
		}
    	.subSelect {
    		position: absolute;
    		top: 0px;
    		right: 0px;
    	}
    	.subCostTime {
    		text-align: right;
    		border: none;
    		background: none;
    		font-weight: bold;
    	}
    	.subCostTime:focus {
    		outline: none;
    	}
    	.subSelectBtn {
    		padding: 5px 20px;
    		background-color: white;
    		color: gray;
    		border: 1px solid gray;
    		border-radius: 3px;
    	}
    	.subSelectBtn:hover {
    		color: white;
    		background-color: gray;
    	}
    	.subSelectBtn:focus {
    		outline:none;
    	}
    	.subSpaceBox {
    		padding: 10px;
    	}
    	.subSpaceBox:nth-of-type(2n+2) {
    		background-color:rgba(221, 221, 221, 0.3);
    	}
    	.subSpaceBox:hover {
    		border: 2px solid #dddddd;
    		transition: .4s;
    	}
    	.subSpaceViewImage {
    		border-radius: 5px;
    	}
    	.subPriceStyle {
    		padding: 3px 0px;
    	}
    	
    	#resStatusBtn {
    		margin-left: 5px;
    		padding: 3px 8px;
    		background-color: white;
    		color: gray;
    		border: 1px solid gray;
    		border-radius: 3px;
    	}
    	#resStatusBtn:hover {
    		color: white;
    		background-color: gray;
    	}
    	#resStatusBtn:focus {
    		outline: none;
    	}
    	.remoteSubSpace {
    		border: none;
    	}
    	.remoteSubSpace:focus {
    		outline: none;
    	}
    	.remote_content_span {
    		display: block;
    		padding: 10px;
    	}
    	.calendar_input {
    		border-bottom: 1px solid #EBEBEB;
    	}
    	.remote_reservation_list_content {
    		height: 50px;
    	}
    	.remote_reservation_list_left {
    		float: left;
    		height: 100%;
    	}
    	.remote_reservation_list_right {
    		float: left;
    		padding: 10px;
    		height: 100%;
    	}
    	#after_start_time {
    		float: left;
    	}
    	#startTimeInput,#endTimeInput {
    		width: 100%;
    		color: #dddddd;
    	}
    	#remotePrice {
    		border: none;
    		text-align:right;
    		width: 70%;
    		color: red;
    	}
    	#remotePrice:focus {
    		outline:none
    	}
    	.remote_reservation_list_left_span {
    		line-height: 50px;
    		padding: 10px;
    	}
    	.remote_reservation_list_input {
    		border: none;
    		border-bottom: 1px solid #EBEBEB;
    		padding: 3px 10px 3px 10px;
    	}
    	.remote_reservation_list_input:focus {
    		outline: none;
    	}
    	.remote_pay_box span {
		    box-sizing: border-box;
		    display: inline-block;
		    vertical-align: top;
    	}
    	.remote_pay_box_left {
    		width: 140px;
		    padding: 0 10px;
		    font-family: "nanumsquare-eb";
		    font-size: 18px;
		    line-height: 26px;
		    color: #444444;
    	}
    	.remote_pay_box_right {
		    width: calc(100% - 150px);
		    padding: 0 10px 0 0;
		    font-family: "nanumsquare-b";
		    font-size: 20px;
		    line-height: 26px;
		    color: #f80d65;
		    text-align: right;
    	}
    	.remote_space_choice_before {
    		line-height: 24px;
    	}
    	#remote_btn {
    		width: 50%;
    		height: 100%;
    	}
    	.peopleStyle {
    		float: left;
    		width: 30px;
    		height: 30px;
    		background-color: white;
    		border: 1px solid black;
    		border-radius: 32px;
    		color: black;
    		font-weight: bold;
    	}
    	.peopleStyle:focus {
    		outline: none;
    	}
    	#inputPeople {
    		float: left;
    		width: 75%;
    		height: 100%;
    	}
    	#inputPeople>input {
    		border: none;
    		text-align: center;
    		height: 100%;
    	}
    	#inputPeople>input:focus {
    		outline: none;
    	}
    	#reservation_calendar_btn {
    		margin: 2px;
    		cursor: pointer;
    		color:grey;
    	}
    	#reservation_calendar_btn:hover {
    		color:black;
    	}
    	#remote_rsvt_datepicker {
    		 width: 90%;
    		 float: left;
    	}
    	#remote_rsvt_datepicker_btn {
    		margin: 2px;
    		cursor: pointer;
    		color: grey;
    	}
    	#remote_rsvt_datepicker_btn:hover {
    		color:black;
    	}
	</style>
</head>
<body>
	<div class="wrapper">
        <div id="header">
            <%@ include file="/views/user/common/header.jsp" %>
        </div>
        <%
        	ArrayList<SubSpace> subspace = (ArrayList<SubSpace>)request.getAttribute("subspace");
        	SpaceRegistration space = (SpaceRegistration)session.getAttribute("space");
        %>
        <div class="main-content" id="container">
	        <div id="contents">
	        	<div class="row p-0" style="margin: 50px 0px 0px 0px;">
	        		<div class="col-12 col-sm-9 p-0" style="margin: 0 auto; max-width:1180px;">
	        			<div class="row m-0 p-0">
	        				<div class="col-12 col-xl-8 m-0 place_view">
	        					<h3><b><%=space.getSpaceName()%></b></h3>
	        					<i class="fas fa-map-marker-alt" style="color: gray;"></i><span>&nbsp;<%=space.getSpaceAddress() %></span>
	        					<div class="col-12 p-0" id="place_image_box">
	        						<img src="/resources/file/image/<%=space.getFileName() %>" id="place_image" style="width: 100%; height:100%;"/>
	        					</div>
	        					<% Date today = new Date(); %>
								<% SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd"); %>
	        					
	        					<div style="margin-top: 60px">
	        					<hr>
	        						<h5 class="insertPlaceTitleStyle">
	        							<span>시설 안내</span>
	        						</h5>
	        						<span><%=space.getSpaceIntro() %></span>
	        					</div>
	        					
	        					<div style="margin-top: 60px">
	        					<hr>
	        						<h5 class="insertPlaceTitleStyle" id="movesubspaceinfo">
	        							<span>회의실 안내</span>
	        						</h5>
	        					</div>
	        					<% int countsubSpaceNo=0; %>
	        					<% for(SubSpace ss : subspace) { %>
	        					<div class="col-12 subSpaceBox m-0 p-10">
	        						<div class="subSpaceView row p-0 m-0">
					        			<div class="subSpaceImage col-md-4 p-0" style="float:left">
					        				<img src="/image/오피스9.jpg" class="subSpaceViewImage" style="width: 100%; height:90%;"/>
					        			</div>
				        				<div class="col-md-8">
				        					<div class="row">
				        						<div class="col-12 m-0" id="subNameParentbox">
					        						<h4><%=ss.getSubName() %></h4>
						        					<input type="hidden" id="subSpaceNoCount" name="subSpaceNo_<%=countsubSpaceNo%>" value="<%=ss.getSubNo()%>"/>
						        					<span class="subPriceStyle">
						        					<% DecimalFormat formatter = new DecimalFormat("###,###");%>
						        						<b>
						        							<input type="text" value="<%=formatter.format(ss.getSubCost()) %>" class="subCostTime" size="2" readonly/>
						        							<span>원 / 시간</span>
						        						</b>
						        					</span>
						        					<div class="subSelect"><button class="subSelectBtn">선택</button></div>
					        					</div>
					        					<div class="col-12 m-0">
					        						<div class="row m-0 subPriceStyle">
					        							<div class="col-4 m-0 p-0">
					        								<span class="subSpaceInfo">세부 공간안내</span>
					        							</div>
							        					<div class="col-8 m-0 p-0">
								        					<span class="subMinTime"><%=ss.getSubIntro() %></span><br>
							        					</div>
							        				</div>
							        				<div class="row m-0 subPriceStyle">
					        							<div class="col-4 m-0 p-0">
					        								<span class="subSpaceInfo">세부 공간유형</span>
					        							</div>
							        					<div class="col-8 m-0 p-0">
								        					<span class="subMinTime"><%=ss.getSubType() %></span><br>
							        					</div>
							        				</div>
					        						<div class="row m-0 subPriceStyle">
					        							<div class="col-4 m-0 p-0">
					        								<span class="subSpaceInfo">최저 이용시간</span>
					        							</div>
							        					<div class="col-8 m-0 p-0">
								        					<span class="subMinTime"><%=ss.getMinTime() %>시간</span><br>
							        					</div>
							        				</div>
							        				<div class="row m-0 subPriceStyle">
							        					<div class="col-4 m-0 p-0">
					        								<span class="subSpaceInfo">최소이용인원</span>
							        					</div>
							        					<div class="col-8 m-0 p-0">
								        					<span class="subType"><%=ss.getMinPeople() %>명</span><br>
							        					</div>
							        				</div>
							        				<div class="row m-0 subPriceStyle">
							        					<div class="col-4 m-0 p-0">
					        								<span class="subSpaceInfo">편의시설</span>
							        					</div>
							        					<div class="col-8 m-0 p-0">
								        					<span class="subAmenties"><%=ss.getAmenities() %></span>
							        					</div>
						        					</div>
					        					</div>
				        					</div>
				        				</div>
					        		</div>
	        					</div>
	        					<% countsubSpaceNo++; %>
	        					<% } %>
	        					<div style="margin: 30px 0px">
	        					<hr>
	        					</div>
	        				</div>
	        				<script>
	        				

	        	        	
	        	    		/* var date = new Date();
	        	    		
	        	    		function hz(val) {
	        	    			alert('안뜨냐');
	        	        		var strArr = val.split('-');
	        	        		var todayval = new Date(strArr[0],strArr[1]-1,strArr[2]);
	        	        		
	        	        		if(todayval<=date) {
	        	        			alert("금일날짜보다 앞선날짜를선택했어여");
	        	        		} else {
	        	        			alert("금일날짜보다 뒷날짤르 선택했어여");
	        	        		}
	        	    		}
	        	    		$('#remote_rsvt_datepicker').focus(function() {
	        	    			var strArr = $(this).val().split('-');
	        	    			var todayval = new Date(strArr[0],strArr[1]-1,strArr[2]);
	        	    			
	        	    			if(todayval<=date) {
	        	        			alert("금일날짜보다 앞선날짜를선택했어여");
	        	        		} else {
	        	        			alert("금일날짜보다 뒷날짤르 선택했어여");
	        	        		}
	        	    		}) */
	        					$(function() {
	        						$('#remote_btn').click(function() {
	        							if($('#clickShow').hasClass("d-none")) {
		        							alert("예약을 원하는 회의실을 선택해주세요.");
		        							var moveSubSpaceInfo = $('#movesubspaceinfo').offset();
		        							$('html').animate({scrollTop: moveSubSpaceInfo.top}, 500);
		        						} else if($('#remote_rsvt_datepicker').val()=="") {
		        							alert("이용일자를 선택해주세요");
		        							$('#remote_rsvt_datepicker').focus();
		        						} else if($('input[name=startTime]').val()=="선택") {
		        							alert("이용시작시간을 선택해주세요.");
		        							$('input[name=startTime]').focus();
		        						} else if($('input[name=endTime]').val()=="선택") {
		        							alert("이용종료시간을 선택해주세요.");
		        							$('input[name=endTime]').focus();
		        						} else if($('input[name=resPeople]').val()=="0") {
		        							alert("최소이용인원은 1명 이상이어야 합니다.")
		        							$('input[name=resPeople]').focus();
		        						} else {
		        							$('#remoteForm').submit();
		        						}
	        						});
	        					});
	        				</script>
	        				<form method="get" id="reservationStatusForm">
								<input type="hidden" name="subno" id="subno" value="">
								<input type="hidden" name="resdate" id="resdate" value="">
							</form>
	        				<div class="col-12 col-xl-4 remote_view">
	        					<div id="item_remote_box">
	        						<form action="/SpaceChoiceSubspace.ss" method="get" id="remoteForm">
		        						<div class="remote_space_name_box">
		        							<h4 style="padding: 10px"><%=space.getSpaceName() %></h4>
		        						</div>
		        						<div class="remote_space_choice_before remote_border" id="clickHide">
		        							<span class="remote_content_span">회의실을 선택해주세요.</span>
		        						</div>
		        						<div class="d-none" id="clickShow">
			        						<div class="remote_space_choice_before remote_border">
			        							<h5><input type="text" class="remoteSubSpace" name="resSubSpaceName" style="padding: 10px 0px 0px 10px; font-weight:bold;" readonly/></h5>
			        							<h5><input type="text" class="remoteSubSpace" name="resSubSpacePrice" style="padding: 10px 0px 0px 10px;" readonly/></h5>
			        						</div>
			        						<div class="remote_space_choice_before remote_border remote_reservation_list">
			        							<div class="remote_reservation_list_content">
													<div class="remote_reservation_list_left" style="width: 25%">
														<span class="remote_reservation_list_left_span">이용일자</span>
													</div>
													<div class="remote_reservation_list_right" style="width: 75%">
														<input name="resDate" class="remote_reservation_list_input" style="width: 50%;" id="remote_rsvt_datepicker" readonly/>
														<i class="fas fa-calendar-alt" id="remote_rsvt_datepicker_btn"></i>
														<button type="button" id="resStatusBtn" onClick="resStatus()">예약현황</button>
													</div>
												</div>
												<div class="remote_reservation_list_content">
													<div class="remote_reservation_list_left" style="width: 25%">
														<span class="remote_reservation_list_left_span">이용시간</span>
													</div>
													<div class="remote_reservation_list_right" style="width: 35%">
														<input type="text" id="startTimeInput" name="startTime" value="선택" class="remote_reservation_list_input" readonly/>
													</div>
													<span id="after_start_time">~</span>
													<div class="remote_reservation_list_right" style="width: 35%">
														<input type="text" id="endTimeInput" name="endTime" value="선택" class="remote_reservation_list_input" readonly/>
													</div>
												</div>
												<div class="remote_reservation_list_content" style="clear: left;">
													<div class="remote_reservation_list_left" style="width: 25%">
														<span class="remote_reservation_list_left_span">이용인원</span>
													</div>
													<div class="remote_reservation_list_right" style="width: 75%; text-align: center">
														<button type="button" id="minusPeople" class="peopleStyle">-</button>
														<div id="inputPeople"><input name="resPeople" value='0' readonly/></div>
														<button type="button" id="plusPeople" class="peopleStyle">+</button>
													</div>
												</div>
			        						</div>
		        						</div>
		        						<div class="remote_space_choice_before remote_border remote_pay_box">
		        							<span class="remote_pay_box_left"><b>결제 예상금액</b></span>
		        							<span class="remote_pay_box_right">
												<input type="text" id="remotePrice" name="resPrice" value='0' readonly>원
											</span>
		        						</div>
		        						<div style="text-align: center; height:60px; margin-top: 20px; margin-bottom: 20px;">
		        							<button type="button" class="btn btn-secondary" id="remote_btn">다 음</button>
		        						</div>
	        						</form>
	        					</div>
	        				</div>
	        			</div>
	        		</div>
	        	</div>
	        </div>
		</div>
        <div id="footer">
        	<%@ include file="/views/user/common/footer.jsp" %>
        </div>
    </div>
    
    <script>
    	var windowWidth;
    	var $place_view = $('.place_view');
    	var $place_image_box = $('#place_image_box');
    	var $place_image = $('#place_image');
    	var $calendar_input = $('.calendar_input');
    	var $choice_date = $('.choice_date');
    	var $remote_view = $('.remote_view');
    	var $reservation_table_top = $('.reservation_table_top');
    	var $reservation_table = $('.reservation_table');

    	
    	$place_view.css('max-width','710px');
    	$place_view.css('padding','0px 10px 0px 10px');
    	$place_image_box.css('margin','10px 0px 0px 0px');
    	$remote_view.css('float','right');
    	$choice_date.css('border','none');
    	$choice_date.css('padding-left','10px');
    	$choice_date.focus().css('outline','none');
    	$reservation_table.css('width','1270px');
    </script>
    <script>
    	var $item_remote_box = $('#item_remote_box');
    	var $remote_border = $('.remote_border');
    	var $remote_reservation_list_left = $('.remote_reservation_list_left');
    	var $remote_btn = $('#remote_btn');
    	
    	$item_remote_box.css('min-width','400px');
    	$item_remote_box.css('padding','26px 20px 0px');
    	$item_remote_box.css('border','2px solid #EBEBEB');
    	$item_remote_box.css('border-radius','5px');
    	$item_remote_box.css('box-shadow','0px 3px 10px 1px lightgray');
    	$remote_border.css('border-top','1px solid #EBEBEB');
    	$remote_border.css('padding','10px 0px');
    </script>
    <script>
    	$(function() {
    		$('#reservation_calendar_btn').click(function() {
    			$("#rsvt_ins_datepicker").focus();
    		});
    		$('#remote_rsvt_datepicker_btn').click(function() {
    			$("#remote_rsvt_datepicker").focus();
    		});
    	});
   	    $("#rsvt_ins_datepicker").datepicker({
   	        language: 'ko'
   	    });
   	    $('#remote_rsvt_datepicker').datepicker({
   	    	language: 'ko'
   	    });
		$("#startTimeInput").datepicker({
		    language: 'ko',
		    timepicker: true,
		    onlyTimepicker: true,
		    timeFormat:"hh:00"
		});
		$("#endTimeInput").datepicker({
		    language: 'ko',
		    timepicker: true,
		    onlyTimepicker: true,
		    timeFormat:"hh:00"
		});
    </script>
    <script>
    $(document).ready(function() {
    	$('#minusPeople').css('color','#dddddd').css('border','1px solid #dddddd');
    	$(function() {
    		$('#minusPeople').click(function() {
    	    	var number = $('input[name=resPeople]').val();
    			if(number>1) {
    				var minus_num = parseInt(number) - 1;
    				$('input[name=resPeople]').attr('value',minus_num);
    			} else if(number==1) {
    				var minus_num = parseInt(number) - 1;
    				$('input[name=resPeople]').attr('value',minus_num);
    				$('#minusPeople').css('color','#dddddd').css('border','1px solid #dddddd');
    				$('#minusPeople').attr('disabled',true);
    			}
    		});
    		$('#plusPeople').click(function() {
    	    	var number = $('input[name=resPeople]').val();
    			if(number==0) {
    				$('#minusPeople').css('color','black').css('border','1px solid black');
    			}
    			var plus_num = parseInt(number) + 1;
    			$('input[name=resPeople]').attr('value',plus_num);
    			$('#minusPeople').attr('disabled',false);
    		});
    	});
    });
    </script>
    <script>
    
    	$(function() {
    		var masterbox;
    		
    		$('.subSelectBtn').click(function() {
    			$('.subSpaceBox').css('border','none');
    			$('.subSelectBtn').css('color','gray').css('background-color','white');
    			$(this).css('color','white').css('background-color','gray');
    			masterbox = $(this).parent().parent().parent().parent().parent().parent();
				masterbox.css('border','2px solid #dddddd');
				
				var offset = $('#item_remote_box').offset();
				$('html').animate({scrollTop: offset.top}, 500);
				
				$('input[name=resSubSpaceName]').attr('value',$(this).parent().parent().children().eq(0).text())
				$('input[name=resSubSpacePrice]').attr('value',$(this).parent().parent().children().eq(2).children().children().eq(0).val()+"원 (시간당)")
				$('#clickHide').addClass('d-none');
				$('#clickShow').removeClass('d-none');
				
				$('#startTimeInput').val("선택");
				$('#endTimeInput').val("선택");
				$('input[name=resPeople]').attr("value",0);
				$('#minusPeople').attr("disabled",true);
				$('#minusPeople').css('color','#dddddd').css('border','1px solid #dddddd');
				$('#remotePrice').attr("value",0);
				
				$("#subno").val($(this).parent().prev().prev().val());
				
    		});
    		$('#startTimeInput').focus(function() {
    			if($(this).val()=="선택") {
    				$(this).css('color','#dddddd').css('font-weight','bold');
    			}
    			if($(this).val()>$('#endTimeInput').val()) {
    				//$(this).val($('#endTimeInput').val());
    				$('#endTimeInput').val($(this).val());
    				$('#endTimeInput').focus();
    				$('#remotePrice').attr("value",0);
    				alert("종료 시간의 이후 시간을 선택할 수 없습니다.");
    			}
    				$(this).css('color','black').css('font-weight','normal');
    		});
    		$('#endTimeInput').focus(function() {
    			if($(this).val()=="선택") {
    				$(this).css('color','#dddddd').css('font-weight','bold');
    			}
    			if($(this).val()<$('#startTimeInput').val()) {
    				$(this).val($('#startTimeInput').val());
    				$('#remotePrice').attr("value",0);
    				alert("시작 시간의 이전 시간을 선택할 수 없습니다.");
    				$('#startTimeInput').focus();
    			}
    				$(this).css('color','black').css('font-weight','normal');
    		});
    		$('#startTimeInput').focusout(function() {
    			if((!($('#startTimeInput').val()=="선택"))&&(!($('#endTimeInput').val()=="선택"))) {
    				var startTimeInput = $('#startTimeInput').val().substr(0,2);
    				var endTimeInput = $('#endTimeInput').val().substr(0,2);
    				var compute = (endTimeInput-startTimeInput) * (Number(masterbox.find('#subNameParentbox').children().eq(2).children().children().eq(0).val().replace(',','')));
    				
    				$('#remotePrice').attr('value',compute);
        		}
    		});
    		$('#endTimeInput').focusout(function() {
    			if((!($('#startTimeInput').val()=="선택"))&&(!($('#endTimeInput').val()=="선택"))) {
    				var startTimeInput = $('#startTimeInput').val().substr(0,2);
    				var endTimeInput = $('#endTimeInput').val().substr(0,2);
    				var compute = (endTimeInput-startTimeInput) * (Number(masterbox.find('#subNameParentbox').children().eq(2).children().children().eq(0).val().replace(',','')));
    				$('#remotePrice').attr('value',compute);
        		}
    		});
    		
    	});
    	
    	var resStatus = function() {
    		if($('#clickShow').hasClass("d-none")) {
    			alert("예약을 원하는 회의실을 선택해주세요.");
    			return;
    		}
    		
    		window.open("", "PopupWin", "width=600,height=400");
    		
    		var frmData = document.getElementById('reservationStatusForm');
    		
    		//$("#subno").val($("#subSpaceNoCount").val());
    		$("#resdate").val($("#remote_rsvt_datepicker").val().replaceAll('-',''));
    		
    		frmData.target = "PopupWin";
    		frmData.action = "/ResStatusView.ss";
    		
    		frmData.submit();
    	}
    	
    </script>
</body>
</html>
