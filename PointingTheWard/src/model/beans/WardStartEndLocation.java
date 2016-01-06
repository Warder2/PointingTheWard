package model.beans;

public class WardStartEndLocation {
	private String startLocation;
	private String endLocation;
	public WardStartEndLocation() {
		this("시작위치","끝 위치");
	}
	public WardStartEndLocation(String startLocation, String endLocation) {
		super();
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	@Override
	public String toString() {
		return "WardStartEndLocation [startLocation=" + startLocation + ", endLocation=" + endLocation + "]";
	}
}
