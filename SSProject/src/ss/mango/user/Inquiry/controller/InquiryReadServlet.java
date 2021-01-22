package ss.mango.user.Inquiry.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.user.Inquiry.model.service.InquiryService;
import ss.mango.user.Inquiry.model.vo.Inquiry;
import ss.mango.user.Inquiry.model.vo.InquiryAnswer;
import ss.mango.user.member.model.vo.Member;

/**
 * Servlet implementation class InquiryReadServlet
 */
@WebServlet("/InquiryRead.ss")
public class InquiryReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		String memberId = m.getMemberId();
		
		Inquiry inqu = new InquiryService().readInquiry(inquiryNo,memberId);
		InquiryAnswer ia = new InquiryService().answerInquiry(inquiryNo);
		
		if(inqu != null) {
			RequestDispatcher view = request.getRequestDispatcher("/views/user/mypage/myPage_Inquiry_Read.jsp");
			request.setAttribute("Inquiry", inqu);
			request.setAttribute("InquiryAnswer", ia);
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/views/user/mypage/myPage_Inquiry_Read_Fail.jsp");
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
