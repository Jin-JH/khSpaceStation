package ss.mango.user.Inquiry.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ss.mango.common.JDBCTemplate;
import ss.mango.user.Inquiry.model.dao.InquiryDAO;
import ss.mango.user.Inquiry.model.vo.Inquiry;
import ss.mango.user.Inquiry.model.vo.InquiryAnswer;
import ss.mango.user.Inquiry.model.vo.InquiryPageData;

public class InquiryService {
	InquiryDAO inquDAO = new InquiryDAO();
	
	public InquiryPageData selectAllInquiryPage(int presentPage, String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPage = 10; // 한 페이지당 보여주는 게시물의 갯수
		ArrayList<Inquiry> list = inquDAO.selectAllInquiryPage(conn,presentPage,recordCountPage,memberId);
		
		int naviCountPage = 5; // presentPage 값이 몇개씩 보여지게 할 것인지
		String pageNavi = inquDAO.getpageNavi(conn,presentPage,recordCountPage,naviCountPage,memberId);
		
		InquiryPageData ipd = new InquiryPageData();
		ipd.setList(list);
		ipd.setPageNavi(pageNavi);
		
		JDBCTemplate.close(conn);
		
		return ipd;
	}
	
	public int insertInquiry(String inquiryCartegory, String inquiryTitle, String inquiryContent, String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = inquDAO.insertInquiry(conn,inquiryCartegory,inquiryTitle,inquiryContent,memberId);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	public Inquiry readInquiry(int inquiryNo, String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		
		Inquiry inqu = inquDAO.readInquiry(conn, inquiryNo, memberId);
		
		JDBCTemplate.close(conn);
		
		return inqu;
	}

	public InquiryAnswer answerInquiry(int inquiryNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		InquiryAnswer ia = inquDAO.answerInquiry(conn, inquiryNo);
		
		JDBCTemplate.close(conn);
		
		return ia;
	}


}
