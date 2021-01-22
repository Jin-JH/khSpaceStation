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
import ss.mango.user.member.model.vo.Member;
import ss.mango.user.member.model.vo.PartnerInfo;

/**
 * Servlet implementation class MemberModifyPartnerInfoServlet
 */
@WebServlet("/MemberModifypartnerInfo.ss")
public class MemberModifyPartnerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberModifyPartnerInfoServlet() {
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
		
		if(m!=null) {
			String memberCode = m.getMemberCode();
			String ceoName = request.getParameter("ceoName");
			String businessName = request.getParameter("businessName");
			int businessLicenseNumber = Integer.parseInt(request.getParameter("businessLicenseNumber"));
			String ceoPhone = request.getParameter("ceoPhone");
			String businessEmail = request.getParameter("businessEmail");
			
			PartnerInfo pi = new PartnerInfo();
			pi.setMemberCode(memberCode);
			pi.setCeoName(ceoName);
			pi.setBusinessName(businessName);
			pi.setBusinessLicenseNumber(businessLicenseNumber);
			pi.setCeoPhone(ceoPhone);
			pi.setBusinessEmail(businessEmail);
			
			int result = new MemberService().updatePartnerInfo(pi);
			
			if(result > 0) {
				RequestDispatcher view = request.getRequestDispatcher("/views/user/mypage/myPage_ModifyPartnerInfoSuccess.jsp");
				request.setAttribute("PartnerInfo",pi);
				view.forward(request, response);
			} else {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				
				PrintWriter out = response.getWriter();
				out.println("<script>alert('사업자정보 변경에 실패하였습니다. 지속적인 오류 발생시 관리자에게 문의해주세요');</script>");
				out.println("<script>history.back(-1);</script>");
			}
			
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인을 해주세요.');</script>");
			out.println("<script>location.replace('/views/user/member/memberLogin.jsp');</script>");
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
