package model.openData;

public enum ReqeustLinCategory {
	I("I"), D("D");
	private String categody;
	private ReqeustLinCategory(String categody){
		this.categody = categody;
	}
	public String getCategody() {
		return categody;
	}
}
