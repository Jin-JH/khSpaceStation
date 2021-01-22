package kr.or.ss.space.model.vo;

public class SpaceCost {
	private String rDate;
	private int cost;
	private int stateN;
	private int stateY;
	public SpaceCost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpaceCost(String rDate, int cost, int stateN, int stateY) {
		super();
		this.rDate = rDate;
		this.cost = cost;
		this.stateN = stateN;
		this.stateY = stateY;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getStateN() {
		return stateN;
	}

	public void setStateN(int stateN) {
		this.stateN = stateN;
	}

	public int getStateY() {
		return stateY;
	}

	public void setStateY(int stateY) {
		this.stateY = stateY;
	}
	
	
	
	
}
