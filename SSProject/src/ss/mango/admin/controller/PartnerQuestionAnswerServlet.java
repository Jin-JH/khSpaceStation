package ss.mango.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.admin.model.service.AdminService;
import ss.mango.admin.model.vo.Admin;
import ss.mango.admin.model.vo.InquiryAnswer;

/**
 * Servlet implementation class PartnerQuestionAnswerServlet
 */
@WebServlet("/partnerQuestionAnswer.ss")
public class PartnerQuestionAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartnerQuestionAnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
		String answerTitle = request.getParameter("answerTitle");
		String answerContent = request.getParameter("answerContent");
		
		HttpSession session = request.getSession();
		String adminId = ((Admin)session.getAttribute("admin")).getAdminId();
		
		InquiryAnswer ia = new InquiryAnswer();
		ia.setAdminId(adminId);
		ia.setAnswerContent(answerContent);
		ia.setAnswerTitle(answerTitle);
		ia.setInquiryNo(inquiryNo);
		
		int result = new AdminService().insertInquiryAnswer(ia);
		
		RequestDispatcher view = request.getRequestDispatcher("/partnerQuestionText.ss?pmqt=pmqt&inquiryNo="+inquiryNo);
		if(result>0) {
			request.setAttribute("result", true);
		}else {
			request.setAttribute("result", false);
		}
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
