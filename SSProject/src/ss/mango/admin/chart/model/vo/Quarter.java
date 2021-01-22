package ss.mango.admin.chart.model.vo;

public class Quarter {
	private int quarter;
	private int quarterCount;
	
	public Quarter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quarter(int quarter, int quarterCount) {
		super();
		this.quarter = quarter;
		this.quarterCount = quarterCount;
	}
	
	public int getQuarter() {
		return quarter;
	}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
	public int getQuarterCount() {
		return quarterCount;
	}
	public void setQuarterCount(int quarterCount) {
		this.quarterCount = quarterCount;
	}
}
