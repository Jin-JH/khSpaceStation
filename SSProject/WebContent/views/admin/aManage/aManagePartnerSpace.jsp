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
			<%@ include file="../chart/charPartnerSpace.jsp" %> <!-- 그래프 -->
			
			<div id="whiteBoard" class="col-12 padding1 bgColor2"> <!--divRadius를 whiteboard로 변경. col-12클래스 추가-->
				<div id="inquiry" class="padding1">최근 등록한 공간</div>
            	<hr>
            	    
				<div>
					<table class="tableStyle"> <!--infoTable클래스 추가-->
				        <tr>
				        	<th>공간 번호</th>
	                        <th>아이디</th>
	                        <th>이름</th>
	                        <th>공간 이름</th>
	                        <th>공간 주소</th>
	                        <th>등록일</th>
				        </tr>
				        <c:choose>
				        	<c:when test="${empty list }">
				        		<tr><td colspan=6 align="center">최근 등록된 공간이 없습니다.</td></tr>
				        	</c:when>
				        	<c:otherwise>
				        		<c:forEach items="${list }" var="s" varStatus="i" step="1">
				        			<tr>
				        				<td>${s.spaceNo }</td>
				        				<td>${pList[i.index].memberId }</td>
				        				<td>${pList[i.index].memberName }</td>
				        				<td>${s.spaceName }</td>
				        				<td>${s.spaceAddress }</td>
				        				<td>${s.spaceDate }</td>
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
	$(".accordian").eq(0).hide(); //선택한 메뉴 제외하고 나머지 메뉴 숨김. ready() 함수로 처리하면 이쁘지가 않다.
	$('.accList').eq(1).removeClass('hoverColor'); //선택한 메뉴 투명도 제거
	$('.accList').eq(1).children('.arrow').removeClass('fa-angle-right');
    $('.accList').eq(1).children('.arrow').addClass('fa-angle-down');
	$('.accordian>a').eq(3).css('color','#FF9614'); //선택한 소메뉴 색칠
</script>

</body>
</html>