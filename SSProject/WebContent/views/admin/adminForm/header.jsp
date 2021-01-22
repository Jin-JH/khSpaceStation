<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ss.mango.admin.model.vo.Admin" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	Admin rightAdmin = (Admin)session.getAttribute("admin");
%>
<% if(rightAdmin==null){ %>
	<script>
		//로그인 하지않고 페이지 접근시 예외처리
		location.replace("/views/admin/error/loginError.jsp");
	</script>
<% }else{
	char right = rightAdmin.getRight(); %>
	<script>
	$(function(){
		var $navGNB = $('.navGNB');
		$.each($navGNB, function(index, item) { //권한에 맞지 않는 페이지 접근시 예외처리
            if ($(this).hasClass('mangoBgcolor')) {
                var tap = $(this).children('a').text();
                
                <% if(right=='P'){ %>
					if(tap="관리자" && tap=="사용자"){
						location.replace("/views/admin/error/rightError.jsp");
					}else{
						return;
					}
				<% }else if(right=='U'){ %>
					if(tap="관리자" && tap=="사업자"){
						location.replace("/views/admin/error/rightError.jsp");
					}else{
						return;
					}
				<% }else{ %>
					return;
				<% } %>
	    	}
        });
		
		$('.navGNB>a').click(function(){ //권한에 맞는 TAP만 클릭 가능
			var tap = $(this).text();
			
			<% if(right=='P'){ %>
				if(tap=="사업자"){
					return true;
				}else{
					alert("권한이 없습니다.");
					return false;
				}
			<% }else if(right=='U'){ %>
				if(tap=="사용자"){
					return true;
				}else{
					alert("권한이 없습니다.");
					return false;
				}
			<% }else{ %>
				return true;
			<% } %>
		});
		
		$('.category').parents('a').click(function(){ // 권한에 맞는 메뉴만 클릭 가능
			var tap = $('.mangoBgcolor>a').text();
		
			<% if(right=='P'){ %>
				if(tap=="사업자"){
					return true;
				}else{
					alert("권한이 없습니다.");
					return false;
				}
				
			<% }else if(right=='U'){ %>
				if(tap=="사용자"){
					return true;
				}else{
					alert("권한이 없습니다.");
					return false;
				}
			<% }else{ %>
				return true;
			<% } %>
		});
		
		$('.accordian a').click(function(){ // 권한에 맞는 소메뉴만 클릭 가능
			var tap = $('.mangoBgcolor>a').text();
		
			<% if(right=='P'){ %>
				if(tap=="사업자"){
					return true;
				}else{
					alert("권한이 없습니다.");
					return false;
				}
				
			<% }else if(right=='U'){ %>
				if(tap=="사용자"){
					return true;
				}else{
					alert("권한이 없습니다.");
					return false;
				}
			<% }else{ %>
				return true;
			<% } %>
		});
	});
	</script>
<% } %>
<body>
<div id="header" class="row">
	<div class="col-3 col-md-2">
		<a href='/MemberLogout.ss' class="house hoverColor">
			<i class="fas fa-rocket fa-2x"></i>
		</a>
	</div>
	<div class="col-2 col-md-3"></div>
	
	<div class="col-2 navGNB hoverColor">
		<a href="/adminAllSelect.ss">관리자</a>
	</div>
	
	<div class="col-2 navGNB hoverColor">
		<a href="/selectAllUser.ss">사용자</a>
	</div>
	
	<div class="col-2 navGNB hoverColor">
		<a href="/selectAllPartner.ss">사업자</a>
	</div>
	<div class="col-1"></div>
</div><!-- header -->
<script>
$(function(){
	
	$(window).resize(function() { //창크기 변화 감지
        var windowWidth = $(this).width(); //현재 창의 너비
        var $navGNB = $('.navGNB');

        if (windowWidth <= 720) { //sm은 540px, md는 720px, lg는 960px.

            $.each($navGNB, function(index, item) { //선택하지 않은 탭은 none
                if ($(this).hasClass('mangoBgcolor')) {
                    $(this).removeClass('col-2');
                    $(this).addClass('col-6');
                } else {
                    $(this).removeClass('col-2');
                    $(this).addClass('d-none');
                }
            });

        } else {
            $navGNB.removeClass('col-2');
            $navGNB.removeClass('col-6');
            $navGNB.removeClass('d-none');
            $navGNB.addClass('col-2');
        }
    });
});
</script>
</body>
</html>