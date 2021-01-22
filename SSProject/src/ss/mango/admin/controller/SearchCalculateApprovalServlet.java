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

/**
 * Servlet implementation class CalculateApproval
 */
@WebServlet(name = "SearchCalculateApprovalServlet", urlPatterns = { "/searchCalculateApproval.ss" })
public class SearchCalculateApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCalculateApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }// CalculateApproval

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String selectWord = request.getParameter("selectWord");
		String keyword = request.getParameter("keyword");
		
		ArrayList<SpaceRegistration> srList = new AdminService().searchCalculateApprovalSpace();
		ArrayList<CalculateInfo> ciList = new AdminService().searchCalculateApprovalInfo(selectWord, keyword);
				
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/pManage/pManageCalculateApprovalList.jsp");
		request.setAttribute("srList",srList);
		request.setAttribute("ciList", ciList);
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
