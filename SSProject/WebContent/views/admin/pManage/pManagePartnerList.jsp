<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자-사업자</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<%@ include file="../adminForm/adminStyle.jsp" %>

<div id="wrapper">
	<%@ include file ="../adminForm/pManageSidebar.jsp" %>
	<!--navSNB-->
	
    <div id="fluid" class="container-fluid">
		<%@ include file = "../adminForm/header.jsp" %>
        <!-- header -->
        
		<div id="content" class="row padding1 bgColor1"> <!--id를 content로 주어서 구분이 명확해지고 row클래스에 추가-->
			<div id="whiteBoard" class="col-12 padding1 bgColor2"> <!--divRadius를 whiteboard로 변경. col-12클래스 추가-->
				<div id="inquiry" class="padding1">사업자 목록</div>
            	<hr>
            	    
				<div>
					<div id="selectAlign" class="padding1">
						<form action="/searchPartnerList.ss" method="post">
			    	        <select name="selectWord" class="padding2 bgColor2">
			  					<option value="memberId">아이디</option>
			        	        <option value="memberName">이름</option>
			                    <option value="businessName">상호명</option>
			                    <option value="ceoName">대표명</option>
			                    <option value="memberEnd">탈퇴 여부</option>
			                </select>
						        
							<input type="text" name="keyword" placeholder="검색어" class="padding2 bgColor2"/> <!--name="keyword" 추가 -->
							<button id="searchBtn" class="padding2"> <!--btnOp클래스를 searchBtn아이디로 변경 type제거(검색어를 다른페이지로 보내는 것이 아닌, 검색어로 현재 페이지에 정보를 가져오는것) hoverColor클래스추가(깜빡이는 동작) -->
							    <i class="fas fa-search"></i>
							</button>
						</form>
					</div>
				
					<table class="tableStyle">
				        <tr>
	                        <th>아이디</th>
	                        <th>이름</th>
	                        <th>이메일</th>
	                        <th>연락처</th>
	                        <th>상호명</th>
                           	<th>대표명</th>
                           	<th>사업자 등록번호</th>
	                        <th>가입일</th>
	                        <th>탈퇴 요청일</th>
	                        <th>탈퇴 여부</th>
				        </tr>
				        
				        <c:choose>
				        	<c:when test="${empty list}">
				        		<tr>
				        			<td colspan=10 align="center">사업자 정보가 없습니다.</td>
				        		</tr>
				        	</c:when>
				        	<c:otherwise>
					        	<c:forEach items="${list}" var="p">
					        	<tr>
					        		<td>${p.memberId }</td>
					        		<td>${p.memberName }</td>
					        		<td>${p.memberEmail }</td>
					        		<td>${p.memberPhone }</td>
					        		<td>${p.businessName }</td>
					        		<td>${p.ceoName }</td>
					        		<td>${p.businessLicenseNumber }</td>
					        		<td>${p.memberDate }</td>
					        		
					        		<td>
					        			<c:choose>
					        				<c:when test="${empty p.memberEndDate}">
					        					없음
					        				</c:when>
					        				<c:otherwise>
					        					${p.memberEndDate}
					        				</c:otherwise>
					        			</c:choose>
					        		</td>
					        		
					        		
					        		<td>
					        			<c:choose>
					        				<c:when test="${p.memberEnd == 'N'.charAt(0)}">
					        					사용중
					        				</c:when>
					        				<c:otherwise>
					        					<span style="border:none; color:red;">탈퇴</span>
					        				</c:otherwise>
					        			</c:choose>
					        		</td>
					        	</tr>
					        	</c:forEach>
					        </c:otherwise>
				        </c:choose>
					</table>
					<div class="pageNaviStyle">
						<%=request.getAttribute("pageNavi").toString() %>
					</div>
				</div>    
			</div><!-- whiteBoard -->
		</div><!--content-->
	        
	</div>
	<!--fluid-->

</div>
<!--wrapper-->

<script>
	$('.navGNB').eq(2).addClass('mangoBgcolor'); //선택한 탭 색칠
	$(".accordian").hide(); //선택한 메뉴 제외하고 나머지 메뉴 숨김. ready() 함수로 처리하면 이쁘지가 않다.
	$('.category').parents('a').eq(4).removeClass('hoverColor'); //선택한 메뉴 투명도 제거
	
</script>

</body>
</html>