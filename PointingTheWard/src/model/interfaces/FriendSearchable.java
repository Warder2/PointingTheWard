package model.interfaces;

import java.util.List;

import model.beans.Friend;

public interface FriendSearchable {
	public Friend searchFriend(Friend friend);
	public Friend searchFriendEmail(String email);
	public List<Friend> searchFriendName(String name);
}
