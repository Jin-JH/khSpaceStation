package ss.mango.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.admin.model.service.AdminService;
import ss.mango.admin.model.vo.Admin;

/**
 * Servlet implementation class ApprovalSignOutServlet
 */
@WebServlet("/apprSearchSignOutPartner.ss")
public class ApprovalSearchSignOutPartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovalSearchSignOutPartnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String adminCode = ((Admin)session.getAttribute("admin")).getAdminCode();
				
		//jsp에서 넘어온 값 저장(memberEnd)
		String memberId = request.getParameter("memberId");
		String appr = request.getParameter("appr");
		String selectWord = request.getParameter("selectWord");
		String keyword = request.getParameter("keyword");
		int result;
		String aprovType;
		
			if(appr.equals("승인")) {
				result = new AdminService().memberApprovalSignOut(memberId);
				aprovType="사업자 탈퇴 승인";
			} else {
				result = new AdminService().memberNoSignOut(memberId);
				aprovType="사업자 탈퇴 거절";
			}//if, else
			
			if(result>0) {
				//상태변경이 정상적으로 처리되었다면
				new AdminService().ApprovalRecord(adminCode, aprovType);
						
				RequestDispatcher view = request.getRequestDispatcher("/searchSignOut.ss");
				request.setAttribute("selectWord", selectWord );
				request.setAttribute("keyword", keyword );
				view.forward(request, response);
												
			} else {
				//상태변경이 정상적으로 처리되지않았다면				
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				
				PrintWriter out = response.getWriter();
				out.println("<script>alert('회원 상태변경 실패(지속적인 문제 발생시 개발자에게 문의해주세요)');</script>");
				out.println("<script>location.replace('/signOutPartner.ss');</script>");		
			}//if, else
			
	}// doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
