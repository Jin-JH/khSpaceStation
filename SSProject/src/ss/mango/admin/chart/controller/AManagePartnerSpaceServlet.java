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
import ss.mango.admin.model.vo.SpaceRegistration;

/**
 * Servlet implementation class AManagePartnerSpaceServlet
 */
@WebServlet("/aManagePartnerSpace.ss")
public class AManagePartnerSpaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AManagePartnerSpaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		
		ArrayList<SpaceRegistration> list = new ChartService().recentSpaceRegistrationList();
		ArrayList<Partner> pList = new ArrayList<Partner>();
		
		for(SpaceRegistration sr : list) {
			Partner p = new ChartService().recentPartnerList(sr.getMemberCode());
			
			pList.add(p);
		}
		
		ArrayList<Quarter> quarter = new ChartService().quarterSpaceRegistrationCount(year);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/aManage/aManagePartnerSpace.jsp");
		request.setAttribute("list", list);
		request.setAttribute("pList", pList);
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
