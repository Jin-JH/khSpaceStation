package ss.mango.user.member.model.vo;

public class CalculateInfo {
	private String memberCode;
	private String calBank;
	private String calAccount;
	private String calHolder;
	
	public CalculateInfo() {
		super();
	}
	
	public CalculateInfo(String memberCode, String calBank, String calAccount, String calHolder) {
		super();
		this.memberCode = memberCode;
		this.calBank = calBank;
		this.calAccount = calAccount;
		this.calHolder = calHolder;
	}
	
	public String getMemberCode() { return memberCode; }
	public void setMemberCode(String memberCode) { this.memberCode = memberCode; }
	public String getCalBank() { return calBank; }
	public void setCalBank(String calBank) { this.calBank = calBank; }
	public String getCalAccount() { return calAccount; }
	public void setCalAccount(String calAccount) { this.calAccount = calAccount; }
	public String getCalHolder() { return calHolder; }
	public void setCalHolder(String calHolder) { this.calHolder = calHolder; }
}