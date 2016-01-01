package persistance.viewdto;

public class FriendViewDTO {
	private String email;
	private String fEmail;
	
	public FriendViewDTO(){
		
	}

	public FriendViewDTO(String email, String fEmail) {
		super();
		this.email = email;
		this.fEmail = fEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfEmail() {
		return fEmail;
	}

	public void setfEmail(String fEmail) {
		this.fEmail = fEmail;
	}

	@Override
	public String toString() {
		return "FriendViewDTO [email=" + email + ", fEmail=" + fEmail + "]";
	}
	
}
