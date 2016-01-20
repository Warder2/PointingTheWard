package model.beans;
/**
 * 와드 전 일정의 위치와 후 일정의 위치정보를 가지는 클래스
 * @author SEONGBONG
 *
 */
public class WardStartEndLocation {
	/**
	 * 전 일정의 위치
	 */
	private Place startLocation;
	/**
	 * 후 일정의 위치
	 */
	private Place endLocation;
	public WardStartEndLocation() {
		this(new Place(),new Place());
	}
	
	public WardStartEndLocation(String startLocationName, String endLocationName) {
		this.startLocation = new Place(startLocationName);
		this.endLocation = new Place(endLocationName);
	}

	public WardStartEndLocation(Place startLocation, Place endLocation) {
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}
	public Place getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(Place startLocation) {
		this.startLocation = startLocation;
	}
	public Place getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(Place endLocation) {
		this.endLocation = endLocation;
	}
	@Override
	public String toString() {
		return "WardStartEndLocation [startLocation=" + startLocation + ", endLocation=" + endLocation + "]";
	}
}
