package ss.mango.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ss.mango.admin.model.vo.Admin;
import ss.mango.admin.model.vo.CalculateInfo;
import ss.mango.admin.model.vo.Inquiry;
import ss.mango.admin.model.vo.InquiryAnswer;
import ss.mango.admin.model.vo.Partner;
import ss.mango.admin.model.vo.ResInfo;
import ss.mango.admin.model.vo.Reservation;
import ss.mango.admin.model.vo.SpaceRegistration;
import ss.mango.admin.model.vo.SubSpace;
import ss.mango.admin.model.vo.User;
import ss.mango.common.JDBCTemplate;

public class AdminDAO {

	public Admin loginAdmin(Connection conn, String adminId, String adminPw) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Admin a = null;
		
		String query = "SELECT * FROM ADMIN WHERE ADMINID = ? AND ADMINPW = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, adminId);
			pstmt.setString(2, adminPw);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				a = new Admin();
				
				a.setAdminCode(rset.getString("adminCode"));
				a.setAdminId(rset.getString("adminId"));
				a.setAdminPw(rset.getString("adminPw"));
				a.setPosition(rset.getString("position"));
				a.setAdminName(rset.getString("adminName"));
				a.setAdminPhone(rset.getString("adminPhone"));
				a.setAdminSubPhone(rset.getString("adminSubPhone"));
				a.setAdminEmail(rset.getString("adminEmail"));
				a.setRight(rset.getString("right").charAt(0));
				a.setAdminDate(rset.getDate("admindate"));
			}// if
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}// if, catch, finally
		return a;
	}// loginAdmin

	
	//관리자 전체 목록 페이징
	public ArrayList<Admin> selectAdminAll(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Admin ad = null;
		
		ArrayList<Admin> list = new ArrayList<Admin>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		
		String query = "select * from "
				+ "(select ROW_NUMBER() OVER(order by adminDate DESC) AS Row_Num, admin.* from admin) "
				+ "WHERE Row_Num between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ad = new Admin();
				ad.setPosition(rset.getString("position"));
				ad.setAdminName(rset.getString("adminName"));
				ad.setAdminId(rset.getString("adminId"));
				ad.setAdminPhone(rset.getString("adminPhone"));
				ad.setAdminSubPhone(rset.getString("adminSubPhone"));
				ad.setAdminEmail(rset.getString("adminEmail"));
				ad.setRight(rset.getString("right").charAt(0));
				list.add(ad);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
		
	}// selectAdminAll

	//관리자 검색 목록 페이징
	public ArrayList<Admin> selectAdminWhere(Connection conn, String selectWord, String keyword, int currentPage, int recordCountPerPage) {
		Statement stmt = null;
		ResultSet rset = null;
		Admin ad = null;
		
		ArrayList<Admin> list = new ArrayList<Admin>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		
		try {
			stmt = conn.createStatement();
			String query = ("select * from " + 
					"(select ROW_NUMBER() OVER(order by adminDate DESC) AS Row_Num, admin.* from admin WHERE " +selectWord+ " like '%" +keyword+ "%') " + 
					"WHERE Row_Num between "+start+" and "+end);
				
			rset = stmt.executeQuery(query);			
			while(rset.next()) {
				ad = new Admin();
				ad.setPosition(rset.getString("position"));
				ad.setAdminName(rset.getString("adminName"));
				ad.setAdminId(rset.getString("adminId"));
				ad.setAdminPhone(rset.getString("adminPhone"));
				ad.setAdminSubPhone(rset.getString("adminSubPhone"));
				ad.setAdminEmail(rset.getString("adminEmail"));
				ad.setRight(rset.getString("right").charAt(0));
				list.add(ad);
			}//while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return list;
	}

	
	// 사업자 목록 페이징
	public ArrayList<Partner> selectPartnerAll(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Partner partner = null;
		
		ArrayList<Partner> list = new ArrayList<Partner>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		
		String subQuery = "select ROW_NUMBER() OVER(order by m.memberDate DESC) AS Row_Num , m.memberCode, m.memberId, m.memberName, m.memberEmail, m.MemberPhone, p.BusinessName, p.ceoName, p.BusinessLicenseNumber, m.MemberDate, m.MemberEndDate, m.MemberEnd " + 
				"from member m left join partnerInfo p on(m.membercode=p.membercode) " + 
				"where m.membercode like 'p%'";
		
		String query = "select * from ("+subQuery+") WHERE Row_Num between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				partner = new Partner();
				
				partner.setMemberCode(rset.getString("memberCode"));
				partner.setMemberId(rset.getString("memberId"));
				partner.setMemberName(rset.getString("memberName"));
				partner.setMemberEmail(rset.getString("memberEmail"));
				partner.setMemberPhone(rset.getString("MemberPhone"));
				partner.setBusinessName(rset.getString("BusinessName"));
				partner.setCeoName(rset.getString("ceoName"));
				partner.setBusinessLicenseNumber(rset.getString("BusinessLicenseNumber"));
				partner.setMemberDate(rset.getDate("MemberDate"));
				partner.setMemberEndDate(rset.getDate("MemberEndDate"));
				partner.setMemberEnd(rset.getString("MemberEnd").charAt(0));
				
				list.add(partner);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	//사업자 검색 목록 페이징
	public ArrayList<Partner> selectPartnerWhere(Connection conn, String selectWord, String keyword, int currentPage, int recordCountPerPage) {
		Statement stmt = null;
		ResultSet rset = null;
		Partner partner = null;
		
		ArrayList<Partner> list = new ArrayList<Partner>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		
		try {
			stmt = conn.createStatement();
			String query = ("select * from (select ROW_NUMBER() OVER(order by m.memberDate DESC) AS Row_Num , m.memberCode, m.memberId, m.memberName, m.memberEmail, m.MemberPhone, p.BusinessName, p.ceoName, p.BusinessLicenseNumber, m.MemberDate, m.MemberEndDate, m.MemberEnd " + 
					"from member m left join partnerInfo p on(m.membercode=p.membercode) " + 
					"where m.membercode like 'p%' and " +selectWord+ " like '%" +keyword+ "%') " + 
					"WHERE Row_Num between "+start+" and "+end);
				
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				partner = new Partner();
				
				partner.setMemberCode(rset.getString("memberCode"));
				partner.setMemberId(rset.getString("memberId"));
				partner.setMemberName(rset.getString("memberName"));
				partner.setMemberEmail(rset.getString("memberEmail"));
				partner.setMemberPhone(rset.getString("MemberPhone"));
				partner.setBusinessName(rset.getString("BusinessName"));
				partner.setCeoName(rset.getString("ceoName"));
				partner.setBusinessLicenseNumber(rset.getString("BusinessLicenseNumber"));
				partner.setMemberDate(rset.getDate("MemberDate"));
				partner.setMemberEndDate(rset.getDate("MemberEndDate"));
				partner.setMemberEnd(rset.getString("MemberEnd").charAt(0));
				
				list.add(partner);
			}//while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
			
		}// try, catch, finally
		return list;
	}
	
	public ArrayList<User> selectUserAll(Connection conn, int currentPage, int recordCountPerPage) {
		  PreparedStatement pstmt = null;
		  ResultSet rset = null;
		  
		  ArrayList<User> list = new ArrayList<User>();
		  
		  int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		  int end = currentPage *  recordCountPerPage;
		  
		  String query = "(select * from " + 
		  					"(select row_number() over(order by membercode desc) as row_num, member.* " + 
		  					"from member where membercode like 'u%') " + 
		  					"WHERE Row_Num between "+start+" and "+end+")";
		  
		  try {
		     pstmt = conn.prepareStatement(query);
		     
		     rset = pstmt.executeQuery();
		     
		     while(rset.next()) {
		        User u = new User();
		        u.setMemberCode(rset.getString("memberCode"));
		        u.setMemberId(rset.getString("memberId"));
				u.setMemberName(rset.getString("memberName"));
				u.setMemberEmail(rset.getString("memberEmail"));
				u.setMemberPhone(rset.getString("memberPhone"));
				u.setMemberDate(rset.getDate("memberDate"));
				u.setMemberEndDate(rset.getDate("memberEndDate"));
				u.setMemberEnd(rset.getString("memberEnd").charAt(0));
			    list.add(u);
			 }// while
		     
		  } catch (SQLException e) {
		     e.printStackTrace();
		  } finally {
		     JDBCTemplate.close(rset);
		     JDBCTemplate.close(pstmt);
		  }//try, catch, finally
		  return list;
	      
	}// selectUserAll
	
	// 사용자 페이징처리 (추가)
		public String getUserPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
			
			int userTotalCount = userTotalCount(conn);// user의 수를 구하기 위한 메소드
			int pageTotalCount;// 전체 페이지를 저장하는 변수
			
			if (userTotalCount % recordCountPerPage > 0) {
				pageTotalCount = userTotalCount / recordCountPerPage +1;
			} else {
				pageTotalCount = userTotalCount / recordCountPerPage;
			}//if, else
			
			int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
			int endNavi = startNavi + naviCountPerPage - 1;
			
			if (endNavi > pageTotalCount) {
				endNavi = pageTotalCount;
			}// if
			
			StringBuilder sb = new StringBuilder();
			
			if (startNavi != 1) {
				sb.append("<a href='/selectAllUser.ss?currentPage=" +(startNavi-1)+ "'><</a> ");
			}// if
			
			for (int i = startNavi; i <= endNavi; i++) {
				if (i == currentPage) {
					sb.append("<a href='/selectAllUser.ss?currentPage=" +i+ "'><b style='color: #FF9614;'>" +i+ "</b></a> ");
				} else {
					sb.append("<a href='/selectAllUser.ss?currentPage=" +i+ "'>" +i+ "</a> ");
				}// if, else
			}// for

			if (endNavi != pageTotalCount) {
				sb.append("<a href='/selectAllUser.ss?currentPage=" +(endNavi+1)+ "'>></a> ");
			}// if
			
			// System.out.println(sb);
			return sb.toString();
			
		}// getPageNavi
		
		// 사용자 페이징처리 (추가)
		public int userTotalCount(Connection conn) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			int userTotalCount = 0;
			
			String query = "SELECT COUNT(*) as totalCount from member "
							+ "where membercode like 'u%'";
			
			try {
				pstmt = conn.prepareStatement(query);
				rset = pstmt.executeQuery();
				rset.next();
				userTotalCount = rset.getInt("totalCount");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return userTotalCount;
		}// userTotalCount

	public ArrayList<User> selectUserWhere(Connection conn, String selectWord, String keyword, int currentPage, int recordCountPerPage) {
	      
	      Statement stmt = null;
	      ResultSet rset = null;
	      
	      ArrayList<User> list = new ArrayList<User>();
	      
	      int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
	      int end = currentPage * recordCountPerPage;
	      
	      try {
	         
	         stmt = conn.createStatement();
	         String query = "(SELECT * FROM (SELECT ROW_NUMBER() OVER(order by membercode DESC) AS Row_Num ,member.* FROM member "
	         				+ "WHERE MEMBERCODE LIKE 'u%' AND " +selectWord+ " like '%" +keyword+ "%') "
	         				+ "WHERE Row_Num between "+start+" and "+end+")";
	            
	         rset = stmt.executeQuery(query);
	         
	         while(rset.next()) {
	        	 
	        	User u = new User();
	            u = new User();
	            u.setMemberCode(rset.getString("memberCode"));
	            u.setMemberId(rset.getString("memberId"));
	            u.setMemberName(rset.getString("memberName"));
	            u.setMemberEmail(rset.getString("memberEmail"));
	            u.setMemberPhone(rset.getString("memberPhone"));
	            u.setMemberDate(rset.getDate("memberDate"));
	            u.setMemberEndDate(rset.getDate("memberEndDate"));
	            u.setMemberEnd(rset.getString("memberEnd").charAt(0));
	            list.add(u);
	         }//while
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         
	         JDBCTemplate.close(rset);
	         JDBCTemplate.close(stmt);
	         
	      }// try, catch, finally
	      
	      return list;

	   }// selectUserWhere
	
	public String getSearchUserPageNavi(Connection conn, String selectWord, String keyword, int currentPage,
			
			int recordCountPerPage, int naviCountPerPage) {
			
			int userSearchTotalCount = userSearchTotalCount(conn,selectWord, keyword);// user의 수를 구하기 위한 메소드
			int pageTotalCount;// 전체 페이지를 저장하는 변수
			
			if (userSearchTotalCount % recordCountPerPage > 0) {
				pageTotalCount = userSearchTotalCount / recordCountPerPage +1;
			} else {
				pageTotalCount = userSearchTotalCount / recordCountPerPage;
			}//if, else
			
			int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
			int endNavi = startNavi + naviCountPerPage - 1;
			
			if (endNavi > pageTotalCount) {
				endNavi = pageTotalCount;
			}// if
			
			if(selectWord.equals("memberEnd") && keyword.equals("N")) {
				keyword = "사용중";
			}else if(selectWord.equals("memberEnd") && keyword.equals("Y")){
				keyword = "탈퇴";
			}
			
			StringBuilder sb = new StringBuilder();
			if (startNavi != 1) {
				sb.append("<a href='/userWhere.ss?selectWord="+selectWord+"&keyword="+keyword+"&currentPage=" +(startNavi-1)+ "'><</a> ");
			}// if
			
			for (int i = startNavi; i <= endNavi; i++) {
				if (i == currentPage) {
					sb.append("<a href='/userWhere.ss?selectWord="+selectWord+"&keyword="+keyword+"&currentPage=" +i+ "'><b style='color: #FF9614;'>" +i+ "</b></a> ");

				} else {
					sb.append("<a href='/userWhere.ss?selectWord="+selectWord+"&keyword="+keyword+"&currentPage=" +i+ "'>" +i+ "</a> ");
				}// if, else
			}// for

			if (endNavi != pageTotalCount) {
				sb.append("<a href='/userWhere.ss?selectWord="+selectWord+"&keyword="+keyword+"&currentPage=" +(endNavi+1)+ "'>></a> ");
			}// if
			
			// System.out.println(sb);
			return sb.toString();

		}// getUserPageNavi
		
	//새로만듦
	public int userSearchTotalCount(Connection conn, String selectWord, String keyword) {
		Statement stmt = null;
		ResultSet rset = null;
		int userSearchTotalCount = 0;

		String query = "(SELECT COUNT(*) as totalCount from member "
						+ "where membercode like 'u%' "
						+ "and " +selectWord+ " like '%" +keyword+ "%')";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			rset.next();
			userSearchTotalCount = rset.getInt("totalCount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return userSearchTotalCount;
	}//userSearchTotalCount

	public ArrayList<Partner> signOutPartner(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Partner partner = null;
		
		ArrayList<Partner> list = new ArrayList<Partner>();
		
		String query = "select * " + 
				"from member m left join partnerInfo p on(m.membercode=p.membercode) " + 
				"where m.membercode like 'p%' and m.MEMBERENDDATE is not null and m.memberend='N'";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				partner = new Partner();
				
				partner.setMemberCode(rset.getString("MemberCode"));
				partner.setMemberId(rset.getString("memberId"));
				partner.setMemberName(rset.getString("memberName"));
				partner.setMemberEmail(rset.getString("memberEmail"));
				partner.setMemberPhone(rset.getString("MemberPhone"));
				partner.setBusinessName(rset.getString("BusinessName"));
				partner.setCeoName(rset.getString("ceoName"));
				partner.setBusinessLicenseNumber(rset.getString("BusinessLicenseNumber"));
				partner.setMemberDate(rset.getDate("MemberDate"));
				partner.setMemberEndDate(rset.getDate("MemberEndDate"));
				partner.setMemberEnd(rset.getString("MemberEnd").charAt(0));
				
				list.add(partner);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Partner> searchSignOutPartner(Connection conn, String selectWord, String keyword) {
		Statement stmt = null;
		ResultSet rset = null;
		Partner partner = null;
		
		ArrayList<Partner> list = new ArrayList<Partner>();
		
		String query = "select * from member m left join partnerInfo p on(m.membercode=p.membercode) " + 
				"where m.membercode like 'p%' and m.MEMBERENDDATE is not null and m.memberend='N' AND " +selectWord+ " like '%" +keyword+ "%'";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				partner = new Partner();
				
				partner.setMemberCode(rset.getString("MemberCode"));
				partner.setMemberId(rset.getString("memberId"));
				partner.setMemberName(rset.getString("memberName"));
				partner.setMemberEmail(rset.getString("memberEmail"));
				partner.setMemberPhone(rset.getString("MemberPhone"));
				partner.setBusinessName(rset.getString("BusinessName"));
				partner.setCeoName(rset.getString("ceoName"));
				partner.setBusinessLicenseNumber(rset.getString("BusinessLicenseNumber"));
				partner.setMemberDate(rset.getDate("MemberDate"));
				partner.setMemberEndDate(rset.getDate("MemberEndDate"));
				partner.setMemberEnd(rset.getString("MemberEnd").charAt(0));
				
				list.add(partner);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return list;
	}
	
	public SpaceRegistration signOutPartner(Connection conn, String memberCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SpaceRegistration sr = null;
		
		String query = "select * from SPACEREGISTRATION where membercode=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberCode);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				sr = new SpaceRegistration();
				
				sr.setSpaceNo(rset.getString("spaceNo"));
				sr.setSpaceName(rset.getString("spaceName"));
				sr.setSpaceTel(rset.getString("spaceTel"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return sr;
	}

	public boolean signOutPartnerRes(Connection conn, String spaceNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		
		String query = "select r.resNo from spaceRegistration sr left join SUBSPACE ss on(sr.spaceno=ss.spaceno) " + 
				"left join RESERVATION r on(ss.SUBNO=R.SUBNO) where sr.spaceno=? and R.RESNO is not null";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, spaceNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<SpaceRegistration> selectSpaceWhere(Connection conn, String selectWord, String keyword) {
		Statement stmt = null;
		ResultSet rset = null;
		SpaceRegistration sr = null;
		
		ArrayList<SpaceRegistration> srList = new ArrayList<SpaceRegistration>();
		
		try {
			
			stmt = conn.createStatement();
			String query = ("SELECT * FROM SpaceRegistration WHERE "
							+selectWord+ " like '%" +keyword+ "%'");
				
			rset = stmt.executeQuery(query);			
			while(rset.next()) {
				sr = new SpaceRegistration();
				
				sr.setSpaceName(rset.getString("spaceName"));
				sr.setSpaceNo(rset.getString("spaceNo"));
				sr.setSpaceTel(rset.getString("spaceTel"));
				srList.add(sr);
			}//while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}// try, catch, finally
		return srList;
	}

	public Partner signOutSearchPartner(Connection conn, String spaceNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Partner p = null;
		
		String query = "select * from member m left join SPACEREGISTRATION sr on(M.MEMBERCODE=sr.MEMBERCODE) "
						+ "where spaceno=? and m.membercode like 'p%' and m.MEMBERENDDATE is not null";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, spaceNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				p = new Partner();
				
				p.setMemberDate(rset.getDate("MemberDate"));
				p.setMemberEndDate(rset.getDate("MemberEndDate"));
				p.setMemberId(rset.getString("MemberId"));
				p.setMemberName(rset.getString("MemberName"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return p;
	}

	//사용자 탈퇴 승인
	public ArrayList<User> signOutUser(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User u = null;
		
		ArrayList<User> list = new ArrayList<User>();
		
		String query = "SELECT * FROM MEMBER WHERE (MEMBERCODE LIKE 'u%') AND (MEMBERENDDATE IS NOT NULL) AND (MEMBEREND = 'N')";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				u = new User();
				u.setMemberDate(rset.getDate("memberDate"));
				u.setMemberEndDate(rset.getDate("memberEndDate"));				
				u.setMemberId(rset.getString("memberId"));
				u.setMemberName(rset.getString("memberName"));
				u.setMemberPhone(rset.getString("memberPhone"));
				u.setMemberEmail(rset.getString("memberEmail"));
				u.setMemberEnd(rset.getString("memberEnd").charAt(0));

				list.add(u);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}//try, catch, finally
		return list;
		
	}// signOutUser

	public ArrayList<User> searchSignOutUser(Connection conn, String selectWord, String keyword) {

		Statement stmt = null;
		ResultSet rset = null;
		User u = null;
		
		ArrayList<User> list = new ArrayList<User>();
		
		try {
			
			stmt = conn.createStatement();
			String query = ("SELECT * FROM MEMBER WHERE (MEMBERCODE LIKE 'u%') AND (MEMBERENDDATE IS NOT NULL) AND (MEMBEREND = 'N') AND " +selectWord+ " like '%" +keyword+ "%'");
				
			rset = stmt.executeQuery(query);			
			while(rset.next()) {
				u = new User();
				u.setMemberDate(rset.getDate("memberDate"));
				u.setMemberEndDate(rset.getDate("memberEndDate"));
				u.setMemberId(rset.getString("memberId"));
				u.setMemberName(rset.getString("memberName"));
				u.setMemberPhone(rset.getString("memberPhone"));
				u.setMemberEmail(rset.getString("memberEmail"));
				u.setMemberEnd(rset.getString("memberEnd").charAt(0));
				list.add(u);
			}//while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
			
		}// try, catch, finally
		
		return list;
		
	}// searchSignOutUser

	public int memberApprovalSignOut(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET MEMBEREND = 'Y' WHERE MEMBERID=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}//try, catch, finally
		
		return result;
		
	}// memberApprovalSignOut
	
	public int memberNoSignOut(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET MEMBEREND = 'N', MEMBERENDDATE = NULL WHERE MEMBERID=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}//try, catch, finally
		
		return result;
		
	}// memberNoSignOut

	public int ApprovalRecord(Connection conn, String adminCode, String aprovType) {
		PreparedStatement pstmt = null;
		int AprovResult = 0;
		
		String query = "INSERT INTO APPROVALRECORD VALUES (?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, adminCode);
			pstmt.setString(2, aprovType);
			AprovResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}//try, catch, finally
		
		return AprovResult;
		
	}//ApprovalRecord
	
	
	
	//사업자 문의사항
	public ArrayList<Inquiry> partnerQuestion(Connection conn, String inquiryState, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Inquiry> list = new ArrayList<Inquiry>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		
		String subQuery = "select ROW_NUMBER() OVER(order by i.INQUIRYNO DESC) AS Row_Num ,i.* from inquiry i left join member m on(i.memberid=m.memberid) " + 
				"where m.memberCode like 'p%' and m.memberEnd !='Y' and i.inquiryCartegory ='ETC'";
		
		if(!(inquiryState.equals("A"))) {
			subQuery += " and i.inquiryAns=?";
		}
		
		String query = "select * from ("+subQuery+") WHERE Row_Num between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			if(!(inquiryState.equals("A"))) {
				pstmt.setString(1, inquiryState);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}else {
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Inquiry i = new Inquiry();
				
				i.setInquiryAns(rset.getString("InquiryAns").charAt(0));
				i.setInquiryCategory(rset.getString("InquiryCartegory"));
				i.setInquiryContent(rset.getString("InquiryContent"));
				i.setInquiryDate(rset.getDate("InquiryDate"));
				i.setInquiryNo(rset.getInt("InquiryNo"));
				i.setInquiryTitle(rset.getString("InquiryTitle"));
				i.setMemberId(rset.getString("MemberId"));
				
				list.add(i);
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

	public Inquiry partnerQuestion(Connection conn, int inquiryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Inquiry inquiry = null;
		
		String query = "select * from inquiry where inquiryNo=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inquiryNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				inquiry = new Inquiry();
				
				inquiry.setInquiryAns(rset.getString("InquiryAns").charAt(0));
				inquiry.setInquiryCategory(rset.getString("InquiryCartegory"));
				inquiry.setInquiryContent(rset.getString("InquiryContent"));
				inquiry.setInquiryDate(rset.getDate("InquiryDate"));
				inquiry.setInquiryNo(rset.getInt("InquiryNo"));
				inquiry.setInquiryTitle(rset.getString("InquiryTitle"));
				inquiry.setMemberId(rset.getString("MemberId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return inquiry;
	}

	public int insertInquiryAnswer(Connection conn, InquiryAnswer ia) {
		PreparedStatement pstmt = null;
		int result1 = 0;
		int result2 = updateInquiryAns(conn, ia.getInquiryNo());
		
		String query = "insert into InquiryAnswer values(?,?,null,?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ia.getInquiryNo());
			pstmt.setString(2, ia.getAdminId());
			pstmt.setString(3, ia.getAnswerTitle());
			pstmt.setString(4, ia.getAnswerContent());
			
			result1 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result1*result2;
	}
	
	public int updateInquiryAns(Connection conn, int inquiryNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update inquiry set inquiryAns='Y' where inquiryNo=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inquiryNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int inquiryPartnerTotalCount(Connection conn, String inquiryState) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int inquiryTotalCount = 0;

		String query = "SELECT COUNT(*) as totalCount FROM inquiry i left join member m on(i.memberid=m.memberid) "
				+ "where m.memberCode like 'p%' and m.memberEnd !='Y' and i.inquiryCartegory ='ETC'";
		
		
		if(!(inquiryState.equals("A"))) {
			query += " and inquiryAns=?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(!(inquiryState.equals("A"))) {
				pstmt.setString(1, inquiryState);
			}
			rset = pstmt.executeQuery();
			rset.next();
			inquiryTotalCount = rset.getInt("totalCount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return inquiryTotalCount;
	}

	public String getPartnerQPageNavi(Connection conn, String inquiryState, int currentPage, int recordCountPerPage,
			int naviCountPerPage) {
		
		int inquiryTotalCount = inquiryPartnerTotalCount(conn, inquiryState); // 전체 게시물의 개수를 구하기 위한 메소드
		
		int pageTotalCount; // 전체 페이지를 저장하는 변수
		if (inquiryTotalCount % recordCountPerPage > 0) {
			pageTotalCount = inquiryTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = inquiryTotalCount / recordCountPerPage + 0;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;

		int endNavi = startNavi + naviCountPerPage - 1;

		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		StringBuilder sb = new StringBuilder();

		if (startNavi != 1) {
			sb.append("<a href='/partnerQuestion.ss?currentPage=" +(startNavi-1)+ "&inquiryState="+inquiryState+"'><</a> ");
		}
		
		for (int i = startNavi; i <= endNavi; i++) {
			if (i == currentPage) {
				sb.append("<a href='/partnerQuestion.ss?currentPage=" +i+ "&inquiryState="+inquiryState+"'><b style='color: #FF9614;'>" +i+ "</b></a> ");
			} else {
				sb.append("<a href='/partnerQuestion.ss?currentPage=" +i+ "&inquiryState="+inquiryState+"'>" +i+ "</a> ");
			}
		}

		if (endNavi != pageTotalCount) {
			sb.append("<a href='/partnerQuestion.ss?currentPage=" +(endNavi+1)+ "&inquiryState="+inquiryState+"'>></a> ");
		}
		return sb.toString();
	}

	public InquiryAnswer selectOneInquiryAnswer(Connection conn, int inquiryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		InquiryAnswer ia = null;
		
		String query = "select * from InquiryAnswer where inquiryNo=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inquiryNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				ia = new InquiryAnswer();
				
				ia.setAdminId(rset.getString("AdminId"));
				ia.setAnswerContent(rset.getString("AnswerContent"));
				ia.setAnswerDate(rset.getDate("AnswerDate"));
				ia.setAnswerTitle(rset.getString("AnswerTitle"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return ia;
	}

	// 사용자 문의사항
	public ArrayList<Inquiry> userQuestion(Connection conn, String inquiryState, int currentPage,
			int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Inquiry> list = new ArrayList<Inquiry>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		
		String subQuery = "select ROW_NUMBER() OVER(order by i.INQUIRYNO DESC) AS Row_Num ,i.* from inquiry i left join member m on(i.memberid=m.memberid) " + 
				"where m.memberCode like 'u%' and m.memberEnd !='Y' and i.inquiryCartegory ='ETC'";
		
		if(!(inquiryState.equals("A"))) {
			subQuery += " and i.inquiryAns=?";
		}
		
		String query = "select * from ("+subQuery+") WHERE Row_Num between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			if(!(inquiryState.equals("A"))) {
				pstmt.setString(1, inquiryState);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}else {
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Inquiry i = new Inquiry();
				
				i.setInquiryAns(rset.getString("InquiryAns").charAt(0));
				i.setInquiryCategory(rset.getString("InquiryCartegory"));
				i.setInquiryContent(rset.getString("InquiryContent"));
				i.setInquiryDate(rset.getDate("InquiryDate"));
				i.setInquiryNo(rset.getInt("InquiryNo"));
				i.setInquiryTitle(rset.getString("InquiryTitle"));
				i.setMemberId(rset.getString("MemberId"));
				
				list.add(i);
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

	public String getUserQPageNavi(Connection conn, String inquiryState, int currentPage, int recordCountPerPage,
			int naviCountPerPage) {
		
		int inquiryTotalCount = inquiryUserTotalCount(conn, inquiryState); // 전체 게시물의 개수를 구하기 위한 메소드
		
		int pageTotalCount; // 전체 페이지를 저장하는 변수
		if (inquiryTotalCount % recordCountPerPage > 0) {
			pageTotalCount = inquiryTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = inquiryTotalCount / recordCountPerPage + 0;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;

		int endNavi = startNavi + naviCountPerPage - 1;

		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		StringBuilder sb = new StringBuilder();

		if (startNavi != 1) {
			sb.append("<a href='/userQuestion.ss?currentPage=" +(startNavi-1)+ "&inquiryState="+inquiryState+"'><</a> ");
		}
		
		for (int i = startNavi; i <= endNavi; i++) {
			if (i == currentPage) {
				sb.append("<a href='/userQuestion.ss?currentPage=" +i+ "&inquiryState="+inquiryState+"'><b style='color: #FF9614;'>" +i+ "</b></a> ");
			} else {
				sb.append("<a href='/userQuestion.ss?currentPage=" +i+ "&inquiryState="+inquiryState+"'>" +i+ "</a> ");
			}
		}

		if (endNavi != pageTotalCount) {
			sb.append("<a href='/userQuestion.ss?currentPage=" +(endNavi+1)+ "&inquiryState="+inquiryState+"'>></a> ");
		}
		return sb.toString();
	}

	private int inquiryUserTotalCount(Connection conn, String inquiryState) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int inquiryTotalCount = 0;

		String query = "SELECT COUNT(*) as totalCount FROM inquiry i left join member m on(i.memberid=m.memberid) "
				+ "where m.memberCode like 'u%' and m.memberEnd !='Y' and i.inquiryCartegory ='ETC'";
		
		
		if(!(inquiryState.equals("A"))) {
			query += " and inquiryAns=?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(!(inquiryState.equals("A"))) {
				pstmt.setString(1, inquiryState);
			}
			rset = pstmt.executeQuery();
			rset.next();
			inquiryTotalCount = rset.getInt("totalCount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return inquiryTotalCount;
	}
	
	// 예약조회, 검색
	public ArrayList<Reservation> selectReservation(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Reservation r = null;
				
		ArrayList<Reservation> rList = new ArrayList<Reservation>();
		
		String query = "SELECT * FROM RESERVATION left JOIN SUBSPACE USING (SUBNO) "
						+ "left JOIN MEMBER USING (MEMBERCODE) left JOIN RESINFO USING (RESINFOCODE) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				r = new Reservation();
				r.setResNo(rset.getString("resNo"));				
				r.setResRecordDate(rset.getDate("resRecordDate"));
				r.setResDate(rset.getDate("resDate"));
				r.setResPeople(rset.getInt("resPeople"));
				r.setUserCost(rset.getInt("userCost"));

				rList.add(r);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}//try, catch, finally
		return rList;
	}// selectReservation
	
	public ArrayList<User> selectUserReservation(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User u = null;
		
		ArrayList<User> uList = new ArrayList<User>();
		
		String query = "SELECT * FROM RESERVATION left JOIN SUBSPACE USING (SUBNO) "
						+ "left JOIN MEMBER USING (MEMBERCODE) left JOIN RESINFO USING (RESINFOCODE) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {			
				u = new User();
				u.setMemberId(rset.getString("memberId"));				

				uList.add(u);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}//try, catch, finally
		return uList;
	}// selectReservation
	
	public ArrayList<ResInfo> selectResInfoReservation(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ResInfo ri = null;
		
		ArrayList<ResInfo> riList = new ArrayList<ResInfo>();
		
		String query = "SELECT * FROM RESERVATION left JOIN SUBSPACE USING (SUBNO) "
						+ "left JOIN MEMBER USING (MEMBERCODE) left JOIN RESINFO USING (RESINFOCODE) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ri = new ResInfo();				
				ri.setResInfoName(rset.getString("resInfoName"));
				ri.setResInfoPhone(rset.getString("resInfoPhone"));

				riList.add(ri);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}//try, catch, finally
		return riList;
	}// selectReservation
	
	public ArrayList<SubSpace> selectSubSupaceReservation(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SubSpace s = null;
		
		ArrayList<SubSpace> ssList = new ArrayList<SubSpace>();
		
		String query = "SELECT * FROM RESERVATION left JOIN SUBSPACE USING (SUBNO) "
						+ "left JOIN MEMBER USING (MEMBERCODE) left JOIN RESINFO USING (RESINFOCODE) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {	
				s = new SubSpace();
				s.setSubName(rset.getString("subName"));

				ssList.add(s);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}//try, catch, finally
		return ssList;
	}// selectReservation
	
	public ArrayList<Reservation> searchReservation(Connection conn, String selectWord, String keyword) {
		Statement stmt = null;
		ResultSet rset = null;
		Reservation r = null;
				
		ArrayList<Reservation> rList = new ArrayList<Reservation>();
		
		try {
			stmt = conn.createStatement();
			String query = "SELECT * FROM RESERVATION left JOIN SUBSPACE USING (SUBNO) "
							+ "left JOIN MEMBER USING (MEMBERCODE) left JOIN RESINFO USING (RESINFOCODE) "
							+ "WHERE " +selectWord+ " like '%" +keyword+ "%'";
						
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				r = new Reservation();
				r.setResNo(rset.getString("resNo"));				
				r.setResRecordDate(rset.getDate("resRecordDate"));
				r.setResDate(rset.getDate("resDate"));
				r.setResPeople(rset.getInt("resPeople"));
				r.setUserCost(rset.getInt("userCost"));

				rList.add(r);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}//try, catch, finally
		return rList;
	}// searchReservation
	
	public ArrayList<User> searchUserReservation(Connection conn, String selectWord, String keyword) {
		Statement stmt = null;
		ResultSet rset = null;
		User u = null;
		
		ArrayList<User> uList = new ArrayList<User>();
		
		try {
			stmt = conn.createStatement();
			String query = "SELECT * FROM RESERVATION left JOIN SUBSPACE USING (SUBNO) "
							+ "left JOIN MEMBER USING (MEMBERCODE) left JOIN RESINFO USING (RESINFOCODE) "
							+ "WHERE " +selectWord+ " like '%" +keyword+ "%'";
						
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {			
				u = new User();
				u.setMemberId(rset.getString("memberId"));				

				uList.add(u);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}//try, catch, finally
		return uList;
	}// searchReservation
	
	public ArrayList<ResInfo> searchResInfoReservation(Connection conn, String selectWord, String keyword) {
		Statement stmt = null;
		ResultSet rset = null;
		ResInfo ri = null;
		
		ArrayList<ResInfo> riList = new ArrayList<ResInfo>();
		
			try {
				stmt = conn.createStatement();
				String query = "SELECT * FROM RESERVATION left JOIN SUBSPACE USING (SUBNO) "
								+ "left JOIN MEMBER USING (MEMBERCODE) left JOIN RESINFO USING (RESINFOCODE) "
								+ "WHERE " +selectWord+ " like '%" +keyword+ "%'";
							
				rset = stmt.executeQuery(query);	
			
			while(rset.next()) {
				ri = new ResInfo();				
				ri.setResInfoName(rset.getString("resInfoName"));
				ri.setResInfoPhone(rset.getString("resInfoPhone"));

				riList.add(ri);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}//try, catch, finally
		return riList;
	}// searchReservation
	
	public ArrayList<SubSpace> searchSubSupaceReservation(Connection conn, String selectWord, String keyword) {
		Statement stmt = null;
		ResultSet rset = null;
		SubSpace s = null;
		
		ArrayList<SubSpace> ssList = new ArrayList<SubSpace>();
		
		try {
			stmt = conn.createStatement();
			String query = "SELECT * FROM RESERVATION left JOIN SUBSPACE USING (SUBNO) "
							+ "left JOIN MEMBER USING (MEMBERCODE) left JOIN RESINFO USING (RESINFOCODE) "
							+ "WHERE " +selectWord+ " like '%" +keyword+ "%'";
			
			
			rset = stmt.executeQuery(query);			
			while(rset.next()) {	
				s = new SubSpace();
				s.setSubName(rset.getString("subName"));

				ssList.add(s);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}//try, catch, finally
		return ssList;
	}// searchReservation
	
	//공간 조회, 검색
public ArrayList<SpaceRegistration> selectSpaceRegistration(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SpaceRegistration sr = null;
				
		ArrayList<SpaceRegistration> srList = new ArrayList<SpaceRegistration>();
		
		String query = "select * from spaceregistration left join member using (membercode)";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				sr = new SpaceRegistration();
				sr.setSpaceNo(rset.getString("spaceNo"));
				sr.setSpaceName(rset.getString("spaceName"));
				sr.setSpaceAddress(rset.getString("spaceAddress"));
				sr.setSpaceTel(rset.getString("spaceTel"));
				sr.setSpaceDate(rset.getDate("spaceDate"));
				sr.setSpaceDel(rset.getString("spaceDel").charAt(0));
				
				srList.add(sr);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}//try, catch, finally
		return srList;
	}// selectSpaceRegistration

	public ArrayList<Partner> selectSpacePartner(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Partner sp = null;
				
		ArrayList<Partner> spList = new ArrayList<Partner>();
		
		String query = "select * from spaceregistration left join member using (membercode)";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				sp = new Partner();
				sp.setMemberId(rset.getString("memberId"));
				
				spList.add(sp);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}//try, catch, finally
		return spList;
		
	}// selectSpacePartner

	public ArrayList<SpaceRegistration> searchSpaceRegistration(Connection conn, String selectWord, String keyword) {
		Statement stmt = null;
		ResultSet rset = null;
		SpaceRegistration sr = null;
				
		ArrayList<SpaceRegistration> srList = new ArrayList<SpaceRegistration>();
		
		try {
			stmt = conn.createStatement();
			
			String query = "select * from spaceregistration left join member using (membercode)"
							+ "WHERE " +selectWord+ " like '%" +keyword+ "%'";
			
			rset = stmt.executeQuery(query);	
			
			while(rset.next()) {
				sr = new SpaceRegistration();
				sr.setSpaceNo(rset.getString("spaceNo"));
				sr.setSpaceName(rset.getString("spaceName"));
				sr.setSpaceAddress(rset.getString("spaceAddress"));
				sr.setSpaceTel(rset.getString("spaceTel"));
				sr.setSpaceDate(rset.getDate("spaceDate"));
				sr.setSpaceDel(rset.getString("spaceDel").charAt(0));
				
				srList.add(sr);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}//try, catch, finally
		return srList;
	}// searchSpaceRegistration

	public ArrayList<Partner> selectSpacePartner(Connection conn, String selectWord, String keyword) {
		
		Statement stmt = null;
		ResultSet rset = null;
		Partner sp = null;
				
		ArrayList<Partner> spList = new ArrayList<Partner>();
		
		try {
			stmt = conn.createStatement();
			
			String query = "select * from spaceregistration left join member using (membercode)"
							+ "WHERE " +selectWord+ " like '%" +keyword+ "%'";
			
			rset = stmt.executeQuery(query);	
			
			while(rset.next()) {
				sp = new Partner();
				sp.setMemberId(rset.getString("memberId"));
				
				spList.add(sp);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}//try, catch, finally
		return spList;
		
	}// searchSpacePartner

	
	//관리자 메인 페이지
	public int countMember(Connection conn, char status, String code, String today) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int countMember = 0;
		
		String query = "select count(*) as count from member "
				+ "where memberend=? and membercode like ?";
		
		if(today.equals("today")) {
			query += " and memberDate like sysdate";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, Character.toString(status));
			pstmt.setString(2, code+"%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				countMember = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return countMember;
	}

	// 사업자 조회 페이징 처리
	public String getPartnerLPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		
		int partnerTotalCount = partnerTotalCount(conn); // 전체 게시물의 개수를 구하기 위한 메소드
		
		int pageTotalCount; // 전체 페이지를 저장하는 변수
		if (partnerTotalCount % recordCountPerPage > 0) {
			pageTotalCount = partnerTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = partnerTotalCount / recordCountPerPage + 0;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;

		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		StringBuilder sb = new StringBuilder();
		if (startNavi != 1) {
			sb.append("<a href='/selectAllPartner.ss?currentPage=" +(startNavi-1)+ "'><</a> ");
		}
		
		for (int i = startNavi; i <= endNavi; i++) {
			if (i == currentPage) {
				sb.append("<a href='/selectAllPartner.ss?currentPage=" +i+ "'><b style='color: #FF9614;'>" +i+ "</b></a> ");
			} else {
				sb.append("<a href='/selectAllPartner.ss?currentPage=" +i+ "'>" +i+ "</a> ");
			}
		}

		if (endNavi != pageTotalCount) {
			sb.append("<a href='/selectAllPartner.ss?currentPage=" +(endNavi+1)+ "'>></a> ");
		}
		return sb.toString();
	}

	//사업자 전체 개수
	public int partnerTotalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int partnerTotalCount = 0;

		String query = "SELECT COUNT(*) as totalCount " + 
				"FROM member m left join partnerInfo p on(m.membercode=p.membercode) " + 
				"where m.membercode like 'p%'";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			rset.next();
			partnerTotalCount = rset.getInt("totalCount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return partnerTotalCount;
	}

	// 사업자 검색 조회 페이징 처리
	public String getPartnerSLPageNavi(Connection conn, String selectWord, String keyword, int currentPage,
			int recordCountPerPage, int naviCountPerPage) {
		
		int partnerSearchTotalCount = partnerSearchTotalCount(conn, selectWord, keyword); // 검색한 게시물의 개수를 구하기 위한 메소드
		
		int pageTotalCount; // 전체 페이지를 저장하는 변수
		if (partnerSearchTotalCount % recordCountPerPage > 0) {
			pageTotalCount = partnerSearchTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = partnerSearchTotalCount / recordCountPerPage + 0;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;

		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		if(selectWord.equals("memberEnd") && keyword.equals("N")) {
			keyword = "사용중";
		}else if(selectWord.equals("memberEnd") && keyword.equals("Y")){
			keyword = "탈퇴";
		}
		
		StringBuilder sb = new StringBuilder();
		if (startNavi != 1) {
			sb.append("<a href='/searchPartnerList.ss?selectWord="+selectWord+"&keyword="+keyword+"&currentPage=" +(startNavi-1)+ "'><</a> ");
		}
		
		for (int i = startNavi; i <= endNavi; i++) {
			if (i == currentPage) {
				sb.append("<a href='/searchPartnerList.ss?selectWord="+selectWord+"&keyword="+keyword+"&currentPage=" +i+ "'><b style='color: #FF9614;'>" +i+ "</b></a> ");
			} else {
				sb.append("<a href='/searchPartnerList.ss?selectWord="+selectWord+"&keyword="+keyword+"&currentPage=" +i+ "'>" +i+ "</a> ");
			}
		}

		if (endNavi != pageTotalCount) {
			sb.append("<a href='/searchPartnerList.ss?selectWord="+selectWord+"&keyword="+keyword+"&currentPage=" +(endNavi+1)+ "'>></a> ");
		}
		return sb.toString();
	}

	
	//사업자 검색결과 개수
	public int partnerSearchTotalCount(Connection conn, String selectWord, String keyword) {
		Statement stmt = null;
		ResultSet rset = null;
		int partnerSearchTotalCount = 0;

		String query = "select COUNT(*) as totalCount " + 
				"from member m left join partnerInfo p on(m.membercode=p.membercode) " + 
				"where m.membercode like 'p%' and " +selectWord+ " like '%" +keyword+ "%'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			rset.next();
			partnerSearchTotalCount = rset.getInt("totalCount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return partnerSearchTotalCount;
	}

	
	// 관리자 전체 목록 페이징
	public String getAdminLPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int adminTotalCount = adminTotalCount(conn); // 전체 게시물의 개수를 구하기 위한 메소드
		
		int pageTotalCount; // 전체 페이지를 저장하는 변수
		if (adminTotalCount % recordCountPerPage > 0) {
			pageTotalCount = adminTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = adminTotalCount / recordCountPerPage + 0;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;

		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		StringBuilder sb = new StringBuilder();
		if (startNavi != 1) {
			sb.append("<a href='/adminAllSelect.ss?currentPage=" +(startNavi-1)+ "'><</a> ");
		}
		
		for (int i = startNavi; i <= endNavi; i++) {
			if (i == currentPage) {
				sb.append("<a href='/adminAllSelect.ss?currentPage=" +i+ "'><b style='color: #FF9614;'>" +i+ "</b></a> ");
			} else {
				sb.append("<a href='/adminAllSelect.ss?currentPage=" +i+ "'>" +i+ "</a> ");
			}
		}

		if (endNavi != pageTotalCount) {
			sb.append("<a href='/adminAllSelect.ss?currentPage=" +(endNavi+1)+ "'>></a> ");
		}
		return sb.toString();
	}

	// 관리자 전체 목록 개수
	public int adminTotalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int adminTotalCount = 0;

		String query = "SELECT COUNT(*) as totalCount FROM admin";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			rset.next();
			adminTotalCount = rset.getInt("totalCount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return adminTotalCount;
	}

	//관리자 검색 목록 페이징
	public String getAdminSLPageNavi(Connection conn, String selectWord, String keyword, int currentPage,
			int recordCountPerPage, int naviCountPerPage) {
		int adminSearchTotalCount = adminSearchTotalCount(conn, selectWord, keyword); // 검색한 게시물의 개수를 구하기 위한 메소드
		
		int pageTotalCount; // 전체 페이지를 저장하는 변수
		if (adminSearchTotalCount % recordCountPerPage > 0) {
			pageTotalCount = adminSearchTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = adminSearchTotalCount / recordCountPerPage + 0;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;

		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		StringBuilder sb = new StringBuilder();
		if (startNavi != 1) {
			sb.append("<a href='/adminWhere.ss?selectWord="+selectWord+"&keyword="+keyword+"&currentPage=" +(startNavi-1)+ "'><</a> ");
		}
		
		for (int i = startNavi; i <= endNavi; i++) {
			if (i == currentPage) {
				sb.append("<a href='/adminWhere.ss?selectWord="+selectWord+"&keyword="+keyword+"&currentPage=" +i+ "'><b style='color: #FF9614;'>" +i+ "</b></a> ");
			} else {
				sb.append("<a href='/adminWhere.ss?selectWord="+selectWord+"&keyword="+keyword+"&currentPage=" +i+ "'>" +i+ "</a> ");
			}
		}

		if (endNavi != pageTotalCount) {
			sb.append("<a href='/adminWhere.ss?selectWord="+selectWord+"&keyword="+keyword+"&currentPage=" +(endNavi+1)+ "'>></a> ");
		}
		return sb.toString();
	}

	
	//관리자 검색 목록 개수
	public int adminSearchTotalCount(Connection conn, String selectWord, String keyword) {
		Statement stmt = null;
		ResultSet rset = null;
		int adminSearchTotalCount = 0;

		String query = "select COUNT(*) as totalCount from admin "
				+ "where " +selectWord+ " like '%" +keyword+ "%'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			rset.next();
			adminSearchTotalCount = rset.getInt("totalCount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return adminSearchTotalCount;
	}
	
	//결제 승인
	public ArrayList<SpaceRegistration> calculateApprovalSpace(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SpaceRegistration sr = null;
		
		ArrayList<SpaceRegistration> srList = new ArrayList<SpaceRegistration>();
		
		String query = "select spaceName, NVL(sum(userCost),0) as allCost from reservation " + 
						"left join subSpace using (subNo) " + 
						"left join spaceRegistration using (spaceNo) " + 
						"WHERE (extract (month from resDate)=extract (month from sysDate)-1) " + 
						"group by spaceName";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				sr = new SpaceRegistration();				
				sr.setSpaceName(rset.getString("spaceName"));
				sr.setAllCost(rset.getInt("allCost"));
				
				srList.add(sr);
				
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}//try, catch, finally
		return srList;
	}// calculateApprovalSpace
	
	public ArrayList<CalculateInfo> calculateApprovalInfo(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CalculateInfo ci = null;
		
		ArrayList<CalculateInfo> ciList = new ArrayList<CalculateInfo>();
		
		String query = "select memberid, membercode, spacename, calbank, calholder, calAccount from spaceregistration " +
						"left join member using (membercode) " +
						"left join calculateinfo using (membercode) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				ci = new CalculateInfo();
				
				ci.setMemberId(rset.getString("memberId"));
				ci.setMemberCode(rset.getString("memberCode"));
				ci.setSpaceName(rset.getString("spaceName"));
				ci.setCalBank(rset.getString("calBank"));
				ci.setCalHolder(rset.getString("calHolder"));
				ci.setCalAccount(rset.getString("calAccount"));
				
				ciList.add(ci);
				
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}//try, catch, finally
		return ciList;
		
	}// calculateApprovalInfo

	// 정산 기록
	public int RecordCalculate(Connection conn, String adminCode, String memberCode, double calCost, double feeCost) {
		
			PreparedStatement pstmt = null;
			int result = 0;
			
			String query = "INSERT INTO CALCULATERECORD VALUES (?,?,?,?,sysdate,to_char(TRUNC(sysdate,'MM')||'~'||LAST_DAY(sysdate)),sysdate-2)";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, adminCode);
				pstmt.setString(2, memberCode);
				pstmt.setDouble(3, calCost);
				pstmt.setDouble(4, feeCost);
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}//try, catch, finally
			
			return result;
			
		}//RecordCalculate
	
	//정산 조회
	public ArrayList<CalculateInfo> selectCalculate(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CalculateInfo ci = null;
		
		ArrayList<CalculateInfo> ciList = new ArrayList<CalculateInfo>();
		
		String query = "select memberid, spaceName, (calcost+calfees) as allCost, calcost, calfees, calterm " + 
						"from calculaterecord left join member using (membercode) " +
						"left join spaceRegistration using (membercode) order by 6 desc";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				ci = new CalculateInfo();
				
				ci.setMemberId(rset.getString("memberId"));
				ci.setSpaceName(rset.getString("spaceName"));
				ci.setAllCost(rset.getInt("allCost"));
				ci.setCalCost(rset.getInt("calCost"));
				ci.setCalFees(rset.getInt("calFees"));
				ci.setCalTerm(rset.getString("calTerm"));
				
				ciList.add(ci);
				
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}//try, catch, finally
		
		return ciList;
		
	}// selectCalculate

	// 정산 검색
	public ArrayList<SpaceRegistration> searchCalculateApprovalSpace(Connection conn) {
		
		Statement stmt = null;
		ResultSet rset = null;
		SpaceRegistration sr = null;
				
		ArrayList<SpaceRegistration> srList = new ArrayList<SpaceRegistration>();
		
		try {
			stmt = conn.createStatement();
			
			String query = "select spaceName, NVL(sum(userCost),0) as allCost from reservation " + 
							"left join subSpace using (subNo) " + 
							"left join spaceRegistration using (spaceNo) " + 
							"WHERE (extract (month from resDate)=extract (month from sysDate)-1) " + 							
							"group by spaceName";
			
			rset = stmt.executeQuery(query);	
			
			while(rset.next()) {
				
				sr = new SpaceRegistration();				
				sr.setSpaceName(rset.getString("spaceName"));
				sr.setAllCost(rset.getInt("allCost"));
				
				srList.add(sr);
				
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}//try, catch, finally
		return srList;
		
	}// searchCalculateApprovalSpace
	
	public ArrayList<CalculateInfo> searchCalculateApprovalInfo(Connection conn, String selectWord, String keyword) {

		Statement stmt = null;
		ResultSet rset = null;
		CalculateInfo ci = null;
				
		ArrayList<CalculateInfo> ciList = new ArrayList<CalculateInfo>();
		
		try {
			stmt = conn.createStatement();
			
			String query = "select memberid, membercode, spacename, calbank, calholder, calAccount from spaceregistration " +
							"left join member using (membercode) " +
							"left join calculateinfo using (membercode) " +
							"WHERE " +selectWord+ " like '%" +keyword+ "%'";
			
			rset = stmt.executeQuery(query);	
			
			while(rset.next()) {
				
				ci = new CalculateInfo();
				
				ci.setMemberId(rset.getString("memberId"));
				ci.setMemberCode(rset.getString("memberCode"));
				ci.setSpaceName(rset.getString("spaceName"));
				ci.setCalBank(rset.getString("calBank"));
				ci.setCalHolder(rset.getString("calHolder"));
				ci.setCalAccount(rset.getString("calAccount"));
				
				ciList.add(ci);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}//try, catch, finally
		return ciList;
		
	}// searchCalculateApprovalInfo

	public ArrayList<CalculateInfo> searchCalculate(Connection conn, String selectWord, String keyword) {
		
		Statement stmt = null;
		ResultSet rset = null;
		CalculateInfo ci = null;
				
		ArrayList<CalculateInfo> ciList = new ArrayList<CalculateInfo>();
		
		try {
			stmt = conn.createStatement();
			
			String query = "select memberid, spaceName, (calcost+calfees) as allCost, calcost, calfees, calterm " + 
							"from calculaterecord left join member using (membercode) " +
							"left join spaceRegistration using (membercode) " +
							"WHERE " +selectWord+ " like '%" +keyword+ "%' order by 6 ";
			
			rset = stmt.executeQuery(query);	
			
			while(rset.next()) {
				
				ci = new CalculateInfo();
				
				ci.setMemberId(rset.getString("memberId"));
				ci.setSpaceName(rset.getString("spaceName"));
				ci.setAllCost(rset.getInt("allCost"));
				ci.setCalCost(rset.getInt("calCost"));
				ci.setCalFees(rset.getInt("calFees"));
				ci.setCalTerm(rset.getString("calTerm"));
				
				ciList.add(ci);
			}// while
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}//try, catch, finally
		return ciList;
		
	}// searchCalculate
	
	
}// AdminDAO
