<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="ss.mango.user.Inquiry.model.vo.InquiryPageData" %>
<%@ page import="ss.mango.user.Inquiry.model.vo.Inquiry" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1:1 문의</title>
<style>
	* {
		box-sizing: border-box;
		margin: 0px;
		padding: 0px;
	}
	
	#contents {
		height: 80%;
		padding: 0;
		margin: 0;
	}
	
	#content_right {
		padding: 50px 30px;
		max-width: 1000px;
	}
	
	.inquiryTitle {
		width: 100%;
		font-size: 30px;
		padding: 0 10px;
		margin: 50px 0;
	}
	
	.h3Style {
		padding: 0;
		width: 100%;
		border-left: 5px solid chocolate;
		margin-bottom: 30px;
	}
	
	.inquiry_title {
		height: 50px;
		text-align: center;
		background-color: #ebebeb;
		border-top: 1px solid lightgray;
		border-bottom: 1px solid lightgray;
		margin-top: 50px;
		line-height: 50px;
	}
	
	.inquiry_content {
		height: 50px;
		text-align: center;
		border-bottom: 1px solid lightgray;
	}
	
	.inquiry_text {
		line-height: 50px;
		white-space: nowrap;
	}
	.inquiry_text a {
		text-decoration: none;
		color: black;
	}
	.inquiry_text a:hover {
		text-decoration: none;
		color: black;
	}
	
	#writeQuestionBtn {
		cursor: pointer;
		background-color: white;
		border: 1px solid #EBEBEB;
		border-radius: 5px;
		padding: 8px 15px;
		width: 100px;
	}
	
	#pageNaviStyle>a {
		color: black;
	}
	#writeQuestionBtn:hover {
		background-color: grey;
		color: white;
	}
</style>
</head>
<body>
	<div class="wrapper">
		<div id="header">
			<%@ include file="/views/user/common/header.jsp"%>
		</div>
	<%
		InquiryPageData ipd = (InquiryPageData)request.getAttribute("pageData"); 
		ArrayList<Inquiry> list = ipd.getList();
		String pageNavi = ipd.getPageNavi();
		String keyword = (String)request.getAttribute("keyword");
	%>
		<div class="main-content" id="container">
			<div id="contents" class="row">
				<div id="contents_left" class="col-md-3">
					<%@ include file="/views/user/common/myPagePartnerSideBar.jsp"%>
				</div>
				<div id="content_right" class="col-md-9 m-0">
					<div class="row">
						<h3 class="h3Style col-12">
							<span class="inquiryTitle">1:1 문의</span>
						</h3>
					</div>
					<div class="row table_box">
						<div class="col-12 p-0">
							<div class="inquiry_title row m-0 p-0">
								<div class="col-1">NO</div>
								<div class="col-md-2 d-none d-md-block">카테고리</div>
								<div class="col-5">제목</div>
								<div class="col-3 col-md-2">작성일</div>
								<div class="col-3 col-md-2">답변상태</div>
							</div>
							<% if(list.size()!=0) { %>
								<% int i = list.size();  %>
								<% for(Inquiry inqu : list) { %>
								<div class="inquiry_text row m-0 p-0">
									<div class="inquiry_content col-1"><%= i-- %></div>
									<div class="inquiry_content col-md-2 d-none d-md-block">
										<% if(inqu.getInquiryCartegory().equals("RESERVATION")) { %>
											예약관련
										<% } else if(inqu.getInquiryCartegory().equals("CANCEL")) {%>
											취소관련
										<% } else { %>
											기타문의
										<% } %>
									</div>
									<div class="inquiry_content col-5"><a href="/InquiryRead.ss?inquiryNo=<%=inqu.getInquiryNo()%>"><%=inqu.getInquiryTitle() %></a></div>
									<div class="inquiry_content col-3 col-md-2"><%=inqu.getInquiryDate() %></div>
									<div class="inquiry_content col-3 col-md-2"><%=inqu.getInquiryAns() %></div>
								</div>
								<% } %>
							<% } else { %>
								<div class="inquiry_text row m-0 p-0">
									<div class="inquiry_content col-12">
										<center>문의한 내역이 없습니다.</center>
									</div>
								</div>
							<% } %>
							<div class="row m-0" style="text-align: center; padding: 20px 0px;">
								<div class="col-12 p-0 m-0" id="pageNaviStyle" style="text-align: center; color: black;">
									<%=pageNavi %>
								</div>
							</div>
							<div class="row m-0" style="text-align: right; padding: 20px 0px;">
								<div class="col-12 p-0 m-0" style="text-align: right;">
									<form action="/views/user/mypage/myPage_Inquiry_Write.jsp" method="post">
										<input type="submit" id="writeQuestionBtn" value="글쓰기" />
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<%@ include file="/views/user/common/footer.jsp"%>
		</div>
	</div>
	
	<script>
		$(".aStyle").eq(1).removeClass('aHover');
		$(".spanLi").eq(1).addClass('ClickStyle')
	</script>
   	<script>
   		var windowWidth;
   		
   		$(window).innerWidth(function() {
   			if($(this).width() <= 954) {
   				$('.table_box').css('font-size','14px');
   			} else {
   				$('.table_box').css('font-size','16px');
   			}
   		});
		$(window).resize(function() {
			windowWidth = $(this).width();
			if(windowWidth <= 954) {
				$('.table_box').css('font-size','14px');
			} else {
				$('.table_box').css('font-size','16px');
			}
		});
	</script>
</body>
</html>