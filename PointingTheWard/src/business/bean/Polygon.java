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

	public void addPoint(String xPos, String yPos) {
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
			
			double flat= Double.parseDouble(firstPoint.getLat());
			double flng = Double.parseDouble(firstPoint.getLng());
			
			double slat= Double.parseDouble(secondPoint.getLat());
			double slng = Double.parseDouble(secondPoint.getLng());
			

			factor = ((flat * slng) - (slat * flng ));	
			area += factor;
			
			centerX += (flat + slat) * ((flat * slng) - (slat * flng));
			centerY += (flng + slng) * ((flat *slng) - (slat * flng));
		}
		area *= 0.5;
		centerX /= 6 * area;
		centerY /= 6 * area;

		mCenterPoint.setLat(String.valueOf(centerX));
		mCenterPoint.setLng(String.valueOf(centerY));

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
			
			double flat= Double.parseDouble(firstPoint.getLat());
			double flng = Double.parseDouble(firstPoint.getLng());
			
			double slat= Double.parseDouble(secondPoint.getLat());
			double slng = Double.parseDouble(secondPoint.getLng());
			

			factor = ((flat * slng) - (slat * flng ));
			area += factor;
		}

		area *= 0.5;

		return area;
	}
}
