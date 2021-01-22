package kr.or.ss.customerManagement.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.ss.customerManagement.model.service.CustomerManagementService;
import kr.or.ss.customerManagement.model.vo.CustomerManagement;

/**
 * Servlet implementation class BoardSelectOneServlet
 */
@WebServlet("/boardSelectOne.do")
public class BoardSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String searchCustomer= request.getParameter("searchCustomer");
		String keyword=request.getParameter("keyword");
		CustomerManagement c =null;
		//System.out.println(searchCustomer);
		//System.out.println(keyword);
		
		if("email".equals(searchCustomer)) {//<- 안됨
			//cManagement.setResInfoEmail(keyword);
			String email=keyword;
			c =new CustomerManagementService().boardSelectEmail(email);
			
		}else if("name".equals(searchCustomer)) {
			//cManagement.setResInfoName(keyword);
			String name=keyword;
			c =new CustomerManagementService().boardSelectName(name);
			
		}else if("phone".equals(searchCustomer)) {
			//cManagement.setResInfoPhone(keyword);
			String phone=keyword;
			c =new CustomerManagementService().boardSelectPhone(phone);
			
		}
		System.out.println("1"+c.getResNo());
		System.out.println(c.getResInfoEmail());
		System.out.println(c.getResInfoName());
		System.out.println(c.getResInfoPhone());
		System.out.println(c.getResState());
		
		JSONObject object = new JSONObject();
		
		object.put("resNo", c.getResNo());
		object.put("email", c.getResInfoEmail());
		object.put("resName", c.getResInfoName());
		object.put("phone", c.getResInfoPhone());
		object.put("resState", String.valueOf(c.getResState()));
	//	object.put("resNo", "hello");
		//object.put("email", "hllo");
	//	object.put("resName", "hed");
	//	object.put("phone", "hesd");
		//object.put("resState", "hfdo");
		response.setContentType("application/json");
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
	System.out.println(object); //여기는 됨
		
		out.print(object);
		System.out.println(object.keySet());
		//확인작업 - 여기까지 옴
			//System.out.println(cManagement.getResNo());
			//System.out.println(cManagement.getResInfoEmail());
			//System.out.println(cManagement.getResInfoName());
			//System.out.println(cManagement.getResInfoPhone());
			//System.out.println(cManagement.getResState());
		/*if(c!=null) {
			RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/customerManagement.jsp");
			request.setAttribute("c", c);
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/views/partner/content/postReadFail.jsp");
			view.forward(request, response);
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
