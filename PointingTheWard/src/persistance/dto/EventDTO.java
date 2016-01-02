package persistance.dto;

public class EventDTO {
	private int code;
	private String title;
	private String sDate;
	private String eDate;
	private String sTime;
	private String eTime;
	private String content;
	private String place;

	public EventDTO() {
		this(0, "title" , "start Date", "end Date", "start time", "end time", "content", "location");
	}
	
	public EventDTO(String title, String sDate, String eDate, String sTime, String eTime, String content,
			String place) {
		super();
		this.title = title;
		this.sDate = sDate;
		this.eDate = eDate;
		this.sTime = sTime;
		this.eTime = eTime;
		this.content = content;
		this.place = place;
	}

	public EventDTO(int code, String title, String sDate, String eDate, String sTime, String eTime, String content,
			String place) {
		super();
		this.code = code;
		this.title = title;
		this.sDate = sDate;
		this.eDate = eDate;
		this.sTime = sTime;
		this.eTime = eTime;
		this.content = content;
		this.place = place;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "EventDTO [code=" + code + ", title=" + title + ", sDate=" + sDate + ", eDate=" + eDate + ", sTime="
				+ sTime + ", eTime=" + eTime + ", content=" + content + ", place=" + place + "]";
	}


}
