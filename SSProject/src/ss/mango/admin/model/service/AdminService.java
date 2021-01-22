package ss.mango.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ss.mango.admin.model.dao.AdminDAO;
import ss.mango.admin.model.vo.Admin;
import ss.mango.admin.model.vo.AdminListPageData;
import ss.mango.admin.model.vo.CalculateInfo;
import ss.mango.admin.model.vo.Inquiry;
import ss.mango.admin.model.vo.InquiryAnswer;
import ss.mango.admin.model.vo.InquiryPageData;
import ss.mango.admin.model.vo.Partner;
import ss.mango.admin.model.vo.PartnerListPageData;
import ss.mango.admin.model.vo.ResInfo;
import ss.mango.admin.model.vo.Reservation;
import ss.mango.admin.model.vo.SpaceRegistration;
import ss.mango.admin.model.vo.SpaceRegistration1;
import ss.mango.admin.model.vo.SubSpace;
import ss.mango.admin.model.vo.User;
import ss.mango.admin.model.vo.UserPageData;
import ss.mango.common.JDBCTemplate;

public class AdminService {
	private AdminDAO adminDAO = new AdminDAO();

	public Admin loginAdmin(String adminId, String adminPw) {
		Connection conn = JDBCTemplate.getConnection();
		Admin a = adminDAO.loginAdmin(conn, adminId, adminPw);
		JDBCTemplate.close(conn);
		return a;
		
	}// loginAdmin

	//관리자 전체 목록 페이징
	public AdminListPageData selectAdminAll(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 10; // 한 페이지당 몇개의 게시물이 보이게 될 것인지
		ArrayList<Admin> list = adminDAO.selectAdminAll(conn, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5; // pageNavi값이 몇개씩 보여줄 것인지
		String pageNavi = adminDAO.getAdminLPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage);
		AdminListPageData alpd = new AdminListPageData();
		alpd.setList(list);
		alpd.setPageNavi(pageNavi);
		
		JDBCTemplate.close(conn);
		return alpd;
	}

