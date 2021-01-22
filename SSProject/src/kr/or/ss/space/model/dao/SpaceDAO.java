package kr.or.ss.space.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.ss.common.JDBCTemplate;
import kr.or.ss.space.model.vo.DashCost;
import kr.or.ss.space.model.vo.MRManagement;
import kr.or.ss.space.model.vo.PartnerSpace;
import kr.or.ss.space.model.vo.Space;
import kr.or.ss.space.model.vo.SpaceCost;
import kr.or.ss.space.model.vo.SubSpace;

//meetingRoomManagement DAO

public class SpaceDAO {

	public static ArrayList<MRManagement> selectAllBoardPageList(Connection conn, int currentPage, int recordCountPerPage) {  //공간관리
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<MRManagement> list = new ArrayList<MRManagement>();
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		
		//select row_num,spacename, subno, subname, subdate, subopen from(select row_number() over(order by subdate desc)as row_num,spacename, subno, subname, subdate, subopen from spaceregistration left join subspace using(spaceno)) where row_num between 2 and 5;
		//String query = "select row_num,spacename, subno, subname, subdate, subopen from(select row_number() over(order by subdate desc)as row_num,spacename, subno, subname, subdate, subopen from spaceregistration left join subspace using(spaceno))"
		//					+ "where row_num between ? and ?";
		//String query="select spacename, subno,subname,subdate,subopen from subspace left join spaceregistration using(spaceno)"; //시험코드
		String query = " select e.* from( " + 
				"select row_number() over (order by subdate desc) as num, spacename, subno,subname,subdate,subopen " + 
				"from ( select * from subspace left join spaceregistration using(spaceno)))e " + 
				"where num between ? and ?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				MRManagement mrManagement = new MRManagement();
				mrManagement.setSpaceName(rset.getString("spaceName"));
				mrManagement.setSubNO(rset.getString("subNO"));
				mrManagement.setSubName(rset.getString("subName"));
				mrManagement.setSubDate(rset.getDate("subDate"));
				mrManagement.setSubOpen(rset.getString("subOpen").charAt(0));
				
				list.add(mrManagement);
				
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
		
		StringBuilder sb = new StringBuilder(); 
		if(startNavi != 1) { //startNavi니 1, 6, 11...이런식인데 1이 아니면 2번째 3번째 네비잖아...
			sb.append("<a href='/boardAllListPage.do?currentPage="+(startNavi-1)+"'><</a> "); //startNavi가 6이면 전페이지 5로 이동
			
		}
		for(int i = startNavi; i<=endNavi; i++) {
			if(i==currentPage){
				sb.append("<a href='/boardAllListPage.do?currentPage="+i+"'><b>"+i+"</b></a> "); //현재 선택된 페이지는 진하게 표시해라.

			}else {
				sb.append("<a href='/boardAllListPage.do?currentPage="+i+"'>"+i+"</a> "); //그렇지 않은 페이지는 진하게 처리하지 마.
			}
		}
		if(endNavi != pageTotalCount) {
			sb.append("<a href='/boardAllListPage.do?currentPage="+(endNavi+1)+"'>></a> "); //startNavi가 6이면 다음페이지 7로 이동
			
		}

		
		return sb.toString();
	}

	private static int postTotalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int postTotalCount = 0;
		
		String query = "SELECT COUNT(*) as totalCount " + 
                "FROM SpaceRegistration left join SubSpace using(spaceno) where spaceDel='N' and subDel='N'";

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

