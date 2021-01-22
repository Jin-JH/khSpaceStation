package ss.mango.admin.model.vo;

import java.sql.Date;

public class SpaceRegistration { //제 공간 등록 VO객체는 변수 9개 있습니다!
	private String spaceNo;
	private String spaceName;
	private String spaceTel;
	private String spaceAddress;
	private Date spaceDate;
	private char spaceDel;
	private Date spaceDelDate;
	private char spaceAprync;
	private String memberCode;
	private int allCost;
	
	public SpaceRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpaceRegistration(String spaceNo, String spaceName, String spaceTel, String spaceAddress, Date spaceDate,
			char spaceDel, Date spaceDelDate, char spaceAprync, String memberCode, int allCost) {
		super();
		this.spaceNo = spaceNo;
		this.spaceName = spaceName;
		this.spaceTel = spaceTel;
		this.spaceAddress = spaceAddress;
		this.spaceDate = spaceDate;
		this.spaceDel = spaceDel;
		this.spaceDelDate = spaceDelDate;
		this.spaceAprync = spaceAprync;
		this.memberCode = memberCode;
		this.allCost = allCost;
	}
	
	public String getSpaceNo() {
		return spaceNo;
	}
	public void setSpaceNo(String spaceNo) {
		this.spaceNo = spaceNo;
	}
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	public String getSpaceTel() {
		return spaceTel;
	}
	public void setSpaceTel(String spaceTel) {
		this.spaceTel = spaceTel;
	}
	public String getSpaceAddress() {
		return spaceAddress;
	}
	public void setSpaceAddress(String spaceAddress) {
		this.spaceAddress = spaceAddress;
	}
	public Date getSpaceDate() {
		return spaceDate;
	}
	public void setSpaceDate(Date spaceDate) {
		this.spaceDate = spaceDate;
	}
	public char getSpaceDel() {
		return spaceDel;
	}
	public void setSpaceDel(char spaceDel) {
		this.spaceDel = spaceDel;
	}
	public Date getSpaceDelDate() {
		return spaceDelDate;
	}
	public void setSpaceDelDate(Date spaceDelDate) {
		this.spaceDelDate = spaceDelDate;
	}
	public char getSpaceAprync() {
		return spaceAprync;
	}
	public void setSpaceAprync(char spaceAprync) {
		this.spaceAprync = spaceAprync;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public int getAllCost() {
		return allCost;
	}
	public void setAllCost(int allCost) {
		this.allCost = allCost;
	}
}
