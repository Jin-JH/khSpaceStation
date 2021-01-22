package ss.mango.admin.model.vo;

import java.sql.Date;

public class Inquiry {
	private int inquiryNo;
	private String memberId;
	private String inquiryCategory;
	private String inquiryTitle;
	private String inquiryContent;
	private Date inquiryDate;
	private char inquiryAns;
	
	public Inquiry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inquiry(int inquiryNo, String memberId, String inquiryCategory, String inquiryTitle, String inquiryContent,
			Date inquiryDate, char inquiryAns) {
		super();
		this.inquiryNo = inquiryNo;
		this.memberId = memberId;
		this.inquiryCategory = inquiryCategory;
		this.inquiryTitle = inquiryTitle;
		this.inquiryContent = inquiryContent;
		this.inquiryDate = inquiryDate;
		this.inquiryAns = inquiryAns;
	}
	
	public int getInquiryNo() {
		return inquiryNo;
	}
	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getInquiryCategory() {
		return inquiryCategory;
	}
	public void setInquiryCategory(String inquiryCategory) {
		this.inquiryCategory = inquiryCategory;
	}
	public String getInquiryTitle() {
		return inquiryTitle;
	}
	public void setInquiryTitle(String inquiryTitle) {
		this.inquiryTitle = inquiryTitle;
	}
	public String getInquiryContent() {
		return inquiryContent;
	}
	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}
	public Date getInquiryDate() {
		return inquiryDate;
	}
	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}
	public char getInquiryAns() {
		return inquiryAns;
	}
	public void setInquiryAns(char inquiryAns) {
		this.inquiryAns = inquiryAns;
	}
}
