<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ss.mango.user.space.model.vo.SpaceRegistration" %>
<%@ page import="ss.mango.user.space.model.vo.SubSpace" %>
<%@ page import="ss.mango.user.space.model.vo.ResInfo" %>
<%@ page import="ss.mango.user.space.model.vo.Reservation" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예약자 정보 입력</title>
	<style>
		* {
            box-sizing: border-box;
            margin: 0px;
            padding: 0px;
    	}
    	.place_reservation_content_title {
    		margin-top: 50px;
    	}
    	.place_reservation_content {
    		margin-top: 20px;
    	}
    	.place_reservation_content_left {
    		border-top: 1px solid #EBEBEB;
    		border-bottom: 1px solid #EBEBEB;
    		padding: 25px 0px 25px 0px;
    		background-color: rgba(235,235,235,0.4);
    		font-weight: bold;
    	}
    	.place_reservation_content_right {
    		border-top: 1px solid #EBEBEB;
    		border-bottom: 1px solid #EBEBEB;
    		padding: 25px 0px 25px 0px;
    	}
    	#go_home_btn_box {
    		margin-top: 40px;
    		padding: 20px;
    		height: 100px;
    		text-align: center;
    	}
    	#go_home_btn {
    		width: 200px;
    		height: 100%;
    		margin: 0 auto;
    		border-radius: 5px;
    	}
	</style>
