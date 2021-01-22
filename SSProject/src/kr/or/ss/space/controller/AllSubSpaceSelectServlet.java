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
import kr.or.ss.space.model.vo.SubSpace;

/**
 * Servlet implementation class AllSubSpaceSelectServlet
 */
@WebServlet("/allSubSpaceSelect.do")
public class AllSubSpaceSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllSubSpaceSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("member");
		String memberCode = m.getMemberCode();
		
		ArrayList<SubSpace> list = new SpaceService().selectSubSpaceAll(memberCode);
		if(!(list.isEmpty())) {
			RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/spaceRegistration.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		} else {
			response.sendRedirect("/views/partner/content/spaceRegistration.jsp");
		}
		
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
