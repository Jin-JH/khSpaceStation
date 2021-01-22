<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1:1 문의하기</title>
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
	
	#inquiry_Title {
		width: 100%;
		font-size: 30px;
		padding: 0 10px;
		margin: 50px 0;
	}
	
	.inquiry_writer_row {
		height: 70px;
		line-height: 70px;
		border-top: 1px solid lightgray;
		border-bottom: 1px solid lightgray;
		overflow: hidden;
	}
	
	.inquiry_writer_left {
		background-color: rgba(235, 235, 235, 0.4);
		font-weight: bold;
	}
	
	.inquiry_writer_right {
		padding: 15px;
	}
	
	.inquiry_writer_select {
		padding: 10px 15px;
		border: 1px solid #EBEBEB;
		border-radius: 5px;
	}
	
	.inquiry_writer_select:focus {
		outline: none;
	}
	
	.inquiry_writer_input {
		width: 100%;
		height: 100%;
		padding: 10px 15px;
		border: 1px solid #EBEBEB;
		border-radius: 5px;
	}
	
	.inquiry_writer_input:focus {
		outline: none;
	}
	
	.h3Style {
		padding: 0;
		width: 100%;
		border-left: 5px solid chocolate;
		margin-bottom: 30px;
	}
	
	.inquiry_writer_btn {
		border-radius: 5px;
		padding: 15px 50px;
	}
	
	.inquiry_writer_submit_btn {
		cursor: pointer;
		background-color: chocolate;
		color: white;
		border: none;
	}
	
	.inquiry_writer_submit_btn:hover {
		background-color: #DE844F;
		color: white;
	}
	
	.inquiry_writer_reset_btn {
		cursor: pointer;
		background-color: white;
		color: grey;
		border: 1px solid #EBEBEB;
	}
	
	.inquiry_writer_reset_btn:hover {
		background-color: grey;
		color: white;
		background-color:
	}
</style>
</head>
<body>
	<div class="wrapper">
		<div id="header">
			<%@ include file="/views/user/common/header.jsp"%>
		</div>
		<div class="main-content" id="container">
			<div id="contents" class="row">
				<div id="contents_left" class="col-md-3">
					<%@ include file="/views/user/common/myPageSideBar.jsp"%>
				</div>
				<div id="content_right" class="col-md-9 m-0">
					<div class="row">
						<h3 class="h3Style col-12">
							<span id="inquiry_Title">1:1 문의</span>
						</h3>
					</div>
					<div class="row table_box">
					<script>
						$(function() {
							$('#inquiryWriterSubmitBtn').click(function() {
								if($('input[name=inquiryTitle]').val().length<5 || $('input[name=inquiryTitle]').val().length>30) {
									alert('제목은 최소 5자 ~ 최대 30자로 입력해주세요!');
									$('input[name=inquiryTitle]').focus;
								} else {
									$('#inquirtWriteForm').submit();
								}
							});
						});
					</script>
						<form action="/Inquirywrite.ss" method="post" id="inquirtWriteForm" style="width: 100%;">
							<div class="col-12 p-0">
								<div class="row m-0 p-0 inquiry_writer_row">
									<div class="col-3 col-sm-2 inquiry_writer_left">문의유형</div>
									<div class="col-9 col-sm-10">
										<% if(m.getMemberCode().substring(0,1).equals("u")) { %>
										<select class="inquiry_writer_select" name="inquiryCartegory">
											<option value="예약관련">예약관련</option>
											<option value="취소관련">취소관련</option>
											<option value="기타문의">기타문의</option>
										</select>&nbsp;
										<% } else { %>
										<select class="inquiry_writer_select" name="inquiryCartegory">
											<option value="기타문의">기타문의</option>
										</select>&nbsp;
										<% } %>
									</div>
								</div>
								<div class="row m-0 p-0 inquiry_writer_row">
									<div class="col-3 col-sm-2 inquiry_writer_left">제목</div>
									<div class="col-9 col-sm-10 inquiry_writer_right">
										<input type="text" class="inquiry_writer_input" name="inquiryTitle" autocomplete="off"/>
									</div>
								</div>
								<div class="row m-0 p-0 inquiry_writer_row" style="height: 300px;">
									<div class="col-3 col-sm-2 inquiry_writer_left" style="line-height: 300px;">내용</div>
									<div class="col-9 col-sm-10 inquiry_writer_right">
										<textarea class="inquiry_writer_input" name="inquiryContent" style="padding-top: 0px 10px; resize: none;" maxlength="300" autocomplete="off"></textarea>
									</div>
								</div>
								<div class="row m-0" style="text-align: right; padding: 20px 0px;">
									<div class="col-12 p-0 m-0" style="text-align: center;">
										<button type="button" class="inquiry_writer_btn inquiry_writer_submit_btn" id="inquiryWriterSubmitBtn">등록</button>
										<% if(m.getMemberCode().substring(0,1).equals("u")) { %>
										<a href="/InquiryListPage.ss"><input type="button" class="inquiry_writer_btn inquiry_writer_reset_btn" value="취소" /></a>
										<% } else { %>
										<a href="/InquiryPartnerListPage.ss"><input type="button" class="inquiry_writer_btn inquiry_writer_reset_btn" value="취소" /></a>
										<% } %>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<%@ include file="/views/user/common/footer.jsp"%>
		</div>
	</div>
	
	<script>
		$(".aStyle").eq(2).removeClass('aHover');
		$(".spanLi").eq(2).addClass('ClickStyle')
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