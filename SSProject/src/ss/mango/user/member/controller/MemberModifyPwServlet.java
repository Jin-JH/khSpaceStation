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
 * Servlet implementation class MemberModifyPwServlet
 */
@WebServlet("/memberModifyPw.ss")
public class MemberModifyPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberModifyPwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//찾은 비밀번호가 있는 페이지에서 세션값 가져오기 
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("userNo");
		String memberCode = m.getMemberCode();
		
		//이전 페이지에서 보내준 값(새로운 비밀번호) 가져오기 
		String newPw = request.getParameter("newPw");
		String newPwRe = request.getParameter("newPwRe");
				
		//로직 구현
		int result = new MemberService().updatePw(newPw,memberCode);
		if(result>0)
		{	
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
						
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호가 정상적으로 변경되었습니다. 로그인 페이지에서 새롭게 로그인해주십시오.');</script>");
			out.println("<script>location.replace('/views/user/member/memberLogin.jsp');</script>");
			
		}else {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
					
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호 변경이 실패하였습니다. 지속적인 오류 발생시 관리자에게 문의주세요');</script>");
		    out.println("<script>history.back(-1);</script>");
		    System.out.println("2");
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
