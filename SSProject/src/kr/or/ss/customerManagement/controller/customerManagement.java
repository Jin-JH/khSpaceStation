package kr.or.ss.customerManagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ss.customerManagement.model.service.CustomerManagementService;
import kr.or.ss.customerManagement.model.vo.CMpageData;

/**
 * Servlet implementation class customerManagement
 */
@WebServlet("/customerManagement.do")
public class customerManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage; // 현재페이지 값 저장하는 변수
		if(request.getParameter("currentPage")==null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		CMpageData cmpd= new CustomerManagementService().selectAllBoardPage(currentPage);
		
		RequestDispatcher view=request.getRequestDispatcher("/views/partner/content/customerManagement.jsp");
		request.setAttribute("pageData", cmpd);
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