	public static int insertSpace(Connection conn, Space s, String memberCode) {
		PreparedStatement pstmt = null;
		String query = "insert into spaceregistration values((TO_CHAR(SYSDATE,'YYYYMMDD')||SPACE_SEQ.NEXTVAL),?,?,?,?,?,?,?,?,?,?,?,?,?,default,'N',null,'N')";
		int result=0;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, memberCode);
			pstmt.setString(2, s.getSpaceIntro());
			pstmt.setString(3, s.getSpaceName());		
			pstmt.setString(4, s.getSpaceAddress());
			pstmt.setString(5, s.getSpaceEmail());
			pstmt.setString(6, s.getSpaceTel());
			pstmt.setString(7, s.getSpacePhone());
			pstmt.setInt(8, s.getSpaceSize());
			pstmt.setString(9, s.getClosedDay());
			pstmt.setString(10, s.getOperation24());
			pstmt.setString(11, s.getStartTime());
			pstmt.setString(12, s.getLastTime());
			pstmt.setString(13, s.getAdditionalInfo());
			result=pstmt.executeUpdate();
			
			
			System.out.println(s.getSpaceIntro());
			System.out.println(s.getSpaceName());
			System.out.println(s.getSpaceSize());
			System.out.println(s.getSpaceAddress());
			System.out.println(s.getSpaceEmail());
			System.out.println(s.getSpacePhone());
			System.out.println(s.getSpaceTel());
			System.out.println(s.getClosedDay());
			System.out.println(s.getOperation24());
			System.out.println(s.getStartTime());
			System.out.println(s.getLastTime());
			System.out.println(s.getAdditionalInfo());
			System.out.println("dao"+result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public static ArrayList<MRManagement> selectAllBoardPageList(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		ArrayList<MRManagement> list = new ArrayList<MRManagement>();

		String query="select subno, subopen from subspace where subdel = 'N'";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				MRManagement mrm = new MRManagement();
				mrm.setSubNO(rset.getString("subNO"));
				mrm.setSubOpen(rset.getString("subOpen").charAt(0));
				list.add(mrm);
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

	public static int updateSpace(String[] checkValues, Connection conn) {
		PreparedStatement pstmt=null;
		 
		
		 String query="update subspace set subopen=decode(subopen,'Y', 'N','Y') WHERE subno in ( ? ";
		
	for (int i=1; i<checkValues.length;i++) {query+=",? ";
			} 
	query += ") ";
		
		System.out.println(query);
		int result=0;
		try {
			pstmt = conn.prepareStatement(query);
			
			for(int i=0; i<checkValues.length; i++) {
				pstmt.setString(i+1, checkValues[i]);
			}

			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
// ===========================================================================
	
	//메인공간 등록 현황  
		public Space selectAllSpace(Connection conn, String memberCode) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			Space s = null;
			
			String query = "SELECT * FROM SPACEREGISTRATION " +
						   "	LEFT JOIN FILETBL ON(FILETBL.FILEUSER = SPACEREGISTRATION.MEMBERCODE) " +
						   "WHERE MEMBERCODE = " +
						   "(SELECT MEMBERCODE FROM MEMBER WHERE MEMBERCODE =?) " +
						   "AND SPACEDEL = 'N'";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, memberCode);
				rset = pstmt.executeQuery();
				
				
				if(rset.next()) {
					s = new Space();
					s.setSpaceNo(rset.getString("spaceNo"));
					s.setMemberCode(rset.getString("memberCode"));
					s.setSpaceIntro(rset.getString("spaceIntro"));
					s.setSpaceName(rset.getString("spaceName"));
					s.setSpaceAddress(rset.getString("spaceAddress"));
					s.setSpaceEmail(rset.getString("spaceEmail"));
					s.setSpaceTel(rset.getString("spaceTel"));
					s.setSpacePhone(rset.getString("spacePhone"));
					s.setSpaceSize(rset.getInt("spaceSize"));
					s.setSpaceDate(rset.getDate("spaceDate"));
					s.setClosedDay(rset.getString("closedDay"));
					s.setOperation24(rset.getString("operation24"));
					s.setStartTime(rset.getString("startTime"));
					s.setLastTime(rset.getString("lastTime"));
					s.setAdditionalInfo(rset.getString("additionalInfo"));
					s.setAprYNC(rset.getString("spaceAprYNC").charAt(0));
					s.setSpaceDel(rset.getString("spaceDel").charAt(0));
					s.setFileLoadName(rset.getString("CHANGEDFILENAME"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return s;
		}
		
		
		
		
		//세부공간 리스트 불러오기
		public ArrayList<SubSpace> selectSubSpaceAll(Connection conn, String spaceNo) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<SubSpace> list = new ArrayList<SubSpace>();
			String query = "SELECT * FROM SUBSPACE " +
						   "WHERE SUBDEL='N' "+
						   "AND SPACENO = (SELECT SPACENO FROM SPACEREGISTRATION WHERE SPACENO = ? )" +
						   "ORDER BY SUBDATE";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, spaceNo);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					SubSpace sSub = new SubSpace();
					sSub.setSubNO(rset.getString("subNO")); //1
					sSub.setSubNO(rset.getString("spaceNo")); //2
					sSub.setSubName(rset.getString("subName")); //3
					sSub.setSubIntro(rset.getString("subIntro")); //4
					sSub.setSubType(rset.getString("subType")); //5
					sSub.setMinTime(rset.getInt("minTime")); //6
					sSub.setMinPeople(rset.getInt("minPeople")); //7
					sSub.setMaxPeople(rset.getInt("maxPeople")); //8
					sSub.setAmenities(rset.getString("amenities")); //9
					sSub.setSubDate(rset.getDate("subDate")); //10
					sSub.setSubDel(rset.getString("subDel").charAt(0)); //11
					//sSub.setSubDelDate(rset.getDate("subDelDate")); //12
					sSub.setSubAPRYNC(rset.getString("subAPRYNC").charAt(0)); //13
					sSub.setSubOpen(rset.getString("subOpen").charAt(0)); //14
					sSub.setSubCost(rset.getInt("subCost")); //15
					sSub.setRefundFees(rset.getString("refundFees")); //16
					
					list.add(sSub);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return list;
		}
		
		
		
		//세부공간 등록
		public int insertSubSpace(Connection conn, SubSpace sSub, String memberCode) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			/*
			 INSERT INTO SUBSPACE VALUES ( 
	    	 TO_CHAR(SYSDATE,'YYYYMMDD')||SUBSPACE_SEQ.NEXTVAL, 
	    	 (SELECT SPACENO FROM SPACEREGISTRATION WHERE MEMBERCODE = 1memberCode), 
	    	  2세부공간이름, 3세부공간소개, 4세부공간타입, 5최소시간, 6최소인원, 7최대인원, 
	    	  8편의시설, SYSDATE, 'N', '', 'N', 'Y', 9시간당금액, 10환불수수료
				);
			 */
			String query = "INSERT INTO SUBSPACE VALUES ( " +
						   "TO_CHAR(SYSDATE,'YYYYMMDD')||SUBSPACE_SEQ.NEXTVAL, " +
						   "(SELECT SPACENO FROM SPACEREGISTRATION WHERE MEMBERCODE = ?), " +
						   " ?, ?, ?, ?, ?, ?, " +
						   "?, SYSDATE, 'N', '', 'N', 'Y', ? , ?)";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, memberCode);
				pstmt.setString(2, sSub.getSubName());
				pstmt.setString(3, sSub.getSubIntro());
				pstmt.setString(4, sSub.getSubType());
				pstmt.setInt(5, sSub.getMinTime());
				pstmt.setInt(6, sSub.getMinPeople());
				pstmt.setInt(7, sSub.getMaxPeople());
				pstmt.setString(8, sSub.getAmenities());
				pstmt.setInt(9, sSub.getSubCost());
				pstmt.setString(10, sSub.getRefundFees());
				
				result = pstmt.executeUpdate();
				//성공하면 성공한 행의 수 반환, 실패하면 0 반환
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}



		//사업자별 공간 현황
		public ArrayList<PartnerSpace> partnerSpace(Connection conn, String memberCode) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<PartnerSpace> psList = new ArrayList<PartnerSpace>();
			String query ="SELECT SPACENO, SUBNO, SPACEDEL, SPACEAPRYNC, SUBDEL, SUBAPRYNC, SUBOPEN " + 
						  "FROM SPACEREGISTRATION S " + 
						  "LEFT JOIN SUBSPACE SUB USING (SPACENO) " + 
						  "LEFT JOIN MEMBER MEM USING (MEMBERCODE) " + 
						  "WHERE MEMBERCODE = ? AND SUBDEL IS NOT NULL";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, memberCode);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					PartnerSpace ps = new PartnerSpace();
					ps.setSpaceNo(rset.getString("spaceNo"));
					ps.setSubNo(rset.getString("subNo"));
					ps.setSpaceDel(rset.getString("spaceDel").charAt(0));
					ps.setSpaceApr(rset.getString("spaceAprYNC").charAt(0));
					ps.setSubDel(rset.getString("subDel").charAt(0));
					ps.setSubApr(rset.getString("subAprYNC").charAt(0));
					ps.setSubOpen(rset.getString("subOpen").charAt(0));
					
