<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<%@ include file="../adminForm/adminStyle.jsp" %>

<div id="wrapper">
	<%@ include file ="../adminForm/aManageSidebar.jsp" %>
	<!--navSNB-->
	
    <div id="fluid" class="container-fluid">
		<%@ include file = "../adminForm/header.jsp" %>
        <!-- header -->
        
        <div id="content" class="row padding1 bgColor1"> <!--id를 content로 주어서 구분이 명확해지고 row클래스에 추가-->
			
			<%@ include file="../chart/charAdminStats.jsp" %>
			
			<div id="whiteBoard" class="col-12 padding1 bgColor2">
				<div id="inquiry" class="padding1">연월일별 매출</div>
				<hr>
				<table class="tableStyle"> <!--infoTable클래스 추가-->
				        <tr>
	                        <th>오늘 매출액</th>
	                        <th>이번달 매출액</th>
	                        <th>올해 매출액</th>
	                        <th style="color:#FF9614;">총 매출액</th>
				        </tr>
				        <tr>
				        	<td>${resultArr[0] } 만</td>
				        	<td>${resultArr[1] } 만</td>
				        	<td>${resultArr[2] } 만</td>
				        	<td>${resultArr[3] } 만</td>
				        </tr>
					</table>
			</div>
			
		</div><!--content-->

    </div><!--fluid-->

</div><!--wrapper-->

<script>
	$('.navGNB').eq(0).addClass('mangoBgcolor'); //선택한 탭 색칠
	$(".accordian").hide(); //소메뉴 전부 가리기
	$('.category').parents('a').eq(2).removeClass('hoverColor'); //선택한 메뉴 색칠
</script>

</body>
</html>