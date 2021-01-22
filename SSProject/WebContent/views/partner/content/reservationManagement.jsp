<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 
      <link href='/fullcalendar/main.css' rel='stylesheet' />
    <script src='/fullcalendar/main.js'></script>
    <script>
       
      document.addEventListener('DOMContentLoaded', function() {
          
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth',
            
            initialDate: '2020-09-12',
      editable: true,
      selectable: true,
      businessHours: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: [
        {
         title: '203호',
          start: '2020-09-01',
           
            url: '/views/partner/content/dailyReservation.jsp?date=20200901', 
        },
        {
            title: '103호',
             start: '2020-09-02',
              
               url: '/views/partner/content/dailyReservation.jsp?a=text', 
           }          
      ],
        eventClick:function(info){
    	  info.jsEvent.prevetDefault();
    	  
    	  if(info.event.url){
    		  window.open(info.event.url,"width=500px, height=500px");
    	  }
      }
        });
        calendar.render();
      });
      
    </script>

</head>
<body>
<%@ include file="/views/partner/partnerForm/header.jsp" %>
 <div id='calendar'></div>
            
 <script>
 
 
 
 
 </script>           
            
            
            
        </div>
        <!--content-->

    </div>
    <!--wrapper-->
</body>
</html>