package model.openData.dataForm;

public class StoreZoneDataForm {
	/**
	 * 상권번호
	 */
	private String mainTrarNo;
	/**
	 * 상권명
	 */
	private String mainTrarNm;
	/**
	 * 시도코드
	 */
	private String ctprvnCd;
	/**
	 * 시도명
	 */
	private String ctprvnNm;
	/**
	 * 시군구코드
	 */
	private String signguCd;
	/**
	 * 시군구명
	 */
	private String signguNm;
	/**
	 * 상권면적
	 */
	private String trarArea;
	/**
	 * 좌표개수
	 */
	private String coordNum;
	/**
	 * 좌표값
	 */
	private String coords;
	/**
	 * 데이터기준일자
	 */
	private String stdrDt;
	public StoreZoneDataForm() {
	}
	public StoreZoneDataForm(String mainTrarNo, String mainTrarNm, String ctprvnCd, String ctprvnNm, String signguCd,
			String signguNm, String trarArea, String coordNum, String coords, String stdrDt) {
		super();
		this.mainTrarNo = mainTrarNo;
		this.mainTrarNm = mainTrarNm;
		this.ctprvnCd = ctprvnCd;
		this.ctprvnNm = ctprvnNm;
		this.signguCd = signguCd;
		this.signguNm = signguNm;
		this.trarArea = trarArea;
		this.coordNum = coordNum;
		this.coords = coords;
		this.stdrDt = stdrDt;
	}
	public String getMainTrarNo() {
		return mainTrarNo;
	}
	public void setMainTrarNo(String mainTrarNo) {
		this.mainTrarNo = mainTrarNo;
	}
	public String getMainTrarNm() {
		return mainTrarNm;
	}
	public void setMainTrarNm(String mainTrarNm) {
		this.mainTrarNm = mainTrarNm;
	}
	public String getCtprvnCd() {
		return ctprvnCd;
	}
	public void setCtprvnCd(String ctprvnCd) {
		this.ctprvnCd = ctprvnCd;
	}
	public String getCtprvnNm() {
		return ctprvnNm;
	}
	public void setCtprvnNm(String ctprvnNm) {
		this.ctprvnNm = ctprvnNm;
	}
	public String getSignguCd() {
		return signguCd;
	}
	public void setSignguCd(String signguCd) {
		this.signguCd = signguCd;
	}
	public String getSignguNm() {
		return signguNm;
	}
	public void setSignguNm(String signguNm) {
		this.signguNm = signguNm;
	}
	public String getTrarArea() {
		return trarArea;
	}
	public void setTrarArea(String trarArea) {
		this.trarArea = trarArea;
	}
	public String getCoordNum() {
		return coordNum;
	}
	public void setCoordNum(String coordNum) {
		this.coordNum = coordNum;
	}
	public String getCoords() {
		return coords;
	}
	public void setCoords(String coords) {
		this.coords = coords;
	}
	public String getStdrDt() {
		return stdrDt;
	}
	public void setStdrDt(String stdrDt) {
		this.stdrDt = stdrDt;
	}
	@Override
	public String toString() {
		return "StoreZoneDataForm [mainTrarNo=" + mainTrarNo + ", mainTrarNm=" + mainTrarNm + ", ctprvnCd=" + ctprvnCd
				+ ", ctprvnNm=" + ctprvnNm + ", signguCd=" + signguCd + ", signguNm=" + signguNm + ", trarArea="
				+ trarArea + ", coordNum=" + coordNum + ", coords=" + coords + ", stdrDt=" + stdrDt + "]";
	}
}
