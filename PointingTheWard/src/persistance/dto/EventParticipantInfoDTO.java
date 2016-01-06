package persistance.dto;

import model.beans.Transportation;

public class EventParticipantInfoDTO {
	private int eventCode;
	private String email;
	private String title;
	private String sDate;
	private String eDate;
	private String sTime;
	private String eTime;
	private String content;
	private String place;
	private String name;
	private String location;
	private Transportation transportation;
	
	public EventParticipantInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	public EventParticipantInfoDTO(int eventCode, String email, String title, String sDate, String eDate, String sTime,
			String eTime, String content, String place, String name, String location, Transportation transportation) {
		super();
		this.eventCode = eventCode;
		this.email = email;
		this.title = title;
		this.sDate = sDate;
		this.eDate = eDate;
		this.sTime = sTime;
		this.eTime = eTime;
		this.content = content;
		this.place = place;
		this.name = name;
		this.location = location;
		this.transportation = transportation;
	}

	public int getEventCode() {
		return eventCode;
	}

	public void setEventCode(int eventCode) {
		this.eventCode = eventCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Transportation getTransportation() {
		return transportation;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((eDate == null) ? 0 : eDate.hashCode());
		result = prime * result + ((eTime == null) ? 0 : eTime.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + eventCode;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((sDate == null) ? 0 : sDate.hashCode());
		result = prime * result + ((sTime == null) ? 0 : sTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((transportation == null) ? 0 : transportation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventParticipantInfoDTO other = (EventParticipantInfoDTO) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (eDate == null) {
			if (other.eDate != null)
				return false;
		} else if (!eDate.equals(other.eDate))
			return false;
		if (eTime == null) {
			if (other.eTime != null)
				return false;
		} else if (!eTime.equals(other.eTime))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (eventCode != other.eventCode)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (sDate == null) {
			if (other.sDate != null)
				return false;
		} else if (!sDate.equals(other.sDate))
			return false;
		if (sTime == null) {
			if (other.sTime != null)
				return false;
		} else if (!sTime.equals(other.sTime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (transportation == null) {
			if (other.transportation != null)
				return false;
		} else if (!transportation.equals(other.transportation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventParticipantInfoDTO [eventCode=" + eventCode + ", email=" + email + ", title=" + title + ", sDate="
				+ sDate + ", eDate=" + eDate + ", sTime=" + sTime + ", eTime=" + eTime + ", content=" + content
				+ ", place=" + place + ", name=" + name + ", location=" + location + ", transportation="
				+ transportation + "]";
	}
}
