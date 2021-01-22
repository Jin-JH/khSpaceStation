package ss.mango.user.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import ss.mango.admin.model.vo.Admin;
import ss.mango.user.member.model.service.MemberService;
import ss.mango.user.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/MemberLogin.ss")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginType = request.getParameter("loginType");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		Admin a = new MemberService().adminLoginMember(memberId, memberPw);
		Member m = new MemberService().loginMember(memberId, memberPw);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		PrintWriter out = response.getWriter();
		
		if(a!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin",a);
			out.println("<script>location.replace('/adminMain.ss');</script>");
		} else if(m!=null) {
			if(m.getMemberEndDate()!=null && m.getMemberEnd()=='N') {

				HttpSession session = request.getSession();
				session.setAttribute("member",m);
				out.println("<script>location.replace('/views/user/member/memberWithdrawLogin.jsp');</script>");
				
			} else if(m.getMemberEndDate()==null) {
				if((m.getMemberCode().substring(0,1).equals("u") && loginType.equals("user")) ||
						(m.getMemberCode().substring(0,1).equals("p") && loginType.equals("partner"))) {
					
					HttpSession session = request.getSession();
					session.setAttribute("member",m);
					out.println("<script>location.replace('/SpaceMainRecentInsert.ss');</script>");
					
				} else {
					
					out.println("<script>alert(\"가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.\");\r\n" + 
							"history.back(-1);</script>");
					
				}
			} else {
				out.println("<script>alert(\"'이거 수행 안됨!!');</script>");
			}
			
			/*if((m.getMemberEndDate()!=null && m.getMemberEnd()=='N') && (m.getMemberCode().substring(0,1).equals("u") && loginType.equals("user"))) {
				
				out.println("<script>location.replace('/views/user/member/memberWithdrawLogin.jsp');</script>");
				
			} else if((m.getMemberEndDate()!=null && m.getMemberEnd()=='N') && (m.getMemberCode().substring(0,1).equals("p") && loginType.equals("partner"))) {
				
				out.println("<script>location.replace('/views/user/member/memberWithdrawLogin.jsp');</script>");
				
			} else if(m.getMemberEndDate()==null && (m.getMemberCode().substring(0,1).equals("u") && loginType.equals("user")) ||
					(m.getMemberCode().substring(0,1).equals("p") && loginType.equals("partner"))) {
				
				HttpSession session = request.getSession();
				session.setAttribute("member",m);
				out.println("<script>location.replace('/SpaceMainRecentInsert.ss');</script>");
				
			} else {
				
				out.println("<script>alert(\"가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.\");\r\n" + 
						"history.back(-1);</script>");
				
			}*/
		} else {
			
			out.println("<script>alert(\"가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.\");\r\n" + 
					"history.back(-1);</script>");
			
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
