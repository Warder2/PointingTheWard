package persistance.dto;

public class GroupParticipantInfoDTO {
	private String email;
	private String name;
	private String location;
	private String transportation;
	private int groupCode;
	private String groupName;

	public GroupParticipantInfoDTO() {
		super();
	}

	public GroupParticipantInfoDTO(String email, String name, String location, String transportation, int groupCode,
			String groupName) {
		super();
		this.email = email;
		this.name = name;
		this.location = location;
		this.transportation = transportation;
		this.groupCode = groupCode;
		this.groupName = groupName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public int getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "GroupParticipantInfoViewDTO [email=" + email + ", name=" + name + ", location=" + location
				+ ", transportation=" + transportation + ", groupCode=" + groupCode + ", groupName=" + groupName + "]";
	}

}
