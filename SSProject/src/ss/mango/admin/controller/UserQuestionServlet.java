package ss.mango.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.admin.model.service.AdminService;
import ss.mango.admin.model.vo.InquiryPageData;

/**
 * Servlet implementation class UserQuestionServlet
 */
@WebServlet("/userQuestion.ss")
public class UserQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String inquiryState = request.getParameter("inquiryState");
		int currentPage;
		
		if(inquiryState==null || inquiryState.equals("all") || inquiryState.equals("A")) {
			inquiryState = "A";
		}
		else if(inquiryState.equals("wait")) {
			inquiryState = "N";
		}else {
			inquiryState = "Y";
		}
		
		if(request.getParameter("currentPage")==null)
		{
			currentPage = 1;
		}else
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		InquiryPageData ipd = new AdminService().userQuestion(inquiryState, currentPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/uManage/uManageQuestion.jsp");
		request.setAttribute("list", ipd.getList());
		request.setAttribute("pageNavi", ipd.getPageNavi());
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
