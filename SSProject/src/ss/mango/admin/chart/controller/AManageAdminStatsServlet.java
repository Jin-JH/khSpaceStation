package ss.mango.admin.chart.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.admin.chart.model.service.ChartService;
import ss.mango.admin.chart.model.vo.Quarter;

/**
 * Servlet implementation class AManageAdminStatsServlet
 */
@WebServlet("/aManageAdminStats.ss")
public class AManageAdminStatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AManageAdminStatsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String form = sdf.format(date);
		
		long [] resultArr = new long[4];
		
		for(int i=0; i<resultArr.length; i++) {
			int result = new ChartService().salesList(form,i);
			resultArr[i] = result;
		}
		
		String year = form.substring(2,4);
		ArrayList<Quarter> quarter = new ChartService().quarterSalesCount(year);
		
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/aManage/aManageAdminStats.jsp");
		request.setAttribute("resultArr", resultArr);
		request.setAttribute("quarter", quarter);
		
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
