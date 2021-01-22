<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ss.mango.user.space.model.vo.ReservationDetails" %>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 예약현황</title>

<style>
	#contents {
		height: 80%;
		padding: 0;
		margin: 0;
	}

	#contents_right {
	   padding: 50px 30px;
	   max-width :  1000px;
	   box-sizing: border-box;
	   float: left;
	}
	
	.contents_right_title_div {
	   padding: 8px 0px 0px 0px;
	   border: 1px solid white;
	   border-bottom-color: lightgrey;
	}
	
	.contents_right_title {
	   width: 100%;
	   font-size: 30px;
	   padding: 0 10px;
	   margin: 50px 0;
	}
	
	.h3style{
	   padding: 0;
	   width: 100%;
	   border-left: 5px solid chocolate;
	   margin-bottom: 30px;
	}
	
	.select_div {
	   text-align: right;
	   margin: 5px 0px 10px;
	}
	
	.h3style {
	   text-align: left;
	}
	
	.contents_right_content_div {
		
		border-top : grey;
		box-sizing: border-box;
	}
	
	.list_box {
		position :relative;
	   border: 1px solid black;
	   width: 50px;
	   height: 50px;
	   margin-left: 25px;
	}
	.res_content_category_rescomplete {
		padding: 5px 20px;
		border: 1px solid #EBEBEB;
		display: inline-block;
		margin-bottom: 10px;
		border-radius: 32px;
		color: black;
	}
	.res_content_category_rescancel {
		padding: 5px 20px;
		border: 1px solid #EBEBEB;
		display: inline-block;
		margin-bottom: 10px;
		border-radius: 32px;
		color: red;
	}
	.res_content_category_canceldelay {
		padding: 5px 20px;
		border: 1px solid #EBEBEB;
		display: inline-block;
		margin-bottom: 10px;
		border-radius: 32px;
		color: forestgreen;
	}
	.res_content {
		cursor: pointer;
		margint-top: 20px;
		border: 1px solid lightgrey;
		border-radius: 5px;
		min-width: 350px;
	}
	.res_content:hover {
   		transform: scaleX(1.05) scaleY(1.05);
   		transition: .5s;
   		box-shadow: 0px 3px 10px 1px lightgray;
	}
	.res_content_price {
		position: absolute;
		right: 30px;
		bottom: 30px;
		font-weight: bold;
		font-size: 18px;
	}
</style>
</head>
<body>
	<div class="wrapper">
		<div id="header">
			<%@ include file="/views/user/common/header.jsp"%>
		</div>
		<%
			ArrayList<ReservationDetails> list2 = (ArrayList<ReservationDetails>)request.getAttribute("resDetails");
		%>
		<div class="main-content" id="container">
			<div id="contents" class="row">
				<div id="contents_left" class="col-md-3">
					<%@ include file="/views/user/common/myPageSideBar.jsp"%>
				</div>
				<div id="contents_right" class="col-md-9">
					<div class="row contents_right_title_div">
						<h3 class="h3style col-9">
							<span class="contents_right_title">예약한 회의실</span>
						</h3>
						<div class="select_div col-3 p-0">
							<select class="select_box" style="width: 100px">
								<option value="전체">전체</option>
								<option value="예약완료">예약완료</option>
								<option value="예약취소">예약취소</option>
								<option value="취소대기">취소대기</option>
							</select>
						</div>
					</div>
					<div class="row contents_right_content_div">
					<% DecimalFormat formatter = new DecimalFormat("###,###");%>
						<% for(ReservationDetails resdetail : list2) { %>
							<div class="res_content col-12 col-md-5" style="margin-top: 30px; margin-right:60px; padding: 20px;">
							<div onclick="location.href='/MemberReservationDetail.ss?resNo=<%=resdetail.getResNo()%>'" class="resDetailStyle">
								<% if(resdetail.getResState()=='N') { %>
								<div class="res_content_category_rescomplete"><b>예약완료</b></div>
								<% } else if(resdetail.getResState()=='W') { %>
								<div class="res_content_category_canceldelay"><b>취소대기</b></div>
								<% } else { %>
								<div class="res_content_category_rescancel"><b>예약취소</b></div>
								<% } %>
								<h5><span class="res_content_title"><b><%=resdetail.getSpaceName() %>/<%=resdetail.getSubName() %></b></span></h5>
								<i class="far fa-calendar-alt" style="color:chocolate"></i> <%=resdetail.getResDate() %><br>
								<i class="far fa-clock" style="color:chocolate"></i> <%=resdetail.getResStartTime()+":00" %>~<%=resdetail.getResEndTime()+":00" %> [<%=resdetail.getResEndTime()-resdetail.getResStartTime() %>시간]
								<span class="res_content_price"><%=formatter.format(resdetail.getUserCost()) %>원</span>
							</div>
							</div>
						<% } %>
					</div>
				</div>
			</div>
		</div>
		<div id="footer"><%@ include file="/views/user/common/footer.jsp"%></div>
	</div>



	<script>
		$(".aStyle").eq(0).removeClass('aHover');
		$(".spanLi").eq(0).addClass('ClickStyle')
	</script>
	<script>
   		$('.res_content').click(function() {
   			$(this).patent().submit();
   		});
	</script>
</body>
</html>