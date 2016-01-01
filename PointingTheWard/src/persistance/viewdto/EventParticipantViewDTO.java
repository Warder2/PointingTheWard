package persistance.viewdto;

public class EventParticipantViewDTO {
	private int code;
	private String email;
	public EventParticipantViewDTO() {
		super();
	}
	public EventParticipantViewDTO(int code, String email) {
		super();
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
		return "EventParticipantViewDTO [code=" + code + ", email=" + email + "]";
	}
}
