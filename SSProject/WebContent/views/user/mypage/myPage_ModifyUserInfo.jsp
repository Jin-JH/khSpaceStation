<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 회원 정보 수정</title>
<style>
	#contents {
		height: 80%;
		padding: 0;
		margin: 0;
	}
	
	#content_right {
		padding: 50px 30px;
		max-width: 1000px;
	}
	
	.h3Style {
		padding: 0;
		width: 100%;
		border-left: 5px solid chocolate;
		margin-bottom: 30px;
	}
	
	#content>.row {
		border-top: 1px solid lightgray;
	}
	
	#content>.row>.col-10 {
		padding: 0;
		border-right: 1px solid lightgray;
	}
	
	#divBorder {
		border-bottom: 1px solid lightgray;
	}
	.modifyUserInfo_Row_Style {
		border-top: 1px solid #EBEBEB;
		border-bottom: 1px solid #EBEBEB;
	}
	.modifyUserInfo_Col_Style {
		padding: 10px;
		background-color: #ebebeb;
		height: 100%;
		line-height: 60px;
		text-align: center;
		font-weight: 500;
	}
	.modifyUserInfo_Input_Style_writeonly {
		margin: 15px 0px;
		height: 50px;
		max-width: 250px;
		border: 1px solid #EBEBEB;
		border-radius: 5px;
		padding: 15px;
	}
	.modifyUserInfo_Input_Style_readonly {
		margin: 15px 0px;
		height: 50px;
		max-width: 250px;
		border: 1px solid #EBEBEB;
		border-radius: 5px;
		padding: 15px;
		background-color: rgba(235,235,235,0.4);
		color: grey;
	}
	.modifyUserInfo_Input_Style_writeonly:hover {
		border: 2px solid chocolate;
	}
	
	.modifyUserInfo_Input_Style_writeonly:focus {
		outline: none;
	}
	.modifyUserInfo_Input_Style_readonly:focus {
		outline: none;
	}
	
	.modifyUserInfo_BtnStyle {
		margin: 20px 10px;
		height: 50px;
		width: 150px;
		background-color: chocolate;
		border: 1px solid chocolate;
		color: white;
		font-weight: 900;
		font-size: 18px;
		border-radius: 10px;
		display: inline-block;
	}
	
	.modifyUserInfo_BtnStyle:hover {
		margin: 20px 10px;
		height: 50px;
		width: 150px;
		background-color: white;
		border: 1px solid chocolate;
		color: chocolate;
		font-weight: 900;
		font-size: 18px;
		border-radius: 10px;
		display: inline-block;
	}
	.mypage_withdraw_popup_pwcheck {
		display: none;
		overflow: hidden;
	    width: 630px;
	    position: fixed;
	    top: 50%;
	    left: 50%;
	    background: #ffffff;
	    border-radius: 5px;
	    transform: translate(-50%,-50%);
	    z-index: 999;
	}
	.mypage_withdraw_popup_pwcheck_bg {
		display: none;
		width: 100%;
		height: 1200px;
		position: fixed;
		top: 0;
		left: 0;
		background: #000000;
		opacity: 0.3;
		z-index: 998;
	}
	.withdrawUserInfo_Row_Style {
		border-top: 1px solid #EBEBEB;
		border-bottom: 1px solid #EBEBEB;
	}
	.withdrawUserInfo_Col_Style {
		padding: 10px;
		background-color: #ebebeb;
		height: 100%;
		line-height: 60px;
		text-align: center;
		font-weight: 500;
	}
	.withdrawUserInfo_Input_Style_writeonly {
		margin: 15px 0px;
		height: 50px;
		max-width: 250px;
		border: 1px solid #EBEBEB;
		border-radius: 5px;
		padding: 15px;
	}
	.withdrawUserInfo_Input_Style_writeonly:hover {
		border: 2px solid chocolate;
	}
	
	.withdrawUserInfo_Input_Style_writeonly:focus {
		outline: none;
	}
	.withdrawUserInfo_BtnStyle {
		margin-top: 30px;
		background-color: white;
		border: 1px solid #EBEBEB; 
		padding: 12px 30px;
		border-radius: 7px;
		font-size: 14px;
	}
	
	.withdrawUserInfo_BtnStyle:hover {
		background-color: grey;
		color: white;
	}
	.mypage_withdraw_popup_pwcheck_content_box {
	}
