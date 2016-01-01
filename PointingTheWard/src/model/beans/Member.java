package model.beans;

public class Member {
	private String name;
	private String email;
	private String pwd;
	private String location;
	private Transportation transportaion;
	public Member() {
	}
	public Member(String name, String email, String pwd, String location, Transportation transportaion) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.location = location;
		this.transportaion = transportaion;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Transportation getTransportaion() {
		return transportaion;
	}
	public void setTransportaion(Transportation transportaion) {
		this.transportaion = transportaion;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", email=" + email + ", location=" + location
				+ ", transportaion=" + transportaion + "]";
	}
}
