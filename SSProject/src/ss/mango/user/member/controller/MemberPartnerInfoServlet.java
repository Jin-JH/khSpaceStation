package ss.mango.user.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.user.member.model.service.MemberService;
import ss.mango.user.member.model.vo.CalculateInfo;
import ss.mango.user.member.model.vo.Member;
import ss.mango.user.member.model.vo.PartnerInfo;

/**
 * Servlet implementation class MemberPartnerInfoServlet
 */
@WebServlet("/MemberPartnerInfo.ss")
public class MemberPartnerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPartnerInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Member m1 = (Member)session.getAttribute("member");
		
		PartnerInfo pi = new MemberService().searchPartnerInfo(m1.getMemberCode());
		CalculateInfo ci = new MemberService().searchCalculateInfo(m1.getMemberCode());
		/*System.out.println(pi.getCeoName());
		System.out.println(ci.getCalBank());*/
		
		RequestDispatcher view = request.getRequestDispatcher("/views/user/mypage/myPage_ModifyPartnerInfo.jsp");
		request.setAttribute("PartnerInfo", pi);
		request.setAttribute("CalculateInfo", ci);
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
