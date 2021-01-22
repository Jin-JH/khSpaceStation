package ss.mango.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.mango.admin.model.service.AdminService;
import ss.mango.admin.model.vo.Partner;
import ss.mango.admin.model.vo.SpaceRegistration;

/**
 * Servlet implementation class SearchSignOutServlet
 */
@WebServlet("/searchSignOut.ss")
public class SearchSignOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSignOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String selectWord = request.getParameter("selectWord");
		String keyword = request.getParameter("keyword");
		
		ArrayList<Partner> list = null;
		ArrayList<SpaceRegistration> srList = null;
		boolean [] resultArr = null;
		
		if(selectWord.equals("spaceName")) {
			srList = new AdminService().selectSpaceWhere(selectWord, keyword);
			list = new ArrayList<Partner>();
			resultArr = new boolean[srList.size()];
			
			for(SpaceRegistration sr : srList) {
				Partner p = new AdminService().signOutSearchPartner(sr.getSpaceNo());
				boolean result = new AdminService().signOutPartnerRes(sr.getSpaceNo());
				list.add(p);
				resultArr[srList.indexOf(sr)] = result;
			}
			
		}else {
			list = new AdminService().searchSignOutPartner(selectWord, keyword);
			srList = new ArrayList<SpaceRegistration>();
			resultArr = new boolean[list.size()];
			
			for(Partner p : list) {
				SpaceRegistration sr = new AdminService().signOutPartner(p.getMemberCode());
				if(sr==null) {
					resultArr[list.indexOf(p)] = false;
				}else {
					boolean result = new AdminService().signOutPartnerRes(sr.getSpaceNo());
					resultArr[list.indexOf(p)] = result;
				}
				srList.add(sr);
			}
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/pManage/pManageSelectSignOut.jsp");
		request.setAttribute("list",list);
		request.setAttribute("srList",srList);
		request.setAttribute("resultArr",resultArr);
		request.setAttribute("selectWord", selectWord);
		request.setAttribute("keyword", keyword);
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
