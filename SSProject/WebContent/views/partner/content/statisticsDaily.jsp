<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.or.ss.space.model.vo.PartnerSpace"%>
<%@ page import="kr.or.ss.space.model.vo.SpaceCost"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

<%
ArrayList<PartnerSpace> psList = (ArrayList<PartnerSpace>)request.getAttribute("psList");
ArrayList<SpaceCost> scList = (ArrayList<SpaceCost>)request.getAttribute("scList");
%>

<% 
	Calendar cal = Calendar.getInstance();

	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd(E)");
	SimpleDateFormat week = new SimpleDateFormat("E");
	
			
	Date d0 = new Date();
	d0 = new Date(d0.getTime()+(1000*60*60*24*-0));
%>




google.charts.load('current', {
	'packages' : [ 'bar' ]
});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
	var data = google.visualization.arrayToDataTable([

		[ ' ', '매출액(천원단위)', '예약건수' ], 
		<% for(int i=scList.size()-1; i>=0; i--){ %>
		<%	if(1<=i && i<=7){ %>
			[ '<%=scList.get(i).getrDate()%>', <%=scList.get(i).getCost()/1000 %>, <%=scList.get(i).getStateN() %> ],
			<%} else if(i==0){%>
			[ '<%=scList.get(i).getrDate()%>', <%=scList.get(i).getCost()/1000 %>, <%=scList.get(i).getStateN() %> ]
			<%}%>
		<%} %>
	
	]);

	var options = {
		/*chart : {
			title : 'Company Performance',
			subtitle : 'Sales, Expenses, and Profit: 2014-2017',
		},*/
		colors : [ '#FF9614', 'lightgray' ]

	};

		var chart = new google.charts.Bar(document
				.getElementById('columnchart_material'));

		chart.draw(data, google.charts.Bar.convertOptions(options));
	}
</script>

</head>

<style>
#columnchart_material {
	margin: 0 auto;
}

table{
	margin-top: 35px;
	margin-bottom: 35px;
	position: relative;
	right: 75px;
	width: 600px;
	text-align: center;
}

table tr th{
	border: 1px solid lightgrey;
	font-size: 13px;
}

table tr td{
	border: 1px solid lightgrey;
}

#columnchart_material{
	margin-top: 50px;
}

/* 통계날짜 보여지는 자리 */
#period{ 
	margin-top: 35px;
	margin-bottom: 35px;
	margin-right: 0;
	position: relative;
	text-align: center;
	font-size: 20px;
	font-weight: 600;
}

#period a{
	text-decoration: none;
	color: black;
}

.periodMenuComponent ul li{
	list-style: none;
	list-style-type: none;
}

.periodMenuComponent ul{
	display: block;
}

.periodMenuComponent li {
    display: list-item;
    text-align: -webkit-match-parent;
    padding: 5px 7px 5px 7px; /*상우하좌*/
   	
}

.periodMenuComponent{
	position: relative;
	padding: 35px 0 0 0;
	right: 70px;
	top: 55px;
}

.menuItem {
    float: left;
    position: relative;
    border: 1px solid #ddd;
    background-color: #efefef;
    /*background-color: #9614EF; */
}

#defaultClicked{
	background-color: #9614EF;
	color: white;
	border: 1px solid #9614EF;
}

#defaultClicked a{
	color: white;
}

.menuItem a{
	color: black;
}

.menuItem a:hover{
	text-decoration: none;
}



</style>

<body>
	<!-- 통계 -->
	<%@ include file="/views/partner/partnerForm/head.jsp"%>

	<div id="wrapper">
		<div id="fluid" class="container-fluid">
			<!-- header -->
			<div id="content" class="row padding1 bgColor1">
				<div id="whiteBoard" class="col-12 padding1 bgColor2">
				<div id="inquiry" class="padding1">예약 일간 통계</div>
				<hr>
				
				<div class="row staTitle">
				<!-- 타이틀 -->
				<div class="col-md-4"></div>
				<div class="col-md-3" id="period">
					<h3>
					<a href="#"><i class="fas fa-angle-left"></i></a>
					 <%=df.format(cal.getTime()) %>
					<i class="far fa-calendar-alt"></i>
					<a href="#"><i class="fas fa-angle-right"></i></a>
					</h3>
				</div>
				<!-- 오늘날짜 or 기간 -->
				<div class="periodBtnGroup col-md-5 d-lg-block d-none">
					<div class="periodMenuComponent">
						<ul class="menuList">
							<li class="menuItem" id="defaultClicked"><a href="/daily.do">일간</a></li>
							<li class="menuItem"><a href="/weekly.do">주간</a></li>
							<li class="menuItem"><a href="/monthly.do">월간</a></li>
						</ul>
					</div>
				</div>
				</div>
				
					<div id="columnchart_material" style="width: 800px; height: 500px;"></div>


					<div>
						<center>
							<table>
								<tr>
									<th>날짜</th>
									<th>총 매출</th>
									<th>수수료</th>
									<th>실지급액</th>
									<th>예약건수</th>
									<th>취소건수</th>
								</tr>
								<% for(SpaceCost sc : scList){ %>
								<% 
									int cost = sc.getCost(); 
									String date = sc.getrDate();
									
								%>
								<tr>
									<td><%=sc.getrDate() %></td>
									<td style="background-color: #efefef"><%=cost %>원</td>
									<td><%=(int)(cost*0.1) %>원</td>
									<td><%=cost-(int)(cost*0.1) %>원</td>
									<td><%=sc.getStateN() %>건</td>
									<td><%=sc.getStateY() %>건</td>
								</tr>
								<%} %>
								
							
							</table>
						</center>
					</div>

				</div>
				<!--content-->
			</div>
			<!-- whiteBoard -->
		</div>
		<!--fluid-->
	</div>
	<!--wrapper-->

	<script>
		$('.navGNB').eq(0).addClass('mangoBgcolor'); //선택한 탭 색칠
		$(".accordian").hide(); //소메뉴 전부 가리기
		$('.category').parents('a').eq(3).removeClass('hoverColor'); //선택한 메뉴 색칠
		
		$('.menuItem').on('click',function(){
			if($(this).css('background-color','#efefef')){
				$(this).css('background-color','#9614EF').css('border','1px solid #9614EF');
				$(this).children().css('color','white');
				$(this).siblings().css('background-color','#efefef')
				.css('border','1px solid #ddd').children().css('color','black');
			}
			
		});
	</script>
	
	
	
	
	
	