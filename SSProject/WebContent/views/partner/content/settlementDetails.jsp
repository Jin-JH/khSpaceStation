<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 정산 내역  -->
	<%@ include file="/views/partner/partnerForm/head.jsp"%>
	<style>
.tableStyle tr th {
	border: 1px solid lightgrey;
}

#selectDate>div>span {
	color: gray;
	font-size: 17px;
}

#searchDateBtn {
	background-color: #9614EF;
	color: white;
	width: 45px;
	height: 40px;
	line-height: 40px;
	text-align: center;
	border: 1px solid #9614EF;
	transform:translate(0,10px);
}

.selectDate{
	border: 1px solid lightgrey;
	border-radius: 5px;
	padding: 5px;
}

</style>
<!-- 정산내역 -->

	<div id="wrapper">
		<div id="fluid" class="container-fluid">
			<!-- header -->
			<div id="content" class="row padding1 bgColor1">

				<div id="whiteBoard" class="col-12 padding1 bgColor2">
					<div id="inquiry" class="padding1">정산 내역</div>
					<hr>

					<div>
						<div id="selectDate" class="padding1 row">
							<div class="col-md-6">
								<span>정산기준일</span><br> 
									<input type="date" min="1960-01-01" max="2030-12-31" class="selectDate" name="startDate"/> 
									<input type="date" min="1960-01-01" max="2030-12-31" class="selectDate" name="endDate"/>
							</div>
							<div class="col-md-6" id="selectAlign">
								<button id="searchDateBtn" class="padding2">
									<!--btnOp클래스를 searchBtn아이디로 변경 type제거(검색어를 다른페이지로 보내는 것이 아닌, 검색어로 현재 페이지에 정보를 가져오는것) hoverColor클래스추가(깜빡이는 동작) -->
									<i class="fas fa-search"></i>
								</button>
							</div>
						</div>

						<table class="tableStyle">
							<!--infoTable클래스 추가-->
							<tr>
								<th>정산 번호</th>
								<th>매출 금액</th>
								<th>수수료</th>
								<th>정산 금액</th>
								<th>정산기준일</th>
								<th>정산발행일</th>
								<th>입금유무(Y/N)</th>
							</tr>
							
							<!-- if문 추가 -->
							<% %>
							
						</table>
					</div>
				</div>
				<!-- whiteBoard -->


			</div>
			<!--content-->
		</div>
		<!--fluid-->
	</div>
	<!--wrapper-->

	<script>
		$('.navGNB').eq(0).addClass('mangoBgcolor'); //선택한 탭 색칠
		$(".accordian").hide(); //소메뉴 전부 가리기
		$('.category').parents('a').eq(3).removeClass('hoverColor'); //선택한 메뉴 색칠
	</script>