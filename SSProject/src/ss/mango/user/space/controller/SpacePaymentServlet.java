package ss.mango.user.space.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.user.member.model.vo.Member;
import ss.mango.user.space.model.service.SpaceService;
import ss.mango.user.space.model.vo.ResInfo;
import ss.mango.user.space.model.vo.Reservation;
import ss.mango.user.space.model.vo.SubSpace;

/**
 * Servlet implementation class SpacePaymentServlet
 */
@WebServlet("/SpacePayment.ss")
public class SpacePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpacePaymentServlet() {
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
		SubSpace subspace = (SubSpace)session.getAttribute("subspace");
		
		Date resDate = Date.valueOf(request.getParameter("payDate"));
		int startTime = Integer.parseInt(request.getParameter("startTime").substring(0, 2));
		int endTime = Integer.parseInt(request.getParameter("endTime").substring(0, 2));
		int resPeople = Integer.parseInt(request.getParameter("payPeople"));
		
		String resInfoName = request.getParameter("resInfoName");
		String resInfoPhone1 = request.getParameter("resInfoPhone1");
		String resInfoPhone2 = request.getParameter("resInfoPhone2");
		String resInfoPhone3 = request.getParameter("resInfoPhone3");
		String resInfoPhone = resInfoPhone1 + resInfoPhone2 + resInfoPhone3;
		String resInfoEmail = request.getParameter("resInfoEmail");
		String usePurpose = request.getParameter("usePurpose");
		String requestItem = request.getParameter("requestItem");
		int payPrice = Integer.parseInt(request.getParameter("payPrice"));
		
		int insertResInfo = new SpaceService().insertResInfo(m.getMemberCode(),resInfoName,resInfoPhone,resInfoEmail,usePurpose,requestItem);
		
		ResInfo resinfo = new SpaceService().searchResInfo(m.getMemberCode(),resInfoName,resInfoEmail);
		
		int insertReservation = new SpaceService().spacePaySuccess(subspace.getSubNo(),resinfo.getResInfoCode(),resDate,startTime,endTime,resPeople,payPrice,m.getMemberCode());
		
		Reservation reservation = new SpaceService().searchReservation(resinfo.getResInfoCode());
		
		if(insertResInfo > 0 && insertReservation > 0) {
			RequestDispatcher view = request.getRequestDispatcher("/views/user/reservation/reservation_Success.jsp");
			session.setAttribute("ResInfo", resinfo);
			session.setAttribute("Reservation", reservation);
			view.forward(request, response);
		} else {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('결제자 정보 입력에 실패하였습니다.\\n 지속된 문제 발생시 관리자에게 문의하세요!');</script>");
			out.println("<script>history.back(-1);</script>");
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
