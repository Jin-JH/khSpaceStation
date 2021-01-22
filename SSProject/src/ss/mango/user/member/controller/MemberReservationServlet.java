package ss.mango.user.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.user.member.model.vo.Member;
import ss.mango.user.space.model.service.SpaceService;
import ss.mango.user.space.model.vo.ReservationDetails;

/**
 * Servlet implementation class MemberReservationServlet
 */
@WebServlet("/MemberReservation.ss")
public class MemberReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Member m = (Member)session.getAttribute("member");
		
		ArrayList<ReservationDetails> list = new SpaceService().selectReservation(m.getMemberCode());
		
		RequestDispatcher view = request.getRequestDispatcher("/views/user/mypage/myPage_Reservation.jsp");
		
		request.setAttribute("resDetails", list);
		
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
