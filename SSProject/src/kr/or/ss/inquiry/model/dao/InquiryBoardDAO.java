package kr.or.ss.inquiry.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.ss.common.JDBCTemplate;
import kr.or.ss.inquiry.model.vo.Inquiry;



public class InquiryBoardDAO {
//전체
	public static ArrayList<Inquiry> selectAllBoardPageList(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Inquiry> list = new ArrayList<Inquiry>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		System.out.println("DAO 여기까지 오니?");
		String query = "select e.* from( "+
				"select row_number() over (order by inquirydate desc) as num, inquiryno, inquirydate, membername,inquirytitle, inquiryans "+ 
				"from ( select * from inquiry left join member using(memberid)))e "+
				"where num between ? and ? ";
		try {
			pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
			
			rset=pstmt.executeQuery();
			System.out.println("4.5");
			while(rset.next()) {
				Inquiry i= new Inquiry();
				i.setInquiryNo(rset.getInt("inquiryNo"));
				i.setInquiryDate(rset.getDate("inquiryDate"));
				i.setMemberName(rset.getString("memberName"));
				i.setInquirytitle(rset.getString("inquirytitle"));
				i.setInquiryANS(rset.getString("inquiryANS").charAt(0));
				list.add(i);
			}
			System.out.println("5``````````````````````````````");
			//확인용 여기까지 옴
			for(Inquiry i : list) {
				System.out.println("DAO"+i.getInquiryANS()+"/"+ i.getInquiryNo()+"/"+i.getMemberName()+"/"+i.getInquirytitle()+"/"+i.getInquiryDate());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
	return list;

}

	public static String getPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int postTotalCount = postTotalCount(conn);
		int pageTotalCount;
		if(postTotalCount % recordCountPerPage > 0) {  //나머지가 있다면
			pageTotalCount = postTotalCount / recordCountPerPage + 1;  //몫+1 개수
		}else {
			pageTotalCount = postTotalCount / recordCountPerPage + 0;   //몫 개수
			//예)pageTotalCount = 105/5 ->21페이지
		}
		int startNavi = ((currentPage-1)/naviCountPerPage) * naviCountPerPage +1; 
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}	
		System.out.println(postTotalCount+"/"+pageTotalCount+"/"+startNavi+"/"+endNavi);
		StringBuilder sb = new StringBuilder(); 
		
		if(startNavi != 1) { //startNavi니 1, 6, 11...이런식인데 1이 아니면 2번째 3번째 네비잖아...
			sb.append("<a href='/inquiryBoard.do?currentPage="+(startNavi-1)+"'><</a> "); //startNavi가 6이면 전페이지 5로 이동
			
		}
		for(int i = startNavi; i<=endNavi; i++) {
			if(i==currentPage){
				sb.append("<a href='/inquiryBoard.do?currentPage="+i+"'><b>"+i+"</b></a> "); //현재 선택된 페이지는 진하게 표시해라.

			}else {
				sb.append("<a href='/inquiryBoard.do?currentPage="+i+"'>"+i+"</a> "); //그렇지 않은 페이지는 진하게 처리하지 마.
			}
		}
		if(endNavi != pageTotalCount) {
			sb.append("<a href='/inquiryBoard.do?currentPage="+(endNavi+1)+"'>></a> "); //startNavi가 6이면 다음페이지 7로 이동
			
		}

		
		return sb.toString();
		
		
	}

	private static int postTotalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int postTotalCount = 0;
		
		String query = "SELECT COUNT(*) as totalCount " + 
                "from inquiry left join member using(memberid)";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			rset.next();
			postTotalCount = rset.getInt("totalCount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return postTotalCount;
		
		
	}

	//완료
	public static ArrayList<Inquiry> selectCompletedPage(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Inquiry> list = new ArrayList<Inquiry>();
		System.out.println("DAO 여기까지 오니?");	
		String query ="select inquiryno, " + 
				"inquirydate, membername, inquirytitle, inquiryans " + 
				"from ( select * from inquiry left join member using(memberid)) " + 
				"where inquiryans = 'Y' ";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				Inquiry i= new Inquiry();
				i.setInquiryNo(rset.getInt("inquiryNo"));
				i.setInquiryDate(rset.getDate("inquiryDate"));
				i.setMemberName(rset.getString("memberName"));
				i.setInquirytitle(rset.getString("inquirytitle"));
				i.setInquiryANS(rset.getString("inquiryANS").charAt(0));
				list.add(i);
			}
			//확인용 여기까지 옴
			for(Inquiry i : list) {
				System.out.println("DAO"+i.getInquiryANS()+"/"+ i.getInquiryNo()+"/"+i.getInquirytitle()+"/"+i.getMemberName()+"/"+i.getInquiryDate());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
	return list;
		
	}

	

	

	

	public static ArrayList<Inquiry> selectIncompletedPage(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		ArrayList<Inquiry> lists = new ArrayList<Inquiry>();
		System.out.println("DAO 여기까지 오니?");
		String query ="select inquiryno, " + 
				"inquirydate, membername, inquirytitle, inquiryans " + 
				"from ( select * from inquiry left join member using(memberid)) " + 
				"where inquiryans = 'N' ";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Inquiry i= new Inquiry();
				i.setInquiryNo(rset.getInt("inquiryNo"));
				i.setInquiryDate(rset.getDate("inquiryDate"));
				i.setMemberName(rset.getString("memberName"));
				i.setInquirytitle(rset.getString("inquirytitle"));
				i.setInquiryANS(rset.getString("inquiryANS").charAt(0));
				lists.add(i);
			
			}
			//확인용 여기까지 옴
			for(Inquiry i : lists) {
			System.out.println("DAO"+i.getInquiryANS()+"/"+ i.getInquiryNo()+"/"+i.getInquirytitle()+"/"+i.getMemberName()+"/"+i.getInquiryDate());
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return lists;
	}
	
}
