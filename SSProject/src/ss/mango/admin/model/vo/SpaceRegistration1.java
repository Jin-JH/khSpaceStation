package ss.mango.admin.model.vo;

public class SpaceRegistration1 {
	private String spaceName;
	private int allCost;
	
	public SpaceRegistration1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpaceRegistration1(String spaceName, int allCost) {
		super();
		this.spaceName = spaceName;
		this.allCost = allCost;
	}

	public int getAllCost() {
		return allCost;
	}

	public void setAllCost(int allCost) {
		this.allCost = allCost;
	}

	public String getSpaceName() {
		return spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	
	
}
