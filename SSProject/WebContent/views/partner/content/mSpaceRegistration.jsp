<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    .content-body {
            min-width: 400px;
            width: 90%;
            height: 100%;
            padding: 50px 60px;
            margin: auto auto;
           
        }
        .content-body > div {
            border: 1px solid #9614EF; 
            font-weight: bold;
        }
       
        .heads {
            background-color: #9614EF; 
            color: white;
            font-size: 22px;
            text-align: center;
        }   
        .a-2{
            border-bottom: 1px solid #9614EF;
            padding: 10px 10px;
            font-size: 22px;
            margin: 20px 0 20px 0;
        }
        .a-body{
            padding: 20px 20px;
          
           
            
        }
        .inp{
            margin: 10px 0px 10px 0px;
            width: 100%;
        }
        #inp3{
            margin: 3px 0px 3px 0px;
            width: 100%;
        }
        
        .b{
            margin: 150px 0 150px 0;
           padding: 10px 0px;
            background-color: #fafafa;
        }
        .c{
            margin: 50px 0 100px 0;
            background-color: #fafafa;
            
        }
      
        #data{
            width: 100%; 
            margin: 10px 5px 5px 5px;
            resize:none;
            resize:none;
        }
        #three-brother{
            width:100%;
            padding: 0;
            margin: 10px 0px 10px 0px;
            
        }
        #three-brother>button {
            width:10%;
            padding: 0;
            margin: 0;
            float: left;
        }
        #three-brother>input{
            width:80%;
            padding: 0;
            margin: 0;
            float: left;
        }
        #email-second{
           padding: 0px 0px; 
        }
        #email-second input{
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
        .operate-day{
            float: left;
            width: 10%;
            margin: 0px;
            text-align: center;
        }
        .operate-td span{
            float: left;
            width: 10%;
            margin: 0px 10px 0px 0px;
        }
        .operate-td>select{
            float: left;
            width: 80%;
        }
        .operation_time>*{
        width:100;
        padding:0px 10px;
        margin:20px 20px;
        }
        .a{
            margin-top: 150px;
            margin-bottom: 150px;
        }
      .calculatebox{
      width: 100%;
      margin:0 auto;
      
      }
      .last_btn{
      width: 47%;
      height:50px;
      margin:0px 6px 0px 6px;
      border-style:none;
      }
      .cal_row{
      margin:0px;
      padding:40px 10px;
      }
      .cal_col{
      width:100%;
      }
      .last_btn:hover{
      background-color: #9614EF;
      color:white;
      }
      .useSel{
      width:40%;
      padding:0px;
      margin:0px 5px 0px 5px;
      }
      #spaceImage{
      height: 300px;
      border:1px solid;
      margin:5px 0;
      }
      #spaceBox{
      margin: 150px 0 150px 0;
      }
      #upImgFile{
      text-align:right;
      }
      

</style>
</head>
<body>
<%@ include file="/views/partner/partnerForm/headspace.jsp" %>

<%@ include file="/views/partner/partnerForm/contentForm.jsp" %>

<div id="wrapper">
   <div id="content" class="container-fluid">

<!-- header -->

        <div id="content" class="row padding1 bgColor1"> <!--id를 content로 주어서 구분이 명확해지고 row클래스에 추가-->
         <div id="whiteBoard" class="col-12 padding1 bgColor2"> <!--divRadius를 whiteboard로 변경. col-12클래스 추가-->
            <div id="inquiry" class="padding1">목록 ()</div>
               <hr>
                   
            <div>   
            
