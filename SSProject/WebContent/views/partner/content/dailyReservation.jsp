<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
		html{
		width:500px;
		height:200px;}
        .table{
            width: 90%;
            margin:  auto;
            margin-top: 30px;
            text-align: center;
        }
        thead{
            background-color: #9614EF;
            color: white;
        }
    
    
    </style>
</head>
<body onload="window.resizeTo(1000,200)">
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <script>
    $(function(){
    var $td = $('td');
    $td.filter(function(index){
       if(index%2==1){
           $('#11-1,#11-2').css('background-color','violet');
       } 
        
        
    });
    
    
    });
    </script>
    
    <div id="wrap">
        <table class="table" border="1" style="table-layout: fixed">
            <thead>
                <tr>
                    <td colspan="20">세부공간명</td>
                    <td colspan="4">07</td>
                    <td colspan="4">08</td>
                    <td colspan="4">09</td>
                    <td colspan="4">10</td>
                    <td colspan="4">11</td>
                    <td colspan="4">12</td>
                    <td colspan="4">13</td>
                    <td colspan="4">14</td>
                    <td colspan="4">15</td>
                    <td colspan="4">16</td>
                    <td colspan="4">17</td>
                    <td colspan="4">18</td>
                    <td colspan="4">19</td>
                    <td colspan="4">20</td>
                    <td colspan="4">21</td>
                    <td colspan="4">22</td>
                    <td colspan="4">23</td>
                    <td colspan="4">24</td>
                </tr>
            </thead>
            <tbody>
                <td colspan="20">302호</td>
                    
                    <td colspan="4" id="07"></td>
                    <td colspan="4" id="08"></td>
                    <td colspan="4" id="09"></td>
                    <td colspan="4" id="10"></td>
                    <td colspan="4" id="11"></td>
                    <td colspan="4" id="12"></td>
                    <td colspan="4" id="13"></td>
                    <td colspan="4" id="14"></td>
                    <td colspan="4" id="15"></td>
                    <td colspan="4" id="16"></td>
                    <td colspan="4" id="17"></td>
                    <td colspan="4" id="18"></td>
                    <td colspan="4" id="19"></td>
                    <td colspan="4" id="20"></td>
                    <td colspan="4" id="21"></td>
                    <td colspan="4" id="22"></td>
                    <td colspan="4" id="23"></td>
                    <td colspan="4" id="24"></td>

            
            
            
            
            </tbody>
        </table>
    </div>
</body>
</html>