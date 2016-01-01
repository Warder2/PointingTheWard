package persistance.dto;

public class MemberDTO {
	private String email;
	private String name;
	private String pwd;
	private String location;
	private String transportaion;

	public MemberDTO() {
		this("email", "name", "pwd", "location", "transportation");
	}

	public MemberDTO(String email, String name, String pwd, String location, String transportaion) {
		this.email = email;
		this.name = name;
		this.pwd = pwd;
		this.location = location;
		this.transportaion = transportaion;
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

	public String getTransportaion() {
		return transportaion;
	}

	public void setTransportaion(String transportaion) {
		this.transportaion = transportaion;
	}

	@Override
	public String toString() {
		return "MemberDTO [email=" + email + ", name=" + name + ", pwd=" + pwd + ", location=" + location
				+ ", transportaion=" + transportaion + "]";
	}
}
