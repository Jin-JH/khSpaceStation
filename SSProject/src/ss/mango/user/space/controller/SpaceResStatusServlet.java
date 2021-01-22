package ss.mango.user.space.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.user.space.model.service.SpaceService;
import ss.mango.user.space.model.vo.Reservation;

/**
 * Servlet implementation class SpaceResStatusServlet
 */
@WebServlet("/ResStatusView.ss")
public class SpaceResStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceResStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String subno = request.getParameter("subno");
		String resdate = request.getParameter("resdate");
		
		ArrayList<Reservation> list = new SpaceService().ReservationStatusView(subno,resdate);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/user/reservation/reservation_ReservationStatus.jsp");
		request.setAttribute("list", list);
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
