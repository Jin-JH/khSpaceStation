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
import ss.mango.user.Inquiry.model.vo.InquiryPageData;
import ss.mango.user.member.model.vo.Member;

/**
 * Servlet implementation class InquiryListPageServlet
 */
@WebServlet("/InquiryListPage.ss")
public class InquiryListPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryListPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int presentPage;
		
		if(request.getParameter("presentPage")==null) {
			presentPage = 1;
		} else {
			presentPage = Integer.parseInt(request.getParameter("presentPage"));
		}
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		String memberId = m.getMemberId();
		
		InquiryPageData ipd = new InquiryService().selectAllInquiryPage(presentPage,memberId);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/user/mypage/myPage_Inquiry.jsp");
		request.setAttribute("pageData", ipd);
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
