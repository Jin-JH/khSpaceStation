package ss.mango.user.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.user.member.model.vo.Member;
import ss.mango.user.space.model.service.SpaceService;
import ss.mango.user.space.model.vo.ResInfo;
import ss.mango.user.space.model.vo.ReservationDetails;

/**
 * Servlet implementation class MemberReservationDetailServlet
 */
@WebServlet("/MemberReservationDetail.ss")
public class MemberReservationDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberReservationDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		
		String resNo = request.getParameter("resNo");
		
		ResInfo resinfo = new SpaceService().selectOneReservation(resNo);
		ReservationDetails resDetail = new SpaceService().selectOneReservation(m.getMemberCode(),resNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/user/mypage/myPage_ReservationDetail.jsp");
		request.setAttribute("resinfoDetail", resinfo);
		request.setAttribute("resDetail", resDetail);
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
