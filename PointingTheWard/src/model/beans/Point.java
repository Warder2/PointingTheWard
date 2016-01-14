package model.beans;
/**
 * 좌표정보를 가지는 클래스
 * @author SEONGBONG
 *
 */
public class Point {
	/**
	 * 경도
	 */
	private double lng;
	/**
	 * 위도
	 */
	private double lat;

	public Point() {
	}
	public Point(double lng, double lat) {
		this.lng = lng;
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "Point [lng=" + lng + ", lat=" + lat + "]";
	}
}
