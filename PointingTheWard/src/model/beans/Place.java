package model.beans;

public class Place {
	
	private String name;
	private Point point;
	
	public Place() {
	}
	public Place(String name, Point point) {
		super();
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
