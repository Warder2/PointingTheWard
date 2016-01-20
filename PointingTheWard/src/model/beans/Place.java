package model.beans;
/**
 * 장소정보를 가지는 클래스
 * @author SEONGBONG
 *
 */
public class Place {
	/**
	 * 장소 명
	 */
	private String name;
	/**
	 * 좌표
	 */
	private Point point;
	
	public Place() {
		this("Place name",new Point());
	}
	
	public Place(String name) {
		this(name, new Point());
	}
	public Place(String name, Point point) {
		this.name = name;
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "Place [name=" + name + ", point=" + point + "]";
	}	
}
