package model.beans;
/**
 * 이동수간 enum 클래스
 * @author SEONGBONG
 *
 */
public enum Transportation {
	TRANSIT("transit"), DRIVING("driving");
	private String str;
	private Transportation(String str){
		this.str = str;
	}
	public String getStr() {
		return str;
	}
	public static Transportation valueOfByStr(String str){
		Transportation transportation = null;
		switch(str.toLowerCase()){
		case "transit":
			transportation = TRANSIT;
			break;
		case "driving":
			transportation = DRIVING;
			break;
		default:
		}
		return transportation;
	}
}
