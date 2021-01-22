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
import ss.mango.admin.model.vo.ResInfo;
import ss.mango.admin.model.vo.Reservation;
import ss.mango.admin.model.vo.SpaceRegistration;

/**
 * Servlet implementation class AManageUserReservationServlet
 */
@WebServlet("/aManageUserReservation.ss")
public class AManageUserReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AManageUserReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		
		ArrayList<Reservation> list = new ChartService().recentResList();
		ArrayList<ResInfo> riList = new ArrayList<ResInfo>();
		ArrayList<SpaceRegistration> srList = new ArrayList<SpaceRegistration>();
		
		for(Reservation r : list) {
			ResInfo ri = new ChartService().recentResList(r.getResInfoCode());
			SpaceRegistration sr = new ChartService().recentResSpaceList(r.getSubNo());
			riList.add(ri);
			srList.add(sr);
		}

		ArrayList<Quarter> joinQuarter = new ChartService().quarterResCount(year);
		ArrayList<Quarter> endQuarter = new ChartService().quarterResCancleCount(year);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/aManage/aManageUserReservation.jsp");
		
		request.setAttribute("list", list);
		request.setAttribute("riList", riList);
		request.setAttribute("srList", srList);
		request.setAttribute("joinQuarter",joinQuarter);
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
