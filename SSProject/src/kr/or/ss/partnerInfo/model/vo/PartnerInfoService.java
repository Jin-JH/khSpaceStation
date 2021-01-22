package kr.or.ss.partnerInfo.model.vo;

import java.sql.Connection;

import kr.or.ss.common.JDBCTemplate;

public class PartnerInfoService {

	public void partnerInfo(String memberCode) {
		Connection conn = JDBCTemplate.getConnection();
		PartnerInfoDAO.partnerInfo(conn, memberCode);
		
	}

}
