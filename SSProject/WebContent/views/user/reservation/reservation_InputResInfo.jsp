<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ss.mango.user.space.model.vo.ResInfo" %>
<%@ page import="ss.mango.user.space.model.vo.SpaceRegistration" %>
<%@ page import="ss.mango.user.space.model.vo.SubSpace" %>
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
    	.resInfoInputStyle {
    		border: none;
    	}
    	.resInfoInputStyle:focus {
    		outline: none;
    	}
    	.reservation_info {
    		margin-top: 50px;
    	}
    	.reservation_info_bottom {
    		margin-top: 50px;
    	}
    	.reservation_info_content {
    		border-top: 1px solid #EBEBEB;
    		border-bottom: 1px solid #EBEBEB;
    	}
    	.reservation_info_left {
    		padding: 25px 0px 25px 0px;
    		background-color: rgba(235,235,235,0.4);
    		font-weight: bold;
    	}
    	.reservation_info_right {
    		padding: 25px 0px 25px 0px;
    	}
    	.reservation_info_content_right {
    		padding: 6px;
    	}
    	.reservation_info_content_input {
    		width: 100%;
    		height: 100%;
    		padding: 5px;
    		border: 1px solid grey;
    		border-radius: 5px;
    	}
    	.reservation_info_content_select_input {
    		width: 30%;
    		height: 100%;
    		padding: 5px;
    	}
    	#res_caution {
    		margin-top: 50px;
    	}
    	.res_caution_title {
    		padding: 10px;
    	}
    	#pay_btn_box {
    		padding: 20px;
    		height: 100px;
    		text-align: center;
    	}
    	#pay_btn {
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
        <% if(m!=null) { %>
        <%
        	ArrayList<ResInfo> list = (ArrayList<ResInfo>)request.getAttribute("ResInfolist");
        	SpaceRegistration space = (SpaceRegistration)session.getAttribute("space");
        	SubSpace subspace = (SubSpace)session.getAttribute("subspace");
	    	String resPrice = (String)request.getAttribute("resPrice");
	    	String resDate = (String)request.getAttribute("resDate");
	    	String startTime = (String)request.getAttribute("startTime");
	    	String endTime = (String)request.getAttribute("endTime");
	    	String resPeople = (String)request.getAttribute("resPeople");
        %>
	        <div class="main-content" id="container">
		        <div class="row p-0 m-0" id="contents">
		        
					<script>
				        $(function() {
				        	$('#pay_btn').click(function() {
				        		if(!(/^[가-힣]{2,5}$/.test($('input[name=resInfoName]').val()))) {
									alert("예약자 성함을 2~5자이내로 입력해주세요.");
									$('input[name=resInfoName]').focus();
								} else if(($('input[name=resInfoPhone2]').val().length)!=4) {
									alert("예약자 연락처 가운데 4자리를 입력해주세요.");
									$('input[name=resInfoPhone2]').focus();
								} else if(($('input[name=resInfoPhone3]').val().length)!=4) {
									alert("예약자 연락처 뒷자리 4자리를 입력해주세요.");
									$('input[name=resInfoPhone3]').focus();
								} else if(!(/^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/.test($('input[name=resInfoEmail]').val()))) {
				    				alert("올바른 이메일 형식을 입력해주세요.");
				    				$('input[name=resInfoEmail]').focus();
				    			} else {
						        	var $resInfoPhone = $('select[name=resInfoPhone1]').val() + $('input[name=resInfoPhone2]').val() + $('input[name=resInfoPhone3]');
						        	
									IMP.init('imp46441466');
									IMP.request_pay({
										pg : 'inicis', // version 1.1.0부터 지원.
										pay_method : 'card',
										merchant_uid : 'r' + new Date().getTime(), 						//물품 주문번호 
										name : $('#resInfoSpaceName').val() + " " + $('#resInfoSubSpaceName').val(),		//세부공간명
										amount : <%=resPrice%>, 													//공간가격
										buyer_email : $('input[name=resInfoEmail]').val(),					//예약자이메일
										buyer_name : $('input[name=resInfoName]').val(),					//예약자이름
										buyer_tel : $resInfoPhone,											//구매자번호
										m_redirect_url : 'https://www.yourdomain.com/payments/complete'
									}, function(rsp) {
										if (rsp.success) {
											$('#payForm').submit();
										} else {
											alert('결제에 실패하였습니다. 지속된 오류 발생시 관리자에게 문의하세요.');
											history.back(-1);
										}
									});
				    			}
							});	
				        });
					</script>
		        	<form action="/SpacePayment.ss" method="post" id="payForm" style="width: 100%;">
			        	<div class="col-12 col-sm-11 col-lg-7" style="margin: 0 auto;">
			        		<div class="reservation_info">
			        			<h3><b>예약정보</b></h3>
			        			<div class="reservation_info_bottom">
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">장소명</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_right">
			        						<input type="text" id="resInfoSpaceName" name="paySpaceName" class="resInfoInputStyle reservation_span_right" value="<%=space.getSpaceName()%>" readonly/>
			        					</div>
			        				</div>
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">공간명</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_right">
			        						<input type="text" id="resInfoSubSpaceName" name="paySubSpaceName" class="resInfoInputStyle reservation_span_right" value="<%=subspace.getSubName()%>" readonly/>
			        					</div>
			        				</div>
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">이용일자</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_right">
			        						<input type="text" name="payDate" class="resInfoInputStyle reservation_span_right" value="<%=resDate%>" readonly/>
			        						<input type="hidden" name="startTime" value="<%=startTime%>"/>
			        						<input type="hidden" name="endTime" value="<%=endTime%>"/>
			        					</div>
			        				</div>
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">이용인원</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_right">
			        						<input type="text" name="payPeople" class="resInfoInputStyle reservation_span_right" value="<%=resPeople%>" readonly/>
			        					</div>
			        				</div>
			        			</div>
			        		</div>
			        		<div class="reservation_info">
			        			<h3><b>예약자 정보</b></h3>
			        			<div class="reservation_info_bottom">
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">예약자</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_content_right">
			        						<input type="text" class="reservation_info_content_input" name="resInfoName" autocomplete="off"/>
			        					</div>
			        				</div>
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">연락처</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_content_right">
			        						<select class="reservation_info_content_select_input" name="resInfoPhone1">
			        							<option value="010">010</option>
			        							<option value="011">011</option>
			        							<option value="016">016</option>
			        							<option value="017">017</option>
			        							<option value="018">018</option>
			        							<option value="019">019</option>
			        						</select>&nbsp;-
			        						<input type="text" class="reservation_info_content_select_input" name="resInfoPhone2" maxlength="4" autocomplete="off"/>&nbsp;-
			        						<input type="text" class="reservation_info_content_select_input" name="resInfoPhone3" maxlength="4" autocomplete="off"/>
			        					</div>
			        				</div>
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">이메일</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_content_right">
			        						<input type="email" class="reservation_info_content_input" name="resInfoEmail" autocomplete="off"/>
			        					</div>
			        				</div>
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">사용목적</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_content_right">
			        						<input type="text" class="reservation_info_content_input" placeholder="공간의 사용 목적을 입력해주세요" name="usePurpose" autocomplete="off"/>
			        					</div>
			        				</div>
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">요청사항</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_content_right" style="height:100px;">
			        						<textarea rows="3" class="reservation_info_content_input" placeholder="남기고 싶은말을 적어주세요. (최대 500자)" name="requestItem" autocomplete="off"></textarea>
			        					</div>
			        				</div>
			        				<div class="row m-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">결제금액</span>
			        					</div>
			        					<div class="col-9 reservation_info_content" style="text-align: right; padding: 25px;">
			        						<input type="text" class="resInfoInputStyle" name="payPrice" value="<%=resPrice%>" style="width: 85%; text-align:right; font-size: 25px; font-weight:bold; color: red;" readonly/>
			        						<span style="font-size: 25px; font-weight:bold; color: red;">원</span>
			        					</div>
			        				</div>
			        			</div>
			        		</div>
			        		<div id="res_caution">
			        			<h3><b>예약시 주의사항</b></h3>
			        			<div class="">
			        				<div class="row m-0 res_caution_title">
			        					<div class="res_caution_left col-3">
			        						<i class="fas fa-exclamation-circle">&nbsp;</i><span class="reservation_span_right">주의사항</span>
			        					</div>
			        					<div class="res_caution_right col-9">
			        						<span class="reservation_span_right">주말 냉난방 미제공</span><br>
			        						<span class="reservation_span_right">건물 내외 벽에 무단으로 유인물 부착 금지</span>
			        					</div>
			        				</div>
			        				<div class="row m-0 res_caution_title">
			        					<div class="res_caution_left col-3">
			        						<i class="fas fa-exclamation-circle">&nbsp;</i><span class="reservation_span_left">예약정책</span>
			        					</div>
			        					<div class="res_caution_right col-9">
			        						<span class="reservation_span_right">전액 선납시 예약 확정</span>
			        					</div>
			        				</div>
			        				<div class="row m-0 res_caution_title">
			        					<div class="res_caution_left col-3">
			        						<i class="fas fa-exclamation-circle">&nbsp;</i><span class="reservation_span_left">취소/환불 정책</span>
			        					</div>
			        					<div class="res_caution_right col-9">
			        						<span class="reservation_span_right">계약 후~사용 30일 전: 전액 반환</span><br>
			        						<span class="reservation_span_right">사용 29일전~사용 3일전 : 총 합계 금액의 20% 부과</span><br>
			        						<span class="reservation_span_right">사용 2일전~행사 당일 : 총 합계 금액의 10% 부과</span>
			        					</div>
			        				</div>
			        			</div>
			        		</div>
			        		<div id="pay_btn_box">
			        			<button type="button" class="btn btn-danger" id="pay_btn">결제하기</button>
			        		</div>
			        		<!-- <div>
			        			<div class="reservation_info">
			        			<h3><b>결제</b></h3>
			        			<div class="reservation_info_bottom">
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">카드종류</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_right">
			        						<input type="radio" name="card" value="hyundaicard"/> <span class="reservation_span_right">현대카드</span>&nbsp;&nbsp;
			        						<input type="radio" name="card" value="samsungcard"/> <span class="reservation_span_right">삼성카드</span>&nbsp;&nbsp;
			        						<input type="radio" name="card" value="kbcard"/> <span class="reservation_span_right">KB국민</span>&nbsp;&nbsp;
			        						<input type="radio" name="card" value="bccard"/> <span class="reservation_span_right">비씨카드</span>&nbsp;&nbsp;
			        						<input type="radio" name="card" value="shinhancard"/> <span class="reservation_span_right">신한카드</span>&nbsp;&nbsp;
			        						<input type="radio" name="card" value="nhcard"/> <span class="reservation_span_right">NH농협</span>&nbsp;&nbsp;
			        						<input type="radio" name="card" value="hanacard"/> <span class="reservation_span_right">하나카드</span>&nbsp;&nbsp;
			        						<input type="radio" name="card" value="lottecard"/> <span class="reservation_span_right">롯데카드</span>&nbsp;&nbsp;
			        						<input type="radio" name="card" value="citycard"/> <span class="reservation_span_right">씨티카드</span>&nbsp;&nbsp;
			        						<input type="radio" name="card" value="kakaobankcard"/> <span class="reservation_span_right">카카오뱅크</span>
			        					</div>
			        				</div>
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">장소명</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_right">
			        						<span class="reservation_span_right">장소이름넣기</span>
			        					</div>
			        				</div>
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">공간명</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_right">
			        						<span class="reservation_span_right">공간이름넣기</span>
			        					</div>
			        				</div>
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">이용일자</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_right">
			        						<span class="reservation_span_right">이용일자넣기</span>
			        					</div>
			        				</div>
			        				<div class="row m-0 p-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">이용인원</span>
			        					</div>
			        					<div class="col-9 reservation_info_content reservation_info_right">
			        						<span class="reservation_span_right">이용인원넣기</span>
			        					</div>
			        				</div>
			        				<div class="row m-0">
			        					<div class="col-3 reservation_info_content reservation_info_left">
			        						<span class="reservation_span_left">결제금액</span>
			        					</div>
			        					<div class="col-9 reservation_info_content " style="text-align: right; padding: 25px;">
			        						<span style="font-size: 25px; font-weight:bold; color: red;">20000원</span>
			        					</div>
			        				</div>
			        			</div>
			        		</div>
			        		</div>
			        		<div id="pay_btn_box">
			        			<button type="button" class="btn btn-danger" id="pay_btn">결제하기</button>
			        		</div> -->
			        	</div>
		        	</form>
		        </div>
			</div>
		<% } else {%>
			<script>
				location.replace("/views/user/member/memberLogin.jsp");
			</script>
		<% } %>
        <div class="row p-0 m-0" id="footer">
            <%@ include file="/views/user/common/footer.jsp" %>
        </div>
    </div>
	<script>
		var windowWidth;
		var $reservation_span_left = $('.reservation_span_left');
    	var $reservation_span_right = $('.reservation_span_right');
		
    	/* $('#pay_btn').click(function() {
    		location.href="/views/user/reservation/reservation_Success.jsp";
    	}); */
    	
    	$(window).innerWidth(function() {
    		if($(this).width() <= 576) {
    			$reservation_span_left.css('font-size','14px');
    	    	$reservation_span_right.css('font-size','14px');
    		} else {
    			$reservation_span_left.css('font-size','16px');
    	    	$reservation_span_right.css('font-size','16px');
    		}
    	});
    		
    	$(window).resize(function() {
    		windowWidth = $(this).width();
    		
    		if(windowWidth <= 576) {
    	    	$reservation_span_left.css('font-size','14px');
    	    	$reservation_span_right.css('font-size','14px');
    		} else {
    			$reservation_span_left.css('font-size','16px');
    	    	$reservation_span_right.css('font-size','16px');
    		}
    	});
    </script>
</body>
</html>