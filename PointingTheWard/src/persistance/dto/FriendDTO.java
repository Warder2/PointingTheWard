package persistance.dto;

public class FriendDTO {
	private String email;
	private String friendEmail;

	public FriendDTO() {
		this("userEmail", "friendEmail");
	}

	public FriendDTO(String email, String friendEmail) {
		super();
		this.email = email;
		this.friendEmail = friendEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFriendEmail() {
		return friendEmail;
	}

	public void setFriendEmail(String friendEmail) {
		this.friendEmail = friendEmail;
	}

	@Override
	public String toString() {
		return "FriendDTO [email=" + email + ", friendEmail=" + friendEmail + "]";
	}
}
