package ss.mango.admin.model.vo;

import java.sql.Date;

public class User {
	
	private String memberCode;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	private Date memberDate;
	private char memberEnd;
	private Date memberEndDate;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}// Member

	public User(String memberCode, String memberId, String memberPw, String memberName, String memberEmail,
			String memberPhone, Date memberDate, char memberEnd, Date memberEndDate) {
		super();
		this.memberCode = memberCode;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberDate = memberDate;
		this.memberEnd = memberEnd;
		this.memberEndDate = memberEndDate;
	}// Member

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public Date getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(Date memberDate) {
		this.memberDate = memberDate;
	}

	public char getMemberEnd() {
		return memberEnd;
	}

	public void setMemberEnd(char memberEnd) {
		this.memberEnd = memberEnd;
	}

	public Date getMemberEndDate() {
		return memberEndDate;
	}

	public void setMemberEndDate(Date memberEndDate) {
		this.memberEndDate = memberEndDate;
	}
		
}// Member
