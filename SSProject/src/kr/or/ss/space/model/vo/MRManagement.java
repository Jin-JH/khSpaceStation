package kr.or.ss.space.model.vo;

import java.sql.Date;

public class MRManagement {
private String spaceName;
private String subNO;
private String subName;
private Date subDate;
private char subOpen;
public MRManagement() {
	super();
	// TODO Auto-generated constructor stub
}
public MRManagement(String spaceName, String subNO, String subName, Date subDate, char subOpen) {
	super();
	this.spaceName = spaceName;
	this.subNO = subNO;
	this.subName = subName;
	this.subDate = subDate;
	this.subOpen = subOpen;
}
public String getSpaceName() {
	return spaceName;
}
public void setSpaceName(String spaceName) {
	this.spaceName = spaceName;
}
public String getSubNO() {
	return subNO;
}
public void setSubNO(String subNO) {
	this.subNO = subNO;
}
public String getSubName() {
	return subName;
}
public void setSubName(String subName) {
	this.subName = subName;
}
public Date getSubDate() {
	return subDate;
}
public void setSubDate(Date subDate) {
	this.subDate = subDate;
}
public char getSubOpen() {
	return subOpen;
}
public void setSubOpen(char subOpen) {
	this.subOpen = subOpen;
}


}
