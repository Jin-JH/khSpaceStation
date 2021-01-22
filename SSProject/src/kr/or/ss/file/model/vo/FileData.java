package kr.or.ss.file.model.vo;

import java.sql.Timestamp;

public class FileData {
private int fileNo;
private String originalFileName;
private String changedFileName;
private String filePath;
private long fileSize;
private String fileUser;
private Timestamp uploadTime;
private char delYn;
public FileData() {
	super();
	// TODO Auto-generated constructor stub
}
public FileData(int fileNo, String originalFilename, String changedFileName, String filePath, int fileSize,
		String fileUser, Timestamp uploadTime, char delYn) {
	super();
	this.fileNo = fileNo;
	this.originalFileName = originalFilename;
	this.changedFileName = changedFileName;
	this.filePath = filePath;
	this.fileSize = fileSize;
	this.fileUser = fileUser;
	this.uploadTime = uploadTime;
	this.delYn = delYn;
}
public int getFileNo() {
	return fileNo;
}
public void setFileNo(int fileNo) {
	this.fileNo = fileNo;
}
public String getOriginalFileName() {
	return originalFileName;
}
public void setOriginalFileName(String originalFilename) {
	this.originalFileName = originalFilename;
}
public String getChangedFileName() {
	return changedFileName;
}
public void setChangedFileName(String changedFileName) {
	this.changedFileName = changedFileName;
}
public String getFilePath() {
	return filePath;
}
public void setFilePath(String filePath) {
	this.filePath = filePath;
}
public long getFileSize() {
	return fileSize;
}
public void setFileSize(long fileSize2) {
	this.fileSize = fileSize2;
}
public String getFileUser() {
	return fileUser;
}
public void setFileUser(String fileUser) {
	this.fileUser = fileUser;
}
public Timestamp getUploadTime() {
	return uploadTime;
}
public void setUploadTime(Timestamp uploadTime) {
	this.uploadTime = uploadTime;
}
public char getDelYn() {
	return delYn;
}
public void setDelYn(char delYn) {
	this.delYn = delYn;
}

}
