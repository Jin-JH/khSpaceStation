	package ss.mango.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.admin.model.service.AdminService;
import ss.mango.admin.model.vo.AdminListPageData;

/**
 * Servlet implementation class AdminSelectAllServlet
 */
@WebServlet(name = "AdminAllSelectServlet", urlPatterns = { "/adminAllSelect.ss" })
public class SelectAllAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }// AdminSelectAllServlet

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage;
		if(request.getParameter("currentPage")==null){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		AdminListPageData alpd = new AdminService().selectAdminAll(currentPage);
				
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/aManage/aManageAdminList.jsp");
		request.setAttribute("list", alpd.getList());
		request.setAttribute("pageNavi", alpd.getPageNavi());
		view.forward(request, response);
				
	}// doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}// doPost

}// AdminSelectAllServlet
