package ss.mango.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.admin.model.service.AdminService;
import ss.mango.admin.model.vo.Admin;

/**
 * Servlet implementation class CalculateApproval
 */
@WebServlet(name = "CalculateApprovalServlet", urlPatterns = { "/approvalCalculateApproval.ss" })
public class ApprovalCalculateApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovalCalculateApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }// CalculateApproval

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String adminCode = ((Admin)session.getAttribute("admin")).getAdminCode();	
		
		String memberCode = request.getParameter("memberCode");
		String appr = request.getParameter("appr");				
		int allCost = Integer.parseInt(request.getParameter("allCost"));
						
		double calCost = allCost*0.9;
		double feeCost = allCost*0.1;
		int result;
		String aprovType;
		
		if(appr.equals("정산")) {
			result = new AdminService().RecordCalculate(adminCode,memberCode,calCost,feeCost);
			aprovType="사업자 정산 완료";
			
				if(result>0) {
					//상태변경이 정상적으로 처리되었다면
					response.sendRedirect("/calculateApproval.ss");
					new AdminService().ApprovalRecord(adminCode, aprovType);
													
				} else {
					//상태변경이 정상적으로 처리되지않았다면				
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=UTF-8");
					
					PrintWriter out = response.getWriter();
					out.println("<script>alert('정산 기록 실패(지속적인 문제 발생시 개발자에게 문의해주세요)');</script>");
					out.println("<script>location.replace('/calculateApproval.ss');</script>");		
				}//if, else
			
			}//if
		
		
		
	}// doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}// doPost 

}// CalculateApproval
