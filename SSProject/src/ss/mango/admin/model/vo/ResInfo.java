package ss.mango.admin.model.vo;

public class ResInfo {
	
	private String columnName;
	private String memberCode;
	private String resInfoName;
	private String resInfoPhone;
	private String resInfoEmail;
	private String userPurpose;
	private String requirements;
	private String memberId;
	
	public ResInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResInfo(String columnName, String memberCode, String resInfoName, String resInfoPhone, String resInfoEmail,
			String userPurpose, String requirements, String memberId) {
		super();
		this.columnName = columnName;
		this.memberCode = memberCode;
		this.resInfoName = resInfoName;
		this.resInfoPhone = resInfoPhone;
		this.resInfoEmail = resInfoEmail;
		this.userPurpose = userPurpose;
		this.requirements = requirements;
		this.memberId = memberId;
	}
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
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

	public String getUserPurpose() {
		return userPurpose;
	}

	public void setUserPurpose(String userPurpose) {
		this.userPurpose = userPurpose;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

}
