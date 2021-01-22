package kr.or.ss.inquiry.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import kr.or.ss.inquiry.model.service.InquiryBoardService;
import kr.or.ss.inquiry.model.vo.Inquiry;
import kr.or.ss.inquiry.model.vo.InquiryPageData;



/**
 * Servlet implementation class inquiryBoard
 */
@WebServlet("/inquiryBoard.do")
public class inquiryBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inquiryBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage; //현재 페이지 값을 가지고 있는 변수, 이 변수는 페이지가 변경되면 변경된 페이지값을 가지고 있어야 하는 변수
		
		
		//게시판
		if(request.getParameter("currentPage")==null) {//처음 currentPage는 자동으로 1이기 때문에 보내주는 값이 없어서 null이면 1이란 소리(1페이지라는 소리)
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage")); //1페이지 이후부터는 특정 페이지를 이동할때 값을 보내주게 되므로 그 값을 page처리 하겠다.
		}
		System.out.println("1``````````````````````````````");
	
		InquiryPageData ipd=new InquiryPageData();
		String selection="";
		
			selection = request.getParameter("chk_info");
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			
			PrintWriter out = response.getWriter();
			if("전체".equals(selection)) {
				System.out.println("전체선택");
				ipd = new InquiryBoardService().selectAllBoardPage(currentPage); //전체조회
				System.out.println("2``````````````````````````````");
				System.out.println(ipd);
				RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/inquiryBoard.jsp");
				request.setAttribute("pageData", ipd);
				
				view.forward(request, response);
				

				
			}else if("완료".equals(selection)) {
				System.out.println("완료선택");
				ArrayList<Inquiry> ipds= new InquiryBoardService().selectCompletedPage();
			RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/inquiryBoard.jsp");
				request.setAttribute("completed", ipds); //키 값은 맘대로 정해.
			view.forward(request, response);
			new Gson().toJson(ipds,out);
			
			}else if("미완료".equals(selection)) {
				System.out.println("미완료선택");
				ArrayList<Inquiry> lists= new InquiryBoardService().selectIncompletedPage();
				RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/inquiryBoard.jsp");
				request.setAttribute("incompleted", lists); //키 값은 맘대로 정해.
				view.forward(request, response);
				new Gson().toJson(lists,out);
				}
			
		
	
				
				
				
		
		
			
		//Inquiry i = list.get(0);
				//System.out.println(i);
		//		JSONObject object = new JSONObject();
			//	object.put("name", m.getName());
				//object.put("age", m.getAge());
			//	object.put("addr", m.getAddr());
				//object.put("inquiryNo",)
		/*
		
		ArrayList<Inquiry> list=ipd.getList();
		
		for(Inquiry i : list) {  // 확인용, 여기까지 잘 왔음.
			System.out.println(i.getInquiryNo());
			System.out.println(i.getInquirytitle());
			System.out.println(i.getInquiryANS());
			System.out.println(i.getInquiryDate());
			System.out.println(i.getMemberName());
		}
		RequestDispatcher view = request.getRequestDispatcher("views/partner/content/inquiryBoard.jsp");
		request.setAttribute("InquiryPageData", ipd);
		view.forward(request, response);
		*/
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
