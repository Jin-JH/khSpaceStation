<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자-사용자</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<style>
	.subject{
		font-size: 25px;
		font-weight: 400;
		color: gray;
	}
	.thStyle{
		width: 20%;
		color:gray;
		background-color: rgba(211, 211, 211, 0.3);
	}
	.thStyle-sub{
		width: 10%;
		color:gray;
		background-color: rgba(211, 211, 211, 0.3);
	}
	.tableStyle td{
		text-align: left;
	}
	input[name=answerTitleData]{
		width: 50%;
		height:30px;
	}
	textarea[name=answerContentData]{
		width: 90%;
		height: 300px;
		overflow: auto;
		resize: none;
	}
	
	input, textarea:focus{
		outline: none;
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
	#answerForm{
		border: none;
	}
</style>
<body>
<%@ include file="../adminForm/adminStyle.jsp" %>

<div id="wrapper">
	<%@ include file ="../adminForm/uManageSidebar.jsp" %>
	<!--navSNB-->
	
    <div id="fluid" class="container-fluid">
		<%@ include file = "../adminForm/header.jsp" %>
        <!-- header -->
        
        <div id="content" class="row padding1 bgColor1">
        	
			<div id="whiteBoard" class="col-12 padding1 bgColor2">
				<div id="inquiry" class="padding1">${inquiry.inquiryNo }번 문의사항 답변</div>
            	<hr>
            	    
				<div>
					<table class="tableStyle">
				        <tr>
	                        <th class="thStyle">문의일</th>
	                        <td colspan="5">${inquiry.inquiryDate }</td>
				        </tr>
				        <tr>
	                        <th class="thStyle">문의한 사용자</th>
	                        <td colspan="5">${inquiry.memberId }</td>
				        </tr>
				        
				        <tr>
	                        <th class="thStyle">제목</th>
	                        <td colspan="5"><input type="text" name="answerTitleData"></td>
				        </tr>
				        <tr>
	                        <th class="thStyle">내용</th>
	                        <td colspan="5"><textarea name="answerContentData"></textarea></td>
				        </tr>
				        
				        <tr>
	                        <th class="thStyle">작성자</th>
	                        <td>${sessionScope.admin.adminId }</td>
	                        <th class="thStyle-sub">직급</th>
	                        <td>${sessionScope.admin.position }</td>
	                        <th class="thStyle-sub">답변일</th>
	                        <td id="today"></td>
				        </tr>
					</table>
				</div>
			</div><!-- whiteBoard -->
			
			<div class="col-12">
				<button type="button" id="cancelBtn" class="btnStyle">취소</button>
				<form action="/userQuestionAnswer.ss?inquiryNo=${inquiry.inquiryNo }" method="post" id="answerForm">
					<input type="hidden" name="answerTitle"/>
					<input type="hidden" name="answerContent"/>
					<button type="button" id="answerBtn" class="btnStyle">보내기</button>
				</form>
			</div>
			
		</div><!--content-->

    </div><!--fluid-->

</div><!--wrapper-->

<script>
	$('.navGNB').eq(1).addClass('mangoBgcolor'); //선택한 탭 색칠
	$('.category').parents('a').eq(0).removeClass('hoverColor'); //선택한 메뉴 색칠
	
	$(function(){
		$('#cancelBtn').click(function(){
			/* location.href="/views/admin/pManage/pManageQuestionText.jsp"; */
			history.back(-1);
		});
		
		var date = new Date();
		$('#today').html(date.getFullYear()+"."+(date.getMonth()+1)+"."+date.getDate());
		
		$('#answerBtn').click(function(){
			var answerTitle = $('input[name=answerTitleData]').val();
			var answerContent = $('textarea[name=answerContentData]').val();
			
			$('input[name=answerTitle]').val(answerTitle);
			$('input[name=answerContent]').val(answerContent);
			
			$('#answerForm').submit();
		});
	});
</script>
<c:choose>
	<c:when test="${result==true }">
		<script>
			$(function(){
				alert("답변 완료!");
				location.replace("/userQuestion.ss");
			});
		</script>
	</c:when>
	<c:when test="${result==false }">
		<script>
			$(function(){
				alert("답변 실패...");
			});
		</script>
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>
</body>
</html>