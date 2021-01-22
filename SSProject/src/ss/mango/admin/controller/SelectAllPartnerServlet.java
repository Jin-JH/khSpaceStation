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
 * Servlet implementation class SelectAllPartnerServlet
 */
@WebServlet("/selectAllPartner.ss")
public class SelectAllPartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllPartnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		PartnerListPageData plpd = new AdminService().selectPartnerAll(currentPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/pManage/pManagePartnerList.jsp");
		request.setAttribute("list",plpd.getList());
		request.setAttribute("pageNavi",plpd.getPageNavi());
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
