package ss.mango.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.admin.model.service.AdminService;
import ss.mango.admin.model.vo.PartnerListPageData;

/**
 * Servlet implementation class SearchPartnerListServlet
 */
@WebServlet("/searchPartnerList.ss")
public class SearchPartnerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPartnerListServlet() {
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
		
		int currentPage;
		if(request.getParameter("currentPage")==null){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		PartnerListPageData plpd = new AdminService().selectPartnerWhere(selectWord, keyword, currentPage);
		int countPartner = new AdminService().partnerSearchTotalCount(selectWord, keyword); //사업자 검색결과 개수
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/pManage/pManagePartnerSelectList.jsp");
		request.setAttribute("list", plpd.getList());
		request.setAttribute("pageNavi", plpd.getPageNavi());
		request.setAttribute("countPartner", countPartner);
		request.setAttribute("selectWord", selectWord);
		request.setAttribute("keyword", keyword);
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
