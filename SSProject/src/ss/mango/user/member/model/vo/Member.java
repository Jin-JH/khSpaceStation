package ss.mango.user.member.model.vo;

import java.util.Date;

public class Member {
	private String memberCode;
	private String memberName;
	private String memberId;
	private String memberPw;
	private String memberPhone;
	private String memberEmail;
	private Date memberDate;
	private char memberEnd;
	private Date memberEndDate;
	
	public Member() {
		super();
	}
	public Member(String memberCode, String memberName, String memberId, String memberPw, String memberPhone,
			String memberEmail, Date memberDate, char memberEnd, Date memberEndDate) {
		super();
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberDate = memberDate;
		this.memberEnd = memberEnd;
		this.memberEndDate = memberEndDate;
	}
	public String getMemberCode() { return memberCode; }
	public void setMemberCode(String memberCode) { this.memberCode = memberCode; }
	public String getMemberName() { return memberName; }
	public void setMemberName(String memberName) { this.memberName = memberName; }
	public String getMemberId() { return memberId; }
	public void setMemberId(String memberId) { this.memberId = memberId; }
	public String getMemberPw() { return memberPw; }
	public void setMemberPw(String memberPw) { this.memberPw = memberPw; }
	public String getMemberPhone() { return memberPhone; }
	public void setMemberPhone(String memberPhone) { this.memberPhone = memberPhone; }
	public String getMemberEmail() { return memberEmail; }
	public void setMemberEmail(String memberEmail) { this.memberEmail = memberEmail; }
	public Date getMemberDate() { return memberDate; }
	public void setMemberDate(Date memberDate) { this.memberDate = memberDate; }
	public char getMemberEnd() { return memberEnd; }
	public void setMemberEnd(char memberEnd) { this.memberEnd = memberEnd; }
	public Date getMemberEndDate() { return memberEndDate; }
	public void setMemberEndDate(Date memberEndDate) { this.memberEndDate = memberEndDate; }
}