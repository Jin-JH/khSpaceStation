<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="ss.mango.user.Inquiry.model.vo.Inquiry"%>
<%@ page import="ss.mango.user.Inquiry.model.vo.InquiryAnswer" %>
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

        #contents_read {
            height: 80%;
            padding: 0;
            margin: 0;
        }

        #contents_read_right {
            padding: 50px 30px;
            max-width: 1000px;
        }
		
		.inquiry_read_title_row {
			height: 60px;
			line-height: 60px;
			background-color: #EBEBEB;
		}
		.inquiry_read_title_row_span {
			white-space: nowrap;
		}
		.inquiry_read_content_row {
			height: 400px;
			padding: 15px 0px;
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
        .inquiry_read_btn {
            /* border-radius: 5px;
            padding: 15px 50px; */
		   background-color: white;
		   border: 1px solid #EBEBEB;
		   margin-right: 0px;
		   padding: 12px 50px;
		   border-radius: 7px;
		   font-size:14px;
        }
        .inquiry_read_btn:hover {
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
			Inquiry inqu = (Inquiry)request.getAttribute("Inquiry");
			InquiryAnswer ia = (InquiryAnswer)request.getAttribute("InquiryAnswer");
		%>
		<div class="main-content" id="container">
			<div id="contents_read" class="row">
				<div id="contents_read_left" class="col-md-3">
					<% if(m.getMemberCode().substring(0,1).equals("u")) { %>
						<%@ include file="/views/user/common/myPageSideBar.jsp"%>
					<% } else { %>
						<%@ include file="/views/user/common/myPagePartnerSideBar.jsp"%>
					<% } %>
				</div>
				<div id="contents_read_right" class="col-md-9 m-0">
					<div class="row">
						<h3 class="h3Style col-12">
							<span class="inquiryTitle">1:1 문의</span>
						</h3>
					</div>
					<div class="row inquiry_read_title_row" style="border-top:2px solid chocolate; border-bottom: 1px solid #EBEBEB;">
						<div class="col-8">
							<span class="inquiry_read_title_row_span" style="margin-left: 20px; font-weight: bold"><%= inqu.getInquiryTitle() %></span>
						</div>
						<div class="col-4" style="text-align: right">
							<span class="inquiry_read_title_row_span" style="margin-right: 20px;"><%= inqu.getInquiryDate() %></span>
						</div>
					</div>
					<div class="row inquiry_read_content_row" style="border-top:1px solid #EBEBEB; border-bottom: 1px solid #EBEBEB;">
						<div class="col-12">
							<%= inqu.getInquiryContent() %>
						</div>
					</div>
					<% if(ia!=null) { %>
						<div class="row" style="margin-top: 100px;">
							<h3 class="h3Style col-12">
								<span class="inquiryTitle">문의 답변</span>
							</h3>
						</div>
						<div class="row inquiry_read_title_row" style="border-top:2px solid chocolate; border-bottom: 1px solid #EBEBEB;">
							<div class="col-8">
								<span class="inquiry_read_title_row_span" style="margin-left: 20px; font-weight: bold"><%=ia.getAnswerTitle() %></span>
							</div>
							<div class="col-4" style="text-align: right">
								<span class="inquiry_read_title_row_span" style="margin-right: 20px;"><%=ia.getAnswerDate() %></span>
							</div>
						</div>
						<div class="row inquiry_read_content_row" style="border-top:1px solid #EBEBEB; border-bottom: 1px solid #EBEBEB;">
							<div class="col-12">
								<%=ia.getAnswerContent() %>
							</div>
						</div>
					<% } else { %>
						<div class="row" style="margin-top: 100px;">
							<h3 class="h3Style col-12">
								<span class="inquiryTitle">문의 답변</span>
							</h3>
						</div>
						<div class="row inquiry_read_title_row" style="border-top:2px solid chocolate; border-bottom: 1px solid #EBEBEB;">
							<div class="col-8">
								<span class="inquiry_read_title_row_span" style="margin-left: 20px; font-weight: bold">답변제목</span>
							</div>
							<div class="col-4" style="text-align: right">
								<span class="inquiry_read_title_row_span" style="margin-right: 20px;"></span>
							</div>
						</div>
						<div class="row inquiry_read_content_row" style="border-top:1px solid #EBEBEB; border-bottom: 1px solid #EBEBEB;">
							<div class="col-12">
								아직 답변이 등록되지 않았습니다.
							</div>
						</div>
					<% } %>
					<div class="row" style="text-align: right; padding: 20px 0px;">
						<div class="col-12 p-0 m-0" style="text-align: right;">
							<% if(m.getMemberCode().substring(0, 1).equals("u")) { %>
								<a href="/InquiryListPage.ss"><input type="button" class="inquiry_read_btn" value="목록" /></a>
							<% } else { %>
								<a href="/InquiryPartnerListPage.ss"><input type="button" class="inquiry_read_btn" value="목록" /></a>
							<% } %>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<%@ include file="/views/user/common/footer.jsp"%>
		</div>
	</div>
	<% if(m.getMemberCode().substring(0, 1).equals("u")) { %>
		<script>
			$(".aStyle").eq(2).removeClass('aHover');
			$(".spanLi").eq(2).addClass('ClickStyle')
		</script>
	<% } else { %>
		<script>
		$(".aStyle").eq(1).removeClass('aHover');
		$(".spanLi").eq(1).addClass('ClickStyle')
	</script>
	<% } %>
</body>
</html>