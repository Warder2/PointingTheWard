package persistance.dto;

public class FriendInfoDTO {
	private String email;
	private String fEmail;
	private String fName;
	private String fLocation;
	private String fTransportation;
	
	public FriendInfoDTO(){
		
	}
	public FriendInfoDTO(String email, String fEmail, String fName, String fLocation, String fTransportation) {
		super();
		this.email = email;
		this.fEmail = fEmail;
		this.fName = fName;
		this.fLocation = fLocation;
		this.fTransportation = fTransportation;
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
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfLocation() {
		return fLocation;
	}
	public void setfLocation(String fLocation) {
		this.fLocation = fLocation;
	}
	public String getfTransportation() {
		return fTransportation;
	}
	public void setfTransportation(String fTransportation) {
		this.fTransportation = fTransportation;
	}
	@Override
	public String toString() {
		return "FriendInfoViewDTO [email=" + email + ", fEmail=" + fEmail + ", fName=" + fName + ", fLocation="
				+ fLocation + ", fTransportation=" + fTransportation + "]";
	}
	
	
}
