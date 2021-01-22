<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="kr.or.ss.inquiry.model.vo.Inquiry" %>
     <%@ page import="kr.or.ss.inquiry.model.vo.InquiryPageData" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="ss.mango.user.member.model.vo.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#radio_btn {
float:left;}

</style>
</head>
<body>
<%@ include file="/views/partner/partnerForm/header.jsp" %>

<%@ include file="/views/partner/partnerForm/contentForm.jsp" %>

<%
//ember m = (Member)session.getAttribute("member");
InquiryPageData ipd=(InquiryPageData)request.getAttribute("pageData");

//System.out.println(ipd);
ArrayList<Inquiry> list;
String pageNavi = "";
if(ipd!=null){	
	list = ipd.getList(); 
	pageNavi = ipd.getPageNavi();
	System.out.println("jsp start!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	System.out.println("jsp 리스트 출력2:" +ipd);
	System.out.println("jsp 리스트 출력3:" +ipd.getList());
	System.out.println("jsp 리스트 출력2:" +pageNavi);
	}else{
		list = new ArrayList<Inquiry>();
	}
%>
<div id="wrapper">
	<div id="content" class="container-fluid">

<!-- header -->
<form action="/inquiryBoard.do" method="get">
        <div id="content" class="row padding1 bgColor1"> <!--id를 content로 주어서 구분이 명확해지고 row클래스에 추가-->
			<div id="whiteBoard" class="col-12 padding1 bgColor2"> <!--divRadius를 whiteboard로 변경. col-12클래스 추가-->
				<div id="inquiry" class="padding1">문의 내역 ()</div>
            	<hr>
            	    
				<div>
					
					<div id="selectAlign" class="padding1">
					<span id="radio_btn"><input type="radio" name="chk_info" value="전체" checked="checked"/>전체
	                        <input type="radio" name="chk_info" value="완료"/>완료
	                        <input type="radio" name="chk_info" value="미완료"/>미완료</span>
		    	       
						<button type="submit" id="searchBtn" class="padding2"> <!--btnOp클래스를 searchBtn아이디로 변경 type제거(검색어를 다른페이지로 보내는 것이 아닌, 검색어로 현재 페이지에 정보를 가져오는것) hoverColor클래스추가(깜빡이는 동작) -->
						    <i class="fas fa-search"></i>
						</button>
					</div>
					
					
					<table class="tableStyle"> <!--infoTable클래스 추가-->
				        <tr id="firstTr">
	                        <th>문의번호</th>
	                        <th colspan="2">문의일시</th>
	                        <th>예약자</th>
	                        <th colspan="4">문의제목</th>
	                        <th>답변여부</th>
			        </tr> 	
 				   <%
	               		if(m!=null){ 
							for(Inquiry i: list){
							%>
				       <tr>
				        <td><%=i.getInquiryNo() %></td>
				        <td colspan="2"><%=i.getInquiryDate() %></td>
				        <td><%=i.getMemberName() %></td>
				        <td colspan="4"><%=i.getInquirytitle() %></td>
				        <td><%=i.getInquiryANS() %></td>
				        </tr> 
				    <%} %>
			  		
						</table>
						<div align="center" id="navi">
						<%if(!list.isEmpty()){ %>
							<%=pageNavi %>
						<%} %>
						</div>
					 <%} %>
					
					</div>
				</div>
				<!-- whiteBoard -->
					
					
					
			
		</div><!--content-->
		</form>
    </div><!--"fluid"-->
</div><!--wrapper-->

<script>
$(function(){
	$('#searchBtn').click(function(){
		var selection = $('[name=chk_info]:checked').val();
		
		$.ajax({
			url: "/inquiryBoard.do",
			type: "get",
			data:{"selection" : selection},
			success: function(data){
				if(data.inquiryANS=='N') {
					data.inquiryANS='답변미확인';
				}else if(data.inquiryANS=='Y') {
					data.inquiryANS='답변완료';
				}
				$('#firstTr').siblings().attr('style',"display:none;");
				for(var i=0; i<data.length;i++){
				$(".tableStyle").append("<tr>"
						                +"<td>"+ data[i].inquiryNo + "</td>"
						                +"<td>"+ data[i].inquiryDate + "</td>"
						                +"<td>"+ data[i].membername + "</td>"
						                +"<td>"+ data[i].inquiryTitle + "</td>"
						                +"<td>"+ data[i].inquiryANS + "</td>"
						                +"</tr>");
				}
			},
			error : function(){
				$('#firstTr').siblings().attr('style',"display:none;");
			
			});
		});
	});

	});		


</script>



</body>
</html>




