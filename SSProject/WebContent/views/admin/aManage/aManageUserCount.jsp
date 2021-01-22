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
        
        <div id="content" class="row padding1 bgColor1">
			<%@ include file="../chart/charUserCount.jsp" %> <!-- 그래프 -->
			
			<div id="whiteBoard" class="col-12 padding1 bgColor2">
				<div id="inquiry" class="padding1">신규 사용자 목록</div>
            	<hr>
            	    
				<div>
					<table class="tableStyle">
				        <tr>
	                        <th>아이디</th>
	                        <th>이름</th>
	                        <th>연락처</th>
	                        <th>이메일</th>
	                        <th>가입일</th>
				        </tr>
				        <c:choose>
				        	<c:when test="${empty list }">
				        		<tr><td colspan=5 align="center">최근 가입한 사용자가 없습니다.</td></tr>
				        	</c:when>
				        	<c:otherwise>
				        		<c:forEach items="${list }" var="u">
				        			<tr>
				        				<td>${u.memberId }</td>
				        				<td>${u.memberName }</td>
				        				<td>${u.memberPhone }</td>
				        				<td>${u.memberEmail }</td>
				        				<td>${u.memberDate }</td>
				        			</tr>
				        		</c:forEach>
				        	</c:otherwise>
				        </c:choose>
					</table>
				</div>    
			</div><!-- whiteBoard -->
		</div><!--content-->

    </div><!--fluid-->

</div><!--wrapper-->

<script>
	$('.navGNB').eq(0).addClass('mangoBgcolor'); //선택한 탭 색칠
	$(".accordian").eq(1).hide(); //선택한 메뉴 제외하고 나머지 메뉴 숨김. ready() 함수로 처리하면 이쁘지가 않다.
	$('.accList').eq(0).removeClass('hoverColor'); //선택한 메뉴 투명도 제거
	$('.accList').eq(0).children('.arrow').removeClass('fa-angle-right');
    $('.accList').eq(0).children('.arrow').addClass('fa-angle-down');
	$('.accordian>a').eq(0).css('color','#FF9614'); //선택한 소메뉴 색칠
</script>

</body>
</html>