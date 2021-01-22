package ss.mango.admin.chart.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ss.mango.admin.chart.model.vo.Quarter;
import ss.mango.admin.model.vo.Partner;
import ss.mango.admin.model.vo.ResInfo;
import ss.mango.admin.model.vo.Reservation;
import ss.mango.admin.model.vo.SpaceRegistration;
import ss.mango.admin.model.vo.User;
import ss.mango.common.JDBCTemplate;

public class ChartDAO {
	
	//최근 가입한 사용자 목록 5개
	public ArrayList<User> recentUserList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		  
		ArrayList<User> list = new ArrayList<User>();
		
		String query = "select * from "
				+ "(select ROW_NUMBER() OVER(order by MEMBERDATE DESC) AS Row_Num, member.* " + 
				"from member where memberCode like 'u%' and memberEnd='N') "
				+ "where Row_Num between 1 and 5 order by 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				User u = new User();
				
		        u.setMemberId(rset.getString("memberId"));
				u.setMemberName(rset.getString("memberName"));
				u.setMemberEmail(rset.getString("memberEmail"));
				u.setMemberPhone(rset.getString("memberPhone"));
				u.setMemberDate(rset.getDate("memberDate"));
				u.setMemberEndDate(rset.getDate("memberEndDate"));
				u.setMemberEnd(rset.getString("memberEnd").charAt(0));
				
			    list.add(u);
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

	//그래프 통계
	public ArrayList<Quarter> quarterJoinUserCount(Connection conn, String year) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Quarter> list = new ArrayList<Quarter>();
		year = year.substring(2);

