<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ss.mango.user.member.model.vo.Member"%>
<%@ page import="kr.or.ss.space.model.vo.Space"%>
<%@ page import="kr.or.ss.space.model.vo.SubSpace"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 공간 예약 관리 -->
<%@ include file="/views/partner/partnerForm/head.jsp"%>

<style>

	.currentSituation{
		margin-bottom: 50px;
		padding: 10px 50px 0 50px; /*상우하좌*/
		
	}
	
	/*메인 큰틀*/
	#mainSS{
		padding: 15px;
	}
	
	/*서브 큰틀*/
	#subSS{
		padding: 15px;
		width: 100%;
	}
	
	/*테이블 공간*/
	.mainSSTables{
		height: 500px;
	}
	
	.SSTables table{
		width: 100%;
		padding : 20px;
		border : 1px solid gray;
	}
	
	.SSTables img{
		width: 100%;
		padding : 0;
	}
	
	#plusBtn{
		text-decoration: none;
		color : #595959;
	}
	
	#plusBtn i{
		margin-right: 10px;
		color : #9614EF;
	}
	
	/* lable */
	.ssPlusBtn{
		margin-bottom: 20px;
		padding-left: 15px;
		width: 300px;
		height: 50px;
		line-height: 45px;
		border: 1px solid lightgrey;
		border-radius: 3px;
		background-color: #fbfbfb;
		font-weight: 600;
	}
	
	.SSTables td{
		color : gray;
		font-weight: 500;
	}
	
	.SSTables hr{
		margin : 10px;
		padding: 0;
	}
	
	#SpaceYNC{
		color : orange;
		margin-left: 10px;
	}
		
	#SpaceName{
		font-weight: 600;
		font-size : 24px;
		color : black;
	}
	
	.SSTables table #ssInfo{
		padding-bottom : 20px;
	}
	
	.sSubTables .SSTables table #ssInfo{
		padding-bottom : 0px;
	}
	
	/* 서브공간 정보 */
	.sSubTables .SSTables table .sSubInfo{
		padding-left : 20px;
		padding-bottom : 20px;
		color : #343a40;
		font-weight: 600;
	}
	
	.sSubTables .SSTables table .sSubInfo label{
		color : #9614EF;
		padding : 0;
		margin : 0;
	}
	

	
</style>

	<div id="wrapper">
		<div id="fluid" class="container-fluid">
			<!-- header -->
			<div id="content" class="row padding1 bgColor1">
				
				<div id="whiteBoard" class="col-12 padding1 bgColor2">
				
				
				
				<% 
					//Member m = (Member)session.getAttribute("member"); 
					Space s = (Space)request.getAttribute("space");
					//SubSpace sSub = (SubSpace)request.getAttribute("sSub");
					ArrayList<SubSpace> subList = (ArrayList<SubSpace>)request.getAttribute("subList");
					/* int count = (int)request.getAttribute("count"); */
				%>
				
				
				
				<div id="inquiry" class="padding1">공간 등록 현황</div>
				<hr>
				<div class="currentSituation" >
					<%if(s==null) {%>
					<div id="mainSS">
						<label class="ssPlusBtn">
							<a href="views/partner/content/mSpaceRegistration.jsp" id="plusBtn">
								<i class="fas fa-plus"></i> 새 공간 등록하기
							</a>
						</label>
					</div>
					<!-- 메인공간이 하나라도 등록되면 안보임 -->
				
					
					<%} else{%>
					<div class="SSTables col-md-4">
						<table>
							<tr>
								<td>
									<!-- 여기에 memberCode랑 fileUser랑 같은 파일 이미지 검색하고 경로뒤에 붙여주면될듯 -->
								 	<img src="/resources/file/image/<%=s.getFileLoadName()%>">
								</td>
							</tr>
							<tr >
								<td id="ssInfo">
									<span id="SpaceName"> <%=s.getSpaceName() %></span><hr>
									<span>등록일 <%=s.getSpaceDate() %></span>
									<span id="SpaceYNC">
										<%if(s.getAprYNC()=='N'){ %>
											미승인
										<%}else if(s.getAprYNC()=='Y'){ %>
											승인
										<%} else if(s.getAprYNC()=='C'){ %>
											반려
										<%} %>
									</span>
								</td>
							</tr>
						</table>
					</div>
					<%} %>
				</div>
				<!-- 메인공간현황공간 -->
				
				
				
				
				
				<div id="inquiry" class="padding1">세부 공간 등록 현황</div>
				<hr>
				<div class="currentSituation">	
				<!-- 세부 등록되어도 보임(3개까지 가능) -->
				<!-- 메인공간이 등록되야 등록 가능 -->
					<%if(subList==null && s==null) {%>
					<!-- s공간 null 말고 subS로 하면 될듯! 후하후하! -->
						<div id="subSS" >
							<label class="ssPlusBtn">
								<a id="plusBtn">
									<i class="fas fa-plus"></i> 세부 공간 등록하기
								</a>
							</label>
						</div>		
					<script>
						$(function(){
							$('#subSS').click(function(){
								alert('등록된 공간이 없습니다. 메인공간 등록 후 입력해주세요');
							});
						});
					</script>			
					<%} else if(subList==null){ %>
						<div id="subSS" >
							<label class="ssPlusBtn">
								<a href="/views/partner/content/sSpaceRegistration.jsp" id="plusBtn">
									<i class="fas fa-plus"></i> 세부 공간 등록하기
								</a>
							</label>
						</div>	
					<%} else { %>
						<%if(0<=subList.size()&&subList.size()<3) {%>
							<div id="subSS">
								<label class="ssPlusBtn">
									<a href="/views/partner/content/sSpaceRegistration.jsp" id="plusBtn">
										<i class="fas fa-plus"></i> 세부 공간 등록하기
									</a>
								</label>
							</div>
						<%} %>
						<div class="row sSubTables">
						<%for(SubSpace sSub : subList) {%>
						<div class="SSTables col-md-4">
							<table>
								<tr>
									<td id="ssInfo">
										<span id="SpaceName"> <%=sSub.getSubName() %></span><hr>
										<span>등록일 <%=sSub.getSubDate() %></span>
										<span id="SpaceYNC">
											<%if(sSub.getSubAPRYNC()=='N'){ %>
												미승인
											<%}else if(sSub.getSubAPRYNC()=='Y'){ %>
												승인
											<%} else if(sSub.getSubAPRYNC()=='C'){ %>
												반려
											<%} %>
										</span>
									</td>
								</tr>
								<tr>
									<span>
									<td class="sSubInfo">
										비공개여부 : <%=sSub.getSubOpen() %><br>
										가격 : <label><%=sSub.getSubCost()%></label>원(시간당)<br>
										취소 수수료(%) : <%=sSub.getRefundFees() %><br>
									</td>
									</span>
								</tr>
							</table>
						</div>
						<%} %>
						<%} %>
						
						</div>
						
					
						</div>
						<!-- 서브공간 현황 공간 -->
					
				</div>
				
				
				
				</div>
				<!--whiteBoard-->
				
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