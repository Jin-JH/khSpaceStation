<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ss.mango.user.space.model.vo.ReservationDetails" %>
<%@ page import="ss.mango.user.space.model.vo.ResInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사업자 회원 정보 수정</title>
<style>
	#contents {
		height: 80%;
		padding: 0;
		margin: 0;
	}
	
	#content_right {
		padding: 50px 30px;
		max-width: 1000px;
	}
	
	.h3Style {
		padding: 0;
		width: 100%;
		border-left: 5px solid chocolate;
		margin-bottom: 30px;
	}
	.reservation_detail {
   		margin-top: 20px;
   	}
   	.reservation_detail_left {
   		border-top: 1px solid #EBEBEB;
   		border-bottom: 1px solid #EBEBEB;
   		padding: 25px 0px 25px 0px;
   		background-color: rgba(235,235,235,0.4);
   		font-weight: bold;
   	}
   	.reservation_detail_right {
   		border-top: 1px solid #EBEBEB;
   		border-bottom: 1px solid #EBEBEB;
   		padding: 25px 0px 25px 0px;
   	}
   	#refund_caution {
   		margin-top: 50px;
   	}
   	.refund_caution_title {
   		padding: 10px;
   	}
   	
	#content>.row {
		border-top: 1px solid lightgray;
	}
	
	#content>.row>.col-10 {
		padding: 0;
		border-right: 1px solid lightgray;
	}
	
	.refund_BtnStyle {
		margin: 20px 10px;
		height: 50px;
		width: 150px;
		background-color: chocolate;
		border: 1px solid chocolate;
		color: white;
		font-weight: 900;
		font-size: 18px;
		border-radius: 10px;
		display: inline-block;
	}
	
	.refund_BtnStyle:hover {
		margin: 20px 10px;
		height: 50px;
		width: 150px;
		background-color: white;
		border: 1px solid chocolate;
		color: chocolate;
		font-weight: 900;
		font-size: 18px;
		border-radius: 10px;
		display: inline-block;
	}
	.resInfoPriceStyle {
   		border: none;
   	}
   	.resInfoPriceStyle:focus {
   		outline: none;
   	}
