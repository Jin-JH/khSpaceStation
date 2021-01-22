package kr.or.ss.space.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.or.ss.common.JDBCTemplate;
import kr.or.ss.space.model.dao.SpaceDAO;
import kr.or.ss.space.model.vo.DashCost;
import kr.or.ss.space.model.vo.MRManagement;
import kr.or.ss.space.model.vo.MeetingRoomPageData;
import kr.or.ss.space.model.vo.PartnerSpace;
import kr.or.ss.space.model.vo.Space;
import kr.or.ss.space.model.vo.SpaceCost;
import kr.or.ss.space.model.vo.SubSpace;

public class SpaceService {

	SpaceDAO sDAO = new SpaceDAO();
	
	public MeetingRoomPageData selectAllBoardPage(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 5; //한 페이지당 몇개의 게시물이 보이게 될 것인지
		
		ArrayList<MRManagement> list = sDAO.selectAllBoardPageList(conn, currentPage, recordCountPerPage);
		
		
		int naviCountPerPage = 2; 
		System.out.println(currentPage+"/"+naviCountPerPage);
		String pageNavi = sDAO.getPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage);
		System.out.println(pageNavi);
		//확인용도
				for(MRManagement mrManagement : list) {
					System.out.println(mrManagement.getSpaceName()+"/"+mrManagement.getSubNO()+"/"+mrManagement.getSubName()+"/"+mrManagement.getSubOpen()+"/"+mrManagement.getSubDate());
				}
				
			
		
		//리턴은 한번에 하나 밖에 할 수 없기 때문에 2개 데이터를 저장할 vo객체 필요함
		MeetingRoomPageData mrpd = new MeetingRoomPageData();
		mrpd.setList(list);
		mrpd.setPageNavi(pageNavi);
		JDBCTemplate.close(conn);
		
		return mrpd;
		
	}

	public int insertSpace(Space s, String memberCode) { //공간등록
		Connection conn = JDBCTemplate.getConnection();
		int result = sDAO.insertSpace(conn,s,memberCode);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		System.out.println("service"+result);
		return result;
	}

	public ArrayList<MRManagement> selectAllList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<MRManagement> list=sDAO.selectAllBoardPageList(conn);
		System.out.println("서비스확인용");
		JDBCTemplate.close(conn);
		return list;
		
	}



	public int updateSpace(String[] checkValues) {
		Connection conn=JDBCTemplate.getConnection();
		int result =sDAO.updateSpace(checkValues, conn);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	
	////////////////////////////////////////////////

	//메인공간 등록 현황 
		public Space selectAllSpace(String memberCode) {

			Connection conn = JDBCTemplate.getConnection();
			Space s = sDAO.selectAllSpace(conn, memberCode);
			JDBCTemplate.close(conn);
			
			return s;
		}

		
		//세부공간 등록 현황
		public ArrayList<SubSpace> selectSubSpaceAll(String spaceNo) {
			Connection conn = JDBCTemplate.getConnection();
			ArrayList<SubSpace> subList = sDAO.selectSubSpaceAll(conn, spaceNo);
			JDBCTemplate.close(conn);
			
			return subList;
		}
		
		
		//세부공간 등록
		public int insertSubSpace(SubSpace sSub, String memberCode) {
			Connection conn = JDBCTemplate.getConnection();
			int result = sDAO.insertSubSpace(conn, sSub, memberCode);
			
			if(result>0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			return result;
		}

		
		//사업자별 공간 현황
		public ArrayList<PartnerSpace> partnerSpace(String memberCode) {
			Connection conn = JDBCTemplate.getConnection();
			ArrayList<PartnerSpace> psList = sDAO.partnerSpace(conn, memberCode);
			JDBCTemplate.close(conn);
			
			return psList;
		}




		//일,주별 cost리스트
		public ArrayList<SpaceCost> spaceCost(String spaceNo) {
			Connection conn = JDBCTemplate.getConnection();
			ArrayList<SpaceCost> scList = sDAO.spaceCost(conn,spaceNo);
			JDBCTemplate.close(conn);
			
			return scList;
		}

		//월별 cost 리스트
		public ArrayList<SpaceCost> spaceCostM(String spaceNo) {
			Connection conn = JDBCTemplate.getConnection();
			ArrayList<SpaceCost> scList = sDAO.spaceCostM(conn,spaceNo);
			JDBCTemplate.close(conn);
			
			return scList;
		}

		//주별 cost 리스트
		public ArrayList<SpaceCost> spaceCostW(String spaceNo) {
			Connection conn = JDBCTemplate.getConnection();
			ArrayList<SpaceCost> scList = sDAO.spaceCostW(conn,spaceNo);

			JDBCTemplate.close(conn);
			
			return scList;
		}


		//dashTable에 불러올 월간현황
		public DashCost spaceCostDash(String spaceNo) {
			Connection conn = JDBCTemplate.getConnection();
			DashCost dc = sDAO.spaceCostDash(conn,spaceNo);

			JDBCTemplate.close(conn);
			
			return dc;
		}



}
