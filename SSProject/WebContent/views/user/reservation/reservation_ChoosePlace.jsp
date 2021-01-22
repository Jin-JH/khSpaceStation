<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ss.mango.user.space.model.vo.SpaceRegistration" %>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장소 선택 페이지</title>
    <style>
    	* {
            box-sizing: border-box;
            margin: 0px;
            padding: 0px;
    	}
    	#header {
	    	padding: 0px;
	    	margin: 0px;
    	}
    	#container_box {
    		padding-top: 100px;
    		max-width: 1000px;
    		margin: 0 auto;
    	}
    	.container_title {
    		padding: 0px;
    		height: 60px;
    		display: flex;
    		max-width: 900px;
    	}
    	.container_title_select {
    		padding-left: 10px;
    		display: flex;
    		line-height: 50px;
    		border: 1px solid gray;
    		background-color: white;
    		margin-right: 15px;
    		border-radius: 5px;
    		color: gray;
    	}
	
		.contents_right_title {
		   width: 100%;
		   font-size: 30px;
		   padding: 0 10px;
		   margin: 70px 0;
		}
		
		.h3style{
		   padding: 0;
		   width: 100%;
		   border-left: 5px solid chocolate;
		   margin-bottom: 30px;
		}
    	.container_content {
    		margin-top: 30px;
    	}
    	.icon_style {
    		color: grey;
    	}
    	.content_reset {
    		cursor: pointer;
    		color: grey;
    	}
    	.content_reset:hover {
    		color: black;
    	}
    	.space_view:hover {
    		box-shadow: 0px 3px 10px 1px lightgray;
    		transition: .4s;
    	}
    	.price_style {
    		position: absolute;
    		bottom: 20px;
    		right: 25px;
    	}
    	#spaceListSearchBtn {
    		border: 1px solid gray;
    		border-radius: 5px;
    		display: flex;
    		padding: 0px 10px;
    		text-align: center;
    		background-color: white;
    		color: gray;
    	}
    	#spaceListSearchBtn:hover {
    		background-color: gray;
    		color: white;
    	}
    	#locationInputBox {
    		background: none;
    		border: none;
    	}
    	#locationInputBox:focus {
    		outline: none;
    	}
    </style>
