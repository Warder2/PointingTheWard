package model.beans;
/**
 * 회원정보를 가지는 클래스
 * @author SEONGBONG
 *
 */
public class Member {
	/**
	 * 회원이름
	 */
	private String name;
	/**
	 * 회원이메일
	 */
	private String email;
	/**
	 * 비밀번호
	 */
	private String pwd;
	/**
	 * 기본 주소
	 */
	private String location;
	/**
	 * 기본 이동 수단
	 */
	private Transportation transportation;
	public Member() {
	}
	public Member(String name, String email, String pwd, String location, Transportation transportation) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.location = location;
		this.transportation = transportation;
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
	public Transportation getTransportation() {
		return transportation;
	}
	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", email=" + email + ", location=" + location
				+ ", transportaion=" + transportation + "]";
	}
}
