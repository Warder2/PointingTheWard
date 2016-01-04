package persistance.dto;

public class GroupParticipantInfoDTO {
	private String email;
	private String name;
	private String location;
	private String transportation;
	private int gCode;
	private String gName;
	private String owner;

	public GroupParticipantInfoDTO() {
	}
	public GroupParticipantInfoDTO(String email, String name, String location, String transportation, int gCode,
			String gName, String owner) {
		this.email = email;
		this.name = name;
		this.location = location;
		this.transportation = transportation;
		this.gCode = gCode;
		this.gName = gName;
		this.owner = owner;
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

	public int getGCode() {
		return gCode;
	}
	public void setGCode(int gCode) {
		this.gCode = gCode;
	}
	public String getGName() {
		return gName;
	}
	public void setGName(String gName) {
		this.gName = gName;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "GroupParticipantInfoDTO [email=" + email + ", name=" + name + ", location=" + location
				+ ", transportation=" + transportation + ", gCode=" + gCode + ", gName=" + gName + ", owner=" + owner
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + gCode;
		result = prime * result + ((gName == null) ? 0 : gName.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
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
		GroupParticipantInfoDTO other = (GroupParticipantInfoDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gCode != other.gCode)
			return false;
		if (gName == null) {
			if (other.gName != null)
				return false;
		} else if (!gName.equals(other.gName))
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
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (transportation == null) {
			if (other.transportation != null)
				return false;
		} else if (!transportation.equals(other.transportation))
			return false;
		return true;
	}
}
