<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.or.ss.space.model.vo.PartnerSpace"%>
<%@ page import="kr.or.ss.space.model.vo.SpaceCost"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.content-body {
	width: 90%;
	height: 100%;
	padding: 70px 50px;
	margin: auto auto;
}

.table {
	width: 100%;
	background-color: #fafafa;
}

.heads {
	background-color: #9614EF;
	color: white;
	font-size: 30px;
	text-align: center;
	height: 60px;
	line-height: 60px;
}

.table-body {
	padding: 0 10px;
}

table {
	width: 100%;
}
</style>
</head>
<body>
	<%@ include file="/views/partner/partnerForm/head.jsp"%>
	

	<!-- 공간등록 -->
	<div id="wrapper">

		<!--navSNB-->

		<div id="fluid" class="container-fluid">
			<!-- header -->

			<div id="content" class="row padding1 bgColor1">
				<!--id를 content로 주어서 구분이 명확해지고 row클래스에 추가-->

<%-- 
<%
	ArrayList<PartnerSpace> psList = (ArrayList<PartnerSpace>)request.getAttribute("psList");
	ArrayList<SpaceCost> scList = (ArrayList<SpaceCost>)request.getAttribute("scList");
	int sadNull = (int)(request.getAttribute("sadNull"));
%>	 --%>

	
	<%@ include file="/views/partner/partnerForm/dashTableStyle.jsp"%>
	<%@ include file="/views/partner/content/dashTable.jsp"%>
	<%-- <div id="whiteBoard" class="col-12 padding1 bgColor2">
		<div id="inquiry" class="padding1">
			<h2>DashTable</h2>
		</div>
		<hr>

		<div>
			<div class="row" id="dashTable">
				<div class="col-md-6" id="table1">
					<table>
						<tr>
							<th colspan="2">문의현황</th>
						</tr>
						<tr>
							<th>사용자 문의 미확인 내역</th>
							<th>전체내역</th>
						</tr>
						<tr>
							<td><a href="#">0건</a></td>
							<td><a href="#">10건</a></td>
						</tr>
					</table>
				</div>

				<div class="col-md-6" id="table2">
					<table>
						<tr>
							<th colspan="3"><a href="/monthly.do">월간현황</a></th>
						</tr>
						<tr>
							<th>월 매출액</th>
							<th>예약건수</th>
							<th>취소 건수</th>
						</tr>
						<tr>
							<%if(sadNull==1){ %>
							<td>0원</td>
							<td>0건</td>
							<td>0건</td>
							<%} else{%>
							<td><%=scList.get(0).getCost() %>원</td>
							<td><%=scList.get(0).getStateN() %>건</td>
							<td><%=scList.get(0).getStateY() %>건</td>
							<%} %>
						</tr>
					</table>
				</div>
			</div>

			<div class="row">
				<div col-md-12>&nbsp;</div>
				<!-- 공백 -->
			</div>

			<div class="row" id="dashTable">
				<div class="col-md-12" id="table3">
					<table>
						<tr>
							<th colspan="7"><a href="#">오늘 회의실 예약 현황</a></th>
						</tr>
						<tr>
							<th>예약번호</th>
							<th>고객명</th>
							<th>센터명</th>
							<th>회의실명</th>
							<th>이용시간</th>
							<th>총금액</th>
							<th>수수료</th>
						</tr>
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
							<td>6</td>
							<td>7</td>
						</tr>
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
							<td>6</td>
							<td>7</td>
						</tr>
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
							<td>6</td>
							<td>7</td>
						</tr>
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
							<td>6</td>
							<td>7</td>
						</tr>
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
							<td>6</td>
							<td>7</td>
						</tr>
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
							<td>6</td>
							<td>7</td>
						</tr>
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
							<td>6</td>
							<td>7</td>
						</tr>
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
							<td>6</td>
							<td>7</td>
						</tr>
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
							<td>6</td>
							<td>7</td>
						</tr>
						<tr>
							<th>총예약건수</th>
							<td colspan="6">13건</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- whiteBoard --> --%>


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

</body>
</html>