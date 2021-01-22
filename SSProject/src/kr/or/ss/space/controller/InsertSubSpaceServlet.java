package kr.or.ss.space.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.user.member.model.vo.Member;
import kr.or.ss.space.model.service.SpaceService;
import kr.or.ss.space.model.vo.Space;
import kr.or.ss.space.model.vo.SubSpace;

/**
 * Servlet implementation class InsertSubSapceServlet
 */
@WebServlet("/insertSubSpace.do")
public class InsertSubSpaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSubSpaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("UTF-8");
		
		//2.이전페이지에서 보낸 값 객체에 저장
		SubSpace sSub = new SubSpace();
		
		String subName = request.getParameter("subName"); //세부공간이름
		String subIntro = request.getParameter("subIntro"); //세부공간소개
		String subType = request.getParameter("subType"); //세부공간유형
		int minTime = Integer.parseInt(request.getParameter("minTime")); //최소시간
		int minPeople = Integer.parseInt(request.getParameter("minPeople")); //최소인원
		int maxPeople = Integer.parseInt(request.getParameter("maxPeople")); //최대인원
		
		String [] amenitiesValues = request.getParameterValues("amenities"); //편의시설(여러개의 값 받아오기)
		String amenities = amenitiesValues[0];
		for(int i=1; i<amenitiesValues.length; i++) {
			amenities = amenities+","+amenitiesValues[i];
		}
		
		String subCostStr = request.getParameter("subCost"); //세부공간금액
		int subCost = Integer.parseInt(subCostStr.replaceAll("[^0-9]", "")); //숫자만 추출
		
		String [] refundFeesValues = request.getParameterValues("refundFees"); //세부공간취소수수료(여러개의 값 받아오기)
		String refundFees = refundFeesValues[0];
		for(int i=1; i<refundFeesValues.length; i++) {
			refundFees = refundFees+","+refundFeesValues[i];
		}
		
		
		System.out.println(subName);
		System.out.println(subIntro);
		System.out.println(subType);
		System.out.println(minTime);
		System.out.println(minPeople);
		System.out.println(maxPeople);
		System.out.println(amenities);
		System.out.println(subCost);
		System.out.println(refundFees);
	
		
		
		sSub.setSubName(subName);
		sSub.setSubIntro(subIntro);
		sSub.setSubType(subType);
		sSub.setMinTime(minTime);
		sSub.setMinPeople(minPeople);
		sSub.setMaxPeople(maxPeople);
		sSub.setAmenities(amenities);
		sSub.setSubCost(subCost);
		sSub.setRefundFees(refundFees);
		
		//3. 로그인한 회원코드 받아오기
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		String memberCode = m.getMemberCode();
		System.out.println(memberCode);
		
		
		//4.비지니스 로직 처리
		int result = new SpaceService().insertSubSpace(sSub, memberCode);
		
		//5.결과값 가져와서 처리
		if(result>0) {
			RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/spaceRegistration.jsp");
			request.setAttribute("sSub", sSub);
			//이걸 보내주는게 아닌것가터...
			view.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.print("<script>alert('세부공간 등록에 실패하였습니다.');</script>");
			response.sendRedirect("/views/partner/content/sSpaceRegistration.jsp");
		}
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
