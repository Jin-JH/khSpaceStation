package ss.mango.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.admin.model.service.AdminService;
import ss.mango.admin.model.vo.Inquiry;
import ss.mango.admin.model.vo.InquiryAnswer;

/**
 * Servlet implementation class PartnerQuestionTextServlet
 */
@WebServlet("/partnerQuestionText.ss")
public class PartnerQuestionTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartnerQuestionTextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
		String pmqt = request.getParameter("pmqt");
		String result = request.getParameter("result");
		
		InquiryAnswer ia = null;
		
		Inquiry inquiry = new AdminService().partnerQuestion(inquiryNo);
		if(inquiry.getInquiryAns()=='Y') {
			ia = new AdminService().selectOneInquiryAnswer(inquiryNo);
		}
		
		RequestDispatcher view = null;
		if(pmqt==null) {
			view = request.getRequestDispatcher("/views/admin/pManage/pManageQuestionText.jsp");
		}else {
			view = request.getRequestDispatcher("/views/admin/pManage/pManageQuestionAnswer.jsp?result="+result);
		}
		
		request.setAttribute("inquiry", inquiry);
		request.setAttribute("inquiryAnswer", ia);
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
