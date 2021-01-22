package ss.mango.admin.model.vo;

import java.sql.Date;

public class Admin {
	private String adminCode;
	private String adminId;
	private String adminPw;
	private String position;
	private String adminName;
	private String adminPhone;
	private String adminSubPhone;
	private String adminEmail;
	private char right;
	private Date adminDate;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String adminCode, String adminId, String adminPw, String position, String adminName, String adminPhone,
			String adminSubPhone, String adminEmail, char right, Date adminDate) {
		super();
		this.adminCode = adminCode;
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.position = position;
		this.adminName = adminName;
		this.adminPhone = adminPhone;
		this.adminSubPhone = adminSubPhone;
		this.adminEmail = adminEmail;
		this.right = right;
		this.adminDate = adminDate;
	}
	
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	public String getAdminSubPhone() {
		return adminSubPhone;
	}
	public void setAdminSubPhone(String adminSubPhone) {
		this.adminSubPhone = adminSubPhone;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public char getRight() {
		return right;
	}
	public void setRight(char right) {
		this.right = right;
	}
	public Date getAdminDate() {
		return adminDate;
	}
	public void setAdminDate(Date adminDate) {
		this.adminDate = adminDate;
	}
}
