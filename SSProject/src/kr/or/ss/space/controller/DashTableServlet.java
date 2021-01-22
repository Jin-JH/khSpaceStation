package kr.or.ss.space.controller;

import java.io.IOException;
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
import kr.or.ss.space.model.vo.DashCost;
import kr.or.ss.space.model.vo.PartnerSpace;

/**
 * Servlet implementation class DashTableServlet
 */
@WebServlet("/dashTable.do")
public class DashTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// session에서 membercode 가져오기
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("member");
		String memberCode = m.getMemberCode();

		// 사업자별 공간 등록 현황
		ArrayList<PartnerSpace> psList = new SpaceService().partnerSpace(memberCode);

		RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/mainPartnerPage.jsp");
		if (!(psList.isEmpty())) {
			PartnerSpace ps1 = psList.get(0);
			// 사업자(공간번호)별 해당 예약 금액(월간)
			DashCost dc = new SpaceService().spaceCostDash(ps1.getSpaceNo());
			if (dc!=null) {
				request.setAttribute("dc", dc);
				System.out.println(dc.getDashCost());
			} else {
				
			}
		} else {
			
		}
		
		view.forward(request, response);
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
