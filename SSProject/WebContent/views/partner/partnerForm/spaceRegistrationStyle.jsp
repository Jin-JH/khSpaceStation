<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<style>
form {
	margin: 0 auto;
	padding: 20px 70px;
}

.content-body>div {
	border: 1px solid #9614EF;
	font-weight: bold;
}


.a-2 {
	border-bottom: 1px solid #9614EF;
	padding: 10px 10px;
	font-size: 22px;
	margin: 20px 0 20px 0;
}

.a-body {
	/* padding: 20px 20px;
           background-color: #fafafa;*/
	
}

#inp {
	margin: 10px 0px 10px 0px;
	width: 100%;
}

#inp3 {
	margin: 3px 0px 3px 0px;
	width: 100%;
}

#subString {
	color: grey;
}

.b {
	margin: 50px 0 50px 0;
	padding: 10px 0px;
	background-color: #fafafa;
}

.c {
	margin: 50px 0 50px 0;
}

#three-brother {
	width: 100%;
	padding: 0;
	margin: 10px 0px 10px 0px;
}

#three-brother>button {
	width: 30px;
	height: 40px;
	padding: 0;
	margin: 0;
	float: left;
	border: 1px solid lightgray;
	
}

#three-brother>input {
	width: 70%;
	height: 40px;
	padding: 0;
	margin: 0;
	float: left;
	text-align: center;
}

#email-second {
	padding: 0px 0px;
}

#email-second input {
	margin: 10px 0px 10px 15px;
	width: 80%;
}

.operate-td {
	float: left;
	width: 20%;
	margin: 0px auto;
	text-align: center;
	height: 100%;
}

.operate-day {
	float: left;
	width: 10%;
	margin: 0px;
	text-align: center;
}

.operate-td span {
	float: left;
	width: 10%;
	margin: 0px 10px 0px 0px;
}

.operate-td>select {
	float: left;
	width: 80%;
}

.content-body label {
	color: orange;
}


.option {
	position: absolute;
	top: 120px;
	right: 90px;
	font-size: 15px;
	color: #656565;
	line-height: 11px;
}

.ico_required, .txt_required {
	color: orange;
}

h3 {
	display: block;
	font-size: 18px;
	font-weight: bold;
	margin-block-start: 15px;
	margin-block-end: 15px;
	/*margin-top, -bottom과 같은 개념*/
	margin-inline-start: 0px;
	margin-inline-end: 0px;
	/*margin-left, -right과 같은 개념*/
	color : #595959;
}

form hr {
	border: 1px solid #bf78f0;
}

input[type=text] {
	display: inline-block;
	position: relative;
	width: 100%;
	border: 1px solid #e0e0e0;
	height: 40px;
	padding: 2px 10px;
	line-height: 1.5;
}

textarea {
	display: inline-block;
	position: relative;
	width: 100%;
	border: 1px solid #e0e0e0;
	height: 110px;
	resize: none;
	padding: 2px 10px;
	vertical-align: top;
}

.box_form {
	position: relative;
	margin-top: 50px;
}

.box_form .subTit {
	font-size: 18px;
	font-weight: 700;
	color : #595959;
}

/* 공간유형 더 보강하기 */
.subSpaceTypeCkecklist li {
	width: 33.3%;
	text-align: left;
	border-top: 0;
	display: table;
	table-layout: fixed;
	height: 42px;
	vertical-align: middle;
	position: relative;
	float: left;
}

ul li {
	list-style: none;
}

.file .inner {
	padding: 7px 8px;
	min-height: 35px;
	background-color: #fff;
	border: 1px solid #e0e0e0;
	font-size: 14px;
	line-height: 17px;
	color: #b2b2b2;
	width: 80%;
}

.file .inner.inner_img {
	min-height: 60px;
}

.file .thum_attached {
	position: relative;
	width: 61px;
	height: 61px;
	margin: 1px;
	vertical-align: top;
}

.checkbox_type_add {
	background-color: #6d56e0;
	border: 1px solid #5940ac;
}

.btn_box .btn {
	display: inline-block;
	width: 74px;
	height: 40px;
	background-color: #9614EF;
	border: 0;
	color: #fff;
	text-align: center;
	font-size: 12px;
	line-height: 24px;
	border-radius: 0;
}

.btn_box {
	width: 74px;
	line-height: 40px;
	position: absolute;
	top: 30px;
	right: 0;
	margin-left: 10px;
	overflow: hidden;
}

/*.btn {
    display: inline-block;
    text-align: center;
    color: #fff;
    border-radius: 4px;
    margin-left: 10px;
}*/
.pull_right {
	float: left;
}

dd {
	display: block;
	margin-inline-start: 40px;
}

.box_setting {
	position: relative;
	width: 177px;
	border: 1px solid #ebebeb;
	background: #fff;
	text-align: center;
}

.box_setting .input {
	display: inline-block;
}

.box_setting input[type=number], .box_setting input[type=tel],
	.box_setting input[type=text] {
	width: 38px;
	height: 30px;
	padding: 0;
	border: 0;
	text-align: right;
	font-size: 12px;
	line-height: 33px;
}

.box_setting .txt_unit {
	display: inline-block;
	margin-top: 2px;
	font-size: 12px;
	color: #000;
}

.box_setting .btn_minus {
	position: absolute;
	top: 0;
	left: 0;
	border-right: 1px solid #ebebeb;
}

.ico_minus {
	background-position: -32px -243px;
	width: 30px;
	height: 30px;
}

.ico_plus {
	background-position: -64px -243px;
	width: 30px;
	height: 30px;
}

.box_setting .btn_plus {
	position: absolute;
	top: 0;
	right: 0;
	border-left: 1px solid #ebebeb;
}

a {
	text-decoration: none;
}

ol, ul {
	list-style: none;
}

.facility_wrap .inner {
	width: 100%;
	height: 200px;
	padding: 0;
}

.facility_wrap .inner li {
	float: left;
	text-align: center;
	width: 12.5%;
	height: 100%;
}

/*라벨구역*/
.facility_wrap input[type=checkbox]+label {
    display: inline-block;
    width: 90%;
    height: 90%;
    border: 1px solid #e0e0e0;
    /*background: #ebebeb;*/
    background-color: gray;
    margin-right: 5px;
}

/*라벨아이콘*/
.facility_wrap input[type=checkbox]+label i{
    width: 100%;
    height: 70%;
    font-size: 85px;
    padding-top: 21px;
    color: white;
}

/*라벨글자*/
.facility_wrap input[type=checkbox]+label span {
    display: block;
    width: 100%;
    padding: 15px;
    font-size: 17px;
    font-weight: 600;
    color: #000;
    line-height: 13px;
    text-align: center;
    /*border: 1px solid gray;*/
    background-color: white;
}

.facility_wrap input[type=checkbox]+label:hover {
	cursor: pointer;
}

</style>

</body>
</html>