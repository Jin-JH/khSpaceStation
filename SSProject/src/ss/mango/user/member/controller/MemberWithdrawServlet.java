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
 * Servlet implementation class MemberWithdrawServlet
 */
@WebServlet("/MemberWithdraw.ss")
public class MemberWithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberWithdrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String withdrawPw = request.getParameter("withdrawPw");
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		
		if(withdrawPw.equals(m.getMemberPw())) {
			String memberId = m.getMemberId();
			
			int result = new MemberService().withdrawUser(memberId);
			
			response.setCharacterEncoding("UTF-8");;
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			if(result > 0) {
				out.println("<script>alert('탈퇴요청이 완료되었습니다. 탈퇴까지는 2~4영업일이 소요됩니다.');</script>");
				session.invalidate();
				out.println("<script>location.replace('/index.jsp');</script>");
			} else {
				out.println("<script>alert('오류가 발생되었습니다. 지속적인 문제 발생시 관리자에게 문의해주세요.');</script>");
				out.println("<script>history.back(-1);</script>");
			}
		} else {
			response.setCharacterEncoding("UTF-8");;
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.println("<script>alert('비밀번호가 일치하지 않습니다');</script>");
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
