package model.beans;
/**
 * 친구정보를 가지는 클래스
 * @author SEONGBONG
 *
 */
public class Friend {
	/**
	 * 친구이름
	 */
	private String name;
	/**
	 * 친구 이메일
	 */
	private String email;
	public Friend() {
	}
	public Friend(String name, String email) {
		super();
		this.name = name;
		this.email = email;
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
	@Override
	public String toString() {
		return "Friend [name=" + name + ", email=" + email + "]";
	}
}
