package kr.or.ss.inquiry.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.or.ss.common.JDBCTemplate;
import kr.or.ss.inquiry.model.dao.InquiryBoardDAO;
import kr.or.ss.inquiry.model.vo.Inquiry;
import kr.or.ss.inquiry.model.vo.InquiryPageData;



public class InquiryBoardService {

	public InquiryPageData selectAllBoardPage(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 5; 
		System.out.println("3`````````````````````````````");
		ArrayList<Inquiry> list =InquiryBoardDAO.selectAllBoardPageList(conn, currentPage, recordCountPerPage);
		System.out.println("4``````````````````````````````");
		int naviCountPerPage = 2; 
		String pageNavi = InquiryBoardDAO.getPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage);
		
		//확인용 여기까지옴
		for(Inquiry i : list) {
			System.out.println("service"+ i.getInquiryANS()+"/"+ i.getInquiryNo()+"/"+i.getMemberName()+"/"+i.getInquirytitle()+"/"+i.getInquiryDate());
		}
		
		InquiryPageData ipd = new InquiryPageData();
		ipd.setList(list);
		ipd.setPageNavi(pageNavi);
		JDBCTemplate.close(conn);
		return ipd;
	}

	public ArrayList<Inquiry> selectCompletedPage() {
		Connection conn = JDBCTemplate.getConnection();
		System.out.println("33`````````````````````````````");
		ArrayList<Inquiry> list = InquiryBoardDAO.selectCompletedPage(conn);
		System.out.println("333`````````````````````````````");
		JDBCTemplate.close(conn);
		
		//확인용 여기까지옴
		for(Inquiry i : list) {
			System.out.println("service"+ i.getInquiryANS()+"/"+ i.getInquiryNo()+"/"+i.getInquirytitle()+"/"+i.getMemberName()+"/"+i.getInquiryDate());
		}
			return list;
	}

	public ArrayList<Inquiry> selectIncompletedPage() {
		Connection conn = JDBCTemplate.getConnection();
		System.out.println("322`````````````````````````````");
		ArrayList<Inquiry> lists = InquiryBoardDAO.selectIncompletedPage(conn);
		System.out.println("3222`````````````````````````````");
		JDBCTemplate.close(conn);
		//확인용 여기까지옴
				for(Inquiry i : lists) {
					System.out.println("service"+ i.getInquiryANS()+"/"+ i.getInquiryNo()+"/"+i.getInquirytitle()+"/"+i.getMemberName()+"/"+i.getInquiryDate());
				}
					return lists;
	}

	

}
