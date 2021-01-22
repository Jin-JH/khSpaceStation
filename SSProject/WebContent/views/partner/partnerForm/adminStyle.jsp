<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<style>
    * {
        /*box-sizing: border-box;
        border: 1px solid black;*/
    }

    body,html {
        height: 100%;
    }

    #wrapper {
        height: 100%;
        display: flex;
    }

    #navSNB {
        background: linear-gradient(to bottom, #a535ff, #9614ff);
        color: white;
        overflow: hidden;
    }

    .sideStyle-wide {
        min-width: 260px;
        padding: 0 20px;
        font-weight: 900;
    }

    .sideStyle-slim {
        min-width: 130px;
        padding: 0 5px;
        font-weight: 900;
    }

    #fluid {
        overflow: auto;
    }

    .ulStyle {
        padding: 0px;
        margin: 0 0 60px 0;
        list-style: none;
    }
    .liStyle {
        text-align: center;
        padding: 20px 0px;
        margin: 0px;
    }

    .liStyle-white {
        border-top: 1px solid white;
        border-bottom: 1px solid white;
        margin-bottom: 20px;
    }
    .liStyle>a {
        width: 100%;
        height: 100%;
        color: white;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .liStyle>a:hover {
        text-decoration: none;
    }
    .logo {
        height: 100px;
        font-size: 23px;
    }
    .logout { /*추가 ver5*/
        width: 40%;
        margin: 0 auto;
        font-size: 19px;
        font-weight: 800;
    }
    .category {
        width: 70%;
        font-size: 17px;
    }
    .icon {
        width: 15%;
    }
    #toggle {
        cursor: pointer;
    }

    #header {
        height: 100px;
        border-bottom: 1px solid lightgray;
    }

    .house {
        color: #9614EF;
        border: 2px solid #9614EF;
        border-radius: 7px;
        float: left;
        margin-top: 30px;
        margin-left: 48px;
    }
    .house:hover {
        color: #9614EF;
    }
    .navGNB {
        height: 40%;
        line-height: 40px;
        text-align: center;
        font-size: 22px;
        font-weight: 800;
        margin-top: 60px;
        margin-right: 7.5px;
        padding: 0px;
        background-color: lightgray;
        border-top-left-radius: 15px;
        border-top-right-radius: 15px;
    }
    .navGNB>a {
        display: block;
        width: 100%;
        height: 100%;
        color: white;
        text-decoration: none;
    }
    .accList {
        position: relative;
    }
    .accordian {
        padding: 10px 0;
        margin-top: 20px;
        background-color: white;
        text-align: center;
        border-radius: 15px;
        font-size: 15px;
        cursor: default;
    }
    .accordian a {
        color: black;
        text-decoration-line: none;
    }

    #acc-2 {
        height: 100px;
        line-height: 40px;
    }
    #acc-3 {
        height: 149px;
        line-height: 43px;
    }
    .hoverColor{
        opacity: 0.8;
    }
    .hoverColor:hover{
        opacity: 1.0;
    }
    
	.mangoBgcolor{ /* 탭 색깔칠하기 위한 클래스 */
		background-color: #9614EF;
	}
	
	/* ---------- 2020.12.04 추가---------- */
	/*.content{
    	부트스트랩 row클래스안에 col클래스는 내용물의 높이만큼 height를 자동으로 잡아준다.
    	div는 블럭요소이다. 블럭요소의 width 기본값은 100%이다.
 		width: 100%;
		height: 90%
    }*/

	.bgColor1 {
	    background-color: rgba(211, 211, 211, 0.1);
	}
	
	.bgColor2, table * {
	    background-color: white;
	    border: 1px solid lightgray;
	    padding: 10px;
	}
	
	.padding1 {
	    padding: 15px;
	    margin: 0;
	}
	
	.padding2 {
	    padding: 3px;
	    margin: 0;
	    height: 30px;
	    border-radius: 3px;
	}
	 
	#whiteBoard { 
	    border-radius: 10px;
	    box-shadow: 0px 3px 10px 1px lightgray; /*그림자 추가*/
	    margin-bottom: 20px;
	}
	
	#inquiry {
	    font-weight: 800;
	    font-size: 20px;
	    color: #9614EF;
	}
	
	#selectAlign{
	    text-align: right;
	}
	
	#searchBtn { 
	    background-color: #9614EF;
	    color: white;
	    width: 30px;
	    line-height: 24px;
	    text-align: center;
	    border: 1px solid #9614EF;
	}
	
	.tableStyle { 
	    width: 100%;
	    margin: 10px 0;
	    text-align: center;
	}
</style>

</body>
</html>