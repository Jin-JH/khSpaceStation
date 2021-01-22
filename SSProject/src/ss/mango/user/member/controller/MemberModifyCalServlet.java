package ss.mango.user.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

/**
 * Servlet implementation class MemberModifyCalServlet
 */
@WebServlet("/MemberModifyCal.ss")
public class MemberModifyCalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberModifyCalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		Member m = (Member)session.getAttribute("member");
		
		String calBank = request.getParameter("calBank");
		String calAccount = request.getParameter("calAccount");
		String calHolder = request.getParameter("calHolder");
		
		CalculateInfo ci = new CalculateInfo();
		ci.setMemberCode(m.getMemberCode());
		ci.setCalBank(calBank);
		ci.setCalAccount(calAccount);
		ci.setCalHolder(calHolder);
		
		int result = new MemberService().updateCalculate(ci);
		
		if(result > 0) {
			RequestDispatcher view = request.getRequestDispatcher("/views/user/mypage/myPage_ModifyCalculateInfoSuccess.jsp");
			request.setAttribute("CalculateInfo",ci);
			view.forward(request, response);
		} else {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('사업자정보 변경에 실패하였습니다. 지속적인 오류 발생시 관리자에게 문의해주세요');</script>");
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
