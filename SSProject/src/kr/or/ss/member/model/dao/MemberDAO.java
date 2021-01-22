package kr.or.ss.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ss.mango.user.member.model.vo.Member;
import kr.or.ss.common.JDBCTemplate;

public class MemberDAO {

	public Member loginMember(Connection conn, String memberId, String memberPw) {
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		
		Member m = null;
		
		String query = "SELECT * FROM MEMBER WHERE memberid=? and memberpw=? and memberend='N'";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				m=new Member();
				m.setMemberCode(rset.getString("memberCode"));
				m.setMemberId(rset.getString("memberId"));
				m.setMemberPw(rset.getString("memberPw"));
				m.setMemberName(rset.getString("memberName"));
				m.setMemberEmail(rset.getString("memberEmail"));
				m.setMemberPhone(rset.getString("memberPhone"));
				m.setMemberDate(rset.getDate("memberDate"));
				m.setMemberEnd(rset.getString("memberEnd").charAt(0));
				
				
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

}
