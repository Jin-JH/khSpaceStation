package kr.or.ss.space.model.vo;

public class PartnerSpace {
	
	//사업자별 공간 등록 현황
	private String spaceNo;
	private String subNo;
	private char spaceDel;
	private char spaceApr;
	private char subDel;
	private char subApr;
	private char subOpen;
	
	public PartnerSpace() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartnerSpace(String spaceNo, String subNo, char spaceDel, char spaceApr, char subDel, char subApr,
			char subOpen) {
		super();
		this.spaceNo = spaceNo;
		this.subNo = subNo;
		this.spaceDel = spaceDel;
		this.spaceApr = spaceApr;
		this.subDel = subDel;
		this.subApr = subApr;
		this.subOpen = subOpen;
	}

	public String getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(String spaceNo) {
		this.spaceNo = spaceNo;
	}

	public String getSubNo() {
		return subNo;
	}

	public void setSubNo(String subNo) {
		this.subNo = subNo;
	}

	public char getSpaceDel() {
		return spaceDel;
	}

	public void setSpaceDel(char spaceDel) {
		this.spaceDel = spaceDel;
	}

	public char getSpaceApr() {
		return spaceApr;
	}

	public void setSpaceApr(char spaceApr) {
		this.spaceApr = spaceApr;
	}

	public char getSubDel() {
		return subDel;
	}

	public void setSubDel(char subDel) {
		this.subDel = subDel;
	}

	public char getSubApr() {
		return subApr;
	}

	public void setSubApr(char subApr) {
		this.subApr = subApr;
	}

	public char getSubOpen() {
		return subOpen;
	}

	public void setSubOpen(char subOpen) {
		this.subOpen = subOpen;
	}
	
	
	
}

