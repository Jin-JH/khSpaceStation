package ss.mango.user.file.model.vo;

import java.sql.Timestamp;

public class FileData {
	private int fileNo;
	private String originalFileName;
	private String changedFileName;
	private String filePath;
	private long fileSize;
	private String fileUser;
	private Timestamp uploadTime;
	
	public FileData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileData(int fileNo, String originalFileName, String changedFileName, String filePath, long fileSize,
			String fileUser, Timestamp uploadTime) {
		super();
		this.fileNo = fileNo;
		this.originalFileName = originalFileName;
		this.changedFileName = changedFileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.fileUser = fileUser;
		this.uploadTime = uploadTime;
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
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
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
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
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
}