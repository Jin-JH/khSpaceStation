<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="kr.or.ss.customerManagement.model.vo.CMpageData" %>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="kr.or.ss.customerManagement.model.vo.CustomerManagement" %>
	<%@ page import="ss.mango.user.member.model.vo.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#navi{
 font-size:20px;
 color: black;
}

</style>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<%@ include file="/views/partner/partnerForm/header.jsp"%>

	<%@ include file="/views/partner/partnerForm/contentForm.jsp"%>

	<%
	
	//Member m = (Member)session.getAttribute("member");
	CMpageData cmpd=(CMpageData)request.getAttribute("pageData");
	ArrayList<CustomerManagement>list = cmpd.getList();
	String pageNavi = cmpd.getPageNavi();
	
	%>
	<div id="wrapper">
		<div id="content" class="container-fluid">

			<!-- header -->

			<div id="content" class="row padding1 bgColor1">
				<!--id를 content로 주어서 구분이 명확해지고 row클래스에 추가-->
				<div id="whiteBoard" class="col-12 padding1 bgColor2">
					<!--divRadius를 whiteboard로 변경. col-12클래스 추가-->
					<div id="inquiry" class="padding1">고객 목록 ()</div>
					<hr>

					<div>

						<div id="selectAlign" class="padding1">
							<form action="/boardSelectOne.do" method="get"
								id="customerForm" >
								<select class="padding2 bgColor2" name="searchCustomer"
									id="select">
									<option value="">선택</option>
									<option value="email">이메일</option>
									<option value="name">예약자</option>
									<option value="phone">연락처</option>
								</select>
								<input type="text" name="keyword" placeholder="검색어" id="keyword"
									class="padding2 bgColor2" />
								<!--name="keyword" 추가 -->
								<button id="searchBtn" class="padding2" type="button">
									<!--btnOp클래스를 searchBtn아이디로 변경 type제거(검색어를 다른페이지로 보내는 것이 아닌, 검색어로 현재 페이지에 정보를 가져오는것) hoverColor클래스추가(깜빡이는 동작) -->
									<i class="fas fa-search"></i>
								</button>
							</form>
						</div>

						<table class="tableStyle">
							<!--infoTable클래스 추가-->
							<tr id="firstTr">
								<th>예약 번호</th>
								<th>이메일</th>
								<th>예약자</th>
								<th>연락처</th>
								<th>예약상태</th>

							</tr>
						
							<%
						if(m!=null){	
							for(CustomerManagement cManagement:list){
							%>
					  	<tr >
						<td><%=cManagement.getResNo() %></td> 
								<td><%=cManagement.getResInfoEmail() %></td>
								<td><%=cManagement.getResInfoName() %></td>
							<td><%=cManagement.getResInfoPhone() %></td>	
								<td><%=cManagement.getResState() %></td>
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
				</div>
				<!-- whiteBoard -->
			</div>
			<!--content-->
		</div>
		<!--"fluid"-->
	</div>
	<!--wrapper-->


<script>
$("#keyword").keypress(function(e) { if (e.keyCode == 13) e.preventDefault(); });

$(function(){
	$('#searchBtn').click(function(){
		
		var select=$("#select").val();
		var keyword=$("#keyword").val();
		
		var object={"searchCustomer":select, "keyword":keyword};
		$.ajax({
			
			url:"/boardSelectOne.do",
			data : object,
			type: "get",
			
			success: function(data){
				if(data.resState=='N') {
					data.resState='예약취소';
				}else if(data.resState=='Y') {
					data.resState='예약완료';
				}else if(data.resState=='W') {
					data.resState='취소대기';
				}
				
				$('#firstTr').siblings().attr('style',"display:none;");
				
			$(".tableStyle").append("<tr>"
						                +"<td>"+ data.resNo + "</td>"
						                +"<td>"+ data.email + "</td>"
						                +"<td>"+ data.resName + "</td>"
						                +"<td>"+ data.phone + "</td>"
						                +"<td>"+ data.resState + "</td>"
						                +"</tr>");
						                /*		var str="<tr>";
				$.each(function(){
					str += "<td>"+data.resNo + "</td><td>"+data.email+"</td><td>"+data.resName+"</td><td>"+data.phone+"</td><td>" + data.resState+ "</td>";
					str += "</tr>";
				});
				$(".tableStyle").append(str);*/
			},
			error : function(){
				$('#firstTr').siblings().attr('style',"display:none;");
			}
		});
	});
});



</script>
							
</body>
</html>