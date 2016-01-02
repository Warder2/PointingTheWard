package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Friend;
/**
 * 특정 회원을 친구로 등록하여 데이터베이스에 저장하는 INTERFACE
 * @author SEONGBONG
 *
 */
public interface FriendAdditionDAO {
	/**
	 * 한명의 친구 추가
	 * @param email 회원이메일
	 * @param friendEmail 친구로 등록할 이메일
	 */
	public void addtionFriend(String email,String friendEmail);
	
	/**
	 * 친구들 추가
	 * @param email 회원이메일
	 * @param friendEmails 친구로 등록할 이메일들
	 */
	public void addtionFriends(String email,String... friendEmails);
	
	/**
	 * 친구들 추가
	 * @param email 회원이메일
	 * @param friendEmails 친구로 등록할 이메일들
	 */
	public void addtionFriends(String email,List<String> friendEmails);
}
