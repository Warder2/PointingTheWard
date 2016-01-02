package persistance.dao.Interfaces;

import java.util.List;

public interface FriendDeleteDAO {
	/**
	 * 특정 회원의 친구들을 모두 삭제
	 * @param email 회원이메일
	 */
	public void deleteFriendAll(String email);
	/**
	 * 특정 친구를 삭제
	 * @param email 회원이메일
	 * @param friendEmail 삭제할 친구이메일
	 */
	public void deleteFriendEmail(String email,String friendEmail);
	/**
	 * 친구들을 삭제
	 * @param email 회원이메일
	 * @param friendEmail 삭제할 친구들의 이메일들
	 */
	public void deleteFriends(String email,List<String> friendEmails);
	/**
	 * 친구들을 삭제
	 * @param email 회원이메일
	 * @param friendEmail 삭제할 친구들의 이메일들
	 */
	public void deleteFriends(String email,String... friendEmails);
}
