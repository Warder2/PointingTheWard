package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Friend;
import model.list.FriendList;

public interface FriendAdditionDAO {
	/**
	 * 친구추가
	 * @param email
	 * @param friend
	 */
	public void addtionFriend(String email,Friend friend);
	/**
	 * 친구들 추가
	 * @param email
	 * @param friends
	 */
	public void addtionFriend(String email,FriendList friends);
	/**
	 * 친구들 추가
	 * @param email
	 * @param friends
	 */
	public void addtionFriend(String email,List<Friend> friends);
}
