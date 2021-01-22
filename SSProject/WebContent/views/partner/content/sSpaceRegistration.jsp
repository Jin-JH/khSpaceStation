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

.tableStyle {
	background-color: white;
	border: 1px solid lightgray;
}

#fixed_menu {
	width: 75%;
	height: 60px;
	background-color: white;
	position: fixed;
	height: 60px;
}

#fixed_menu li {
	display: inline-block;
	margin: 20px;
}

#regAllow {
	color: gray;
	font-size: 16px;
	font-weight: 600;
	top: 9px;
}

.heads {
	background-color: #9614EF;
	color: white;
	font-size: 22px;
	font-weight: 800;
	text-align: center;
	line-height: 50px;
	height: 50px;
	border-radius: 5px;
	margin-bottom: 20px;
	margin-top: 20px;
}

input[type=checkbox]{
            border: 1px solid white;
            width: 0px;
            height: 0px;
        }
        
input[type=checkbox]:checked{
            outline: 0;
            border: none;
            width: 0px;
            height: 0px;
        }

#spacePrice{
	margin-bottom: 50px;
}


/*서브구역추가본*/
/*가격 옵션 정보*/
.box_form .subTitRe {
	font-size: 18px;
	font-weight: 700;
	color : blue;
	width: 100%;
	height: 300px;
}


.box_formRe {
	position: relative;
	margin-top: 30px;
}

.box_formRe .subTit {
	font-size: 18px;
	font-weight: 700;
	color : #595959;
}

.prdNmRe{
	font-size: 18px;
	font-weight: 700;
	color : #595959;
	margin-right: 100px;
}

#optionRe{
	display:inline-block; 
}

#optionRe span{
	color: gray;
	font: 13px;
	margin-right: 10px;
	margin-left: 10px;
}

.selectRefund select{
	height: 35px;
	line-height: 35px;
	font-size: 15px;
	font-weight: 500;
	color: #595959;
	padding: 0 15px 0 15px;
	width: 100%;
    border: 1px solid lightgray; 
}

.submitDiv{
	margin-top: 70px;
	width: 70%;
 	height: 70px; 
 	line-height: 35px;
	padding: 10px;
}

.submitDiv div{
	height: 100%;
	width: 50%;
	float: left;
}

.submitDiv div a{
	text-decoration: none;
}

#backBtn{
	background-color: #4d4d4d;
	border: none;
}

#backBtn a{
	color: white;
	font-size: 18px;
	font-weight: 800;
	position: relative;
	top: 7px;
}

#saveBtn input{
	width : 100%;
	height: 100%;
	color: white;
	font-size: 18px;
	font-weight: 800;
	position: relative;
	background-color: #FF9614;
	border: none;
}

