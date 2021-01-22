package ss.mango.user.Inquiry.model.vo;

import java.sql.Date;

public class Inquiry {
	private int inquiryNo;
	private String memberCode;
	private String inquiryCartegory;
	private String inquiryTitle;
	private String inquiryContent;
	private Date inquiryDate;
	private char inquiryAns;
	
	public Inquiry() {
		super();
	}
	
	public Inquiry(int inquiryNo, String memberCode, String inquiryCartegory, String inquiryTitle, String inquiryContent,
			Date inquiryDate, char inquiryAns) {
		super();
		this.inquiryNo = inquiryNo;
		this.memberCode = memberCode;
		this.inquiryCartegory = inquiryCartegory;
		this.inquiryTitle = inquiryTitle;
		this.inquiryContent = inquiryContent;
		this.inquiryDate = inquiryDate;
		this.inquiryAns = inquiryAns;
	}
	
	public int getInquiryNo() { return inquiryNo; }
	public void setInquiryNo(int inquiryNo) { this.inquiryNo = inquiryNo; }
	public String getMemberCode() { return memberCode; }
	public void setMemberCode(String memberCode) { this.memberCode = memberCode; }
	public String getInquiryCartegory() { return inquiryCartegory; }
	public void setInquiryCartegory(String inquiryCartegory) { this.inquiryCartegory = inquiryCartegory; }
	public String getInquiryTitle() { return inquiryTitle; }
	public void setInquiryTitle(String inquiryTitle) { this.inquiryTitle = inquiryTitle; }
	public String getInquiryContent() { return inquiryContent; }
	public void setInquiryContent(String inquiryContent) { this.inquiryContent = inquiryContent; }
	public Date getInquiryDate() { return inquiryDate; }
	public void setInquiryDate(Date inquiryDate) { this.inquiryDate = inquiryDate; }
	public char getInquiryAns() { return inquiryAns; }
	public void setInquiryAns(char inquiryAns) { this.inquiryAns = inquiryAns; }
}