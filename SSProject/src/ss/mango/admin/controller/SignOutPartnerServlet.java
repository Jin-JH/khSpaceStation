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
 * Servlet implementation class SignOutPartnerServlet
 */
@WebServlet("/signOutPartner.ss")
public class SignOutPartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignOutPartnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			ArrayList<Partner> list = new AdminService().signOutPartner(); // 탈퇴 신청한 사업자 목록
			
			ArrayList<SpaceRegistration> srList = new ArrayList<SpaceRegistration>(); // 탈퇴 신청한 사업자의 공간정보
			boolean [] resultArr = new boolean[list.size()]; // 공간 정보에 연결된 세부공간들의 예약 유무 true/false
			
			for(Partner p : list) { //list.get(0)
				SpaceRegistration sr = new AdminService().signOutPartner(p.getMemberCode());// 탈퇴 신청한 사업자의 공간정보
				//select * from SPACEREGISTRATION where membercode=?; -- 탈퇴한 사업자가 가지고 있는 공간 (파란색)
				
				if(sr==null) {//만약 사업자 등록은 했지만 공간 등록하지 않았다면
					resultArr[list.indexOf(p)] = false;
				}else {
					boolean result = new AdminService().signOutPartnerRes(sr.getSpaceNo());
					/*
					 * select * from member m left join partnerInfo p
					 * on(m.membercode=p.membercode) where m.membercode like 'p%' and
					 * m.MEMBERENDDATE is not null and m.memberend='N'; --탈퇴한 사업자 목록 (빨간색)
					 */
					resultArr[list.indexOf(p)] = result;
				}
				srList.add(sr);
			}
		
			RequestDispatcher view = request.getRequestDispatcher("/views/admin/pManage/pManageSignOut.jsp");
			request.setAttribute("list",list);
			request.setAttribute("srList",srList);
			request.setAttribute("resultArr",resultArr);
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
