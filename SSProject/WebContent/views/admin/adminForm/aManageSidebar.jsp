<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ss.mango.admin.model.vo.Admin" %>
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
			<a href="/adminAllSelect.ss" class="hoverColor">
				<i class="fas fa-user fa-lg icon"></i>
				<span class="category">관리자 조회</span>
				<i class="fas fa-angle-right fa-lg icon arrow"></i>
			</a>
		</li>

		<li class="liStyle">
			<a href="/aManageAdminStats.ss" class="hoverColor">
				<i class="fas fa-chart-bar fa-lg icon"></i>
				<span class="category">매출 통계</span>
				<i class="fas fa-angle-right fa-lg icon arrow"></i>
			</a>
		</li>

	    <li class="liStyle">
			<a href="#" class="accList hoverColor">
            	<i class="fas fa-chart-line fa-lg icon"></i>
            	<span class="category">사용자 통계</span>
            	<i class="fas fa-angle-right fa-lg icon arrow"></i>
            </a>
            <div class="accordian" id="acc-2">
            	<a href="/aManageUserCount.ss" class="hoverColor">사용자 수 통계</a>
                <br/>
                <a href="/aManageUserReservation.ss" class="hoverColor">예약 건수 통계</a>
            </div>
		</li>

		<li class="liStyle">
			<a href="#" class="accList hoverColor">
				<i class="fas fa-chart-area fa-lg icon"></i>
				<span class="category">사업자 통계</span>
				<i class="fas fa-angle-right fa-lg icon arrow"></i>
			</a>
			<div class="accordian" id="acc-3">
				<a href="/aManagePartnerCount.ss" class="hoverColor">사업자 수 통계</a>
                <br />
                <a href="/aManagePartnerSpace.ss" class="hoverColor">공간 등록 통계</a>
                <br />
                <a href="/views/admin/aManage/aManagePartnerReservation.jsp" class="hoverColor">예약 건수 통계</a>
			</div>
		</li>
	</ul>
	<div>
		<center>
		<i id="toggle" class="hoverColor fas fa-3x fa-chevron-circle-left"></i>
		</center>
	</div>
</div><!--navSNB-->

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
        var $accList = $('.accList');
        var $accordian = $('.accordian');

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
                
        $accordian.removeClass('d-none');
        $accList.eq(0).attr('href','#'); //ver6
        $accList.eq(1).attr('href','#'); //경로비우기!
    }

    function sideSlim() {
        var $navSNB = $('#navSNB');
        var $arrow = $('.arrow');
        var $logo = $('.logo span');
        var $liStyleA = $('.liStyle>a');
        var $icon = $('.icon');
        var $category = $('.category');
        var $toggle = $('#toggle');
        var $accList = $('.accList');
        var $accordian = $('.accordian');

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
            
        $accordian.addClass('d-none');
        $accList.eq(0).attr('href','/aManageUserCount.ss'); //ver6
        $accList.eq(1).attr('href','/aManagePartnerCount.ss'); //경로 지정하기!
    }

    $('#toggle').click(function() {
        if ($(this).hasClass('fa-chevron-circle-left')) {
            sideSlim();
        } else {
            sideWide();
        }
    });

    $(".accList").click(function() { //화살표 방향 변화 추가
        var $arrow = $(".accList").not($(this)).children('.arrow'); //다른 화살표
        var $arrowClick = $(this).children('.arrow'); //클릭한 화살표
        //다른 화살표 방향 변화
        $arrow.removeClass('fa-angle-down');
        $arrow.addClass('fa-angle-right');

        //클릭한 화살표 방향 변화
        if ($arrowClick.hasClass('fa-angle-right')) {
            $arrowClick.removeClass('fa-angle-right');
            $arrowClick.addClass('fa-angle-down');

        } else if ($arrowClick.hasClass('fa-angle-down')) {
            $arrowClick.removeClass('fa-angle-down');
            $arrowClick.addClass('fa-angle-right');
        }
        
        $(".accordian").not($(this).next(".accordian").slideToggle()).slideUp();
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
</body></html>