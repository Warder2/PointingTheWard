package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Friend;

public interface FriendSearchDAO {
	/**
	 * 회원의 모든 친구 조회
	 * @param email
	 * @return
	 */
	public List<Friend> searchFriendAll(String email);
	/**
	 * 이메일로 친구 조회
	 * @return
	 */
	public Friend searchFriendEmail(String email,String fEmail);
	/**
	 * 이름으로 친구 조회
	 */
	public List<Friend> searchFriendName(String email,String fName);
}
