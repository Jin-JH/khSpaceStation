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
	<div id="whiteBoard" class="col-12 padding1 bgColor2 ">
		<div id="inquiry" class="padding1">분기별 매출
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
		  	['분기', '매출액 (단위 : 만)'],
		  	['1분기',  ${quarter[0].quarterCount }],
		  	['2분기',  ${quarter[1].quarterCount }],
		  	['3분기',  ${quarter[2].quarterCount }],
		  	['4분기',  ${quarter[3].quarterCount }]
		]);
		
		options = {
		  	title: '연간 분기별 매출',
		  	curveType: 'function',
		  	legend: { position: 'bottom' },
		  	colors: ['orange'], //색상 정하기
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
			url : "/chartAdminStates.ss",
			data : {"searchYear":searchYear},
			type : "get",
			success : function(data){
				var sdata;
				
				if(data.length !=0){
					sdata = google.visualization.arrayToDataTable([
					  	['분기', '매출액 (단위 : 만)'],
					  	['1분기',  data[0].quarterCount],
					  	['2분기',  data[1].quarterCount],
					  	['3분기',  data[2].quarterCount],
					  	['4분기',  data[3].quarterCount]
					]);
					
				}else{
					sdata = google.visualization.arrayToDataTable([
					  	['분기', '매출액 (단위 : 만)'],
					  	['1분기',  0],
					  	['2분기',  0],
					  	['3분기',  0],
					  	['4분기',  0]
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