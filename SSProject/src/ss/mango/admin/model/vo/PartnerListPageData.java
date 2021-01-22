package ss.mango.admin.model.vo;

import java.util.ArrayList;

public class PartnerListPageData {
	// 페이징 처리된 데이터를 저장하는 vo객체
	private ArrayList<Partner> list;
	private String pageNavi;
	
	public PartnerListPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PartnerListPageData(ArrayList<Partner> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	
	public ArrayList<Partner> getList() {
		return list;
	}
	public void setList(ArrayList<Partner> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
}