<!--       <form action="/MSpaceEnroll.do" method="post"> -->
        <form action="/MSpaceEnroll.do" method="post" enctype="multipart/form-data">  
            <!--content--> 
            <div class="content-body">
                <section>
               
                <article>
                <div class="c">
                    <div class="heads" id="basicInfo">기본정보</div>
                        <div class="a-body">
                             <div class="a-2">공간 정보를 입력해주세요.</div>
                             <div >
                                   공간명* <h6 style='float:right'><span id="textLength1" >20</span>/20자(최대20자)</h6> <br><input type="text" id= "spaceinfo1" class="inp" name="spaceName"/> <br>
                                    <span>사용 가능한 특수문자 : ( ) , . [ ] - </span>   
                             </div>
                             
                             
                             <div class="c row">
                             <div class="col-md-12">공간소개*  <h6 style='float:right'><span id="textLength2">300</span>/300자(최대300자)</h6></div>
                             <div class="col-md-12"> <textarea id="data" rows="3" name="spaceIntro"></textarea>
                             </div>
                          </div> 
                        </div>
                </div>
                        
                        <script>
                        function check(){
                           var spaceinfo1 = document.getElementById("spaceinfo1").value;
                           var exp=/^[(),.[]-]+$/;
                           if(exp.test(spaceinfo1)){
                              alert("검증되었습니다.");
                           }
                           else{
                              alert("정규표현식에 어긋납니다.");
                           }
                        }
                        
                        
                        </script> 
                    </article>
                    
                    <article>
                <div class="c">
                    <div class="heads" id="spaceType">공간유형</div>
                        <div class="a-body">
                             
                             <div class="a-2">공간 유형을 입력해주세요.</div>
                             <div class="row">
                                   <div class="col-md-12">공간사이즈(m<sup>2</sup>)*</div>
                                   <div class="col-md-6">
                                        <div id="three-brother">
                                            <button type="button" id="subSpaceMinus">-</button>
                                            <input type="text" value="0" id="subSpaceNum" style="text-align:center" name="spaceSize" /><!--  -->
                                            <button type="button" id="subSpacePlus">+</button>
                                        </div>    
                                   </div>
                                   <div class="col-md-6">
                                   </div>
                              </div>
                   
                             <div id="spaceBox">
                            <span>대표이미지*</span>
                              <span>
                                    <input type="file" id="upImgFile" onChange="uploadImg();" accept="image/*" name="mainImg"><!-- name="mainImg" -->
                               </span>
                             <div class="row" id="spaceImage">
                                <div class="col-md-12"> 
                                    <img id="imageView" src="">
                                </div>
                             </div>
                               
                             </div> 
                       
                       
                               <div id="spaceBox">
                            <span>서브이미지*</span>
                              <span>                                                                  <!--  name="subImg" -->
                                    <input type="file" id="upImgFiles" onChange="uploadImgs();" name="subImg" accept="image/*" multiple >
                               </span>
                             <div class="row" id="spaceImage">
                                <div class="col-md-12"> 
                                    <div id="imageviews"></div>
                                </div>
                             </div>
                               
                             </div> 
                              
                              <script>
                        /*      
                              var addInput = document.getElementById("addInput");
                              var delInput = document.getElementById("delInput");
                              var subImgAdd = document.getElementById("subImgAdd");
                              var cnt = 2;
                              addInput.onclick = function(){
                                 if(cnt <= 5){
                                 var element = document.createElement("input");
                                 element.type="file";
                                 element.name = "subImg"+cnt;
                                 cnt++;
                                 
                                 subImgAdd.appendChild(element);
                                 subImgAdd.appendChild(document.createElement("br"));
                                
                                 } else {
                                    alert("파일은 5개까지 추가 가능");
                                 }
                                 
                                 
                                 
                              };
                                 delInput.onclick =function(){
                                    if(cnt>1){
                                       cnt--;
                                       var inputs = subImgAdd.getElementsByTagName('input');  //배열형태
                                       var brArr = subImgAdd.getElementsByTagName('br');
                                       subImgAdd.removeChild(brArr[brArr.length-1]);
                                       subImgAdd.removeChild(inputs[inputs.length-1]);
                                    } else {
                                       alert ("파일은 최소 1개는 업로드 해주세요!");
                                    }
                                 };
                                 */
                           function uploadImgs() {
                                   // @breif 업로드 파일 읽기
                                   var fileList = document.getElementById( "upImgFiles" ).files;
                                        
                                  // @breif 업로드 파일 읽기
                                  function readAndPreview( fileList ) {
                                     // @breif 이미지 확장자 검사
                                     if ( /\.(jpe?g|png|gif)$/i.test( fileList.name ) ) {
                                        var reader = new FileReader();
                                        reader.addEventListener( "load", function() {
                                           var image = new Image();
                                           image.width = "230";
                                           image.height = "230";
                                           image.title = fileList.name;
                                           image.src = this.result;

                                           // @details 이미지 확장자 검사
                                           document.getElementById( "imageviews" ).appendChild( image );
                                        }, false );

                                        // @details readAsDataURL( )을 통해 파일의 URL을 읽어온다.

                                        if( fileList ) {
                                           reader.readAsDataURL( fileList );
                                        }
                                     }
                                  }

                                if( fileList ) {
                             // @details readAndPreview() 함수를 forEach문을통한 반복 수행
                                    [].forEach.call( fileList, readAndPreview );
                                 }
                                }  
                            
                              
                              </script>
                              
                              
                              
                       <%--  
                             <div id="spaceBox">
                            <span>이미지*</span>
                              <span>                                                                  <!--  name="subImg" -->
                                    <input type="file" id="upImgFiles" onChange="uploadImgs();" name="subImg" accept="image/*" multiple >
                               </span>
                             <div class="row" id="spaceImage">
                                <div class="col-md-12"> 
                                    <div id="imageviews"></div>
                                </div>
                             </div>
                               
                             </div> 
                       --%>       
                              
                              <%--
                            <div class="c row">
                             <div class="col-md-12">주소(위치)*</div>
                             <div class="col-md-12">
                                 <div class="row">
                                     <div class="col-md-10"><input type="text" class="inp" name="address1"/></div>
                                     <div class="col-md-2"><button style="width:100%" type="button">주소등록</button></div>
                                 </div>
                             </div>
                             <div class="col-md-12"><input type="text" id="inp3" name="address2"/></div>
                         </div>  
                         </div>
                 </div>
                  --%>      
                      
                      <%@ include file="/views/partner/content/searchAddress.jsp" %>
                      
                      
                                   </article>
                                    
                                    <article>
                                    <form name="email_input">
                <div class="c">
                    <div class="heads" id="contactInfo">공간 연락처 정보</div>
                        <div class="a-body">
                             
                             <div class="a-2">공간에 대한 연락처 정보를 입력해주세요.</div>
                             <div class="email row">
                                 <div class="col-md-12">이메일*</div>
                                 <div class="col-md-12">
                                     <div class="row">
                                         <div class="col-md-3">
                                             <input type="text" placeholder="이메일 주소 입력"  class="inp" id="email1" name="email1"/>
                                         </div>    
                                         <div class="col-md-3" id="email-second" >
                                             <span>@</span><input type="text" id="email2" name="email3" disabled/>
                                         </div>       
                                         <div class="col-md-2" >
                                            
                                              <select id="emailSelect" name="email2" class="inp"  >
                                                <option value="1" selected="selected">직접입력</option>
                                                <option value="daum.net">daum.net</option>
                                                <option value="naver.com">naver.com</option>
                                                <option value="gmail.com">gmail.com</option>
                                                <option value="name.com">nate.com</option>
                                               </select>
                                               
                                            
                                         </div>
                                         <div class="col-md-5" >
                                         </div>
                                     </div>
                                </div>
                           </div>
                         
                        
                    <div class="row">
                                 <div class="col-md-6">
                                    <div class="row">
                                        
                                        <div class="col-12">휴대폰*</div>
                                        <div class="col-12">
                                            <div class="p-1 w-100">
                                            <input type="text" style="width:30%" name="phone1" placeholder="010"/> - 
                                            <input type="text" style="width:30%" name="phone2"/> - 
                                            <input type="text" style="width:30%" name="phone3"/>
                                            </div>
                                        </div>
                                        
                                    </div>
                                </div>
                                   
                                <div class="col-md-6">
                                    <div class="row">
                                        
                                        <div class="col-12">유선번호*</div>
                                        <div class="col-12">
                                            <div class="p-1 w-100">
                                            <input type="text" style="width:30%" name="tel1"/> - 
                                            <input type="text" style="width:30%" name="tel2"/> - 
                                            <input type="text" style="width:30%" name="tel3"/>
                                            </div>
                                        </div>
                                        
                                    </div>
                                </div>
                        </div>
                    </div>        
                </div>
               </article>
         
                  
                <article>
                    <div class="c">
                    <div class="heads" id="useGuide">이용안내</div>
                        <div class="a-body">    
                          <div class="a-2">운영시간</div>
                             <div class="operation_time row">
                                 <div class="co1-2">월</div>
                                 <div class="col-2" >
                                     <input type="checkbox" name="closedDay" value="월"/>휴무
                                 </div>
                                 <div class="col-2">
                                         <input type="checkbox" name="operation24" value="월"/>
                                         24시 운영</div>
                                     <div class="col-6" >
                                        <div class="row">
                                         <select class="useSel" name="startTime_multiple1" id="startT">
                                             <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                      
                                       ~ 
                                     <select class="useSel" name="lastTime_multiple1" id="lastT">
                                            <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                         </div>
                                     </div>
                         </div>       
                                     
                         <div class="operation_time row">
                                 <div class="co1-2">화</div>
                                 <div class="col-2" >
                                     <input type="checkbox" name="closedDay" value="화"/>휴무
                                 </div>
                                 <div class="col-2">
                                         <input type="checkbox" name="operation24" value="화"/>
                                         24시 운영</div>
                                     <div class="col-6" >
                                        <div class="row">
                                         <select class="useSel" name="startTime_multiple2">
                                           <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                      
                                       ~ 
                                     <select class="useSel" name="lastTime_multiple2">
                                           <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                         </div>
                                     </div>
                          </div>  
                                     
                                     
                          <div class="operation_time row">
                                 <div class="co1-2">수</div>
                                 <div class="col-2" >
                                      <input type="checkbox" name="closedDay" value="수"/>휴무
                                 </div>
                                 <div class="col-2">
                                         <input type="checkbox" name="operation24" value="수"/>
                                         24시 운영</div>
                                     <div class="col-6" >
                                        <div class="row">
                                         <select class="useSel" name="startTime_multiple3">
                                           <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                      
                                       ~ 
                                     <select class="useSel" name="lastTime_multiple3">
                                             <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                         </div>
                                     </div>
                          </div>
                                     
                                     
                          <div class="operation_time row">
                                 <div class="co1-2">목</div>
                                 <div class="col-2" >
                                       <input type="checkbox" name="closedDay" value="목"/>휴무
                                 </div>
                                 <div class="col-2">
                                         <input type="checkbox" name="operation24" value="목"/>
                                         24시 운영</div>
                                     <div class="col-6" >
                                        <div class="row">
                                         <select class="useSel" name="startTime_multiple4">
                                            <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                      
                                       ~ 
                                     <select class="useSel" name="lastTime_multiple4">
                                           <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                         </div>
                                     </div>
                          </div>
                                     
                                     
                                     
                          <div class="operation_time row">
                                 <div class="co1-2">금</div>
                                 <div class="col-2" >
                                       <input type="checkbox" name="closedDay" value="금"/>휴무
                                 </div>
                                 <div class="col-2">
                                         <input type="checkbox" name="operation24" value="금"/>
                                         24시 운영</div>
                                     <div class="col-6" >
                                        <div class="row">
                                         <select class="useSel" name="startTime_multiple5">
                                         <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                      
                                       ~ 
                                     <select class="useSel" name="lastTime_multiple5">
                                          <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                         </div>
                                     </div>
                             </div>
                                     
                                     
                                     
                             <div class="operation_time row">
                                 <div class="co1-2">토</div>
                                 <div class="col-2" >
                                       <input type="checkbox" name="closedDay" value="토"/>휴무
                                 </div>
                                 <div class="col-2">
                                         <input type="checkbox" name="operation24" value="토"/>
                                         24시 운영</div>
                                     <div class="col-6" >
                                        <div class="row">
                                         <select class="useSel" name="startTime_multiple6">
                                           <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                      
                                       ~ 
                                     <select class="useSel" name="lastTime_multiple6">
                                           <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                         </div>
                                     </div>
                                 </div>
                                     
                                     
                              <div class="operation_time row">
                                 <div class="co1-2">일</div>
                                 <div class="col-2" >
                                      <input type="checkbox" name="closedDay" value="일"/>휴무
                                 </div>
                                 <div class="col-2">
                                         <input type="checkbox" name="operation24" value="일"/>
                                         24시 운영</div>
                                     <div class="col-6" >
                                        <div class="row">
                                         <select class="useSel" name="startTime_multiple7">
                                           <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                      
                                       ~ 
                                     <select class="useSel" name="lastTime_multiple7">
                                           <option value="0">00:00</option>
                                             <option value="1">01:00</option>
                                             <option value="2">02:00</option>
                                             <option value="3">03:00</option>
                                             <option value="4">04:00</option>
                                             <option value="5">05:00</option>
                                             <option value="6">06:00</option>
                                             <option value="7">07:00</option>
                                             <option value="8">08:00</option>
                                             <option value="9">09:00</option>
                                             <option value="10">10:00</option>
                                             <option value="11">11:00</option>
                                             <option value="12">12:00</option>
                                             <option value="13">13:00</option>
                                             <option value="14">14:00</option>
                                             <option value="15">15:00</option>
                                             <option value="16">16:00</option>
                                             <option value="17">17:00</option>
                                             <option value="18">18:00</option>
                                             <option value="19">19:00</option>
                                             <option value="20">20:00</option>
                                             <option value="21">21:00</option>
                                             <option value="22">22:00</option>
                                             <option value="23">23:00</option>
                                             <option value="24">24:00</option>
                                         </select>
                                         </div>
                                     </div>
                                 </div>
                                     
                                     
                                     
                   <div class="c row">
                       <div class="col-md-12">운영/휴무 관련 추가 안내사항
                              <h6 style='float:right'> <span>0자/100자(최대100자)</span></h6></div>
                        <div class="col-md-12">
                               <div class="row">
                                       <div class="col-md-10"><input type="text" id="input1" class="inp" /></div>
                                      <div class="col-md-2"><button style="width:100%" onclick="test();" type="button">추가</button></div>
                             </div>
                       </div>
                    <div class="col-md-12" id="btn11"> <input id="p1" style=" width:100%; height: 200px; border:1px solid;" name="additionalInfo"/>
                    </div>
                    
                  </div>
                                     
                         </div> <!-- a-body -->
                               
                     </div>
                      
                     
                    </article>
               <script>
              /*$(function(){
                  $('#btn12').click(function(){
                     
                     var inputData = $('#input1').val();
                     $('#p1').html(inputData);
                     $('#input1').val('');
                  });
               });
               */
               function test(){
                  var inputData = document.getElementById("input1").value;
                  document.getElementById("p1").value += inputData;  //여기 br적용 어케함?
                  document.getElementById("input1").value="";
               }
               
               
               </script>
                   
                  
                    <article>
                            <input type="button" onClick="location.href='#basicInfo'" value="맨위로" class="last_btn"/><input type="submit" value="공간등록" class="last_btn" id="submit"/>
                            </article>
                   
                  <br><br><br><br><br><br><br><br><br><br>  
             </section>   
            </div> <!--content-body last--> 
            </form>
            </div>    
         </div><!-- whiteBoard -->
      </div><!--content-->
    </div><!--"fluid"-->
