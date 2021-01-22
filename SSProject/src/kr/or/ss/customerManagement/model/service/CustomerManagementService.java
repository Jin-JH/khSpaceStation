package kr.or.ss.customerManagement.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.or.ss.common.JDBCTemplate;
import kr.or.ss.customerManagement.model.dao.CustomerManagementDAO;
import kr.or.ss.customerManagement.model.vo.CMpageData;
import kr.or.ss.customerManagement.model.vo.CustomerManagement;

public class CustomerManagementService {

	
	CustomerManagementDAO cmDAO= new CustomerManagementDAO();
	
	public CMpageData selectAllBoardPage(int currentPage) {  //자동 조회되는 페이징 게시판
		Connection conn = JDBCTemplate.getConnection(); 
		int recordCountPerPage = 5;
		ArrayList<CustomerManagement> list = cmDAO.selectAllBoardPageList(conn, currentPage, recordCountPerPage);
		
		for(CustomerManagement cManagement:list) {
			System.out.println("2"+cManagement.getResNo()+"/"+cManagement.getResInfoEmail()+"/"+cManagement.getResInfoName()+"/"+cManagement.getResInfoPhone()+"/"+cManagement.getResState());
		}
		
		int naviCountPerPage = 2; 
		String pageNavi = CustomerManagementDAO.getPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage);
		CMpageData cmpd=new CMpageData();
		cmpd.setList(list);
		cmpd.setPageNavi(pageNavi);
		
		
		JDBCTemplate.close(conn);
		
		
		
		return cmpd;
	}
	

	public CustomerManagement boardSelectEmail(String email) {
		Connection conn=JDBCTemplate.getConnection();
		CustomerManagement c =CustomerManagementDAO.boardSelectEmail(conn,email);
		JDBCTemplate.close(conn);
		return c;
		
	}
	
	public CustomerManagement boardSelectName(String name) {
		Connection conn=JDBCTemplate.getConnection();
		CustomerManagement cManagement =CustomerManagementDAO.boardSelectName(conn,name);
		//확인작업 - 여기까지 옴
	//	System.out.println(cManagement.getResNo());
	//	System.out.println(cManagement.getResInfoEmail());
	//	System.out.println(cManagement.getResInfoName());
	//	System.out.println(cManagement.getResInfoPhone());
	//	System.out.println(cManagement.getResState());
		JDBCTemplate.close(conn);
		return cManagement;
	}


	public CustomerManagement boardSelectPhone(String phone) {
		Connection conn=JDBCTemplate.getConnection();
		CustomerManagement cManagement =CustomerManagementDAO.boardSelectPhone(conn,phone);
		JDBCTemplate.close(conn);
		return cManagement;
	}
	
}
