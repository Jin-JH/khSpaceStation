package kr.or.ss.inquiry.model.vo;

import java.sql.Date;

public class Inquiry {
private int inquiryNo;
private Date inquiryDate;
private String memberName; 
private String inquirytitle;
private char inquiryANS;
public Inquiry() {
	super();
	// TODO Auto-generated constructor stub
}
public Inquiry(int inquiryNo, Date inquiryDate, String memberName, String inquirytitle, char inquiryANS) {
	super();
	this.inquiryNo = inquiryNo;
	this.inquiryDate = inquiryDate;
	this.memberName = memberName;
	this.inquirytitle = inquirytitle;
	this.inquiryANS = inquiryANS;
}
public int getInquiryNo() {
	return inquiryNo;
}
public void setInquiryNo(int inquiryNo) {
	this.inquiryNo = inquiryNo;
}
public Date getInquiryDate() {
	return inquiryDate;
}
public void setInquiryDate(Date inquiryDate) {
	this.inquiryDate = inquiryDate;
}
public String getMemberName() {
	return memberName;
}
public void setMemberName(String memberName) {
	this.memberName = memberName;
}
public String getInquirytitle() {
	return inquirytitle;
}
public void setInquirytitle(String inquirytitle) {
	this.inquirytitle = inquirytitle;
}
public char getInquiryANS() {
	return inquiryANS;
}
public void setInquiryANS(char inquiryANS) {
	this.inquiryANS = inquiryANS;
}


}
