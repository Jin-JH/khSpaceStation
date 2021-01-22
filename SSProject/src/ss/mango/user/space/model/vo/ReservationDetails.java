package ss.mango.user.space.model.vo;

import java.sql.Date;

public class ReservationDetails {
	private String resNo;
	private String spaceName;
	private String subType;
	private String subName;
	private Date resDate;
	private int resStartTime;
	private int resEndTime;
	private int resPeople;
	private char resState;
	private int usercost;
	
	
	public ReservationDetails() {
		super();
	}
	
	public ReservationDetails(String resNo, String spaceName, String subType, String subName, Date resDate,
			int resStartTime, int resEndTime, int resPeople, char resState, int usercost) {
		super();
		this.resNo = resNo;
		this.spaceName = spaceName;
		this.subType = subType;
		this.subName = subName;
		this.resDate = resDate;
		this.resStartTime = resStartTime;
		this.resEndTime = resEndTime;
		this.resPeople = resPeople;
		this.resState = resState;
		this.usercost = usercost;
	}
	
	public String getResNo() {
		return resNo;
	}
	public void setResNo(String resNo) {
		this.resNo = resNo;
	}
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public Date getResDate() {
		return resDate;
	}
	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}
	public int getResStartTime() {
		return resStartTime;
	}
	public void setResStartTime(int resStartTime) {
		this.resStartTime = resStartTime;
	}
	public int getResEndTime() {
		return resEndTime;
	}
	public void setResEndTime(int resEndTime) {
		this.resEndTime = resEndTime;
	}
	public int getResPeople() {
		return resPeople;
	}
	public void setResPeople(int resPeople) {
		this.resPeople = resPeople;
	}
	public char getResState() {
		return resState;
	}
	public void setResState(char resState) {
		this.resState = resState;
	}
	public int getUserCost() {
		return usercost;
	}
	public void setUserCost(int usercost) {
		this.usercost = usercost;
	}
}