	//관리자 검색 목록 페이징
	public AdminListPageData selectAdminWhere(String selectWord, String keyword, int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 10; // 한 페이지당 몇개의 게시물이 보이게 될 것인지
		ArrayList<Admin> list = adminDAO.selectAdminWhere(conn, selectWord, keyword, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5; // pageNavi값이 몇개씩 보여줄 것인지
		String pageNavi = adminDAO.getAdminSLPageNavi(conn, selectWord, keyword, currentPage, recordCountPerPage, naviCountPerPage);
		AdminListPageData alpd = new AdminListPageData();
		alpd.setList(list);
		alpd.setPageNavi(pageNavi);
		
		JDBCTemplate.close(conn);
		return alpd;
	}

	// 사업자 목록 페이징
	public PartnerListPageData selectPartnerAll(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 10; // 한 페이지당 몇개의 게시물이 보이게 될 것인지
		ArrayList<Partner> list = adminDAO.selectPartnerAll(conn, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5; // pageNavi값이 몇개씩 보여줄 것인지
		String pageNavi = adminDAO.getPartnerLPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage);
		PartnerListPageData plpd = new PartnerListPageData();
		plpd.setList(list);
		plpd.setPageNavi(pageNavi);
		
		JDBCTemplate.close(conn);
		return plpd;
	}
	
	//사업자 검색 목록 페이징
	public PartnerListPageData selectPartnerWhere(String selectWord, String keyword, int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		if(selectWord.equals("memberEnd") && keyword.equals("사용중")) {
			keyword = "N";
		}else if(selectWord.equals("memberEnd") && keyword.equals("탈퇴")){
			keyword = "Y";
		}
		
		int recordCountPerPage = 10; // 한 페이지당 몇개의 게시물이 보이게 될 것인지
		ArrayList<Partner> list = adminDAO.selectPartnerWhere(conn, selectWord, keyword, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5; // pageNavi값이 몇개씩 보여줄 것인지
		String pageNavi = adminDAO.getPartnerSLPageNavi(conn, selectWord, keyword, currentPage, recordCountPerPage, naviCountPerPage);
		PartnerListPageData plpd = new PartnerListPageData();
		plpd.setList(list);
		plpd.setPageNavi(pageNavi);
		
		JDBCTemplate.close(conn);
		return plpd;
	}
	
	public UserPageData selectUserAll(int currentPage) {
      Connection conn = JDBCTemplate.getConnection();
      int recordCountPerPage = 10; // 한 페이지당 게시물 10개
      ArrayList<User> list = adminDAO.selectUserAll(conn, currentPage, recordCountPerPage);
      
      int naviCountPerPage = 5; // pageNavi 5개
      String pageNavi = adminDAO.getUserPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage);
      
      UserPageData upd = new UserPageData();
      upd.setList(list);
      upd.setPageNavi(pageNavi);
      JDBCTemplate.close(conn);
      
      return upd;
      
   }// selectUserAll

	public UserPageData selectUserWhere(String selectWord, String keyword, int currentPage) {
      Connection conn = JDBCTemplate.getConnection();
      if(selectWord.equals("memberEnd") && keyword.equals("사용중")) {
			keyword = "N";
		}else if(selectWord.equals("memberEnd") && keyword.equals("탈퇴")){
			keyword = "Y";
		}// if, else if
      
      int recordCountPerPage = 10;// 한 페이지당 10개의 게시물
      ArrayList<User> list = adminDAO.selectUserWhere(conn, selectWord, keyword, currentPage, recordCountPerPage);
      
      int naviCountPerPage = 5;// pageNavi 5개
      String pageNavi = adminDAO.getSearchUserPageNavi(conn, selectWord, keyword, currentPage, recordCountPerPage, naviCountPerPage);

      UserPageData upd = new UserPageData();
      upd.setList(list);
      upd.setPageNavi(pageNavi);
      JDBCTemplate.close(conn);
      
      return upd;
   }// selectUserWhere

	public ArrayList<Partner> signOutPartner() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Partner> list = adminDAO.signOutPartner(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public SpaceRegistration signOutPartner(String memberCode) {
		Connection conn = JDBCTemplate.getConnection();
		SpaceRegistration sr = adminDAO.signOutPartner(conn, memberCode);
		JDBCTemplate.close(conn);
		return sr;
	}
	
	public boolean signOutPartnerRes(String spaceNo) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = adminDAO.signOutPartnerRes(conn, spaceNo);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<SpaceRegistration> selectSpaceWhere(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<SpaceRegistration> srList = adminDAO.selectSpaceWhere(conn, selectWord, keyword);
	    JDBCTemplate.close(conn);
	    return srList;
		
	}
	
	public Partner signOutSearchPartner(String spaceNo) {
		Connection conn = JDBCTemplate.getConnection();
		Partner p = adminDAO.signOutSearchPartner(conn, spaceNo);
		JDBCTemplate.close(conn);
		return p;
	}
	
	//사용자 탈퇴 승인
	public ArrayList<User> signOutUser() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<User> list = adminDAO.signOutUser(conn);
		JDBCTemplate.close(conn);
		return list;
	}// signOutUser

	public ArrayList<User> searchSignOutUser(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
	    ArrayList<User> list = adminDAO.searchSignOutUser(conn, selectWord, keyword);
	    JDBCTemplate.close(conn);
	    return list;

	}// searchSignOutUser
	
	public int memberApprovalSignOut(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = adminDAO.memberApprovalSignOut(conn, memberId);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}//if, else
		JDBCTemplate.close(conn);
		return result;
	}//memberApprovalSignOut

