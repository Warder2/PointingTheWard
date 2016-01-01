package persistance.viewdto;

public class GroupParticipantViewDTO {
	private int groupCode;
	private String email;
	public GroupParticipantViewDTO() {
		super();
	}
	public GroupParticipantViewDTO(int groupCode, String email) {
		super();
		this.groupCode = groupCode;
		this.email = email;
	}
	public int getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "GroupParticipantViewDTO [groupCode=" + groupCode + ", email=" + email + "]";
	}
	
}