</style>


	<!-- 세부공간등록 -->
	<%@ include file="/views/partner/partnerForm/head.jsp"%>
	<%@ include file="/views/partner/partnerForm/spaceRegistrationStyle.jsp"%>

	<div id="wrapper">
		<div id="fluid" class="container-fluid">
			<!-- header -->

			<div id="content" class="row padding1 bgColor1">
				<div id="whiteBoard" class="col-12 padding1 bgColor2">
					<div id="inquiry" class="padding1">세부공간등록</div>
					<hr>

					<div class="sSpaceReg">
					<!-- form을 담을 div공간 -->



						<form action="/insertSubSpace.do" method="post">
							<!-- 값을 백으로 전송 -->

							


							<div class="heads">기본정보</div>
							<div class="heading">
								<h3>세부 공간 정보를 입력해주세요.</h3>
								<span class="option"> <span class="txt_required">
										<span class="ico_required">*</span> 필수입력
								</span>
								</span>
							</div>
							<hr>

							<div class="box_form">
								<div class="subTit">
									<label class="prdNm"> 세부 공간명 <span class="ico_required">*</span>
									</label>
									<div class="input">
										<input type="text" id="subSpaceName" name="subName"
											placeholder="세부공간명을 입력해 주세요(예 : 201호)" />
									</div>
								</div>
							</div>
							<!-- 세부 공간 이름 -->

							<div class="box_form">
								<div class="subTit">
									<label class="prdNm"> 세부 공간 소개 <span
										class="ico_required">*</span>
									</label>
									<div class="input">
										<textarea type="text" id="subSpaceInfo" name="subIntro"
											placeholder="세부 공간 소개를 입력해주세요."></textarea>
									</div>
								</div>
							</div>
							<!-- 세부 공간 소개 -->
							<!-- 몇자이상 적기 이런거 해야함 -->

							<div class="box_form">
								<div class="subTit">
									<label class="prdNm"> 공간유형 <span class="ico_required">*</span>
									</label>
									<div class="row">
										<ul class="subSpaceTypeCkecklist">
											<li><input type="radio" name="subType"
												id="meetingRoom" value="회의실" checked /> 회의실</li>
											<li><input type="radio" name="subType"
												id="seminarRoom" value="세미나실" /> 세미나실</li>
											<li><input type="radio" name="subType"
												id="partyRoom" value="파티룸" /> 파티룸</li>
											<li><input type="radio" name="subType"
												id="concertHall" value="공연장" /> 공연장</li>
											<li><input type="radio" name="subType"
												id="studyRoom" value="스터디룸" /> 스터디룸</li>
											<!-- name이 같아야 그 안에서 하나만 선택됨ㅎㅎㅎ -->
										</ul>
									</div>
								</div>
							</div>
							<!-- 공간 유형 -->


							<div class="box_form">
								<div class="subTit">
									<label class="prdNm"> 예약허용 <span class="ico_required">*</span>
									</label>
									<div class="a-body">
										<div class="row">
											<div class="col-md-6">
												<div class="row">
													<div class="col-md-12" id="regAllow">
														<i> 최소 예약 시간 </i>
													</div>
													<div class="col-md-12">
														<div id="three-brother">
															<button type="button" id="minusMinTimeBtn" value="-" onclick='btn_click("upDown")'>-</button>
															<input type="text" id="minTime" name="minTime" value="1" />
															<button type="button" id="plusMinTimeBtn" value="+" onclick='btn_click("upDown")'>+</button>
														</div>
													</div>
												</div>

											</div>
											<div class="col-md-6"></div>
										</div>

										<div class="row">
											<div class="col-md-6">
												<div class="row">
													<div class="col-md-12" id="regAllow">
														<i> 최소 인원 </i>
													</div>
													<div class="col-md-12">
														<div id="three-brother">
															<button type="button" id="minusMinMemberBtn" value="-" onclick='btn_click("upDown")'>-</button>
															<input type="text" id="minMember" name="minPeople" value="1" />
															<button type="button" id="plusMinMemberBtn" value="+" onclick='btn_click("upDown")'>+</button>
														</div>
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="row">
													<div class="col-md-12" id="regAllow">
														<i> 최대 인원 </i>
													</div>
													<div class="col-md-12">
														<div id="three-brother">
															<button type="button" id="minusMaxMemberBtn" value="-">-</button>
															<input type="text" id="maxMember" name="maxPeople" value="1" />
															<button type="button" id="plusMaxMemberBtn" value="+" />+</button>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 예약 허용 -->
							
							<script>
							$(function(){
									$('#minusMaxMemberBtn').click(function(){
										if(Number($('#maxMember').val()) > 0 && Number($('#maxMember').val()) > Number($('#minMember').val()) ){
											$result = Number($('#maxMember').val()) -1;
											$('#maxMember').val($result);
										}
									});
									$('#plusMaxMemberBtn').click(function() {
											$result = Number($('#maxMember').val())+1;
											$('#maxMember').val($result);
										});
										
									$('#minusMinMemberBtn').click(function() {
										if(Number($('#minMember').val()) >0 ){
											$result = Number($('#minMember').val())-1;
											$('#minMember').val($result);
										}
									});
									$('#plusMinMemberBtn').click(function() {
											$result = Number($('#minMember').val())+1;
											$('#minMember').val($result);
									});
										
									$('#minusMinTimeBtn').click(function() {
										if(Number($('#minTime').val()) >0 ){
											$result = Number($('#minTime').val())-1;
											$('#minTime').val($result);
										}
									});
									$('#plusMinTimeBtn').click(function() {
											$result = Number($('#minTime').val()) +1;
											$('#minTime').val($result);
									});
							});
							</script>

							<!-- <div class="heads"></div>
							<div id="spaceBox">
								<span>대표이미지*</span> <span> <input type="file"
									id="upImgFile" onChange="uploadImg();" accept="image/*"
									name="mainImg">
								</span>
								<div class="row" id="spaceImage">
									<div class="col-md-12">
										<img id="imageView" src="">
									</div>
								</div>
							</div> -->


							<div class="heads">편의시설</div>
							<div class="heading">
								<h3>보유하신 편의시설을 입력해주세요</h3>
							</div>
							<hr>

							<div class="box_form">
								<div class="facility_wrap">
									<ul class="inner">
										<li>
											<input type="checkbox" name="amenities" id="amenitiesPlug" class="amenities" value="콘센트"> 
											<label for="amenitiesPlug">
												<i class="fas fa-plug"></i> 
												<span>콘센트</span>
											</label>
										</li>
										<li>
											<input type="checkbox" name="amenities" id="amenitiesWifi" class="amenities" value="와이파이"> 
											<label for="amenitiesWifi">
												<i class="fas fa-wifi"></i> 
												<span>와이파이</span>
											</label>
										</li>
										<li>
											<input type="checkbox" name="amenities"	id="amenitiesAir" class="amenities" value="에어컨"> 
											<label for="amenitiesAir">
												<i class="fas fa-wind"></i> 
												<span>에어컨</span>
											</label>
										</li>
										<li>
											<input type="checkbox" name="amenities"	id="amenities24hour" class="amenities" value="24시운영"> 
											<label for="amenities24hour">
												<i class="fas fa-hourglass-half"></i> 
												<span>24시운영</span>
											</label>
										</li>
										<li>
											<input type="checkbox" name="amenities" id="amenitiesWater" class="amenities" value="정수기"> 
											<label for="amenitiesWater">
												<i class="fas fa-tint"></i> 
												<span>정수기</span>
											</label>
										</li>
										<li>
											<input type="checkbox" name="amenities" id="amenitiesLoker" class="amenities" value="개인락커"> 
											<label for="amenitiesLoker">
												<i class="fas fa-user-lock"></i> 
												<span>개인락커</span>
											</label>
										</li>
										<li>
											<input type="checkbox" name="amenities" id="amenitiesWhiteB" class="amenities" value="화이트보드"> 
											<label for="amenitiesWhiteB">
												<i class="fas fa-chalkboard-teacher"></i> 
												<span>화이트보드</span>
											</label>
										</li>
										<li>
											<input type="checkbox" name="amenities" id="amenitiesEtc" class="amenities" value="기타"> 
											<label for="amenitiesEtc">
												<i class="fab fa-rocketchat"></i> 
												<span>기타</span>
											</label>
										</li>
									</ul>
								</div>
							</div>
							<!-- 편의시설 -->




								<div class="heads">가격 / 옵션정보</div>
								<div class="heading">
								<h3>공간당 가격을 입력해주세요</h3>
								</div>
								<hr>
								<div class="box_formRe">
								<div class="subTit" id="spacePriceTit">
									<label class="prdNm"> 공간별 가격 
										<span class="ico_required">*</span>
									</label>
									<div><input type="text" value="" name="subCost" id="spacePrice"/></div>
								</div>
								</div>
								<script>
									$(document).on('keyup','input[id=spacePrice]',function(event){
										this.value = this.value.replace(/[^0-9]/g,'');   // 입력값이 숫자가 아니면 공백
										this.value = this.value.replace(/,/g,'');          // ,값 공백처리
										this.value = this.value.replace(/\B(?=(\d{3})+(?!\d))/g, ","); // 정규식을 이용해서 3자리 마다 , 추가 	
									}); 
								</script>
								
								
								<div class="heading">
								<h3>환불 기준을 작성해주세요</h3>
								</div>
								<hr>
								<div class="box_formRe"> <!-- 박스폼(div) -->
									<div class="subTitRe" id="spacePriceTit">
										<div style="margin-bottom:10px">
											<label class="prdNmRe" style="display:inline-block"> 이용 8일 전 </label>
											<div id="optionRe">
												<span>총 금액의</span>
												<div class="selectRefund" style="display:inline-block">
													<select name="refundFees">
														<option value="100" selected="selected">100%</option>
													</select>
												</div>
												<span>환불</span>
											</div>
										</div>
										
										<div style="margin-bottom:10px">
											<label class="prdNmRe" style="display:inline-block"> 이용 6일 전 </label>
											<div id="optionRe">
												<span>총 금액의</span>
												<div class="selectRefund" style="display:inline-block">
													<select name="refundFees">
														<option value="100" selected="selected">100%</option>
														<option value="80">80%</option>
														<option value="60">60%</option>
														<option value="40">40%</option>
														<option value="20">20%</option>
														<option value="0">환불불가</option> 
													</select>
												</div>
												<span>환불</span>
											</div>
										</div>
										
										<div style="margin-bottom:10px">
											<label class="prdNmRe" style="display:inline-block"> 이용 4일 전 </label>
											<div id="optionRe">
												<span>총 금액의</span>
												<div class="selectRefund" style="display:inline-block">
													<select name="refundFees">
														<option value="100" selected="selected">100%</option>
														<option value="80">80%</option>
														<option value="60">60%</option>
														<option value="40">40%</option>
														<option value="20">20%</option>
														<option value="0">환불불가</option> 
													</select>
												</div>
												<span>환불</span>
											</div>
										</div>
										
										<div style="margin-bottom:10px">
											<label class="prdNmRe" style="display:inline-block"> 이용 2일 전 </label>
											<div id="optionRe">
												<span>총 금액의</span>
												<div class="selectRefund" style="display:inline-block">
													<select name="refundFees">
														<option value="100" selected="selected">100%</option>
														<option value="80">80%</option>
														<option value="60">60%</option>
														<option value="40">40%</option>
														<option value="20">20%</option>
														<option value="0">환불불가</option> 
													</select>
												</div>
												<span>환불</span>
											</div>
										</div>
										
										<div style="margin-bottom:10px">
											<label class="prdNmRe" style="display:inline-block"> 이용 당일 &nbsp;&nbsp; </label>
											<div id="optionRe">
												<span>총 금액의</span>
												<div class="selectRefund" style="display:inline-block">
													<select name="refundFees">
														<option value="100" selected="selected">100%</option>
														<option value="80">80%</option>
														<option value="60">60%</option>
														<option value="40">40%</option>
														<option value="20">20%</option>
														<option value="0">환불불가</option> 
													</select>
												</div>
												<span>환불</span>
											</div>
										</div>
										<!-- 크기가 점점 작아야함... 몬주알지... -->
										
									</div>
								</div>
								
							<center>
							<div class="submitDiv">
								<div id="backBtn"><a href="/views/partner/content/spaceRegistration.jsp">뒤로가기</a></div>
								<div id="saveBtn"><input type="submit"value="저장"/></div> 
							</div>	
							</center>		
								

						</div>
						<!-- form을 담을 div공간 -->

						</form>

					</div>
				</div>
				<!-- whiteBoard -->
			</div>
			<!--content-->
		</div>
		<!--fluid-->
	</div>
	<!--wrapper-->

	<script>
	$('.navGNB').eq(0).addClass('mangoBgcolor'); //선택한 탭 색칠
	$(".accordian").hide(); //소메뉴 전부 가리기
	$('.category').parents('a').eq(3).removeClass('hoverColor'); //선택한 메뉴 색칠
	$('.heads').nextAll('.heads').css('margin-top','100px');
	
	
	$('.amenities').click(function(){ //.amenities를 클릭했을때 함수 실행
		if($(this).is(':checked')){ //현재 클릭한 속성이 checked되었다면 실행
			$(this).next().children().eq(0).css('color','#FF9614').css('background-color','white');
		}else{
			$(this).next().children().eq(0).css('color','white').css('background-color','gray');
		}
	});
	
	
	
	
</script>

</body>
</html>