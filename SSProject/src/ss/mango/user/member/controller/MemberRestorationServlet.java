package ss.mango.user.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.user.member.model.service.MemberService;
import ss.mango.user.member.model.vo.Member;

/**
 * Servlet implementation class MemberRestorationServlet
 */
@WebServlet("/MemberRestoration.ss")
public class MemberRestorationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRestorationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String restoreId = request.getParameter("restoreId");
		String restorePw = request.getParameter("restorePw");
		
		Member m = new Member();
		m.setMemberId(restoreId);
		m.setMemberPw(restorePw);
		
		int result = new MemberService().restoreMember(restoreId, restorePw);
		
		if(result > 0) {
			RequestDispatcher view = request.getRequestDispatcher("/views/user/member/memberWithdrawRestoreSuccess.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/views/user/member/memberWithdrawRestoreFail.jsp");
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
