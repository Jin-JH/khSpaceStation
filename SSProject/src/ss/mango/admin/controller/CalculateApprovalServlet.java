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
import ss.mango.admin.model.vo.CalculateInfo;
import ss.mango.admin.model.vo.SpaceRegistration;
import ss.mango.admin.model.vo.SpaceRegistration1;

/**
 * Servlet implementation class CalculateApproval
 */
@WebServlet(name = "CalculateApproval", urlPatterns = { "/calculateApproval.ss" })
public class CalculateApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }// CalculateApproval

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<SpaceRegistration1> srList = new AdminService().calculateApprovalSpace();
		ArrayList<CalculateInfo> ciList = new AdminService().calculateApprovalInfo();
		System.out.println(srList);
		System.out.println(ciList);
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/pManage/pManageCalculateApproval.jsp");
		request.setAttribute("srList",srList);
		request.setAttribute("ciList",ciList);
		view.forward(request, response);
		
	}// doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}// doPost 

}// CalculateApproval
