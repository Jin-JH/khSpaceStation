package ss.mango.user.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.user.member.model.service.MemberService;
import ss.mango.user.member.model.vo.Member;

/**
 * Servlet implementation class MemberFindIdServlet
 */
@WebServlet("/MemberFindId.ss")
public class MemberFindIdServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1. 인코딩 
      request.setCharacterEncoding("utf-8");
      
      //2.이전 페이지에서 보내온 데이터 받기 
      String select_member = request.getParameter("select_member");
      String select_type = request.getParameter("select_type");
      String findName = request.getParameter("findName"); // DB로 안보내고, 이메일이나 폰번호로 찾아와진 정보의 Member_name과 동일한지 비교하기 위함
      String findEmail = request.getParameter("findEmail"); //이메일로 찾기. db로 보내서  where 구문에 쓰기
      String findPhone = request.getParameter("findPhone"); //폰번호로 찾기. db로 보내서  where 구문에 쓰기 
      
      //3. 이메일로 아이디찾기 & 폰번호로 아이디 찾기 비즈니스 로직 
      Member m1 = new MemberService().selectByEmail(findName,findEmail);
      Member m2 = new MemberService().selectByPhone(findName,findPhone);
        
      if(m1!=null && select_type.equals("email")) {
    	  if(findName.equals(m1.getMemberName()) && ( (select_member.equals("user") && m1.getMemberCode().substring(0,1).equals("u")) ||
    			  (select_member.equals("partner") && m1.getMemberCode().substring(0,1).equals("p")))) {
        	  RequestDispatcher view = request.getRequestDispatcher("/views/user/member/memberFindIdByEmailSuccess.jsp");
        	  request.setAttribute("m1", m1);
        	  view.forward(request, response);        	  
        	  
    	  } else {
        	  RequestDispatcher view = request.getRequestDispatcher("/views/user/member/memberFindIdFail.jsp");
        	  view.forward(request, response);
        	  System.out.println("2");
    	  }
      } else if(m2!=null && select_type.equals("phone")) {
    	  if(findName.equals(m2.getMemberName()) && (select_member.equals("user") && m2.getMemberCode().substring(0,1).equals("u") ||
    			  select_member.equals("partner") && m2.getMemberCode().substring(0,1).equals("p"))) {
        	  RequestDispatcher view = request.getRequestDispatcher("/views/user/member/memberFindIdByPhoneSuccess.jsp");
        	  request.setAttribute("m2", m2);
        	  view.forward(request, response);
        	  
          } else {
        	  RequestDispatcher view = request.getRequestDispatcher("/views/user/member/memberFindIdFail.jsp");
        	  view.forward(request, response);
        	  System.out.println("4");
    	  }
      } else {
    	  response.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html; charset=UTF-8");
			
		  PrintWriter out = response.getWriter();
		  out.println("<script>alert('아이디 찾기에 실패하였습니다. 지속적인 오류 발생시 관리자에게 문의해주세요');</script>");
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