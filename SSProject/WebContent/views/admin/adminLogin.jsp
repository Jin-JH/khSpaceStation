<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ss.mango.admin.model.vo.Admin" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<style>
	* {
		/*border: 1px solid black;
		box-sizing: border-box;*/
	}

	body, html {
		padding: 0;
        margin: 0;
        height: 100%;
        background-color: whitesmoke;
	}

    #form {
		margin: auto;
        padding: 50px 0;
        width: 500px;
        height: 500px;
        text-align: center;
        border: 1px solid lightgray;
        background-color: white;
        vertical-align: middle;
        position: relative;
        top: 50%;
        transform: translateY(-50%);
        border-radius: 8px;
	}

	#form p {
		margin: 10px auto;
        padding: 0;
        width: 400px;
	}

	#form p:nth-child(1) {
		font-size: 50px;
		font-weight: 800;
	}

	#form p:nth-child(2) {
		font-size: 15px;
		font-weight: 700;
		color: gray;
	}

	#form p:nth-child(3) {
		padding-bottom: 50px;
		font-size: 13px;
		font-weight: 700;
		color: darkgray;
	}

	.icon {
		width: 50px;
		height: 50px;
		line-height: 50px;
		color: lightgray;
		border: 1px solid lightgray;
	}

	.in-type {
        margin: 5px 0;
        padding: 0;
		width: 350px;
 		height: 50px;
		font-weight: 600;
		text-indent: 20px;
		border: 1px solid lightgray;
	}

	.log-type {
		margin: 20px;
		padding: 0px;
		width: 400px;
		height: 50px;
		font-weight: 900;
		border: 1px solid #FF9614;
		background-color: #FF9614;
		color: white;
		font-size: 20px;
	}
	
	/* 추가 */
	.in-type::placeholder{
		opacity: 0.8;
	}
	.in-type:focus{
		outline: 3px solid #FF9614;
	}
	.log-type:focus{
		outline: none;
	}
	.log-type:hover{
		background-color: #FF9000;
		border-color: #FF9000;
	}
</style>

<body>
<%
	Admin a = (Admin)session.getAttribute("admin");
%>
<% if(a!=null){ %>
    <script>
		location.replace("/adminMain.ss");
	</script>
<% }else{ %>
	<form id="form" action="/adminLogin.ss" method="post">
        <p>ADMIN LOGIN</p>
        <p>관리자 아이디로 로그인 해주세요.</p>
        <p>관리자 페이지로 접속하기 위한 페이지입니다.</p>
        <i class="fas fa-user fa-lg icon"></i>
        <input type="text" name="adminId" class="in-type" placeholder="ID"/><br />
        <i class="fas fa-unlock-alt fa-lg icon"></i>
        <input type="password" name="adminPw" class="in-type" placeholder="PASSWORD"/><br />
        <input class="log-type" type="submit" value="로그인"/>
    </form>
<% } %>
</body></html>