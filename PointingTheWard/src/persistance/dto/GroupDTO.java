package persistance.dto;

public class GroupDTO {
	private int code;
	private String name;
	private String owner;

	public GroupDTO() {
	}

	public GroupDTO(int code, String name, String owner) {
		super();
		this.code = code;
		this.name = name;
		this.owner = owner;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "GroupDTO [code=" + code + ", name=" + name + ", owner=" + owner +"]";
	}

}
