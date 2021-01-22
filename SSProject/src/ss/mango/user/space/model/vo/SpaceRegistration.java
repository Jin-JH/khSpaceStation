package ss.mango.user.space.model.vo;

import java.sql.Date;

public class SpaceRegistration {
	private String spaceNo;
	private String memberCode;
	private String spaceIntro;
	private String spaceName;
	private String spaceAddress;
	private String spaceEmail;
	private String spaceTel;
	private String spacePhone;
	private int spaceSize;
	private String closedDay;
	private String operation24;
	private String startTime;
	private String lastTime;
	private String additionalInfo;
	private Date spaceDate;
	private char spaceDel;
	private Date spaceDelDate;
	private int minSubCost;
	private String fileName;
	
	public SpaceRegistration() {
		super();
	}
	
	public SpaceRegistration(String spaceNo, String memberCode, String spaceIntro, String spaceName,
			String spaceAddress, String spaceEmail, String spaceTel, String spacePhone, int spaceSize, String closedDay,
			String operation24, String startTime, String lastTime, String additionalInfo, Date spaceDate, char spaceDel,
			Date spaceDelDate, int minSubCost, String fileName) {
		super();
		this.spaceNo = spaceNo;
		this.memberCode = memberCode;
		this.spaceIntro = spaceIntro;
		this.spaceName = spaceName;
		this.spaceAddress = spaceAddress;
		this.spaceEmail = spaceEmail;
		this.spaceTel = spaceTel;
		this.spacePhone = spacePhone;
		this.spaceSize = spaceSize;
		this.closedDay = closedDay;
		this.operation24 = operation24;
		this.startTime = startTime;
		this.lastTime = lastTime;
		this.additionalInfo = additionalInfo;
		this.spaceDate = spaceDate;
		this.spaceDel = spaceDel;
		this.spaceDelDate = spaceDelDate;
		this.minSubCost = minSubCost;
		this.fileName = fileName;
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
	public String getSpaceIntro() {
		return spaceIntro;
	}
	public void setSpaceIntro(String spaceIntro) {
		this.spaceIntro = spaceIntro;
	}
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	public String getSpaceAddress() {
		return spaceAddress;
	}
	public void setSpaceAddress(String spaceAddress) {
		this.spaceAddress = spaceAddress;
	}
	public String getSpaceEmail() {
		return spaceEmail;
	}
	public void setSpaceEmail(String spaceEmail) {
		this.spaceEmail = spaceEmail;
	}
	public String getSpaceTel() {
		return spaceTel;
	}
	public void setSpaceTel(String spaceTel) {
		this.spaceTel = spaceTel;
	}
	public String getSpacePhone() {
		return spacePhone;
	}
	public void setSpacePhone(String spacePhone) {
		this.spacePhone = spacePhone;
	}
	public int getSpaceSize() {
		return spaceSize;
	}
	public void setSpaceSize(int spaceSize) {
		this.spaceSize = spaceSize;
	}
	public String getClosedDay() {
		return closedDay;
	}
	public void setClosedDay(String closedDay) {
		this.closedDay = closedDay;
	}
	public String getOperation24() {
		return operation24;
	}
	public void setOperation24(String operation24) {
		this.operation24 = operation24;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
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
	public int getMinSubCost() {
		return minSubCost;
	}
	public void setMinSubCost(int minSubCost) {
		this.minSubCost = minSubCost;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}