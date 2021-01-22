<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.util.ArrayList" %>
        <%@ page import="kr.or.ss.space.model.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

#btn_group input{

background-color:white;
color:#9614EF;
border:1px solid #9614EF;
 cursor: pointer;
padding:5px;

}
#btn_group input:hover{
background-color:#9614EF;
color:white;
}

#last_btn2{
border-radius:10px;


}
#table_margin{
margin:70px 0 30px 0;
}

</style>
</head>
<body>
<%@ include file="/views/partner/partnerForm/header.jsp" %>

<%@ include file="/views/partner/partnerForm/contentForm.jsp" %>
<%
		//Servlet에서 페이징 처리된 데이터를 꺼내는 코드
		MeetingRoomPageData mrpd = (MeetingRoomPageData)request.getAttribute("MeetingRoomPageData");
		ArrayList<MRManagement> list = mrpd.getList();
		String pageNavi = mrpd.getPageNavi();
	%>

<div id="wrapper">
	<div id="content" class="container-fluid">

<!-- header -->
<form action="/MRManagementChange.do" method="post">	
        <div id="content" class="row padding1 bgColor1"> <!--id를 content로 주어서 구분이 명확해지고 row클래스에 추가-->
        
			<div id="whiteBoard" class="col-12 padding1 bgColor2"> <!--divRadius를 whiteboard로 변경. col-12클래스 추가-->
				<div id="inquiry" class="padding1">회의실 목록 ()</div>
            	<hr>
            	    
				<div>
			
				
					<table class="tableStyle" id="table_margin"> <!--infoTable클래스 추가-->
				        <tr>
	                        <th>공간명</th>
	                        <th>세부공간번호</th>
	                        <th>세부공간명</th>
	                        <th>등록일</th>
	                        <th>공개여부</th>
	                        <th>공개여부수정</th>
				        </tr> 
				        <%
	 	 		for(MRManagement mrManagement: list){
	 	 				%>
	 	 			<!-- 	<script>
	 	 				$(function(){
	 	 					var cnt=2;
		 	 				$(".check").attr({
		 	 					"value":"세부공간ID"+cnt;
		 	 				});
		 	 				cnt++;
	 	 				});   -->
	 	 				
	 	 				</script>
	 	 		<tr>
	 	 			<td><%=mrManagement.getSpaceName() %></td>
	 	 			<td><%=mrManagement.getSubNO()%></td>
	 	 			<td><%=mrManagement.getSubName()%></td>
	 	 			<td><%=mrManagement.getSubDate()%></td>
	 	 			<td>
	 	 			<%-- 	<select name="subopen_yn">
	 	 					<option value="N" <%if(mrManagement.getSubOpen() == 'N') {%> selected <%} %>>N</option>		 				
	 	 					<option value="Y" <%if(mrManagement.getSubOpen() == 'Y') {%> selected <%} %>>Y</option>
	 	 				</select> --%>
	 	 				<%=mrManagement.getSubOpen()%>
					</td>
	 	 			<td><input type="checkbox" name="check" value=<%=mrManagement.getSubNO()%> class="check"  /></td>
	 	 		</tr>
	 	 	<%
	 	 		}
	 	 	%>
					</table>
					
					<div align="center" id="navi">
						<%=pageNavi %>
						</div>
					<hr>
					<div id="btn_group"> <input type="submit" name="enrollment" value="수정" style="float:right;" id="last_btn2"></div>
				</div>    
				
			</div><!-- whiteBoard -->
			
</form>				
			
		</div><!--content-->
    </div><!--"fluid"-->
</div><!--wrapper-->



<!--  -->



</body>
</html>