</style>
</head>
<body>
	<div class="wrapper">
		<div id="header">
			<%@ include file="/views/user/common/header.jsp"%>
		</div>
		<%
			ReservationDetails resDetail = (ReservationDetails)request.getAttribute("resDetail");
			ResInfo resinfo = (ResInfo)request.getAttribute("resinfoDetail");
		%>
		<div class="main-content" id="container">
			<div id="contents" class="row">
				<div id="contents_left" class="col-md-3">
					<%@ include file="/views/user/common/myPageSideBar.jsp"%>
				</div>
				<div id="content_right" class="col-md-9">
					<div class="row">
						<h3 class="h3Style col-12">
							<span class="contactTitle">회의실 예약 내용</span>
						</h3>
					</div>
					<div class="reservation_detail">
        				<div class="row m-0 place_reservation_row">
        					<div class="col-3 col-md-2 reservation_detail_left">
        						<span class="reservation_detail_span_style">예약장소</span>
        					</div>
        					<div class="col-9 col-md-4 reservation_detail_right">
        						<span class="reservation_detail_span_style"><%= resDetail.getSpaceName()%></span>
        					</div>
        					<div class="col-3 col-md-2 reservation_detail_left">
        						<span class="reservation_detail_span_style">공간명</span>
        					</div>
        					<div class="col-9 col-md-4 reservation_detail_right">
        						<span class="reservation_detail_span_style"><%= resDetail.getSubName() %></span>
        					</div>
        				</div>
        				<div class="row m-0 place_reservation_row">	
        					<div class="col-3 col-md-2 reservation_detail_left">
        						<span class="reservation_detail_span_style">이용일자</span>
        					</div>
        					<div class="col-9 col-md-4 reservation_detail_right">
        						<span class="reservation_detail_span_style"><%= resDetail.getResDate() %></span>
        					</div>
        					<div class="col-3 col-md-2 reservation_detail_left">
        						<span class="reservation_detail_span_style">이용시간</span>
        					</div>
        					<div class="col-9 col-md-4 reservation_detail_right">
        						<span class="reservation_detail_span_style">
        							<%= resDetail.getResStartTime()+":00" %> ~ <%=resDetail.getResEndTime()+":00" %>
        							 / <%=resDetail.getResEndTime()-resDetail.getResStartTime() %>시간
        						</span>
        					</div>
        				</div>
        				<div class="row m-0 place_reservation_row">
        					<div class="col-3 col-md-2 reservation_detail_left">
        						<span class="reservation_detail_span_style">수용타입</span>
        					</div>
        					<div class="col-9 col-md-4 reservation_detail_right">
        						<span class="reservation_detail_span_style"><%=resDetail.getSubType() %></span>
        					</div>
        					<div class="col-3 col-md-2 reservation_detail_left">
        						<span class="reservation_detail_span_style">이용인원</span>
        					</div>
        					<div class="col-9 col-md-4 reservation_detail_right">
        						<span class="reservation_detail_span_style"><%=resDetail.getResPeople() %>명</span>
        					</div>
        				</div>
        				<div class="row m-0 place_reservation_row">
	       					<div class="col-3 col-md-2 reservation_detail_left">
	       						<span class="reservation_detail_span_style">결제금액</span>
	       					</div>
	       					<div class="col-9 col-md-10 reservation_detail_right">
	       						<input type="text" class="resInfoPriceStyle" name="payPrice" value="<%=resDetail.getUserCost()%>" style="width: 90%; text-align:right; font-size: 20px; font-weight:bold; color: red;" readonly/>
	       						<span style="font-size: 20px; font-weight:bold; color: red;">원</span>
        					</div>
	       				</div>
       				</div>
       				<div class="row">
						<h3 class="h3Style col-12" style="margin-top: 100px;">
							<span class="contactTitle">예약자 정보</span>
						</h3>
					</div>
					<div class="reservation_detail">
        				<div class="row m-0 place_reservation_row">
        					<div class="col-3 col-md-2 reservation_detail_left">
        						<span class="reservation_detail_span_style">예약자</span>
        					</div>
        					<div class="col-9 col-md-10 reservation_detail_right">
        						<span class="reservation_detail_span_style"><%=resinfo.getResInfoName() %></span>
        					</div>
        				</div>
        				<div class="row m-0 place_reservation_row">	
        					<div class="col-3 col-md-2 reservation_detail_left">
        						<span class="reservation_detail_span_style">이메일</span>
        					</div>
        					<div class="col-9 col-md-4 reservation_detail_right">
        						<span class="reservation_detail_span_style"><%=resinfo.getResInfoEmail() %></span>
        					</div>
        					<div class="col-3 col-md-2 reservation_detail_left">
        						<span class="reservation_detail_span_style">연락처</span>
        					</div>
        					<div class="col-9 col-md-4 reservation_detail_right">
        						<span class="reservation_detail_span_style">
        							<%=resinfo.getResInfoPhone().substring(0, 3) %> -
        							<%=resinfo.getResInfoPhone().substring(3, 7) %> -
        							<%=resinfo.getResInfoPhone().substring(7, 11) %>
        						</span>
        					</div>
        				</div>
        				<div class="row m-0 place_reservation_row">
        					<div class="col-3 col-md-2 reservation_detail_left">
        						<span class="reservation_detail_span_style">사용목적</span>
        					</div>
        					<div class="col-9 col-md-10 reservation_detail_right">
        						<% if(resinfo.getUsePurpose()==null) { %>
        						<span class="reservation_detail_span_style">없음</span>	
        						<% } else { %>
        						<span class="reservation_detail_span_style"><%=resinfo.getUsePurpose() %></span>
        						<% } %>
        					</div>
        				</div>
        				<div class="row m-0 place_reservation_row">
        					<div class="col-3 col-md-2 reservation_detail_left">
        						<span class="reservation_detail_span_style">요청사항</span>
        					</div>
        					<div class="col-9 col-md-10 reservation_detail_right">
        						<% if(resinfo.getRequirements()==null) { %>
        						<span class="reservation_detail_span_style">없음</span>
        						<% } else { %>
        						<span class="reservation_detail_span_style"><%=resinfo.getRequirements() %></span>
        						<% } %>
        					</div>
        				</div>
        				<div id="refund_caution">
		        			<div class="row">
								<h3 class="h3Style col-12">
									<span class="contactTitle">환불시 주의사항</span>
								</h3>
							</div>
		        			<div class="">
		        				<div class="row m-0 refund_caution_title">
		        					<div class="refund_caution_left col-3">
		        						<i class="fas fa-exclamation-circle">&nbsp;</i><span class="reservation_span_right">주의사항</span>
		        					</div>
		        					<div class="refund_caution_right col-9">
		        						<span class="reservation_span_right">주말 냉난방 미제공</span><br>
		        						<span class="reservation_span_right">건물 내외 벽에 무단으로 유인물 부착 금지</span>
		        					</div>
		        				</div>
		        				<div class="row m-0 refund_caution_title">
		        					<div class="refund_caution_left col-3">
		        						<i class="fas fa-exclamation-circle">&nbsp;</i><span class="reservation_span_left">예약정책</span>
		        					</div>
		        					<div class="refund_caution_right col-9">
		        						<span class="reservation_span_right">전액 선납시 예약 확정</span>
		        					</div>
		        				</div>
		        				<div class="row m-0 refund_caution_title">
		        					<div class="refund_caution_left col-3">
		        						<i class="fas fa-exclamation-circle">&nbsp;</i><span class="reservation_span_left">취소/환불 정책</span>
		        					</div>
		        					<div class="refund_caution_right col-9">
		        						<span class="reservation_span_right">계약 후~사용 30일 전: 전액 반환</span><br>
		        						<span class="reservation_span_right">사용 29일전~사용 3일전 : 총 합계 금액의 20% 부과</span><br>
		        						<span class="reservation_span_right">사용 2일전~행사 당일 : 총 합계 금액의 10% 부과</span>
		        					</div>
		        				</div>
		        			</div>
		        		</div>
       				</div>
					
					<center>
						<button type="button" class="refund_BtnStyle" id="resCancelBtn">예약취소</button>
					</center>
					
   				</div>
			</div>
		</div>
		<div id="footer">
			<%@ include file="/views/user/common/footer.jsp"%>
		</div>
	</div>
	
	<script>
		$(".aStyle").eq(0).removeClass('aHover');
		$(".spanLi").eq(0).addClass('ClickStyle')
	</script>
	<script>
		var windowWidth;
		var $reservation_detail_span_style = $('.reservation_detail_span_style');
		$(function() {
			$(window).innerWidth(function() {
				if($(this).width() <= 900) {
					$reservation_detail_span_style.css('font-size','13px');
				} else {
					$reservation_detail_span_style.css('font-size','16px');
				}
			});
			$(window).resize(function() {
				windowWidth = $(this).width();
				
				if(windowWidth <= 900) {
			    	$reservation_detail_span_style.css('font-size','13px');
				} else {
					$reservation_detail_span_style.css('font-size','16px');
				}
			});
		});
	</script>
</body>
</html>