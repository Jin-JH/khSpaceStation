package ss.mango.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.admin.model.service.AdminService;
import ss.mango.admin.model.vo.ResInfo;
import ss.mango.admin.model.vo.Reservation;
import ss.mango.admin.model.vo.SubSpace;
import ss.mango.admin.model.vo.User;

/**
 * Servlet implementation class SearchReservationServlet
 */
@WebServlet("/searchReservation.ss")
public class SearchReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }// SearchReservationServlet
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String selectWord = request.getParameter("selectWord");
		String keyword = request.getParameter("keyword");
		
		
		ArrayList<Reservation> rList = new AdminService().searchReservation(selectWord, keyword);
		ArrayList<User> uList = new AdminService().searchUserReservation(selectWord, keyword);
		ArrayList<ResInfo> riList = new AdminService().searchResInfoReservation(selectWord, keyword);
		ArrayList<SubSpace> ssList = new AdminService().searchSubSupaceReservation(selectWord, keyword);	
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/uManage/uManageReservationList.jsp");
		request.setAttribute("rList",rList);
		request.setAttribute("uList",uList);
		request.setAttribute("riList",riList);
		request.setAttribute("ssList",ssList);
		view.forward(request, response);
		
	}// doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}// doPost

}// SearchReservationServlet
