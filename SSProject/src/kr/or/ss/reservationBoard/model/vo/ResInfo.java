package kr.or.ss.reservationBoard.model.vo;
//예약자
public class ResInfo {
private String resInfoCode;	//예약자코드
private String memberCode;	//회원코드
private String resInfoName;	//예약자이름
private String resInfoPhone;	//예약자 연락처
private String resInfoEmail;	//예약자 이메일
private String userPurpose;		//사용목적
private String requirements;	//요청사항
public ResInfo() {
	super();
	// TODO Auto-generated constructor stub
}
public ResInfo(String resInfoCode, String memberCode, String resInfoName, String resInfoPhone, String resInfoEmail,
		String userPurpose, String requirements) {
	super();
	this.resInfoCode = resInfoCode;
	this.memberCode = memberCode;
	this.resInfoName = resInfoName;
	this.resInfoPhone = resInfoPhone;
	this.resInfoEmail = resInfoEmail;
	this.userPurpose = userPurpose;
	this.requirements = requirements;
}
public String getResInfoCode() {
	return resInfoCode;
}
public void setResInfoCode(String resInfoCode) {
	this.resInfoCode = resInfoCode;
}
public String getMemberCode() {
	return memberCode;
}
public void setMemberCode(String memberCode) {
	this.memberCode = memberCode;
}
public String getResInfoName() {
	return resInfoName;
}
public void setResInfoName(String resInfoName) {
	this.resInfoName = resInfoName;
}
public String getResInfoPhone() {
	return resInfoPhone;
}
public void setResInfoPhone(String resInfoPhone) {
	this.resInfoPhone = resInfoPhone;
}
public String getResInfoEmail() {
	return resInfoEmail;
}
public void setResInfoEmail(String resInfoEmail) {
	this.resInfoEmail = resInfoEmail;
}
public String getUserPurpose() {
	return userPurpose;
}
public void setUserPurpose(String userPurpose) {
	this.userPurpose = userPurpose;
}
public String getRequirements() {
	return requirements;
}
public void setRequirements(String requirements) {
	this.requirements = requirements;
}


}
