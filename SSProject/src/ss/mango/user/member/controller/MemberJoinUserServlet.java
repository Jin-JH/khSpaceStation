package ss.mango.user.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.user.member.model.service.MemberService;
import ss.mango.user.member.model.vo.Member;

/**
 * Servlet implementation class MemberJoinUserServlet
 */
@WebServlet("/MemberJoinUser.ss")
public class MemberJoinUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		Member m = new Member();
		try {
			String memberName = request.getParameter("memberName");
			String memberId = request.getParameter("memberId");
			String memberPw = request.getParameter("memberPw");
			String tel_input_01 = request.getParameter("tel_input_01");
			String tel_input_02 = request.getParameter("tel_input_02");
			String tel_input_03 = request.getParameter("tel_input_03");
			String memberphone = tel_input_01 + tel_input_02 + tel_input_03;
			String memberEmail = request.getParameter("memberEmail");
			
			m.setMemberName(memberName);
			m.setMemberId(memberId);
			m.setMemberPw(memberPw);
			m.setMemberPhone(memberphone);
			m.setMemberEmail(memberEmail);
			
			Member mCheck = new MemberService().dupCheckIdMember(memberId);
			int result = new MemberService().joinUser(m);
			
			if(mCheck!=null) {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8"); 
				
				PrintWriter out = response.getWriter();
				
				out.println("<script>alert('이미 존재하는 ID입니다.');</script>");
				out.println("<script>history.back(-1);</script>");
			} else if(result > 0) {
				//response.sendRedirect("/views/user/member/memberJoinSuccess.jsp");
				RequestDispatcher view = request.getRequestDispatcher("/views/user/member/memberJoinSuccess.jsp");
				view.forward(request, response);
			} else {
				//response.sendRedirect("/views/user/member/memberJoinFail.jsp");
				RequestDispatcher view = request.getRequestDispatcher("/views/user/member/memberJoinFail.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher view = request.getRequestDispatcher("/views/user/member/memberJoinFail.jsp");
			view.forward(request, response);
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
