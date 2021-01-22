package ss.mango.user.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ss.mango.admin.model.vo.Admin;
import ss.mango.common.JDBCTemplate;
import ss.mango.user.member.model.dao.MemberDAO;
import ss.mango.user.member.model.vo.CalculateInfo;
import ss.mango.user.member.model.vo.Member;
import ss.mango.user.member.model.vo.PartnerInfo;

public class MemberService {
	
	MemberDAO mDAO = new MemberDAO();
	
	public Member loginMember(String memberId, String memberPw) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = mDAO.loginMember(conn,memberId,memberPw);
		
		JDBCTemplate.close(conn);
		
		return m;
	}

	public Admin adminLoginMember(String memberId, String memberPw) {
		Connection conn = JDBCTemplate.getConnection();
		Admin a = mDAO.adminLoginMember(conn,memberId,memberPw);
		
		JDBCTemplate.close(conn);
		
		return a;
	}

	public int joinUser(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.joinUser(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int joinPartner(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = mDAO.joinPartner(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public Member selectMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = mDAO.selectMember(conn, memberId);
		
		JDBCTemplate.close(conn);
		
		return m;
	}

	public int joinPartnerInfo(Member selectMember, PartnerInfo p) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.joinPartnerInfo(conn, selectMember, p);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int joinCalculateInfo(Member selectMember, CalculateInfo c) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.joinCalculateInfo(conn, selectMember, c);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int updateUser(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.updateUser(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public PartnerInfo searchPartnerInfo(String memberCode) {
		Connection conn = JDBCTemplate.getConnection();
		
		PartnerInfo pi = mDAO.searchPartnerInfo(conn, memberCode);
		
		JDBCTemplate.close(conn);
		
		return pi;
	}

	public int updatePartnerInfo(PartnerInfo pi) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = mDAO.updatePartnerInfo(conn,pi);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	public int updateCalculate(CalculateInfo ci) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = mDAO.updateCalculate(conn,ci);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	public CalculateInfo searchCalculateInfo(String memberCode) {
		Connection conn = JDBCTemplate.getConnection();
		
		CalculateInfo ci = mDAO.searchCalculateInfo(conn, memberCode);
		
		JDBCTemplate.close(conn);
		
		return ci;
	}

	public int withdrawUser(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = mDAO.withdrawUser(conn,memberId);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int restoreMember(String restoreId, String restorePw) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = mDAO.restoreMember(conn,restoreId,restorePw);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	public Member dupCheckIdMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = mDAO.dupCheckIdMember(conn,memberId);
		
		JDBCTemplate.close(conn);
		
		return m;
	}
	
	public Member selectByEmail(String findName, String findEmail) {
		Connection conn = JDBCTemplate.getConnection();
		Member m1 = mDAO.selectByEmail(conn, findName, findEmail);
		JDBCTemplate.close(conn);
		return m1;

	}

	public Member selectByPhone(String findName, String findPhone) {
		Connection conn = JDBCTemplate.getConnection();
		Member m2 = mDAO.selectByPhone(conn, findName, findPhone);
		JDBCTemplate.close(conn);
		return m2;

	}

	public Member selectPwByEmail(String findPwEmail, String findId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m1 = mDAO.selectPwByEmail(conn, findPwEmail, findId);
		return m1;
	}

	public Member selectPwByPhone(String findPwPhone, String findId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m2 = mDAO.selectPwByPhone(conn, findPwPhone, findId);
		return m2;
	}

	public int updatePw(String newPw, String memberCode) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.updatePw(conn, newPw, memberCode);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}