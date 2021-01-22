package kr.or.ss.space.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ss.space.model.service.SpaceService;
import kr.or.ss.space.model.vo.MeetingRoomPageData;

/**
 * Servlet implementation class MeetingRoomManagementServlet
 */
@WebServlet("/boardAllListPage.do")
public class MeetingRoomManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingRoomManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage; 
		if(request.getParameter("currentPage")==null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		
		MeetingRoomPageData mrpd = new SpaceService().selectAllBoardPage(currentPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/meetingRoomManagement.jsp");
		request.setAttribute("MeetingRoomPageData", mrpd);
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
