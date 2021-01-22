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
import ss.mango.user.space.model.vo.SpaceRegistration;

/**
 * Servlet implementation class SpaceAllListPageServlet
 */
@WebServlet("/SpaceAllListPage.ss")
public class SpaceAllListPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceAllListPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String location = request.getParameter("location");
		String price = request.getParameter("price");
		
		request.getAttribute("checkIn");
		request.getAttribute("start_time");
		request.getAttribute("end_time");
		
		ArrayList<SpaceRegistration> list = new ArrayList<SpaceRegistration>();
		ArrayList<SpaceRegistration> list2 = new ArrayList<SpaceRegistration>();
		
		if(price==null) {
			list = new SpaceService().SpaceAllListPage(location);
		} else if(price.equals("high")) {			
			list2 = new SpaceService().SpaceAllListPage(location,price);
		} else if(price.equals("low")){
			list = new SpaceService().SpaceAllListPage(location);
		}
		
		if(list!=null) {
			RequestDispatcher view = request.getRequestDispatcher("/views/user/reservation/reservation_ChoosePlace.jsp");
			
			if(price==null) {
				request.setAttribute("list", list);				
				request.setAttribute("location", location);
				request.setAttribute("price", price);
			} else if(price.equals("high")) {
				request.setAttribute("list", list2);				
				request.setAttribute("location", location);
				request.setAttribute("price", price);
			} else {
				request.setAttribute("list", list);
				request.setAttribute("location", location);
				request.setAttribute("price", price);
			}
			
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
