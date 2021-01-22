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
import ss.mango.admin.model.vo.User;

/**
 * Servlet implementation class SignOutUserServlet
 */
@WebServlet("/searchSignOutUser.ss")
public class SearchSignOutUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSignOutUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }// SignOutUserServlet

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String selectWord = request.getParameter("selectWord");
		String keyword = request.getParameter("keyword");
				
		ArrayList<User> list = new AdminService().searchSignOutUser(selectWord, keyword);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/uManage/uManageSignOutSelect.jsp");
		request.setAttribute("list", list);
		request.setAttribute("selectWord",selectWord);
		request.setAttribute("keyword",keyword);
		view.forward(request, response);
		
	}// doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}// doPost

}// SignOutUserServlet
