package model.openDataVO;

import java.util.StringTokenizer;

import model.beans.Point;
import model.list.PointList;

public class StoreZone {
	/**
	 * 상권명
	 */
	private String mainTrarNm;
	/**
	 * 시도명
	 */
	private String ctprvnNm;
	/**
	 * 시군구명
	 */
	private String signguNm;
	/**
	 * 좌표개수
	 */
	private int coordNum;
	/**
	 * 좌표값
	 */
	private PointList coords;

	public StoreZone() {
		super();
		coords = new PointList();

	}

	public StoreZone(String mainTrarNm, String ctprvnNm, String signguNm, int coordNum, PointList coords) {
		super();
		this.mainTrarNm = mainTrarNm;
		this.ctprvnNm = ctprvnNm;
		this.signguNm = signguNm;
		this.coordNum = coordNum;
		this.coords = coords;
	}

	public String getMainTrarNm() {
		return mainTrarNm;
	}

	public void setMainTrarNm(String mainTrarNm) {
		this.mainTrarNm = mainTrarNm;
	}

	public String getCtprvnNm() {
		return ctprvnNm;
	}

	public void setCtprvnNm(String ctprvnNm) {
		this.ctprvnNm = ctprvnNm;
	}

	public String getSignguNm() {
		return signguNm;
	}

	public void setSignguNm(String signguNm) {
		this.signguNm = signguNm;
	}

	public int getCoordNum() {
		return coordNum;
	}

	public void setCoordNum(int coordNum) {
		this.coordNum = coordNum;
	}

	public PointList getCoords() {
		return coords;
	}

	public void setCoords(PointList coords) {
		this.coords = coords;
	}

	public void setcoordes(String coord) {

		StringTokenizer co = new StringTokenizer(coord, ",");

		while (co.hasMoreTokens()) {
			String p = co.nextToken();

			StringTokenizer points = new StringTokenizer(p, " ");
			while (points.hasMoreTokens()) {

				String lat = points.nextToken();
				Double latD = Double.parseDouble(lat);

				String lng = points.nextToken();
				Double lngD = Double.parseDouble(lng);

				coords.getPoints().add(new Point(lng, lat));
			}
		}
	}
	
	@Override
	public String toString() {
		return "StoreZone [mainTrarNm=" + mainTrarNm + ", ctprvnNm=" + ctprvnNm + ", signguNm=" + signguNm
				+ ", coordNum=" + coordNum + ", coords=" + coords + "]";
	}
}
