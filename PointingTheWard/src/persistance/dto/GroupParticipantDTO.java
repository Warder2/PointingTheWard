package persistance.dto;

public class GroupParticipantDTO {
	private int code;
	private String email;

	public GroupParticipantDTO() {
	}

	public GroupParticipantDTO(int code, String email) {
		this.code = code;
		this.email = email;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "GroupParticipant [code=" + code + ", email=" + email + "]";
	}

}
