<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="ss.mango.user.member.model.vo.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기 페이지</title>
    
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
    	#container {
    		margin: 0 auto;
    	}
    	#find_id_box {
    		max-width: 600px;
    		margin: 0 auto;
    	}
    	#find_id_title {
            margin: 0 auto;
            padding-top: 50px;
            padding-bottom: 40px;
            text-align: center;
        }
        .find_info {
            height: 50px;
            overflow: hidden;
            line-height: 50px;
        }
        .find_left_style {
            text-align: left;
            
        }
        .find_info_input {
            height: 40px;
            border: 1px solid #EBEBEB;
            border-radius: 5px;
            padding: 5px;
        }
        .find_info_input:focus {
        	outline: none;
        }
        #find_id_content {
        	margin: 0 auto;
        	padding-top: 30px;
        }
        #find_id_submit {
        	width: 100%;
        	height: 100%;
        	padding: 15px;
        	margin: 0 auto;
        }
    </style>
</head>
<body>
	<div class="wrapper">
        <div id="header">
            <%@ include file="/views/user/common/header.jsp" %>
        </div>
        <div class="main-content" id="container">
        	<div id="find_id_box" class="p-0">
        		<div class="row m-0 p-0">
	                <div id="find_id_title" class="col-8">
	                    <span><h3>아이디 찾기</h3></span>
	                </div>
	            </div>
                <form action="/MemberFindId.ss" method="post">
                	<div class="row m-0 p-0">
                		<div class="find_form col-12 p-0" style="margin: 0 auto">
                			<div class="row find_info m-0 p-0">
	                            <div class="col-3 col-md-4 find_left_style">
	                                <span class="span_style">회원유형</span>
	                            </div>
	                            <div class="col-9 col-md-8">
	                            	<select class="find_info_input span_style" name="select_member" style="min-width: 60px">
	                            		<option value="user" selected>개인회원</option>
	                            		<option value="partner">사업자회원</option>
	                            	</select> 
	                                &nbsp;
	                            </div>
	                        </div>
	                        <div class="row find_info m-0 p-0">
	                            <div class="col-3 col-md-4 find_left_style">
	                            </div>
	                            <div class="col-9 col-md-8" style="padding-bottom:20px;">
	                            	<input type="radio" name="select_type" value="email" checked/> <span class="span_style">이메일</span>
	                            	<input type="radio" name="select_type" value="phone"/> <span class="span_style">휴대폰번호</span>
	                            </div>
	                        </div>
	                        <div class="row find_info m-0 p-0">
	                            <div class="col-3 col-md-4 find_left_style">
	                                <span class="span_style">이름</span>
	                            </div>
	                            <div class="col-9 col-md-8">
	                                <input type="text" class="find_info_input" name="findName" size="30"/> 
	                                &nbsp;
	                            </div>
	                        </div>
	                        <div class="row find_info m-0 p-0" id="find_id_email">
	                            <div class="col-3 col-md-4 find_left_style">
	                                <span class="span_style">이메일로 찾기</span>
	                            </div>
	                            <div class="col-9 col-md-8">
	                                <input type="text" class="find_info_input" name="findEmail" size="30"/> 
	                                &nbsp;
	                            </div>
	                        </div>
	                        <div class="row find_info m-0 p-0 d-none" id="find_id_phone">
	                            <div class="col-3 col-md-4 find_left_style">
	                                <span class="span_style">휴대폰번호로 찾기</span>
	                            </div>
	                            <div class="col-9 col-md-8">
	                                <input type="text" class="find_info_input" name="findPhone" size="30"/> 
	                                &nbsp;
	                            </div>
	                        </div>
                		</div>
                		<div class="col-12" style="margin: 0 auto; padding-top: 20px;">
				            <div class="col-12 m-0 p-0 find_id_content">
				            	<input type="submit" value="확인" class="btn btn-dark" id="find_id_submit">
				            </div>
			            </div>
                	</div>
                </form>
            </div>
        </div>
        <div id="footer">
        	<%@ include file="/views/user/common/footer.jsp" %>
        </div>
    </div>
    
    <script>
    	$('input[value=email]').click(function() {
    		$('#find_id_email').removeClass('d-none');
    		$('#find_id_phone').addClass('d-none');
    	});
    	$('input[value=phone]').click(function() {
    		$('#find_id_phone').removeClass('d-none');
    		$('#find_id_email').addClass('d-none');
    	});
    </script>
    <script>
		var $windowWidth;
	    var $header = $('#header');
	    var $span_style = $('.span_style');
	    var $find_info_input = $('.find_info_input');
	    
		$(window).innerWidth(function() {
			if ($(this).width() <= 576) {
				$header.css('display','none');
				$span_style.css('font-size',' 14px');
				$find_info_input.css('max-width','')
            } else {
            	$header.removeAttr('style','display');
            	$span_style.css('font-size',' 18px');
            }
		});
		
        $(window).resize(function() { //창크기 변화 감지
            var windowWidth = $(this).width(); //현재 창의 너비
            $header = $('#header');
            
            if (windowWidth <= 576) {
                $header.css('display','none');
                $span_style.css('font-size',' 14px');
            } else {
                $header.removeAttr('style','display');
                $span_style.css('font-size',' 18px');
            }
    	});
    </script>
</body>
</html>