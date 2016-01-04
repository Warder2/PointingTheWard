package persistance.dto;

import java.io.Serializable;

public class MemberPDTO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -8140152748694940785L;
	private String email;
	private String pwd;
	private String name;

	public MemberPDTO() {

	}

	public MemberPDTO(String email, String pwd, String name) {
		super();
		this.email = email;
		this.pwd = pwd;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberPViewDTO [email=" + email + ", name=" + name + "]";
	}

}
