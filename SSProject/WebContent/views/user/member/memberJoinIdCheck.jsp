<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ss.mango.user.member.model.vo.Member" %>
<%@ page import="ss.mango.user.member.model.service.MemberService" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<title>Insert title here</title>
	<style>
		.checkIdFormBtn {
			padding: 10px 15px;
			margin: 0px 5px;
		}
		#checkIdForminput {
			border: 1px solid #EBEBEB;
			border-radius: 5px;
			padding: 10px;
		}
		#checkIdForminput:focus {
			outline: none;
		}
		#checkIdFormDumpBtn {
            border: 2px solid #EBEBEB;
            border-radius: 5px;
            margin-left: 10px;
            padding: 7px 20px;
            background-color: white;
		}
		#checkIdFormDumpBtn:hover {
        	cursor: pointer;
        	background-color: grey;
        	color: white;
        }
        #checkIdFormCancelBtn:hover {
        	color: white;
        }
	</style>
</head>
<body>
	<center style="margin-top: 20px;"><h3>중복확인</h3></center>
	<%
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
		
		Member m = new MemberService().dupCheckIdMember(memberId);
	%>
		
	
			<form action="memberJoinIdCheck.jsp" method="post" name="wfr">
				<div class="row" style="margin: 15px 0px;">
					<div class="col-3" style="padding: 20px; background-color: rgba(235,235,235,0.4)">
						<span>아이디</span>
					</div>
					<div class="col-9" style="padding: 10px;">
						<input type="text" name="memberId" value="<%=memberId%>" id="checkIdForminput" size="20" autocomplete="off">
						<input type="submit" value="중복 확인" id="checkIdFormDumpBtn">
					</div>
				</div>
			</form>
			<center>
	<%
		if(m!=null) {
			out.println("<script>alert('이미 존재하는 ID입니다.');</script>");
		} else {
			out.println("<script>alert('사용 가능한 ID입니다.');</script>");
	%>
				<input type="button" class="btn btn-secondary checkIdFormBtn" value="사용하기" onclick="result();">
			
	<%
		}
	%>
				<input type="button" class="btn btn-light checkIdFormBtn" id="checkIdFormCancelBtn" value="돌아가기" onclick="cancel();">
			</center>
	
	<script>
		function result() {
	    	opener.document.joinForm.memberId.value = document.wfr.memberId.value;
	    	
	    	opener.document.joinForm.memberId.readOnly = true;
	    	
	    	window.close();
	    }
		function cancel() {
			window.close();
		}
	</script>
</body>
</html>