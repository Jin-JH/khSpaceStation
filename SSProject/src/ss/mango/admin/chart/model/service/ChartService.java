package ss.mango.admin.chart.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ss.mango.admin.chart.model.dao.ChartDAO;
import ss.mango.admin.chart.model.vo.Quarter;
import ss.mango.admin.model.vo.Partner;
import ss.mango.admin.model.vo.ResInfo;
import ss.mango.admin.model.vo.Reservation;
import ss.mango.admin.model.vo.SpaceRegistration;
import ss.mango.admin.model.vo.User;
import ss.mango.common.JDBCTemplate;

public class ChartService {
	private ChartDAO cDAO = new ChartDAO();

	//사용자 수 통계
	public ArrayList<User> recentUserList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<User> list = cDAO.recentUserList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Quarter> quarterJoinUserCount(String year) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Quarter> list = cDAO.quarterJoinUserCount(conn, year);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Quarter> quarterEndUserCount(String year) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Quarter> list = cDAO.quarterEndUserCount(conn, year);
		JDBCTemplate.close(conn);
		return list;
	}

	//사업자 수 통계
	public ArrayList<Partner> recentPartnerList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Partner> list = cDAO.recentPartnerList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Quarter> quarterJoinPartnerCount(String year) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Quarter> list = cDAO.quarterJoinPartnerCount(conn, year);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Quarter> quarterEndPartnerCount(String year) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Quarter> list = cDAO.quarterEndPartnerCount(conn, year);
		JDBCTemplate.close(conn);
		return list;
	}

	// 매출 통계
	public int salesList(String form, int i) {
		Connection conn = JDBCTemplate.getConnection();
		int result = cDAO.salesList(conn, form, i);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Quarter> quarterSalesCount(String year) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Quarter> list = cDAO.quarterSalesCount(conn, year);
		JDBCTemplate.close(conn);
		return list;
	}

	// 최근 등록한 공간 정보
	public ArrayList<SpaceRegistration> recentSpaceRegistrationList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<SpaceRegistration> list = cDAO.recentSpaceRegistrationList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	// 최근 등록한 공간을 가진 사업자 정보
	public Partner recentPartnerList(String memberCode) {
		Connection conn = JDBCTemplate.getConnection();
		Partner p = cDAO.recentPartnerList(conn, memberCode);
		JDBCTemplate.close(conn);
		return p;
	}

	// 분기별 등록된 공간 수
	public ArrayList<Quarter> quarterSpaceRegistrationCount(String year) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Quarter> list = cDAO.quarterSpaceRegistrationCount(conn, year);
		JDBCTemplate.close(conn);
		return list;
	}

	// 최근 예약 목록
	public ArrayList<Reservation> recentResList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Reservation> list = cDAO.recentResList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public ResInfo recentResList(String resInfoCode) {
		Connection conn = JDBCTemplate.getConnection();
		ResInfo ri = cDAO.recentResList(conn, resInfoCode);
		JDBCTemplate.close(conn);
		return ri;
	}

	public SpaceRegistration recentResSpaceList(String subNo) {
		Connection conn = JDBCTemplate.getConnection();
		SpaceRegistration sr = cDAO.recentResSpaceList(conn, subNo);
		JDBCTemplate.close(conn);
		return sr;
	}

	//분기별 총 예약 건수
	public ArrayList<Quarter> quarterResCount(String year) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Quarter> list = cDAO.quarterResCount(conn, year);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Quarter> quarterResCancleCount(String year) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Quarter> list = cDAO.quarterResCancleCount(conn, year);
		JDBCTemplate.close(conn);
		return list;
	}

}
