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

/**
 * Servlet implementation class MemberFindPwServlet
 */
@WebServlet("/memberFindPw.ss")
public class MemberFindPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindPwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩 
		request.setCharacterEncoding("utf-8"); 
		
		//2.이전 페이지에서 보내온 데이터 받기(이름,이메일,아이디,폰번호)
		String select_type = request.getParameter("select_type");
		String select_member = request.getParameter("select_member");
		String findName = request.getParameter("findName");
		String findPwEmail = request.getParameter("findPwEmail");
		String findId = request.getParameter("findId");
		String findPwPhone = request.getParameter("findPwPhone");
		
		//3. 이메일로 비번찾기 & 폰번호로 비번 찾기 비즈니스 로직
		Member m1 = new MemberService().selectPwByEmail(findPwEmail,findId);
		Member m2 = new MemberService().selectPwByPhone(findPwPhone, findId);
		
		if(m1!=null && select_type.equals("email")) 
		{
			if(findId.equals(m1.getMemberId()) && ((select_member.equals("user") && m1.getMemberCode().substring(0,1).equals("u")) ||
		    	(select_member.equals("partner") && m1.getMemberCode().substring(0,1).equals("p")))) {
		         RequestDispatcher view = request.getRequestDispatcher("/views/user/member/memberFindPwByEmailSuccess.jsp");
		         request.setAttribute("m1", m1);
		         view.forward(request, response);
		        
		        HttpSession session = request.getSession();
		        session.setAttribute("userNo",m1);
		        	  
		        	  
		    } else {
		        RequestDispatcher view = request.getRequestDispatcher("/views/user/member/memberFindPwFail.jsp");
		        view.forward(request, response);
		    }
		    
		} else if(m2!=null && select_type.equals("phone")) {
		    
			if(findId.equals(m2.getMemberId()) && (select_member.equals("user") && m2.getMemberCode().substring(0,1).equals("u") ||
		    	select_member.equals("partner") && m2.getMemberCode().substring(0,1).equals("p"))) {
		        RequestDispatcher view = request.getRequestDispatcher("/views/user/member/memberFindPwByPhoneSuccess.jsp");
		        request.setAttribute("m2", m2);
		        view.forward(request, response);
		        
		        HttpSession session = request.getSession();
		        session.setAttribute("userNo",m2);
		        
		    } else {
		        RequestDispatcher view = request.getRequestDispatcher("/views/user/member/memberFindPwFail.jsp");
		        view.forward(request, response);
		    }
			
	   }else {
		   response.setCharacterEncoding("UTF-8");
		   response.setContentType("text/html; charset=UTF-8");
				
		   PrintWriter out = response.getWriter();
		   out.println("<script>alert('비밀번호 찾기에 실패하였습니다. 지속적인 오류 발생시 관리자에게 문의해주세요');</script>");
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
