<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<style>
	.selYear{
		float: right;
		font-size: 17px;
		margin-right: 5px;
	}
</style>
<body>
	<div id="whiteBoard" class="col-12 padding1 bgColor2 d-none d-xl-block">
		<div id="inquiry" class="padding1">사업자수 통계
			<select class="selYear" class="padding2 bgColor2">
				<option style="display:none;">년도 선택</option>
 				<option></option>
       	        <option></option>
       	        <option></option>
	        </select>
		</div>
		<hr>
    	<div id="curve_chart" style="width: 100%; height: 500px;"></div>
    </div>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);

	var cdata;
	var options;
	var chart;
	
	function drawChart() {
		cdata = google.visualization.arrayToDataTable([
		  	['분기', '가입한 사업자', '탈퇴한 사업자'],
		  	['1분기',  ${joinQuarter[0].quarterCount }, ${endQuarter[0].quarterCount }],
		  	['2분기',  ${joinQuarter[1].quarterCount }, ${endQuarter[1].quarterCount }],
		  	['3분기',  ${joinQuarter[2].quarterCount }, ${endQuarter[2].quarterCount }],
		  	['4분기',  ${joinQuarter[3].quarterCount }, ${endQuarter[3].quarterCount }]
		]);
		
		options = {
		  	title: '사업자 수 현황  (단위 : 명)',
		  	curveType: 'function',
		  	legend: { position: 'bottom' },
		  	colors: ['blue', 'skyblue'], //사용자와 사업자 색상 정하기
		};
		
		chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
		chart.draw(cdata, options);
	}

$(function(){
	var date = new Date();
	var todayYear = date.getFullYear();
	
	var $option = $('.selYear>option');
	$option.filter(function(index){
		$(this).next().html(todayYear-index); /* 년도 자동 입력 */
	});
	
	$('.selYear').change(function(){
		var searchYear = $('.selYear>option:selected').val();

		$.ajax({
			url : "/chartPartnerCount.ss",
			data : {"searchYear":searchYear},
			type : "get",
			success : function(data){
				var sdata;
				
				if(data.searchJoin.length !=0 && data.searchEnd.length !=0){
					sdata = google.visualization.arrayToDataTable([
					  	['분기', '가입한 사업자', '탈퇴한 사업자'],
					  	['1분기',  data.searchJoin[0].quarterCount, data.searchEnd[0].quarterCount],
					  	['2분기',  data.searchJoin[1].quarterCount, data.searchEnd[1].quarterCount],
					  	['3분기',  data.searchJoin[2].quarterCount, data.searchEnd[2].quarterCount],
					  	['4분기',  data.searchJoin[3].quarterCount, data.searchEnd[3].quarterCount]
					]);
					
				}else if(data.searchJoin.length ==0 && data.searchEnd.length !=0){
					sdata = google.visualization.arrayToDataTable([
					  	['분기', '가입한 사업자', '탈퇴한 사업자'],
					  	['1분기',  0, data.searchEnd[0].quarterCount],
					  	['2분기',  0, data.searchEnd[1].quarterCount],
					  	['3분기',  0, data.searchEnd[2].quarterCount],
					  	['4분기',  0, data.searchEnd[3].quarterCount]
					]);
					
				}else if(data.searchJoin.length !=0 && data.searchEnd.length ==0){
					sdata = google.visualization.arrayToDataTable([
					  	['분기', '가입한 사업자', '탈퇴한 사업자'],
					  	['1분기',  data.searchJoin[0].quarterCount, 0],
					  	['2분기',  data.searchJoin[1].quarterCount, 0],
					  	['3분기',  data.searchJoin[2].quarterCount, 0],
					  	['4분기',  data.searchJoin[3].quarterCount, 0]
					]);
				}else{
					sdata = google.visualization.arrayToDataTable([
					  	['분기', '가입한 사업자', '탈퇴한 사업자'],
					  	['1분기',  0, 0],
					  	['2분기',  0, 0],
					  	['3분기',  0, 0],
					  	['4분기',  0, 0]
					]);
				}
				chart.draw(sdata, options);
			},
			error : function(){
				alert("오류");
			}
		});
		
	});
	
});
</script>
</body>
</html>