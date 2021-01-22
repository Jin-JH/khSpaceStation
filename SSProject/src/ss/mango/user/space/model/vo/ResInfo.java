package ss.mango.user.space.model.vo;

public class ResInfo {
	private String resInfoCode;
	private String memberCode;
	private String resInfoName;
	private String resInfoPhone;
	private String resInfoEmail;
	private String usePurpose;
	private String requirements;
	
	public ResInfo() {
		super();
	}
	public ResInfo(String resInfoCode, String memberCode, String resInfoName, String resInfoPhone, String resInfoEmail,
			String usePurpose, String requirements) {
		super();
		this.resInfoCode = resInfoCode;
		this.memberCode = memberCode;
		this.resInfoName = resInfoName;
		this.resInfoPhone = resInfoPhone;
		this.resInfoEmail = resInfoEmail;
		this.usePurpose = usePurpose;
		this.requirements = requirements;
	}
	public String getResInfoCode() {
		return resInfoCode;
	}
	public void setResInfoCode(String resInfoCode) {
		this.resInfoCode = resInfoCode;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
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
	public String getResInfoEmail() {
		return resInfoEmail;
	}
	public void setResInfoEmail(String resInfoEmail) {
		this.resInfoEmail = resInfoEmail;
	}
	public String getUsePurpose() {
		return usePurpose;
	}
	public void setUsePurpose(String usePurpose) {
		this.usePurpose = usePurpose;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
}