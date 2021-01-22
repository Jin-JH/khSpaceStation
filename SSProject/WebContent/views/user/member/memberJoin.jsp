<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 페이지</title>
	<style>
    	* {
            box-sizing: border-box;
            margin: 0px;
            padding: 0px;
    	}
    	#container {
    		height: 70%;
    	}
    	#join_title {
            margin: 0 auto;
            padding-top: 50px;
            padding-bottom: 20px;
            text-align: center;
            border-bottom: 2px solid #EBEBEB;
        }
        #join_main {
            display: flex;
            text-align: center;
            margin: 0 auto;
            padding-top: 20px;
        }
        #join_sub {
        	display: flex;
        	justify-content: center;
        }
        #join_sub_space {
        	height: 400px;
        	border-left: 1px solid #EBEBEB;
        }
        .join_sub_a {
        	text-align:center;
        	margin: 30px;
        	width: 250px;
        	height: 250px;
        	border: 1px solid rgb(0,0,0,0.2);
        	border-radius: 10px;
        	padding-top: 40px;
        	color: grey;
        	font-weight: bold;
        	opacity: 0.8;
        }
        .join_sub_a:hover {
        	text-decoration: none;
        	opacity: 0.8;
        	background-color: grey;
        	color: white;
        }
        .i_style {
        	margin: 30px;
        	font-size: 50px;
        }
        .join_image_bottom {
        	font-weight: normal;
        }
	</style>
</head>

<body>
	<div class="wrapper">
        <div id="header" class="row p-0 m-0">
            <%@ include file="/views/user/common/header.jsp" %>
        </div>
        <div class="main-content" id="container">
            <div id="join_box" class="row" style="margin:0px;">
                <div id="join_title" class="col-8">
                    <span><h2>회원가입</h2></span>
                </div>
            </div>
            <div id="join_main col-7">
	            <div id="join_sub">
	                <a href="/views/user/member/memberJoinUser.jsp" class="join_sub_a">
	                	<i class="far fa-user i_style"></i><br>
	                	<span>개인회원</span><br>
	                	<span class="join_image_bottom">(회의실 이용 고객)</span>
	                </a>
	                <div id="join_sub_space"></div>
	                <a href="/views/user/member/memberJoinPartner.jsp" class="join_sub_a">
	                	<i class="far fa-handshake i_style"></i><br>
	                	<span>파트너 회원</span><br>
	                	<span class="join_image_bottom">(가맹점)</span>
	                </a>
	            </div>
            </div>
        </div>
        <div id="footer">
        	<%@ include file="/views/user/common/footer.jsp" %>
        </div>
    </div>
    
    <script>
    	var windowWidth; 
	    var $join_title = $('#join_title');
	    var $join_main = $('#join_main');
	    var $join_sub_a = $('.join_sub_a');
	    var $header = $('#header');
	    var $join_sub_space = $('#join_sub_space');
	    
    	$(window).innerWidth(function() {
    		if($(this).width() <= 767) {
                $join_title.removeClass('col-8');
                $join_title.addClass('col-11');
            } else {
                $join_title.addClass('col-8');
                $join_title.removeClass('col-11');
            }
            if($(this).width() <= 576) {
                $header.addClass('d-none');
                $join_sub_a.css('width','200px');
                $join_sub_a.css('height','200px');
                $join_sub_a.css('padding-top','20px');
                $join_sub_space.css('height','300px');
            } else {
                $header.removeClass('d-none');
                $join_sub_a.css('width','250px');
                $join_sub_a.css('height','250px');
                $join_sub_a.css('padding-top','40px');
                $join_sub_space.css('height','400px');
            }
    	});
    	
        $(window).resize(function() {
            var windowWidth = $(this).width();
            
            if(windowWidth <= 767) {
                $join_title.removeClass('col-8');
                $join_title.addClass('col-11');
            } else {
                $join_title.addClass('col-8');
                $join_title.removeClass('col-11');
            }
            if(windowWidth <= 576) {
                $header.addClass('d-none');
                $join_sub_a.css('width','200px');
                $join_sub_a.css('height','200px');
                $join_sub_a.css('padding-top','20px');
                $join_sub_space.css('height','300px');
            } else {
                $header.removeClass('d-none');
                $join_sub_a.css('width','250px');
                $join_sub_a.css('height','250px');
                $join_sub_a.css('padding-top','40px');
                $join_sub_space.css('height','400px');
            }
        });
    </script>
</body>
</html>