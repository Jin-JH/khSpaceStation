package ss.mango.admin.chart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ss.mango.admin.chart.model.service.ChartService;
import ss.mango.admin.chart.model.vo.Quarter;
import ss.mango.admin.chart.model.vo.SearchQuarter;

/**
 * Servlet implementation class ChartReservationCountServlet
 */
@WebServlet("/chartReservationCount.ss")
public class ChartReservationCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChartReservationCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String year = request.getParameter("searchYear");
		
		ArrayList<Quarter> searchJoin = new ChartService().quarterResCount(year);
		ArrayList<Quarter> searchEnd = new ChartService().quarterResCancleCount(year);
		
		SearchQuarter searchQuarter = new SearchQuarter();
		searchQuarter.setSearchJoin(searchJoin);
		searchQuarter.setSearchEnd(searchEnd);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		new Gson().toJson(searchQuarter,out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
