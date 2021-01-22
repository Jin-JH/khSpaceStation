<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="ss.mango.user.member.model.vo.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
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
    		height: 70%;
    	}
    	#login_box {
    		max-width: 600px;
    		margin: 0 auto;
    	}
    	#login_title {
            margin: 0 auto;
            padding-top: 50px;
            padding-bottom: 15px;
            text-align: center;
        }
        #login_form {
        	border: 1px solid #EBEBEB;
        	border-radius: 10px;
        	padding: 0px 30px 30px 30px;
        	box-shadow: 0px 3px 10px 1px lightgray;
        }
        #login_main {
        	padding-top: 10px;
        	margin: 0 auto;
        	text-align: center;
        	height: 50px;
        	line-height: 50px;
        }
        .div_content {
        	margin: 5px 0px 5px 0px;
        	height: 60px;
        }
        .div_input {
        	width: 100%;
        	height: 100%;
        	padding: 15px;
        	border: 1px solid #EBEBEB;
        	border-radius: 5px;
        }
        .div_input:focus {
        	outline: none;
        }
        #input_submit {
        	width: 100%;
        	height: 100%;
        	padding: 15px;
        }
        #div_footer {
        	text-align: center;
        	height: 60px;
        	line-height: 60px;
        }
        #div_footer>ul {
        	margin: 0px;
        	padding: 0px;
        }
        #div_footer>ul>li {
        	display: inline;
        	margin: 0px;
        	padding: 0px;
        	list-style-type: none;
        }
        #div_footer a {
        	color:black;
        	font-size: 14px;
        }
    </style>
</head>
<body>
	<div class="wrapper">
        <div id="header">
            <%@ include file="/views/user/common/header.jsp" %>
        </div>
        <div class="main-content" id="container">
        	<div id="login_box">
        		<div class="row">
	                <div id="login_title" class="col-8">
	                    <span><h3>로그인</h3></span>
	                </div>
	            </div>
                <form action="/MemberLogin.ss" method="post">
                	<div id="login_form" class="row">
			            <div id="login_main" class="col-8">
				            <input type="radio" name="loginType" value="user" checked/> 개인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				            <input type="radio" name="loginType" value="partner"/> 파트너
			            </div>
			            <div class="col-12" style="text-align: right; font-size: 13px">보안접속</div>
			            <div class="col-12 div_content">
			            	<input type="text" name="memberId" class="div_input" placeholder="아이디" autocomplete="off"/>
			            </div>
			            <div class="col-12 div_content">
			            	<input type="Password" name="memberPw" class="div_input" placeholder="비밀번호" maxlength="20" autocomplete="off"/>
			            </div>
			            <div class="col-12 div_content">
			            	<input type="submit" value="로그인" class="btn btn-dark" id="input_submit">
			            </div>
			            <div class="col-12" id="div_footer">
			            	<ul>
			            		<li><a href="/views/user/member/memberJoin.jsp">회원가입</a>&nbsp;&nbsp;<span style="color: grey">|</span>&nbsp;</li>
			            		<li><a href="/views/user/member/memberFindId.jsp">아이디</a>&nbsp;/
			            			<a href="/views/user/member/memberFindPw.jsp">비밀번호 찾기</a></li>
			            	</ul>
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
		var $windowWidth;
	    var $header = $('#header');
	    
		$(window).innerWidth(function() {
			if ($(this).width() <= 576) {
				$header.css('display','none');
            } else {
            	$header.removeAttr('style','display');
            }
		});
		
        $(window).resize(function() { //창크기 변화 감지
            var windowWidth = $(this).width(); //현재 창의 너비
            $header = $('#header');
            
            if (windowWidth <= 576) {
                $header.css('display','none');
            } else {
                $header.removeAttr('style','display');
            }
    	});
    </script>
</body>
</html>