<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ss.mango.user.member.model.vo.Member"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<style>
* {
	/*box-sizing: border-box;
            border: 1px solid black;*/
	
}



body, html {
	height: 100%;
}

#wrapper {
	height: 100%;
	display: flex;
}

#navSNB {
	background-color: #9614EF;
	color: white;
	overflow: hidden;
}

.sideStyle-wide {
	min-width: 260px;
	padding: 0 20px;
	font-weight: 900;
}

.sideStyle-slim {
	min-width: 130px;
	padding: 0 5px;
	font-weight: 900;
}

#content {
	overflow: auto;
}

#fluid {
	overflow: auto;
}

.ulStyle {
	padding: 0px;
	margin: 0 0 60px 0;
	list-style: none;
}

.liStyle {
	text-align: center;
	padding: 20px 0px;
	margin: 0px;
}

.liStyle-white {
	border-top: 1px solid white;
	border-bottom: 1px solid white;
	margin-bottom: 20px;
}

.liStyle>a {
	width: 100%;
	height: 100%;
	color: white;
	display: flex;
	justify-content: center;
	align-items: center;
}

.liStyle>a:hover {
	text-decoration: none;
}

.logo {
	height: 100px;
	font-size: 23px;
}

.dashboard { /*추가 ver5*/
	width: 40%;
	margin: 0 auto;
	font-size: 19px;
	font-weight: 800;
}

.category {
	width: 70%;
	font-size: 17px;
}

.icon {
	width: 15%;
}

#toggle {
	cursor: pointer;
}

#houseArea, #loginUserId{
	width: 100%;
}

.house {
	color: #9614EF;
	border: 2px solid #9614EF;
	border-radius: 7px;
	float: left;
	margin-top: 30px;
	margin-left: 48px;
}

.house:hover {
	color: #9614EF;
}

.navGNB {
	height: 40%;
	line-height: 40px;
	text-align: center;
	font-size: 22px;
	font-weight: 800;
	margin-top: 60px;
	margin-right: 7.5px;
	padding: 0px;
	background-color: lightgray;
	border-top-left-radius: 15px;
	border-top-right-radius: 15px;
}

.navGNB>a {
	display: block;
	width: 100%;
	height: 100%;
	color: white;
	text-decoration: none;
}

.navGNB-bgcolor {
	background-color: #9614EF;
}

.accList {
	position: relative;
}

.accordian {
	padding: 10px 0;
	margin-top: 20px;
	background-color: white;
	text-align: center;
	border-radius: 15px;
	font-size: 15px;
	cursor: default;
}

.accordian a {
	color: black;
	text-decoration-line: none;
}

#acc-2 {
	height: 100px;
	line-height: 40px;
}

#acc-3 {
	height: 149px;
	line-height: 43px;
}


.hoverColor {
	opacity: 0.8;
}

.hoverColor:hover {
	opacity: 1.0;
}

.padding1 {
	padding: 15px;
	margin: 0;
}

.padding2 {
	padding: 3px;
	margin: 0;
	height: 30px;
	border-radius: 3px;
}

.tableStyle {
	width: 100%;
	margin: 10px 0;
	text-align: center;
}

table * {
	padding: 10px;
}

/*요것들은 왜 있는지 모르겠으나 무서워서 일단 두기*/
/*.mangoBgcolor { 탭 색깔칠하기 위한 클래스 
	background-color: #9614EF;
}*/ 

.bgColor1 {
	background-color: rgba(211, 211, 211, 0.1);
}

.bgColor2{
	background-color: white;
	border: 1px solid lightgray;
	padding: 10px;
}

#header {
	width: 100%;
	height: 100px; /*이건 평주꺼에만 있음*/
	border-bottom: 1px solid lightgray;
}

#whiteBoard {
	border-radius: 10px;
	box-shadow: 0px 3px 10px 1px lightgray; /*그림자 추가*/
	margin-bottom: 20px;
}

/*얘들도 뭔진 모르겠지만.. 이케저케되겠지라...?*/
#inquiry {
	font-weight: 800;
	font-size: 20px;
	color: #9614EF;
}

#selectAlign {
	text-align: right;
}

#searchBtn {
	background-color: #9614EF;
	color: white;
	width: 30px;
	line-height: 24px;
	text-align: center;
	border: 1px solid #9614EF;
}




