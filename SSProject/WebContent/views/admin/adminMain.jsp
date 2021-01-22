<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ss.mango.admin.model.vo.Admin" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우주정거장-관리자</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<style>
	/*추가*/
	#content .content {
		margin: 0 auto;
	}
	
	/*삭제*/
	.content { /* adminMain만 */
		padding: 0;
		margin: 0;/*margin: 0 auto;*/
		
		width: 100%;
		/*height: 45%;*/
	}
	.content div table {
	    padding: 0;
	    margin: 50px auto;
	    width: 95%;
	    background-color: white;
	    border: 1px solid rgba(211, 211, 211, 0.8);
	    font-weight: 900;
	    /* table-layout: fixed;
	    min-width: 530px;*/
	}
	
	.content table tr th {
	    padding: 0 15px;
	    margin: 0;
	    width: 100%;
	    height: 50px;
	    background-color: #FF9600;
	    color: white;
	}
	
	.content table tr td {
	    text-align: center;
	    font-size: 15px;
	}
	
	#waitList tr td {
	    height: 150px;
	    width: 33%;
	    border: 1px solid rgba(211, 211, 211, 0.8);
	}
	
	#reserveTop {
	    padding-bottom: 0;
	    margin-bottom: 0;
	}
	
	#reserveBottom {
	    padding-top: 0;
	    margin-top: 0;
	}
	
	#reserveTop tr td {
	    height: 40px;
	    border-right: 1px solid rgba(211, 211, 211, 0.8);
	}
	
	#reserveBottom tr td {
	    height: 50px;
	    width: 25%;
	    border: 1px solid rgba(211, 211, 211, 0.8);
	}
	
	.colorGray {
	    height: 30px;
	    background-color: rgba(211, 211, 211, 0.3);
	}
	
	.rowRight {
	    text-indent: 50%;
	}
	
	.tableType tr td {
	    height: 40px;
	    width: 25%;
	    border-right: 1px solid rgba(211, 211, 211, 0.8);
	}
	
	.number {
	    height: 150px;
	    width: 25%;
	    border: 1px solid rgba(211, 211, 211, 0.8);
	}
	
	/* 추가 */
	#waitList, .reserve, .tableType{
		box-shadow: 0px 3px 10px 1px lightgray; /*그림자 추가*/
	}
</style>

<body>
<%@ include file = "./adminForm/adminStyle.jsp" %>
<div id="wrapper">
	<%@ include file ="./adminForm/aManageSidebar.jsp" %>
	<!--navSNB-->
	
    <div id="fluid" class="container-fluid">
		<%@ include file = "./adminForm/header.jsp" %>
        <!-- header -->
        
        <div class="row content">
                <div class="col-xl-6">
                    <table id="waitList">
                        <tr>
                            <th colspan="3" class="tableName">승인 대기 목록</th>
                        </tr>
                        <tr>
                            <td>사용자 승인 대기<br><br>...</td>
                            <td>사업자 승인 대기<br><br>준비 중 입니다</td>
                            <td>총 승인 대기<br><br>...</td>
                        </tr>
                    </table>
                </div>
                <div class="col-xl-6">
                    <table class="reserve" id="reserveTop">
                        <tr>
                            <th colspan="6" class="tableName">매출 현황</th>
                        </tr>
                        
                    </table>
                    <table class="reserve" id="reserveBottom">
                    	<tr>
                    		<td colspan=6><span id="clock" style="border:none;"></span></td>
                    	</tr>
                        <tr>
                            <td class="colorGray">오늘 매출액</td>
                            <td class="rowRight">${resultArr[0] } 만</td>
                            <td class="colorGray">올해 매출액</td>
                            <td class="rowRight">${resultArr[2] } 만</td>
                        </tr>
                        <tr>
                            <td class="colorGray"> 이달 매출액</td>
                            <td class="rowRight">${resultArr[1] } 만</td>
                            <td class="colorGray">총 매출액</td>
                            <td class="rowRight">${resultArr[3] } 만</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="row content">
                <div class="col-xl-6">
                    <table class="tableType">
                        <tr>
                            <th colspan="4" class="tableName">사용자 현황</th>
                        </tr>
                        <tr class="number colorGray">
                            <td>신규 사용자<br><br>${todayUser } 명</td>
                            <td>전체 사용자<br><br>${allUser } 명</td>
                            <td>오늘 탈퇴 사용자<br><br>${todayEndUser } 명</td>
                            <td>총 탈퇴 사용자<br><br>${allEndUser } 명</td>
                        </tr>
                    </table>
                </div>
                <div class="col-xl-6">
                    <table class="tableType">
                        <tr>
                            <th colspan="4" class="tableName">사업자 현황</th>
                        </tr>
                        <tr class="number colorGray">
                            <td>신규 사업자<br><br>${todayPartner } 명</td>
                            <td>전체 사업자<br><br>${allPartner } 명</td>
                            <td>오늘 탈퇴 사업자<br><br>${todayEndPartner } 명</td>
                            <td>총 탈퇴 사업자<br><br>${allEndPartner } 명</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div><!--fluid-->
        
</div><!--wrapper-->

<script>
	//$('.navGNB').eq(0).addClass('mangoBgcolor'); //선택한 탭 색칠
	$(".accordian").hide(); //ready() 함수로 처리하면 이쁘지가 않다.
</script>
<script language="JavaScript">
	function printTime() {
		var clock = document.getElementById("clock");
		var now = new Date();
		
		clock.innerHTML = now.getFullYear() + "년 " +
		(now.getMonth()+1) + "월 " +
		now.getDate() + "일 " +
		now.getHours() + "시 " +
		now.getMinutes() + "분 " +
		now.getSeconds() + "초";
		
		setTimeout("printTime()", 1000);
	}
	
	window.onload = function() {
		printTime();
	};
</script>

</body></html>