package model.openDataVO;

import model.ListVO.PointList;

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
	
	public void setcoordes(String coords){
		//구현 해야함 
	}
	@Override
	public String toString() {
		return "StoreZone [mainTrarNm=" + mainTrarNm + ", ctprvnNm=" + ctprvnNm + ", signguNm=" + signguNm
				+ ", coordNum=" + coordNum + ", coords=" + coords + "]";
	}
}
