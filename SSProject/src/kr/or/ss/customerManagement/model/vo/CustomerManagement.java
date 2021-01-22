package kr.or.ss.customerManagement.model.vo;

public class CustomerManagement { //예약+ 예약자
private String resNo;  //예약번호
private String resInfoEmail; //이메일
private String resInfoName; //예약자
private String resInfoPhone; //연락처
private char resState; //예약상태


public CustomerManagement() {
	super();
	// TODO Auto-generated constructor stub
}
public CustomerManagement(String resNo, String resInfoEmail, String resInfoName, String resInfoPhone, char resState) {
	super();
	this.resNo = resNo;
	this.resInfoEmail = resInfoEmail;
	this.resInfoName = resInfoName;
	this.resInfoPhone = resInfoPhone;
	this.resState = resState;
}
public String getResNo() {
	return resNo;
}
public void setResNo(String resNo) {
	this.resNo = resNo;
}
public String getResInfoEmail() {
	return resInfoEmail;
}
public void setResInfoEmail(String resInfoEmail) {
	this.resInfoEmail = resInfoEmail;
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
public char getResState() {
	return resState;
}
public void setResState(char resState) {
	this.resState = resState;
}


}
