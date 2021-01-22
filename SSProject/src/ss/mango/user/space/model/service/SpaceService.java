package ss.mango.user.space.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import ss.mango.common.JDBCTemplate;
import ss.mango.user.space.model.dao.SpaceDAO;
import ss.mango.user.space.model.vo.ResInfo;
import ss.mango.user.space.model.vo.Reservation;
import ss.mango.user.space.model.vo.ReservationDetails;
import ss.mango.user.space.model.vo.SpaceRegistration;
import ss.mango.user.space.model.vo.SubSpace;

public class SpaceService {
	SpaceDAO sDAO = new SpaceDAO();
	
	public ArrayList<SpaceRegistration> selectRecentSpace() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<SpaceRegistration> list = sDAO.selectRecentSpace(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public ArrayList<SpaceRegistration> SpaceAllListPage(String location) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<SpaceRegistration> list = sDAO.SpaceAllListPage(conn,location);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public ArrayList<SpaceRegistration> SpaceAllListPage(String location, String price) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<SpaceRegistration> list = sDAO.SpaceAllListPage(conn,location,price);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public SpaceRegistration SelectSpace(String spaceNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		SpaceRegistration space = sDAO.SelectSpace(conn, spaceNo);
		
		JDBCTemplate.close(conn);
		
		return space;
	}

	public ArrayList<SubSpace> SelectSubSpace(String spaceNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<SubSpace> list = sDAO.SelectSubSpace(conn,spaceNo);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public SubSpace choiceSubSpace(String spaceNo, String resSubSpaceName) {
		Connection conn = JDBCTemplate.getConnection();
		
		SubSpace subspace = sDAO.choiceSubSpace(conn,spaceNo,resSubSpaceName);
		
		JDBCTemplate.close(conn);
		
		return subspace;
	}

	public int insertResInfo(String memberCode, String resInfoName, String resInfoPhone, String resInfoEmail,
			String usePurpose, String requestItem) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = sDAO.insertResInfo(conn,memberCode,resInfoName,resInfoPhone,resInfoEmail,usePurpose,requestItem);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public ResInfo searchResInfo(String memberCode, String resInfoName, String resInfoEmail) {
		Connection conn = JDBCTemplate.getConnection();
		
		ResInfo resinfo = sDAO.searchResInfo(conn,memberCode,resInfoName,resInfoEmail);
		
		JDBCTemplate.close(conn);
		
		return resinfo;
	}

	public int spacePaySuccess(String subNo, String resInfoCode, Date resDate, int startTime, int endTime, int resPeople, int payPrice, String memberCode) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = sDAO.spacePaySuccess(conn,resInfoCode,subNo,resDate,startTime,endTime,resPeople,payPrice,memberCode);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public Reservation searchReservation(String resInfoCode) {
		Connection conn = JDBCTemplate.getConnection();
		
		Reservation reservation = sDAO.searchReservation(conn,resInfoCode);
		
		JDBCTemplate.close(conn);
		
		return reservation;
	}

	public ArrayList<ReservationDetails> selectReservation(String memberCode) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<ReservationDetails> list = sDAO.selectReservation(conn,memberCode);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ResInfo selectOneReservation(String resNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ResInfo resinfo = sDAO.selectOneReservation(conn,resNo);
		
		JDBCTemplate.close(conn);
		
		return resinfo;
	}

	public ReservationDetails selectOneReservation(String memberCode, String resNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ReservationDetails resDetails = sDAO.selectOneReservation(conn,memberCode,resNo);
		
		JDBCTemplate.close(conn);
		
		return resDetails;
	}

	public ArrayList<ResInfo> checkNamecheckPhone() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<ResInfo> list = sDAO.checkNamecheckPhone(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Reservation> ReservationStatusView(String subno, String resdate) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Reservation> res = sDAO.ReservationStatusView(conn,subno,resdate);
		
		JDBCTemplate.close(conn);
		
		return res;
	}
}