package kr.or.ss.space.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.user.member.model.vo.Member;
import kr.or.ss.space.model.service.SpaceService;
import kr.or.ss.space.model.vo.PartnerSpace;
import kr.or.ss.space.model.vo.SpaceCost;

/**
 * Servlet implementation class WeeklyStatistics
 */
@WebServlet("/weekly.do")
public class WeeklyStatistics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeeklyStatistics() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session에서 membercode 가져오기
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("member");
		String memberCode = m.getMemberCode();
		
		//사업자별 공간 등록 현황
		ArrayList<PartnerSpace> psList = new SpaceService().partnerSpace(memberCode);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/statisticsWeekly.jsp");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		 
		if(!(psList.isEmpty())) {
			PartnerSpace ps1 = psList.get(0);
			//사업자(공간번호)별 해당 예약 금액(월간)
			ArrayList<SpaceCost> scList = new SpaceService().spaceCostW(ps1.getSpaceNo());
			if(!(scList.isEmpty())) {
				request.setAttribute("scList", scList);
				
			} else {
				PrintWriter out = response.getWriter();
				out.print("<script>alert('등록된 예약정보가 존재하지 않습니다.')</script>");
				out.println("<script>location.replace('history.back(-1);');</script>");
			}
			request.setAttribute("psList", psList);
			
		} else {
			PrintWriter out = response.getWriter();
			out.print("<script>alert('등록된 공간이 존재하지 않습니다.')</script>");
			out.println("<script>location.replace('history.back(-1);');</script>");
		}
		
		view.forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
