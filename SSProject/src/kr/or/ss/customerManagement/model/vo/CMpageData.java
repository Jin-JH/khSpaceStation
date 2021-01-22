package kr.or.ss.customerManagement.model.vo;

import java.util.ArrayList;

public class CMpageData {
	private ArrayList<CustomerManagement> list;
	private String pageNavi;
	
	public CMpageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CMpageData(ArrayList<CustomerManagement> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<CustomerManagement> getList() {
		return list;
	}
	public void setList(ArrayList<CustomerManagement> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
