package ss.mango.user.space.model.vo;

import java.sql.Date;

public class Reservation {
	private String resNo;
	private String resInfoCode;
	private String subNo;
	private Date resDate;
	private int resStartTime;
	private int resEndTime;
	private int resPeople;
	private Date resRecordDate;
	private char resState;
	private Date resCancelDate;
	private int usercost;
	private String memberCode;
	private String spaceName;
	
	public Reservation() {
		super();
	}
	
	public Reservation(String resNo, String resInfoCode, String subNo, Date resDate, int resStartTime, int resEndTime,
			int resPeople, Date resRecordDate, char resState, Date resCancelDate, int usercost, String memberCode, String spaceName) {
		super();
		this.resNo = resNo;
		this.resInfoCode = resInfoCode;
		this.subNo = subNo;
		this.resDate = resDate;
		this.resStartTime = resStartTime;
		this.resEndTime = resEndTime;
		this.resPeople = resPeople;
		this.resRecordDate = resRecordDate;
		this.resState = resState;
		this.resCancelDate = resCancelDate;
		this.usercost = usercost;
		this.memberCode = memberCode;
		this.spaceName = spaceName;
	}
	
	public String getResNo() {
		return resNo;
	}
	public void setResNo(String resNo) {
		this.resNo = resNo;
	}
	public String getResInfoCode() {
		return resInfoCode;
	}
	public void setResInfoCode(String resInfoCode) {
		this.resInfoCode = resInfoCode;
	}
	public String getSubNo() {
		return subNo;
	}
	public void setSubNo(String subNo) {
		this.subNo = subNo;
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
	public Date getResRecordDate() {
		return resRecordDate;
	}
	public void setResRecordDate(Date resRecordDate) {
		this.resRecordDate = resRecordDate;
	}
	public char getResState() {
		return resState;
	}
	public void setResState(char resState) {
		this.resState = resState;
	}
	public Date getResCancelDate() {
		return resCancelDate;
	}
	public void setResCancelDate(Date resCancelDate) {
		this.resCancelDate = resCancelDate;
	}
	public int getUsercost() {
		return usercost;
	}
	public void setUsercost(int usercost) {
		this.usercost = usercost;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
}
