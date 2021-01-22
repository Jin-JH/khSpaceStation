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
 * Servlet implementation class AdminWhereServlet
 */
@WebServlet("/adminWhere.ss")
public class SearchAdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAdminListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }// AdminWhereServlet

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String selectWord = request.getParameter("selectWord");
		String keyword = request.getParameter("keyword");
		
		int currentPage;
		if(request.getParameter("currentPage")==null){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		AdminListPageData alpd = new AdminService().selectAdminWhere(selectWord, keyword, currentPage);
		int countAdmin = new AdminService().adminSearchTotalCount(selectWord, keyword); //관리자 검색결과 개수
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/aManage/aManageAdminSelectList.jsp");
		request.setAttribute("list", alpd.getList());
		request.setAttribute("pageNavi", alpd.getPageNavi());
		request.setAttribute("countAdmin", countAdmin);
		request.setAttribute("selectWord", selectWord);
		request.setAttribute("keyword", keyword);
		view.forward(request, response);
		
	}// doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}// doPost

}// AdminWhereServlet
