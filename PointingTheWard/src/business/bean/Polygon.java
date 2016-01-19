package business.bean;

import java.util.ArrayList;
import java.util.List;

import model.beans.Point;

public class Polygon {
	private List<Point> mVertexs = new ArrayList<Point>();
	private Point mCenterPoint = null;
	
	public Polygon() {
		super();
	}
	
	public Polygon(List<Point> mVertexs, Point mCenterPoint) {
		this.mVertexs = mVertexs;
		this.mCenterPoint = mCenterPoint;
	}

	public void addPoint(double xPos, double yPos) {
		mVertexs.add(new Point(xPos, yPos));
		mCenterPoint = null;
	}

	public void clear() {
		mVertexs.clear();
	}

	public Point centerOfPolygon() {
		if (mCenterPoint != null) {
			return mCenterPoint;
		}
		double centerX = 0, centerY = 0;
		double area = 0;

		mCenterPoint = new Point();
		int firstIndex, secondIndex, sizeOfVertexs = mVertexs.size();
		Point firstPoint, secondPoint;

		double factor = 0;

		for (firstIndex = 0; firstIndex < sizeOfVertexs; firstIndex++) {
			secondIndex = (firstIndex + 1) % sizeOfVertexs;

			firstPoint = mVertexs.get(firstIndex);
			secondPoint = mVertexs.get(secondIndex);

			factor = ((firstPoint.getLat() * secondPoint.getLng()) - (secondPoint.getLat() * firstPoint.getLng()));	
			area += factor;
			
			centerX += (firstPoint.getLat() + secondPoint.getLat()) * ((firstPoint.getLat() * secondPoint.getLng()) - (secondPoint.getLat()*firstPoint.getLng()));
			centerY += (firstPoint.getLng() + secondPoint.getLng()) * ((firstPoint.getLat() * secondPoint.getLng()) - (secondPoint.getLat()*firstPoint.getLng()));
		}
		area *= 0.5;
		centerX /= 6 * area;
		centerY /= 6 * area;

		mCenterPoint.setLat(centerX);
		mCenterPoint.setLng(centerY);

		return mCenterPoint;
	}

	/**
	 * Polygon
	 * 
	 * @return
	 */
	public double getArea() {
		double area = 0;
		mCenterPoint = new Point();
		int firstIndex, secondIndex;
		int sizeOfVertexs = mVertexs.size();

		Point firstPoint;
		Point secondPoint;
		double factor = 0;
		for (firstIndex = 0; firstIndex < sizeOfVertexs; firstIndex++) {
			secondIndex = (firstIndex + 1) % sizeOfVertexs;
			firstPoint = mVertexs.get(firstIndex);
			secondPoint = mVertexs.get(secondIndex);
			factor = ((firstPoint.getLat() * secondPoint.getLng()) - (secondPoint.getLat() * firstPoint.getLng()));
			area += factor;
		}

		area *= 0.5;

		return area;
	}
}
