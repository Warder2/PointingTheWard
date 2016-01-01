package persistance.dao.Interfaces;

import java.util.List;

public interface FriendDeleteDAO {
	/**
	 * 모든 친구 삭제
	 * @param email
	 */
	public void deleteFriendAll(String email);
	/**
	 * 이메일로 친구 삭제
	 * @param email
	 * @param femail
	 */
	public void deleteFriend(String email,String femail);
	/**
	 * 이름으로 친구들 삭제
	 * @param email
	 * @param femail
	 */
	public void deleteFriendName(String email,List<String> fName);
	/**
	 * 이름으로 친구들 삭제
	 * @param email
	 * @param fName
	 */
	public void deleteFriendName(String email,String... fName);
}
