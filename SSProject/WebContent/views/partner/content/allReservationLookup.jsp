<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="ss.mango.user.member.model.vo.Member" %>
    <%@ page import="java.util.ArrayList" %>
	<%@ page import="kr.or.ss.reservationBoard.model.vo.AllReservation" %>
	<%@ page import="kr.or.ss.reservationBoard.model.vo.ReservationPageData" %>
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#top_menu{
float:left;
margin-bottom:10px;
}
#top_menu2{


float:left;
}
#top_menu3{
float:right;
padding-top:37px;
}
.text{
margin:0;
}
</style>
</head>
<body>
<%@ include file="/views/partner/partnerForm/header.jsp" %>

<%@ include file="/views/partner/partnerForm/contentForm.jsp" %>
<%
	
	//Member m = (Member)session.getAttribute("member");
	ReservationPageData rpd =(ReservationPageData)request.getAttribute("pageData");
	ArrayList<AllReservation> list;
	String pageNavi = "";
	if(rpd!=null){	
	list = rpd.getList();      //여기 자꾸 에러나와..   <-- 에러가 나옵니다. 잠시만요 확ㅇ니좀 해볼꼐요보내주는 서블릿이 어딨어요? 여기를 지우면 나옵니다.
	//지금 이 페이지를 불러왔을때 애초에 처음에는 서블릿을 간적도 없는데 위에 코드가 작동 될수 없죠 아래 코드들은 당연히 안되고		
	pageNavi = rpd.getPageNavi();
	System.out.println("jsp start!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	System.out.println("jsp 리스트 출력2:" +rpd);
	System.out.println("jsp 리스트 출력3:" +rpd.getList());
	System.out.println("jsp 리스트 출력2:" +pageNavi);
	}else{
		list = new ArrayList<AllReservation>();
	}
	// 편법 코딩을 할 수 밖에 없습니다.
	// 즉, 서블릿을 갔다가 온게 아니면 데이터가 없으니까 빈 list 만들어 두어라 (편법)
%>
<div id="wrapper">
	<div id="content" class="container-fluid">

<!-- header -->

        <div id="content" class="row padding1 bgColor1"> <!--id를 content로 주어서 구분이 명확해지고 row클래스에 추가-->
			<div id="whiteBoard" class="col-12 padding1 bgColor2"> <!--divRadius를 whiteboard로 변경. col-12클래스 추가-->
				<div id="inquiry" class="padding1">전체예약 목록 ()</div>
            	<hr>
        <form action="/allReservation.do" method="get">	    
				<div>	
					<div id="top_menu" class="padding1">
					<p class="text">예약상태</p>
                    <select class="padding2 bgColor2" name="category" id="category">
                        <option value="A">전체</option>
                        <option value="N">예약취소</option>
                        <option value="Y">예약완료</option>
                        <option value="W">취소대기</option>
                    </select>
                </div>        
				<div id="top_menu2" class="padding1">
				<p class="text"> 신청일</p>
                    <input type="date" min="1960-01-01" max="2030-12-31" id="startDate" name="startDate"/>
                    <!-- <input type="date" min="1960-01-01" max="2030-12-31" id="lastDate" name="lastDate"/> -->
                </div> 
                <div id="top_menu3" class="padding1">
                    
				 	<button id="searchBtn" class="padding2" onClick="recordSearch()"> <!--btnOp클래스를 searchBtn아이디로 변경 type제거(검색어를 다른페이지로 보내는 것이 아닌, 검색어로 현재 페이지에 정보를 가져오는것) hoverColor클래스추가(깜빡이는 동작) -->
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
							for(AllReservation al:list){
							%>
					  	<tr >
						<td><%=al.getResNO() %></td> 
								<td><%=al.getResInfoName() %></td>
								<td><%=al.getSubName() %></td>
							<td><%=al.getResRecordDate() %></td>	
								<td><%=al.getResState() %></td>
							</tr> 	 
							<%
						}
							%>
				 	
						</table>
						<div align="center" id="navi">
						<%if(!list.isEmpty()){ %>
							<%=pageNavi %>
						<%} %>
						</div>
					<%} %>
			
	                   
	                 
	                 
	          
				</div>  
 		</form>    
			</div><!-- whiteBoard -->
		</div><!--content-->
    </div><!--"fluid"-->
</div><!--wrapper-->
<script>

/* $(function(){
	$('#searchBtn').click(function(){
		
		var startDate=$("#startDate").val();
		var category=$("#category").val();
		
		var object={"startDate":startDate, "category":category};
		$.ajax({
			
			url:"/allReservation.do",
			data : object,
			type: "get",
			
			success: function(data){
				
				
				$('#firstTr').siblings().attr('style',"display:none;");
				
					if(data.resState=='N') {
						data.resState='예약취소';
					}else if(data.resState=='Y') {
						data.resState='예약완료';
					}else if(data.resState=='W') {
						data.resState='취소대기';
					}
			$(".tableStyle").append("<tr>"
						                +"<td>"+ data.resNo + "</td>"
						                +"<td>"+ data.resInfoName + "</td>"
						                +"<td>"+ data.subName + "</td>"
						                +"<td>"+ data.resRecordDate + "</td>"
						                +"<td>"+ data.resState + "</td>"
						                +"</tr>");
				
						                /*		var str="<tr>";
				$.each(function(){
					str += "<td>"+data.resNo + "</td><td>"+data.email+"</td><td>"+data.resName+"</td><td>"+data.phone+"</td><td>" + data.resState+ "</td>";
					str += "</tr>";
				});
				$(".tableStyle").append(str);
			},
			error : function(){
				$('#firstTr').siblings().attr('style',"display:none;");
			}
		});
	});
});

 */


</script>




</body>
</html>




