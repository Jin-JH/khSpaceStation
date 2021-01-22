package kr.or.ss.space.model.vo;

import java.util.ArrayList;

public class MeetingRoomPageData {
	private ArrayList<MRManagement> list;
	private String pageNavi;
	public MeetingRoomPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MeetingRoomPageData(ArrayList<MRManagement> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<MRManagement> getList() {
		return list;
	}
	public void setList(ArrayList<MRManagement> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	
}
