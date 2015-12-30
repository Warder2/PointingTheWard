package model.ListVO;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.beans.Point;

public class PointList {
	private List<Point> points;

	public PointList() {
		super();
	}

	public PointList(List<Point> points) {
		super();
		this.points = points;
	}
	
	public void add(int index, Point element) {
		points.add(index, element);
	}

	public boolean add(Point e) {
		return points.add(e);
	}

	public boolean addAll(Collection<? extends Point> c) {
		return points.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends Point> c) {
		return points.addAll(index, c);
	}

	public Point searchPoint(Point point){
		
		for(Point p : points){
			if(p.equals(point)) return p;
		}
		return null;
	}
	
	public Point searchPointValue(double lng, double lat){
		
		for(Point p : points){
			if(p.getLat() == lat && p.getLng() == lng)
				return p;
		}
		
		return null;
	}
	
	public boolean modifyPoint(Point point,  Point newPoint){
		
		Point p = searchPoint(point);
		
		if( p != null){
			p = newPoint;
			return true;
		}
		return false;

	}
	
	public boolean modifyPointValue(Point point, double newlng , double newlat){
		
		Point p = searchPoint(point);
		
		if( p != null){
			p.setLat(newlat);
			p.setLng(newlng);
			return true;
		}
		return false;
	}
	
	public boolean deletePoint(Point point){
		
		Point p = searchPoint(point);
		
		if( p != null){
			remove(p);
			return true;
		}
		return false;
	}
	
	public boolean deletePointValue(double lat, double lng){
		
		Point p = searchPointValue(lng, lat);
		
		if( p != null){
			remove(p);
			return true;
		}
		return false;
		
	}
	
	public void clear() {
		points.clear();
	}

	public boolean contains(Object o) {
		return points.contains(o);
	}

	public boolean equals(Object o) {
		return points.equals(o);
	}

	public Point get(int index) {
		return points.get(index);
	}

	public int indexOf(Object o) {
		return points.indexOf(o);
	}

	public boolean isEmpty() {
		return points.isEmpty();
	}

	public Iterator<Point> iterator() {
		return points.iterator();
	}

	public int lastIndexOf(Object o) {
		return points.lastIndexOf(o);
	}

	public Point remove(int index) {
		return points.remove(index);
	}

	public boolean remove(Object o) {
		return points.remove(o);
	}

	public Point set(int index, Point element) {
		return points.set(index, element);
	}

	public int size() {
		return points.size();
	}

	public List<Point> subList(int fromIndex, int toIndex) {
		return points.subList(fromIndex, toIndex);
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "PointList [points=" + points + "]";
	}
	
}
