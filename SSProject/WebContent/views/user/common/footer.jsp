<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	* {
		box-sizing: border-box;
		margin: 0px;
		padding: 0px;
	}
	#footer_main {
		width: 100%;
		height: 20%;
           background-color: #EBEBEB;
           margin-top: 100px;
           padding-top: 25px;
	}
	#footer_main_span {
		padding: 15px;
	}
	#footer_main_span>ul>li {
		list-style-type: none;
		padding-right: 10px;
	}
	/* #footer_main_span span:after {
	    content: '';
	    display: block;
	    width: 1px;
	    height: 10px;
   		background-color: black;
   		top: 6px;
   		position: absolute;
   	} */
   	.footer_main_span_title:after {
	    display: inline-block;
	    content: '';
	    background-color: black;
	    width: 1px;
	    height: 10px;
	    margin: 0 8px;
	    vertical-align: 0px;
    }
    .footer_main_span_title {
    	font-size:14px;
    }
    .footer_main_span_content {
    	font-size:14px;
    }
</style>
<div id="footer_main">
	<div class="col-10 p-0" style="display: flex; margin: 0 auto;">
		<div id="footer_main_logo">
			<a href="#" style="color: black; text-decoration: none">
				<i class='fas fa-rocket logo_image' style="font-size: 30px; color:black;"></i>
				<span>Space Station</span>
			</a>
		</div>
		<div id="footer_main_span">
			<ul>
				<li><span class="footer_main_span_title"><b>회사명</b></span>
					<span class="footer_main_span_content">Space Station</span></li>
				<li><span class="footer_main_span_title"><b>대표자</b></span>
					<span class="footer_main_span_content">재호 신</span></li>
				<li><span class="footer_main_span_title"><b>주소</b></span>
					<span class="footer_main_span_content">07212 서울특별시 영등포구 선유동2로 57 이레빌딩(구관) 19F, 20F</span></li>
				<li><span class="footer_main_span_title"><b>대표번호</b></span>
					<span class="footer_main_span_content">010-7243-6395</span></li>
			</ul>
		</div>
	</div>
	<div class="col-10 p-0" style="display: flex; margin: 0 auto; border-top: 1px solid grey">
		<span style="font-size: 14px; padding: 20px">Copyright © 2021 (주) MANGO. All rights reserved.</span>
	</div>
</div>
<script>
   	var windowWidth;
	var $footer_main_logo = $('#footer_main_logo');
	
	$footer_main_logo.css('font-size','30px');
	$footer_main_logo.css('padding','15px');
	
	$(window).innerWidth(function() {
		if($(this).width() <= 991) {
       		$footer_main_logo.css('display','none');
       		$footer_main_logo.css('display','none');
       	} else {
       		$footer_main_logo.css('display','block');
       	}
	})
	$(window).resize(function() { //창크기 변화 감지
       	windowWidth = $(this).width(); //현재 창의 너비
		if(windowWidth <= 991) {
       		$footer_main_logo.css('display','none');
       	} else {
       		$footer_main_logo.css('display','block');
       	}
	});
</script>