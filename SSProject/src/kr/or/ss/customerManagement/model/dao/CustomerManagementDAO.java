package kr.or.ss.customerManagement.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.ss.common.JDBCTemplate;
import kr.or.ss.customerManagement.model.vo.CustomerManagement;
import kr.or.ss.space.model.vo.MRManagement;

public class CustomerManagementDAO {

	public ArrayList<CustomerManagement> selectAllBoardPageList(Connection conn, int currentPage,  //자동 조회되는 게시판
			int recordCountPerPage) {
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		
		ArrayList<CustomerManagement> list = new ArrayList<CustomerManagement>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		/* 최신 예약자 순으로 정렬 
		 * select row_num,res_no, res_info_email,res_info_name,res_info_phone,res_state from (select row_number() 
		over(order by res_no desc) as row_num,res_no, res_info_email,res_info_name,res_info_phone,res_state from res left join res_info using(res_info_no));
		 */
	//String query = "select row_num,resno, resinfoemail,resinfoname,resinfophone,resstate from (select row_number()over(order by resno desc) as row_num,resno, resinfoemail,resinfoname,resinfophone,resstate" + 
	//			"from reservation left join resinfo using(resinfocode))WHERE row_num between ? and ?";
				String query = "select resno, resinfoemail, resinfoname,resinfophone,resstate from reservation left join resinfo using(resinfocode)";
	/*	String query="select rownum, numnum.*" + 
				"from (select res.resno, rin.resinfoname, sub.subname, res.resdate, res.resstate" + 
				"from reservation res" + 
				"left join resinfo rin using (resinfocode)" + 
				"left join subspace  sub using (subno)" + 
				"left join member mem on rin.membercode=mem.membercode" + 
				"left join spaceregistration sgi on sgi.spaceno=sub.spaceno" + 
				"where mem.membercode=sgi.membercode" + 
				"order by res.resdate desc) numnum where rownum between ? and ?";*/
		try {
			pstmt = conn.prepareStatement(query);
		//	pstmt.setInt(1, start);
		//	pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			System.out.println(rset);
			while(rset.next()) {
				CustomerManagement cManagement = new CustomerManagement();
				cManagement.setResNo(rset.getString("resNo"));
				cManagement.setResInfoEmail(rset.getString("resInfoEmail"));
				cManagement.setResInfoName(rset.getString("resInfoName"));
				cManagement.setResInfoPhone(rset.getString("resInfoPhone"));
				cManagement.setResState(rset.getString("resState").charAt(0));	
				
				list.add(cManagement);
			}
			//확인용도
			for(CustomerManagement cManagement : list) {
				System.out.println("1"+cManagement.getResNo()+"/"+cManagement.getResInfoEmail()+"/"+cManagement.getResInfoName()+"/"+cManagement.getResInfoPhone()+"/"+cManagement.getResState());
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
		int postTotalCount = postTotalCount(conn);  //전체 게시물의 개수를 구하기 위한 메소드
		
		int pageTotalCount; //전체 페이지를 저장하는 변수
		if(postTotalCount % recordCountPerPage > 0) {  //나머지가 있다면
			pageTotalCount = postTotalCount / recordCountPerPage + 1;  //몫+1 개수
			//예)pageTotalCount = 108/5+1 ->22페이지
					
		}else {
			pageTotalCount = postTotalCount / recordCountPerPage + 0;   //몫 개수
			//예)pageTotalCount = 105/5 ->21페이지
		}
		int startNavi = ((currentPage-1)/naviCountPerPage) * naviCountPerPage +1;  //공식이다 외워라
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}	
		
		
		
		StringBuilder sb = new StringBuilder();
		if(startNavi != 1) { //startNavi니 1, 6, 11...이런식인데 1이 아니면 2번째 3번째 네비잖아...
			sb.append("<a href='/customerManagement.do?currentPage="+(startNavi-1)+"'><</a> "); //startNavi가 6이면 전페이지 5로 이동
			
		}
		for(int i = startNavi; i<=endNavi; i++) {
			if(i==currentPage){
				sb.append("<a href='/customerManagement.do?currentPage="+i+"'><b>"+i+"</b></a> "); //현재 선택된 페이지는 진하게 표시해라.

			}else {
				sb.append("<a href='/customerManagement.do?currentPage="+i+"'>"+i+"</a> "); //그렇지 않은 페이지는 진하게 처리하지 마.
			}
		}
		
		//만약 마지막 PageNavi가 아니라면 ' > ' 모양을 추가해라 ( 마지막 pageNavi이면 추가하지 말아라)
		if(endNavi != pageTotalCount) {
			sb.append("<a href='/customerManagement.do?currentPage="+(endNavi+1)+"'>></a> "); //startNavi가 6이면 다음페이지 7로 이동
			
		}
		
		return sb.toString();
	}


	private static int postTotalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int postTotalCount = 0;
		
		String query = "SELECT COUNT(*) as totalCount FROM reservation left join resinfo using(resinfocode)";
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


	public static CustomerManagement boardSelectEmail(Connection conn, String email) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CustomerManagement cManagement = null;
		
		String query="select resno, resinfoemail,resinfoname,resinfophone,resstate from reservation left join resinfo using(resinfocode) where resinfoemail=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				cManagement = new CustomerManagement();
				cManagement.setResNo(rset.getString("resNo"));
				cManagement.setResInfoEmail(rset.getString("resInfoEmail"));
				cManagement.setResInfoName(rset.getString("resInfoName"));
				cManagement.setResInfoPhone(rset.getString("resInfoPhone"));
				cManagement.setResState(rset.getString("resState").charAt(0));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return cManagement;
	}


	public static CustomerManagement boardSelectName(Connection conn, String name) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CustomerManagement c = null;
		
		String query="select resno, resinfoemail,resinfoname,resinfophone,resstate from reservation left join resinfo using(resinfocode) where resinfoname=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				c = new CustomerManagement();
				c.setResNo(rset.getString("resNo"));
				c.setResInfoEmail(rset.getString("resInfoEmail"));
				c.setResInfoName(rset.getString("resInfoName"));
				c.setResInfoPhone(rset.getString("resInfoPhone"));
				c.setResState(rset.getString("resState").charAt(0));
			}
			//확인작업 - 여기까지는 옴
			//System.out.println(cManagement.getResNo());
			//System.out.println(cManagement.getResInfoEmail());
			//System.out.println(cManagement.getResInfoName());
			//System.out.println(cManagement.getResInfoPhone());
			//System.out.println(cManagement.getResState());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return c;
	}


	public static CustomerManagement boardSelectPhone(Connection conn, String phone) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CustomerManagement cManagement = null;
		
		String query="select resno, resinfoemail,resinfoname,resinfophone,resstate from reservation left join resinfo using(resinfocode) where resinfophone=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, phone);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				cManagement = new CustomerManagement();
				cManagement.setResNo(rset.getString("resNo"));
				cManagement.setResInfoEmail(rset.getString("resInfoEmail"));
				cManagement.setResInfoName(rset.getString("resInfoName"));
				cManagement.setResInfoPhone(rset.getString("resInfoPhone"));
				cManagement.setResState(rset.getString("resState").charAt(0));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return cManagement;
	}

}
