<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ss.mango.user.space.model.vo.SpaceRegistration" %>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Space Station</title>
	<%@ include file="/views/user/common/__js.jsp" %>
    
    <style>
    	* {
            box-sizing: border-box;
            margin: 0px;
            padding: 0px;
    	}
    	#container {
    		height: 70%;
    	}
    	.cardShow {
    		overflow-x: hidden;
    	}
    	#prevBtn {
    		position: absolute;
    		float: left;
    		width: 60px;
    		height: 77%;
    		top: 30;
    		left: 0;
    		bottom: 0;
    		font-size: 20px;
    		font-weight: bold;
    		border: none;
    		background-color: rgba(0,0,0,0.0);
    		z-index: 20;
    	}
    	#prevBtn:hover {
    		background: rgba(234,234,234,0.3);
    		transition: background-color 0.8s ease-out;
    	}
    	#prevBtn:focus {
    		outline: none;
    	}
    	#nextBtn {
    		position: absolute;
    		float: left;
    		width: 60px;
    		height: 77%;
    		top: 30;
    		right: 0;
    		bottom: 0;
    		font-size: 20px;
    		font-weight: bold;
    		border: none;
    		background-color: rgba(0,0,0,0.0);
    		z-index: 20;
    	}
    	#nextBtn:hover {
    		background: rgba(234,234,234,0.4);
    		transition: background-color 0.8s ease-out;
    	}
    	#nextBtn:focus {
    		outline: none;
    	}
    	.cardHide {
    		background-color: yellow;
    	}
    	.cardHideUl {
    		height: 100%;
    	}
    	.cardHideLi {
    		float: left;
    		list-style-type: none;
    	}
    	.cardSize {
    		margin: 30px 0px 30px 60px;
    		width: 300px;
    		height: 400px;
    	}
    	.card {
    		border: 1px solid #EBEBEB;
    		border-radius: 5px;
    		width: 100%;
    		height: 100%;
    		margin: 0 auto;
    		cursor: pointer;
    	}
    	.card:hover {
    		transform: scaleX(1.05) scaleY(1.05);
    		transition: .5s;
    		box-shadow: 0px 3px 10px 1px lightgray;
    	}
    	.cardPriceBox {
    		position: absolute;
    		left: 20px;
    		bottom: 20px;
    	}
    </style>
</head>
<body>
	<div class="wrapper">
        <div class="row p-0 m-0" id="header">
            <%@ include file="/views/user/common/header.jsp" %>
        </div>
		<div class="row p-0 m-0" id="container">
			<% ArrayList<SpaceRegistration> list = (ArrayList<SpaceRegistration>)request.getAttribute("list"); %>
			<div class="col-12 m-0 p-0">
				<img src="/image/오피스10.jpg" style="width: 100%; height: 100%;">
			</div>
			<div class="col-12 m-0 p-0" style="margin: 0 auto;">
				<center><h2 id="cardTitle" style="margin: 80px 0px 20px 0px;"><b><span style="color:chocolate">최근</span> 등록한 신규 오피스</b></h2></center>
				<div class="cardShow">
					<div class="cardHide" position="absoulute" style="width:3700px">
						<button type="button" id="prevBtn"><</button>
						<ul class="cardHideUl">
						<% for(int i = 0; i < list.size(); i++) { %>
						<li class="cardHideLi">
							<div class="cardSize" style="display: inline-block;">
								<div class="card" onclick="location.href='/SpaceShowSubSpace.ss?spaceNo=<%=list.get(i).getSpaceNo()%>'">
									<div style="height:50%;">
										<img src="/resources/file/image/<%=list.get(i).getFileName() %>" class="card-img-top" style="width:100%; height:100%" alt="...">
									</div>
									<div class="card-body">
										<h5 class="card-title"><b><%=list.get(i).getSpaceName() %></b></h5>
										<p class="card-text">
											<i class="fas fa-map-marker-alt icon_style"></i> <%=list.get(i).getSpaceAddress().substring(0, 2) %>
										</p>
										<% DecimalFormat formatter = new DecimalFormat("###,###");%>
										<div class="cardPriceBox">
											<h5 style="display: inline"><b><%=formatter.format(list.get(i).getMinSubCost()) %>원</b></h5>
											<span class="font-size: 14px;">부터</span>
										</div>
									</div>
								</div>
							</div>
						</li>
						<% } %>
						</ul>
						<button type="button" id="nextBtn">></button>
					</div>
					<a href="" style="width:60px; height:100%"></a>
				</div>
			</div>
		</div>
		<div class="row p-0 m-0" id="footer">
            <%@ include file="/views/user/common/footer.jsp" %>
        </div>
    </div>
    <script>
    	var $card = $('.card');
    	var $cardSize = $('.cardSize');
    	
	    if($card.width() > $cardSize.width()) {
			$cardSize.width() = $card.width();
			$cardSize.height() = $card.width() * 2/3;
		}
    </script>
	<script>
		$("#prevBtn").click(function() {
			if($('.cardHide').css('margin-left')!='0px') {
				$('.cardHide').animate({marginLeft:"+=360"},300);
			}
		});
		$("#nextBtn").click(function() {
			if($('.cardHide').css('margin-left')!='-1800px') {
				$('.cardHide').animate({marginLeft:"-=360"},300);
			}
		});
	</script>
</body>
</html>