package kr.or.ss.member.model.vo;
//사업자정보
public class PartnerInfo {
	private String memberCode;
	private String ceoName;
	private String ceoPhone;
	private String businessName;
	private int businessLicenseNumber;
	private String businessEmail;
	private String businessAddress;
	
	public PartnerInfo() {
		super();
	}
	
	public PartnerInfo(String memberCode, String ceoName, String ceoPhone, String businessName,
			int businessLicenseNumber, String businessEmail, String businessAddress) {
		super();
		this.memberCode = memberCode;
		this.ceoName = ceoName;
		this.ceoPhone = ceoPhone;
		this.businessName = businessName;
		this.businessLicenseNumber = businessLicenseNumber;
		this.businessEmail = businessEmail;
		this.businessAddress = businessAddress;
	}
	
	public String getMemberCode() { return memberCode; }
	public void setMemberCode(String memberCode) { this.memberCode = memberCode; }
	public String getCeoName() { return ceoName; }
	public void setCeoName(String ceoName) { this.ceoName = ceoName; }
	public String getCeoPhone() { return ceoPhone; }
	public void setCeoPhone(String ceoPhone) { this.ceoPhone = ceoPhone; }
	public String getBusinessName() { return businessName; }
	public void setBusinessName(String businessName) { this.businessName = businessName; }
	public int getBusinessLicenseNumber() { return businessLicenseNumber; }
	public void setBusinessLicenseNumber(int businessLicenseNumber) { this.businessLicenseNumber = businessLicenseNumber; }
	public String getBusinessEmail() { return businessEmail; }
	public void setBusinessEmail(String businessEmail) { this.businessEmail = businessEmail; }
	public String getBusinessAddress() { return businessAddress; }
	public void setBusinessAddress(String businessAddress) { this.businessAddress = businessAddress; }
}