package model.beans;

import java.util.List;

public class Event {
	private String title;
	private String sDate;
	private String eDate;
	private String sTime;
	private String eTime;
	private String content;
	private Place place;
	private List<Member> participants;
	public Event() {
	}
	public Event(String title, String sDate, String eDate, String sTime, String eTime, String content, Place place,
			List<Member> participants) {
		super();
		this.title = title;
		this.sDate = sDate;
		this.eDate = eDate;
		this.sTime = sTime;
		this.eTime = eTime;
		this.content = content;
		this.place = place;
		this.participants = participants;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public List<Member> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Member> participants) {
		this.participants = participants;
	}
	@Override
	public String toString() {
		return "Event [title=" + title + ", sDate=" + sDate + ", eDate=" + eDate + ", sTime=" + sTime + ", eTime="
				+ eTime + ", content=" + content + ", place=" + place + ", participants=" + participants + "]";
	}
}
