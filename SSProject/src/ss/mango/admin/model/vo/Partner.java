package ss.mango.admin.model.vo;

import java.sql.Date;

public class Partner {
	private String memberCode;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	private Date memberDate;
	private char memberEnd;
	private Date memberEndDate;
	private String ceoName;
	private String ceoPhone;
	private String businessName;
	private String businessLicenseNumber;
	private String businessAddress;
	private String businessEmail;
	
	public Partner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Partner(String memberCode, String memberId, String memberPw, String memberName, String memberEmail,
			String memberPhone, Date memberDate, char memberEnd, Date memberEndDate, String ceoName, String ceoPhone,
			String businessName, String businessLicenseNumber, String businessAddress, String businessEmail) {
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
		this.ceoName = ceoName;
		this.ceoPhone = ceoPhone;
		this.businessName = businessName;
		this.businessLicenseNumber = businessLicenseNumber;
		this.businessAddress = businessAddress;
		this.businessEmail = businessEmail;
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
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getCeoName() {
		return ceoName;
	}
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	public String getCeoPhone() {
		return ceoPhone;
	}
	public void setCeoPhone(String ceoPhone) {
		this.ceoPhone = ceoPhone;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessLicenseNumber() {
		return businessLicenseNumber;
	}
	public void setBusinessLicenseNumber(String businessLicenseNumber) {
		this.businessLicenseNumber = businessLicenseNumber;
	}
	public String getBusinessAddress() {
		return businessAddress;
	}
	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}
	public String getBusinessEmail() {
		return businessEmail;
	}
	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
	}
}