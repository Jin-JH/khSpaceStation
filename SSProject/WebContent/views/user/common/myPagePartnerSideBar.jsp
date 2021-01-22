<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="ss.mango.user.member.model.vo.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%@ include file="/views/user/common/__js.jsp" %>

<style>
#navigation {
   width:100%;
   margin: 0 auto;
   padding: 50px 0;
   max-width: 300px;
}

.ulStyle {
   padding: 0;
   margin: 0;
   list-style: none;
   border: 1px solid lightgray;
}

.liStyle {
   height: 85px;
   line-height: 85px;
   font-size: 17px;
   font-weight: 900;
}

.liStyle>a:hover {
   text-decoration: none;
   color: black;
   opacity: 1.0;
   cursor: pointer;
}

.liStyle>a:hover>span {
   border-left: 5px solid chocolate;
   white-space: nowrap;
}

#liMain {
   background-color: chocolate;
   color: white;
   font-size: 20px;
   text-align: left;
}

.aStyle {
   height: 100%;
   width: 100%;
   color: black;
   display: block;
   text-decoration: none;
}

.aHover {
   opacity: 0.6;
}
#icon {
   margin-right: 20px;
   margin-left: 20px;
}

.spanLi {
   padding: 0 20px;
   white-space: nowrap;
}

.ClickStyle {
   border-left: 5px solid chocolate;
   white-space: nowrap;
   text-decoration: none;
   color: black;
   cursor: pointer;
}

</style>


</head>
<body>
	<div id="navigation" class="col-12">
		<ul class="ulStyle">
			<li id="liMain" class="liStyle">
				<i id="icon" class="fas fa-user fa-lg"></i>
				<span>마이페이지</span>
			</li>
			<li class="liStyle">
				<a href="/MemberPartnerInfo.ss" class="aStyle aHover">
					<span class="spanLi">회원정보 수정</span>
				</a>
			</li>

			<li class="liStyle">
				<a href="/InquiryPartnerListPage.ss" class="aStyle aHover">
					<span class="spanLi">관리자 문의</span>
				</a>
			</li>
		</ul>
	</div>
	
	<script>
		var windowWidth;
		$(window).width(function() {
			if($(this).width() <= 767) {
				$('#navigation').css('max-width','550px');
			} else {
				$('#navigation').css('max-width','300px');
			}
		});
		$(window).resize(function() {
			windowWidth = $(this).width();
			
			if(windowWidth <= 767) {
				$('#navigation').css('max-width','550px');
			} else {
				$('#navigation').css('max-width','300px');
			}
		});
	</script>
</body>
</html>