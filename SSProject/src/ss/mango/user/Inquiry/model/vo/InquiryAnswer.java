package ss.mango.user.Inquiry.model.vo;

import java.sql.Date;

public class InquiryAnswer {
	private int inquiryNo;
	private String adminId;
	private String memberId;
	private String answerTitle;
	private String answerContent;
	private Date answerDate;
	
	public InquiryAnswer() {
		super();
	}
	
	public InquiryAnswer(int inquiryNo, String adminId, String memberId, String answerTitle, String answerContent,
			Date answerDate) {
		super();
		this.inquiryNo = inquiryNo;
		this.adminId = adminId;
		this.memberId = memberId;
		this.answerTitle = answerTitle;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
	}
	
	public int getInquiryNo() {
		return inquiryNo;
	}
	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getAnswerTitle() {
		return answerTitle;
	}
	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public Date getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}
}