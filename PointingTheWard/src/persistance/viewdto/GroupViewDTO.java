package persistance.viewdto;

public class GroupViewDTO {
	private int groupCode;
	private String name;
	public GroupViewDTO() {
		super();
	}
	public GroupViewDTO(int groupCode, String name) {
		super();
		this.groupCode = groupCode;
		this.name = name;
	}
	public int getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "GroupViewDTO [groupCode=" + groupCode + ", name=" + name + "]";
	}
}