		String query = "select quarter, count(*) as quarterCount " + 
				"from (SELECT to_char(memberDate,'Q')as quarter FROM member where memberCode like 'u%' and memberDate like ?) " + 
				"group by quarter order by quarter";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, year+"%");
			
			rset = pstmt.executeQuery();
			
			int count = 1;
			while(rset.next()) {
				Quarter q = new Quarter();
				
				//분기에 해당하는 데이터가 없으면 0처리
				while(count<rset.getInt("quarter")) {
					Quarter q0 = new Quarter();
					
					q0.setQuarter(count);
					q0.setQuarterCount(0);
					
					list.add(q0);
					count++;
				}
				
				if(count == rset.getInt("quarter")) {
					q.setQuarter(rset.getInt("quarter"));
					q.setQuarterCount(rset.getInt("quarterCount"));
					
					list.add(q);
					count++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Quarter> quarterEndUserCount(Connection conn, String year) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Quarter> list = new ArrayList<Quarter>();
		year = year.substring(2);

		String query = "select quarter, count(*) as quarterCount " + 
				"from (SELECT to_char(memberDate,'Q')as quarter FROM member where memberCode like 'u%' and memberEnd ='Y' and memberDate like ?) " + 
				"group by quarter order by quarter";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, year+"%");
			
			rset = pstmt.executeQuery();
			
			int quarter = 1;
			while(rset.next()) {
				Quarter q = new Quarter();
				
				while(quarter<rset.getInt("quarter")) {
					Quarter q0 = new Quarter();
					
					q0.setQuarter(quarter);
					q0.setQuarterCount(0);
					
					list.add(q0);
					quarter++;
				}
				
				if(quarter == rset.getInt("quarter")) {
					q.setQuarter(rset.getInt("quarter"));
					q.setQuarterCount(rset.getInt("quarterCount"));
					
					list.add(q);
					quarter++;
				}
			}
			// 선택된 분기 이후에 데이터가 없을 경우
			for(int i=quarter; i<5; i++) {
				Quarter q9 = new Quarter();
				
				q9.setQuarter(quarter);
				q9.setQuarterCount(0);
				
				list.add(q9);
				quarter++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	//최근 가입한 사업자 5명
	public ArrayList<Partner> recentPartnerList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		  
		ArrayList<Partner> list = new ArrayList<Partner>();
		
		String query = "with mem as(select ROW_NUMBER() OVER(order by MEMBERDATE DESC) AS Row_Num, m.* " + 
				"from member m where m.memberCode like 'p%' and m.memberEnd='N') " + 
				"select * from mem left join PARTNERINFO p on(mem.membercode=P.MEMBERCODE) " + 
				"where Row_Num between 1 and 5 order by 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Partner p = new Partner();
				
		        p.setMemberId(rset.getString("memberId"));
				p.setMemberName(rset.getString("memberName"));
				p.setMemberEmail(rset.getString("memberEmail"));
				p.setMemberPhone(rset.getString("memberPhone"));
				p.setMemberDate(rset.getDate("memberDate"));
				
				p.setBusinessName(rset.getString("BusinessName"));
				p.setCeoName(rset.getString("CeoName"));
				
			    list.add(p);
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

	//분기별 사업자 가입수
	public ArrayList<Quarter> quarterJoinPartnerCount(Connection conn, String year) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Quarter> list = new ArrayList<Quarter>();
		year = year.substring(2);

		String query = "select quarter, count(*) as quarterCount " + 
				"from (SELECT to_char(memberDate,'Q')as quarter FROM member where memberCode like 'p%' and memberDate like ?) " + 
				"group by quarter order by quarter";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, year+"%");
			
			rset = pstmt.executeQuery();
			
			int quarter = 1;
			while(rset.next()) {
				Quarter q = new Quarter();
				
				//분기에 해당하는 데이터가 없으면 0처리
				while(quarter<rset.getInt("quarter")) {
					Quarter q0 = new Quarter();
					
					q0.setQuarter(quarter);
					q0.setQuarterCount(0);
					
					list.add(q0);
					quarter++;
				}
				
				if(quarter == rset.getInt("quarter")) {
					q.setQuarter(rset.getInt("quarter"));
					q.setQuarterCount(rset.getInt("quarterCount"));
					
					list.add(q);
					quarter++;
				}
			}
			// 선택된 분기 이후에 데이터가 없을 경우
			for(int i=quarter; i<5; i++) {
				Quarter q9 = new Quarter();
				
				q9.setQuarter(quarter);
				q9.setQuarterCount(0);
				
				list.add(q9);
				quarter++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	//분기별 사업자 탈퇴 수
	public ArrayList<Quarter> quarterEndPartnerCount(Connection conn, String year) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Quarter> list = new ArrayList<Quarter>();
		year = year.substring(2);

		String query = "select quarter, count(*) as quarterCount " + 
				"from (SELECT to_char(memberDate,'Q')as quarter FROM member where memberCode like 'p%' and memberEnd ='Y' and memberDate like ?) " + 
				"group by quarter order by quarter";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, year+"%");
			
			rset = pstmt.executeQuery();
			
			int quarter = 1;
			while(rset.next()) {
				Quarter q = new Quarter();
				
				//분기에 해당하는 데이터가 없으면 0처리
				while(quarter<rset.getInt("quarter")) {
					Quarter q0 = new Quarter();
					
					q0.setQuarter(quarter);
					q0.setQuarterCount(0);
					
					list.add(q0);
					quarter++;
				}
				
				//분기에 해당하는 데이터가 있으면
				if(quarter == rset.getInt("quarter")) {
					q.setQuarter(rset.getInt("quarter"));
					q.setQuarterCount(rset.getInt("quarterCount"));
					
					list.add(q);
					quarter++;
				}
			}
			// 선택된 분기 이후에 데이터가 없을 경우
			for(int i=quarter; i<5; i++) {
				Quarter q9 = new Quarter();
				
				q9.setQuarter(quarter);
				q9.setQuarterCount(0);
				
				list.add(q9);
				quarter++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	//매출 통계 리스트
	public int salesList(Connection conn, String form, int i) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int result = 0;
		
		String query = "with sales as(select to_char(calDate,'YYYYMMDD')as cdate,calfees as calfees from CALCULATERECORD)\r\n" + 
				"select sum(calfees)as sum from sales where cdate like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			switch(i) {
			case 0: pstmt.setString(1, form.substring(0)); break;
			case 1: pstmt.setString(1, form.substring(0,5)+"%"); break;
			case 2: pstmt.setString(1, form.substring(0,3)+"%"); break;
			case 3: pstmt.setString(1, "%"); break;
			}
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				if(rset.getInt("sum")>0) {
					result = rset.getInt("sum")/10000;
				}else {
					result = 0;
				}
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

	//분기별 매출
	public ArrayList<Quarter> quarterSalesCount(Connection conn, String year) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Quarter> list = new ArrayList<Quarter>();

		String query = "select quarter, sum(CALFEES) as quarterSum " + 
				"from (SELECT to_char(calDate,'Q')as quarter, CALFEES FROM CALCULATERECORD where calDate like ?) " + 
				"group by quarter order by quarter";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, year+"%");
			
			rset = pstmt.executeQuery();
			
			int quarter = 1;
			while(rset.next()) {
				Quarter q = new Quarter();
				
				//분기에 해당하는 데이터가 없으면 0처리
				while(quarter<rset.getInt("quarter")) {
					Quarter q0 = new Quarter();
					
					q0.setQuarter(quarter);
					q0.setQuarterCount(0);
					
					list.add(q0);
					quarter++;
				}
				
				//분기에 해당하는 데이터가 있으면
				if(quarter == rset.getInt("quarter")) {
					q.setQuarter(rset.getInt("quarter"));
					
					if((rset.getInt("quarterSum")>0)){
						q.setQuarterCount((rset.getInt("quarterSum")/10000));
					}else {
						q.setQuarterCount(0);
					}
					list.add(q);
					quarter++;
				}	
			}
			// 선택된 분기 이후에 데이터가 없을 경우
			for(int i=quarter; i<5; i++) {
				Quarter q9 = new Quarter();
				
				q9.setQuarter(quarter);
				q9.setQuarterCount(0);
				
				list.add(q9);
				quarter++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	//최근 등록한 공간 정보
	public ArrayList<SpaceRegistration> recentSpaceRegistrationList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		  
		ArrayList<SpaceRegistration> list = new ArrayList<SpaceRegistration>();
		
		String query = "select * from " + 
				"(select ROW_NUMBER() OVER(order by spaceDate DESC) AS Row_Num, SpaceRegistration.* " + 
				"from SpaceRegistration where spaceDel ='N' and spaceAprync='Y') " + 
				"where Row_Num between 1 and 5 order by 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SpaceRegistration sr = new SpaceRegistration();
				
				sr.setMemberCode(rset.getString("MemberCode"));
				sr.setSpaceNo(rset.getString("spaceNo"));
				sr.setSpaceName(rset.getString("SpaceName"));
				sr.setSpaceAddress(rset.getString("SpaceAddress"));
				sr.setSpaceDate(rset.getDate("SpaceDate"));
				
			    list.add(sr);
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

	// 최근 공간을 등록한 사업자 정보
	public Partner recentPartnerList(Connection conn, String memberCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Partner p = null;
		
		String query = "select * from member where membercode=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Partner();
				
		        p.setMemberId(rset.getString("memberId"));
				p.setMemberName(rset.getString("memberName"));
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

	//분기별 등록된 공간 수
	public ArrayList<Quarter> quarterSpaceRegistrationCount(Connection conn, String year) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Quarter> list = new ArrayList<Quarter>();
		year = year.substring(2);

		String query = "select quarter, count(*) as quarterCount " + 
				"from (SELECT to_char(spaceDate,'Q')as quarter FROM SpaceRegistration "
				+ "where spaceDel ='N' and spaceAprync='Y' and spaceDate like ?) " + 
				"group by quarter order by quarter";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, year+"%");
			
			rset = pstmt.executeQuery();
			
			int quarter = 1;
			while(rset.next()) {
				Quarter q = new Quarter();
				
				//분기에 해당하는 데이터가 없으면 0처리
				while(quarter<rset.getInt("quarter")) {
					Quarter q0 = new Quarter();
					
					q0.setQuarter(quarter);
					q0.setQuarterCount(0);
					
					list.add(q0);
					quarter++;
				}
				
				if(quarter == rset.getInt("quarter")) {
					q.setQuarter(rset.getInt("quarter"));
					q.setQuarterCount(rset.getInt("quarterCount"));
					
					list.add(q);
					quarter++;
				}
			}
			// 선택된 분기 이후에 데이터가 없을 경우
			for(int i=quarter; i<5; i++) {
				Quarter q9 = new Quarter();
				
				q9.setQuarter(quarter);
				q9.setQuarterCount(0);
				
				list.add(q9);
				quarter++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	//최근 예약 목록
	public ArrayList<Reservation> recentResList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		
		String query = "select * from "
				+ "(select ROW_NUMBER() OVER(order by resrecordDate DESC) AS Row_Num, reservation.* from reservation where resState='N') "
				+ "where Row_Num between 1 and 5 order by 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Reservation r = new Reservation();
				
		        r.setResNo(rset.getString("resNo"));
		        r.setResInfoCode(rset.getString("ResInfoCode"));
		        r.setSubNo(rset.getString("SubNo"));
		        r.setResRecordDate(rset.getDate("ResRecordDate"));
		        r.setMemberCode(rset.getString("MemberCode"));
		        
		        list.add(r);
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

	public ResInfo recentResList(Connection conn, String resInfoCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ResInfo ri = null;
		
		String query = "select * from resinfo left join member using(membercode) "
				+ "where resInfoCode=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, resInfoCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				ri = new ResInfo();
				
		        ri.setMemberId(rset.getString("MemberId"));
		        ri.setResInfoName(rset.getString("ResInfoName"));
		        ri.setResInfoPhone(rset.getString("ResInfoPhone"));
		        ri.setResInfoEmail(rset.getString("ResInfoEmail"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return ri;
	}

	public SpaceRegistration recentResSpaceList(Connection conn, String subNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SpaceRegistration sr = null;
		
		String query = "select * from subSpace left join spaceRegistration using(spaceNo) "
				+ "where subNo=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, subNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				sr = new SpaceRegistration();
				
				sr.setSpaceName(rset.getString("spaceName"));
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

	// 분기별 총 예약 건수
	public ArrayList<Quarter> quarterResCount(Connection conn, String year) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Quarter> list = new ArrayList<Quarter>();
		year = year.substring(2);

		String query = "select quarter, count(*) as quarterCount "
				+ "from (SELECT to_char(resrecordDate,'Q')as quarter FROM reservation "
				+ "where resrecordDate like ?) "
				+ "group by quarter order by quarter";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, year+"%");
			
			rset = pstmt.executeQuery();
			
			int quarter = 1;
			while(rset.next()) {
				Quarter q = new Quarter();
				
				//분기에 해당하는 데이터가 없으면 0처리
				while(quarter<rset.getInt("quarter")) {
					Quarter q0 = new Quarter();
					
					q0.setQuarter(quarter);
					q0.setQuarterCount(0);
					
					list.add(q0);
					quarter++;
				}
				
				if(quarter == rset.getInt("quarter")) {
					q.setQuarter(rset.getInt("quarter"));
					q.setQuarterCount(rset.getInt("quarterCount"));
					
					list.add(q);
					quarter++;
				}
			}
			// 선택된 분기 이후에 데이터가 없을 경우
			for(int i=quarter; i<5; i++) {
				Quarter q9 = new Quarter();
				
				q9.setQuarter(quarter);
				q9.setQuarterCount(0);
				
				list.add(q9);
				quarter++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	// 분기별 환불된 예약 건수
	public ArrayList<Quarter> quarterResCancleCount(Connection conn, String year) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Quarter> list = new ArrayList<Quarter>();
		year = year.substring(2);

		String query = "select quarter, count(*) as quarterCount "
				+ "from (SELECT to_char(resrecordDate,'Q')as quarter FROM reservation "
				+ "where resState='Y' and resrecordDate like ?) "
				+ "group by quarter order by quarter";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, year+"%");
			
			rset = pstmt.executeQuery();
			
			int quarter = 1;
			while(rset.next()) {
				Quarter q = new Quarter();
				
				//분기에 해당하는 데이터가 없으면 0처리
				while(quarter<rset.getInt("quarter")) {
					Quarter q0 = new Quarter();
					
					q0.setQuarter(quarter);
					q0.setQuarterCount(0);
					
					list.add(q0);
					quarter++;
				}
				
				if(quarter == rset.getInt("quarter")) {
					q.setQuarter(rset.getInt("quarter"));
					q.setQuarterCount(rset.getInt("quarterCount"));
					
					list.add(q);
					quarter++;
				}
			}
			// 선택된 분기 이후에 데이터가 없을 경우
			for(int i=quarter; i<5; i++) {
				Quarter q9 = new Quarter();
				
				q9.setQuarter(quarter);
				q9.setQuarterCount(0);
				
				list.add(q9);
				quarter++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
}
