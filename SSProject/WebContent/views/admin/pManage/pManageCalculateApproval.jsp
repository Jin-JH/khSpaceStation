<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자-사업자</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
				<div id="inquiry" class="padding1">정산 대기 목록 (${fn:length(ciList)})</div>
            	<hr>
            	    
				<div>
					<div id="selectAlign" class="padding1">
						<form action="/searchCalculateApproval.ss" method="post">
		    	        	<select name="selectWord" class="padding2 bgColor2">
				        		<option value="memberId">아이디</option>
				        		<option value="spaceName">공간 이름</option> 
		                	</select>					        
							<input type="text" name="keyword" placeholder="검색어" class="padding2 bgColor2"/> <!--name="keyword" 추가 -->
							<button type="submit" id="searchBtn" class="padding2"> <!--btnOp클래스를 searchBtn아이디로 변경 type제거(검색어를 다른페이지로 보내는 것이 아닌, 검색어로 현재 페이지에 정보를 가져오는것) hoverColor클래스추가(깜빡이는 동작) -->
						    	<i class="fas fa-search"></i>
							</button>
						</form>
					</div>
				
					<table class="tableStyle"> <!--infoTable클래스 추가-->
				        <tr>
				        	<th>아이디</th>
				        	<th>공간 이름</th>
				        	<th>은행명</th>
				        	<th>예금주</th>
				        	<th>계좌 번호</th>
				        	<!-- <th>정산 금액</th> -->
				        	<th>정산 발행일</th>
	                        <th>정산일</th>
	                        <th>정산</th>  
				        </tr>
				        
				        <c:choose>
				        	<c:when test="${empty ciList}">
				        		<td colspan="9">처리할 정산이 없습니다</td>
				        	</c:when>
							<c:otherwise>
			              				        		
				        		<c:forEach items="${ciList }" var="ci" varStatus="i" step="1">
					        		<tr>
					     				<td>${ci.memberId }</td>
							        	<td>${ci.spaceName }</td>
							        	<td>${ci.calBank }</td>
				                        <td>${ci.calHolder }</td>
				                        <td>${ci.calAccount }</td>
				                        
											<c:forEach items="${srList }" var="sr" varStatus="j" step="1">
												<c:choose>
													<c:when test="${sr.spaceName==ci.spaceName }">
														<!--<td>${sr.calCost }</td>	  -->		
													</c:when>
													<c:otherwise>
														<td>없음</td>
													</c:otherwise>
												</c:choose>	
											</c:forEach>
				                        				                        
				                        <td>			                        	
				                        	매달 말일
										</td>
				                        <td>
											다음달 3일
				                        </td>
				                        <td class="apprStateTd">
				     						<!-- 
				     							jQuery로 바꾸기
				     							<form action="/approvalCalculateApproval.ss" method="post" class="apprStateForm">
				     								<input type = "hidden" name="memberCode" value="${ci.memberCode}"/>
				     								<input type = "submit" class="apprBtn" name="appr" value="정산"
				     									onclick="test(${srList[i.index].allCost }, ${p.memberCode})"/>
				     							</form>
				     						-->
				     						<input type = "submit" class="apprBtn apprStateForm apprCal" name="appr" value="정산" style="margin : 5px;" onclick="record(${srList[i.index].allCost }, '${ci.memberCode }')"/>
					     				</td>
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

	$('.navGNB').eq(2).addClass('mangoBgcolor'); //선택한 탭 색칠
	$(".accordian").eq(0).hide(); //선택한 메뉴 제외하고 나머지 메뉴 숨김. ready() 함수로 처리하면 이쁘지가 않다.
	$('.accList').eq(1).removeClass('hoverColor'); //선택한 메뉴 투명도 제거
	$('.accList').eq(1).children('.arrow').removeClass('fa-angle-right');
    $('.accList').eq(1).children('.arrow').addClass('fa-angle-down');
    $('.accordian>a').eq(3).css('color','#FF9614'); //선택한 소메뉴 색칠
    
	function record(allCost,memberCode){
		alert('정산 기록되었습니다.'); 
		location.href='/approvalCalculateApproval.ss?allCost='+allCost+'&memberCode='+memberCode+'&appr=정산';   	
    };
    
</script>

</body>
</html>