package kr.or.ss.reservationBoard.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.ss.common.JDBCTemplate;
import kr.or.ss.reservationBoard.model.vo.*;

public class ReservationDAO {

	public static ArrayList<AllReservation> selectAllList(Connection conn, int currentPage, String s, int recordCountPerPage, String memberCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AllReservation> list = new ArrayList<AllReservation>();
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		System.out.println("쿼리전 여기까지 왔니? 여기까지 도착함"+memberCode);
/*
		String query= "WITH RESULT AS (SELECT "+
				"reservation.RESNO AS RESNO, "+
                "resinfo.RESINFOCODE AS RESINFOCODE,"+
                "resinfo.RESINFONAME AS RESINFONAME, "+
                "reservation.SUBNO AS SUBNO, "+
                "subspace.SUBNAME AS SUBNAME,"+
                "subspace.spaceNo AS SPACENO, "+
                "spaceregistration.MEMBERCODE AS MEMBERCODE, "+
                "reservation.RESSTATE AS RESSTATE, "+
                "reservation.RESRECORDDATE AS RESRECORDDATE  "+
    "FROM resinfo LEFT JOIN reservation ON (resinfo.RESINFOCODE = reservation.RESINFOCODE) "+
	"LEFT JOIN subspace ON (reservation.SUBNO = subspace.SUBNO) "+
	"LEFT JOIN spaceregistration ON (spaceregistration.spaceNO = subspace.spaceNo) "+
	"WHERE spaceregistration.MEMBERCODE =? "+      
	"AND TO_CHAR(reservation.RESRECORDDATE,'YYYY-MM-DD')=? ) "+
	"SELECT * FROM (SELECT RANK() OVER(ORDER BY RESULT.RESINFOCODE DESC) AS NUM, RESULT.* FROM RESULT) "+
	"WHERE NUM between ? and ?";
*/		
		

		String query = "SELECT * " +
					" FROM " +
					"     ( " +
					"      SELECT ROWNUM AS num, " +
					"			  resno AS resNO,         " +
					"   	      resinfoname AS resInfoName,	 " +
					"			  subname AS subName,		 " +
					"			  resrecorddate AS resRecordDate, " +
					"			  resstate		 " +
					"		 FROM " +
					"			 ( " +
					"			  SELECT r.resno, " +
					"					 ri.resinfoname, " +
					"					 r.subno, " +
					"					 (SELECT subname FROM subspace WHERE subno = r.subno) AS subname, " +
					"					 TO_CHAR(r.resrecorddate,'YYYY-MM-DD') AS resrecorddate, " +
					"					 r.resstate " +
					"				FROM reservation r, " + 
					"					 resinfo ri, " +
					"					 member m, " +
					"					 spaceregistration s, " +
					"					 subspace ss " +
					"			   WHERE r.resinfocode = ri.resinfocode " +
					"				 AND m.memberid = ? " +
					"	  			 AND TO_CHAR(r.resrecorddate, 'YYYY-MM-DD') = ? " +
					"	  			 AND m.membercode = s.membercode " +
					"	  			 AND s.spaceno = ss.spaceno " +
					"	  			 AND r.subno = ss.subno " +
					"   		   ORDER BY r.resrecorddate " +
					"			  ) " +
					"		) " +
					" WHERE num BETWEEN ? AND ? ";
		
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query);
			
			
			//우선 날짜 빼고 해볼께요 잠시만요 나오는거 보면 현재 날짜가 제대로 안잡혀서 그래요 이거 날짜 잡아보죠
			
			pstmt.setString(1, "value");
			pstmt.setString(2, s);
			//pstmt.setDate(2, s);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				AllReservation al = new AllReservation();
				al.setResNO(rset.getString("resNO"));
				al.setResInfoName(rset.getString("resInfoName"));
				al.setSubName(rset.getString("subName"));
				al.setResRecordDate(rset.getDate("resRecordDate"));
				al.setResState(rset.getString("resState").charAt(0));
				
				list.add(al);
			
				  
				System.out.println("쿼리후 여기까지 오니?" +al.getResInfoName() +"/"+al.getResNO()+"/"+al.getResRecordDate()+"/"+al.getResState()+"/"+al.getSubName());
			
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

