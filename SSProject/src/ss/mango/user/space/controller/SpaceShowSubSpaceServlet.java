package ss.mango.user.space.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.user.space.model.service.SpaceService;
import ss.mango.user.space.model.vo.SpaceRegistration;
import ss.mango.user.space.model.vo.SubSpace;

/**
 * Servlet implementation class SpaceSelectSubSpaceServlet
 */
@WebServlet("/SpaceShowSubSpace.ss")
public class SpaceShowSubSpaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceShowSubSpaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String spaceNo = request.getParameter("spaceNo");
		
		SpaceRegistration space = new SpaceService().SelectSpace(spaceNo);
		ArrayList<SubSpace> list = new SpaceService().SelectSubSpace(spaceNo);
		
		HttpSession session = request.getSession();
		
		RequestDispatcher view = request.getRequestDispatcher("/views/user/reservation/reservation_InsertPlace.jsp");
		session.setAttribute("space", space);
		request.setAttribute("subspace", list);
		
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
