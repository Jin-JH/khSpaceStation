package ss.mango.user.space.model.vo;

import java.sql.Date;

public class SubSpace {
	private String subNo;
	private String spaceNo;
	private String subName;
	private String subIntro;
	private String subType;
	private int minTime;
	private int minPeople;
	private int maxPeople;
	private String amenities;
	private Date subDate;
	private char subDel;
	private Date subDelDate;
	private char subAprync;
	private char subOpen;
	private int subCost;
	private String refundFees;
	
	
	public SubSpace() {
		super();
	}
	
	public SubSpace(String subNo, String spaceNo, String subName, String subIntro, String subType, int minTime,
			int minPeople, int maxPeople, String amenities, Date subDate, char subDel, Date subDelDate, char subAprync,
			char subOpen, int subCost, String refundFees) {
		super();
		this.subNo = subNo;
		this.spaceNo = spaceNo;
		this.subName = subName;
		this.subIntro = subIntro;
		this.subType = subType;
		this.minTime = minTime;
		this.minPeople = minPeople;
		this.maxPeople = maxPeople;
		this.amenities = amenities;
		this.subDate = subDate;
		this.subDel = subDel;
		this.subDelDate = subDelDate;
		this.subAprync = subAprync;
		this.subOpen = subOpen;
		this.subCost = subCost;
		this.refundFees = refundFees;
	}
	
	public String getSubNo() {
		return subNo;
	}
	public void setSubNo(String subNo) {
		this.subNo = subNo;
	}
	public String getSpaceNo() {
		return spaceNo;
	}
	public void setSpaceNo(String spaceNo) {
		this.spaceNo = spaceNo;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubIntro() {
		return subIntro;
	}
	public void setSubIntro(String subIntro) {
		this.subIntro = subIntro;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public int getMinTime() {
		return minTime;
	}
	public void setMinTime(int minTime) {
		this.minTime = minTime;
	}
	public int getMinPeople() {
		return minPeople;
	}
	public void setMinPeople(int minPeople) {
		this.minPeople = minPeople;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	public String getAmenities() {
		return amenities;
	}
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	public Date getSubDate() {
		return subDate;
	}
	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}
	public char getSubDel() {
		return subDel;
	}
	public void setSubDel(char subDel) {
		this.subDel = subDel;
	}
	public Date getSubDelDate() {
		return subDelDate;
	}
	public void setSubDelDate(Date subDelDate) {
		this.subDelDate = subDelDate;
	}
	public char getSubAprync() {
		return subAprync;
	}
	public void setSubAprync(char subAprync) {
		this.subAprync = subAprync;
	}
	public char getSubOpen() {
		return subOpen;
	}
	public void setSubOpen(char subOpen) {
		this.subOpen = subOpen;
	}
	public int getSubCost() {
		return subCost;
	}
	public void setSubCost(int subCost) {
		this.subCost = subCost;
	}
	public String getRefundFees() {
		return refundFees;
	}
	public void setRefundFees(String refundFees) {
		this.refundFees = refundFees;
	}
}