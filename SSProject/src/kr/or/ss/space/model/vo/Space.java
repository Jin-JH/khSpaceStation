package kr.or.ss.space.model.vo;

import java.sql.Date;

public class Space {
   
private String spaceNo; //공간번호
private String memberCode; //회원코드(외래키)
private String spaceIntro; //공간소개
private String spaceName; //공간이름
private String spaceAddress; //공간주소
private String spaceEmail;//공간이메일
private String spaceTel; //공간유선번호
private String spacePhone; //공간휴대폰
private int spaceSize; //공간사이즈
private String closedDay; //휴무일
private String operation24; //24시간운영유무
private String startTime; //운영시작시간
private String lastTime; //운영마감시간
private String additionalInfo; //추가안내사항
private char aprYNC; //승인
private char spaceDel; //삭제여부
private Date spaceDate; //공간등록일
private String fileLoadName;
//private String space_thumbnail; //썸네일 이미지 목록
//private String space_img;//대표이미지
public Space() {
	super();
	// TODO Auto-generated constructor stub
}
public Space(String spaceNo, String memberCode, String spaceIntro, String spaceName, String spaceAddress,
		String spaceEmail, String spaceTel, String spacePhone, int spaceSize, String closedDay, String operation24,
		String startTime, String lastTime, String additionalInfo, char aprYNC, char spaceDel, Date spaceDate, String fileLoadName) {
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
	this.aprYNC = aprYNC;
	this.spaceDel = spaceDel;
	this.spaceDate = spaceDate;
	this.fileLoadName = fileLoadName;
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
public char getAprYNC() {
	return aprYNC;
}
public void setAprYNC(char aprYNC) {
	this.aprYNC = aprYNC;
}
public char getSpaceDel() {
	return spaceDel;
}
public void setSpaceDel(char spaceDel) {
	this.spaceDel = spaceDel;
}
public Date getSpaceDate() {
	return spaceDate;
}
public void setSpaceDate(Date spaceDate) {
	this.spaceDate = spaceDate;
}
public String getFileLoadName() {
	return fileLoadName;
}
public void setFileLoadName(String fileLoadName) {
	this.fileLoadName = fileLoadName;
}



}