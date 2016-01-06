package service.interfaces;

import java.util.List;

import model.beans.Friend;

public interface FriendSearchable {
	public Friend searchFriend(String email, String fEmail);
	public List<Friend> searchFriends(String email);
	public List<Friend> searchFriendName(String email, String fName);
}
