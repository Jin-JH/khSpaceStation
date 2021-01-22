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
 * Servlet implementation class MemberDupCheckId
 */
@WebServlet("/MemberDupCheckId.ss")
public class MemberDupCheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDupCheckId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		
		Member m = new MemberService().dupCheckIdMember(memberId);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		PrintWriter out = response.getWriter();
		
		if(m!=null) {
			out.println("<script>alert('이미 존재하는 ID입니다.');</script>");
			out.println("<script>history.back(-1);</script>");
		} else {
			out.println("<script>alert('사용 가능한 ID입니다.');</script>");
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
