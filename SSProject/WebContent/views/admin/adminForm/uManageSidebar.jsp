<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="navSNB" class="sideStyle-wide">
	<ul class="ulStyle">
		<li class="liStyle logo">
			<a href="/adminMain.ss">
				<span>ADMIN CMS</span>
			</a>
		</li>

		<li class="liStyle liStyle-white">
			<a href="/MemberLogout.ss" class="logout">
				<span>LOGOUT</span>
			</a>
		</li>

		<li class="liStyle">
			<a href="/selectAllUser.ss" class="hoverColor">
				<i class="fas fa-user fa-lg icon"></i>
				<span class="category">사용자 조회</span>
				<i class="fas fa-angle-right fa-lg icon arrow"></i>
			</a>
		</li>

		<li class="liStyle">
			<a href="/selectReservation.ss" class="hoverColor">
				<i class="far fa-list-alt fa-lg icon"></i>
				<span class="category">예약 조회</span>
				<i class="fas fa-angle-right fa-lg icon arrow"></i>
			</a>
		</li>

		<li class="liStyle">
			<a href="/views/admin/uManage/uManageRefund.jsp" class="hoverColor">
				<i class="far fa-credit-card fa-lg icon"></i>
				<span class="category">환불 승인</span>
				<i class="fas fa-angle-right fa-lg icon arrow"></i>
			</a>
		</li>

		<li class="liStyle">
			<a href="/signOutUser.ss" class="hoverColor">
				<i class="fas fa-address-card fa-lg icon"></i>
				<span class="category">탈퇴 승인</span>
				<i class="fas fa-angle-right fa-lg icon arrow"></i>
			</a>
		</li>
			
		<li class="liStyle">
			<a href="/userQuestion.ss" class="hoverColor">
				<i class="fas fa-question fa-lg icon"></i>
				<span class="category">문의사항</span>
				<i class="fas fa-angle-right fa-lg icon arrow"></i>
			</a>
		</li>
	</ul>
	<div>
		<center>
			<i id="toggle" class="hoverColor fas fa-3x fa-chevron-circle-left"></i>
		</center>
	</div>
</div> <!--navSNB-->
<script>
$(function(){
	
    function sideWide() {
        var $navSNB = $('#navSNB');
        var $arrow = $('.arrow');
        var $logo = $('.logo span');
        var $liStyleA = $('.liStyle>a');
        var $icon = $('.icon');
        var $category = $('.category');
        var $toggle = $('#toggle');

        $toggle.removeClass('fa-chevron-circle-right');
        $toggle.addClass('fa-chevron-circle-left');

        $navSNB.removeClass('sideStyle-slim');
        $navSNB.addClass('sideStyle-wide');

        $arrow.removeClass('d-none');
        $logo.removeClass('d-none');
        $liStyleA.css('display', 'flex');

        $icon.css('width', '15%');
        $category.css('width', '70%');
        $category.css('height', '');
    }

    function sideSlim() {
        var $navSNB = $('#navSNB');
        var $arrow = $('.arrow');
        var $logo = $('.logo span');
        var $liStyleA = $('.liStyle>a');
        var $icon = $('.icon');
        var $category = $('.category');
        var $toggle = $('#toggle');
       	
        $toggle.removeClass('fa-chevron-circle-left');
        $toggle.addClass('fa-chevron-circle-right');

        $navSNB.removeClass('sideStyle-wide');
        $navSNB.addClass('sideStyle-slim');

        $arrow.addClass('d-none');
        $logo.addClass('d-none');
        $liStyleA.css('display', 'block');

        $icon.css('width', '100%');
        $category.css('width', '100%');
        $category.css('height', '50%');
    }

    $('#toggle').click(function() {
        if ($(this).hasClass('fa-chevron-circle-left')) {
            sideSlim();
        } else {
            sideWide();
        }
    });

    $(window).resize(function() { //창크기 변화 감지
        var windowWidth = $(this).width(); //현재 창의 너비
        var $toggle = $('#toggle');

        if (windowWidth <= 720) { //sm은 540px, md는 720px, lg는 960px.
            sideSlim();
            $toggle.addClass('d-none');

        } else {
            sideWide();
            $toggle.removeClass('d-none');
        }
    });
    
}); //---$(document).ready(function()내부의 끝
</script>
</body>
</html>