package ss.mango.admin.model.vo;

import java.util.ArrayList;

public class InquiryPageData {
	
	// 페이징 처리된 데이터를 저장하는 vo객체
	private ArrayList<Inquiry> list;
	private String pageNavi;
	
	public InquiryPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InquiryPageData(ArrayList<Inquiry> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<Inquiry> getList() {
		return list;
	}
	public void setList(ArrayList<Inquiry> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
}
