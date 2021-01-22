package ss.mango.admin.chart.model.vo;

import java.util.ArrayList;

public class SearchQuarter {
	private ArrayList<Quarter> searchJoin;
	private ArrayList<Quarter> searchEnd;
	
	public SearchQuarter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchQuarter(ArrayList<Quarter> searchJoin, ArrayList<Quarter> searchEnd) {
		super();
		this.searchJoin = searchJoin;
		this.searchEnd = searchEnd;
	}
	
	public ArrayList<Quarter> getSearchJoin() {
		return searchJoin;
	}
	public void setSearchJoin(ArrayList<Quarter> searchJoin) {
		this.searchJoin = searchJoin;
	}
	public ArrayList<Quarter> getSearchEnd() {
		return searchEnd;
	}
	public void setSearchEnd(ArrayList<Quarter> searchEnd) {
		this.searchEnd = searchEnd;
	}
}
