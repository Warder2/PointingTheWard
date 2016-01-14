package model.beans;
/**
 * 와드 정보를 가지는 클래스
 * @author SEONGBONG
 *
 */
public class Ward {
	/**
	 * 시작날짜
	 */
	private String sDate;
	/**
	 * 종료날짜
	 */
	private String eDate;
	/**
	 * 시작시간
	 */
	private String sTime;
	/**
	 * 종료시간
	 */
	private String eTime;
	/**
	 * 장소
	 */
	private Place place;

	public Ward() {
		// TODO Auto-generated constructor stub
	}
	public Ward(String sDate, String eDate, String sTime, String eTime) {
		super();
		this.sDate = sDate;
		this.eDate = eDate;
		this.sTime = sTime;
		this.eTime = eTime;
	}
	
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String geteDate() {
		return eDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}
	public String getsTime() {
		return sTime;
	}
	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	public String geteTime() {
		return eTime;
	}
	public void seteTime(String eTime) {
		this.eTime = eTime;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "Ward [sDate=" + sDate + ", eDate=" + eDate + ", sTime=" + sTime + ", eTime=" + eTime + ", place="
				+ place + "]";
	}
}
