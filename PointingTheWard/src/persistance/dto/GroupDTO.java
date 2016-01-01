package persistance.dto;

public class GroupDTO {
	private int code;
	private String name;

	public GroupDTO() {
		this(0, "group name");
	}

	public GroupDTO(int code, String name) {
		super();
		this.code = code;
		this.name = name;
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

	@Override
	public String toString() {
		return "GroupDTO [code=" + code + ", name=" + name + "]";
	}

}
