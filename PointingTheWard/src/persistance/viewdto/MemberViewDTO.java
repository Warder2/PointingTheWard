package persistance.viewdto;

public class MemberViewDTO {

	
	private String email;
	private String name;
	private String pwd;
	private String location;
	private String transportation;
	
	public MemberViewDTO(){
		
	}

	public MemberViewDTO(String email, String name, String pwd, String location, String transportation) {
		super();
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

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	@Override
	public String toString() {
		return "MemberViewDATO [email=" + email + ", name=" + name + ", pwd=" + pwd + ", location=" + location
				+ ", transportation=" + transportation + "]";
	}
	
}
