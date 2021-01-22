package ss.mango.user.member.model.vo;

public class PartnerInfo {
	private String memberCode;
	private String ceoName;
	private String ceoPhone;
	private String businessName;
	private long businessLicenseNumber;
	private String businessEmail;
	private String businessAddress;
	
	public PartnerInfo() {
		super();
	}
	
	public PartnerInfo(String memberCode, String ceoName, String ceoPhone, String businessName,
			long businessLicenseNumber, String businessEmail, String businessAddress) {
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
	public long getBusinessLicenseNumber() { return businessLicenseNumber; }
	public void setBusinessLicenseNumber(long businessLicenseNumber) { this.businessLicenseNumber = businessLicenseNumber; }
	public String getBusinessEmail() { return businessEmail; }
	public void setBusinessEmail(String businessEmail) { this.businessEmail = businessEmail; }
	public String getBusinessAddress() { return businessAddress; }
	public void setBusinessAddress(String businessAddress) { this.businessAddress = businessAddress; }
}