package model.beans;

import java.util.List;

public class Group {
	private int gCode;
	private String name;
	private List<Friend> participants;
	
	public Group() {
	}

	public Group(int gCode, String name, List<Friend> participants) {
		super();
		this.gCode = gCode;
		this.name = name;
		this.participants = participants;
	}
	
	public int getgCode() {
		return gCode;
	}
	
	public void setgCode(int gCode) {
		this.gCode = gCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Friend> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Friend> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "Group [name=" + name + ", participants=" + participants + "]";
	}
}