</head>
<body>
	<div class="wrapper">
        <div id="header">
            <%@ include file="/views/user/common/header.jsp" %>
        </div>
        <%
        	ArrayList<SpaceRegistration> list = (ArrayList<SpaceRegistration>)request.getAttribute("list");
        	String location = (String)request.getAttribute("location");
        	String price = (String)request.getAttribute("price");
        %>
        <div class="main-content" id="container">
        	<div id="container_box">
        		<%if(list.size()!=0) { %>
        		<div class="container_title row" style="margin: 0 auto;">
        			<div class="col-4 container_title_select" id="spaceListLocation">
        				<div style="width: 90%">
	        				<i class="fas fa-map-marker-alt icon_style"></i>
	        				<% if(location=="") { %>
	        					<input type="text" id="locationInputBox" name="location" size="7" value="전체" style="text-overflow: ellipsis" />
	        				<% } else { %>
	        					<input type="text" id="locationInputBox" name="location" size="7" value="<%=location %>" style="text-overflow: ellipsis"/>
	        				<% } %>
        				</div>
        				<div style="width: 10%; text-align: right; min-width: 25px">
        					<div style="display: block;" onclick="location.href='SpaceAllListPage.ss?location='">
        						<i class="fas fa-times content_reset fa-lg"></i>&nbsp;
        					</div>
        				</div>
        			</div>
        			<div class="col-6 col-sm-5 container_title_select" id="spaceListDateTime">
	        			<div style="width: 90%">
	        				<i class="far fa-clock icon_style"></i>
	        				<span>날짜/시간</span>
        				</div>
        				<div style="width: 10%; text-align: right; min-width: 25px">
        					<i class="fas fa-times content_reset fa-lg"></i>&nbsp;
        				</div>
       				</div>
       				<% if(location=="") { %>
       				<button class="col-1 col-sm-2" id="spaceListSearchBtn" type="button" onclick="location.href='SpaceAllListPage.ss?location='">
       					<div style="width: 100%; height: 100%;">
       						<i id="spaceInfoBtn" class="fas fa-search fa-lg" style="width: 100%; height: 100%; padding-top:17px;"></i>
       					</div>
       				</button>
       				<% } else { %>
	      				<button class="col-1 col-sm-2" id="spaceListSearchBtn" type="button" onclick="location.href='SpaceAllListPage.ss?location='">
	      					<div style="width: 100%; height: 100%;">
	      						<i id="spaceInfoBtn" class="fas fa-search fa-lg" style="width: 100%; height: 100%; padding-top:17px;"></i>
	      					</div>
	      				</button>
       				<% } %>
        		</div>
        		<div class="container_content">
	        		<div class="container_content_title row" style="margin: 0px;">
	        			<h3 class="h3style col-12">
							<span class="contents_right_title">예약한 회의실</span>
						</h3>
	        			<div class="col-md-3">검색된 센터 <%=list.size() %>개</div>
	        			<div class="col-12 col-md-9">
	        				<span id="lowPriceSort" onclick="location.href='SpaceAllListPage.ss?location=&price=low'"> 낮은금액순</span>|
	        				<span id="highPriceSort" onclick="location.href='SpaceAllListPage.ss?location=&price=high'"> 높은금액순</span>
	        			</div>
	        		</div>
	        		<% for(int i = 0; i < list.size(); i++) { %>
			        		<div class="space_view row p-0" onclick="location.href='/SpaceShowSubSpace.ss?spaceNo=<%=list.get(i).getSpaceNo()%>'" style="cursor:pointer">
			        			<div class="space_image col-md-5 p-0">
			        				<img src="/resources/file/image/<%=list.get(i).getFileName() %>" style="width: 100%; height:100%;"/>
			        			</div>
		        				<div class="space_info col-md-5">
		        					<h4><%=list.get(i).getSpaceName() %></h4>
		        					<input type="hidden" name="spaceNo" value="<%=list.get(i).getSpaceNo()%>"/>
		        					<i class="fas fa-map-marker-alt icon_style"></i>
		        					<span><%=list.get(i).getSpaceAddress().substring(0, 2) %></span><br>
		        					<span><%=list.get(i).getSpaceSize() %>평형</span><br>
		        					<i class="fas fa-user icon_style"></i>
		        					<span>70인실, 16인실, 12인실</span>
		        				</div>
		        				<% DecimalFormat formatter = new DecimalFormat("###,###");%>
		        				<div class="space_service col-md-2" style="text-align: right">
		        					<span class="price_style"><h4><b><%=formatter.format(list.get(i).getMinSubCost()) %>원</h4></span>
		        				</div>
			        		</div>
	        		<% } %>
        		</div>
        		<% } else { %>
        			<div class="container_content">
		        		<div class="container_content_title row" style="margin: 0px;">
		        			<div class="col-md-3">검색된 센터 <%=list.size() %>개</div>
		        			<div class="col-12 col-md-9">
		        			</div>
		        		</div>
		        		<div class="not_space_view">
		        			<center><h2>검색 결과가 존재하지 않습니다.</h2></center>
		        		</div>
		        	</div>
        		<% } %>
        	</div>
        </div>
        <div id="footer">
        	<%@ include file="/views/user/common/footer.jsp" %>
        </div>
    </div>
    <script>
		var $windowWidth;
		var $container_box = $('#container_box');
		var $container_content_title = $('.container_content_title');
		var $check_span_style = $('.check_span_style');
		var $space_image = $('.space_image');
		var $space_info = $('.space_info');
		var $space_view = $('.space_view');
	    
		$(document).ready(function() {
			$container_content_title.css('padding','5px');
			$container_content_title.css('white-space','nowrap');
			$container_content_title.children().last().css('text-align','right');
			$container_content_title.children().last().children().css('margin','5px');
			$container_content_title.children().last().children().css('cursor','pointer');
			$check_span_style.css('color','grey');
			$space_view.css('border','1px solid #EBEBEB');
			$space_view.css('margin','70px 0px 70px 0px');
			$space_view.css('border-radius','5px');
			$space_view.css('cursor','pointer');
			$space_view.css('diaplay','flex');
			$space_info.css('padding','20px');
		});
		
		$space_view.click(function() {
			$(this).parent().submit();
		});

		if($space_image.width() > $space_view.width()) {
			$space_view.width() = $space_image.width();
			$space_view.height() = $space_image.width() * 2/3;
    	}
		
		$(window).innerWidth(function() {
			$container_box = $('#container_box');
			
			if ($(this).width() <= 576) {
                $container_box.css('padding-top','50px');
            } else {
            	$container_box.css('padding-top','100px');
            }
		});
		
        $(window).resize(function() { //창크기 변화 감지
            var windowWidth = $(this).width(); //현재 창의 너비
            $container_box = $('#container_box');
            
            if (windowWidth <= 576) {
            	$container_box.css('padding-top','50px');
            } else {
            	$container_box.css('padding-top','100px');
            }
    	});
    </script>
</body>
</html>