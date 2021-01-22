package ss.mango.admin.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.admin.chart.model.service.ChartService;
import ss.mango.admin.model.service.AdminService;

/**
 * Servlet implementation class AdminMainServlet
 */
@WebServlet("/adminMain.ss")
public class AdminMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String today = "today";
		String userCode = "u";
		String partnerCode = "p";
		char statusN = 'N';
		char statusY = 'Y';
		
		int todayUser = new AdminService().countMember(statusN, userCode, today);
		int allUser = new AdminService().countMember(statusN, userCode, "all");
		int todayEndUser = new AdminService().countMember(statusY, userCode, today);
		int allEndUser = new AdminService().countMember(statusY, userCode, "all");
		
		int todayPartner = new AdminService().countMember(statusN, partnerCode, today);
		int allPartner = new AdminService().countMember(statusN, partnerCode, "all");
		int todayEndPartner = new AdminService().countMember(statusY, partnerCode, today);
		int allEndPartner = new AdminService().countMember(statusY, partnerCode, "all");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String form = sdf.format(date);
		long [] resultArr = new long[4];
		
		for(int i=0; i<resultArr.length; i++) {
			int result = new ChartService().salesList(form,i);
			resultArr[i] = result;
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/adminMain.jsp");
		request.setAttribute("todayUser", todayUser);
		request.setAttribute("allUser", allUser);
		request.setAttribute("todayEndUser", todayEndUser);
		request.setAttribute("allEndUser", allEndUser);
		
		request.setAttribute("todayPartner", todayPartner);
		request.setAttribute("allPartner", allPartner);
		request.setAttribute("todayEndPartner", todayEndPartner);
		request.setAttribute("allEndPartner", allEndPartner);
		
		request.setAttribute("resultArr", resultArr);
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
