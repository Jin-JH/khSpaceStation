package kr.or.ss.partnerInfo.model.vo;

public class Partner {
	private String spaceNo; //공간번호
	private String memberCode; //회원코드(외래키)
	private String subNO;
	private String resInfoCode;	//예약자코드
	private String resNO; 	//예약번호
	public Partner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Partner(String spaceNo, String memberCode, String subNO, String resInfoCode, String resNO) {
		super();
		this.spaceNo = spaceNo;
		this.memberCode = memberCode;
		this.subNO = subNO;
		this.resInfoCode = resInfoCode;
		this.resNO = resNO;
	}
	public String getSpaceNo() {
		return spaceNo;
	}
	public void setSpaceNo(String spaceNo) {
		this.spaceNo = spaceNo;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getSubNO() {
		return subNO;
	}
	public void setSubNO(String subNO) {
		this.subNO = subNO;
	}
	public String getResInfoCode() {
		return resInfoCode;
	}
	public void setResInfoCode(String resInfoCode) {
		this.resInfoCode = resInfoCode;
	}
	public String getResNO() {
		return resNO;
	}
	public void setResNO(String resNO) {
		this.resNO = resNO;
	}
	
	
}
