<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자-사업자</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<style>
	/* #content{
    	min-width: 500px;
    } */
	.subject{
		font-size: 25px;
		font-weight: 400;
		color: gray;
	}
	.notice{
		width: 50%;
		padding: 0px;
	}
	.notice-list{
		border:none;
		color: #FF9614;
	}
	.notice-list:hover{
		color: #FF9614;
	}
	
	#qAaState{
		float : right;
		font-size : 15px;
	}
</style>
<body>
<%@ include file="../adminForm/adminStyle.jsp" %>

<div id="wrapper">
	<%@ include file ="../adminForm/pManageSidebar.jsp" %>
	<!--navSNB-->
	
    <div id="fluid" class="container-fluid">
		<%@ include file = "../adminForm/header.jsp" %>
        <!-- header -->
        
        <div id="content" class="row padding1 bgColor1">
        	
			<div id="whiteBoard" class="col-12 padding1 bgColor2">
				<div id="inquiry" class="padding1">사업자 문의사항 목록
				
				<select id="qAaState" class="padding2 bgColor2">
					<option style="display:none;">답변 상태</option>
					<option value="all">전체</option>
					<option value="wait">답변 대기</option>
					<option value="complete">답변 완료</option>
				</select>
				</div>
            	<hr>
            	    
				<div>
					<table class="tableStyle">
				        <tr>
	                        <th>번호</th>
	                        <th class="notice">제목</th>
	                        <th>작성자</th>
	                        <th>작성일</th>
	                        <th>답변 여부</th>
				        </tr>
				        <c:choose>
				        	<c:when test="${empty list }">
				        		<tr>
				        			<td colspan=4 align="center">문의사항이 없습니다.</td>
				        		</tr>
				        	</c:when>
				        	<c:otherwise>
				        		<c:forEach items="${list }" var="i">
				        			<tr>
				        				<td>${i.inquiryNo }</td>
				        				<td><a href="/partnerQuestionText.ss?inquiryNo=${i.inquiryNo }">${i.inquiryTitle }</a></td>
				        				<td>${i.memberId }</td>
				        				<td>${i.inquiryDate }</td>
				        				<td>
				        					<c:choose>
				        						<c:when test="${i.inquiryAns == 'N'.charAt(0) }">
				        							<span style="border:none; color:red;">대기</span>
				        						</c:when>
				        						<c:otherwise>
				        							완료
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

    </div><!--fluid-->

</div><!--wrapper-->

<script>
	$('.navGNB').eq(2).addClass('mangoBgcolor'); //선택한 탭 색칠
	$(".accordian").hide(); //선택한 메뉴 제외하고 나머지 메뉴 숨김. ready() 함수로 처리하면 이쁘지가 않다.
	$('.category').parents('a').eq(0).removeClass('hoverColor'); //선택한 메뉴 투명도 제거
	
	$(function(){
		$('.tableStyle').find('a').addClass('notice-list');
		
		$('#qAaState').change(function(){
			var inquiryState = $('#qAaState option:selected').val();
			location.replace("/partnerQuestion.ss?inquiryState="+inquiryState);
		});
	});
</script>

</body>
</html>