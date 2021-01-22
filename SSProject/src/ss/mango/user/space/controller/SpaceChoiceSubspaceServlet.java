package ss.mango.user.space.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.mango.user.space.model.service.SpaceService;
import ss.mango.user.space.model.vo.ResInfo;
import ss.mango.user.space.model.vo.SpaceRegistration;
import ss.mango.user.space.model.vo.SubSpace;

/**
 * Servlet implementation class SpaceChoiceSubspaceServlet
 */
@WebServlet("/SpaceChoiceSubspace.ss")
public class SpaceChoiceSubspaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceChoiceSubspaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		HttpSession session = request.getSession();
		
		SpaceRegistration space = (SpaceRegistration)session.getAttribute("space");
		
    	String resSubSpaceName = request.getParameter("resSubSpaceName");
    	String resPrice = request.getParameter("resPrice");
    	String resDate = request.getParameter("resDate");
    	String startTime = request.getParameter("startTime");
    	String endTime = request.getParameter("endTime");
    	String resPeople = request.getParameter("resPeople");
    	
    	ArrayList<ResInfo> list = new SpaceService().checkNamecheckPhone();
    	SubSpace subspace = new SpaceService().choiceSubSpace(space.getSpaceNo(),resSubSpaceName);
    	
    	RequestDispatcher view = request.getRequestDispatcher("/views/user/reservation/reservation_InputResInfo.jsp");
    	request.setAttribute("ResInfolist", list);
    	session.setAttribute("subspace", subspace);
    	request.setAttribute("resPrice", resPrice);
    	request.setAttribute("resDate", resDate);
    	request.setAttribute("startTime", startTime);
    	request.setAttribute("endTime", endTime);
    	request.setAttribute("resPeople", resPeople);
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
