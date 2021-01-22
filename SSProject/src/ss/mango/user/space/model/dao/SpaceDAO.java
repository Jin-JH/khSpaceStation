package ss.mango.user.space.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ss.mango.common.JDBCTemplate;
import ss.mango.user.space.model.vo.ResInfo;
import ss.mango.user.space.model.vo.Reservation;
import ss.mango.user.space.model.vo.ReservationDetails;
import ss.mango.user.space.model.vo.SpaceRegistration;
import ss.mango.user.space.model.vo.SubSpace;

public class SpaceDAO {

	public ArrayList<SpaceRegistration> selectRecentSpace(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<SpaceRegistration> list = new ArrayList<SpaceRegistration>();
		
		String query = "SELECT * FROM "
					+  "(SELECT * FROM SPACEREGISTRATION "
					+  "LEFT JOIN FILETBL ON (SPACEREGISTRATION.MEMBERCODE = FILETBL.FILEUSER) "
					+  "LEFT JOIN (SELECT SPACENO, MIN(SUBCOST) AS MINSUBCOST "
					+  "		   FROM SUBSPACE "
					+  "		   GROUP BY SPACENO) USING(SPACENO) "
					+  "ORDER BY SPACEDATE DESC) "
					+  "WHERE ROWNUM <= 10 AND SPACEAPRYNC = 'Y'";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SpaceRegistration space = new SpaceRegistration();
				space.setSpaceNo(rset.getString("SPACENO"));
				space.setMemberCode(rset.getString("MEMBERCODE"));
				space.setSpaceIntro(rset.getString("SPACEINTRO"));
				space.setSpaceName(rset.getString("SPACENAME"));
				space.setSpaceAddress(rset.getString("SPACEADDRESS"));
				space.setSpaceEmail(rset.getString("SPACEEMAIL"));
				space.setSpaceTel(rset.getString("SPACETEL"));
				space.setSpacePhone(rset.getString("SPACEPHONE"));
				space.setSpaceSize(rset.getInt("SPACESIZE"));
				space.setClosedDay(rset.getString("CLOSEDDAY"));
				space.setOperation24(rset.getString("OPERATION24"));
				space.setStartTime(rset.getString("STARTTIME"));
				space.setLastTime(rset.getString("LASTTIME"));
				space.setAdditionalInfo(rset.getString("ADDITIONALINFO"));
				space.setSpaceDate(rset.getDate("SPACEDATE"));
				space.setSpaceDel(rset.getString("SPACEDEL").charAt(0));
				space.setSpaceDelDate(rset.getDate("SPACEDELDATE"));
				space.setMinSubCost(rset.getInt("MINSUBCOST"));
				space.setFileName(rset.getString("CHANGEDFILENAME"));
				
				list.add(space);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public ArrayList<SpaceRegistration> SpaceAllListPage(Connection conn, String location) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SpaceRegistration> list = new ArrayList<SpaceRegistration>();
		
		String query = "SELECT * FROM SPACEREGISTRATION"
					+  "	LEFT JOIN FILETBL ON (SPACEREGISTRATION.MEMBERCODE = FILETBL.FILEUSER) "
					+  "	LEFT JOIN(SELECT SPACENO, MIN(SUBCOST) AS MINSUBCOST "
					+  "			  FROM SUBSPACE"
					+  "			  GROUP BY SPACENO) USING(SPACENO) "
					+  "WHERE SPACEADDRESS LIKE ? AND SPACEAPRYNC = 'Y' "
					+  "ORDER BY MINSUBCOST ASC";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + location + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SpaceRegistration space = new SpaceRegistration();
				space.setSpaceNo(rset.getString("SPACENO"));
				space.setMemberCode(rset.getString("MEMBERCODE"));
				space.setSpaceIntro(rset.getString("SPACEINTRO"));
				space.setSpaceName(rset.getString("SPACENAME"));
				space.setSpaceAddress(rset.getString("SPACEADDRESS"));
				space.setSpaceEmail(rset.getString("SPACEEMAIL"));
				space.setSpaceTel(rset.getString("SPACETEL"));
				space.setSpacePhone(rset.getString("SPACEPHONE"));
				space.setSpaceSize(rset.getInt("SPACESIZE"));
				space.setClosedDay(rset.getString("CLOSEDDAY"));
				space.setOperation24(rset.getString("OPERATION24"));
				space.setStartTime(rset.getString("STARTTIME"));
				space.setLastTime(rset.getString("LASTTIME"));
				space.setAdditionalInfo(rset.getString("ADDITIONALINFO"));
				space.setSpaceDate(rset.getDate("SPACEDATE"));
				space.setSpaceDel(rset.getString("SPACEDEL").charAt(0));
				space.setSpaceDelDate(rset.getDate("SPACEDELDATE"));
				space.setMinSubCost(rset.getInt("MINSUBCOST"));
				space.setFileName(rset.getString("CHANGEDFILENAME"));
				
				list.add(space);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<SpaceRegistration> SpaceAllListPage(Connection conn, String location, String price) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SpaceRegistration> list = new ArrayList<SpaceRegistration>();
		
		String query = "SELECT * FROM SPACEREGISTRATION"
					+  "	LEFT JOIN FILETBL ON (SPACEREGISTRATION.MEMBERCODE = FILETBL.FILEUSER) "
					+  "	LEFT JOIN(SELECT SPACENO, MIN(SUBCOST) AS MINSUBCOST "
					+  "			  FROM SUBSPACE"
					+  "			  GROUP BY SPACENO) USING(SPACENO) "
					+  "WHERE SPACEADDRESS LIKE ? AND SPACEAPRYNC = 'Y' AND MINSUBCOST IS NOT NULL "
					+  "ORDER BY MINSUBCOST DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + location + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SpaceRegistration space = new SpaceRegistration();
				space.setSpaceNo(rset.getString("SPACENO"));
				space.setMemberCode(rset.getString("MEMBERCODE"));
				space.setSpaceIntro(rset.getString("SPACEINTRO"));
				space.setSpaceName(rset.getString("SPACENAME"));
				space.setSpaceAddress(rset.getString("SPACEADDRESS"));
				space.setSpaceEmail(rset.getString("SPACEEMAIL"));
				space.setSpaceTel(rset.getString("SPACETEL"));
				space.setSpacePhone(rset.getString("SPACEPHONE"));
				space.setSpaceSize(rset.getInt("SPACESIZE"));
				space.setClosedDay(rset.getString("CLOSEDDAY"));
				space.setOperation24(rset.getString("OPERATION24"));
				space.setStartTime(rset.getString("STARTTIME"));
				space.setLastTime(rset.getString("LASTTIME"));
				space.setAdditionalInfo(rset.getString("ADDITIONALINFO"));
				space.setSpaceDate(rset.getDate("SPACEDATE"));
				space.setSpaceDel(rset.getString("SPACEDEL").charAt(0));
				space.setSpaceDelDate(rset.getDate("SPACEDELDATE"));
				space.setMinSubCost(rset.getInt("MINSUBCOST"));
				space.setFileName(rset.getString("CHANGEDFILENAME"));
				
				list.add(space);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public SpaceRegistration SelectSpace(Connection conn, String spaceNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SpaceRegistration space = null;
		
		String query = "SELECT * FROM SPACEREGISTRATION "
					+  "LEFT JOIN FILETBL ON (SPACEREGISTRATION.MEMBERCODE = FILETBL.FILEUSER) "
					+  "WHERE SPACENO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, spaceNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				space = new SpaceRegistration();
				space.setSpaceNo(rset.getString("SPACENO"));
				space.setMemberCode(rset.getString("MEMBERCODE"));
				space.setSpaceIntro(rset.getString("SPACEINTRO"));
				space.setSpaceName(rset.getString("SPACENAME"));
				space.setSpaceAddress(rset.getString("SPACEADDRESS"));
				space.setSpaceEmail(rset.getString("SPACEEMAIL"));
				space.setSpaceTel(rset.getString("SPACETEL"));
				space.setSpacePhone(rset.getString("SPACEPHONE"));
				space.setSpaceSize(rset.getInt("SPACESIZE"));
				space.setClosedDay(rset.getString("CLOSEDDAY"));
				space.setOperation24(rset.getString("OPERATION24"));
				space.setStartTime(rset.getString("STARTTIME"));
				space.setLastTime(rset.getString("LASTTIME"));
				space.setAdditionalInfo(rset.getString("ADDITIONALINFO"));
				space.setSpaceDate(rset.getDate("SPACEDATE"));
				space.setSpaceDel(rset.getString("SPACEDEL").charAt(0));
				space.setSpaceDelDate(rset.getDate("SPACEDELDATE"));
				space.setFileName(rset.getString("CHANGEDFILENAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return space;
	}

	public ArrayList<SubSpace> SelectSubSpace(Connection conn, String spaceNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SubSpace> list = new ArrayList<SubSpace>();
				
		String query = "SELECT * FROM SUBSPACE WHERE SPACENO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, spaceNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SubSpace subspace = new SubSpace();
				subspace.setSubNo(rset.getString("SUBNO"));
				subspace.setSpaceNo(rset.getString("SPACENO"));
				subspace.setSubName(rset.getString("SUBNAME"));
				subspace.setSubIntro(rset.getString("SUBINTRO"));
				subspace.setSubType(rset.getString("SUBTYPE"));
				subspace.setMinTime(rset.getInt("MINTIME"));
				subspace.setMinPeople(rset.getInt("MINPEOPLE"));
				subspace.setMaxPeople(rset.getInt("MAXPEOPLE"));
				subspace.setAmenities(rset.getString("AMENITIES"));
				subspace.setSubDate(rset.getDate("SUBDATE"));
				subspace.setSubDel(rset.getString("SUBDEL").charAt(0));
				subspace.setSubDelDate(rset.getDate("SUBDELDATE"));
				subspace.setSubAprync(rset.getString("SUBAPRYNC").charAt(0));
				subspace.setSubOpen(rset.getString("SUBOPEN").charAt(0));
				subspace.setSubCost(rset.getInt("SUBCOST"));
				
				list.add(subspace);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public SubSpace choiceSubSpace(Connection conn, String spaceNo, String resSubSpaceName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SubSpace subspace = null;
		
		String query = "SELECT * FROM SUBSPACE WHERE SPACENO=? AND SUBNAME=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, spaceNo);
			pstmt.setString(2, resSubSpaceName);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				subspace = new SubSpace();
				subspace.setSubNo(rset.getString("SUBNO"));
				subspace.setSpaceNo(rset.getString("SPACENO"));
				subspace.setSubName(rset.getString("SUBNAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return subspace;
	}

	public int insertResInfo(Connection conn, String memberCode, String resInfoName, String resInfoPhone, String resInfoEmail,
			String usePurpose, String requestItem) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO RESINFO VALUES('RI'||TO_CHAR(RESINFO_SEQ.NEXTVAL,'FM000009'),?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberCode);
			pstmt.setString(2, resInfoName);
			pstmt.setString(3, resInfoPhone);
			pstmt.setString(4, resInfoEmail);
			pstmt.setString(5, usePurpose);
			pstmt.setString(6, requestItem);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ResInfo searchResInfo(Connection conn, String memberCode, String resInfoName, String resInfoEmail) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ResInfo resinfo = null;
		
		String query = "SELECT * FROM RESINFO WHERE MEMBERCODE = ? AND RESINFONAME = ? AND RESINFOEMAIL = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberCode);
			pstmt.setString(2, resInfoName);
			pstmt.setString(3, resInfoEmail);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				resinfo = new ResInfo();
				resinfo.setResInfoCode(rset.getString("RESINFOCODE"));
				resinfo.setMemberCode(rset.getString("MEMBERCODE"));
				resinfo.setResInfoName(rset.getString("RESINFONAME"));
				resinfo.setResInfoPhone(rset.getString("RESINFOPHONE"));
				resinfo.setResInfoEmail(rset.getString("RESINFOEMAIL"));
				resinfo.setUsePurpose(rset.getString("USEPURPOSE"));
				resinfo.setRequirements(rset.getString("REQUIREMENTS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return resinfo;
	}

	public int spacePaySuccess(Connection conn, String resInfoCode, String subNo, Date resDate, int startTime, int endTime,
			int resPeople, int payPrice, String memberCode) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO RESERVATION VALUES('R'||TO_CHAR(RES_SEQ.NEXTVAL,'FM000009'),?,?,?,?,?,?,DEFAULT,'N','',?,'',?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, resInfoCode);
			pstmt.setString(2, subNo);
			pstmt.setDate(3, resDate);
			pstmt.setInt(4, startTime);
			pstmt.setInt(5, endTime);
			pstmt.setInt(6, resPeople);
			pstmt.setInt(7, payPrice);
			pstmt.setString(8, memberCode);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	public Reservation searchReservation(Connection conn, String resInfoCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Reservation reservation = null;
		
		String query = "SELECT * FROM RESERVATION WHERE RESINFOCODE = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, resInfoCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reservation = new Reservation();
				reservation.setResNo(rset.getString("RESNO"));
				reservation.setResInfoCode(rset.getString("RESINFOCODE"));
				reservation.setSubNo(rset.getString("SUBNO"));
				reservation.setResDate(rset.getDate("RESDATE"));
				reservation.setResStartTime(rset.getInt("RESSTARTTIME"));
				reservation.setResEndTime(rset.getInt("RESENDTIME"));
				reservation.setResPeople(rset.getInt("RESPEOPLE"));
				reservation.setResRecordDate(rset.getDate("RESRECORDDATE"));
				reservation.setResState(rset.getString("RESSTATE").charAt(0));
				reservation.setUsercost(rset.getInt("USERCOST"));
				reservation.setMemberCode(rset.getString("MEMBERCODE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return reservation;
	}

	public ArrayList<ReservationDetails> selectReservation(Connection conn, String memberCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReservationDetails> list = new ArrayList<ReservationDetails>();
		
		String query = "SELECT RESERVATION.RESNO, SPACEREGISTRATION.SPACENAME, SUBSPACE.SUBTYPE, SUBSPACE.SUBNAME, "
					+	"RESERVATION.RESDATE, RESERVATION.RESSTARTTIME, RESERVATION.RESENDTIME, RESERVATION.RESPEOPLE, "
					+	"RESERVATION.RESSTATE, RESERVATION.USERCOST "
					+	"FROM SPACEREGISTRATION "
					+ 	"LEFT JOIN SUBSPACE USING(SPACENO) " 
					+	"LEFT JOIN RESERVATION USING(SUBNO) " 
					+	"WHERE RESERVATION.MEMBERCODE=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberCode);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReservationDetails reservationDetails = new ReservationDetails();
				reservationDetails.setResNo(rset.getString("RESNO"));
				reservationDetails.setSpaceName(rset.getString("SPACENAME"));
				reservationDetails.setSubType(rset.getString("SUBTYPE"));
				reservationDetails.setSubName(rset.getString("SUBNAME"));
				reservationDetails.setResDate(rset.getDate("RESDATE"));
				reservationDetails.setResStartTime(rset.getInt("RESSTARTTIME"));
				reservationDetails.setResEndTime(rset.getInt("RESENDTIME"));
				reservationDetails.setResPeople(rset.getInt("RESPEOPLE"));
				reservationDetails.setResState(rset.getString("RESSTATE").charAt(0));
				reservationDetails.setUserCost(rset.getInt("USERCOST"));
				
				list.add(reservationDetails);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public ResInfo selectOneReservation(Connection conn, String resNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ResInfo resinfo = null;
		
		String query = "SELECT * FROM RESINFO "
					+	"LEFT JOIN RESERVATION USING(RESINFOCODE) " 
					+	"WHERE RESNO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, resNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				resinfo = new ResInfo();
				resinfo.setResInfoCode(rset.getString("RESINFOCODE"));
				resinfo.setMemberCode(rset.getString("MEMBERCODE"));
				resinfo.setResInfoName(rset.getString("RESINFONAME"));
				resinfo.setResInfoPhone(rset.getString("RESINFOPHONE"));
				resinfo.setResInfoEmail(rset.getString("RESINFOEMAIL"));
				resinfo.setUsePurpose(rset.getString("USEPURPOSE"));
				resinfo.setRequirements(rset.getString("REQUIREMENTS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return resinfo;
	}

	public ReservationDetails selectOneReservation(Connection conn, String memberCode, String resNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ReservationDetails resDetails = null;
		String query = "SELECT RESERVATION.RESNO, SPACEREGISTRATION.SPACENAME, SUBSPACE.SUBTYPE, SUBSPACE.SUBNAME, "
					+ 	"RESERVATION.RESDATE, RESERVATION.RESSTARTTIME, RESERVATION.RESENDTIME, RESERVATION.RESPEOPLE, "
					+ 	"RESERVATION.RESSTATE, RESERVATION.USERCOST "
					+	"FROM SPACEREGISTRATION "
					+	"LEFT JOIN SUBSPACE USING(SPACENO) "
					+	"LEFT JOIN RESERVATION USING(SUBNO) "
					+	"WHERE RESERVATION.MEMBERCODE=? AND RESNO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberCode);
			pstmt.setString(2, resNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				resDetails = new ReservationDetails();
				resDetails.setResNo(rset.getString("RESNO"));
				resDetails.setSpaceName(rset.getString("SPACENAME"));
				resDetails.setSubType(rset.getString("SUBTYPE"));
				resDetails.setSubName(rset.getString("SUBNAME"));
				resDetails.setResDate(rset.getDate("RESDATE"));
				resDetails.setResStartTime(rset.getInt("RESSTARTTIME"));
				resDetails.setResEndTime(rset.getInt("RESENDTIME"));
				resDetails.setResPeople(rset.getInt("RESPEOPLE"));
				resDetails.setResState(rset.getString("RESSTATE").charAt(0));
				resDetails.setUserCost(rset.getInt("USERCOST"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return resDetails;
		
	}

	public ArrayList<ResInfo> checkNamecheckPhone(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ResInfo> list = new ArrayList<ResInfo>(); 
		String query = "SELECT * FROM RESINFO";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ResInfo resinfo = new ResInfo();
				resinfo.setResInfoCode(rset.getString("RESINFOCODE"));
				resinfo.setMemberCode(rset.getString("MEMBERCODE"));
				resinfo.setResInfoName(rset.getString("RESINFONAME"));
				resinfo.setResInfoPhone(rset.getString("RESINFOPHONE"));
				resinfo.setResInfoEmail(rset.getString("RESINFOEMAIL"));
				resinfo.setUsePurpose(rset.getString("USEPURPOSE"));
				resinfo.setRequirements(rset.getString("REQUIREMENTS"));
				
				list.add(resinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Reservation> ReservationStatusView(Connection conn, String subno, String resdate) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		
		String query = "SELECT * FROM RESERVATION "
				     + "WHERE SUBNO = ? AND TO_CHAR(RESDATE,'YYYYMMDD') = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, subno);
			pstmt.setString(2, resdate);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Reservation res = new Reservation();
				res.setResNo(rset.getString("RESNO"));
				res.setResInfoCode(rset.getString("RESINFOCODE"));
				res.setSubNo(rset.getString("SUBNO"));
				res.setResDate(rset.getDate("RESDATE"));
				res.setResStartTime(rset.getInt("RESSTARTTIME"));
				res.setResEndTime(rset.getInt("RESENDTIME"));
				res.setResPeople(rset.getInt("RESPEOPLE"));
				res.setResRecordDate(rset.getDate("RESRECORDDATE"));
				res.setResState(rset.getString("RESSTATE").charAt(0));
				res.setUsercost(rset.getInt("USERCOST"));
				res.setMemberCode(rset.getString("MEMBERCODE"));
				
				list.add(res);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
}