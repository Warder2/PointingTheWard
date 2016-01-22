package model.beans;

import java.util.List;
/**
 * 그룹정보를 가지는 클래스
 * @author SEONGBONG
 *
 */
public class Group {
	/**
	 * 그룹코드
	 */
	private int gCode;
	/**
	 * 그룹이름
	 */
	private String name;
	/**
	 * 참여자들
	 */
	private List<Friend> participants;
	
	public Group() {
	}

	public Group(int gCode, String name, List<Friend> participants) {
		super();
		this.gCode = gCode;
		this.name = name;
		this.participants = participants;
	}
	
	public int getgCode() {
		return gCode;
	}
	
	public void setgCode(int gCode) {
		this.gCode = gCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Friend> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Friend> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "Group [name=" + name + ", participants=" + participants + "]";
	}
}
