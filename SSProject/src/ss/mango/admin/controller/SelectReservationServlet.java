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
@WebServlet("/selectReservation.ss")
public class SelectReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }// SearchReservationServlet
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Reservation> rList = new AdminService().selectReservation();
		ArrayList<User> uList = new AdminService().selectUserReservation();
		ArrayList<ResInfo> riList = new AdminService().selectResInfoReservation();
		ArrayList<SubSpace> ssList = new AdminService().selectSubSupaceReservation();	
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/uManage/uManageReservation.jsp");
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
