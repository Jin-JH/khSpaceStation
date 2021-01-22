package kr.or.ss.member.model.service;

import java.sql.Connection;

import ss.mango.user.member.model.vo.Member;
import kr.or.ss.common.JDBCTemplate;
import kr.or.ss.member.model.dao.MemberDAO;

public class MemberService {
		MemberDAO mDAO = new MemberDAO();
	public Member loginMember(String memberId, String memberPw) {
		Connection conn=JDBCTemplate.getConnection();
		Member m = mDAO.loginMember(conn,memberId,memberPw);
		JDBCTemplate.close(conn);
		return m;
		
	}

}
