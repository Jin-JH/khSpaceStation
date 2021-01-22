package ss.mango.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.admin.model.service.AdminService;
import ss.mango.admin.model.vo.Admin;
import ss.mango.admin.model.vo.User;

/**
 * Servlet implementation class SignOutUserServlet
 */
@WebServlet("/signOutUser.ss")
public class SignOutUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignOutUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }// SignOutUserServlet

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			Admin ad = (Admin)session.getAttribute("admin");
			
			if(ad!=null) {
				ArrayList<User> list = new AdminService().signOutUser();
							
					RequestDispatcher view = request.getRequestDispatcher("/views/admin/uManage/uManageSignOut.jsp");
					request.setAttribute("list",list);
					view.forward(request, response);
												
			} else {				
				response.sendRedirect("/views/admin/error/loginError.jsp");
			}// if, else
			
		} catch (Exception e) {
			response.sendRedirect("/views/admin/error/loginError.jsp");
		}// try, catch
				
	}// doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}// doPost

}// SignOutUserServlet
