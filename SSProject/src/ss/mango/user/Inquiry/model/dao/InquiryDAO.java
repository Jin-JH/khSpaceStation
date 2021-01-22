package ss.mango.user.Inquiry.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.javafx.fxml.ParseTraceElement;

import ss.mango.common.JDBCTemplate;
import ss.mango.user.Inquiry.model.vo.Inquiry;
import ss.mango.user.Inquiry.model.vo.InquiryAnswer;

public class InquiryDAO {

	public ArrayList<Inquiry> selectAllInquiryPage(Connection conn, int presentPage, int recordCountPage, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Inquiry> list = new ArrayList<Inquiry>();
		
		//시작 = 현재페이지 * 보여줄 페이지 갯수 - (보여줄 페이지 개수 - 1)
		int start = presentPage * recordCountPage - (recordCountPage-1);
		
		//종료 = 현재페이지 * 보여줄 페이지 갯수
		int end = presentPage * recordCountPage;
		
		String query = "SELECT * FROM (SELECT Row_NUMBER() OVER (ORDER BY INQUIRYNO DESC) "
					+ "AS Row_Num, INQUIRY.* "
					+ "FROM INQUIRY WHERE memberId=?) WHERE Row_Num BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Inquiry inqu = new Inquiry();
				inqu.setInquiryNo(rset.getInt("INQUIRYNO"));
				inqu.setInquiryCartegory(rset.getString("INQUIRYCARTEGORY"));
				inqu.setInquiryTitle(rset.getString("INQUIRYTITLE"));
				inqu.setInquiryContent(rset.getString("INQUIRYCONTENT"));
				inqu.setInquiryDate(rset.getDate("INQUIRYDATE"));
				inqu.setInquiryAns(rset.getString("INQUIRYANS").charAt(0));
				
				list.add(inqu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public String getpageNavi(Connection conn, int presentPage, int recordCountPage, int naviCountPage,
			String memberId) {
		//presentPage		: 현재 페이지를 가지고 있는 변수
		//recordCountPage	: 한 페이지당 보여질 게시물의 개수
		//naviCountPage		: pageNavi가 몇개씩 보여질 것인지에 대한 개수
		
		int postTotalCount = postTotalCount(conn,memberId); // 전체 게시물의 갯수를 구하기 위한 메소드
		
		int pageTotalCount; //전체 페이지의 갯수 저장
		if(postTotalCount % recordCountPage > 0) {
			pageTotalCount = postTotalCount / recordCountPage + 1;
		} else {
			pageTotalCount = postTotalCount / recordCountPage + 0;
		}
		
		// startNavi = 시작페이지 번호, endNavi = 끝페이지 번호?
		int startNavi = ((presentPage-1) / naviCountPage) * naviCountPage + 1;
		int endNavi = startNavi + naviCountPage - 1;
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(startNavi != 1) {
			sb.append("<a href='/InquiryListPage.ss?presentPage=" + (startNavi-1) + "'><</a> ");
		}
		
		for(int i = startNavi; i <= endNavi; i++) {
			if(i==presentPage) {
				sb.append("&nbsp;<a href='/InquiryListPage.ss?presentPage=" + i + "'><b>" + i + " </b></a>&nbsp;");
			} else {
				sb.append("<a href='/InquiryListPage.ss?presentPage=" + i + "'>" + i + "</a>&nbsp;");
			}
		}
		
		if(endNavi != pageTotalCount) {
			sb.append("<a href='/InquiryListPage.ss?presentPage=" + (endNavi+1) + "'>></a>");
		}
		
		return sb.toString();
	}
	
	private int postTotalCount(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int postTotalCount = 0;
		
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM INQUIRY WHERE memberId=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			rset.next();
			postTotalCount = rset.getInt("TOTALCOUNT");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return postTotalCount;
	}

	public int insertInquiry(Connection conn, String inquiryCartegory, String inquiryTitle, String inquiryContent,
			String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO INQUIRY VALUES(INQUIRY_SEQ.NEXTVAL,?,?,?,?,DEFAULT,'N')";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, inquiryCartegory);
			pstmt.setString(3, inquiryTitle);
			pstmt.setString(4, inquiryContent);
			
			result = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Inquiry readInquiry(Connection conn, int inquiryNo, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Inquiry inqu = null;
		
		String query = "SELECT * FROM INQUIRY WHERE INQUIRYNO = ? AND memberId = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inquiryNo);
			pstmt.setString(2, memberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				inqu = new Inquiry();
				inqu.setInquiryNo(rset.getInt("INQUIRYNO"));
				inqu.setInquiryCartegory(rset.getString("INQUIRYCARTEGORY"));
				inqu.setInquiryTitle(rset.getString("INQUIRYTITLE"));
				inqu.setInquiryContent(rset.getString("INQUIRYCONTENT"));
				inqu.setInquiryDate(rset.getDate("INQUIRYDATE"));
				inqu.setInquiryAns(rset.getString("INQUIRYANS").charAt(0));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return inqu;
	}

	public InquiryAnswer answerInquiry(Connection conn, int inquiryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		InquiryAnswer ia = null;
		
		String query = "SELECT * FROM INQUIRYANSWER WHERE INQUIRYNO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inquiryNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				ia = new InquiryAnswer();
				ia.setInquiryNo(rset.getInt("INQUIRYNO"));
				ia.setAdminId(rset.getString("ADMINID"));
				ia.setMemberId(rset.getString("MEMBERID"));
				ia.setAnswerTitle(rset.getString("ANSWERTITLE"));
				ia.setAnswerContent(rset.getString("ANSWERCONTENT"));
				ia.setAnswerDate(rset.getDate("ANSWERDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return ia;
	}
}