					psList.add(ps);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return psList;
		}






		//사업자(공간별)별 해당 예약 금액 불러오기-일주일치
		public ArrayList<SpaceCost> spaceCost(Connection conn, String spaceNo) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<SpaceCost> scList = new ArrayList<SpaceCost>();
			
			String query = "SELECT TO_CHAR(RESDATE,'YYYYMMDD') AS RDATE, " + 
						   		"SUM(NVL(USERCOST,0)) AS COST, " + 
						   		"COUNT(CASE WHEN RES.RESSTATE = 'N' THEN 1 END) AS stateN, " + 
						   		"COUNT(CASE WHEN RES.RESSTATE = 'Y' THEN 1 END) AS stateY  " + 
						   "FROM RESERVATION RES " + 
						   "LEFT JOIN SUBSPACE SUB USING (SUBNO) " + 
						   "WHERE SPACENO = ? " + 
						   "AND TO_CHAR(RES.RESDATE,'YYYYMMDD') " + 
						   		"BETWEEN TO_CHAR(SYSDATE-6,'YYYYMMDD') " + 
						   		"AND TO_CHAR(SYSDATE,'YYYYMMDD') " + 
						   "GROUP BY TO_CHAR(RESDATE,'YYYYMMDD') " + 
						   "ORDER BY RDATE DESC";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, spaceNo);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					SpaceCost sc = new SpaceCost();
					sc.setrDate(rset.getString("rDate"));
					sc.setCost(rset.getInt("cost"));
					sc.setStateN(rset.getInt("stateN"));
					sc.setStateY(rset.getInt("stateY"));
					
					scList.add(sc);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			
			return scList;
		}




		public ArrayList<SpaceCost> spaceCostM(Connection conn, String spaceNo) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<SpaceCost> scList = new ArrayList<SpaceCost>();
			
			String query = "SELECT TO_CHAR(RESDATE,'YYYYMM') AS RDATE, " + 
						   "SUM(NVL(USERCOST,0)) AS COST, " + 
						   "COUNT(CASE WHEN RES.RESSTATE = 'N' THEN 1 END) AS stateN, " + 
						   "COUNT(CASE WHEN RES.RESSTATE = 'Y' THEN 1 END) AS stateY  " + 
						   "FROM RESERVATION RES " + 
						   "LEFT JOIN SUBSPACE SUB USING (SUBNO) " + 
						   "WHERE SPACENO = ? " + 
						   "AND TO_CHAR(RES.RESDATE,'YYYYMM')  " + 
						   "BETWEEN TO_CHAR(ADD_MONTHS(SYSDATE,-12),'YYYYMM') " + 
						   "AND TO_CHAR(SYSDATE,'YYYYMM') " + 
						   "GROUP BY TO_CHAR(RESDATE,'YYYYMM') " + 
						   "ORDER BY RDATE DESC";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, spaceNo);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					SpaceCost sc = new SpaceCost();
					sc.setrDate(rset.getString("rDate"));
					sc.setCost(rset.getInt("cost"));
					sc.setStateN(rset.getInt("stateN"));
					sc.setStateY(rset.getInt("stateY"));
					
					scList.add(sc);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			
			return scList;
		}




		public ArrayList<SpaceCost> spaceCostW(Connection conn, String spaceNo) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<SpaceCost> scList = new ArrayList<SpaceCost>();

			String query = "SELECT TO_CHAR(RESDATE,'w') as WEEK, " + 
						   "SUM(NVL(USERCOST,0)) AS COST, " + 
						   "COUNT(CASE WHEN RES.RESSTATE = 'N' THEN 1 END) AS stateN, " + 
						   "COUNT(CASE WHEN RES.RESSTATE = 'Y' THEN 1 END) AS stateY " + 
						   "FROM RESERVATION RES " + 
						   "LEFT JOIN SUBSPACE SUB USING (SUBNO) " + 
						   "WHERE SPACENO = ? " + 
						   "AND TO_CHAR(RES.RESDATE,'YYYYMMDD') " + 
						   "BETWEEN TO_CHAR(ADD_MONTHS(SYSDATE,-1),'YYYYMMDD') " + 
						   "AND TO_CHAR(SYSDATE,'YYYYMMDD') " + 
						   "GROUP BY TO_CHAR(RESDATE,'w') " + 
						   "ORDER BY WEEK DESC";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, spaceNo);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					SpaceCost sc = new SpaceCost();
					sc.setrDate(rset.getString("week")); //몇째주인지 받아옴
					sc.setCost(rset.getInt("cost"));
					sc.setStateN(rset.getInt("stateN"));
					sc.setStateY(rset.getInt("stateY"));

					scList.add(sc);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			
			return scList;
		}

		//dashCost
		public DashCost spaceCostDash(Connection conn, String spaceNo) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			DashCost dc = null;
			
			String query = "SELECT NVL(SUM(NVL(USERCOST,0)),0) AS COST, " + 
						   "COUNT(CASE WHEN RES.RESSTATE = 'Y' THEN 1 END) AS stateY, " + 
						   "COUNT(CASE WHEN RES.RESSTATE = 'N' THEN 1 END) AS stateN " + 
						   "FROM RESERVATION RES " + 
						   "LEFT JOIN SUBSPACE SUB USING (SUBNO) " + 
						   "WHERE SPACENO = ? " + 
						   "AND TO_CHAR(RES.RESDATE,'YYYYMMDD')  " + 
						   "BETWEEN TO_CHAR(ADD_MONTHS(SYSDATE,-1),'YYYYMMDD') " + 
						   "AND TO_CHAR(SYSDATE,'YYYYMMDD') " + 
						   "ORDER BY RESDATE DESC";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, spaceNo);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					dc = new DashCost();
					dc.setDashCost(rset.getInt("cost"));
					dc.setStateN(rset.getInt("stateN"));
					dc.setStateY(rset.getInt("stateY"));
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			
			return dc;
		}

}
