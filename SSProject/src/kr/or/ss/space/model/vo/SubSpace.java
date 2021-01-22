package kr.or.ss.space.model.vo;

import java.sql.Date;

public class SubSpace {
private String subNO; //1세부공간번호
private String spaceNo; //2공간번호
private String subName; //3세부공간이름
private String subIntro; //4세부공간소개
private String subType; //5세부공간유형
private int minTime; //6최소시간
private int minPeople; //7최소인원
private int maxPeople; //8최대인원
private String amenities; //9편의시설
private Date subDate; //10세부공간등록일
private char subDel; //11세부공간삭제여
//private Date subDelDate; //12세부공간삭제일
private char subAPRYNC; //13세부공간승인여부
private char subOpen; //14세부공간미공개여부
private int subCost; //15세부공간금액
private String refundFees; //16세부공간취소수수료



public SubSpace() {
	super();
	// TODO Auto-generated constructor stub
}

public SubSpace(String subNO, String spaceNo, String subName, String subIntro, String subType, int minTime,
		int minPeople, int maxPeople, String amenities, Date subDate, char subDel, char subAPRYNC, char subOpen,
		int subCost, String refundFees) {
	super();
	this.subNO = subNO;
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
	this.subAPRYNC = subAPRYNC;
	this.subOpen = subOpen;
	this.subCost = subCost;
	this.refundFees = refundFees;
}

public String getSubNO() {
   return subNO;
}
public void setSubNO(String subNO) {
   this.subNO = subNO;
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
/*public Date getSubDelDate() {
   return subDelDate;
}
public void setSubDelDate(Date subDelDate) {
   this.subDelDate = subDelDate;
}*/
public char getSubAPRYNC() {
   return subAPRYNC;
}
public void setSubAPRYNC(char subAPRYNC) {
   this.subAPRYNC = subAPRYNC;
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