<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.ad {
   margin: 8px 0;
}
.v{
padding-left : 0;
padding-right : 10px;
}

</style>
</head>
<body>

 <div class="c row">
                             <div class="col-12">주소(위치)*</div>
                             <div class="col-12">
                                <div class="ad row">
                                   <div class="v col-4"><input type="text" id="sample6_postcode" placeholder="우편번호" style="width:100%;" name="zipCode" readonly></div>
                                   <div class="v col-4"><input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" style="width:100%;"></div>
                                   <div class="v col-4"></div>
                                </div>
                                 <div class="ad row">
                                     <div class="v col-8"><input type="text" id="sample6_address" placeholder="주소" name="address1" style="width:100%;"><br></div>
                                     <div class="v col-4"></div>
                                 </div>
                             </div>
                             <div class="col-12">
                                <div class="ad row">
                                   <div class="v col-7"><input type="text" id="sample6_detailAddress" placeholder="상세주소" name="address2" style="width:100%;"></div>
                                   <div class="v col-5"> <input type="text" id="sample6_extraAddress" placeholder="참고항목" style="width:100%;" ></div>
                                </div>
                                
                            </div>
                         </div>  
                         </div>
                 </div>


<!-- 
<input type="text" id="sample6_postcode" placeholder="우편번호">
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample6_address" placeholder="주소" name="address1"><br>
<input type="text" id="sample6_detailAddress" placeholder="상세주소" name="address2" >
<input type="text" id="sample6_extraAddress" placeholder="참고항목" >
 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
var themeObj = {
   //bgColor: "", //바탕 배경색
   searchBgColor: "#9614EF", //검색창 배경색
   //contentBgColor: "", //본문 배경색(검색결과,결과없음,첫화면,검색서제스트)
   //pageBgColor: "", //페이지 배경색
   //textColor: "", //기본 글자색
   queryTextColor: "#FFFFFF" //검색창 글자색
   //postcodeTextColor: "", //우편번호 글자색
   //emphTextColor: "", //강조 글자색
   //outlineColor: "", //테두리
};




        new daum.Postcode({
    theme: themeObj,
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>



</body>
</html>