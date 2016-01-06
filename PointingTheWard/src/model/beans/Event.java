package model.beans;

import java.util.List;
/**
 * 일정 정보를 가지는 클래스
 * @author SEONGBONG
 *
 */
public class Event {
	private int eCode;
	/**
	 * 제목
	 */
	private String title;
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
	 * 내용
	 */
	private String content;
	/**
	 * 장소
	 */
	private Place place;
	/**
	 * 참가자
	 */
	private List<Member> participants;
	/**
	 * Defalut constructor
	 */
	public Event() {
	}
	public Event(int eCode, String title, String sDate, String eDate, String sTime, String eTime, String content, Place place,
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