</head>
<body>
	<div class="wrapper">
        <div class="row p-0 m-0" id="header">
            <%@ include file="/views/user/common/header.jsp" %>
        </div>
        	<%
	    		SpaceRegistration space = (SpaceRegistration)session.getAttribute("space");
        		SubSpace subspace = (SubSpace)session.getAttribute("subspace");
	        	ResInfo resinfo = (ResInfo)session.getAttribute("ResInfo");
	    		Reservation reservation = (Reservation)session.getAttribute("Reservation");
        	%>
        <div class="main-content" id="container">
	        <div class="row p-0 m-0" id="contents">
	        	<div class="col-12 col-sm-11 col-lg-8" style="margin: 0 auto;">
	        		<div class="place_reservation_content_title">
	        			<h3><b>예약정보</b></h3>
	        			<div class="place_reservation_content">
	        				<div class="row m-0 place_reservation_row">
	        					<div class="col-3 col-md-2 place_reservation_content_left">
	        						<span class="reservation_success_span_style">예약장소</span>
	        					</div>
	        					<div class="col-9 col-md-10 place_reservation_content_right">
	        						<span class="reservation_success_span_style"><%= space.getSpaceName() %></span>
	        					</div>
	        				</div>
	        				<div class="row m-0 place_reservation_row">	
	        					<div class="col-3 col-md-2 place_reservation_content_left">
	        						<span class="reservation_success_span_style">공간명</span>
	        					</div>
	        					<div class="col-9 col-md-4 place_reservation_content_right">
	        						<span class="reservation_success_span_style"><%= subspace.getSubName() %></span>
	        					</div>
	        					<div class="col-3 col-md-2 place_reservation_content_left">
	        						<span class="reservation_success_span_style">이용일자</span>
	        					</div>
	        					<div class="col-9 col-md-4 place_reservation_content_right">
	        						<span class="reservation_success_span_style"><%= reservation.getResDate() %></span>
	        					</div>
	        				</div>
	        				<div class="row m-0 place_reservation_row">
	        					<div class="col-3 col-md-2 place_reservation_content_left">
	        						<span class="reservation_success_span_style">이용인원</span>
	        					</div>
	        					<div class="col-9 col-md-4 place_reservation_content_right">
	        						<span class="reservation_success_span_style"><%= reservation.getResPeople()+"명" %></span>
	        					</div>
	        					<div class="col-3 col-md-2 place_reservation_content_left">
	        						<span class="reservation_success_span_style">이용시간</span>
	        					</div>
	        					<div class="col-9 col-md-4 place_reservation_content_right">
	        						<span class="reservation_success_span_style"><%= reservation.getResStartTime()+":00" %> ~ <%= reservation.getResEndTime()+":00" %></span>
	        					</div>
	        				</div>
	        			</div>
	        		</div>
	        		<div class="place_reservation_content_title">
	        			<h3><b>예약자 정보</b></h3>
	        			<div class="place_reservation_content">
	        				<div class="row m-0 place_reservation_row">
	        					<div class="col-3 col-md-2 place_reservation_content_left">
	        						<span class="reservation_success_span_style">예약자</span>
	        					</div>
	        					<div class="col-9 col-md-10 place_reservation_content_right">
	        						<span class="reservation_success_span_style"><%= resinfo.getResInfoName() %></span>
	        					</div>
	        				</div>
	        				<div class="row m-0 place_reservation_row">	
	        					<div class="col-3 col-md-2 place_reservation_content_left">
	        						<span class="reservation_success_span_style">연락처</span>
	        					</div>
	        					<div class="col-9 col-md-4 place_reservation_content_right">
	        						<span class="reservation_success_span_style"><%= resinfo.getResInfoPhone() %></span>
	        					</div>
	        					<div class="col-3 col-md-2 place_reservation_content_left">
	        						<span class="reservation_success_span_style">이메일</span>
	        					</div>
	        					<div class="col-9 col-md-4 place_reservation_content_right">
	        						<span class="reservation_success_span_style"><%= resinfo.getResInfoEmail() %></span>
	        					</div>
	        				</div>
	        				<div class="row m-0 place_reservation_row">
	        					<div class="col-3 col-md-2 place_reservation_content_left">
	        						<span class="reservation_success_span_style">사용목적</span>
	        					</div>
	        					<div class="col-9 col-md-10 place_reservation_content_right">
		        					<% if(resinfo.getUsePurpose()==null) { %>
		        						<span class="reservation_success_span_style"><%="없음"%></span>
		        					<% } else { %>
		        						<span class="reservation_success_span_style"><%=resinfo.getUsePurpose()%></span>
		        					<% } %>
	        					</div>
	       					</div>
	        				<div class="row m-0 place_reservation_row">
	        					<div class="col-3 col-md-2 place_reservation_content_left">
	        						<span class="reservation_success_span_style">요청사항</span>
	        					</div>
	        					<div class="col-9 col-md-10 place_reservation_content_right">
		        					<% if(resinfo.getRequirements()==null) { %>
		        						<span class="reservation_success_span_style"><%="없음"%></span>
		        					<% } else { %>
		        						<span class="reservation_success_span_style"><%=resinfo.getRequirements() %></span>
		        					<% } %>
	        					</div>
	        				</div>
	        				<div class="row m-0 place_reservation_row">	
	        					<div class="col-3 col-md-2 place_reservation_content_left">
	        						<span class="reservation_success_span_style">결제금액</span>
	        					</div>
	        					<div class="col-9 col-md-10 place_reservation_content_right" style="text-align: right">
	        						<span id="reservation_success_span_pay_style" style="font-size: 20px; color: red; font-weight: bold"><%=reservation.getUsercost() %>원</span>
	        					</div>
	        				</div>
	        			</div>
	        		</div>
	        		<div id="go_home_btn_box">
	        			<button type="button" class="btn btn-danger" id="go_home_btn">홈으로</button>
	        		</div>
	        	</div>
        	</div>
        </div>
        <div class="row p-0 m-0" id="footer">
            <%@ include file="/views/user/common/footer.jsp" %>
        </div>
   	</div>
    
    <script>
		var windowWidth;
		var $reservation_success_span_style = $('.reservation_success_span_style');
		
    	$('#go_home_btn').click(function() {
    		location.href="/index.jsp";
    	});
    	
    	$(window).innerWidth(function() {
    		if($(this).width() <= 576) {
    			$reservation_success_span_style.css('font-size','12px');
    			$('#reservation_success_span_pay_style').css('font-size','17px');
    		} else {
    			$reservation_success_span_style.css('font-size','16px');
    			$('#reservation_success_span_pay_style').css('font-size','20px');
    		}
    	});
    		
    	$(window).resize(function() {
    		windowWidth = $(this).width();
    		
    		if(windowWidth <= 576) {
    	    	$reservation_success_span_style.css('font-size','12px');
    	    	$('#reservation_success_span_pay_style').css('font-size','17px');
    		} else {
    			$reservation_success_span_style.css('font-size','16px');
    			$('#reservation_success_span_pay_style').css('font-size','20px');
    		}
    	});
    </script>
</body>
</html>