	public String getPageNavi(Connection conn, int currentPage, String s, String memberCode, int recordCountPerPage, int naviCountPerPage) {
		int postTotalCount = postTotalCount(conn,s,memberCode);
		//System.out.println(postTotalCount);
		int pageTotalCount; //전체 페이지를 저장하는 변수
		if(postTotalCount % recordCountPerPage > 0) {  //나머지가 있다면
			pageTotalCount = postTotalCount / recordCountPerPage + 1;  //몫+1 개수
			//예)pageTotalCount = 108/5+1 ->22페이지
					
		}else {
			pageTotalCount = postTotalCount / recordCountPerPage + 0;   //몫 개수
			//예)pageTotalCount = 105/5 ->21페이지
		}
		int startNavi = ((currentPage-1)/naviCountPerPage) * naviCountPerPage +1; 
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}	
		StringBuilder sb = new StringBuilder();
		if(startNavi != 1) { //startNavi니 1, 6, 11...이런식인데 1이 아니면 2번째 3번째 네비잖아...
			sb.append("<a href='/allReservation.do?currentPage="+(startNavi-1)+"'><</a> "); //startNavi가 6이면 전페이지 5로 이동
			
		}
		for(int i = startNavi; i<=endNavi; i++) {
			if(i==currentPage){
				sb.append("<a href='/allReservation.do?currentPage="+i+"'><b>"+i+"</b></a> "); //현재 선택된 페이지는 진하게 표시해라.

			}else {
				sb.append("<a href='/allReservation.do?currentPage="+i+"'>"+i+"</a> "); //그렇지 않은 페이지는 진하게 처리하지 마.
			}
		}
		if(endNavi != pageTotalCount) {
			sb.append("<a href='/allReservation.do?currentPage="+(endNavi+1)+"'>></a> "); //startNavi가 6이면 다음페이지 7로 이동
			
		}
		System.out.println(sb);// <--sb출력 되는지 검사하는 코드
		System.out.println("여기까지는 된다");
		
