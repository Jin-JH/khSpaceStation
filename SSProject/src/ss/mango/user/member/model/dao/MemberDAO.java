package ss.mango.user.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ss.mango.admin.model.vo.Admin;
import ss.mango.common.JDBCTemplate;
import ss.mango.user.member.model.vo.CalculateInfo;
import ss.mango.user.member.model.vo.Member;
import ss.mango.user.member.model.vo.PartnerInfo;

public class MemberDAO {
	public Member loginMember(Connection conn, String userId, String userPw) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Member m = null;
		
		String query = "SELECT * FROM MEMBER WHERE MEMBERID=? AND MEMBERPW=? AND memberEnd='N'";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				
				m.setMemberCode(rset.getString("MEMBERCODE"));
				m.setMemberName(rset.getString("MEMBERNAME"));
				m.setMemberId(rset.getString("MEMBERID"));
				m.setMemberPw(rset.getString("MEMBERPW"));
				m.setMemberPhone(rset.getString("MEMBERPHONE"));
				m.setMemberEmail(rset.getString("MEMBEREMAIL"));
				m.setMemberDate(rset.getDate("MEMBERDATE"));
				m.setMemberEnd(rset.getString("MEMBEREND").charAt(0));
				m.setMemberEndDate(rset.getDate("MEMBERENDDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
	}

	public Admin adminLoginMember(Connection conn, String memberId, String memberPw) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Admin a = null;
		
		String query = "SELECT * FROM ADMIN WHERE ADMINID=? AND ADMINPW=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				a = new Admin();
				a.setAdminCode(rset.getString("ADMINCODE"));
				a.setAdminId(rset.getString("ADMINID"));
				a.setAdminPw(rset.getString("ADMINPW"));
				a.setPosition(rset.getString("POSITION"));
				a.setAdminName(rset.getString("ADMINNAME"));
				a.setAdminPhone(rset.getString("ADMINPHONE"));
				a.setAdminSubPhone(rset.getString("ADMINSUBPHONE"));
				a.setAdminEmail(rset.getString("ADMINEMAIL"));
				a.setRight(rset.getString("RIGHT").charAt(0));
				a.setAdminDate(rset.getDate("ADMINDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return a;
	}

	public int joinUser(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO MEMBER VALUES('u'||TO_CHAR(MEMBER_SEQ.NEXTVAL,'FM000009'),?,?,?,?,?,DEFAULT,'N','')";
		
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMemberEmail());
			pstmt.setString(5, m.getMemberPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int joinPartner(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO MEMBER VALUES('p'||TO_CHAR(MEMBER_SEQ.NEXTVAL,'FM000009'),?,?,?,?,?,DEFAULT,'N','')";
		
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMemberEmail());
			pstmt.setString(5, m.getMemberPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Member selectMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Member m = null;
		
		String query = "SELECT * FROM MEMBER WHERE MEMBERID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				
				m.setMemberCode(rset.getString("MEMBERCODE"));
				m.setMemberName(rset.getString("MEMBERNAME"));
				m.setMemberId(rset.getString("MEMBERID"));
				m.setMemberPw(rset.getString("MEMBERPW"));
				m.setMemberPhone(rset.getString("MEMBERPHONE"));
				m.setMemberEmail(rset.getString("MEMBEREMAIL"));
				m.setMemberDate(rset.getDate("MEMBERDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
	}
	
	public int joinPartnerInfo(Connection conn, Member selectMember, PartnerInfo p) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO PARTNERINFO VALUES(?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, selectMember.getMemberCode());
			pstmt.setString(2, p.getCeoName());
			pstmt.setString(3, p.getCeoPhone());
			pstmt.setString(4, p.getBusinessName());
			pstmt.setLong(5, p.getBusinessLicenseNumber());
			pstmt.setString(6, p.getBusinessEmail());
			pstmt.setString(7, p.getBusinessAddress());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int joinCalculateInfo(Connection conn, Member selectMember, CalculateInfo c) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO CALCULATEINFO VALUES(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, selectMember.getMemberCode());
			pstmt.setString(2, c.getCalBank());
			pstmt.setString(3, c.getCalAccount());
			pstmt.setString(4, c.getCalHolder());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int updateUser(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET " 
				+ "MEMBERNAME = ?, "
				+ "MEMBEREMAIL = ?, "
				+ "MEMBERPW = ?, "
				+ "MEMBERPHONE = ? WHERE MEMBERID=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getMemberName());
			pstmt.setString(2, m.getMemberEmail());
			pstmt.setString(3, m.getMemberPw());
			pstmt.setString(4, m.getMemberPhone());
			pstmt.setString(5, m.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	public PartnerInfo searchPartnerInfo(Connection conn, String memberCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		PartnerInfo pi = null;
		
		String query = "SELECT * FROM PARTNERINFO WHERE MEMBERCODE = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pi = new PartnerInfo();
				pi.setMemberCode(rset.getString("MEMBERCODE"));
				pi.setCeoName(rset.getString("CEONAME"));
				pi.setCeoPhone(rset.getString("CEOPHONE"));
				pi.setBusinessName(rset.getString("BUSINESSNAME"));
				pi.setBusinessLicenseNumber(rset.getLong("BUSINESSLICENSENUMBER"));
				pi.setBusinessEmail(rset.getString("BUSINESSEMAIL"));
				pi.setBusinessAddress(rset.getString("BUSINESSADDRESS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return pi;
	}

	public int updatePartnerInfo(Connection conn, PartnerInfo pi) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE PARTNERINFO SET " 
				+ "CEONAME = ?, "
				+ "BUSINESSNAME = ?, "
				+ "BUSINESSLICENSENUMBER = ?, "
				+ "CEOPHONE = ?, "
				+ "BUSINESSEMAIL = ? WHERE MEMBERCODE=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pi.getCeoName());
			pstmt.setString(2, pi.getBusinessName());
			pstmt.setLong(3, pi.getBusinessLicenseNumber());
			pstmt.setString(4, pi.getCeoPhone());
			pstmt.setString(5, pi.getBusinessEmail());
			pstmt.setString(6, pi.getMemberCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateCalculate(Connection conn, CalculateInfo ci) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE CALCULATEINFO SET " 
				+ "CALBANK = ?, "
				+ "CALACCOUNT = ?, "
				+ "CALHOLDER = ? WHERE MEMBERCODE = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ci.getCalBank());
			pstmt.setString(2, ci.getCalAccount());
			pstmt.setString(3, ci.getCalHolder());
			pstmt.setString(4, ci.getMemberCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public CalculateInfo searchCalculateInfo(Connection conn, String memberCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CalculateInfo ci = null;
		
		String query = "SELECT * FROM CALCULATEINFO WHERE MEMBERCODE = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				ci = new CalculateInfo();
				ci.setMemberCode(rset.getString("MEMBERCODE"));
				ci.setCalBank(rset.getString("CALBANK"));
				ci.setCalAccount(rset.getString("CALACCOUNT"));
				ci.setCalHolder(rset.getString("CALHOLDER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return ci;
	}

	public int withdrawUser(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET MEMBERENDDATE=SYSDATE WHERE MEMBERID=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int restoreMember(Connection conn, String restoreId, String restorePw) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET MEMBERENDDATE='' WHERE MEMBERID=? AND MEMBERPW=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, restoreId);
			pstmt.setString(2, restorePw);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public Member dupCheckIdMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		
		String query = "SELECT * FROM MEMBER WHERE MEMBERID=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("MEMBERID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
	}
	
	public Member selectByEmail(Connection conn, String findName, String findEmail) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Member m1 = null;

		String query = "SELECT * FROM MEMBER WHERE MEMBERNAME=? AND MEMBEREMAIL=? AND memberEnd ='N'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, findName);
			pstmt.setString(2, findEmail);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				m1 = new Member();

				m1.setMemberCode(rset.getString("MEMBERCODE"));
				m1.setMemberEmail(rset.getString("MemberEmail"));
				m1.setMemberPhone(rset.getString("MemberPhone"));
				m1.setMemberId(rset.getString("MemberId"));
				m1.setMemberName(rset.getString("MemberName"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m1;
	}

	public Member selectByPhone(Connection conn, String findName, String findPhone) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Member m2 = null;

		String query = "SELECT * FROM MEMBER WHERE MEMBERNAME=? AND MEMBERPHONE=? AND memberEnd ='N'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, findName);
			pstmt.setString(2, findPhone);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				m2 = new Member();

				m2.setMemberCode(rset.getString("MEMBERCODE"));
				m2.setMemberEmail(rset.getString("MemberEmail"));
				m2.setMemberPhone(rset.getString("MemberPhone"));
				m2.setMemberId(rset.getString("MemberId"));
				m2.setMemberName(rset.getString("MemberName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m2;
	}

	public Member selectPwByEmail(Connection conn, String findPwEmail, String findId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Member m1 = null;

		String query = "SELECT * FROM MEMBER WHERE MEMBERID=? AND MEMBEREMAIL=? AND memberEnd ='N'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, findId);
			pstmt.setString(2, findPwEmail);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				m1 = new Member();

				m1.setMemberCode(rset.getString("MEMBERCODE"));
				m1.setMemberEmail(rset.getString("MemberEmail"));
				m1.setMemberPhone(rset.getString("MemberPhone"));
				m1.setMemberId(rset.getString("MemberId"));
				m1.setMemberName(rset.getString("MemberName"));
				m1.setMemberPw(rset.getString("MemberPw"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m1;

	}

	public Member selectPwByPhone(Connection conn, String findPwPhone, String findId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Member m2 = null;

		String query = "SELECT * FROM MEMBER WHERE MEMBERID=? AND MEMBERPHONE=? AND memberEnd ='N'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, findId);
			pstmt.setString(2, findPwPhone);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				m2 = new Member();

				m2.setMemberCode(rset.getString("MEMBERCODE"));
				m2.setMemberEmail(rset.getString("MemberEmail"));
				m2.setMemberPhone(rset.getString("MemberPhone"));
				m2.setMemberId(rset.getString("MemberId"));
				m2.setMemberName(rset.getString("MemberName"));
				m2.setMemberPw(rset.getString("MemberPw"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m2;
	}

	public int updatePw(Connection conn, String newPw, String memberCode) {
		PreparedStatement pstmt = null;

		int result = 0;
		
		String query = "UPDATE MEMBER SET MEMBERPW=? WHERE MEMBERCODE=? AND MEMBEREND='N'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newPw);
			pstmt.setString(2, memberCode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