</style>
</head>
<body>

	<script>
$(document).ready(function() {
    
    function sideWide() {
        var $navSNB = $('#navSNB');
        var $arrow = $('.arrow');
        var $logo = $('.logo span');
        var $liStyleA = $('.liStyle>a');
        var $icon = $('.icon');
        var $category = $('.category');
        var $categoryDash = $('.category-dash');
        var $toggle = $('#toggle');
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
        $categoryDash.parents('a').css('padding', '0px');
        $categoryDash.css('width', '85%');
        $categoryDash.css('height', '');
                
        $accordian.removeClass('d-none');
    }

    function sideSlim() {
        var $navSNB = $('#navSNB');
        var $arrow = $('.arrow');
        var $logo = $('.logo span');
        var $liStyleA = $('.liStyle>a');
        var $icon = $('.icon');
        var $category = $('.category');
        var $categoryDash = $('.category-dash');
        var $toggle = $('#toggle');
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
        $categoryDash.parents('a').css('padding', '10px');
        $categoryDash.css('width', '100%');
        $categoryDash.css('height', '50%');
            
        $accordian.addClass('d-none');
    }

    $('#toggle').click(function() {
        $(".accordian").hide(); //토글 클릭하면 일단 accordian을 숨김 ver5
                
        if ($(this).hasClass('fa-chevron-circle-left')) {
            sideSlim();
        } else {
            sideWide();
        }
    });

    $(".accordian").hide();
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
        var $navGNB = $('.navGNB');

        if (windowWidth <= 720) { //sm은 540px, md는 720px, lg는 960px.
            sideSlim();
            $toggle.addClass('d-none');

            $.each($navGNB, function(index, item) { //선택하지 않은 탭은 none
                if ($(this).hasClass('navGNB-bgcolor')) {
                    $(this).removeClass('col-2');
                    $(this).addClass('col-6');
                } else {
                    $(this).removeClass('col-2');
                    $(this).addClass('d-none');
                }
            });

        } else {
            sideWide();
            $toggle.removeClass('d-none');
            
            $navGNB.removeClass('col-2');
            $navGNB.removeClass('col-6');
            $navGNB.addClass('col-2');
            $navGNB.removeClass('d-none');
        }
    });

}); //---$(document).ready(function()내부의 끝
</script>

<style>
	.dashboard>a{
		color : white;
	}
	
</style>


<% 
		Member m = (Member)session.getAttribute("member"); 
