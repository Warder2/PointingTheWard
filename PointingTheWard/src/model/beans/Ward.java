package model.beans;

public class Ward {
	private String sDate;
	private String eDate;
	private String sTime;
	private String eTime;
	
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
	private Place place;

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
