package kr.or.ss.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.user.member.model.vo.Member;
import kr.or.ss.member.model.service.MemberService;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/MemberLogin.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memberId= request.getParameter("memberId");
		String memberPw= request.getParameter("memberPw");
		
		Member m = new MemberService().loginMember(memberId,memberPw);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		System.out.println("로그인 처리");
		if(m!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", m);
			out.println("<script>alert('로그인성공');</script>");
		}else {
			out.println("<script>alert('로그인실패 ID 또는 PW를 확인해주세요!');</script>");
		}
		out.println("<script>location.replace('/index.jsp');</script>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
