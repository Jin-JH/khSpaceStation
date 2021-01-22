<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.util.ArrayList" %>
        <%@ page import="kr.or.ss.reservationBoard.model.vo.AllReservation" %>
        <%@ page import="ss.mango.user.member.model.vo.Member" %>
        <%@ page import="kr.or.ss.reservationBoard.model.vo.ReservationPageData" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#calendar{
float:left;
}
</style>
</head>
<body>
<%@ include file="/views/partner/partnerForm/header.jsp" %>

<%@ include file="/views/partner/partnerForm/contentForm.jsp" %>
<% 
	//Member m = (Member)session.getAttribute("member");
	ReservationPageData rpd =(ReservationPageData)request.getAttribute("pageData");
	ArrayList<AllReservation> list = rpd.getList();
	String pageNavi = rpd.getPageNavi();
	%>
<div id="wrapper">
	<div id="content" class="container-fluid">

<!-- header -->

        <div id="content" class="row padding1 bgColor1"> <!--id를 content로 주어서 구분이 명확해지고 row클래스에 추가-->
			<div id="whiteBoard" class="col-12 padding1 bgColor2"> <!--divRadius를 whiteboard로 변경. col-12클래스 추가-->
				<div id="inquiry" class="padding1">예약완료 목록 ()</div>
            	<hr>
            	    
				<div>
					<div id="selectAlign" class="padding1">
									<span id="calendar">
                                    <input type="date" min="1960-01-01" max="2030-12-31" id="startDate" name="startDate"/>
                                    </span>
		    	       
						<button id="searchBtn" class="padding2"> <!--btnOp클래스를 searchBtn아이디로 변경 type제거(검색어를 다른페이지로 보내는 것이 아닌, 검색어로 현재 페이지에 정보를 가져오는것) hoverColor클래스추가(깜빡이는 동작) -->
						    <i class="fas fa-search"></i>
						</button>
					</div>
				
					<table class="tableStyle"> <!--infoTable클래스 추가-->
				        <tr>
	                        <th>예약 번호</th>
	                        <th>예약자</th>
	                        <th>세부공간명</th>
	                        <th>신청일</th>
	                        <th>진행상태</th>
	                       	
				        </tr> 
				        <%
				        if(m!=null){
				        for(AllReservation all : list){
				        %>
				        <tr>
				        <td><%=all.getResNO() %></td>
				        <td><%=all.getResInfoName() %></td>
				        <td><%=all.getSubName() %></td>
				        <td><%=all.getResRecordDate() %></td>
				        <td><%=all.getResState() %></td>
				        </tr>
				        <%
				        }
				        %>
					</table>
					<div align="center" id="navi">
						<%=pageNavi %>
						</div>
					<%} %>	
				</div>    
			</div><!-- whiteBoard -->
		</div><!--content-->
    </div><!--"fluid"-->
</div><!--wrapper-->







</body>
</html>




