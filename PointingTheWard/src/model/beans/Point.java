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
	private String lng;
	/**
	 * 위도
	 */
	private String lat;

	public Point() {
		this("0.0","0.0");
	}
	public Point(String lng, String lat) {
		this.lng = lng;
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "Point [lng=" + lng + ", lat=" + lat + "]";
	}
}
