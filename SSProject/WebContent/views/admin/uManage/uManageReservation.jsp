<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자-사용자</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<%@ include file="../adminForm/adminStyle.jsp" %>

<div id="wrapper">
	<%@ include file ="../adminForm/uManageSidebar.jsp" %>
	<!--navSNB-->
	
    <div id="fluid" class="container-fluid">
		<%@ include file = "../adminForm/header.jsp" %>
        <!-- header -->
        
        <div id="content" class="row padding1 bgColor1"> <!--id를 content로 주어서 구분이 명확해지고 row클래스에 추가-->
			<div id="whiteBoard" class="col-12 padding1 bgColor2"> <!--divRadius를 whiteboard로 변경. col-12클래스 추가-->
				<div id="inquiry" class="padding1">예약 목록</div>
            	<hr>
            	    
				<div>
					<div id="selectAlign" class="padding1">
						<form action="/searchReservation.ss" method="post">
			    	        <select name="selectWord" class="padding2 bgColor2">
			  					<option value="resNo">예약 번호</option>
			        	        <option value="memberId">아이디</option>
			        	        <option value="resInfoName">이름</option>
			        	        <option value="subName">공간명</option>
			                </select>
					        
							<input type="text" name="keyword" placeholder="검색어" class="padding2 bgColor2"/> <!--name="keyword" 추가 -->
							<button type="submit" id="searchBtn" class="padding2"> <!--btnOp클래스를 searchBtn아이디로 변경 type제거(검색어를 다른페이지로 보내는 것이 아닌, 검색어로 현재 페이지에 정보를 가져오는것) hoverColor클래스추가(깜빡이는 동작) -->
							    <i class="fas fa-search"></i>
							</button>
						</form>
					</div>
		
					<table class="tableStyle"> <!--infoTable클래스 추가-->
				        <tr>
	                        <th>예약 번호</th>
	                        <th>아이디</th>
	                        <th>이름</th>
	                        <th>연락처</th>
	                        <th>공간명</th>
	                        <th>예약 날짜</th>
	                        <th>이용 날짜</th>
	                       	<th>인원</th>
	                       	<th>금액</th>
				        </tr>
				        <c:choose>
				        	<c:when test="${empty rList}">
				        		<td colspan=9 align="center">예약 정보가 없습니다.</td>
				        	</c:when>
							<c:otherwise>
				        		<c:forEach items="${rList }" var="r" varStatus="i" step="1">
				        		<tr>
				     				<td>${r.resNo }</td>
				     				<td>${uList[i.index].memberId }</td>
				     				<td>${riList[i.index].resInfoName }</td>
				     				<td>${riList[i.index].resInfoPhone }</td>
				     				<td>${ssList[i.index].subName }</td>				     					
				     				<td>${r.resRecordDate }</td>
				     				<td>${r.resDate }</td>
				     				<td>${r.resPeople }</td>
				     				<td>${r.userCost }</td>		
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
	$('.navGNB').eq(1).addClass('mangoBgcolor'); //선택한 탭 색칠
	$('.category').parents('a').eq(3).removeClass('hoverColor'); //선택한 메뉴 색칠
</script>

</body>
</html>