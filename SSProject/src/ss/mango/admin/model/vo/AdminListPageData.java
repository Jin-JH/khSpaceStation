package ss.mango.admin.model.vo;

import java.util.ArrayList;

public class AdminListPageData {
	// 페이징 처리된 데이터를 저장하는 vo객체
	private ArrayList<Admin> list;
	private String pageNavi;
	
	public AdminListPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminListPageData(ArrayList<Admin> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	
	public ArrayList<Admin> getList() {
		return list;
	}
	public void setList(ArrayList<Admin> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
}
