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
	.subject{
		font-size: 25px;
		font-weight: 400;
		color: gray;
	}
	.tableStyle th{
		width: 20%;
		color:gray;
		background-color: rgba(211, 211, 211, 0.3);
	}
	.tableStyle td{
		text-align: left;
	}
	
	/* 버튼 스타일 */
	.btnStyle{
		width: 70px;
		height: 40px;
		float:right;
		color: #FF9614;
		background-color: white;
		border: 1px solid #FF9614;
		border-radius: 10px;
		font-weight: 600;
		margin-left: 20px;
		
		animation-duration: 0.5s;
		animation-fill-mode	: forwards;
	}
	.btnStyle:focus{
		outline: none;
	}
	.btnStyle:hover{
		animation-name: hoverin;
	}
	@keyframes hoverin{
		from{
		}
		to{
			color: white;
			background-color: #FF9614;
		}
	}
	
	textarea[name=QuestionText]{
		width: 90%;
		height: 300px;
		overflow: auto;
		resize: none;
	}
	textarea:focus{
		outline: none;
	}
	
	textarea[name=answerContentData]{
		width: 90%;
		height: 300px;
		overflow: auto;
		resize: none;
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
				<div id="inquiry" class="padding1">${inquiry.inquiryNo }번 문의사항</div>
            	<hr>
            	    
				<div>
					<table class="tableStyle">
				        <tr>
	                        <th>작성일</th>
	                        <td>${inquiry.inquiryDate }</td>
				        </tr>
				        <tr>
	                        <th>제목</th>
	                        <td>${inquiry.inquiryTitle }</td>
				        </tr>
				        <tr>
	                        <th>본문</th>
	                        <td><textarea readonly name="QuestionText">${inquiry.inquiryContent }</textarea></td>
	                        
				        </tr>
				        <tr>
	                        <th>답변 상태</th>
	                        <td>
	                        	<c:choose>
	                        		<c:when test="${inquiry.inquiryAns == 'N'.charAt(0) }">
	                        			답변 대기
	                        		</c:when>
	                        		<c:otherwise>
	                        			답변 완료
	                        		</c:otherwise>
	                        	</c:choose>
	                        </td>
				        </tr>
				        <tr>
	                        <th>작성자</th>
	                        <td>${inquiry.memberId }</td>
				        </tr>
					</table>
					<c:if test="${!empty inquiryAnswer }">
						<br><hr>
						<div id="inquiry" class="padding1">답변</div>
						<div>
						<table class="tableStyle">
					        <tr>
		                        <th class="thStyle">답변일</th>
		                        <td colspan="5">${inquiryAnswer.answerDate }</td>
					        </tr>
					        <tr>
		                        <th class="thStyle">제목</th>
		                        <td colspan="5">${inquiryAnswer.answerTitle }</td>
					        </tr>
					        <tr>
		                        <th class="thStyle">내용</th>
		                        <td colspan="5"><textarea readonly name="answerContentData">${inquiryAnswer.answerContent }</textarea></td>
					        </tr>
					        <tr>
		                        <th class="thStyle">답변 작성자</th>
		                        <td colspan="5">${inquiryAnswer.adminId }</td>
					        </tr>
						</table>
						</div>
					</c:if>
				</div>
			</div><!-- whiteBoard -->
			
			<div class="col-12">
				<button type="button" id="listBtn" class="btnStyle">목록</button>
				<c:if test="${empty inquiryAnswer }">
					<button type="button" id="answerBtn" class="btnStyle">답변</button>
				</c:if>
			</div>
			
		</div><!--content-->

    </div><!--fluid-->

</div><!--wrapper-->

<script>
	$('.navGNB').eq(2).addClass('mangoBgcolor'); //선택한 탭 색칠
	$(".accordian").hide(); //선택한 메뉴 제외하고 나머지 메뉴 숨김. ready() 함수로 처리하면 이쁘지가 않다.
	$('.category').parents('a').eq(0).removeClass('hoverColor'); //선택한 메뉴 투명도 제거
	
	$(function(){
		$('#listBtn').click(function(){
			history.back(-1);
		});
		
		$('#answerBtn').click(function(){
			location.href="/partnerQuestionText.ss?pmqt=pmqt&inquiryNo="+${inquiry.inquiryNo };
		});
	});
	
</script>

</body>
</html>