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
		}else if(mVertexs.size() > 3){
			//좌표가 3개 이상일 경우 max X,Y | min X,Y를 이용한 사각형좌표로 초기화
			tetragonFromVertexs();
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
	public void tetragonFromVertexs(){
		Point initPoint = this.mVertexs.get(0);
		Point max = new Point(initPoint.getLat(),initPoint.getLng());
		Point min = new Point(initPoint.getLat(),initPoint.getLng());
		for(Point point: this.mVertexs){
			if(max.getLat().compareTo(point.getLat()) < 0){
				max.setLat(point.getLat());
			}else if(min.getLat().compareTo(point.getLat()) > 0){
				min.setLat(point.getLat());
			} 
			if(max.getLng().compareTo(point.getLng()) < 0){
				max.setLng(point.getLng());
			}else if(min.getLng().compareTo(point.getLng()) > 0){
				min.setLng(point.getLng());
			}
		}
		this.mVertexs.clear();
		this.mVertexs.add(new Point(min.getLat(),max.getLng()));//(min x, max y)
		this.mVertexs.add(new Point(max.getLat(),max.getLng()));//(max x, max y)
		this.mVertexs.add(new Point(max.getLat(),min.getLng()));//(max x, min y)
		this.mVertexs.add(new Point(min.getLat(),min.getLng()));//(min x, min y)		
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