%>



	<div id="wrapper">
		<div id="navSNB" class="sideStyle-wide">
			<ul class="ulStyle">
				<li class="liStyle logo"><a><span>PARTNER CMS</span></a></li>

				 <li class="liStyle liStyle-white">
                    
                        <span class="dashboard"><a href="/dashTable.do">Dashboard</a></span>
                    </a>
                </li>

                <li class="liStyle">
                    <a href="#" class="accList hoverColor">
                        <i class="fas fa-user fa-lg icon"></i>
                        <span class="category">고객관리</span>
                        <i class="fas fa-angle-right fa-lg icon arrow"></i>
                    </a>
                    <div class="accordian" id="acc-2">
                        <a href="/views/partner/content/inquiryBoard.jsp" class="hoverColor">문의게시판 관리</a>
                        <br />
                        <a href="/customerManagement.do" class="hoverColor">고객 관리</a>
                    </div>
                </li>

                <li class="liStyle">
                    <a href="#" class="accList hoverColor">
                        <i class="fas fa-chart-bar fa-lg icon"></i>
                        <span class="category">센터관리</span>
                        <i class="fas fa-angle-right fa-lg icon arrow"></i>
                    </a>
                    <div class="accordian" id="acc-3">
                        <a href="/allSpaceSelect.do" class="hoverColor">공간 등록</a>
                        <br />
                        <a href="/boardAllListPage.do" class="hoverColor">회의실 관리</a>
                        <br/>
                        <a href="#" class="hoverColor">정보 수정 내역</a>
                    </div>
                </li>

                <li class="liStyle">
                    <a href="#" class="accList hoverColor">
                        <i class="fas fa-chart-line fa-lg icon"></i>
                        <span class="category">예약관리</span>
                        <i class="fas fa-angle-right fa-lg icon arrow"></i>
                    </a>
                    <div class="accordian" id="acc-3">
                        <a href="/views/partner/content/reservationManagement.jsp" class="hoverColor">공간 예약 관리</a>
                        <br />
                        <a href="/reservationCompleted.do" class="hoverColor">예약 완료 관리</a>
                        <br />
                        <a href="/views/partner/content/allReservationLookup.jsp" class="hoverColor">전체 예약 조회</a>
                    </div>
                    
                </li>

                <li class="liStyle">
                    <a href="#" class="accList hoverColor">
                        <i class="fas fa-chart-area fa-lg icon"></i>
                        <span class="category">매출관리</span>
                        <i class="fas fa-angle-right fa-lg icon arrow"></i>
                    </a>
                    <div class="accordian" id="acc-2">
                        <a href="/views/partner/content/settlementDetails.jsp" class="hoverColor">정산 내역</a>
                        <br />
                        <a href="/daily.do" class="hoverColor">통계</a>
                    </div>
                </li>
			</ul>
			<div>
				<center>
					<i id="toggle" class="hoverColor fas fa-3x fa-chevron-circle-left"></i>
				</center>
			</div>
		</div>

		<div id="content" class="container-fluid">
			<div id="header" class="row">
				<div class="col-4 col-md-4" id="houseArea">
					<!--반응형 수정-->
					<a href="/index.jsp" class="house hoverColor"><i
						class="fas fa-home fa-2x"></i></a>
				</div>
				<div class="col-5 col-md-5"></div>
				<div class="col-3 col-md-3" id="loginUserId">
					<%if(m!=null){ %>
						<ul class="zeta-menu">
							<li><a href="#"><%=m.getMemberName() %></a>
								<ul id="dropDown">
									<li class="down"><a href="/MemberPartnerInfo.ss">마이페이지</a></li>
									<li class="down"><a href="/MemberLogout.ss">로그아웃</a></li>
								</ul>
							</li>
						</ul>
					
					<%}else{%>
						<a href="#">해리포터</a>
						<!-- m.getUserName() -->
					<%} %>
				</div>
				<!--반응형 수정-->
			</div>
		
<script>

	$(function(){
	$(document).mouseup(function(e) {
		if ($(e.target).parents('.zeta-menu').length == 0) {
			$('.zeta-menu li').removeClass('expand');
			$('.zeta-menu ul').hide();
		}
	});
	$(".zeta-menu>li:has(ul)>a").each( function() {
		$(this).html( $(this).html()+' &or;' );
	});
	$(".zeta-menu ul li:has(ul)")
		.find("a:first")
		.append("<p style='float:right;margin:-3px'>&#343a40;</p>");

	$(".zeta-menu li>a").click(function(){
		var li = $(this).parent();
		var ul = li.parent()
		ul.find('li').removeClass('expand');
		ul.find('ul').not(li.find('ul')).hide();
		li.children('ul').toggle();
		if( li.children('ul').is(':visible') || li.has('ul')) {
			li.addClass('expand');
		}
	});
});	
</script>
<style>
/*이건 위에 로그아웃 칸이구먼유..*/
#loginUserId{
	height: 100px;
	/* border: 1px solid blue; */
	text-align: center;
	line-height: 70px;
	font-size: 18px;
}

#loginUserId>a{
	text-decoration: none;
	color : #343a40;
}



.zeta-menu a {
  display: block;
  padding: 10px 10px;
  text-decoration: none;
}

.zeta-menu { margin: 0; padding: 0; list-style:none;}

.zeta-menu li:hover { color: #FF9614; }
.zeta-menu li.expand { background: white; }
.zeta-menu li.expand>a { color: blue; }


#dropDown {
  background: #fefefe;
  display: none;
  padding: 0;
  position: absolute;
  left: 110px;
  top: 100%;
  width: 45%;
  list-style:none;
  z-index : 999;
}

.down{
	border: 1px solid #eee;
}

.zeta-menu ul li { float: none; } 
.zeta-menu ul li.expand a { color: #343a40; }
.zeta-menu ul a { color: #343a40; }
.zeta-menu ul ul { left: 100%; top: 0; }
</style>
			
			
</body>
</html>
				