package kr.or.ss.reservationBoard.model.vo;

import java.sql.Date;
//예약
public class Reservation {
private String resNO; 	//예약번호
private String resInfoNo;	//예약자코드
private String subNo;	//세부공간번호
private Date resDate;	//이용일자
private int resStartTime;	//이용시작시간
private int resEndTime;	//이용 종료시간
private int resPeople;		//인원
private Date resRecordDate;		//예약접수일
private char resState;		//취소여부
private Date resCancleDate;		//취소날짜

public Reservation(String resNO, String resInfoNo, String subNo, Date resDate, int resStartTime, int resEndTime,
		int resPeople, Date resRecordDate, char resState, Date resCancleDate) {
	super();
	this.resNO = resNO;
	this.resInfoNo = resInfoNo;
	this.subNo = subNo;
	this.resDate = resDate;
	this.resStartTime = resStartTime;
	this.resEndTime = resEndTime;
	this.resPeople = resPeople;
	this.resRecordDate = resRecordDate;
	this.resState = resState;
	this.resCancleDate = resCancleDate;
}
public Reservation() {
	super();
	// TODO Auto-generated constructor stub
}
public String getResNO() {
	return resNO;
}
public void setResNO(String resNO) {
	this.resNO = resNO;
}
public String getResInfoNo() {
	return resInfoNo;
}
public void setResInfoNo(String resInfoNo) {
	this.resInfoNo = resInfoNo;
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
public Date getResCancleDate() {
	return resCancleDate;
}
public void setResCancleDate(Date resCancleDate) {
	this.resCancleDate = resCancleDate;
}


}
