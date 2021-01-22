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
    	#withdrawpage_box {
    		max-width: 500px;
    		margin: 0 auto;
    	}
    	#withdrawpage_title {
            margin: 0 auto;
            padding-top: 50px;
            padding-bottom: 15px;
            text-align: center;
        }
        #withdrawpage_form {
        	border: 1px solid #EBEBEB;
        	border-radius: 10px;
        	padding: 20px 30px 10px 30px;
        	height: 300px;
        	box-shadow: 0px 3px 10px 1px lightgray;
        }
        #withdrawpage_main {
        	padding-top: 20px;
        	margin: 0 auto;
        	text-align: center;
        	height: 50px;
        }
        .withdrawpage_span {
        	padding: 20px 0;
        }
        .div_content {
        	margin: 5px 0px 5px 0px;
        	height: 60px;
        }
    	#restore_box {
    		max-width: 500px;
    		margin: 0 auto;
    		display: none;
    	}
    	#restore_title {
            margin: 0 auto;
            padding-top: 50px;
            padding-bottom: 15px;
            text-align: center;
        }
        #restore_form {
        	padding: 0px 30px 30px 30px;
        }
        #restore_main {
        	padding-top: 10px;
        	margin: 0 auto;
        	text-align: center;
        	height: 50px;
        	line-height: 50px;
        }
        .input_button {
        	width: 100%;
        	height: 100%;
        	padding: 15px;
        	margin-bottom: 5px;
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
        #prev_div {
        	background-color: white;
        	border: 1px solid #EBEBEB;
        }
        #prev_div:hover {
        	background-color: grey;
        	color: white;
        }
    </style>
</head>
<body>
	<div class="wrapper">
        <div id="header">
            <%@ include file="/views/user/common/header.jsp" %>
        </div>
        <% session.invalidate(); %>
        <div class="main-content" id="container">
        	<div id="withdrawpage_box" class="col-11">
        		<div class="row">
	                <div id="withdrawpage_title" class="col-8">
	                    <span><h3>탈퇴 진행 중</h3></span>
	                </div>
	            </div>
               	<div id="withdrawpage_form" class="row">
		            <div id="withdrawpage_main" class="col-12">
		            	<span class="withdrawpage_span">고객님께서는 현재 탈퇴 심사중에 있습니다.</span><br>
			            <span class="withdrawpage_span">탈퇴를 철회하시려면 '탈퇴 취소'를 클릭해주세요.</span>
		            </div>
		            <div class="col-12 div_content">
		            	<input type="button" value="탈퇴 취소" class="btn btn btn-danger input_button" id="go_restore">
		            	<a href="/index.jsp"><input type="button" value="홈으로" class="btn btn-secondary input_button" id="go_home"></a>
		            </div>
               	</div>
			</div>
			<div id="restore_box" class="col-11">
        		<div class="row">
	                <div id="restore_title" class="col-8">
	                    <span><h3>탈퇴 복구 신청</h3></span>
	                </div>
	            </div>
                <form action="/MemberRestoration.ss" method="post">
                	<div id="restore_form" class="row">
			            <div class="col-12 div_content">
			            	<input type="text" name="restoreId" class="div_input" placeholder="아이디"/>
			            </div>
			            <div class="col-12 div_content">
			            	<input type="Password" name="restorePw" class="div_input" placeholder="비밀번호" maxlength="20"/>
			            </div>
			            <div class="col-12 div_content">
			            	<input type="submit" value="복구신청" class="btn btn-dark input_button" id="input_submit">
			            	<input type="button" value="이전" class="input_button" id="prev_div">
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
    <script>
    	$(function() {
    		$('#go_restore').click(function() {
    			$('#withdrawpage_box').slideUp(600);
    			$('#restore_box').slideDown(600);
    		});
    		$('#prev_div').click(function() {
    			$('#restore_box').slideUp(600);
    			$('#withdrawpage_box').slideDown(600);
    		});
    	});
    </script>
</body>
</html>