	public int memberNoSignOut(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = adminDAO.memberNoSignOut(conn, memberId);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}//if, else
		JDBCTemplate.close(conn);
		return result;		
	}//memberNoSignOut

	public int ApprovalRecord(String adminCode, String aprovType) {
		Connection conn = JDBCTemplate.getConnection();
		int AprovResult = adminDAO.ApprovalRecord(conn, adminCode, aprovType);
		if(AprovResult>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}//if, else
		JDBCTemplate.close(conn);
		return AprovResult;
	}// ApprovalRecord
	
	
	
	//사업자 문의사항
	public InquiryPageData partnerQuestion(String inquiryState, int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 8; // 한 페이지당 몇개의 게시물이 보이게 될 것인지
		ArrayList<Inquiry> list = adminDAO.partnerQuestion(conn, inquiryState, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5; // pageNavi값이 몇개씩 보여줄 것인지
		String pageNavi = adminDAO.getPartnerQPageNavi(conn, inquiryState, currentPage, recordCountPerPage, naviCountPerPage);
		InquiryPageData ipd = new InquiryPageData();
		ipd.setList(list);
		ipd.setPageNavi(pageNavi);
		
		JDBCTemplate.close(conn);
		return ipd;
	}

	public Inquiry partnerQuestion(int inquiryNo) {
		Connection conn = JDBCTemplate.getConnection();
		Inquiry inquiry = adminDAO.partnerQuestion(conn, inquiryNo);
		JDBCTemplate.close(conn);
		return inquiry;
	}

	public ArrayList<Partner> searchSignOutPartner(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Partner> list = adminDAO.searchSignOutPartner(conn, selectWord, keyword);
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertInquiryAnswer(InquiryAnswer ia) {
		Connection conn = JDBCTemplate.getConnection();
		int result = adminDAO.insertInquiryAnswer(conn, ia);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public InquiryAnswer selectOneInquiryAnswer(int inquiryNo) {
		Connection conn = JDBCTemplate.getConnection();
		InquiryAnswer ia = adminDAO.selectOneInquiryAnswer(conn, inquiryNo);
		JDBCTemplate.close(conn);
		return ia;
	}
	
	
	//사용자 문의사항
	public InquiryPageData userQuestion(String inquiryState, int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 8; // 한 페이지당 몇개의 게시물이 보이게 될 것인지
		ArrayList<Inquiry> list = adminDAO.userQuestion(conn, inquiryState, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5; // pageNavi값이 몇개씩 보여줄 것인지
		String pageNavi = adminDAO.getUserQPageNavi(conn, inquiryState, currentPage, recordCountPerPage, naviCountPerPage);
		InquiryPageData ipd = new InquiryPageData();
		ipd.setList(list);
		ipd.setPageNavi(pageNavi);
		
		JDBCTemplate.close(conn);
		return ipd;
	}

	public Inquiry userQuestion(int inquiryNo) {
		Connection conn = JDBCTemplate.getConnection();
		Inquiry inquiry = adminDAO.partnerQuestion(conn, inquiryNo);
		JDBCTemplate.close(conn);
		return inquiry;
	}
	
	//예약 조회, 검색
	public ArrayList<Reservation> selectReservation() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Reservation> rList = adminDAO.selectReservation(conn);
		JDBCTemplate.close(conn);
		return rList;
	}//selectReservation
	
	public ArrayList<User> selectUserReservation() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<User> uList = adminDAO.selectUserReservation(conn);
		JDBCTemplate.close(conn);
		return uList;
	}//selectUserReservation
	
	public ArrayList<ResInfo> selectResInfoReservation() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<ResInfo> riList = adminDAO.selectResInfoReservation(conn);		
		JDBCTemplate.close(conn);
		return riList;
	}//selectResInfoReservation
	
	public ArrayList<SubSpace> selectSubSupaceReservation() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<SubSpace> ssList = adminDAO.selectSubSupaceReservation(conn);		
		JDBCTemplate.close(conn);
		return ssList;
	}//selectSubSupaceReservation
	
	public ArrayList<Reservation> searchReservation(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Reservation> rList = adminDAO.searchReservation(conn,selectWord, keyword);
		JDBCTemplate.close(conn);
		return rList;
	}//searchReservation
	
	public ArrayList<User> searchUserReservation(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<User> uList = adminDAO.searchUserReservation(conn,selectWord, keyword);
		JDBCTemplate.close(conn);
		return uList;
	}//searchUserReservation
	
	public ArrayList<ResInfo> searchResInfoReservation(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<ResInfo> riList = adminDAO.searchResInfoReservation(conn,selectWord, keyword);		
		JDBCTemplate.close(conn);
		return riList;
	}//searchResInfoReservation
	
	public ArrayList<SubSpace> searchSubSupaceReservation(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<SubSpace> ssList = adminDAO.searchSubSupaceReservation(conn,selectWord, keyword);		
		JDBCTemplate.close(conn);
		return ssList;
	}//searchSubSupaceReservation
	
	//공간 조회, 검색
	public ArrayList<SpaceRegistration> selectSpaceRegistration() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<SpaceRegistration> srList = adminDAO.selectSpaceRegistration(conn);
		JDBCTemplate.close(conn);
		return srList;
	}// selectSpaceRegistration

	public ArrayList<Partner> selectSpacePartner() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Partner> spList = adminDAO.selectSpacePartner(conn);
		JDBCTemplate.close(conn);
		return spList;
	}// ArrayList<Partner>

	public ArrayList<SpaceRegistration> searchSpaceRegistration(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<SpaceRegistration> srList = adminDAO.searchSpaceRegistration(conn, selectWord, keyword);
		JDBCTemplate.close(conn);
		return srList;
	}// searchSpaceRegistration

	public ArrayList<Partner> searchSpacePartner(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Partner> spList = adminDAO.selectSpacePartner(conn, selectWord, keyword);
		JDBCTemplate.close(conn);
		return spList;
	}// searchSpacePartner

	
	
	//관리자 메인 페이지
	public int countMember(char status, String code, String today) {
		Connection conn = JDBCTemplate.getConnection();
		int countMember = adminDAO.countMember(conn, status, code, today);
		JDBCTemplate.close(conn);
		return countMember;
	}

	//사업자 검색결과 개수
	public int partnerSearchTotalCount(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		
		if(selectWord.equals("memberEnd") && keyword.equals("사용중")) {
			keyword = "N";
		}else if(selectWord.equals("memberEnd") && keyword.equals("탈퇴")){
			keyword = "Y";
		}
		
		int countPartner = adminDAO.partnerSearchTotalCount(conn, selectWord, keyword);
		JDBCTemplate.close(conn);
		return countPartner;
	}

	//관리자 검색결과 개수
	public int adminSearchTotalCount(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		int countAdmin = adminDAO.adminSearchTotalCount(conn, selectWord, keyword);
		JDBCTemplate.close(conn);
		return countAdmin;
	}

	public int userSearchTotalCount(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		if(selectWord.equals("memberEnd") && keyword.equals("사용중")) {
			keyword = "N";
		}else if(selectWord.equals("memberEnd") && keyword.equals("탈퇴")){
			keyword = "Y";
		}// if, else if
		
		int userTotalCount = adminDAO.userSearchTotalCount(conn, selectWord, keyword);
		JDBCTemplate.close(conn);
		return userTotalCount;
	}// userSearchTotalCount
	
	//정산승인
	public ArrayList<SpaceRegistration1> calculateApprovalSpace() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<SpaceRegistration1> srList = adminDAO.calculateApprovalSpace(conn);
		JDBCTemplate.close(conn);
		return srList;
	}// calculateApprovalSpace

	public ArrayList<CalculateInfo> calculateApprovalInfo() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<CalculateInfo> ciList = adminDAO.calculateApprovalInfo(conn);
		JDBCTemplate.close(conn);
		return ciList;
	}// calculateApprovalInfo
	
	//정산 기록
	public int RecordCalculate(String adminCode, String memberCode, double calCost, double feeCost) {
		Connection conn = JDBCTemplate.getConnection();
		int result = adminDAO.RecordCalculate(conn, adminCode, memberCode, calCost, feeCost);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}// RecordCalculate

	//정산 조회
	public ArrayList<CalculateInfo> selectCalculate() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<CalculateInfo> ciList = adminDAO.selectCalculate(conn);
		JDBCTemplate.close(conn);
		return ciList;
	}// selectCalculate
	
	//정산 검색
	public ArrayList<SpaceRegistration> searchCalculateApprovalSpace() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<SpaceRegistration> srList = adminDAO.searchCalculateApprovalSpace(conn);
		JDBCTemplate.close(conn);
		return srList;
	}// searchCalculateApprovalSpace
	
	public ArrayList<CalculateInfo> searchCalculateApprovalInfo(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<CalculateInfo> ciList = adminDAO.searchCalculateApprovalInfo(conn,selectWord,keyword);
		JDBCTemplate.close(conn);
		return ciList;
	}// searchCalculateApproval

	public ArrayList<CalculateInfo> searchCalculate(String selectWord, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<CalculateInfo> ciList = adminDAO.searchCalculate(conn,selectWord,keyword);
		JDBCTemplate.close(conn);
		return ciList;
	}// searchCalculate
	
}// AdminService
