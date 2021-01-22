<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 페이지 (사용자)</title>
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
    		z-index: 99;
    	}
    	#join_page {
            padding-top: 20px;
            margin: 0 auto;
            padding-left: 30px;
            padding-right: 30px;
        }
        #join_page_title {
        	margin-top: 50px;
        	margin-bottom: 50px;
            text-align: center;
        }
        #join_page_content {
            display: flex;
            margin: auto;
            max-width: 1000px;
        }
        #join_page_content_title>span {
        	position: absolute;
        	right: 0;
        	bottom: 10px;
        	font-size: 14px;
        }
        #span_essential {
        	color: red;
        }
        #join_page_content_title_info {
        	margin-top: 10px;
        }
        .join_info {
            height: 80px;
            overflow: hidden;
            border-top: 1px solid #EBEBEB;
            border-bottom: 1px solid #EBEBEB;
        }
        .join_info_left {
            text-align: center;
            background-color: rgba(235,235,235,0.4);
            line-height: 80px;
        }
        .join_info_right {
        	padding: 20px;
        }
        .join_info_input {
            height: 40px;
            border: 1px solid #EBEBEB;
            border-radius: 5px;
            padding: 5px;
            box-shadow: 1px 1px #EBEBEB;
        }
        .join_info_input:focus {
            outline: none;
        }
        #check_find_id {
            border: 2px solid #EBEBEB;
            border-radius: 5px;
            margin-left: 2px;
            padding: 7px 20px;
            background-color: white;
        }
        #check_find_id:hover {
        	cursor: pointer;
        	background-color: grey;
        	color: white;
        }
        #join_page_terms {
            margin: 50px auto;
            background-color: rgba(235,235,235,0.4);
            padding: 0px;
        }
        .join_terms_content {
            padding: 30px;
            border: 1px solid #EBEBEB;
        }
        .terms_textarea {
            overflow: auto;
            width: 100%;
            height: 100px;
            padding: 10px;
            margin: 12px 0 12px;
            border: 1px solid #EBEB;
            border-radius: 5px;
            background-color: white;
        }
        .span_font {
            font-weight: bold;
            margin: 0px 0px 12px;
        }
        #join_button {
            margin: 0 auto;
            width: 200px;
            height: 80px;
            font-size: 25px;
            border-radius: 16px;
            margin-bottom: 50px;
        }
    </style>
