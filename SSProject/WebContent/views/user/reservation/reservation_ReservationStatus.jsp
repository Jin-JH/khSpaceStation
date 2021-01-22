<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ss.mango.user.space.model.vo.Reservation" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="stylesheet" href="/JS/air-datepicker/dist/css/datepicker.min.css">
<script src="/JS/jquery-3.1.1.min.js"></script>
<script src="/JS/air-datepicker/dist/js/datepicker.min.js"></script>
<script src="/JS/air-datepicker/dist/js/i18n/datepicker.ko.js"></script>
<style>
	.insertPlaceTitleStyle {
		padding: 0;
		width: 100%;
		border-left: 5px solid gray;
		margin-bottom: 30px;
	}
	.insertPlaceTitleStyle>span {
		width: 100%;
		padding: 0 10px;
		margin: 50px 0;
		font-weight: bold;
	}
	thead>tr>th {
		width: 30px;
		height: 30px;
		text-align: center;
	}
	tbody>tr>td {
		width: 30px;
		height: 30px;
	}
	#closeBtn {
		margin-top: 50px;
		padding: 10px 30px;
		background-color: gray;
		border: 2px solid gray;
		border-radius: 5px;
		color: white;
	}
	#closeBtn:hover {
		background-color: white;
		color: gray;
	}
</style>
</head>
<body>
	<%
		ArrayList<Reservation> list = (ArrayList<Reservation>)request.getAttribute("list");
	%>
	<div style="margin: 30px;">
		<div style="margin-top: 30px;">
			<div>
				<h4 class="insertPlaceTitleStyle" style="margin-bottom: 10px;">
					<span>회의실 예약 현황</span>
				</h4>
				<p style="margin: 20px 0px;">날짜를 선택하여 예약 현황을 확인하세요.</p>
			</div>
		</div>
		<div class="col-12 m-0 p-0 reservation_table_box" style="margin-top: 30px">
			<div class="reservation_table">
				<table border="1px">
					<thead>
						<tr>
							<th>06</th>
							<th>07</th>
							<th>08</th>
							<th>09</th>
							<th>10</th>
							<th>11</th>
							<th>12</th>
							<th>13</th>
							<th>14</th>
							<th>15</th>
							<th>16</th>
							<th>17</th>
							<th>18</th>
							<th>19</th>
							<th>20</th>
							<th>21</th>
							<th>22</th>
						</tr>
					</thead>
					<tbody id="trgt">
						<tr>
							<td id="6"></td>
							<td id="7"></td>
							<td id="8"></td>
							<td id="9"></td>
							<td id="10"></td>
							<td id="11"></td>
							<td id="12"></td>
							<td id="13"></td>
							<td id="14"></td>
							<td id="15"></td>
							<td id="16"></td>
							<td id="17"></td>
							<td id="18"></td>
							<td id="19"></td>
							<td id="20"></td>
							<td id="21"></td>
							<td id="22"></td>
						</tr>
					</tbody>
				</table>
				<center>
					<button type="button" id="closeBtn">나가기</button>
				</center>
			</div>
		</div>
	</div>
<script>
	$(document).ready(function() {
		
		<%
		for(int i = 0; i < list.size(); i++) {
		%>
		var startTime = <%=list.get(i).getResStartTime()%>;
		var endTime = <%=list.get(i).getResEndTime()%>;
			for(var j=0; j<(endTime-startTime); j++){
				$("#"+(startTime+j)).css("background-color", "yellow");
			}
		<% }%>
	});
	$('#closeBtn').click(function(){
		window.close();
	});
</script>	
</body>
</html>