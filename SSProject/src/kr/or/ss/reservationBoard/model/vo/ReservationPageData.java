package kr.or.ss.reservationBoard.model.vo;

import java.util.ArrayList;



public class ReservationPageData {
	private ArrayList<AllReservation> list;
	private String pageNavi;
	public ReservationPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReservationPageData(ArrayList<AllReservation> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<AllReservation> getList() {
		return list;
	}
	public void setList(ArrayList<AllReservation> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
