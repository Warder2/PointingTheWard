package persistance.dto;

import model.beans.Transportation;

public class MemberDTO {
	private String email;
	private String name;
	private String pwd;
	private String location;
	private Transportation transportation;

	public MemberDTO() {
	}

	public MemberDTO(String email, String name, String pwd, String location, Transportation transportation) {
		this.email = email;
		this.name = name;
		this.pwd = pwd;
		this.location = location;
		this.transportation = transportation;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public String toString() {
		return "MemberDTO [email=" + email + ", name=" + name + ", pwd=" + pwd + ", location=" + location
				+ ", transportation=" + transportation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
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
		MemberDTO other = (MemberDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (transportation != other.transportation)
			return false;
		return true;
	}
}