</style>
</head>
<body>
	<div class="wrapper">
		<div id="header">
			<%@ include file="/views/user/common/header.jsp"%>
		</div>
	<script>
		$(function(){
			$('#modifyForm').submit(function() {
				var $password = $('input[name=password]');
				var $passwordRe = $('input[name=passwordRe]');
				var $tel_01 = $('input[name=tel_01]');
				var $tel_02 = $('input[name=tel_02]');
				var $tel_03 = $('input[name=tel_03]');
				var $email = $('input[name=email]');
				
				if(!(/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{10,16}$/.test($password.val()))) {
					alert("비밀번호는 영문,숫자,특수문자 조합으로 10~16자로 입력해주세요");
					$password.focus();
					return false;
				} else if(!($password.val()==$passwordRe.val())) {
					alert("비밀번호와 비밀번호 확인이 서로 다릅니다");
					$passwordRe.focus();
					return false;
				} else if(($tel_01.val().length)!=3) {
					alert("휴대폰번호 앞자리 3자리를 입력해주세요.");
					$tel_01.focus();
					return false;
				} else if(($tel_02.val().length)!=4) {
					alert("휴대폰번호 가운데 4자리를 입력해주세요.");
					$tel_02.focus();
					return false;
				} else if(($tel_03.val().length)!=4) {
					alert("휴대폰번호 끝자리 4자리를 입력해주세요.");
					$tel_03.focus();
					return false;
				} else if(!(/^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/.test($email.val()))) {
					alert("올바른 이메일 형식을 입력해주세요.");
					$email.focus();
					return false;
				}
				return true;
			});
		});
	</script>
		<div class="main-content" id="container">
			<div id="contents" class="row">
				<div id="contents_left" class="col-md-3">
					<%@ include file="/views/user/common/myPageSideBar.jsp"%>
				</div>
				<div id="content_right" class="col-md-9">
					<form action="/MemberModifyUser.ss" method="post" id="modifyForm">
						<div class="row">
							<h3 class="h3Style col-12">
								<span class="contactTitle">회원정보수정</span>
							</h3>
						</div>
						<div class="row modifyUserInfo_Row_Style">
							<div class="col-3 col-md-2 modifyUserInfo_Col_Style">
								<span class="modify_input_title">이름</span>
							</div>
							<div class="col-9 col-md-10 modifyUserInfo_Col_Style_right">
								<input type="text" class="modifyUserInfo_Input_Style_readonly" value="<%= m.getMemberName() %>" name="userName" readonly/>
							</div>
						</div>
			
						<div class="row modifyUserInfo_Row_Style">
							<div class="col-3 col-md-2 modifyUserInfo_Col_Style">
								<span class="modify_input_title">아이디</span>
							</div>
							<div class="col-9 col-md-10 modifyUserInfo_Col_Style_right">
								<input type="text" class="modifyUserInfo_Input_Style_readonly" value="<%= m.getMemberId() %>" name="userId" readonly/>
							</div>
						</div>
			
						<div class="row modifyUserInfo_Row_Style">
							<div class="col-3 col-md-2 modifyUserInfo_Col_Style">
								<span class="modify_input_title">비밀번호</span>
							</div>
							<div class="col-9 col-md-10 modifyUserInfo_Col_Style_right">
								<input type="password" class="modifyUserInfo_Input_Style_writeonly" name="password" placeholder="비밀번호를 입력하세요"/>
								<span id="phone_info">(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 10자 ~ 16자)</span>
							</div>
						</div>
			
						<div class="row modifyUserInfo_Row_Style">
							<div class="col-3 col-md-2 modifyUserInfo_Col_Style">
								<span class="modify_input_title">비밀번호 확인</span>
							</div>
							<div class="col-9 col-md-10 modifyUserInfo_Col_Style_right">
								<input type="password" class="modifyUserInfo_Input_Style_writeonly" name="passwordRe" placeholder="비밀번호를 확인하세요" />
							</div>
						</div>
						
						<div id="divBorder" class="row modifyUserInfo_Row_Style">
							<div class="col-3 col-md-2 modifyUserInfo_Col_Style">
								<span class="modify_input_title">휴대전화</span>
							</div>
							<div class="col-9 col-md-10 modifyUserInfo_Col_Style_right">
								<script>
								<%
									String tel_01 = m.getMemberPhone().substring(0,3);
									String tel_02 = m.getMemberPhone().substring(3,7);
									String tel_03 = m.getMemberPhone().substring(7,11);
								%>
								</script>
								<input type="text" class="modifyUserInfo_Input_Style_writeonly" value="<%= tel_01 %>" name="tel_01" size="3" maxlength="3" autocomplete="off"/>&nbsp;-
								<input type="text" class="modifyUserInfo_Input_Style_writeonly" value="<%= tel_02 %>" name="tel_02" size="3" maxlength="4" autocomplete="off"/>&nbsp;-
								<input type="text" class="modifyUserInfo_Input_Style_writeonly" value="<%= tel_03 %>" name="tel_03" size="3" maxlength="4" autocomplete="off"/>
							</div>
						</div>
						
						<div class="row modifyUserInfo_Row_Style">
							<div class="col-3 col-md-2 modifyUserInfo_Col_Style">
								<span class="modify_input_title">이메일</span>
							</div>
							<div class="col-9 col-md-10 modifyUserInfo_Col_Style_right">
								<input type="text" class="modifyUserInfo_Input_Style_writeonly" value="<%= m.getMemberEmail() %>" name="email" placeholder="이메일을 입력하세요" autocomplete="off"/>
							</div>
						</div>
						
						<center>
							<input type="submit" class="modifyUserInfo_BtnStyle" value="회원정보수정" />
							<input type="button" class="modifyUserInfo_BtnStyle" id="withdraw_Btn_PwCheck" value="회원탈퇴">
						</center>
					</form>
				</div>
				<div class="mypage_withdraw_popup_pwcheck">
					<div class="mypage_withdraw_popup_pwcheck_content_box" style="padding:40px 30px;">
						<form action="/MemberWithdraw.ss" method="post" id="member_Withdraw_Form">
							<h3 class="h3Style col-12">
								<span class="contactTitle">회원탈퇴</span>
							</h3>
							<div class="row withdrawUserInfo_Row_Style">
								<div class="col-4 col-md-3 m-0 withdrawUserInfo_Col_Style">
									<span class="modify_input_title">비밀번호</span>
								</div>
								<div class="col-8 col-md-9 m-0 withdrawUserInfo_Col_Style_right">
									<input type="password" class="withdrawUserInfo_Input_Style_writeonly" name="withdrawPw" placeholder="비밀번호를 입력하세요"/>
								</div>
							</div>
				
							<div class="row withdrawUserInfo_Row_Style">
								<div class="col-4 col-md-3 m-0 withdrawUserInfo_Col_Style">
									<span class="modify_input_title">비밀번호 확인</span>
								</div>
								<div class="col-8 col-md-9 m-0 withdrawUserInfo_Col_Style_right">
									<input type="password" class="withdrawUserInfo_Input_Style_writeonly" name="withdrawPwRe" placeholder="비밀번호를 확인하세요" />
								</div>
							</div>
							<center>
								<button type="submit" class="withdrawUserInfo_BtnStyle" id="withdraw_btn">회원탈퇴</button>
							</center>
						</form>
					</div>
				</div>
				<div class="mypage_withdraw_popup_pwcheck_bg"></div>
			</div>
		</div>
		<div id="footer">
			<%@ include file="/views/user/common/footer.jsp"%>
		</div>
	</div>
	
	<script>
		$(".aStyle").eq(1).removeClass('aHover');
		$(".spanLi").eq(1).addClass('ClickStyle')
	</script>
	<!-- 탈퇴로직 -->
	<script>
	</script>
	
	<!-- 반응형 크기 -->
   	<script>
		var windowWidth;
		// 현재 창 크기
		$(window).width(function() {
			if($(this).width() <= 1200) {
				$('.modify_input_title').css('font-size','13px');
				$('.modifyUserInfo_Input_Style').css('font-size','13px');
				$('#phone_info').css('display','none');
				$('.modifyUserInfo_Col_Style').removeClass('col-md-2');
				$('.modifyUserInfo_Col_Style_right').removeClass('col-md-10');
				$('.modifyUserInfo_Input_Style').css('width','100%');
			} else {
				$('.modify_input_title').css('font-size','16px');
				$('.modifyUserInfo_Input_Style').css('font-size','16px');
				$('#phone_info').css('display','inline');
				$('.modifyUserInfo_Col_Style').addClass('col-md-2');
				$('.modifyUserInfo_Col_Style_right').addClass('col-md-10');
				$('.modifyUserInfo_Input_Style').removeAttr('style','width');
			}
			if($(this).width() <= 660) {
				$('.mypage_withdraw_popup_pwcheck').css('width','420px');
			} else {
				$('.mypage_withdraw_popup_pwcheck').css('width','630px');
			}
		});
		
		//윈도우창 사이즈가 조절되면 반응
		$(window).resize(function() {
			windowWidth = $(this).width();
			
			if(windowWidth <= 1200) {
				$('.modify_input_title').css('font-size','13px');
				$('.modifyUserInfo_Input_Style').css('font-size','13px');
				$('#phone_info').css('display','none');
				$('.modifyUserInfo_Col_Style').removeClass('col-md-2');
				$('.modifyUserInfo_Col_Style_right').removeClass('col-md-10');
				$('.modifyUserInfo_Input_Style').css('width','100%');
			} else {
				$('.modify_input_title').css('font-size','16px');
				$('.modifyUserInfo_Input_Style').css('font-size','16px');
				$('#phone_info').css('display','inline');
				$('.modifyUserInfo_Col_Style').addClass('col-md-2');
				$('.modifyUserInfo_Col_Style_right').addClass('col-md-10');
				$('.modifyUserInfo_Input_Style').removeAttr('style','width');
			}
			if(windowWidth <= 660) {
				$('.mypage_withdraw_popup_pwcheck').css('width','420px');
			} else {
				$('.mypage_withdraw_popup_pwcheck').css('width','630px');
			}
		});
		
		//회원정보 수정에서 탈퇴하기 버튼을 클릭했을때
		$('#withdraw_Btn_PwCheck').click(function() {
			/* $('.mypage_withdraw_popup_pwcheck').css('display','inline');
			$('.mypage_withdraw_popup_pwcheck_bg').css('display','inline'); */
			$('.mypage_withdraw_popup_pwcheck').fadeIn(200);
			$('.mypage_withdraw_popup_pwcheck_bg').fadeIn(200);
		});
		$('.mypage_withdraw_popup_pwcheck_bg').click(function() {
			/* $('.mypage_withdraw_popup_pwcheck').css('display','none');
			$('.mypage_withdraw_popup_pwcheck_bg').css('display','none'); */
			$('.mypage_withdraw_popup_pwcheck').fadeOut(200);
			$('.mypage_withdraw_popup_pwcheck_bg').fadeOut(200);
		});
		
		//탈퇴하기 전 비밀번호 유효성 검사
		$('#member_Withdraw_Form').submit(function() {
			var result;
			
			if($('input[name=withdrawPw]').val()=="") {
				alert("비밀번호를 입력해주세요.");
				$('input[name=withdrawPw]').focus();
				return false;
			} else if(!($('input[name=withdrawPw]').val()==$('input[name=withdrawPwRe]').val())) {
	 			alert("비밀번호와 비밀번호 확인이 서로 다릅니다");
	 			$('input[name=withdrawPwRe]').focus();
	 			return false;
	 		} else {
	 			result = window.confirm("정말로 탈퇴하시겠습니까?");
	 			
	 			return result;
	 		}
		});
	</script>
</body>
</html>