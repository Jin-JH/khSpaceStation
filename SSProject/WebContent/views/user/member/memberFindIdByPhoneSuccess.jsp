<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ss.mango.user.member.model.vo.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기 페이지</title>
	<%@ include file="/views/user/common/__js.jsp" %>
    
    <style>
    	* {
            box-sizing: border-box;
            margin: 0px;
            padding: 0px;
    	}
    	#container {
    		margin: 0 auto;
    	}
    	#find_pw_box {
    		max-width: 600px;
    		margin: 0 auto;
    	}
    	#find_pw_title {
            margin: 0 auto;
            padding-top: 50px;
            padding-bottom: 40px;
            text-align: center;
        }
        .find_success_info_title {
            background-color: rgba(235,235,235,0.4);
        }
        .find_success_info {
            overflow: hidden;
            line-height: 50px;
        }
        .find_left_style {
            text-align: left;   
        }
        .find_success_info_input {
            height: 40px;
            border: 1px solid #EBEBEB;
            border-radius: 5px;
            padding: 5px;
        }
        .find_success_info_input:focus {
        	outline: none;
        }
        #find_pw_content {
        	margin: 0 auto;
        	padding-top: 30px;
        }
        #find_pw_submit {
        	width: 100%;
        	height: 100%;
        	padding: 15px;
        	margin: 0 auto;
        }
    </style>
</head>
<body>

<% 
	Member m2 = (Member)request.getAttribute("m2");
	
	String findName = request.getParameter("findName");
	String findPhone = request.getParameter("findPhone");
%>
	<div class="wrapper">
        <div id="header">
            <%@ include file="/views/user/common/header.jsp" %>
        </div>
        <div class="main-content" id="container">
        	<div id="find_pw_box" class="p-0">
        		<div class="row m-0 p-0">
	                <div id="find_pw_title" class="col-8">
	                    <span><h3>아이디 찾기</h3></span>
	                </div>
	            </div>
               	<div class="row m-0 p-0">
               		<div class="col-12 p-0" style="margin: 0 auto">
                		<div class="col-9" style="margin: 0 auto; padding-top: 50px; padding-bottom: 30px;">
		                    <h5><b>[<%=findName%>]님 아이디 찾기가 완료되었습니다.</b></h5>
		                </div>
	                </div>
	                <div class="row p-0 m-0" style="border: 2px solid #EBEBEB; border-radius: 5px;"> 
		                <div class="col-12 find_success_info_title p-0 m-0">
		                	<i class="fas fa-exclamation" style="padding: 30px; align: center; font-size:20px; color:red;"></i>
		                	<span style="line-height: 70px; margin: 0 0 0 -10px">입력된 정보로 가입된 아이디입니다.</span>
		                </div>
               			<div class="row find_success_info m-0" style="padding: 10px 0px 10px 20px">
                            <div class="col-12 m-0 p-0">
                            	<span>이름</span>
                            	<span>&nbsp;&nbsp;&nbsp;: &nbsp;<%=findName%></span>
                            </div><br>
                            <div class="col-12 m-0 p-0">
                            	<span>휴대폰번호</span>
                            	<span>: &nbsp;<%=findPhone%></span>
                            </div>
                            <div class="col-12 m-0 p-0">
                            	<input type="radio" checked/> &nbsp;<%=m2.getMemberId()%>
                            </div>
                        </div>
               		</div>
               		<div class="col-12" style="margin: 0 auto; padding-top: 20px;">
               			<div style="text-align: center;">
			            	<a href="/views/user/member/memberLogin.jsp"><button class="btn btn-dark" id="find_pw_submit" style=" width: 40%">로그인</button></a>
			            	&nbsp;&nbsp;&nbsp;
			            	<a href="/views/user/member/memberFindPw.jsp"><button class="btn btn-light" id="find_pw_submit" style=" width: 40%">비밀번호 찾기</button></a>
		            	</div>
		            </div>
               	</div>
            </div>
        </div>
        <div id="footer">
        	<%@ include file="/views/user/common/footer.jsp" %>
        </div>
    </div>
    
    <script>
		var $windowWidth;
	    var $header = $('#header');
	    var $span_style = $('.span_style');
	    var $find_success_info_input = $('.find_success_info_input');
	    
		$(window).innerWidth(function() {
			if ($(this).width() <= 576) {
				$header.css('display','none');
				$span_style.css('font-size',' 14px');
				$find_success_info_input.css('max-width','')
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