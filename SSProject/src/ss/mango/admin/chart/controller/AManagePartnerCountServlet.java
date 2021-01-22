package ss.mango.admin.chart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.admin.chart.model.service.ChartService;
import ss.mango.admin.chart.model.vo.Quarter;
import ss.mango.admin.model.vo.Partner;

/**
 * Servlet implementation class AManagePartnerCountServlet
 */
@WebServlet("/aManagePartnerCount.ss")
public class AManagePartnerCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AManagePartnerCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		
		ArrayList<Partner> list = new ChartService().recentPartnerList();
		ArrayList<Quarter> joinQuarter = new ChartService().quarterJoinPartnerCount(year);
		ArrayList<Quarter> endQuarter = new ChartService().quarterEndPartnerCount(year);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/aManage/aManagePartnerCount.jsp");
		request.setAttribute("list", list);
		request.setAttribute("joinQuarter", joinQuarter);
		request.setAttribute("endQuarter", endQuarter);
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