</div><!--wrapper-->


 <script>
                        $(function(){
                            $('.inp').keydown(function(){
                                var inputTextLength1=$(this).val().length;
                                var inputTextPossible1 = 20-inputTextLength1;
                                
                                if(inputTextLength1>20){
                                    $(this).val($(this).val().substring(0,20));
                                    $('#textLength1').html(0);
                                }else{
                                    $('#textLength1').html(inputTextPossible1);
                                }
                            });
                        });
  
                        $(function(){
                            $('#data').keydown(function(){
                                var inputTextLength2=$(this).val().length;
                                var inputTextPossible2 = 300-inputTextLength2;
                                
                                if(inputTextLength2>300){
                                    $(this).val($(this).val().substring(0,300));
                                    $('#textLength2').html(0);
                                }else{
                                    $('#textLength2').html(inputTextPossible2);
                                }
                            });
                        });
  
                        </script>

 <script>
                  $(function(){
                    $('#subSpaceMinus').click(function(){
                       if(Number($('#subSpaceNum').val()>0)){
                          $result=Number($('#subSpaceNum').val())-1;
                          $('#subSpaceNum').val($result);
                       }
                       
                      
                    });
                     $('#subSpacePlus').click(function(){
                        $result=Number($('#subSpaceNum').val())+1;
                        $('#subSpaceNum').val($result);
                       
                      
                     });
                   
                  });
                  
                  
                  
                  
                  </script>       
                      
                       
        
                 <script type="text/javascript">
      function uploadImg() {
       var fileInfo = document.getElementById("upImgFile").files[0];
       var reader = new FileReader();
        reader.onload = function() {
            document.getElementById("imageView").src = reader.result;
            document.getElementById('imageView').setAttribute('width','300px');
        };         
       if( fileInfo ) {
            reader.readAsDataURL( fileInfo );
        }
    }
      
      
      function uploadImgs() {
         // @breif 업로드 파일 읽기
         var fileList = document.getElementById( "upImgFiles" ).files;
              
        // @breif 업로드 파일 읽기
        function readAndPreview( fileList ) {
           // @breif 이미지 확장자 검사
           if ( /\.(jpe?g|png|gif)$/i.test( fileList.name ) ) {
              var reader = new FileReader();
              reader.addEventListener( "load", function() {
                 var image = new Image();
                 image.width = "230";
                 image.height = "230";
                 image.title = fileList.name;
                 image.src = this.result;

                 // @details 이미지 확장자 검사
                 document.getElementById( "imageviews" ).appendChild( image );
              }, false );

              // @details readAsDataURL( )을 통해 파일의 URL을 읽어온다.

              if( fileList ) {
                 reader.readAsDataURL( fileList );
              }
           }
        }

      if( fileList ) {
   // @details readAndPreview() 함수를 forEach문을통한 반복 수행
          [].forEach.call( fileList, readAndPreview );
       }
      }  
      
      
      
</script>   
                            
       
    <script>
             $(function(){
               $('#emailSelect').change(function(){
                  $('#emailSelect option:selected').each(function(){
                     if($(this).val()=='1'){
                        $('#email2').val('');
                        $('#email2').attr("disabled",false);
                     }
                     else{
                        $('#email2').val($(this).text());
                        $('#email2').attr("disabled",true);
                     }
                  });
               });
                
                
             });
             
               
             
               </script>


</body>
</html>