</head>
<body>

    
	<div class="wrapper">
		<div id="header">
			<%@ include file="/views/user/common/header.jsp" %>
		</div>
	<script>
    	$(function() {
    		$('form').submit(function() {
    			var $memberName = $('input[name=memberName]');
    			var $memberId = $('input[name=memberId]');
    			var $memberPw = $('input[name=memberPw]');
    			var $memberPwRe = $('input[name=memberPwRe]');
    			var $tel_input_01 = $('input[name=tel_input_01]');
    			var $tel_input_02 = $('input[name=tel_input_02]');
    			var $tel_input_03 = $('input[name=tel_input_03]');
    			var $memberEmail = $('input[name=memberEmail]');
    			
    			var num = $memberName.val().search(/[0-9]/g);
    			var eng = $memberName.val().search(/[a-z]/ig);
    			var spe = $memberName.val().search(/[~!@#$%^&*()]/gi);
    			
    			if(!(/^[가-힣]{2,5}$/.test($memberName.val()))) {
    				alert("이름은 한글로 2~5자로 입력해주세요");
    				$memberName.focus();
    				return false;
    			} else if(!(/^(?=.*[a-z])(?=.*[0-9]).{4,10}$/.test($memberId.val()))) {
    				alert("아이디는 영문 소문자 또는 숫자 조합으로 4~10자로 입력해주세요");
    				$memberId.focus();
    				return false;
    			} else if(!(/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{10,16}$/.test($memberPw.val()))) {
    				alert("비밀번호는 영문,숫자,특수문자 조합으로 10~16자로 입력해주세요");
    				$memberPw.focus();
    				return false;
    			} else if(!((num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0))) {
    				alert("영문,숫자,특수문자 중 2가지 이상을 혼합하여 입력해주세요.");
    				$memberPw.focus();
    				return false;
    			} else if(!($memberPw.val()==$memberPwRe.val())) {
    				alert("비밀번호와 비밀번호 확인이 서로 다릅니다");
    				$memberPwRe.focus();
    				return false;
    			} else if(($tel_input_02.val().length)!=4) {
    				alert("휴대폰번호 가운데 4자리를 입력해주세요.");
    				$tel_input_02.focus();
    				return false;
    			} else if(($tel_input_03.val().length)!=4) {
    				alert("휴대폰번호 끝자리 4자리를 입력해주세요.");
    				$tel_input_03.focus();
    				return false;
    			} else if(!(/^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/.test($memberEmail.val()))) {
    				alert("올바른 이메일 형식을 입력해주세요.");
    				$memberEmail.focus();
    				return false;
    			} else if(!($('input[name=termscheck01]').prop("checked"))) {
    				alert("필수 항목에 체크해주세요");
    				$('input[name=termscheck01]').focus();
    				return false;
    			} else if(!($('input[name=termscheck02]').prop("checked"))) {
    				alert("필수 항목에 체크해주세요");
    				$('input[name=termscheck02]').focus();
    				return false;
    			}
    			return true;
    		});
			$('input[name]').focusin(function() {
				$(this).css('background-color','rgb(232, 240, 254');
			});
			$('input[name]').focusout(function() {
				$(this).css('background-color','white');
			});
    	});
    </script>
		<div class="main-content" id="container">
            <div id="join_page">
                <div id="join_page_title">
                    <h2>회원가입</h2>
                </div>
                <form action="/MemberJoinUser.ss" method="post" name="joinForm">
	                <div id="join_page_content" class="row">
	                    <div id="join_page_content_title" class="col-12">
							<h5><b>기본정보</b></h5>
							<span><span id="span_essential">*</span>표시는 필수항목입니다.</span>
						</div>
						<div id="join_page_content_title_info" class="col-12">
	                        <div class="row join_info">
	                            <div class="col-3 col-md-2 join_info_left">
	                                <span class="span_style">이름<span id="span_essential">*</span></span>
	                            </div>
	                            <div class="col-9 col-md-10 join_info_right">
	                                <input type="text" class="join_info_input" name="memberName" autocomplete="off"/> 
	                                &nbsp;
	                            </div>
	                        </div>
	                        <div class="row join_info">
	                            <div class="col-3 col-md-2 join_info_left">
	                                <span class="span_style">아이디<span id="span_essential">*</span></span>
	                            </div>
	                            <div class="col-9 col-md-10 join_info_right">
	                                <input type="text" class="join_info_input" name="memberId" maxlength="20" autocomplete="off"/>
	                                <input type="button" value="중복확인" id="check_find_id" onclick="checkForm()"/>
	                            </div>
	                        </div>
	                        <div class="row join_info row">
	                            <div class="col-3 col-md-2 join_info_left">
	                                <span class="span_style">비밀번호<span id="span_essential">*</span></span>
	                            </div>
	                            <div class="col-9 col-md-10 join_info_right">
	                                <input type="password" class="join_info_input" name="memberPw"/>&nbsp;
	                                <span class="span_style hide_text" style="margin-left: 10px;">(영문 대소문자/숫자/특수문자 조합, 10자~16자)</span>
	                            </div>
	                        </div>
	                        <div class="row join_info">
	                            <div class="col-3 col-md-2 join_info_left">
	                                <span class="span_style">비밀번호 확인<span id="span_essential">*</span></span> 
	                            </div>
	                            <div class="col-9 col-md-10 join_info_right">
	                                <input type="password" class="join_info_input" name="memberPwRe"/>
	                                &nbsp;
	                            </div>
	                        </div>
	                        <div class="row join_info">
	                            <div class="col-3 col-md-2 join_info_left">
	                                <span class="span_style">휴대전화<span id="span_essential">*</span></span>&nbsp;
	                            </div>
	                            <div class="col-9 col-md-10 join_info_right">
	                                <select class="join_info_input" name="tel_input_01">
	                                    <option value="010">010</option>
	                                    <option value="011">011</option>
	                                    <option value="016">016</option>
	                                    <option value="017">017</option>
	                                    <option value="018">018</option>
	                                    <option value="019">019</option>
	                                </select> -
	                                <input type="text" class="join_info_input" name="tel_input_02" size="5" maxlength="4" autocomplete="off"/> - 
	                                <input type="text" class="join_info_input" name="tel_input_03" size="5" maxlength="4" autocomplete="off"/>
	                            </div>
	                        </div>
	                        <div class="row join_info">
	                            <div class="col-3 col-md-2 join_info_left">
	                                <span class="span_style">이메일<span id="span_essential">*</span></span>
	                            </div>
	                            <div class="col-9 col-md-10 join_info_right">
	                                <input type="text" class="join_info_input" id="email_input" size="30" name="memberEmail" autocomplete="off"/>
	                                &nbsp;
	                            </div>
	                        </div>
	                    </div>
	                    
	                    <div id="join_page_terms" class="col-12">
	                        <div class="join_terms_content">
	                            <input type="checkbox" id="checkall"/> 이용약관 및 개인정보수집 및 이용에 모두 동의합니다.
	                        </div>
	                        <div class="join_terms_content">
	                            <span class="span_font">(필수) 이용약관 동의</span><br>
	                            <div class="terms_textarea">
	                                제1조 목적<br>
	                                이 약관은 <b>(주)ManGo</b>가 운영하는 공유 플랫폼 <b>SpaceStation</b>에서 제공하는 공유 플랫폼 서비스(이하'서비스'라 한다)를 이용함에 있어 사이버 몰과 이용자의 권리 및 책임사항을 규정함을 목적으로 합니다.
	                            </div>
	                            이용약관에 동의하십니까? <input type="checkbox" name="termscheck01"/> 동의함
	                        </div>
	                        <div class="join_terms_content">
	                            <span class="span_font">(필수) 개인정보 수집 및 이용 동의</span><br>
	                            <div class="terms_textarea">
	                                (개인정보처리방침) <b>주식회사 ManGo</b>는 (이하 '회사'는) 고객님의 개인정보를 중요시하며, "정보통신망 이용촉진 및 정보보호"에 관한 법률을 준수하고 있습니다.  ~~~~~
	                            </div>
	                            개인정보 수집 및 이용에 동의하십니까? <input type="checkbox" name="termscheck02"/> 동의함
	                        </div>
	                        <div class="join_terms_content">
	                            <span class="span_font">(선택) 개인정보 제3자 제공 동의</span><br>
	                            <div class="terms_textarea">
	                                ■ 수집하는 개인정보 항목<br>
	                                회사는 회원가입, 서비스 신청 등등을 위해 아래와 같은 개인정보를 수집하고 있습니다.<br>
	                                ○ 수집항목 : 이름, 로그인ID, 비밀번호, 휴대폰번호, 이메일, 서비스 이용기록, 접속 IP 정보, 결제기록<br>
	                                ○ 개인정보 수집방법 : 홈페이지(회원가입), 서면양식<br>
	                                ■ 개인정보의 수집 및 이용목적<br>
	                                회사는 수집한 개인정보를 다음의 목적을 위해 활용합니다.
	                                ○ 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산 컨텐츠 제공, 요금 결제<br>
	                                ○ 회원 관리<br>
	                                회원제 서비스 이용에 따른 본인확인, 개인 식별, 연령확인, 고지사항 전달<br>
	                                ○ 마케팅 및 광고에 활용<br>
	                                접속 빈도 파악 또는 회원의 서비스 이용에 대한 통계<br>
	                                ■ 개인정보의 보유 및 이용기간<br>
	                                회사는 개인정보 수집 및 이용목적이 달성된 후에는 예외 없이 해당 정보를 지체 없이 파기합니다.
	                            </div>
	                            개인정보 수집 및 이용에 동의하십니까? <input type="checkbox" name="termscheck03"/> 동의함
	                        </div>
	                    </div>
	                    
	                    <input type="submit" id="join_button" value="회원가입" class="btn btn-secondary"/>
	                </div>
                </form>
                <form>
                	<div></div>
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
	    var $span_style = $('.span_style');
	    var $join_page_content_title = $('#join_page_content_title');
	    $(document).ready(function() {
	    	$('#nav_main').addClass('d-none');
	    	$('#nav_sub_main').addClass('d-none');
	    });
	    $('#checkall').click(function() {
	    	if($('#checkall').prop("checked")) {
	    		$('input[name=termscheck01]').prop("checked",true);
	    		$('input[name=termscheck02]').prop("checked",true);
	    		$('input[name=termscheck03]').prop("checked",true);
	    	} else {
	    		$('input[name=termscheck01]').prop("checked",false);
	    		$('input[name=termscheck02]').prop("checked",false);
	    		$('input[name=termscheck03]').prop("checked",false);
	    	}
	    });
	    /* $('#check_find_id').click(function() {
	    	if($('input[name=memberId]').val()=="") {
	    		alert("아이디를 입력해주세요!");
	    		$('input[name=memberId]').focus();
	    	} else if(!(/^(?=.*[a-z])(?=.*[0-9]).{4,10}$/.test($('input[name=memberId]').val()))) {
				alert("아이디는 영문 소문자 또는 숫자 조합으로 4~10자로 입력해주세요");
				$('input[name=memberId]').focus();
			}
	    }); */
	    function checkForm() {
	    	if($('input[name=memberId]').val()=="") {
	    		alert("아이디를 입력해주세요!");
	    		$('input[name=memberId]').focus();
	    	} else if(!(/^(?=.*[a-z])(?=.*[0-9]).{4,10}$/.test($('input[name=memberId]').val()))) {
				alert("아이디는 영문 소문자 또는 숫자 조합으로 4~10자로 입력해주세요");
				$('input[name=memberId]').focus();
			} else {
				window.open("memberJoinIdCheck.jsp?memberId="+document.joinForm.memberId.value,"","width=500, height=300");
			}
	    }
	    
		$(window).innerWidth(function() {
			if ($(this).width() <= 900) {
				$('.hide_text').css('display','none');
			} else {
				$('.hide_text').css('display','inline');
			}
			if ($(this).width() <= 576) {
                $header.addClass('d-none');
                $span_style.css('font-size','11px');
                $('#check_find_id').css('font-size','12px');
            } else {
                $header.removeClass('d-none');
                $span_style.css('font-size','16px');
                $('#check_find_id').css('font-size','16px');
            }
		});
		
        $(window).resize(function() { //창크기 변화 감지
            var windowWidth = $(this).width(); //현재 창의 너비
            var $header = $('#header');
            var $span_style = $('.span_style');
            
            if (windowWidth <= 900) {
				$('.hide_text').css('display','none');
			} else {
				$('.hide_text').css('display','inline');
			}
            if (windowWidth <= 576) {
                $header.addClass('d-none');
                $span_style.css('font-size','11px');
                $('#check_find_id').css('font-size','12px');
            } else {
                $header.removeClass('d-none');
                $span_style.css('font-size','16px');
                $('#check_find_id').css('font-size','16px');
            }
    	});
    </script>
</body>
</html>