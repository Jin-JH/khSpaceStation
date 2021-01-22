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
import ss.mango.user.member.model.vo.CalculateInfo;
import ss.mango.user.member.model.vo.Member;
import ss.mango.user.member.model.vo.PartnerInfo;

/**
 * Servlet implementation class MemberJoinPartnerServlet
 */
@WebServlet("/MemberJoinPartner.ss")
public class MemberJoinPartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinPartnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Member m = new Member();
		PartnerInfo p = new PartnerInfo();
		CalculateInfo c = new CalculateInfo();
		
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
			
			
			String ceoName = request.getParameter("ceoName");
			String businessName = request.getParameter("businessName"); 
			long businessLicenseNumber = Integer.parseInt(request.getParameter("businessLicenseNumber"));
			String partner_tel_input_01 = request.getParameter("partner_tel_input_01");
			String partner_tel_input_02 = request.getParameter("partner_tel_input_02");
			String partner_tel_input_03 = request.getParameter("partner_tel_input_03");
			String ceoPhone = partner_tel_input_01 + partner_tel_input_02 + partner_tel_input_03;
			String address = request.getParameter("address");
			String detailAddress = request.getParameter("detailAddress");
			String businessAddress = address + ", " + detailAddress;
			String businessEmail = request.getParameter("businessEmail");
			
			p.setCeoName(ceoName);
			p.setBusinessName(businessName);
			p.setBusinessLicenseNumber(businessLicenseNumber);
			p.setCeoPhone(ceoPhone);
			p.setBusinessAddress(businessAddress);
			p.setBusinessEmail(businessEmail);
			
			
			String calBank = request.getParameter("calBank");
			String calAccount = request.getParameter("calAccount");
			String calHolder = request.getParameter("calHolder");
			
			c.setCalBank(calBank);
			c.setCalAccount(calAccount);
			c.setCalHolder(calHolder);
			
			
			Member mCheck = new MemberService().dupCheckIdMember(memberId);
			
			int result = new MemberService().joinPartner(m);
			
			Member selectMember = new MemberService().selectMember(memberId);
			System.out.print(result);
			if(mCheck!=null) {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8"); 
				
				PrintWriter out = response.getWriter();
				
				out.println("<script>alert('이미 존재하는 ID입니다.');</script>");
				out.println("<script>history.back(-1);</script>");
			} else if(result > 0) {
				new MemberService().joinPartnerInfo(selectMember, p);
				new MemberService().joinCalculateInfo(selectMember, c);
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
