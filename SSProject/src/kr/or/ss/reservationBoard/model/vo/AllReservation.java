package kr.or.ss.reservationBoard.model.vo;

import java.sql.Date;

public class AllReservation {
	private String resNO; 	//예약번호
	private String resInfoName;	//예약자이름
	private String subName;
	private Date resRecordDate;		//예약접수일, 신청일
	private char resState;		//취소여부 , 진행상태
	public AllReservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AllReservation(String resNO, String resInfoName, String subName, Date resRecordDate, char resState) {
		super();
		this.resNO = resNO;
		this.resInfoName = resInfoName;
		this.subName = subName;
		this.resRecordDate = resRecordDate;
		this.resState = resState;
	}
	public String getResNO() {
		return resNO;
	}
	public void setResNO(String resNO) {
		this.resNO = resNO;
	}
	public String getResInfoName() {
		return resInfoName;
	}
	public void setResInfoName(String resInfoName) {
		this.resInfoName = resInfoName;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
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
	
	
}
