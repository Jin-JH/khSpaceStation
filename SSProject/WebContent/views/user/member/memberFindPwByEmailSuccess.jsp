<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="ss.mango.user.member.model.vo.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 찾기 페이지</title>
    
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
    	#find_id_box {
    		max-width: 600px;
    		margin: 0 auto;
    	}
    	#find_id_title {
            margin: 0 auto;
            padding-top: 50px;
            padding-bottom: 0;
            text-align: center;
        }
        .find_success_info_title {
            background-color: rgba(235,235,235,0.4);
        }
        .change_pw{
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
        .divLeft{
        	display: inline-block;
        	width:200px; 
        	height:100%; 
        	border-right:1px solid #EBEBEB;
        }
        
        .newPwInput{
        	height:50px; margin:0; border: 2px solid #EBEBEB; border-radius:5px;
        }
    </style>
</head>
<body>
<%
	Member m1 = (Member)request.getAttribute("m1");
	String findName = request.getParameter("findName");
%>

	<div class="wrapper">
        <div id="header">
            <%@ include file="/views/user/common/header.jsp" %>
        </div>

		<script>
			$(function() {
				$('form').submit(function() {
					var $newPw = $('input[name=newPw]');
					var $newPwRe = $('input[name=newPwRe]');

					if(!(/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{10,16}$/.test($newPw.val()))) {
						alert("비밀번호는 영문,숫자,특수문자 조합으로 10~16자로 입력해주세요");
						$newPw.focus();
						return false;
					} else if(!($newPw.val() == $newPwRe.val())) {
						alert("비밀번호와 비밀번호 확인이 서로 다릅니다");
						$newPwRe.focus();
						return false;
					}
					return true;
				});
			});
		</script>

		<div class="main-content" id="container">
        <center>
        	<div id="find_id_box" class="p-0">
        		<div class="row m-0 p-0">
	                <div id="find_id_title" class="col-8">
	                    <span><h3>비밀번호 찾기</h3></span>
	                </div>
	            </div>
               	<div class="row m-0 p-0">
               		<div class="col-12 p-0" style="margin: 0 auto">
                		<div class="col-9" style="margin: 10px auto 0 auto; padding-top: 20px; padding-bottom: 0;">
		                    
		                    <h5 style="margin:0;"><b>[<%=findName%>]님 비밀번호 찾기가 완료되었습니다.</b></h5><br>
		                   	<h6>보안을 위해 기존 비밀번호를 변경해주세요</h6>
		                   	<span style="font-size:10px;">(영문 대소문자/숫자/특수문자 조합, 10자~16자)</span>
		                  	<hr>
		                </div>
	                </div>
	                <form action="/memberModifyPw.ss" method="post" style="margin: 0 auto;">
               		<div class="col-12 p-0 m-0"> 
               			<div class="row change_pw m-0 p-0">
                            <div class="col-12 m-0 p-0"><input class="newPwInput" type="password" name="newPw" size="50" placeholder=" 새 비밀번호"/>
                            </div>
                        </div>
               		</div><br>
               		<div class="col-12 p-0 m-0"> 
               			<div class="row change_pw m-0 p-0">
                            <div class="col-12 m-0 p-0">                            	
                            	<input class="newPwInput" type="password" name="newPwRe"size="50" placeholder=" 비밀번호 확인"/>
                            </div>
                        </div>
               		</div>
               		<div class="col-12" style="margin: 0 auto; padding-top: 20px;">
               			<div style="text-align: center;">
			                <button class="btn btn-dark" id="find_id_submit" style=" width: 40%">비밀번호 변경</button>
		            	</div>
		            </div>
		            </form>
               	</div>
            </div>
            </center>
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