package kr.or.ss.space.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ss.space.model.service.SpaceService;
import kr.or.ss.space.model.vo.MRManagement;
import kr.or.ss.space.model.vo.MeetingRoomPageData;

/**
 * Servlet implementation class MRManagementChange
 */
@WebServlet("/MRManagementChange.do")
public class MRManagementChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MRManagementChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		System.out.println("여기까지 오니?");
		String [] checkValues = request.getParameterValues("check");
	//	String check="'"+checkValues[0]+"'";
		//for(int i =1; i<checkValues.length;i++) {
		//	check=check+", '" + checkValues[i]+"'";
			
		//}
		int result =new SpaceService().updateSpace(checkValues);
		System.out.println(checkValues);
		if(result>0) {
			response.sendRedirect("/boardAllListPage.do");
		}else {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out=response.getWriter();
			out.println("<script>alert('회원정보실패(지송문제시 관리자에게 문의해!)');</script>");
			out.println("<script>location.replace('/views/partner/content/meetingRoomManagement.jsp');</script>");
		}
		
		}
	//	ArrayList<MRManagement> list=new SpaceService().selectAllList();
	//	System.out.println("서블릿확인용"+ list);
	//	for(MRManagement mrm:list) {
		//	System.out.println(mrm.getSubNO());
		//	System.out.println(mrm.getSubOpen());
		//}
	//	System.out.println("후후"+list.get(1).getSubNO());
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
