package ss.mango.user.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.user.member.model.service.MemberService;
import ss.mango.user.member.model.vo.Member;

/**
 * Servlet implementation class MemberModifyPartnerServlet
 */
@WebServlet("/MemberModifyPartner.ss")
public class MemberModifyPartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberModifyPartnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String memberName = ((Member)session.getAttribute("member")).getMemberName();
		String memberId = ((Member)session.getAttribute("member")).getMemberId();
		String memberPw = request.getParameter("password");
		String memberEmail = request.getParameter("email");
		String tel_01 = request.getParameter("tel_01");
		String tel_02 = request.getParameter("tel_02");
		String tel_03 = request.getParameter("tel_03");
		String memberPhone = tel_01 + tel_02 + tel_03;
		
		Member m = new Member();
		m.setMemberName(memberName);
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		m.setMemberEmail(memberEmail);
		m.setMemberPhone(memberPhone);

		int result = new MemberService().updateUser(m);
		
		if(result > 0) {
			session.setAttribute("member",m);
			response.sendRedirect("/MemberPartnerMyPageLoad.ss");
		} else {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원정보 변경 실패하였습니다. 지속적인 오류 발생시 관리자에게 문의해주세요');</script>");
			out.println("<script>history.back(-1);</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
