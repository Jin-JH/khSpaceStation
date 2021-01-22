package kr.or.ss.reservationBoard.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.user.member.model.vo.Member;
import kr.or.ss.reservationBoard.model.service.ReservationService;
import kr.or.ss.reservationBoard.model.vo.ReservationPageData;

/**
 * Servlet implementation class ReservationCompletedServlet
 */
@WebServlet("/reservationCompleted.do")
public class ReservationCompletedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationCompletedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		String memberCode = m.getMemberCode();		 //사업자 정보	
		
		
		 ReservationPageData rpd = null;
		 
		 String startDate="";
		int currentPage;
		
		if(request.getParameter("currentPage")==null) {//처음 currentPage는 자동으로 1이기 때문에 보내주는 값이 없어서 null이면 1이란 소리(1페이지라는 소리)
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage")); //1페이지 이후부터는 특정 페이지를 이동할때 값을 보내주게 되므로 그 값을 page처리 하겠다.
		}
		rpd = new ReservationService().selectOneListc(currentPage, startDate,memberCode);
		 request.setAttribute("pageData", rpd);
		 RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/reservationCompleted.jsp");
			System.out.println("서블릿의 마지막까지는 된다"+ rpd);
			System.out.println("서블릿 리스트 출력:" +rpd.getList());//여기까지 애초에 안되고 있는데요? 이게 
			
			view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
