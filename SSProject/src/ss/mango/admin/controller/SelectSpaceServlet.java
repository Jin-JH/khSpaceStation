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
import ss.mango.admin.model.vo.Partner;
import ss.mango.admin.model.vo.SpaceRegistration;

/**
 * Servlet implementation class SelectSpaceServlet
 */
@WebServlet("/selectSpace.ss")
public class SelectSpaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSpaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }// SelectSpaceServlet

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<SpaceRegistration> srList = new AdminService().selectSpaceRegistration();
		ArrayList<Partner> spList = new AdminService().selectSpacePartner();
				
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/pManage/pManageSpace.jsp");
		request.setAttribute("srList",srList);
		request.setAttribute("spList",spList);
		view.forward(request, response);
	
	}// doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}// doPost

}// SelectSpaceServlet
