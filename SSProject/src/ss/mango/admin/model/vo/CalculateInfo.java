package ss.mango.admin.model.vo;

public class CalculateInfo {
	
	private String memberCode;
	private String memberId;
	private String spaceName;
	private String calBank;
	private String calAccount;
	private String calHolder;
	private int allCost;
	private int calCost;
	private int calFees;
	private String calTerm;
	
	public CalculateInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CalculateInfo(String memberCode, String memberId, String spaceName, String calBank, String calAccount,
			String calHolder, int allCost, int calCost, int calFees, String calTerm) {
		super();
		this.memberCode = memberCode;
		this.memberId = memberId;
		this.spaceName = spaceName;
		this.calBank = calBank;
		this.calAccount = calAccount;
		this.calHolder = calHolder;
		this.allCost = allCost;
		this.calCost = calCost;
		this.calFees = calFees;
		this.calTerm = calTerm;
	}

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

	public String getSpaceName() {
		return spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	public String getCalBank() {
		return calBank;
	}

	public void setCalBank(String calBank) {
		this.calBank = calBank;
	}

	public String getCalAccount() {
		return calAccount;
	}

	public void setCalAccount(String calAccount) {
		this.calAccount = calAccount;
	}

	public String getCalHolder() {
		return calHolder;
	}

	public void setCalHolder(String calHolder) {
		this.calHolder = calHolder;
	}

	public int getAllCost() {
		return allCost;
	}

	public void setAllCost(int allCost) {
		this.allCost = allCost;
	}

	public int getCalCost() {
		return calCost;
	}

	public void setCalCost(int calCost) {
		this.calCost = calCost;
	}

	public int getCalFees() {
		return calFees;
	}

	public void setCalFees(int calFees) {
		this.calFees = calFees;
	}

	public String getCalTerm() {
		return calTerm;
	}

	public void setCalTerm(String calTerm) {
		this.calTerm = calTerm;
	}
	
}// CalculateInfo
