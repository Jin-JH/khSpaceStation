<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ss.mango.user.member.model.vo.Member" %>
<%@ include file="/views/user/common/__js.jsp" %>
    <style>
	    html, body {
	    	margin: 0;
	    	padding: 0;
	    	width: 100%;
	    	height: 100%;
	    }
	    .wrapper {
	    	display: flex;
	    	min-height: 100vh;
	    	flex-direction: column;
	    }
	    .main-content {
	    	flex: 1;
	    }
        * {
            box-sizing: border-box;
            margin: 0px;
            padding: 0px;
        }
        #logo {
            text-align: center;
            padding-top: 30px;
            font-size: 30px;
            overflow: hidden;
        }
        #logo>a {
	    	text-decoration: none;
	    	color: grey;
        }
        #logo>a:hover {
        	color: black;
        }
        .logo_image:hover{
        	color: black;
        }
        #header_main {
        	width: 100%;
            height: 100px;
            display: flex;
            position: fixed;
            top: 0;
            background-color: white;
            z-index: 99;
        }
        body {
        	padding-top: 100px;
        }
        #nav {
            text-align: center;
        }
        #nav_main {
            border: 1px solid #EBEBEB;
            border-radius: 40px;
            height: 80%;
            margin: 10px auto;
            max-width: 1000px;
            display: flex;
            overflow: hidden;
        }
        #search_form {
        	height: 100%;
        }
        #search_sub_form {
        	height: 100%;
        }
        .nav_search {
            border-radius: 40px;
            text-align: left;
            padding-top: 15px;
            padding-left: 30px;
        }
        .nav_search_input {
            border: none;
            background: none;
            width: 90%;
            text-overflow: ellipsis;
        }
        .nav_search_input:focus {
            outline: none;
        }
        .nav_search_space {
            height: 80%;
            margin: 7px 5px 7px 5px;
            border-left: 1px solid #EBEBEB;
        }
        .nav_search:hover {
            cursor: pointer;
            background-color: #EBEBEB;
        }
        .search_btn {
            width: 60px;
            height: 60px;
            margin: auto;
            border-radius: 50%;
            /*background-color: #FF385C;*/
            background-color: grey;
            cursor: pointer;
            padding: 0px;
            text-align: center;
            border: none;
        }
        .search_btn:focus {
        	outline: none;
        }
        .search_btn:hover {
        	background-color: red;
        }
        .search_btn_i {
        	color: white;
        	line-height: 60px;
        	font-size: 20px;
        }
        
        #location_box_title:hover {
        	cursor: pointer;
        	background-color: #EBEBEB;
        }
        
        
        #nav_sub_main {
            border: 1px solid #EBEBEB;
            height: 70%;
            max-width: 300px;
            border-radius: 40px;
            margin-top: 15px;
            margin-left: 10px;
            overflow: hidden;
            display: flex;
        }
        
        #nav_sub_input {
       		width: 100%;
       		height: 100%;
       		padding-left: 20px;
       		border: none;
        }
        #nav_sub_input:focus {
        	outline: none;
        }
        
        #snb {
            line-height: 90px;
            white-space: nowrap;
        }
        #snb>ul {
            margin: 0px;
            padding: 0px;
            text-align: right;
            padding-right: 10px;
        }
        #snb>ul>li {
            display: inline;
        }
        #snb>ul>li>a {
            color: black;
        }
        #snb>ul>li>a:hover {
            text-decoration: none;
        }
        #snb_slide_view {
        	position: absolute;
        	border: 1px solid grey;
        	border-radius: 5px;
        	right: -350px;
        	top: 0px;
        	width: 350px;
        	height: 1000px;
        	background-color: white;
        	text-align: center;
        }
        #snb_slide_view_title {
        	width: 75%;
        	height: 100px;
        	line-height: 100px;
        	float: left;
        }
        #snb_slide_view_title_snb {
        	width: 25%;
        	Padding: 30px;
        	height: 100px;
        	float: left;
        }
        #snb_slide_view_title_bottom {
        	clear: left;
        	height: 70px;
        	padding: 10px 5px 10px 5px;
        }
        .snb_slide_view_title_bottom_content {
        	width: 100%;
        	height: 100%;
        }
        #slide_view_open_btn {
        	color: grey;
        	cursor: pointer;
        }
        #slide_view_open_btn:hover {
        	color: black;
        }
        #slide_view_close_btn {
        	color: grey;
        	height: 100%;
        	cursor: pointer;
        }
        #slide_view_close_btn:hover {
        	color: black;
        }

        /* 여기까지 header_main주석 */
    </style>
    
	<%
   		Member m = (Member)session.getAttribute("member");    		
   	%>
	<div id="header_main">
	    <div id="logo" class="col-1 col-sm-2 col-lg-2">
	    	<a href="/SpaceMainRecentInsert.ss" style="padding:0px">
	        	<span>Space Station</span>
	        </a>
	    </div>
	    <div id="nav" class="col-7 col-sm-6 col-lg-8">
	    	<script>
	    		function headerForm() {
	    			var form = document.getElementById('search_form');
	    			
	    			form.action = "/SpaceAllListPage.ss";
	    			
	    			form.submit();
	    		}
	    		function headerSubForm() {
	    			var subForm = document.getElementById('search_sub_form');
	    			
	    			subForm.action = "/SpaceAllListPage.ss";
	    			
	    			subForm.submit();
	    		}
	    	</script>
	    	<form method="post" id="search_form">
	        <div id="nav_main">
	            <div class="nav_search" style="width: 25%">
	                <span><b>위치</b></span><br>
	                <input type="text" placeholder="지역명으로 검색" name="location" class="nav_search_input" autocomplete="off">
	            </div>
	            <div class="nav_search_space"></div>
	            <div class="nav_search" style="width: 20%">
	                <span><b>체크인</b></span><br>
	                <input type="text" placeholder="날짜 추가" name="checkIn" class="nav_search_input" id="datepicker" autocomplete="off">
	            </div>
	            <div class="nav_search_space"></div>
	            <div class="nav_search" style="width: 20%">
	                <span><b>시작시간</b></span><br>
	                <input type="text" placeholder="시간 추가" name="start_time" class="nav_search_input" id="start_timepicker" autocomplete="off">
	                
	            </div>
	            <div class="nav_search_space"></div>
	            <div class="nav_search" style="width: 20%">
	                <span><b>종료시간</b></span><br>
	                <input type="text" placeholder="시간 추가" name="end_time" class="nav_search_input" id="end_timepicker" autocomplete="off">
	            </div>
            	<button type="button" class="search_btn" id="search_main_header_btn" onclick="headerForm();">
	                <i class="fas fa-search search_btn_i"></i>
                </button>
	        </div>
	        </form>
	    </div>
	    <div id="nav_sub" class="d-none col-12 col-sm-6 col-lg-8">
	    	<form method="post" id="search_sub_form">
	        <div id="nav_sub_main">
	            <div id="nav_sub_search" style="width: 75%">
	                <input type="text" name="location" id="nav_sub_input" placeholder="검색 시작하기"/>
	            </div>
	            <button type="button" class="search_btn" id="search_sub_header_btn" onclick="headerSubForm();">
	                <i class="fas fa-search search_btn_i"></i>
                </button>
	        </div>
	    	</form>
	    </div>
	    <div id="snb" class="col-4 col-sm-4 col-lg-2">
	        <ul>
	        	<% if((m!=null) && (m.getMemberCode().substring(0,1).equals("u"))) { %>
	        			<li><a href="/MemberReservation.ss">마이페이지</a>&nbsp;|</li>
	    	            <li><a href="/MemberLogout.ss">로그아웃</a></li>
				<% } else if((m!=null) && (m.getMemberCode().substring(0,1).equals("p"))) { %>
						<li><a href="/dashTable.do">센터관리</a>&nbsp;|</li>
						<li><a href="/MemberPartnerInfo.ss">마이페이지</a>&nbsp;|</li>
	    	            <li><a href="/MemberLogout.ss">로그아웃</a></li>
				<% } else if((m!=null) && (m.getMemberCode().substring(0,1).equals("a"))) { %>
						<li><a href="/views/user/member/adminManage.jsp">관리자용</a>&nbsp;|</li>
						<li><a href="/views/user/member/adminMyPage.jsp">마이페이지</a>&nbsp;|</li>
	    	            <li><a href="/MemberLogout.ss">로그아웃</a></li>
				<% } else {%>
						<li><a href="/views/user/member/memberJoin.jsp">회원가입</a>&nbsp;|</li>
	    	            <li><a href="/views/user/member/memberLogin.jsp">로그인</a></li>
				<% } %>
	        </ul>
	    </div>
	    <div id="snb_icon" class="d-none col-4 col-sm-4 col-lg-2">
	    	<i class="fas fa-bars" id="slide_view_open_btn" style="font-size: 25px"></i>
		    <div id="snb_slide_view">
		    	<div id="snb_slide_view_title" style="font-size: 30px;">
		    		<span>Space Station</span>
		    	</div>
		    	<div id="snb_slide_view_title_snb">
		    		<i class="fas fa-times" id="slide_view_close_btn" style="font-size: 25px"></i>
		    	</div>
		    	<% if((m!=null) && (m.getMemberCode().substring(0,1).equals("u"))) { %>
			    	<div id="snb_slide_view_title_bottom">
			    		<div class="snb_slide_view_title_bottom_content">
			    			<a href="/MemberReservation.ss"><button type="button" class="btn btn-light slide_view_close_btn" id"">마이페이지</button></a>&nbsp;&nbsp;
			    			<a href="/MemberLogout.ss"><button type="button" class="btn btn-dark slide_view_close_btn" id="">로그아웃</button></a>
			    		</div>
			    	</div>
			    <% } else if((m!=null) && (m.getMemberCode().substring(0,1).equals("p"))) { %>
			    	<div id="snb_slide_view_title_bottom">
			    		<div class="snb_slide_view_title_bottom_content">
			    			<a href="/dashTable.do"><button type="button" class="btn btn-info slide_view_close_btn" id"">센터관리</button></a>&nbsp;&nbsp;
			    			<a href="/MemberPartnerInfo.ss"><button type="button" class="btn btn-light slide_view_close_btn" id="">마이페이지</button></a>&nbsp;&nbsp;
			    			<a href="/MemberLogout.ss"><button type="button" class="btn btn-dark slide_view_close_btn" id="">로그아웃</button></a>
			    		</div>
			    	</div>
			    <% } else if((m!=null) && (m.getMemberCode().substring(0,1).equals("a"))) { %>
			    	<div id="snb_slide_view_title_bottom">
			    		<div class="snb_slide_view_title_bottom_content">
			    			<a href="/views/user/member/adminManage.jsp"><button type="button" class="btn btn-info slide_view_close_btn" id"">관리자용</button></a>&nbsp;&nbsp;
			    			<a href="/views/user/member/adminMyPage.jsp"><button type="button" class="btn btn-light slide_view_close_btn" id="">마이페이지</button></a>&nbsp;&nbsp;
			    			<a href="/MemberLogout.ss"><button type="button" class="btn btn-dark slide_view_close_btn" id="">로그아웃</button></a>
			    		</div>
			    	</div>
			    <% } else {%>
			    	<div id="snb_slide_view_title_bottom">
			    		<div class="snb_slide_view_title_bottom_content">
			    			<a href="/views/user/member/memberJoin.jsp"><button type="button" class="btn btn-light slide_view_close_btn" id"">회원가입</button></a>&nbsp;&nbsp;
			    			<a href="/views/user/member/memberLogin.jsp"><button type="button" class="btn btn-dark slide_view_close_btn" id="">로그인</button></a>
			    		</div>
			    	</div>
			    <% } %>
		    </div>
	    </div>
    </div>
    <div class="menu_bg"></div>
    <script>
	    var windowWidth;
	    var $logo = $('#logo');
	    var $nav = $('#nav');
	    var $nav_sub = $('#nav_sub');
	    var $snb = $('#snb');
	    var $snb_icon = $('#snb_icon');
	    var $search_btn = $('.search_btn');
	    var $logo_icon = $('#logo_icon');
	    var $logo_image = $('.logo_image');
	    
	    $snb_icon.css('padding','30px');
	    $snb_icon.css('text-align','right');
	    
	    $(window).innerWidth(function() {
	        if ($(this).width() <= 1550) {
	        	$snb_icon.removeClass('d-none');
	        	$snb.addClass('d-none');
	        } else {
	        	$snb_icon.addClass('d-none');
	        	$snb.removeClass('d-none');
	        }
	    	if ($(this).width() <= 1253) {
	    		$logo.children().html("<i class='fas fa-rocket logo_image'></i>");
	    	} else {
	    		$logo.children().html("Space Station");
	    	}
	    	if ($(this).width() <= 991) {
	            $nav.addClass('d-none');
	            $nav_sub.removeClass('d-none');
	            $search_btn.css('width','50px');
	            $search_btn.css('height','50px');
	            $('.search_btn_i').css('line-height','50px');
	    	} else {
	            $nav.removeClass('d-none');
	            $nav_sub.addClass('d-none');
	            $search_btn.css('width','60px');
	            $search_btn.css('height','60px');
	            $('.search_btn_i').css('line-height','60px');
	    	}
	    	if ($(this).width() <= 576) {
	            $logo.addClass('d-none');
	            $snb_icon.addClass('d-none');
	            $nav_sub.children().children().css('margin-right','10px');
	            $nav_sub.children().children().css('max-width','500px');
	            $nav_sub.children().children().css('box-shadow','10px 10px 10px #EBEBEB');
	        } else {
	            $logo.removeClass('d-none');
	            $snb_icon.removeClass('d-none');
	            $nav_sub.removeAttr('style','margin-right');
	            $nav_sub.children().children().removeAttr('style','box-shadow');
	            $nav_sub.children().children().css('max-width','300px');
	        }
	    });
	    
	    $(window).resize(function() { //창크기 변화 감지
	        windowWidth = $(this).width(); //현재 창의 너비
	        if (windowWidth <= 1550) {
	        	$snb_icon.removeClass('d-none');
	        	$snb.addClass('d-none');
	        } else {
	        	$snb_icon.addClass('d-none');
	        	$snb.removeClass('d-none');
	        }
	        if (windowWidth <= 1253) {
	    		$logo.children().html("<i class='fas fa-rocket logo_image'></i>");
	    	} else {
	    		$logo.children().html("Space Station");
	    	}
	        if (windowWidth <= 991) { //sm은 576px, md는 767px, lg는 991px.
	            $nav.addClass('d-none');
	            $nav_sub.removeClass('d-none');
	            $search_btn.css('width','50px');
	            $search_btn.css('height','50px');
	            $('.search_btn_i').css('line-height','50px');
	        } else {
	            $nav.removeClass('d-none');
	            $nav_sub.addClass('d-none');
	            $search_btn.css('width','60px');
	            $search_btn.css('height','60px');
	            $('.search_btn_i').css('line-height','60px');
	        }
	        if (windowWidth <= 576) {
	            $logo.addClass('d-none');
	            $snb_icon.addClass('d-none');
	            $nav_sub.children().children().css('margin-right','10px');
	            $nav_sub.children().children().css('max-width','500px');
	            $nav_sub.children().children().css('box-shadow','10px 10px 10px #EBEBEB');
	        } else {
	            $logo.removeClass('d-none');
	            $snb_icon.removeClass('d-none');
	            $nav_sub.removeAttr('style','margin-right');
	            $nav_sub.children().children().removeAttr('style','box-shadow');
	            $nav_sub.children().children().css('max-width','300px');
	        }
	    });
    </script>
    <script>
    	var $snb_slide_view = $('#snb_slide_view');
    	var $slide_view_open_btn = $('#slide_view_open_btn');
    	var $slide_view_close_btn = $('#slide_view_close_btn');
    	var $snb_slide_view = $('#snb_slide_view');
    	
    	$slide_view_open_btn.click(function() {
    		$snb_slide_view.animate({right:0});
    	});
    	$slide_view_close_btn.click(function() {
    		$snb_slide_view.animate({right:-350});
    	});
    	
    	$(window).innerWidth(function() {
	    	if ($(this).width() > 1550) {
	    		$snb_slide_view.css('right','-350px');
	    	}
    	});
    	$(window).resize(function() {
    		windowWidth = $(this).width();
			if (windowWidth > 1550) {
	    		$snb_slide_view.css('right','-350px');
	    	}
    	});
    </script>
    <script>
	    var $nav_search = $('.nav_search');
	    
	    $nav_search.click(function() {
	    	$(this).children().last().focus();
	    	$(this).css('box-shadow','rgba(0, 0, 0, 0.15) 0px 8px 16px, rgba(0, 0, 0, 0.1) 0px 3px 8px');
	    	$(this).css('background','white');
	    	$(this).children().last().focusout(function() {
		    	$(this).parent().parent().children().css('box-shadow','');
		    	$(this).parent().parent().children().css('background','');
		    });
	    });
	    
	    $("#datepicker").datepicker({
	    	language: 'ko'
        });
	    $("#start_timepicker").datepicker({
            language: 'ko',
            timepicker: true,
            onlyTimepicker: true,
            timeFormat:"hh:00"
        });
	    $("#end_timepicker").datepicker({
            language: 'ko',
            timepicker: true,
            onlyTimepicker: true,
            timeFormat:"hh:00"
        });
    </script>
    
    <script>
    	var today = new Date();
    	
	    /* $(function() {
	    	$('#datepicker').focus(function() {
	    		if($(this).val()<today) {
	    			alert($(this).val());
	    		}
	    	})
	    }); */
    </script>
