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
 * Servlet implementation class SearchUserListServlet
 */
@WebServlet("/userWhere.ss")
public class SearchUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }// SearchUserListServle

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
		}// if, else if
		
		UserPageData upd = new AdminService().selectUserWhere(selectWord, keyword, currentPage);
		int countUser = new AdminService().userSearchTotalCount(selectWord, keyword);
				
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/uManage/uManageUserSelectList.jsp");
		
		request.setAttribute("list", upd.getList());
		request.setAttribute("pageNavi", upd.getPageNavi());
		request.setAttribute("countUser", countUser);
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

}// SearchUserListServle
