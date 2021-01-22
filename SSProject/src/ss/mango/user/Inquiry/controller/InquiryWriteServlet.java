package ss.mango.user.Inquiry.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.user.Inquiry.model.service.InquiryService;
import ss.mango.user.member.model.vo.Member;

/**
 * Servlet implementation class InquiryWriteServlet
 */
@WebServlet("/Inquirywrite.ss")
public class InquiryWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String inquiryCartegory = request.getParameter("inquiryCartegory");
		
		if(inquiryCartegory.equals("예약관련")) {
			inquiryCartegory = "RESERVATION"; 
		} else if(inquiryCartegory.equals("취소관련")) {
			inquiryCartegory = "CANCEL";
		} else if(inquiryCartegory.equals("기타문의")) {
			inquiryCartegory = "ETC";
		}
		
		String inquiryTitle = request.getParameter("inquiryTitle");
		String inquiryContent = request.getParameter("inquiryContent");
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		String memberId = m.getMemberId();
		
		int result = new InquiryService().insertInquiry(inquiryCartegory, inquiryTitle, inquiryContent, memberId);
		
		if(result > 0) {
			if(m.getMemberCode().substring(0,1).equals("u")) {
				RequestDispatcher view = request.getRequestDispatcher("/views/user/mypage/myPage_Inquiry_Write_Success.jsp");
				view.forward(request, response);
			} else {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=UTF-8");
				
				PrintWriter out = response.getWriter();
				
				out.println("<script>location.replace('/InquiryPartnerListPage.ss');</script>");
			}
				
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/views/user/mypage/myPage_Inquiry_Write_Fail.jsp");
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
