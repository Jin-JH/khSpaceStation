package ss.mango.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.admin.model.service.AdminService;
import ss.mango.admin.model.vo.UserPageData;

/**
 * Servlet implementation class SelectAllUserServlet
 */
@WebServlet("/selectAllUser.ss")
public class SelectAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }// SelectAllUserServlet

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage;
		if(request.getParameter("currentPage")==null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}// if, else
		
		UserPageData upd = new AdminService().selectUserAll(currentPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/uManage/uManageUserList.jsp");
		request.setAttribute("list",upd.getList());
		request.setAttribute("pageNavi",upd.getPageNavi());
		
		view.forward(request, response);
				
	}// doGet	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}// doPost

}// SelectAllUserServlet
