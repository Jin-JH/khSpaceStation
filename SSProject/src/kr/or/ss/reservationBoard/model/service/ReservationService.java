package kr.or.ss.reservationBoard.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import kr.or.ss.common.JDBCTemplate;
import kr.or.ss.reservationBoard.model.dao.ReservationDAO;
import kr.or.ss.reservationBoard.model.vo.AllReservation;
import kr.or.ss.reservationBoard.model.vo.ReservationPageData;

public class ReservationService {

	
ReservationDAO reservationDAO = new ReservationDAO();
	public ReservationPageData selectAllList(int currentPage, String s, String memberCode) {
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 5;
		
		ArrayList<AllReservation> list =  reservationDAO.selectAllList(conn,currentPage, s, recordCountPerPage, memberCode);
		int naviCountPerPage = 3; //pageNavi값이 몇개씩 보여줄 것인지
		
		String pageNavi = reservationDAO.getPageNavi(conn,currentPage,s,memberCode,recordCountPerPage,naviCountPerPage);
		ReservationPageData rpd = new ReservationPageData();  //페이징 ㅓ처리하려고요 이거 네비랑 리스트 정보랑 두개 담는것
		rpd.setList(list);
		rpd.setPageNavi(pageNavi);
		System.out.println("서비스 리스트 출력:" +rpd.getList());
		
		//System.out.println("서비스여기까지 오니?" +al.getResInfoName() +"/"+al.getResNO()+"/"+al.getResRecordDate()+"/"+al.getResState()+"/"+al.getSubName());
		JDBCTemplate.close(conn);
		return rpd;
	}
	
	
	public ReservationPageData selectOneList(int currentPage, String startDate, String memberCode, String category) {
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 5;
		System.out.println("역이까지 오니?");
		System.out.println("1"+currentPage+"/"+recordCountPerPage+"/");
		ArrayList<AllReservation> list = reservationDAO.selectOneList(conn,currentPage, startDate, recordCountPerPage, memberCode,category);
		
		int naviCountPerPage = 3; //pageNavi값이 몇개씩 보여줄 것인지
		String pageNavi = reservationDAO.getPageNavi(conn,currentPage,startDate,memberCode,recordCountPerPage,naviCountPerPage);
		
		ReservationPageData rpd = new ReservationPageData();  //페이징 ㅓ처리하려고요 이거 네비랑 리스트 정보랑 두개 담는것
		rpd.setList(list);
		rpd.setPageNavi(pageNavi);
		System.out.println("서비스 리스트 출력:" +rpd.getList());
		
		//System.out.println("서비스여기까지 오니?" +al.getResInfoName() +"/"+al.getResNO()+"/"+al.getResRecordDate()+"/"+al.getResState()+"/"+al.getSubName());
		JDBCTemplate.close(conn);
		return rpd;
	}


	public ReservationPageData selectOneListc(int currentPage, String startDate, String memberCode) {
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 5;
		System.out.println("역이까지 오니?");
		System.out.println("1"+currentPage+"/"+recordCountPerPage+"/");
		ArrayList<AllReservation> list = reservationDAO.selectOneListc(conn,currentPage, startDate, recordCountPerPage, memberCode);
		
		int naviCountPerPage = 3; //pageNavi값이 몇개씩 보여줄 것인지
		String pageNavi = reservationDAO.getPageNavi(conn,currentPage,startDate,memberCode,recordCountPerPage,naviCountPerPage);
		
		ReservationPageData rpd = new ReservationPageData();  //페이징 ㅓ처리하려고요 이거 네비랑 리스트 정보랑 두개 담는것
		rpd.setList(list);
		rpd.setPageNavi(pageNavi);
		System.out.println("서비스 리스트 출력:" +rpd.getList());
		
		//System.out.println("서비스여기까지 오니?" +al.getResInfoName() +"/"+al.getResNO()+"/"+al.getResRecordDate()+"/"+al.getResState()+"/"+al.getSubName());
		JDBCTemplate.close(conn);
		return rpd;
	}

	
}
