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
import kr.or.ss.space.model.vo.Space;
import kr.or.ss.space.model.vo.SubSpace;

/**
 * Servlet implementation class AllSpaceSelectServlet
 */
@WebServlet("/allSpaceSelect.do")
public class AllSpaceSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllSpaceSelectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. Servlet에서는 session 수동 연결
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("member");
		String memberCode = m.getMemberCode();
		
		// 2.메인 공간 정보 불러오기
		Space s = new SpaceService().selectAllSpace(memberCode);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/spaceRegistration.jsp");
		
		if (s!=null) {
			ArrayList<SubSpace> subList = new SpaceService().selectSubSpaceAll(s.getSpaceNo());
			if(!(subList.isEmpty())) {
				request.setAttribute("subList", subList);
			}
			request.setAttribute("space", s);
		} else {
			
		}

		view.forward(request, response);

		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
