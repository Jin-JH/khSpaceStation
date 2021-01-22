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

/**
 * Servlet implementation class SelectCalculateServlet
 */
@WebServlet("/searchCalculate.ss")
public class SearchCalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCalculateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String selectWord = request.getParameter("selectWord");
		String keyword = request.getParameter("keyword");
		
		ArrayList<CalculateInfo> ciList = new AdminService().searchCalculate(selectWord, keyword);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/pManage/pManageCalculateList.jsp");
		request.setAttribute("ciList", ciList);
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