		return sb.toString();
	}

	private int postTotalCount(Connection conn, String s, String memberCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int postTotalCount = 0;
		
		String query = "SELECT count(*) as totalCount FROM ( " + 
				"SELECT resinfo.RESINFOCODE AS RESINFOCODE,resinfo.RESINFONAME AS RESINFONAME, " + 
				"reservation.SUBNO AS SUBNO, subspace.SUBNAME AS SUBNAME,subspace.spaceNo AS SPACENO, spaceregistration.MEMBERCODE AS MEMBERCODE " + 
				", reservation.RESSTATE AS RESSTATE, reservation.RESRECORDDATE AS RESRECORDDATE " + 
				"FROM resinfo LEFT JOIN reservation ON (resinfo.RESINFOCODE = reservation.RESINFOCODE) " + 
				"LEFT JOIN subspace ON (reservation.SUBNO = subspace.SUBNO) " + 
				"LEFT JOIN spaceregistration ON (spaceregistration.spaceNO = subspace.spaceNo) " + 
				"WHERE spaceregistration.MEMBERCODE = ?" + 
				"    AND TO_CHAR(reservation.RESRECORDDATE,'YY/MM/DD')= ?) ";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberCode);
			pstmt.setString(2, s);
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

	

	public ArrayList<AllReservation> selectOneList(Connection conn, int currentPage, String startDate,
			int recordCountPerPage, String memberCode, String category) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AllReservation> list = new ArrayList<AllReservation>();
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		System.out.println("쿼리전 여기까지 왔니? 여기까지 도착함"+memberCode);
		String query= "WITH RESULT AS (SELECT "+
				"reservation.RESNO AS RESNO, "+
                "resinfo.RESINFOCODE AS RESINFOCODE,"+
                "resinfo.RESINFONAME AS RESINFONAME, "+
                "reservation.SUBNO AS SUBNO, "+
                "subspace.SUBNAME AS SUBNAME,"+
                "subspace.spaceNo AS SPACENO, "+
                "spaceregistration.MEMBERCODE AS MEMBERCODE, "+
                "reservation.RESSTATE AS RESSTATE, "+
                "reservation.RESRECORDDATE AS RESRECORDDATE  "+
    "FROM resinfo LEFT JOIN reservation ON (resinfo.RESINFOCODE = reservation.RESINFOCODE) "+
	"LEFT JOIN subspace ON (reservation.SUBNO = subspace.SUBNO) "+
	"LEFT JOIN spaceregistration ON (spaceregistration.spaceNO = subspace.spaceNo) "+
	"WHERE spaceregistration.MEMBERCODE =? "+   
	"AND reservation.resstate = ? "+
	"AND TO_CHAR(reservation.RESRECORDDATE,'YYYY-MM-DD')=? ) "+
	"SELECT * FROM (SELECT RANK() OVER(ORDER BY RESULT.RESINFOCODE DESC) AS NUM, RESULT.* FROM RESULT) "+
	"WHERE NUM between ? and ?";
	
		
		try {
			pstmt = conn.prepareStatement(query);
			
			System.out.println(memberCode);
			System.out.println(category);
			System.out.println(startDate);
			System.out.println(start);
			System.out.println(end);
			
			//우선 날짜 빼고 해볼께요 잠시만요 나오는거 보면 현재 날짜가 제대로 안잡혀서 그래요 이거 날짜 잡아보죠
			
			pstmt.setString(1, memberCode);
			pstmt.setString(2, category);
			pstmt.setString(3, startDate);
			pstmt.setInt(4, start);
			pstmt.setInt(5, end);
			rset = pstmt.executeQuery();
		System.out.println(rset+"힘내자");	
			
			while(rset.next()) {
				AllReservation al = new AllReservation();
				al.setResNO(rset.getString("resNO"));
				al.setResInfoName(rset.getString("resInfoName"));
				al.setSubName(rset.getString("subName"));
				al.setResRecordDate(rset.getDate("resRecordDate"));
				al.setResState(rset.getString("resState").charAt(0));
				
				list.add(al);
			
				  
				System.out.println("쿼리후 여기까지 오니?" +al.getResInfoName() +"/"+al.getResNO()+"/"+al.getResRecordDate()+"/"+al.getResState()+"/"+al.getSubName());
			
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

	public ArrayList<AllReservation> selectOneListc(Connection conn, int currentPage, String startDate,
			int recordCountPerPage, String memberCode) {
		
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<AllReservation> list = new ArrayList<AllReservation>();
			int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
			int end = currentPage * recordCountPerPage;
			System.out.println("쿼리전 여기까지 왔니? 여기까지 도착함"+memberCode);
			String query= "WITH RESULT AS (SELECT "+
					"reservation.RESNO AS RESNO, "+
	                "resinfo.RESINFOCODE AS RESINFOCODE,"+
	                "resinfo.RESINFONAME AS RESINFONAME, "+
	                "reservation.SUBNO AS SUBNO, "+
	                "subspace.SUBNAME AS SUBNAME,"+
	                "subspace.spaceNo AS SPACENO, "+
	                "spaceregistration.MEMBERCODE AS MEMBERCODE, "+
	                "reservation.RESSTATE AS RESSTATE, "+
	                "reservation.RESRECORDDATE AS RESRECORDDATE  "+
	    "FROM resinfo LEFT JOIN reservation ON (resinfo.RESINFOCODE = reservation.RESINFOCODE) "+
		"LEFT JOIN subspace ON (reservation.SUBNO = subspace.SUBNO) "+
		"LEFT JOIN spaceregistration ON (spaceregistration.spaceNO = subspace.spaceNo) "+
		"WHERE spaceregistration.MEMBERCODE =? "+ 
		"AND reservation.resstate ='Y' "+
		"AND TO_CHAR(reservation.RESRECORDDATE,'YYYY-MM-DD')=? ) "+
		"SELECT * FROM (SELECT RANK() OVER(ORDER BY RESULT.RESINFOCODE DESC) AS NUM, RESULT.* FROM RESULT) "+
		"WHERE NUM between ? and ?";
		
			
			try {
				pstmt = conn.prepareStatement(query);
				
				System.out.println(memberCode);
				
				System.out.println(startDate);
				System.out.println(start);
				System.out.println(end);
				
				//우선 날짜 빼고 해볼께요 잠시만요 나오는거 보면 현재 날짜가 제대로 안잡혀서 그래요 이거 날짜 잡아보죠
				
				pstmt.setString(1, memberCode);
				
				pstmt.setString(2, startDate);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
				rset = pstmt.executeQuery();
			System.out.println(rset+"힘내자");	
				
				while(rset.next()) {
					AllReservation al = new AllReservation();
					al.setResNO(rset.getString("resNO"));
					al.setResInfoName(rset.getString("resInfoName"));
					al.setSubName(rset.getString("subName"));
					al.setResRecordDate(rset.getDate("resRecordDate"));
					al.setResState(rset.getString("resState").charAt(0));
					
					list.add(al);
				
					  
					System.out.println("쿼리후 여기까지 오니?" +al.getResInfoName() +"/"+al.getResNO()+"/"+al.getResRecordDate()+"/"+al.getResState()+"/"+al.getSubName());
				
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

	

}

	
