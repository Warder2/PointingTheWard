package model.beans;

import java.util.List;

public class Group {
	private String name;
	private List<Friend> participants;
	
	public Group() {
	}

	public Group(String name, List<Friend> participants) {
		super();
		this.name = name;
		this.participants = participants;
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
